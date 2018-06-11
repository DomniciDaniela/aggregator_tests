package helpers.utility;


import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ConfigLoad {

    public static class ConfigLoadVariables {

        // Environment  Variables
        public static String TEST_ENVIRONMENT = null;
        public static String WEB_APP_ENVIRONMENT = null;
        public static String IS_DEV = null;
        public static String DEV_ENVIRONMENT = null;
        public static String WEB_DEV_ENVIRONMENT = null;
        public static String BROWSER = null;
    }

    public static void loadConfig(WebDriver driver, Integer iRecordNumber) throws Exception {

        //Re-Initialise the data array
        ArrayList<String> DataArray = DataArrayPool.DataArray("TestConfig").get(iRecordNumber);

        ConfigLoadVariables.TEST_ENVIRONMENT = DataArray.get(0);
        ConfigLoadVariables.WEB_APP_ENVIRONMENT = DataArray.get(1);
        ConfigLoadVariables.IS_DEV = DataArray.get(2);
        ConfigLoadVariables.DEV_ENVIRONMENT = DataArray.get(3);
        ConfigLoadVariables.WEB_DEV_ENVIRONMENT = DataArray.get(4);
        ConfigLoadVariables.BROWSER = DataArray.get(5);
    }

}
