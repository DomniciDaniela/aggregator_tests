package helpers.utility;


import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class HomeAggregatorDataLoad {

    public static class DataLoadVariables {

        // Confused Home Cariables
        public static String aggId = null;
        public static String brand = null;
        public static String specialTermsFlag = null;
        public static String convictionPendFlag = null;
        public static String repairStateFlag = null;
        public static String holidayHomeFlag = null;
        public static String unoccupiedFlag = null;
        public static String floodFlag = null;
        public static String subsidenceFlag = null;
        public static String listedFlag = null;
        public static String businessFlag = null;
        public static String treeDamageFlag = null;
        public static String tallTreeNearbyFlag = null;
        public static String buildingInProgressFlag = null;
        public static String prevInsBldCd = null;
        public static String rebuildingValue = null;
        public static String yearsBldInsWithoutClaim = null;
        public static String propertyValue = null;
        public static String prevInsConCd = null;
        public static String forSaleFlag = null;
        public static String bankruptFlag = null;
        public static String smokersFlag = null;
        public static String nWatchAreaFlag = null;
        public static String nWatchMemberFlag = null;
        public static String burglarAlarmCd = null;
        public static String alarmProfessionalFlag = null;
        public static String alarmPoliceFlag = null;
        public static String jointPropBankruptFlag = null;
        public static String occupiedByFamilyFlag = null;
        public static String selfContainedFlag = null;
        public static String coverLevel = null;
        public static String ncdProtect = null;
        public static String ncdYrs = null;
        public static String sumIns = null;
        public static String volXs = null;
        public static String insuranceDeclined = null;
        public static String currentInsurer = null;
        public static String yearsCurrentInsurer = null;
        public static String houseNumber = null;
        public static String streetName = null;
        public static String town = null;
        public static String county = null;
        public static String postCodeOut = null;
        public static String postCodeIn = null;
        public static String firstTimeBuyer = null;
        public static String locks = null;
        public static String nacoss = null;
        public static String bedsCd = null;
        public static String addRoomsCd = null;
        public static String numAdultCd = null;
        public static String numChildCd = null;
        public static String ownCd = null;
        public static String propCd = null;
        public static String roofCd = null;
        public static String wallCd = null;
        public static String builtCd = null;
        public static String currentMortgageProvider = null;
        public static String proposerTitle = null;
        public static String proposerFirstName = null;
        public static String proposerLastName = null;
        public static String proposerDateOfBirth = null;
        public static String proposerGender = null;
        public static String occCd = null;
        public static String occDesc = null;
        public static String eveningNum = null;
        public static String daytimeNum = null;
        public static String emailAddress = null;
        public static String maritalCd = null;
        public static String relationCd = null;
        public static String livedUkMonth = null;
        public static String livedUkYear = null;
        public static String isHomeOwner = null;
        public static String yearsAtRiskAddress = null;
        public static String buildVarFlag = null;
        public static String buildingsFlag = null;
        public static String contentsFlag = null;
        public static String emergencyFlag = null;
        public static String flpFlag = null;
        public static String persPossFlag = null;
        public static String pestFlag = null;
        public static String specifiedItemsFlag = null;
    }

    public static void loadData(WebDriver driver, Integer iRecordNumber) throws Exception {

        //Re-Initialise the data array
        ArrayList<String> DataArray = DataArrayPool.DataArray("ConfusedHomeAggregator").get(iRecordNumber);

        // Home Aggregator Details
        DataLoadVariables.aggId = DataArray.get(0);
        DataLoadVariables.brand = DataArray.get(1);
        DataLoadVariables.specialTermsFlag = DataArray.get(2);
        DataLoadVariables.convictionPendFlag = DataArray.get(3);
        DataLoadVariables.repairStateFlag = DataArray.get(4);
        DataLoadVariables.holidayHomeFlag = DataArray.get(5);
        DataLoadVariables.unoccupiedFlag = DataArray.get(6);

        DataLoadVariables.floodFlag = DataArray.get(7);
        DataLoadVariables.subsidenceFlag = DataArray.get(8);
        DataLoadVariables.listedFlag = DataArray.get(9);
        DataLoadVariables.businessFlag = DataArray.get(10);
        DataLoadVariables.treeDamageFlag = DataArray.get(11);
        DataLoadVariables.tallTreeNearbyFlag = DataArray.get(12);
        DataLoadVariables.buildingInProgressFlag = DataArray.get(13);

        DataLoadVariables.prevInsBldCd = DataArray.get(14);
        DataLoadVariables.rebuildingValue = DataArray.get(15);
        DataLoadVariables.yearsBldInsWithoutClaim = DataArray.get(16);
        DataLoadVariables.propertyValue = DataArray.get(17);
        DataLoadVariables.prevInsConCd = DataArray.get(18);
        DataLoadVariables.forSaleFlag = DataArray.get(19);
        DataLoadVariables.bankruptFlag = DataArray.get(20);
        DataLoadVariables.smokersFlag = DataArray.get(21);

        DataLoadVariables.nWatchAreaFlag = DataArray.get(22);
        DataLoadVariables.nWatchMemberFlag = DataArray.get(23);
        DataLoadVariables.burglarAlarmCd = DataArray.get(24);
        DataLoadVariables.alarmProfessionalFlag = DataArray.get(25);
        DataLoadVariables.alarmPoliceFlag = DataArray.get(26);
        DataLoadVariables.jointPropBankruptFlag = DataArray.get(27);
        DataLoadVariables.occupiedByFamilyFlag = DataArray.get(28);
        DataLoadVariables.selfContainedFlag = DataArray.get(29);
        DataLoadVariables.coverLevel = DataArray.get(30);
        DataLoadVariables.ncdProtect = DataArray.get(31);
        DataLoadVariables.ncdYrs = DataArray.get(32);
        DataLoadVariables.sumIns = DataArray.get(33);
        DataLoadVariables.volXs = DataArray.get(34);
        DataLoadVariables.insuranceDeclined = DataArray.get(35);
        DataLoadVariables.currentInsurer = DataArray.get(36);
        DataLoadVariables.yearsCurrentInsurer = DataArray.get(37);
        DataLoadVariables.houseNumber = DataArray.get(38);
        DataLoadVariables.streetName = DataArray.get(39);
        DataLoadVariables.town = DataArray.get(40);
        DataLoadVariables.county = DataArray.get(41);
        DataLoadVariables.postCodeOut = DataArray.get(42);
        DataLoadVariables.postCodeIn = DataArray.get(43);
        DataLoadVariables.firstTimeBuyer = DataArray.get(44);
        DataLoadVariables.locks = DataArray.get(45);
        DataLoadVariables.nacoss = DataArray.get(46);
        DataLoadVariables.bedsCd = DataArray.get(47);
        DataLoadVariables.addRoomsCd = DataArray.get(48);
        DataLoadVariables.numAdultCd = DataArray.get(49);
        DataLoadVariables.numChildCd = DataArray.get(50);
        DataLoadVariables.ownCd = DataArray.get(51);
        DataLoadVariables.propCd = DataArray.get(52);
        DataLoadVariables.roofCd = DataArray.get(53);
        DataLoadVariables.wallCd = DataArray.get(54);
        DataLoadVariables.builtCd = DataArray.get(55);
        DataLoadVariables.currentMortgageProvider = DataArray.get(56);
        DataLoadVariables.proposerTitle = DataArray.get(57);
        DataLoadVariables.proposerFirstName = DataArray.get(58);
        DataLoadVariables.proposerLastName = DataArray.get(58);
        DataLoadVariables.proposerDateOfBirth = DataArray.get(60);
        DataLoadVariables.proposerGender = DataArray.get(61);
        DataLoadVariables.occCd = DataArray.get(62);
        DataLoadVariables.occDesc = DataArray.get(63);
        DataLoadVariables.eveningNum = DataArray.get(64);
        DataLoadVariables.daytimeNum = DataArray.get(65);
        DataLoadVariables.emailAddress = DataArray.get(66);
        DataLoadVariables.maritalCd = DataArray.get(67);
        DataLoadVariables.relationCd = DataArray.get(68);
        DataLoadVariables.livedUkMonth = DataArray.get(69);
        DataLoadVariables.livedUkYear = DataArray.get(70);
        DataLoadVariables.isHomeOwner = DataArray.get(71);
        DataLoadVariables.yearsAtRiskAddress = DataArray.get(72);
        DataLoadVariables.buildVarFlag = DataArray.get(73);
        DataLoadVariables.buildingsFlag = DataArray.get(74);
        DataLoadVariables.contentsFlag = DataArray.get(75);
        DataLoadVariables.emergencyFlag = DataArray.get(76);
        DataLoadVariables.flpFlag = DataArray.get(77);
        DataLoadVariables.persPossFlag = DataArray.get(78);
        DataLoadVariables.pestFlag = DataArray.get(79);
        DataLoadVariables.specifiedItemsFlag = DataArray.get(80);
    }

}
