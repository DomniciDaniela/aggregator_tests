package helpers.utility;


import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class MotorAggregatorDataLoad {

    public static class DataLoadVariables {

        // GoCompare Motor Variables
        public static String aggId = null;
        public static String brand = null;
        public static String policy = null;
        public static String currentInsurer = null;
        public static String insuranceDeclined = null;
        public static String prefPayMethCd = null;
        public static String covTypCd = null;
        public static String volXSCd = null;
        public static String ncdProtect = null;
        public static String numChildCd = null;
        public static String useOfOtherVehicleCd = null;
        public static String drvRestrictCd = null;
        public static String vehicleNums = null;
        public static String abiCd = null;
        public static String annMileCd = null;
        public static String annBusMiles = null;
        public static String daySituCd = null;
        public static String nightSituCd = null;
        public static String isEstValRaw = null;
        public static String notPurchasedYet = null;
        public static String purchaseDate = null;
        public static String estVal = null;
        public static String regDate = null;
        public static String vrm = null;
        public static String postCodeOut = null;
        public static String postCodeIn = null;
        public static String usage = null;
        public static String secDevice = null;
        public static String trackDevice = null;
        public static String isImport = null;
        public static String regKeeperCd = null;
        public static String legalOwnerCd = null;

        public static String driverTitle = null;
        public static String driverFirstName = null;
        public static String driverLastName = null;
        public static String driverDateOfBirth = null;
        public static String driverGender = null;
        public static String occCd = null;
        public static String occDesc = null;
        public static String resStatusCd = null;
        public static String eveningNum = null;
        public static String daytimeNum = null;
        public static String emailAddress = null;
        public static String maritalCd = null;
        public static String ncdYrs = null;
        public static String relationCd = null;

        public static String typCd = null;
        public static String testPassedMonth = null;
        public static String testPassedYear = null;
        public static String licRestrictCd = null;
        public static String livedUkMonth = null;
        public static String livedUkYear = null;
        public static String requireDoc = null;
        public static String hasNonMotConv = null;
        public static String isHomeOwner = null;
        public static String hasChildUnder16 = null;
        public static String houseNumber = null;
        public static String streetName = null;
        public static String town = null;
        public static String county = null;
    }

    public static void loadData(WebDriver driver, Integer iRecordNumber) throws Exception {

        //Re-Initialise the data array
        ArrayList<String> DataArray = DataArrayPool.DataArray("GoCompareMotorAggregator").get(iRecordNumber);

        // Home Aggregator Details
        MotorAggregatorDataLoad.DataLoadVariables.aggId = DataArray.get(0);
        MotorAggregatorDataLoad.DataLoadVariables.brand = DataArray.get(1);
        MotorAggregatorDataLoad.DataLoadVariables.policy = DataArray.get(2);
        MotorAggregatorDataLoad.DataLoadVariables.currentInsurer = DataArray.get(3);
        MotorAggregatorDataLoad.DataLoadVariables.insuranceDeclined = DataArray.get(4);
        MotorAggregatorDataLoad.DataLoadVariables.prefPayMethCd = DataArray.get(5);
        MotorAggregatorDataLoad.DataLoadVariables.covTypCd = DataArray.get(6);

        MotorAggregatorDataLoad.DataLoadVariables.volXSCd = DataArray.get(7);
        MotorAggregatorDataLoad.DataLoadVariables.ncdProtect = DataArray.get(8);
        MotorAggregatorDataLoad.DataLoadVariables.numChildCd = DataArray.get(9);
        MotorAggregatorDataLoad.DataLoadVariables.useOfOtherVehicleCd = DataArray.get(10);
        MotorAggregatorDataLoad.DataLoadVariables.drvRestrictCd = DataArray.get(11);
        MotorAggregatorDataLoad.DataLoadVariables.vehicleNums = DataArray.get(12);
        MotorAggregatorDataLoad.DataLoadVariables.abiCd = DataArray.get(13);

        MotorAggregatorDataLoad.DataLoadVariables.annMileCd = DataArray.get(14);
        MotorAggregatorDataLoad.DataLoadVariables.annBusMiles = DataArray.get(15);
        MotorAggregatorDataLoad.DataLoadVariables.daySituCd = DataArray.get(16);
        MotorAggregatorDataLoad.DataLoadVariables.nightSituCd = DataArray.get(17);
        MotorAggregatorDataLoad.DataLoadVariables.isEstValRaw = DataArray.get(18);
        MotorAggregatorDataLoad.DataLoadVariables.notPurchasedYet = DataArray.get(19);
        MotorAggregatorDataLoad.DataLoadVariables.purchaseDate = DataArray.get(20);
        MotorAggregatorDataLoad.DataLoadVariables.estVal = DataArray.get(21);

        MotorAggregatorDataLoad.DataLoadVariables.regDate = DataArray.get(22);
        MotorAggregatorDataLoad.DataLoadVariables.vrm = DataArray.get(23);
        MotorAggregatorDataLoad.DataLoadVariables.postCodeOut = DataArray.get(24);
        MotorAggregatorDataLoad.DataLoadVariables.postCodeIn = DataArray.get(25);
        MotorAggregatorDataLoad.DataLoadVariables.usage = DataArray.get(26);
        MotorAggregatorDataLoad.DataLoadVariables.secDevice = DataArray.get(27);
        MotorAggregatorDataLoad.DataLoadVariables.trackDevice = DataArray.get(28);
        MotorAggregatorDataLoad.DataLoadVariables.isImport = DataArray.get(29);
        MotorAggregatorDataLoad.DataLoadVariables.regKeeperCd = DataArray.get(30);
        MotorAggregatorDataLoad.DataLoadVariables.legalOwnerCd = DataArray.get(31);

        MotorAggregatorDataLoad.DataLoadVariables.driverTitle = DataArray.get(32);
        MotorAggregatorDataLoad.DataLoadVariables.driverFirstName = DataArray.get(33);
        MotorAggregatorDataLoad.DataLoadVariables.driverLastName = DataArray.get(34);
        MotorAggregatorDataLoad.DataLoadVariables.driverDateOfBirth = DataArray.get(35);
        MotorAggregatorDataLoad.DataLoadVariables.driverGender = DataArray.get(36);
        MotorAggregatorDataLoad.DataLoadVariables.occCd = DataArray.get(37);
        MotorAggregatorDataLoad.DataLoadVariables.occDesc = DataArray.get(38);
        MotorAggregatorDataLoad.DataLoadVariables.resStatusCd = DataArray.get(39);
        MotorAggregatorDataLoad.DataLoadVariables.eveningNum = DataArray.get(40);
        MotorAggregatorDataLoad.DataLoadVariables.daytimeNum = DataArray.get(41);
        MotorAggregatorDataLoad.DataLoadVariables.emailAddress = DataArray.get(42);
        MotorAggregatorDataLoad.DataLoadVariables.maritalCd = DataArray.get(43);
        MotorAggregatorDataLoad.DataLoadVariables.ncdYrs = DataArray.get(44);
        MotorAggregatorDataLoad.DataLoadVariables.relationCd = DataArray.get(45);
        MotorAggregatorDataLoad.DataLoadVariables.typCd = DataArray.get(46);
        MotorAggregatorDataLoad.DataLoadVariables.testPassedMonth = DataArray.get(47);
        MotorAggregatorDataLoad.DataLoadVariables.testPassedYear = DataArray.get(48);
        MotorAggregatorDataLoad.DataLoadVariables.licRestrictCd = DataArray.get(49);
        MotorAggregatorDataLoad.DataLoadVariables.livedUkMonth = DataArray.get(50);
        MotorAggregatorDataLoad.DataLoadVariables.livedUkYear = DataArray.get(51);
        MotorAggregatorDataLoad.DataLoadVariables.requireDoc = DataArray.get(52);
        MotorAggregatorDataLoad.DataLoadVariables.hasNonMotConv = DataArray.get(53);
        MotorAggregatorDataLoad.DataLoadVariables.isHomeOwner = DataArray.get(54);
        MotorAggregatorDataLoad.DataLoadVariables.hasChildUnder16 = DataArray.get(55);
        MotorAggregatorDataLoad.DataLoadVariables.houseNumber = DataArray.get(56);
        MotorAggregatorDataLoad.DataLoadVariables.streetName = DataArray.get(57);
        MotorAggregatorDataLoad.DataLoadVariables.town = DataArray.get(58);
        MotorAggregatorDataLoad.DataLoadVariables.county = DataArray.get(59);
    }

}
