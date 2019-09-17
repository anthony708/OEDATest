package oracle.onecommand.tests.webUi.seleniumTests;

import com.google.gson.Gson;
import oracle.onecommand.escommon.model.NetworkPool;
import oracle.onecommand.tests.webUi.common.WebUIFields;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OEDAJsonInputTestHelper {
    private WebDriver driver;

    static final String jsonPath = "/Users/zhuduan/Documents/Projects/OEDAJsonInputTest/Scaqae03-ovmpkeyvlan-Web-scaqae03.json";

    public static WebUIFields parseJson(String jsonPath) throws Exception {
        File jsonFile = new File(jsonPath);
        if (!jsonFile.exists()) {
            System.out.println("File not exist.");
            return null;
        }
        BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
        Gson gson = new Gson();
        return gson.fromJson(reader, WebUIFields.class);
    }

    // OS
    public static String getOsTypeXpath(String jsonPath) throws Exception {
        WebUIFields webUIFields = parseJson(jsonPath);
        return "//div[@class='oj-listbox-result-label' and @aria-label='" + webUIFields.getOs().getOsType() + "']";
    }

    // Hardware
    public static String getComputeNodeFamilyXpath(String jsonPath, String computeNode) throws Exception {
        WebUIFields webUIFields = parseJson(jsonPath);
        return "//div[@class='oj-listbox-result-label' and @aria-label='" + computeNode + "']";
    }

    public static String getRackSizeXpath(String jsonPath) throws Exception {
        WebUIFields webUIFields = parseJson(jsonPath);
        return "//div[@class='oj-listbox-result-label' and text()=\"" + webUIFields.getHardware().getRacks().get(0).getRackSize() + "\"]";
    }

    public static String getDiskSizeXpath(String jsonPath) throws Exception {
        WebUIFields webUIFields = parseJson(jsonPath);
        return "//div[@class='oj-listbox-result-label' and contains(text(),'" + webUIFields.getHardware().getRacks().get(0).getDiskSize() +"')]";
    }

    public static String getSubnetMaskXpath(String jsonPath) throws Exception {
        WebUIFields webUIFields = parseJson(jsonPath);
        return "//span[contains(text(),'" + webUIFields.getClusterNetworks().getClusterNetworkList().get(0).getClientNetwork().getSubnetMask() + "']";
    }

    public static int getDiskgroupSize(String jsonPath) throws Exception {
        return parseJson(jsonPath).getDiskgroups().getClusters().getCluster().get(0).getDiskGroups().getDiskGroup().size();
    }

    public static Map<Integer,String> diskgroupNameMap(String jsonPath) throws Exception {
        Map<Integer, String> diskgroupMap = new HashMap<Integer, String>();
        int diskgroupSize = getDiskgroupSize(jsonPath);
        for (int i = 0; i < diskgroupSize; i++) {
            diskgroupMap.put(i, parseJson(jsonPath).getDiskgroups().getClusters().getCluster().get(0).getDiskGroups().getDiskGroup().get(i).getDiskGroupName());
        }
        return diskgroupMap;
    }

    public static String userGroupRadioBtnXpath(int userGroupNum, String userGroupCollectionType) {
        String userGroupType = "";
        if (userGroupCollectionType.equals("default")) {
            userGroupType = "Default";
        } else if (userGroupCollectionType.equals("rolesep")) {
            userGroupType = "Role Separated";
        } else if (userGroupCollectionType.equals("custom")) {
            userGroupType = "Custom";
        }
        userGroupNum += 1;
        return "//div[@id=\"usergroup-container\"]/div[" + userGroupNum + "]/div/div/div[1]/div/div/span/span/input[@alt=\"" + userGroupType + " radio button\"]";

    }

    public static String defineClusterTabXpath(String clusterName) {
        return "//div[@id=\"defineClusterTabs\"]//span[text()='" + clusterName + "']";
    }

    public static String diskgroupsTabXpath(String clusterName) {
        return "//div[@id=\"DgClusterLayoutTab\"]//span[text()='" + clusterName + "']";
    }

    public static String dbHomeTabXpath(String dbHomeName) {
        return "//div[@id=\"defineDatabaseHomeTabs\"]//span[text()='" + dbHomeName + "']";
    }

    public static String dbHomeTypeXpath(String dbHomeType) {
        if (dbHomeType.equals("rac_database")) {
            return "//input[@alt=\"RAC Home\"]";
        } else if (dbHomeType.equals("single_instance_database")) {
            return "//input[@alt=\"Single Instance Home\"]";
        }
        return null;
    }

    public static String databaseTabXpath(String databaseName) {
        return "//div[@id=\"defineDatabaseTabs\"]//span[text()='" + databaseName + "']";
    }

    public static String adminNetworkClusterTab(int i) {
        return "//div[@id=\"clusterNwLayoutTab_admin\"]//span[text()='Cluster-c" + i + "']";
    }

    public static String clientNetowrkClusterTab(int i) {
        return "//div[@id=\"clusterNwLayoutTab_client\"]//span[text()='Cluster-c" + i + "']";
    }

    public static String privateNetworkClusterTab(int i) {
        return "//div[@id=\"clusterNwLayoutTab_private\"]//span[text()='Cluster-c" + i + "']";
    }

    public static String backupNetworkClusterTab(int i) {
        return "//div[@id=\"clusterNwLayoutTab_backup\"]//span[text()='Cluster-c" + i + "']";
    }

    public static void main(String[] args) throws Exception {

        WebUIFields webUIFields = parseJson(jsonPath);

        List<NetworkPool> privateNetworkList = parseJson(jsonPath).getClusterNetworks().getClusterNetworkList().get(0).getPrivateNetworks();
    }
}
