package helpers.utility;


import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class CardDetailsDataLoad {

    public static class DataLoadVariables {
        // Card Details Variables
        public static String sType = null;
        public static String sCardOwner = null;
        public static String sCardNumber = null;
        public static String sExpiryMonth = null;
        public static String sExpiryYear = null;
        public static String sSecurityCode = null;
    }

    public static void loadData(WebDriver driver, Integer iRecordNumber) throws Exception {

        //Re-Initialise the data array
        ArrayList<String> DataArray = DataArrayPool.DataArray("CardDetails").get(iRecordNumber);

        // Card Details
        DataLoadVariables.sType = DataArray.get(0);
        DataLoadVariables.sCardOwner = DataArray.get(1);
        DataLoadVariables.sCardNumber = DataArray.get(2);
        DataLoadVariables.sExpiryMonth = DataArray.get(3);
        DataLoadVariables.sExpiryYear = DataArray.get(4);
        DataLoadVariables.sSecurityCode = DataArray.get(5);
    }

}
