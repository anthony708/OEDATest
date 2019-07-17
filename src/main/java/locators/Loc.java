package locators;

public class Loc {

    // Menu and menu items
    public static String menuBtn = "//*[@class=\"oj-button-text\" and contains(text(), 'Menu')]";
    public static String saveItem = "//a[text()='Save']";
    public static String diagnosticsItem = "//*[@id=\"diagnostics\"]";
    public static String preferencesItem = "//*[@id=\"preferences\"]";

    // Navigation
    public static String hardwareItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Hardware')]";
    public static String rackNetworksItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Rack Networks')]";
    public static String operatingSystemItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Operating System')]";
    public static String usersItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Users')]";
    public static String clustersItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Clusters')]";
    public static String diskgroupItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Diskgroups')]";
    public static String dbHomeItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Database Home')]";
    public static String dbItem = "//*[text()='Database']";
    public static String clusterNetworksItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Cluster Networks')]";
    public static String alertingItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Alerting')]";
    public static String commentsItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Comments')]";

    /*
        Hardware
     */
    public static String selectHardwareCollapse = "//span[contains(text(),'Select Hardware')]";
    public static String exadbmIcon = "//input[@id=\"exaopt\"]";
    public static String zdlraIcon = "//input[@id=\"zdlraopt\"]";
    public static String exacIcon = "//input[@id=\"cloudopt\"]";

    public static String computeNodeDropList = "//*[@id=\"ojChoiceId_selectExaCompNode_selected\"]";
    public static String searchField = "//input[@title=\"Search field\"]";
    public static String computeNodeX7_2RoCE = "//div[@class='oj-listbox-result-label' and contains(text(),'X7-2 RoCE')]";
    public static String computeNodeX7_8RoCE = "//div[@class='oj-listbox-result-label' and contains(text(),'X7-8 RoCE')]";
    public static String computeNodeX7_2 = "//div[@class='oj-listbox-result-label' and @aria-label='X7-2']";
    public static String computeNodeX7_8 = "//div[@class='oj-listbox-result-label' and @aria-label='X7-8']";
    public static String computeNodeX6_2 = "//div[@class='oj-listbox-result-label' and @aria-label='ExadataX6-2']";
    public static String computeNodeX6_8 = "//div[@class='oj-listbox-result-label' and @aria-label='ExadataX6-8']";
    public static String computeNodeX5_8 = "//div[@class='oj-listbox-result-label' and @aria-label='X5-8']";
    public static String computeNodeX5_2 = "//div[@class='oj-listbox-result-label' and @aria-label='X5-2']";
    public static String computeNodeX4_8 = "//div[@class='oj-listbox-result-label' and @aria-label='X4-8']";
    public static String computeNodeX4_2 = "//div[@class='oj-listbox-result-label' and @aria-label='X4-2']";
    public static String computeNodeX4SE = "//div[@class='oj-listbox-result-label' and @aria-label='X4 Storage Expansion']";
    public static String computeNodeX3_8 = "//div[@class='oj-listbox-result-label' and @aria-label='X3-8']";
    public static String computeNodeX3_2 = "//div[@class='oj-listbox-result-label' and @aria-label='X3-2']";
    public static String computeNodeX3SE = "//div[@class='oj-listbox-result-label' and @aria-label='X3 Storage Expansion']";
    public static String computeNodeX2_8 = "//div[@class='oj-listbox-result-label' and @aria-label='X2-8']";
    public static String computeNodeX2_2 = "//div[@class='oj-listbox-result-label' and @aria-label='X2-2']";
    public static String computeNodeX2SE = "//div[@class='oj-listbox-result-label' and @aria-label='X2 Storage Expansion']";

    public static String rackSizeDropList = "//*[@id=\"ojChoiceId_selectRackSize_selected\"]";
    public static String rackSizeElastic = "//div[@class='oj-listbox-result-label' and text()=\"Elastic\"]";
    public static String rackSizeFull = "//div[contains(text(),'Full')]";
    public static String rackSizeQuarter = "//div[contains(text(),'Quarter')]";

    public static String diskSizeDropList = "//*[@id=\"ojChoiceId_selectCellServerCapacity_selected\"]";
    public static String diskSizeHC10TB = "//div[@class='oj-listbox-result-label' and contains(text(),'HC 10TB')]";
    public static String diskSizeEF64TB = "//div[@class='oj-listbox-result-label' and contains(text(),'EF 6.4TB')]";

    public static String addRackBtn = "//button[@id=\"addRackBtn\"]";

    public static String rackName = "/html/body/div[3]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[5]/div/div[4]/div/div[3]/div[1]/div/label";
    public static String rackPrefixInput = inputAltXPath("Rack Prefix");
    public static String spineSwitchCheckbox = inputAltXPath("Spine Switch");
    public static String customerNameInput = inputAltXPath("Customer Name");
    public static String appSerialNumInput = inputAltXPath("Application/Serial #");

    public static String regionLabel = "//div[@class='oj-label-group']/label[contains(text(),'Region')";
    public static String regionDropList = "//div[@class='oj-label-group']/label[contains(text(),'Region')]/../../following-sibling::div";
    public static String regionAfrica = "//div[@class='oj-listbox-result-label' and @aria-label='Africa']";
    public static String regionAmerica = "//div[@class='oj-listbox-result-label' and @aria-label='America']";
    public static String regionAntarctica = "//div[@class='oj-listbox-result-label' and @aria-label='Antarctica']";
    public static String regionArctic = "//div[@class='oj-listbox-result-label' and @aria-label='Arctic']";
    public static String regionAsia = "//div[@class='oj-listbox-result-label' and @aria-label='Asia']";
    public static String regionAtlantic = "//div[@class='oj-listbox-result-label' and @aria-label='Atlantic']";
    public static String regionAustralia = "//div[@class='oj-listbox-result-label' and @aria-label='Australia']";
    public static String regionEurope = "//div[@class='oj-listbox-result-label' and @aria-label='Europe']";
    public static String regionIndian = "//div[@class='oj-listbox-result-label' and @aria-label='Indian']";
    public static String regionOther = "//div[@class='oj-listbox-result-label' and @aria-label='Other']";
    public static String regionPacific = "//div[@class='oj-listbox-result-label' and @aria-label='Pacific']";

    public static String timezoneLabel = "//div[@class='oj-label-group']/label[contains(text(),'Timezone')]";
    public static String timezoneDropList = "//div[@class='oj-label-group']/label[contains(text(),'Timezone')]/../../following-sibling::div";
    public static String timezoneSearchField = "/html/body/div[1]/div/div/div/div/input";
    public static String timezoneSearchBtn = "//span[@class=\"oj-listbox-spyglass-box\"]";
    public static String timezoneNY = "//div[@class='oj-listbox-result-label' and @aria-label='New_York']";

    public static String computeNodeCountInput = inputAltXPath("Compute Node count");
    public static String storageNodeCountInput = inputAltXPath("Storage Node count");
    public static String dnsServers1Input = "//div[@class='oj-label-group']/label[contains(text(), 'DNS Servers')]/../../following-sibling::div/input[@alt='DNS Servers']";
    public static String dnsServers2Input = "//div[@class='oj-label-group']/label[contains(text(), 'DNS Servers')]/../../../following-sibling::div[1]/div/input[@alt='DNS Servers']";
    public static String dnsServers3Input = "//div[@class='oj-label-group']/label[contains(text(), 'DNS Servers')]/../../../following-sibling::div[2]/div/input[@alt='DNS Servers']";
    public static String ntpServers1Input = "//div[@class='oj-label-group']/label[contains(text(), 'NTP Servers')]/../../following-sibling::div/input[@alt='NTP Servers']";
    public static String ntpServers2Input = "//div[@class='oj-label-group']/label[contains(text(), 'NTP Servers')]/../../../following-sibling::div[1]/div/input[@alt='NTP Servers']";
    public static String ntpServers3Input = "//div[@class='oj-label-group']/label[contains(text(), 'NTP Servers')]/../../../following-sibling::div[2]/div/input[@alt='NTP Servers']";

    public static String automcticWBFCIcon = "//input[@value=\"automatic\"]";
    public static String disableWBFCIcon = "//input[@value=\"disable\"]";
    public static String enableWBFCIcon = "//input[@value=\"enable\"]";

    public static String enableCoDCheckbox = "//label[contains(text(),'Enable Capacity-on-Demand')]/../input[@class='oj-checkbox-nocomp']";

    public static String hardwareApplyBtn = "//button[@id=\"rackSelectNextButton\"]";
    public static String confirmedBtn = "// button[@id=\"codConfirmButton\"]";

    /*
        Operating System
     */
    public static String osChoiceDropList = "//*[@id=\"ojChoiceId_selectOsChoice_selected\"]";
    public static String osCLinuxOVM = "//*[@id=\"ojChoiceId_selectOsChoice_selected\"]";
    public static String osCLinuxPhysical = "//div[@class='oj-listbox-result-label' and @aria-label='All Linux Physical']";
    public static String osCCustom = "//div[@class='oj-listbox-result-label' and @aria-label='Custom']";
    public static String osSaveBtn = "//*[@id=\"osSaveBtn\"]";

    /*
        Rack Networks
      */
    public static String removePDUsCheckBox = "/html/body/div[3]/div/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[2]/div[1]/div/input[@type='checkbox']";
    public static String rackNwAdvBtn = "//button[@id=\"RackNwAdvancedButton\"]";
    public static String adminNetworkCollapse = "//label[contains(text(), 'Admin Network')]";

    public static String gateWayCheckBox = "//input[@alt='Default Gateway']";
    public static String gateWayInput = inputAltXPath("Gateway");
    public static String anStartIPAddress = inputAltXPath("Start IP");

    public static String anSubnetMaskDropList = "//label[contains(text(),'Subnet Mask')]/../../following-sibling::div/div";

    public static String anSubnetMaskSearchField = "/html/body/div[1]/div/div/div/div/input";
    public static String anSubnetMask2552552400 = "//div[@aria-label='255.255.240.0']";

    public static String anDomainNameInput = "//input[@alt=\"Domain Name\"]";

    public static String seperateILOMNwCheckBox = "//input[@title='Separate ILOM network']";

    public static String adminNetworkApplyBtn = "//*[@id=\"saveRackNetworksButtonAdmin\"]";

    public static String pnStartIPAddress = "//label[contains(text(),'Start IP Address')]/../../following-sibling::div/input[@alt=\"Start IP Address\"]";
    //public static String pnSubnetMaskDropList = "";
    //public static String pnSubnetMaskSearchField = "";
    //public static String pnSubnetMask2552552480 = "";
    //public static String pnDomainNameInput = "";
    public static String privateNetworkApplyBtn = "//*[@id=\"saveRackNetworksButtonPrivate\"]";

    /*
        Modify Masks
     */
    public static String modifyMasksBtn = "//button[@id=\"buttonOpener\" and @title=\"Modify masks\"]";
    public static String computeNameMaskInput = "//input[@type=\"text\" and @alt=\" Compute Name Mask\"]";
    public static String computeNameStartIDInput = "//input[@type=\"text\" and @alt=\"Compute Name Start Id\"]";

    public static String storageNameMaskInput = "//label[contains(text(),'Storage Name Mask')]/../../following-sibling::div/input";
    public static String storageNameStartIDInput = "//label[contains(text(),'Storage Name Start Id')]/../../following-sibling::div/input";

    public static String computeILOMMaskInput = "//input[@type=\"text\" and @alt=\" Compute ILOM Mask\"]";
    public static String ilomNameStartIDInput = "//input[@type=\"text\" and @alt=\"ILOM Name Start Id\"]";

    public static String storageILOMNameMaskInput = "//label[contains(text(),'Storage ILOM Name Mask')]/../../following-sibling::div/input";
    public static String storageILOMStartIDInput = "//label[contains(text(),'Storage ILOM Start Id')]/../../following-sibling::div/input";

    public static String ciscoSwitchInput = "//label[contains(text(),'Cisco Switch')]/../../following-sibling::div/input";
    public static String infiniBandLeaf1Input = "//label[contains(text(),'InfiniBand Leaf')]/../../following-sibling::div/input";
    public static String pduAInput = "//label[contains(text(),'PDU-A')]/../../following-sibling::div/input";
    public static String infiniBandSpineInput = "//label[contains(text(),'InfiniBand Spine')]/../../following-sibling::div/input";
    public static String infinibandLeaf2Input = "//label[contains(text(),'Infiniband Leaf')]/../../following-sibling::div/input";
    public static String pdbBInput = "//label[contains(text(),'PDU-B')]/../../following-sibling::div/input";

    public static String networkMasksApplyBtn = "//div[@id=\"masks\"]/div/div/button/div/span[text()=\"Apply\"]";
    public static String computePrivateNetworkMasksInput = "//div[contains(text(),'Compute private masks')]/../following-sibling::div[2]/div[1]/div[2]/input";
    public static String computePrivateNameStartIDInput = "//div[contains(text(),'Compute private masks')]/../following-sibling::div[3]/div[1]/div[2]/input";

    public static String cellPrivateNameMaskInput = "//div[contains(text(),'Compute private masks')]/../following-sibling::div[2]/div[2]/div[2]/input";
    public static String cellPrivateNameStartIDInput = "//div[contains(text(),'Compute private masks')]/../following-sibling::div[3]/div[2]/div[2]/input";

    public static String clientNetworkMaskNameInput = "//div[contains(text(), \"Client access details\")]/../following-sibling::div[2]/div[1]/div[2]/input";
    public static String clientNetworkNameStartIDInput = "//div[contains(text(), \"Client access details\")]/../following-sibling::div[3]/div[1]/div[2]/input";

    public static String vipMaskNameInput = "//div[contains(text(), \"Client access details\")]/../following-sibling::div[2]/div[2]/div[2]/input";
    public static String vipDetailsStartIDInput = "//div[contains(text(), \"Client access details\")]/../following-sibling::div[3]/div[2]/div[2]/input";

    public static String scanDetailsNameInput = "//div[contains(text(),'Scan details')]/../following-sibling::div[2]/div[1]/div[2]/input";
    public static String scanDetailsPortInput = "//div[contains(text(),'Scan details')]/../following-sibling::div[2]/div[2]/div[2]/input";

    public static String clientNetworkMasksApplyBtn = "//div[text()=\"Client Network Masks\"]/../following-sibling::div/div[2]/div[1]/button/div/span";

    /*
        Users
     */
    public static String defaultRadioBtn = "//span[contains(text(),'Default')]/../preceding-sibling::span";
    public static String roleSeperatedRadioBtn = "//span[contains(text(),'Role Separated')]/../preceding-sibling::span";
    public static String customRadioBtn = "//span[contains(text(),'Custom')]/../preceding-sibling::span";
    public static String userGroupSaveBtn = "//*[@id=\"usergroup-save-btn\"]";

    /*
        Clusters
     */
    public static String gridSoftwareVersionDropList = "";
    public static String addAllNodesbtn = "//button[@alt=\"Add All Nodes Button\"]";
    public static String submitClusterBtn = "//*[@id=\"submitClusterButton_v2\"]";

    /*
        Diskgroups
     */
    public static String advancedCheckBox = "//input[@title=\"Advanced options\"]";
    public static String enableASMSSCheckBox = "//input[@title=\"Enable Asm Scoped Security\"]";

    public static String redundancyDropList2 = "/html/body/div[3]/div/div[2]/div/div[2]/div/div/div[6]/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[4]/div[2]/div[3]/div[1]/following-sibling::div";
    public static String redundancyHigh = "//div[@aria-label=\"HIGH\"]";
    public static String redundancyNormal = "//div[@aria-label=\"NORMAL\"]";
    public static String saveDiskgroupBtn = "//*[@id=\"saveDiskgroupBtnId\"]";

    /*
        Database Home
     */
    public static String submitDBHomeBtn = "//*[@id=\"submitDatabaseHomeButton\"]";

    /*
        Database
     */
    public static String submitDBBtn = "//*[@id=\"submitDatabaseButtonId\"]";

    /*
        Client Network
     */
    public static String clientNetworkCollapse = "//*[@id=\"oj-collapsible-clusterClientNetworkCollapsible-header\"]";
    public static String defaultGatewayCheckBox = "//input[@class=\"oj-checkbox-nocomp defaultGatewayClient\" and @title=\"Default Gateway\"]";
    public static String defaultHosenameCheckBox = "//input[@class=\"oj-checkbox-nocomp defaultHostnameClient\" and @title=\"Default Hostname\"]";
    public static String cnGatewayInput = "//label[contains(text(),'Gateway')]/../../following-sibling::div/input";
    public static String cnSubnetMaskDropList = "//label[contains(text(),'Subnet Mask')]/../../following-sibling::div";
    public static String cnSubnetMaskSearchField = "//input[@title=\"Search field\"]";
    public static String cnSubnetMast2552552480 = "//span[contains(text(),'255.255.248.0')]";
    public static String startIPAddressInput = "//label[contains(text(),'Start IP Address')]/../../following-sibling::div/input";
    public static String saveClusterNetworkBtn = "//*[@id=\"saveClusterNetworkBtn_client\"]";

    // BackupNetwork
    public static String enableBackupNetworkBtn = "//label[contains(text(),'Enable Backup network')]";
    public static String selectNetworkMediaSpeedDroplist = "//label[contains(text(),'Select network media and speed')]/../../../following-sibling::div/div/div/div/span";
    public static String SFP28PCI = "//div[text()=\"SFP28 PCI Dual Port Card\"]";
    public static String backupNetworkGateway = "//input[@alt=\"Gateway\"]";
    public static String backupNetworkApplyBtn = "//button[@title='Apply Network changes']";

    /*
        Alerting
     */
    public static String submitAlertBtn = "//*[@id=\"submitAlertsButton\"]";

    /*
        Comments
     */
    public static String saveCommentsBtn = "//*[@id=\"saveCommentButton\"]";

    private static String inputAltXPath(String alt) {
        return "//input[@alt=\"" + alt + "\"]";
    }

}
