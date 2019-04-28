package testcases.Sanity;

import utils.OEDATestConfigHelper;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.SessionNotCreatedException;

import java.text.SimpleDateFormat;
import java.util.Date;

import static locators.Loc.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OEDASanityTest {

    private static OEDATestConfigHelper driverHelper;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

    private static void log(String message, Object... args) {
        if (message == null) {
            message = "null";
        }
        System.out.println(String.format("[%s]%s", formatter.format(new Date()), String.format(message, args)));
    }


    @BeforeClass
    public static void setUpBeforeClass() {

 //       String baseUrl = System.getProperty("TEST_URL");
//        String browserBin = System.getProperty("webdriver.firefox.bin");

          String baseUrl = "";
          log("TEST_URL = " + baseUrl);
          System.setProperty("webdriver.gecko.driver", "");
//
            String browserBin = "";

        driverHelper = OEDATestConfigHelper.newInstance(baseUrl, browserBin);
        log(System.getProperty("webdriver.firefox.profile"));
    }

    @Before
    public void beforeMethod() {
        log("This runs before every method");
        driverHelper.waitTime(5);
        log("This runs after wait 5 seconds");
    }

    @After
    public void afterMethod() {
        log("This runs after every method");
    }

    @Test
    public void test01SelectHardware() {
        driverHelper.waitAndClickByXpath(exadbmIcon);
        driverHelper.waitAndClickByXpath(computeNodeDropList);
        driverHelper.waitAndClickByXpath(computeNodeX7_2);
        driverHelper.waitAndClickByXpath(rackSizeDropList);
        driverHelper.waitAndClickByXpath(rackSizeQuarter);
        driverHelper.waitAndClickByXpath(addRackBtn);

        driverHelper.waitForLoad();

        driverHelper.waitAndTypeByXpath(rackPrefixInput, "dbm0");
        driverHelper.waitAndTypeByXpath(customerNameInput, "sanity");
        driverHelper.waitAndTypeByXpath(appSerialNumInput, "sanity");

        driverHelper.scrollToElement(hardwareApplyBtn);
        driverHelper.waitAndClickByXpath(hardwareApplyBtn);
        driverHelper.waitAndClickByXpath(confirmedBtn);
    }

    @Test
    public void test02ChooseOperatingSystem() {
        driverHelper.waitAndClickByXpath(osCLinuxOVM);
        driverHelper.waitAndClickByXpath(osCLinuxPhysical);
        driverHelper.waitAndClickByXpath(osSaveBtn);
    }

    @Test
    public void test03ConfigRackNetworks() {
        driverHelper.waitAndTypeByXpath(cnGatewayInput, "10.31.16.1");
        driverHelper.waitAndClickByXpath(anStartIPAddress);
        driverHelper.waitAndTypeByXpath(anDomainNameInput, "");
        driverHelper.waitAndClickByXpath(adminNetworkApplyBtn);

        boolean isAdminNetworkCollapse = driverHelper.findElement(adminNetworkCollapse).isSelected();
        log("isAdminNetworkCollapse = " + isAdminNetworkCollapse);
        if (!isAdminNetworkCollapse) {
            driverHelper.waitAndClickByXpath(adminNetworkCollapse);
        }

        driverHelper.waitTime(10);
        driverHelper.scrollToElement(privateNetworkApplyBtn);
        driverHelper.waitAndClickByXpath(privateNetworkApplyBtn);
    }

    @Test
    public void test04SetupUsersandGroups() {
        driverHelper.waitAndClickByXpath(roleSeperatedRadioBtn);
        driverHelper.waitAndClickByXpath(userGroupSaveBtn);
    }

    @Test
    public void test05DefineClusters() {
        driverHelper.scrollToElement(addAllNodesbtn);
        driverHelper.waitAndClickByXpath(addAllNodesbtn);

        driverHelper.waitTime(10);
        driverHelper.scrollToElement(submitClusterBtn);
        driverHelper.waitAndClickByXpath(submitClusterBtn);
    }

    @Test
    public void test06DefineDiskgroups() {
        driverHelper.scrollToElement(saveDiskgroupBtn);
        driverHelper.waitAndClickByXpath(saveDiskgroupBtn);
    }

    @Test
    public void test07CreateDBHome() {
        driverHelper.scrollToElement(submitDBHomeBtn);
        driverHelper.waitAndClickByXpath(submitDBHomeBtn);
    }

    @Test
    public void test08CreateDB() {
        driverHelper.scrollToElement(submitDBBtn);
        driverHelper.waitAndClickByXpath(submitDBBtn);
    }

    @Test
    public void test09ConfigClientNetwork() {
        driverHelper.waitTime(5);
        driverHelper.scrollToElement(cnGatewayInput);
        driverHelper.findLastElement(cnGatewayInput).clear();
        driverHelper.findLastElement(cnGatewayInput).sendKeys("10.31.218.193");

        driverHelper.findLastElement(cnSubnetMaskDropList).click();
        driverHelper.findLastElement(cnSubnetMaskDropList).click();
        driverHelper.waitTime(5);
        driverHelper.waitAndClickByXpath(saveClusterNetworkBtn);
    }

    @Test
    public void test10Alert() {
        driverHelper.scrollToElement(submitAlertBtn);
        driverHelper.waitAndClickByXpath(submitAlertBtn);
    }

    @Test
    public void test11SaveComments() {
        driverHelper.scrollToElement(saveCommentsBtn);
        // wait for download
        driverHelper.waitAndClickForDownloadByXpath(saveCommentsBtn, "sanity-dbm0-Es.zip");

    }

    @AfterClass
    public static void cleanUpAfterClass() {
        driverHelper.quit();
    }
}
