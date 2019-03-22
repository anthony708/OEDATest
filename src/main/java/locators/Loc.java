package locators;

public class Loc {

    // Navigation
    public static String hardwareItem = spanClassXPath("Hardware");
    public static String rackNetworksItem = spanClassXPath("Rack Networks");

    public static String exadbmIcon = "//input[@id=\"exaopt\"]";
    public static String zdlraIcon = "//input[@id=\"zdlraopt\"]";
    public static String exacIcon = "//input[@id=\"cloudopt\"]";

    public static String computeNodeDropList = spanIdXPath("ojChoiceId_selectExaCompNode_selected");
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

    public static String rackSizeDropList = spanIdXPath("ojChoiceId_selectRackSize_selected");
    public static String rackSizeElastic = "/div[contains(text(),'Elastic')]";
    public static String rackSizeFull = "/div[contains(text(),'Full')]";

    public static String diskSizeDropList = spanIdXPath("ojChoiceId_selectCellServerCapacity_selected");
    public static String diskSizeHC10TB = "//div[@class='oj-listbox-result-label' and contains(text(),'HC 10TB')]";
    public static String diskSizeEF64TB = "//div[@class='oj-listbox-result-label' and contains(text(),'EF 6.4TB')]";

    public static String addBtn = "//button[@id=\"addRackBtn\"]";

    public static String rackPrefixText = inputAltXPath("Rack Prefix");
    public static String spineSwitchCheckbox = inputAltXPath("Spine Switch");
    public static String customerNameText = inputAltXPath("Customer Name");
    public static String appSerialNumText = inputAltXPath("Application/Serial #");

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
    //public static String timezoneSearchField = "//input[@class=\"oj-listbox-input\"]";
    public static String timezoneSearchBtn = "//span[@class=\"oj-listbox-spyglass-box\"]";

    public static String computeNodeCountText = inputAltXPath("Compute Node count");
    public static String storageNodeCountText = inputAltXPath("Storage Node count");
    public static String DNSServers1Text = "//div[@class='oj-label-group']/label[contains(text(), 'DNS Servers')]/../../following-sibling::div/input[@alt='DNS Servers']";
    public static String DNSServers2Text = "//div[@class='oj-label-group']/label[contains(text(), 'DNS Servers')]/../../../following-sibling::div[1]/div/input[@alt='DNS Servers']";
    public static String DNSServers3Text = "//div[@class='oj-label-group']/label[contains(text(), 'DNS Servers')]/../../../following-sibling::div[2]/div/input[@alt='DNS Servers']";
    public static String NTPServers1Text = "//div[@class='oj-label-group']/label[contains(text(), 'NTP Servers')]/../../following-sibling::div/input[@alt='NTP Servers']";
    public static String NTPServers2Text = "//div[@class='oj-label-group']/label[contains(text(), 'NTP Servers')]/../../../following-sibling::div[1]/div/input[@alt='NTP Servers']";
    public static String NTPServers3Text = "//div[@class='oj-label-group']/label[contains(text(), 'NTP Servers')]/../../../following-sibling::div[2]/div/input[@alt='NTP Servers']";

    public static String automcticWBFCIcon = "//input[@value=\"automatic\"]";
    public static String disableWBFCIcon = "//input[@value=\"disable\"]";
    public static String enableWBFCIcon = "//input[@value=\"enable\"]";

    //public static String enableCoDCheckbox =

    public static String applyBtn = "//button[@id=\"rackSelectNextButton\"]";
    public static String comfirmedBtn = "// button[@id=\"codConfirmButton\"]";

    public static String spanIdXPath(String id) {
        return "//span[@id=\"" + id + "\"]";
    }

    public static String spanClassXPath(String classname) {
        return "//span[@class=\"" + classname + "\"]";
    }

    public static String inputAltXPath(String alt) {
        return "//input[@alt=\"" + alt + "\"]";
    }

}
