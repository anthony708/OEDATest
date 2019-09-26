import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.util.Map;

import static locators.Loc.*;
import static oracle.onecommand.tests.webUi.seleniumTests.OEDAJsonInputTestHelper.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OEDAJsonInputTest {
    private static WebDriver driver;
    static final String jsonfile = "*.json";

    @BeforeClass
    public static void setUp() throws IOException {

        String url = "http://*:8080";
        String browserBinary = "*/MacOS/firefox";
        String geckodriver = "*/libs/geckodriver";
        System.setProperty("webdriver.gecko.driver", geckodriver);

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(browserBinary);

        driver = new FirefoxDriver(options);
//        driver.manage().window().maximize();
        driver.get(url);
    }

    @Before
    public void beforeMethod() throws Exception {
        System.out.println("This runs before every method.");
        Thread.sleep(4000);
    }

    @Test
    public void test01*() throws Exception {
        System.out.println("Running test " + getMethodName());
        Thread.sleep(15000);
        String computeNode = parseJson(jsonfile).getHardware().getRacks().get(0).getComputeNodeFamily();
        String rackSize = parseJson(jsonfile).getHardware().getRacks().get(0).getRackSize();
        String diskSize = parseJson(jsonfile).getHardware().getRacks().get(0).getDiskSize();
        driver.findElement(By.xpath(computeNodeDropList)).click();
        driver.findElements(By.xpath(searchField)).get(xpathHelper(searchField)).sendKeys(computeNode);
        driver.findElement(By.xpath(getComputeNodeFamilyXpath(computeNode))).click();
        driver.findElement(By.xpath(rackSizeDropList)).click();
        driver.findElement(By.xpath(getRackSizeXpath(rackSize))).click();
        driver.findElement(By.xpath(diskSizeDropList)).click();
        driver.findElement(By.xpath(getDiskSizeXpath(diskSize))).click();

        driver.findElement(By.xpath(addRackBtn)).click();
        Thread.sleep(3000);

        String rackPrefix = parseJson(jsonfile).getHardware().getRacks().get(0).getRackPrefix();
        clearAndSendkeys(rackPrefixInput, rackPrefix);
        Thread.sleep(100);

        boolean spineSwitchEnabled = parseJson(jsonfile).getHardware().getRacks().get(0).isSpineSwitchEnabled();
        if (spineSwitchEnabled) {
            driver.findElement(By.xpath(spineSwitchCheckbox)).click();
            Thread.sleep(100);
        }

        String customerName = parseJson(jsonfile).getHardware().getRacks().get(0).getCustomerName();
        if (customerName != null) {
            clearAndSendkeys(customerNameInput, customerName);
        }

        String applicationName = parseJson(jsonfile).getHardware().getRacks().get(0).getApplicationName();
        if (applicationName != null) {
            clearAndSendkeys(appSerialNumInput, applicationName);
        }

        // add Region and Timezone
        String regionAndTimezone = parseJson(jsonfile).getClusters().get(0).getMachines().getMachine().get(0).getTimeZone();
        String region = regionAndTimezone.split("/")[0];
        String timezone = regionAndTimezone.split("/")[1];

        if (!driver.findElement(By.xpath(regionDropList)).getText().equals(region)) {
            driver.findElement(By.xpath(regionDropList)).click();
            driver.findElement(By.xpath("//div[@aria-label='" + region + "']")).click();
        }

        if (!driver.findElement(By.xpath(timezoneDropList)).getText().equals(timezone)) {
            driver.findElement(By.xpath(timezoneDropList)).click();
            clearAndSendkeys(timezoneSearchField, timezone);
            driver.findElement(By.xpath("//div[@aria-label='" + timezone + "']")).click();
        }

        try {
            int computeNodeCount = parseJson(jsonfile).getHardware().getRacks().get(0).getComputeNodeCount();
            if (computeNodeCount != 0 && driver.findElement(By.xpath(computeNodeCountInput)).isEnabled()) {
                clearAndSendkeys(computeNodeCountInput, Integer.toString(computeNodeCount));
            }
        } catch (Exception e) {
            System.out.println("computeNodeCountInput not existed");
        }

        try {
            int celleNodeCount = parseJson(jsonfile).getHardware().getRacks().get(0).getCelleNodeCount();
            if (celleNodeCount != 0 && driver.findElement(By.xpath(storageNodeCountInput)).isEnabled()) {
                clearAndSendkeys(storageNodeCountInput, Integer.toString(celleNodeCount));
            }
        } catch (Exception e) {
            System.out.println("storageNodeCountInput not existed");
        }

        String dns1 = parseJson(jsonfile).getClusters().get(0).getDns1();
        String dns2 = parseJson(jsonfile).getClusters().get(0).getDns2();
        String dns3 = parseJson(jsonfile).getClusters().get(0).getDns3();
        String ntp1 = parseJson(jsonfile).getClusters().get(0).getNtp1();
        String ntp2 = parseJson(jsonfile).getClusters().get(0).getNtp2();
        String ntp3 = parseJson(jsonfile).getClusters().get(0).getNtp3();
        if (dns1 != null) {
            clearAndSendkeys(dnsServers1Input, dns1);
        }
        if (dns2 != null) {
            clearAndSendkeys(dnsServers2Input, dns2);
        }
        if (dns3 != null) {
            clearAndSendkeys(dnsServers3Input, dns3);
        }
        if (ntp1 != null) {
            clearAndSendkeys(ntpServers1Input, ntp1);
        }
        if (ntp2 != null) {
            clearAndSendkeys(ntpServers2Input, ntp2);
        }
        if (ntp3 != null) {
            clearAndSendkeys(ntpServers3Input, ntp3);
        }
        Thread.sleep(100);

        // add WriteBack Flash Cache
        try {
            String writeBackFC = parseJson(jsonfile).getClusters().get(0).getMachines().getMachine().get(2).getWriteBackFlashCache();
            if (writeBackFC.equals("true")) {
                driver.findElement(By.xpath(enableWBFCIcon)).click();
            }
        } catch (Exception e) {
            System.out.println("Error: writeback flash cache");
        }

        driver.findElement(By.xpath(hardwareApplyBtn)).click();
        Thread.sleep(100);
        driver.findElement(By.xpath(confirmedBtn)).click();

    }

    @Test
    public void test02*() throws Exception {
        System.out.println("Running test " + getMethodName());
        String osType = parseJson(jsonfile).getOs().getOsType();
        String osChoices = driver.findElement(By.xpath(osChoiceDropList)).getText();
        if (!osChoices.equals(osType)) {
            driver.findElement(By.xpath(osChoiceDropList)).click();
            driver.findElement(By.xpath(getOsTypeXpath(jsonfile))).click();
        }
        driver.findElement(By.xpath(osSaveBtn)).click();
    }

    @Test
    public void test03*() throws Exception {
        System.out.println("Running test " + getMethodName());
        try {
            String defaultGateway = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getComputeAdminNetwork().getDefaultGateway();
            String defaultHostname = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getComputeAdminNetwork().getDefaultHostname();
            if (defaultGateway.equals("true") && driver.findElement(By.xpath(adminNetworkDefaultGatewayCheckBox)).isDisplayed()) {
                driver.findElement(By.xpath(adminNetworkDefaultGatewayCheckBox)).click();
            }
            if (defaultHostname.equals("true") && driver.findElement(By.xpath(adminNetworkDefaultHostnameCheckBox)).isDisplayed()) {
                driver.findElement(By.xpath(adminNetworkDefaultHostnameCheckBox)).click();
            }
        } catch (Exception e) {
            System.out.println("Errors in setting default gateway and default hostname");
        }

        String gateway = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getComputeAdminNetwork().getGateway();
        String domain = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getComputeAdminNetwork().getDomain();
        String startIp = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getComputeAdminNetwork().getStartIp();

        clearAndSendkeys(anGateWayInput, gateway);
        clearAndSendkeys(anStartIPAddress, startIp);

        // add Subnet Mask
        String subnetMask = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getComputeAdminNetwork().getSubnetMask();

        driver.findElement(By.xpath(anSubnetMaskDropList)).click();
        driver.findElement(By.xpath(anSubnetMaskSearchField)).sendKeys(subnetMask);
        driver.findElement(By.xpath("//div[@aria-label='" + subnetMask + "']")).click();
        Thread.sleep(100);

        clearAndSendkeys(anDomainNameInput, domain);

        System.out.println("********************** Modify Admin Network Masks **************************");

        driver.findElement(By.xpath(modifyMasksBtn)).click();
        String computeNameMask = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getComputeAdminNetwork().getNameMask();
        String computeNameStartId = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getComputeAdminNetwork().getStartId();
        clearAndSendkeys(computeNameMaskInput, computeNameMask);
        clearAndSendkeys(computeNameStartIDInput, computeNameStartId);

        String storageNameMask = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getCellAdminNetwork().getNameMask();
        String storageNameStartId = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getCellAdminNetwork().getStartId();
        clearAndSendkeys(storageNameMaskInput, storageNameMask);
        clearAndSendkeys(storageNameStartIDInput, storageNameStartId);

        String computeILOMMask = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getComputeIlomadminNetwork().getNameMask();
        String ilomNameStartId = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getComputeIlomadminNetwork().getStartId();
        clearAndSendkeys(computeILOMMaskInput, computeILOMMask);
        clearAndSendkeys(ilomNameStartIDInput, ilomNameStartId);

        String storageILOMNameMask = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getCellIlomadminNetwork().getNameMask();
        String storageILOMStartId = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getCellIlomadminNetwork().getStartId();
        clearAndSendkeys(storageILOMNameMaskInput, storageILOMNameMask);
        clearAndSendkeys(storageILOMStartIDInput, storageILOMStartId);

        try {
            String ciscoSwitch = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getSwitchNetworkPool().getCiscoswitchMask();
            String infiniBandLeaf1 = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getSwitchNetworkPool().getInfinibandLeaf1();
            String pduA = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getSwitchNetworkPool().getPduaMask();
            String infiniBandSpine = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getSwitchNetworkPool().getInfinibandSpine();
            String infinibandLeaf2 = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getSwitchNetworkPool().getInfinibandLeaf2();
            String pduB = parseJson(jsonfile).getRackNetworks().getRackAdminNetworkList().get(0).getSwitchNetworkPool().getPdubMask();
            clearAndSendkeys(ciscoSwitchInput, ciscoSwitch);
            clearAndSendkeys(infiniBandLeaf1Input, infiniBandLeaf1);
            clearAndSendkeys(pduAInput, pduA);
            clearAndSendkeys(infiniBandSpineInput, infiniBandSpine);
            clearAndSendkeys(infinibandLeaf2Input, infinibandLeaf2);
            clearAndSendkeys(pduBInput, pduB);
            Thread.sleep(500);
        } catch (Exception e) {

        }
        scrollToXpath(networkMasksApplyBtn);
        driver.findElement(By.xpath(networkMasksApplyBtn)).click();
        Thread.sleep(1000);

        scrollToXpath(adminNetworkApplyBtn);
        driver.findElement(By.xpath(adminNetworkApplyBtn)).click();
        Thread.sleep(3000);

        //Admin network review and edit
        System.out.println("************************* Admin network review and edit ***********************");
        scrollToXpath(adminNetworkReviewAndEditCollapse);
        if (!driver.findElement(By.xpath(adminNetworkReviewAndEditCollapse)).isSelected()) {
            driver.findElement(By.xpath(adminNetworkReviewAndEditCollapse)).click();
            Thread.sleep(2000);
        }

        if (driver.findElement(By.xpath(lookupAdminNetworkIPBtn)).isEnabled()) {
            scrollToXpath(lookupAdminNetworkIPBtn);
            driver.findElement(By.xpath(lookupAdminNetworkIPBtn)).click();
        }
        while (!driver.findElement(By.xpath(lookupAdminNetworkIPBtn)).isEnabled()) {
            Thread.sleep(2000);
        }
        driver.findElement(By.xpath(adminReviewAndEditUpdateBtn)).click();

        String isActiveBonded = parseJson(jsonfile).getRackNetworks().getRackPrivateNetworkList().get(0).getComputePrivateNetwork().getIsActiveBonded();
        try {
            scrollToXpath(enableActiveBondingCheckBox);
            if (isActiveBonded.equals("true") && !driver.findElement(By.xpath(enableActiveBondingCheckBox)).isSelected()) {
                driver.findElement(By.xpath(enableActiveBondingCheckBox)).click();
            }
        } catch (Exception e) {
            System.out.println("Errors: enable active bonding");
        }
        // add private network start IP Address
        String privateNetworkStartIPAddress = parseJson(jsonfile).getRackNetworks().getRackPrivateNetworkList().get(0).getComputePrivateNetwork().getStartIp();
        clearAndSendkeys(pnStartIPAddress, privateNetworkStartIPAddress);

        String privateNetworkSubnetMask = parseJson(jsonfile).getRackNetworks().getRackPrivateNetworkList().get(0).getComputePrivateNetwork().getSubnetMask();
        String pnSubnetMask = driver.findElement(By.xpath(pnSubnetMaskDropList)).getText();
        if (!pnSubnetMask.equals(privateNetworkSubnetMask)) {
            driver.findElement(By.xpath(pnSubnetMaskDropList)).click();
            String pnSubnetMaskXpath = "//div[@aria-label=\"" + privateNetworkSubnetMask + "\"]";
            if (!driver.findElement(By.xpath(pnSubnetMaskXpath)).isDisplayed()) {
                scrollToXpath(pnSubnetMaskXpath);
            }
            driver.findElement(By.xpath(pnSubnetMaskXpath)).click();
        }

        System.out.println("************************** Modify Private Network Masks ************************");

        driver.findElements(By.xpath(modifyMasksBtn)).get(1).click();
        String computePrivateMasks = parseJson(jsonfile).getRackNetworks().getRackPrivateNetworkList().get(0).getComputePrivateNetwork().getNameMask();
        String computePrivateStartId = parseJson(jsonfile).getRackNetworks().getRackPrivateNetworkList().get(0).getComputePrivateNetwork().getStartId();
        clearAndSendkeys(computePrivateNetworkMasksInput, computePrivateMasks);
        clearAndSendkeys(computePrivateNameStartIDInput, computePrivateStartId);

        String cellPrivateMasks = parseJson(jsonfile).getRackNetworks().getRackPrivateNetworkList().get(0).getCellPrivateNetwork().getNameMask();
        String cellPrivateStartId = parseJson(jsonfile).getRackNetworks().getRackPrivateNetworkList().get(0).getCellPrivateNetwork().getStartId();
        clearAndSendkeys(cellPrivateNameMaskInput, cellPrivateMasks);
        clearAndSendkeys(cellPrivateNameStartIDInput, cellPrivateStartId);

        scrollToElement(driver.findElements(By.xpath(networkMasksApplyBtn)).get(0));
        Thread.sleep(3000);
        driver.findElements(By.xpath(networkMasksApplyBtn)).get(0).click();
        Thread.sleep(1000);

        scrollToXpath(privateNetworkApplyBtn);
        driver.findElement(By.xpath(privateNetworkApplyBtn)).click();

    }

    @Test
    public void test04*() throws Exception {
        System.out.println("Running test " + getMethodName());
        Thread.sleep(1000);
        int userNumber = parseJson(jsonfile).getUserGroups().size();
        for (int i = 1; i < userNumber; i++) {
            driver.findElement(By.xpath(addUsersBtn)).click();
            Thread.sleep(100);
        }

        for (int i = 0; i < userNumber; i++) {
            String userGroupCollectionType = parseJson(jsonfile).getUserGroups().get(i).getUserGroupCollectionType();
            scrollToXpath(userGroupRadioBtnXpath(i, userGroupCollectionType));
            driver.findElement(By.xpath(userGroupRadioBtnXpath(i, userGroupCollectionType))).click();
            Thread.sleep(100);
        }

        scrollToXpath(userGroupSaveBtn);
        driver.findElement(By.xpath(userGroupSaveBtn)).click();
    }

    @Test
    public void test05*() throws Exception {
        System.out.println("Running test " + getMethodName());
        Thread.sleep(3000);

        int clusterNumber = parseJson(jsonfile).getClusters().size();
        for (int i = 1; i < clusterNumber; i++) {
            driver.findElement(By.xpath(addClusterBtn)).click();
            Thread.sleep(100);
        }

        for (int i = 0; i < clusterNumber; i++) {
            String clusterName = parseJson(jsonfile).getClusters().get(i).getClusterName();
            driver.findElement(By.xpath(defineClusterTabXpath(clusterName))).click();
            String gridHomeLoc = parseJson(jsonfile).getClusters().get(i).getClusterHome();
            int j = xpathHelper(gridInfrastructureHomeLocationInput);
            clearAndSendKeys(gridInfrastructureHomeLocationInput, gridHomeLoc, j);

            try {
                String gridVersion = parseJson(jsonfile).getClusters().get(i).getClusterVersion();
                String gridVersionInput = gridVersion.substring(0, 8) + " RU" + gridVersion.substring(9,15);
                driver.findElements(By.xpath(gridSoftwareVersionDropList)).get(xpathHelper(gridSoftwareVersionDropList)).click();
                Thread.sleep(100);
                scrollToXpath("//div[contains(text(),'" + gridVersionInput + "')]");
                driver.findElement(By.xpath("//div[contains(text(),'" + gridVersionInput + "')]")).click();
            } catch (Exception e) {
                System.out.println("Grid version is not correct");
            }
            scrollToElement(driver.findElements(By.xpath(addAllNodesbtn)).get(j));
            driver.findElements(By.xpath(addAllNodesbtn)).get(j).click();

            String regionAndTimezone = parseJson(jsonfile).getClusters().get(i).getMachines().getMachine().get(0).getTimeZone();
            String region = regionAndTimezone.split("/")[0];
            String timezone = regionAndTimezone.split("/")[1];
            try {
                if (!driver.findElements(By.xpath(clustersRegionDropList)).get(i).getText().equals(region)) {
                    driver.findElements(By.xpath(clustersRegionDropList)).get(i).click();
                    driver.findElement(By.xpath("//div[@aria-label='" + region + "']")).click();
                }

                if (!driver.findElements(By.xpath(clustersTimezoneDropList)).get(i).getText().equals(timezone)) {
                    driver.findElements(By.xpath(clustersTimezoneDropList)).get(i).click();
                    scrollToXpath("//div[@aria-label='" + timezone + "']");
                    driver.findElement(By.xpath("//div[@aria-label='" + timezone + "']")).click();
                }
            } catch (Exception e) {
                System.out.println("Errors: region and timezone");
            }

            try {
                if (driver.findElements(By.xpath(guestCoresInput)).get(j).isDisplayed()) {
                    int guestCores = Integer.parseInt(parseJson(jsonfile).getClusters().get(i).getGuestCores());
                    guestCores /= 2;
                    if (guestCores <= 48 && guestCores >= 1) {
                        clearAndSendKeys(guestCoresInput, String.valueOf(guestCores), j);
                    }
                }
                if (driver.findElements(By.xpath(guestMemoryInput)).get(j).isDisplayed()) {
                    String guestMemory = parseJson(jsonfile).getClusters().get(i).getGuestMemory();
                    String guestMemoryValue = guestMemory.substring(0, guestMemory.length() - 2);
                    clearAndSendKeys(guestMemoryInput, guestMemoryValue, j);
                }
            } catch (Exception e) {
                System.out.println("guestCores or guestMemory got error");
            }
        }

        scrollToXpath(submitClusterBtn);
        driver.findElement(By.xpath(submitClusterBtn)).click();
    }

    @Test
    public void test06*() throws Exception {
        System.out.println("Running test " + getMethodName());
        Thread.sleep(5000);

        int clusterNumber = parseJson(jsonfile).getClusters().size();
        int diskgroupSize = getDiskgroupSize(jsonfile);
        for (int i = 0; i < clusterNumber; i++) {

            // diskgroup size count:
            // size == 2, no changes
            // size == 3, advanced = true, sparseDG = true
            // size == 4, diskgroupLayout = custom, add a new diskgroup

            String clusterName = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getClusterName();
            driver.findElement(By.xpath(diskgroupsTabXpath(clusterName))).click();
            String enableASMScopedSecurityCheckbox = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getAsmScopedSecurity();

            int j = xpathHelper(advancedCheckBox);
            if (diskgroupSize == 3 || enableASMScopedSecurityCheckbox.equals("true")) {
                driver.findElements(By.xpath(advancedCheckBox)).get(j).click();
                if (enableASMScopedSecurityCheckbox.equals("true")) {
                    driver.findElements(By.xpath(enableASMSSCheckBox)).get(j).click();
                }
            }
            try {
                String acfsVolumeName = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(0).getAcfsVolumeName();
                if (acfsVolumeName != null) {
                    driver.findElements(By.xpath(configureAcfsBtn)).get(j).click();
                    driver.findElements(By.xpath(enableACFSForDGCheckBox)).get(xpathHelper(enableACFSForDGCheckBox)).click();
                    driver.findElements(By.xpath(acfsConfigureSaveBtn)).get(xpathHelper(acfsConfigureSaveBtn)).click();
                }
            } catch (Exception e) {
                System.out.println("Errors in setting acfs");
            }
            if (diskgroupSize == 3) {
                if (!driver.findElements(By.xpath(enableSparseDiskgroupCheckBox)).get(j).isSelected()) {
                    driver.findElements(By.xpath(enableSparseDiskgroupCheckBox)).get(j).click();
                }

                String sparseDiskgroupName = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(1).getDiskGroupName();
                clearAndSendKeys(diskgroup3Name, sparseDiskgroupName, j);
                String dataRedundancy = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(0).getRedundancy();
                String recoRedundancy = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(2).getRedundancy();
                String sparseRedundancy = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(1).getRedundancy();
                if (!dataRedundancy.equals(driver.findElements(By.xpath(redundancyDropList1)).get(j).getText())) {
                    driver.findElements(By.xpath(redundancyDropList1)).get(j).click();
                    driver.findElement(By.xpath("//div[@aria-label=\"" + dataRedundancy.toUpperCase() + "\"]")).click();
                    Thread.sleep(100);
                }
                if (!recoRedundancy.equals(driver.findElements(By.xpath(redundancyDropList2)).get(j).getText())) {
                    driver.findElements(By.xpath(redundancyDropList2)).get(j).click();
                    driver.findElement(By.xpath("//div[@aria-label=\"" + recoRedundancy.toUpperCase() + "\"]")).click();
                    Thread.sleep(100);
                }
                if (!sparseRedundancy.equals(driver.findElements(By.xpath(redundancyDropList3)).get(j).getText())) {
                    driver.findElements(By.xpath(redundancyDropList3)).get(j).click();
                    driver.findElement(By.xpath("//div[@aria-label=\"" + sparseRedundancy.toUpperCase() + "\"]")).click();
                    Thread.sleep(100);
                }

                String dataSize = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(0).getUiSize();
                String recoSize = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(2).getUiSize();
                String sparseSize = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(1).getUiSize();
                clearAndSendKeys(dg1SizeInput, dataSize, j);
                clearAndSendKeys(dg2SizeInput, recoSize, j);
                clearAndSendKeys(dg3SizeInput, sparseSize, j);

            } else if (diskgroupSize == 4) {

                int diskgroupNum3 = -1;
                int diskgroupNum4 = -1;
                Map<Integer, String> diskgroupNameMap = diskgroupNameMap(jsonfile);
                for (Map.Entry<Integer, String> entry : diskgroupNameMap.entrySet()) {
                    if (entry.getValue().equals("CUSTOM3")) {
                        diskgroupNum3 = entry.getKey();
                    }
                    if (entry.getValue().equals("CUSTOM4")) {
                        diskgroupNum4 = entry.getKey();
                    }
                }

                // set diskgroupLayout = Custom
                j = xpathHelper(diskgroupLayoutDropBox);
                driver.findElements(By.xpath(diskgroupLayoutDropBox)).get(j).click();
                driver.findElements(By.xpath(diskgroupLayoutCustom)).get(j).click();
                // add 2 new diskgroups
                driver.findElements(By.xpath(addNewDiskgroupBtn)).get(j).click();
                driver.findElements(By.xpath(addNewDiskgroupBtn)).get(j).click();
                String newDiskgroup3Name = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(diskgroupNum3).getDiskGroupName();
                String newDiskgroup4Name = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(diskgroupNum4).getDiskGroupName();

                driver.findElements(By.xpath(dg3SizeTypeDropbox)).get(j).click();
                Thread.sleep(1000);
                driver.findElements(By.xpath(usableSizeType)).get(j).click();
                clearAndSendKeys(diskgroup3Name, newDiskgroup3Name, j);
                driver.findElements(By.xpath(dg3TypeDropbox)).get(j).click();
                driver.findElements(By.xpath(dgTypeOther)).get(j).click();
                String dg3UiSize = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(diskgroupNum3).getUiSize();
                clearAndSendKeys(dg3SizeInput, dg3UiSize, j);

                driver.findElements(By.xpath(dg4SizeTypeDropbox)).get(j).click();
                driver.findElements(By.xpath(usableSizeType)).get(j).click();
                Thread.sleep(1000);
                clearAndSendKeys(diskgroup4Name, newDiskgroup4Name, j);
                driver.findElements(By.xpath(dg4TypeDropbox)).get(j).click();
                driver.findElements(By.xpath(dgTypeOther)).get(j).click();
                String dg4UiSize = parseJson(jsonfile).getDiskgroups().getClusters().getCluster().get(i).getDiskGroups().getDiskGroup().get(diskgroupNum4).getUiSize();
                clearAndSendKeys(dg4SizeInput, dg4UiSize, j);

            }
        }
        scrollToXpath(saveDiskgroupBtn);
        driver.findElement(By.xpath(saveDiskgroupBtn)).click();
    }

    @Test
    public void test07*() throws Exception {
        System.out.println("Running test " + getMethodName());

        int dbHomeSize = parseJson(jsonfile).getDatabaseHomeDataObjects().getDatabaseHomeDataObject().size();
        for (int i = 1; i < dbHomeSize; i++) {
            driver.findElement(By.xpath(addDBHomeBtn)).click();
        }

        for (int i = 0; i < dbHomeSize; i++) {
            String dbHomeName = parseJson(jsonfile).getDatabaseHomeDataObjects().getDatabaseHomeDataObject().get(i).getDatabaseHomeName();
//            String dbHomeType = parseJson(jsonfile).getDatabaseHomeDataObjects().getDatabaseHomeDataObject().get(i).getInstallType();
            driver.findElement(By.xpath(dbHomeTabXpath(dbHomeName))).click();
            Thread.sleep(100);
            int j = xpathHelper(selectClusterDropList);

            driver.findElements(By.xpath(selectClusterDropList)).get(j).click();
            driver.findElement(By.xpath("//div[@aria-label=\"Cluster-c" + (i + 1) + "\"]")).click();

            try {
                String dbHomeVersion = parseJson(jsonfile).getDatabaseHomeDataObjects().getDatabaseHomeDataObject().get(j).getDatabaseVersion();
                driver.findElements(By.xpath(dbHomeVersionDropList)).get(j).click();
                String dbVersionInput = dbHomeVersion.substring(0, 8) + " RU" + dbHomeVersion.substring(9,15);
                driver.findElement(By.xpath("//div[@aria-label=\"" + dbVersionInput + "\"]")).click();
            } catch (Exception e) {
                System.out.println("Database home version is not correct");
            }
        }
        scrollToXpath(submitDBHomeBtn);
        driver.findElement(By.xpath(submitDBHomeBtn)).click();
    }

    @Test
    public void test08*() throws Exception {
        System.out.println("Running test " + getMethodName());

        int databaseNumber = parseJson(jsonfile).getDatabaseDataObjects().getDatabaseDataObject().size();
        for (int i = 1; i < databaseNumber; i++) {
            driver.findElement(By.xpath(addDatabaseBtn)).click();
            Thread.sleep(100);
        }
        for (int i = 0; i < databaseNumber; i++) {
            String databaseName = parseJson(jsonfile).getDatabaseDataObjects().getDatabaseDataObject().get(i).getDatabaseSid();
            driver.findElement(By.xpath(databaseTabXpath(databaseName))).click();
            driver.findElements(By.xpath(databaseHomeDropList)).get(xpathHelper(databaseHomeDropList)).click();
            driver.findElement(By.xpath("//div[@aria-label=\"DbHome_" + (i + 1) + "\"]")).click();

            // add enable CDB
            try {
                String pdbName = parseJson(jsonfile).getDatabaseDataObjects().getDatabaseDataObject().get(i).getPdbNames().getPdbName().get(0);
                if (pdbName != null && !driver.findElements(By.xpath(enableCDBCheckbox)).get(xpathHelper(enableCDBCheckbox)).isSelected()) {
                    driver.findElements(By.xpath(enableCDBCheckbox)).get(xpathHelper(enableCDBCheckbox)).click();
                    clearAndSendKeys(pdbNameInput, pdbName, xpathHelper(pdbNameInput));
                }
            } catch (Exception e) {
                System.out.println("Do not support pdb here");
            }
        }

        scrollToXpath(submitDBBtn);
        driver.findElement(By.xpath(submitDBBtn)).click();
    }

    @Test
    public void test09*() throws Exception {
        System.out.println("Running test " + getMethodName());
        Thread.sleep(5000);

        int clusterNumber = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().size();

        String adminNetworkGateway = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(0).getAdminNetwork().getGateway();
        for (int i = 0; i < clusterNumber; i++) {

            try {
                String vlanID = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getVlanId();
                String pKey = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getPrivateNetworks().get(0).getPkey();
                if (i == 0 && (vlanID != null || pKey != null)) {
                    if (!driver.findElement(By.xpath(clusterNetworkAdvancedBtn)).isSelected()) {
                        driver.findElement(By.xpath(clusterNetworkAdvancedBtn)).click();
                    }
                    if (vlanID != null) {
                        driver.findElement(By.xpath(clusterNetworkEnableVlanCheckBox)).click();
                    }
                    if (pKey != null) {
                        driver.findElement(By.xpath(clusterNetworkEnablePKeyCheckBox)).click();
                    }
                    driver.findElement(By.xpath(clusterNetworkAdvancedCloseBtn)).click();
                }
            } catch (Exception e) {

            }

            // if virtual configuration, adminNetwork and privateNetworkList should not be null

            if (adminNetworkGateway != null) {
                if (i == 0) {
                    while (!driver.findElement(By.xpath(enableAdminNetworkBtn)).isDisplayed()) {
                        driver.findElement(By.xpath(adminNetworkCollapse)).click();
                        Thread.sleep(5000);
                    }
                    driver.findElement(By.xpath(enableAdminNetworkBtn)).click();
                }
                driver.findElement(By.xpath(adminNetworkClusterTab(i + 1))).click();

                String cnAdminNetworkDefaultGateway = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getAdminNetwork().getDefaultGateway();
                String cnAdminNetworkDefaultHostname = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getAdminNetwork().getDefaultHostname();
                if (cnAdminNetworkDefaultGateway.equals("true") && driver.findElements(By.xpath(clusterNetworkAdminNetworkDefaultGatewayCheckBox)).get(i).isDisplayed()) {
                    if (!driver.findElements(By.xpath(clusterNetworkAdminNetworkDefaultGatewayCheckBox)).get(i).isSelected()) {
                        driver.findElements(By.xpath(clusterNetworkAdminNetworkDefaultGatewayCheckBox)).get(i).click();
                    }
                }
                if (cnAdminNetworkDefaultHostname.equals("true") && driver.findElements(By.xpath(clusterNetworkAdminNetworkDefaultHostnameCheckBox)).get(i).isDisplayed()) {
                    if (!driver.findElements(By.xpath(clusterNetworkAdminNetworkDefaultHostnameCheckBox)).get(i).isSelected()) {
                        driver.findElements(By.xpath(clusterNetworkAdminNetworkDefaultHostnameCheckBox)).get(i).click();
                    }
                }

                String cnAdminNetworkGateway = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getAdminNetwork().getGateway();
                String cnAdminNetworkStartIPAddress = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getAdminNetwork().getStartIp();
                String cnAdminNetworkSubnetMask = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getAdminNetwork().getSubnetMask();
                String cnAdminNetworkComputeNameMask = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getAdminNetwork().getNameMask();
                String cnAdminNetworkComputeNameStartId = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getAdminNetwork().getStartId();

                clearAndSendKeys(clusterNetworkAdminGatewayInput, cnAdminNetworkGateway, i);
                Thread.sleep(100);
                clearAndSendKeys(clusterNetworkAdminStartIPInput, cnAdminNetworkStartIPAddress, i);
                Thread.sleep(100);
                driver.findElements(By.xpath(clusterNetworkAdminSubnetMaskDropList)).get(i).click();

                driver.findElements(By.xpath(clusterNetworkAdminSubnetMaskSearckField)).get(xpathHelper(clusterNetworkAdminSubnetMaskSearckField)).sendKeys(cnAdminNetworkSubnetMask);
                Thread.sleep(100);
                driver.findElement(By.xpath("//div[@aria-label=\"" + cnAdminNetworkSubnetMask + "\"]")).click();

                driver.findElements(By.xpath(clusterNetworkAdminModifyMasksBtn)).get(i).click();

                clearAndSendKeys(clusterNetworkAdminComputeNameMaskInput, cnAdminNetworkComputeNameMask, xpathHelper(clusterNetworkAdminComputeNameMaskInput));
                clearAndSendKeys(clusterNetworkAdminComputeNameStartIdInput, cnAdminNetworkComputeNameStartId, xpathHelper(clusterNetworkAdminComputeNameStartIdInput));
                driver.findElements(By.xpath(networkMasksApplyBtn)).get(xpathHelper(networkMasksApplyBtn)).click();
                Thread.sleep(1000);

            }
        }
        if (adminNetworkGateway != null) {
            driver.findElement(By.xpath(saveClusterNetworkAdminBtn)).click();
            Thread.sleep(5000);

            // admin network review and edit
            try {
                scrollToXpath(clusterNetworkAdminNetworkReviewAndEditCollapse);
                if (!driver.findElement(By.xpath(clusterNetworkAdminNetworkReviewAndEditCollapse)).isSelected()) {
                    driver.findElement(By.xpath(clusterNetworkAdminNetworkReviewAndEditCollapse)).click();
                    Thread.sleep(2000);
                }
                driver.findElement(By.xpath(clusterNetworkAdminNetworkLookUpIPBtn)).click();
                while (!driver.findElement(By.xpath(clusterNetworkAdminNetworkLookUpIPBtn)).isEnabled()) {
                    Thread.sleep(1000);
                }
                driver.findElement(By.xpath(clusterNetworkAdminNetworkEditUpdateBtn)).click();
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("Errors: Admin network review and edit");
            }
        }

        // client network
        String clientNetworkGateway = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(0).getClientNetwork().getGateway();
        if (clientNetworkGateway != null) {
            while (!driver.findElement(By.xpath(clientNetworkDefaultGatewayCheckBox)).isDisplayed()) {
                driver.findElement(By.xpath(clientNetworkCollapse)).click();
                Thread.sleep(5000);
            }
            for (int i = 0; i < clusterNumber; i++) {
                Thread.sleep(200);
                driver.findElement(By.xpath(clientNetowrkClusterTab(i + 1))).click();
                try {
                    String clientNetworkDefaultGateway = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getDefaultGateway();
                    String clientNetowrkDefaultHostname = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getDefaultHostname();
                    if (clientNetworkDefaultGateway.equals("true")) {
                        if (!driver.findElements(By.xpath(clientNetworkDefaultGatewayCheckBox)).get(i).isSelected()) {
                            driver.findElements(By.xpath(clientNetworkDefaultGatewayCheckBox)).get(i).click();
                        }
                    }
                    if (clientNetowrkDefaultHostname.equals("true")) {
                        if (!driver.findElements(By.xpath(clientNetworkDefaultHostnameCheckBox)).get(i).isSelected()) {
                            driver.findElements(By.xpath(clientNetworkDefaultHostnameCheckBox)).get(i).click();
                        }
                    }
                } catch (Exception e) {

                }

                try {
                    String clientNetworkVlan = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getVlanId();
                    if (clientNetworkVlan != null && driver.findElements(By.xpath(clientNetworkVlanInput)).get(i).isDisplayed()) {
                        clearAndSendKeys(clientNetworkVlanInput, clientNetworkVlan, i);
                    }
                } catch (Exception e) {
                }

                scrollToElement(driver.findElements(By.xpath(selectNetworkMediaSpeedDropList)).get(i));
                try {
                    String uiNetworkDescription = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getUiNetworkDescription();
                    String networkMediaAndSpeed = driver.findElements(By.xpath(selectNetworkMediaSpeedDropList)).get(i).getText();
                    if (!networkMediaAndSpeed.equals(uiNetworkDescription)) {
                        driver.findElements(By.xpath(selectNetworkMediaSpeedDropList)).get(i).click();
                        driver.findElement(By.xpath("//div[@aria-label=\"" + uiNetworkDescription + "\"]")).click();
                    }
                } catch (Exception e) {
                    System.out.println("Errors in ui network description");
                }

                String gateway = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getGateway();
                String startIPAddress = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getStartIp();
                clearAndSendKeys(cnGatewayInput, gateway, xpathHelper(cnGatewayInput));
                clearAndSendKeys(clientStartIPAddressInput, startIPAddress, xpathHelper(clientStartIPAddressInput));
                String clientNetworkSubnetMask = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getSubnetMask();
                driver.findElements(By.xpath(cnSubnetMaskDropList)).get(xpathHelper(cnSubnetMaskDropList)).click();
                driver.findElements(By.xpath(cnSubnetMaskSearchField)).get(xpathHelper(cnSubnetMaskSearchField)).sendKeys(clientNetworkSubnetMask);
                driver.findElement(By.xpath("//div[@aria-label='" + clientNetworkSubnetMask + "']")).click();
                Thread.sleep(200);

                System.out.println("*************************** Modify Client Network Masks ***********************************");
                driver.findElements(By.xpath(clientNetworkModifyMasksBtn)).get(i).click();
                Thread.sleep(100);
                String clientNetworkName = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getNameMask();
                String clientStartId = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getStartId();
                String vipName = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getVipNameMask();
                String vipStartId = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getVipStartId();
                clearAndSendKeys(clientNetworkMaskNameInput, clientNetworkName, xpathHelper(clientNetworkMaskNameInput));
                clearAndSendKeys(clientNetworkNameStartIDInput, clientStartId, xpathHelper(clientNetworkNameStartIDInput));
                clearAndSendKeys(vipMaskNameInput, vipName, xpathHelper(vipMaskNameInput));
                clearAndSendKeys(vipDetailsStartIDInput, vipStartId, xpathHelper(vipDetailsStartIDInput));

                String scanDetailsName = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getScanNameMask();
                String scanDetailsPort = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getClientNetwork().getScanPort();
                clearAndSendKeys(scanDetailsNameInput, scanDetailsName, xpathHelper(scanDetailsNameInput));
                clearAndSendKeys(scanDetailsPortInput, scanDetailsPort, xpathHelper(scanDetailsPortInput));
                Thread.sleep(200);
                driver.findElements(By.xpath(clientNetworkMasksApplyBtn)).get(xpathHelper(clientNetworkMasksApplyBtn)).click();

                Thread.sleep(2000);
            }

            scrollToXpath(saveClusterNetworkBtn);
            driver.findElement(By.xpath(saveClusterNetworkBtn)).click();
            Thread.sleep(10000);

            //Client network review and edit
            System.out.println("************************* Client network review and edit ***********************");
            try {
                scrollToXpath(clientNetworkReviewAndEditCollapse);
                if (!driver.findElement(By.xpath(clientNetworkReviewAndEditCollapse)).isSelected()) {
                    driver.findElement(By.xpath(clientNetworkReviewAndEditCollapse)).click();
                    Thread.sleep(5000);
                }
                if (driver.findElement(By.xpath(lookupClientNetworkIPBtn)).isEnabled()) {
                    scrollToXpath(lookupClientNetworkIPBtn);
                    driver.findElement(By.xpath(lookupClientNetworkIPBtn)).click();
                }
                while (!driver.findElement(By.xpath(lookupClientNetworkIPBtn)).isEnabled()) {
                    Thread.sleep(1000);
                }
                driver.findElement(By.xpath(clientReviewAndEditUpdateBtn)).click();
            } catch (Exception e) {
                System.out.println("Errors: client network review and edit");
            }
        }

        // private network
        boolean isPrivateNetworkAvailable = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(0).getPrivateNetworks().size() != 0;
        if (isPrivateNetworkAvailable) {
            try {
                String pKey = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(0).getPrivateNetworks().get(0).getPkey();
                if (pKey != null) {
                    while (!driver.findElement(By.xpath(privateNetowrkClusterTab(1))).isDisplayed()) {
                        driver.findElement(By.xpath(privateNetworkCollapse)).click();
                        Thread.sleep(10000);
                    }
                    for (int i = 0; i < clusterNumber; i++) {
                        driver.findElement(By.xpath(privateNetowrkClusterTab(i + 1)));
                        String clusterPKey = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getPrivateNetworks().get(0).getPkey();
                        String clusterStartIPAddress = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getPrivateNetworks().get(0).getStartIp();
                        String clusterNameMask = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getPrivateNetworks().get(0).getNameMask();
                        String clusterStartId = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getPrivateNetworks().get(0).getStartId();
                        scrollToElement(driver.findElements(By.xpath(privateNetworkClusterPKeyInput)).get(i));
                        clearAndSendKeys(privateNetworkClusterPKeyInput, clusterPKey, i);
                        clearAndSendKeys(privateNetworkClusterStartIPAddressInput, clusterStartIPAddress, i);
                        clearAndSendKeys(privateNetworkClusterNameMaskInput, clusterNameMask, i);
                        clearAndSendKeys(privateNetworkClusterStartIdInput, clusterStartId, i);

                        String storagePKey = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getPrivateNetworks().get(1).getPkey();
                        String storageStartIPAddress = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getPrivateNetworks().get(1).getStartIp();
//                String computeNameMask = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getPrivateNetworks().get(1).getNameMask();
                        String storageNameMask = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getPrivateNetworks().get(1).getNameMask();
//                String computeStartId = ;
                        String storageStartId = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getPrivateNetworks().get(1).getStartId();
                        clearAndSendKeys(privateNetworkStoragePKeyInput, storagePKey, i);
                        clearAndSendKeys(privateNetworkStorageStartIPAddressInput, storageStartIPAddress, i);
//                clearAndSendKeys(privateNetworkComputeNameMaskInput, computeNameMask, i);
                        clearAndSendKeys(privateNetworkStorageNameMaskInput, storageNameMask, i);
//                clearAndSendKeys(privateNetworkComputeNameStartIdInput, computeStartId, i);
                        clearAndSendKeys(privateNetworkStorageNameStartIdInput, storageStartId, i);
                        Thread.sleep(200);
                    }
                }
            } catch (Exception e) {

            }
            scrollToXpath(savePrivateNetworkBtn);
            driver.findElement(By.xpath(savePrivateNetworkBtn)).click();
            Thread.sleep(5000);
        }

        // backup network
        boolean isBackupNetworkAvailable = false;
        for (int i = 0; i < clusterNumber; i++) {
            String backupNetworkGateway = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getBackupNetwork().getGateway();
            if (backupNetworkGateway != null) {
                isBackupNetworkAvailable = true;
                break;
            }
        }
        if (isBackupNetworkAvailable) {
            while (!driver.findElement(By.xpath(enableBackupNetworkBtn)).isDisplayed()) {
                driver.findElement(By.xpath(backNetworkCollapse)).click();
                Thread.sleep(5000);
            }
            if (!driver.findElement(By.xpath(enableBackupNetworkBtn)).isSelected()) {
                driver.findElement(By.xpath(enableBackupNetworkBtn)).click();
                Thread.sleep(500);
            }
            for (int i = 0; i < clusterNumber; i++) {
                driver.findElement(By.xpath(backupNetworkClusterTab(i + 1))).click();

                // set shared client network port
                String sharedClientNetworkPort = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getBackupNetwork().getSharedClientNetworkPort();
                String backupNetworkVlan = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getBackupNetwork().getVlanId();
                String backupNetworkGateway = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getBackupNetwork().getGateway();
                String backupNetworkStartIPAddress = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getBackupNetwork().getStartIp();
                String backupNetworkSubnetMask = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getBackupNetwork().getSubnetMask();
                String backupName = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getBackupNetwork().getNameMask();
                String backupStartID = parseJson(jsonfile).getClusterNetworks().getClusterNetworkList().get(i).getBackupNetwork().getStartId();

                if (sharedClientNetworkPort.equals("true")) {
                    driver.findElements(By.xpath(sharedClientNetworkPortCheckBox)).get(i).click();
                }
                if (backupNetworkVlan != null && driver.findElements(By.xpath(backupNetworkVlanInput)).get(i).isDisplayed()) {
                    clearAndSendKeys(backupNetworkVlanInput, backupNetworkVlan, i);
                }
                clearAndSendKeys(backupNetworkGatewayInput, backupNetworkGateway, i);
                clearAndSendKeys(backupNetworkStartIPAddressInput, backupNetworkStartIPAddress, i);
                driver.findElements(By.xpath(backupNetworkSubnetMaskDropList)).get(i).click();
                driver.findElements(By.xpath(backupNetworkSubnetMaskSearchField)).get(xpathHelper(backupNetworkSubnetMaskSearchField)).sendKeys(backupNetworkSubnetMask);
                driver.findElement(By.xpath("//div[@aria-label=\"" + backupNetworkSubnetMask + "\"]")).click();
                driver.findElements(By.xpath(backupNetworkModifyMasksBtn)).get(i).click();
                clearAndSendKeys(backupNameInput, backupName, xpathHelper(backupNameInput));
                clearAndSendKeys(backupStartIDInput, backupStartID, xpathHelper(backupStartIDInput));
                driver.findElements(By.xpath(backupDetailApplyBtn)).get(xpathHelper(backupDetailApplyBtn)).click();
                Thread.sleep(100);
            }
            driver.findElement(By.xpath(backupNetworkApplyBtn)).click();
            Thread.sleep(5000);

            System.out.println("***************************** Backup network review and edit *******************************");
            try {
                if (!driver.findElement(By.xpath(backupNetworkReviewAndEditCollapse)).isSelected()) {
                    driver.findElement(By.xpath(backupNetworkReviewAndEditCollapse)).click();
                    Thread.sleep(200);
                }
                driver.findElement(By.xpath(backupNetworkLookupIPBtn)).click();
                while (!driver.findElement(By.xpath(backupNetworkLookupIPBtn)).isEnabled()) {
                    Thread.sleep(1000);
                }
                driver.findElement(By.xpath(backupNetworkIPUpdateBtn)).click();
            } catch (Exception e) {
                System.out.println("Errors: backup network review and edit");
            }
        }
    }

    @Test
    public void test10*() throws Exception {
        System.out.println("Running test " + getMethodName());
        Thread.sleep(5000);
        scrollToXpath(submitAlertBtn);
        driver.findElement(By.xpath(submitAlertBtn)).click();
    }

    @Test
    public void test11*() throws Exception {
        System.out.println("Running test " + getMethodName());
        Thread.sleep(1000);
        String commentText = parseJson(jsonfile).getComments();
        clearAndSendkeys(addCommnetsText, commentText);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private void scrollToXpath(String pLocator) throws Exception {
        WebElement element = driver.findElement(By.xpath(pLocator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].scrollIntoView(false);", element);
        Thread.sleep(3000);
    }

    private void scrollToElement(WebElement element) throws  Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].scrollIntoView(false);", element);
        Thread.sleep(3000);
    }

    private String getMethodName() {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        return ste.getMethodName();
    }

    private void clearAndSendkeys(String pLocator, String keys) throws Exception {
        driver.findElement(By.xpath(pLocator)).click();
        Thread.sleep(100);
        driver.findElement(By.xpath(pLocator)).clear();
        Thread.sleep(100);
        driver.findElement(By.xpath(pLocator)).sendKeys(keys);
        Thread.sleep(100);
    }

    private void clearAndSendKeys(String pLocator, String keys, int i) throws Exception {
        driver.findElements(By.xpath(pLocator)).get(i).click();
        Thread.sleep(100);
        driver.findElements(By.xpath(pLocator)).get(i).clear();
        Thread.sleep(100);
        driver.findElements(By.xpath(pLocator)).get(i).sendKeys(keys);
        Thread.sleep(100);
    }

    private int xpathHelper(String pLocator) {
        int size = driver.findElements(By.xpath(pLocator)).size();
        for (int i = 0; i < size; i++) {
            if (driver.findElements(By.xpath(pLocator)).get(i).isDisplayed()) {
                return i;
            }
        }
        System.out.println("Xpath error: " + pLocator);
        return -1;
    }
}
