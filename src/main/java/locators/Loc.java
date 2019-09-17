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

    public static String regionDropList = "//label[contains(text(),'Region')]/../../following-sibling::div/div/span";

    public static String timezoneDropList = "//div[@class='oj-label-group']/label[contains(text(),'Timezone')]/../../following-sibling::div/div";
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
    public static String osSaveBtn = "//*[@id=\"osSaveBtn\"]";

    /*
        Rack Networks
      */
    public static String removePDUsCheckBox = "/html/body/div[3]/div/div[2]/div/div[2]/div/div/div[3]/div/div/div/div[2]/div[1]/div/input[@type='checkbox']";
    public static String rackNwAdvBtn = "//button[@id=\"RackNwAdvancedButton\"]";
    public static String enableVlanCheckBox = "//input[@id=\"rackNetworkVlanCb\"]/following-sibling::label[contains(text(),'Enable Vlan')]";
    public static String enableVlanCloseBtn = "//input[@id=\"rackNetworkVlanCb\"]/../../../../following-sibling::div/button[@id=\"preferencesCloseButton\"]";
    //public static String adminNetworkCollapse = "//label[contains(text(), 'Admin Network')]";

    public static String adminNetworkDefaultGatewayCheckBox = "//div[@id=\"rackNetworksTab_Admin\"]/div[4]/div/div/div/div[3]/div/div/input[@alt=\"Default Gateway\"]";
    public static String adminNetworkDefaultHostnameCheckBox = "//div[@id=\"rackNetworksTab_Admin\"]/div[4]/div/div/div/div[4]/div/div/input[@alt=\"Default Hostname\"]";
    public static String anGateWayInput = "//div[@id=\"rackNetworksTab_Admin\"]/div[4]/div/div[@class=\"networkUiElements\"]/div/div[6]/div[1]/div[2]/input";
    public static String anStartIPAddress = "//div[@id=\"rackNetworksTab_Admin\"]/div[4]/div/div[@class=\"networkUiElements\"]/div/div[6]/div[2]/div[2]/input";

    public static String anSubnetMaskDropList = "//label[contains(text(),'Subnet Mask')]/../../following-sibling::div/div";
    public static String anSubnetMaskSearchField = "/html/body/div[1]/div/div/div/div/input";

    public static String anDomainNameInput = "//input[@alt=\"Domain Name\"]";

    public static String seperateILOMNwCheckBox = "//input[@title='Separate ILOM network']";

    public static String adminNetworkApplyBtn = "//*[@id=\"saveRackNetworksButtonAdmin\"]";

    public static String enableActiveBondingCheckBox = inputAltXPath("Active Bonding");
    public static String pnStartIPAddress = "//label[contains(text(),'Start IP Address')]/../../following-sibling::div/input[@alt=\"Start IP Address\"]";
    public static String pnSubnetMaskDropList = "//div[@id=\"rackNetworksTab_Private\"]/div[4]/div/div/div/div[5]/div/div[2]/div/span";

    public static String privateNetworkApplyBtn = "//*[@id=\"saveRackNetworksButtonPrivate\"]";

    // Admin network Review and Edit
    public static String adminNetworkReviewAndEditCollapse = "//label[text()=\"Admin network Review and Edit\"]";
    public static String lookupAdminNetworkIPBtn = "//button[@id=\"lookupAdminNetworkButton\"]";
    public static String adminReviewAndEditUpdateBtn = "//button[@id=\"adminReviewAndEdit\"]";

    // Client network Review and Edit
    public static String clientNetworkReviewAndEditCollapse = "//label[text()=\"Client network Review and Edit\"]";
    public static String lookupClientNetworkIPBtn = "//button[@id=\"lookupClientNetworkButton\"]";
    public static String clientReviewAndEditUpdateBtn = "//button[@id=\"lookupClientNetworkButton\"]//following-sibling::button[@id=\"saveNetworkAdmin\"]";

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
    public static String infiniBandLeaf1Input = "//div[@id=\"masks\"]/div/div[11]/div[4]/div[1]/div/div/label[contains(text(),'Infiniband Leaf')]/../../following-sibling::div/input";
    public static String pduAInput = "//label[contains(text(),'PDU-A')]/../../following-sibling::div/input";
    public static String infiniBandSpineInput = "//label[contains(text(),'Infiniband Spine')]/../../following-sibling::div/input";
    public static String infinibandLeaf2Input = "//div[@id=\"masks\"]/div/div[11]/div[4]/div[2]/div/div/label[contains(text(),'Infiniband Leaf')]/../../following-sibling::div/input";
    public static String pduBInput = "//label[contains(text(),'PDU-B')]/../../following-sibling::div/input";

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
    public static String addUsersBtn = "//div[@id=\"usergroup-container\"]/div[1]/div/div/div[2]/div[2]/button[@alt=\"add UserGroup Collection\"]";

    public static String defaultRadioBtn = "//span[contains(text(),'Default')]/../preceding-sibling::span";
    public static String roleSeperatedRadioBtn = "//span[contains(text(),'Role Separated')]/../preceding-sibling::span";
    public static String customRadioBtn = "//span[contains(text(),'Custom')]/../preceding-sibling::span";
    public static String userGroupSaveBtn = "//*[@id=\"usergroup-save-btn\"]";

    /*
        Clusters
     */
    public static String addClusterBtn = "//button[@alt=\"Add Cluster Button\"]";

    public static String gridSoftwareVersionDropList = "//input[@alt=\"Grid Software Version\"]/preceding-sibling::div";
    public static String gridVersionText = "//div[@aria-label=\"19.3.0.0 RU190416\"]";
    public static String gridInfrastructureHomeLocationInput = "//input[@alt=\"Grid Infrastructure Home Location\"]";
    public static String addAllNodesbtn = "//button[@alt=\"Add All Nodes Button\"]";
    public static String guestCoresInput = inputAltXPath("Cores");
    public static String guestMemoryInput = inputAltXPath("Memory");
    public static String submitClusterBtn = "//*[@id=\"submitClusterButton_v2\"]";

    /*
        Diskgroups
     */
    public static String advancedCheckBox = "//input[@title=\"Advanced options\"]";
    public static String enableSparseDiskgroupCheckBox = "//input[@title=\"Enable sparse diskgroup\"]";
    public static String enableASMSSCheckBox = "//input[@title=\"Enable Asm Scoped Security\"]";
    public static String configureAcfsBtn = "//button[@id=\"configureAcfsBtnId\"]";
    public static String enableACFSForDGCheckBox = "//input[@title=\"Enable acfs diskgroup\"]";
    public static String acfsConfigureSaveBtn = "//input[@title=\"Enable acfs diskgroup\"]/../../../following-sibling::div/button/div/span[text()='Save']";

    public static String diskgroupLayoutDropBox = "//label[contains(text(), 'Diskgroup layout')]/../../following-sibling::div/div[1]";
    public static String diskgroupLayoutCustom = "//div[text()=\"Custom\"]";
    public static String addNewDiskgroupBtn = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[1]/div[10]/div/div/button[@alt=\"add new diskgroup\"]";

    public static String redundancyDropList1 = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[1]/div[3]/div[2]/div/span";
    public static String redundancyDropList2 = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[2]/div[3]/div[2]/div/span";
    public static String redundancyDropList3 = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[3]/div[3]/div[2]/div/span";
    public static String redundancyDropList4 = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[4]/div[3]/div[2]/div/span";

    public static String diskgroup1Name = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[1]/div[1]/div[2]/input";
    public static String diskgroup2Name = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[2]/div[1]/div[2]/input";
    public static String diskgroup3Name = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[3]/div[1]/div[2]/input";
    public static String diskgroup4Name = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[4]/div[1]/div[2]/input";

    public static String dg3TypeDropbox = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[3]/div[2]/div[2]/div";
    public static String dg4TypeDropbox = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[4]/div[2]/div[2]/div";
    public static String dgTypeOther = "//div[@aria-label=\"OTHER\"]";
    public static String dg1SizeInput = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[1]/div[5]/div[2]/input";
    public static String dg2SizeInput = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[2]/div[5]/div[2]/input";
    public static String dg3SizeInput = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[3]/div[5]/div[2]/input";
    public static String dg4SizeInput = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[4]/div[5]/div[2]/input";
    public static String dg3SizeTypeDropbox = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[3]/div[6]/div[2]/div[1]";
    public static String dg4SizeTypeDropbox = "//div[@id=\"diskGroupView\"]/div[2]/div/div[4]/div[4]/div[6]/div[2]/div[1]";
    public static String usableSizeType = "//div[text()='usable size']";

    public static String saveDiskgroupBtn = "//*[@id=\"saveDiskgroupBtnId\"]";

    /*
        Database Home
     */
    public static String addDBHomeBtn = "//button[@id=\"addDatabaseHomeButton\"]";
    public static String selectClusterDropList = "//label[contains(text(),'Select Cluster')]/../../following-sibling::div/div/input";
    public static String dbHomeVersionDropList = "//label[contains(text(),'Database Home Version')]/../div/input[@alt=\"Select Database Home version\"]";
    public static String submitDBHomeBtn = "//*[@id=\"submitDatabaseHomeButton\"]";

    /*
        Database
     */
    public static String addDatabaseBtn = "//button[@id=\"addDatabaseButton\"]";
    public static String databaseHomeDropList = "//label[text()='Database Home']/../../following-sibling::div/div/input";
    public static String enableCDBCheckbox = "//input[@title=\"Enable CDB\"]";
    public static String pdbNameInput = "//input[@alt=\"PDB Name\"]";
    public static String submitDBBtn = "//*[@id=\"submitDatabaseButtonId\"]";

    /*
        Client Network
     */
    public static String adminNetworkCollapse = "//div[@id=\"clusterNetworkAccordionPage\"]/div/label[text()=\"Admin Network\"]";
    public static String clusterNetworkAdvancedBtn = "//div[@id=\"network_container_id\"]//button[@id=\"hwAdvancedButton\"]";
    public static String clusterNetworkEnableVlanCheckBox = "//div[@id=\"nwAdvancedDialog_layer\"]//label[contains(text(),'Enable Vlan')]";
    public static String clusterNetworkEnableVlanCloseBtn = "//div[@id=\"nwAdvancedDialog\"]/div[4]/button[@id=\"preferencesCloseButton\"]";
    public static String enableAdminNetworkBtn = "//label[text()='Enable Admin network']";
    public static String clusterNetworkAdminNetworkDefaultGatewayCheckBox = "//div[@id=\"clusterAdminNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[3]/div/div/input[@alt=\"Default Gateway\"]";
    public static String clusterNetworkAdminNetworkDefaultHostnameCheckBox = "//div[@id=\"clusterAdminNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[4]/div/div/input[@alt=\"Default Hostname\"]";
    public static String clusterNetworkAdminGatewayInput = "//div[@id=\"clusterAdminNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[6]/div[1]/div[2]/input";
    public static String clusterNetworkAdminStartIPInput = "//div[@id=\"clusterAdminNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[6]/div[2]/div[2]/input";
    public static String clusterNetworkAdminSubnetMaskDropList = "//div[@id=\"clusterAdminNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[7]/div/div[2]/div/span";
    public static String clusterNetworkAdminSubnetMaskSearckField = "//input[@title=\"Search field\"]";
    public static String clusterNetworkAdminModifyMasksBtn = "//div[@id=\"clusterAdminNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[10]/div/button";
    public static String clusterNetworkAdminComputeNameMaskInput = "//input[@alt=\" Compute Name Mask\"]";
    public static String clusterNetworkAdminComputeNameStartIdInput = "//input[@alt=\"Compute Name Start Id\"]";
    public static String clusterNetworkAdminNetworkReviewAndEditCollapse = "//div[@id=\"clusterAdminNetworkCollapsible\"]/div/div/div/label[text()='Admin network Review and Edit']";
    public static String clusterNetworkAdminNetworkLookUpIPBtn = "//div[@id=\"clusterAdminNetworkCollapsible\"]/div/div/div/div/div/div/div[3]/button[@id=\"lookupAdminNetworkButton\"]";
    public static String clusterNetworkAdminNetworkEditUpdateBtn = "//div[@id=\"clusterAdminNetworkCollapsible\"]/div/div/div/div/div/div/div[3]/button[@id=\"adminReviewAndEdit\"]";
    public static String saveClusterNetworkAdminBtn = "//button[@id=\"saveClusterNetworkBtn_admin\"]";

    public static String clientNetworkCollapse = "//div[@id=\"clusterNetworkAccordionPage\"]/div/label[text()=\"Client Network\"]";
    public static String clientNetworkDefaultGatewayCheckBox = "//div[@id=\"clusterClientNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[3]/div/div/input[@alt=\"Default Gateway\"]";
    public static String clientNetworkDefaultHostnameCheckBox = "//div[@id=\"clusterClientNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[4]/div/div/input[@alt=\"Default Hostname\"]";
    public static String selectNetworkMediaSpeedDropList = "//label[contains(text(),'Select network media and speed')]/../../../following-sibling::div/div/div/div/span";
    public static String clientNetworkVlanInput = "//div[@id=\"clusterClientNetworkCollapsible\"]//label[contains(text(),'Vlan')]/../../following-sibling::div/input";
    public static String cnGatewayInput = "//div[@id=\"clusterClientNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[6]/div[1]/div[2]/input";
    public static String cnSubnetMaskDropList = "//div[@id=\"clusterClientNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[7]/div/div[2]/div/span";
    public static String cnSubnetMaskSearchField = "//input[@title=\"Search field\"]";
    public static String clientStartIPAddressInput = "//div[@id=\"clusterClientNetworkCollapsible\"]//div[@class=\"networkUiElements\"]/div/div[6]/div[2]/div[2]/input";
    public static String clientNetworkModifyMasksBtn = "//div[@id=\"clusterClientNetworkCollapsible\"]//span[text()='Modify Masks']";
    public static String saveClusterNetworkBtn = "//*[@id=\"saveClusterNetworkBtn_client\"]";

    // PrivateNetwork
    public static String privateNetworkCollapse  = "//div[@id=\"clusterNetworkAccordionPage\"]/div/label[text()=\"Private Network\"]";
    public static String privateNetworkStartIPAddressInput = "//div[@id=\"clusterPrivateNetworkCollapsible\"]//input[@alt=\"Start IP Address\"]";
    public static String savePrivateNetworkBtn = "//button[@id=\"saveClusterNetworkBtn_private\"]";

    // BackupNetwork
    public static String enableBackupNetworkBtn = "//label[contains(text(),'Enable Backup network')]";
    public static String sharedClientNetworkPortCheckBox = "//label[contains(text(), 'Shared client network port')]";
    public static String backupNetworkVlanInput = "//div[@id=\"clusterBackupNetworkCollapsible\"]//label[contains(text(),'Vlan')]/../../following-sibling::div/input";
    public static String backupNetworkGatewayInput = "//div[@id=\"clusterBackupNetworkCollapsible\"]//input[@alt=\"Gateway\"]";
    public static String backupNetworkStartIPAddressInput = "//div[@id=\"clusterBackupNetworkCollapsible\"]//input[@alt=\"Start IP Address\"]";
    public static String backupNetworkSubnetMaskDropList = "//div[@id=\"clusterBackupNetworkCollapsible\"]//label[contains(text(),'Subnet Mask')]/../../following-sibling::div/div/span";
    public static String backupNetworkSubnetMaskSearchField = "//input[@title=\"Search field\"]";
    public static String backupNetworkModifyMasksBtn = "//div[@id=\"clusterBackupNetworkCollapsible\"]//button[@title=\"Modify masks\"]";
    public static String backupNameInput = "//div[text()='Compute backup details']/../following-sibling::div[2]/div/div[2]/input";
    public static String backupStartIDInput = "//div[text()='Compute backup details']/../following-sibling::div[3]/div/div[2]/input";
    public static String backupDetailApplyBtn = "//div[text()='Compute backup details']/../../following-sibling::div/div[1]/button/div/span";
    public static String backupNetworkApplyBtn = "//button[@id=\"saveClusterNetworkBtn_backup\"]";
    public static String backupNetworkReviewAndEditCollapse = "//div[@id=\"clusterBackupNetworkReviewandEditCollapsible\"]/label";
    public static String backupNetworkLookupIPBtn = "//div[@id=\"clusterBackupNetworkReviewandEditCollapsible\"]//button[@id=\"lookupClientNetworkButton\"]";
    public static String backupNetworkIPUpdateBtn = "//div[@id=\"clusterBackupNetworkReviewandEditCollapsible\"]//button[@id=\"updateBackupNetwork\"]";

    /*
        Alerting
     */
    public static String submitAlertBtn = "//*[@id=\"submitAlertsButton\"]";

    /*
        Comments
     */

    public static String addCommnetsText = "//textarea[@id=\"esCommentTextArea\"]";
    public static String saveCommentsBtn = "//*[@id=\"saveCommentButton\"]";

    private static String inputAltXPath(String alt) {
        return "//input[@alt=\"" + alt + "\"]";
    }

}
