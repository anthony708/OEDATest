package utils;

import org.awaitility.Awaitility;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class OEDATestConfigHelper {

    private String mTestUrl;
    private String mFirefoxBrowserBinPath;
    private String mChromeBrowserBinPath;
    private RemoteWebDriver mWebDriver;
    private String mDownloadPath;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

    private static void log(String message, Object... args) {
        System.out.println(String.format("[%s]%s", formatter.format(new Date()), String.format(message, args)));
    }

    public OEDATestConfigHelper(String testUrl, String browserBinPath) {

//        mFirefoxBrowserBinPath = System.getProperty("webdriver.firefox.bin");
//        mChromeBrowserBinPath = System.getProperty("webdriver.chrome.bin");
        mDownloadPath = System.getProperty("downloadPath");
        mTestUrl = testUrl;
        mDownloadPath = "";
        log("testUrl = " + testUrl + ", browserBinPath = " + browserBinPath + ", download path = " + mDownloadPath);
        mFirefoxBrowserBinPath = browserBinPath;
//        mChromeBrowserBinPath = browserBinPath;
        //       System.getProperty("webdriver.gecko.driver");
 //       System.setProperty("webdriver.gecko.driver", "");

//        System.setProperty("webdriver.chrome.driver", "");
//        HashMap<String, Object> chromePrefs = new HashMap<>();
//        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.default_directory", mDownloadPath);
//        ChromeOptions options = new ChromeOptions();
//        HashMap<String,Object> chromeOptionsMap = new HashMap<>();
//        options.setExperimentalOption("prefs", chromePrefs);
//        options.addArguments("--test-type");
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setCapability("chrome.binary", "");
//        cap.setCapability(ChromeOptions.CAPABILITY,  chromeOptionsMap);
//        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        cap.setCapability(ChromeOptions.CAPABILITY, options);
//        mWebDriver = new ChromeDriver(cap);

        // Set Firefox download path
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(firefoxDriverProfile(mDownloadPath));
        options.setBinary(mFirefoxBrowserBinPath);
       // options.setLogLevel(FirefoxDriverLogLevel.DEBUG);
        mWebDriver = new FirefoxDriver(options);
        mWebDriver.manage().window().maximize();
        waitForPageToLoad(30);
        mWebDriver.get(testUrl);
    }

    public RemoteWebDriver getWebDriver() {
        return mWebDriver;
    }

    public FirefoxProfile firefoxDriverProfile(String downloadPath) {
        FirefoxProfile profile = new FirefoxProfile();

        profile.setPreference("dom.disable_beforeunload", true);
        profile.setPreference("browser.download.dir", downloadPath);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.helperApps.neverAsk.openFile",
                "application/xml,application/zip,octet/stream");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/xml,application/zip,octet/stream");
        profile.setPreference("browser.download.manager.showWhenStarting", false);

        return profile;
    }

    public void waitForPageToLoad(int timeoutInSeconds) {
        mWebDriver.manage().timeouts().implicitlyWait(timeoutInSeconds, TimeUnit.SECONDS);
        mWebDriver.manage().timeouts().pageLoadTimeout(timeoutInSeconds, TimeUnit.SECONDS);
    }

    public void waitForLoad() {
        Awaitility.await().atMost(25, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return mWebDriver.executeScript("return document.readyState").equals("complete");
            }
        });
    }

    public void waitTime(int timeoutInSeconds) {
//        Awaitility.await().atMost(timeoutInSeconds, TimeUnit.SECONDS);
        try {
            Thread.sleep(timeoutInSeconds * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isElementPresent(String pLocator) {
        return mWebDriver.findElementByXPath(pLocator) != null;
    }

    public void waitToClick(String pLocator) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            if (isElementPresent(pLocator)) {
                log("Element " + pLocator + "is present.");
                waitTime(2);
                mWebDriver.findElement(By.xpath(pLocator)).click();
                log("Clicked " + pLocator + " now");
                break;
            } else {
                log("Waiting for element " + pLocator + " to appear.");
                waitTime(2);
            }
        }
    }

    public WebElement findElement(String pLocator) {
        return mWebDriver.findElement(By.xpath(pLocator));
    }

    public WebElement findLastElement(String pLocator) {
        List<WebElement> list = mWebDriver.findElements(By.xpath(pLocator));
        WebElement lastElement = list.get(list.size() - 1);

        WebDriverWait wait = createWebDriverWaitInstance();
        wait.until(ExpectedConditions.visibilityOf(lastElement));
        log("Element is present.");
        return lastElement;
    }

    public void waitAndClickByXpath(String pLocator) {
        WebDriverWait wait = createWebDriverWaitInstance();

        log("Page Loaded...");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pLocator)));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pLocator)));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pLocator)));
        log("Element is present, clickable and visible.");

        mWebDriver.findElement(By.xpath(pLocator)).click();
        waitTime(1);
    }

    public void waitAndClickForDownloadByXpath(String pLocator, String fileName) {
        WebDriverWait wait = createWebDriverWaitInstance();

        log("Page Loaded...");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pLocator)));
        log("Element is present, clickable and visible.");

        mWebDriver.findElement(By.xpath(pLocator)).click();
        Awaitility.await().atMost(30, TimeUnit.SECONDS).until(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return new File(mDownloadPath + fileName).exists();
            }
        });
    }

    public void waitAndTypeByXpath(String pLocator, String values) {
        WebDriverWait wait = createWebDriverWaitInstance();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pLocator)));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pLocator)));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pLocator)));
        log("Element is visible");

        mWebDriver.findElement(By.xpath(pLocator)).clear();
        waitTime(1);
        mWebDriver.findElement(By.xpath(pLocator)).sendKeys(values);
        waitTime(1);
    }

    public void pageDown(String pLocator) {
        WebElement element = mWebDriver.findElement(By.xpath(pLocator));
        element.sendKeys(Keys.PAGE_DOWN);
    }

    public void scrollToElement(String pLocator) {
        log("Scroll to element...");
        WebElement element = mWebDriver.findElement(By.xpath(pLocator));
        JavascriptExecutor js = (JavascriptExecutor) mWebDriver;
        js.executeScript("return arguments[0].scrollIntoView(false);", element);
        waitTime(5);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) mWebDriver;
        js.executeScript("javascript:window.scroll(0,200)");
    }

    private WebDriverWait createWebDriverWaitInstance() {
        return new WebDriverWait(mWebDriver, 20);
    }

    public static OEDATestConfigHelper newInstance(final String testUrl, final String browserBinPath) {
        return new OEDATestConfigHelper(testUrl, browserBinPath);
    }

    public void quit() {
        mWebDriver.quit();
    }

}
