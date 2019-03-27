package locators;

public class Loc {

    // Navigation
    public static String hardwareItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Hardware')]";
    public static String rackNetworksItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Rack Networks')]";
    public static String operatingSystemItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Operating System')]";
    public static String usersItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Users')]";
    public static String clustersItem = "//span[@class=\"oj-navigationlist-item-label\" and contains(text(), 'Clusters')]";

    /*
        Hardware
     */
    public static String exadbmIcon = "//input[@id=\"exaopt\"]";
    public static String zdlraIcon = "//input[@id=\"zdlraopt\"]";
    public static String exacIcon = "//input[@id=\"cloudopt\"]";

    public static String computeNodeDropList = "//*[@id=\"ojChoiceId_selectExaCompNode_selected\"]";
    //public static String computeNodeSearchField = "//input[@class=\"oj-listbox-input\"]";
    public static String computeNodeX7_2RoCE = "//div[@class='oj-listbox-result-label' and contains(text(),'X7-2 RoCE')]";
    public static String computeNodeX7_8RoCE = "//div[@class='oj-listbox-result-label' and contains(text(),'X7-8 RoCE')]";
    public static String computeNodeX7_2 = "//div[@class='oj-listbox-result-label' and @aria-label='X7-2']";
    public static String computeNodeX7_8 = "//div[@class='oj-listbox-result-label' and @aria-label='X7-8']";
    public static String computeNodeX6_2 = "//div[@class='oj-listbox-result-label' and @aria-label='X6-2']";
    public static String computeNodeX6_8 = "//div[@class='oj-listbox-result-label' and @aria-label='X6-8']";
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

    public static String addBtn = "//button[@id=\"addRackBtn\"]";

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
    public static String gateWayCheckBox = "//input[@alt='Default Gateway']";
    public static String gateWayInput = inputAltXPath("Gateway");
    public static String anStartIPAddress = inputAltXPath("Start IP");

    public static String anSubnetMaskDropList = "//label[contains(text(),'Subnet Mask')]/../../following-sibling::div/div";

    public static String anSubnetMaskSearchField = "/html/body/div[1]/div/div/div/div/input";
    public static String anSubnetMask2552552400 = "//div[@aria-label='255.255.240.0']";

    public static String anDomainNameInput = "//input[@alt=\"Domain Name\"]";

    public static String seperateILOMNwCheckBox = "//input[@title='Separate ILOM network']";
    public static String anModifyMasksBtn = "//*[@id=\"buttonOpener\"]";
    public static String adminNetworkApplyBtn = "//*[@id=\"saveRackNetworksButtonAdmin\"]";

    public static String pnStartIPAddress = "//label[contains(text(),'Start IP Address')]/../../following-sibling::div/input[@alt=\"Start IP Address\"]";
    //public static String pnSubnetMaskDropList = "";
    public static String pnSubnetMaskSearchField = "";
    public static String pnSubnetMask2552552480 = "";
    //public static String pnDomainNameInput = "";
    public static String privateNetworkApplyBtn = "//*[@id=\"saveRackNetworksButtonPrivate\"]";

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

    private static String inputAltXPath(String alt) {
        return "//input[@alt=\"" + alt + "\"]";
    }

}
