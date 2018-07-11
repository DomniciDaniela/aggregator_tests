package helpers;

import helpers.utility.ConfigLoad;

public class TestDataUtils {

    public static class Aggregators {
        public static final String ESURE = "https://etst" + ConfigLoad.ConfigLoadVariables.WEB_APP_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";
        public static final String FA = "https://ftst" + ConfigLoad.ConfigLoadVariables.WEB_APP_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";
        public static final String SW = "https://ltst"  + ConfigLoad.ConfigLoadVariables.WEB_APP_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";

        public static final String ESURE_DEV = "https://edev" + ConfigLoad.ConfigLoadVariables.WEB_DEV_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";
        public static final String FA_DEV = "https://fdev" + ConfigLoad.ConfigLoadVariables.WEB_DEV_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";
        public static final String SW_DEV = "https://ldev"  + ConfigLoad.ConfigLoadVariables.WEB_DEV_ENVIRONMENT + ".es-dte.co.uk/testlink.jsp";
    }

    public static class AuthorizationCredentials {
        public static final String BASIC_AUTHORIZATION = "Basic ZXN1cmVfdXNlcjplNXVyZV91NWVy";
    }

    public static class Brands {
        public static final String ESURE_HOME = "EH";
        public static final String ESURE_MOTOR = "EM";
        public static final String SW_MOTOR= "SW";
    }

    public static class Flags {
        public static final String YES = "Y";
    }

    public static class Other {
        public static final String OTHER = "Other";
        public static final String POLICY_NUMBER = "123";
    }

    public static class PageURLs {
        public static final String BREAKDOWN_OPTIONS = "breakdownOptions.xhtml";
        public static final String CARD_DETAILS = "cardInformation.xhtml";
        public static final String DIRECT_DEBIT = "directDebitInformation.xhtml";
        public static final String MORE_DETAILS_ABOUT_YOUR_COVER = "moreDetailsAboutYourCover.xhtml";
        public static final String PAYMENT_CONFIRMATION = "paymentConfirmation.xhtml";
        public static final String PAYMENT_OPTIONS = "paymentOptions.xhtml";
        public static final String QUOTE_DETAILS = "quoteDetails.xhtml";
        public static final String YOUR_JOINT_POLICY_HOLDER = "yourJointPolicyholder.xhtml";
        public static final String YOUR_QUOTE = "yourQuote.xhtml";
    }

    public static class SoapAssertions {
        public static final String AGGEGATOR_REQUEST = "java:com.esure.busservices.cdm.aggregator.request";
        public static final String SOA_IBISSERVICE = "http://www.esure.com/SOA/ibisservice";
        public static final String SCHEMA_INSTANCE = "http://www.w3.org/2001/XMLSchema-instance";
        public static final String SOAP_ENCODING = "http://schemas.xmlsoap.org/soap/encoding/";
        public static final String SOAP_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    }

    public static class SoapBody {
        public static final String ABI_CD = "abiCd";
        public static final String ADDRESS = "address";
        public static final String ADD_ROOMS_CD = "addRoomsCd";
        public static final String AGG_ID = "aggId";
        public static final String ALARM_POLICE = "alarmPoliceFlag";
        public static final String ALARM_PROFESSIONAL = "alarmProfessionalFlag";
        public static final String ANNUAL_BUS_MILE = "annBusMiles";
        public static final String ANNUAL_MILE = "annMileCd";
        public static final String ASSUMPTIONS = "assumptions";
        public static final String BANKRUPT_FLAG = "bankruptFlag";
        public static final String BEDS_CD = "bedsCd";
        public static final String BRAND = "brand";
        public static final String BRANDS = "brands";
        public static final String BUILDINGS = "buildings";
        public static final String BUILDINGS_FLAG = "buildingsFlag";
        public static final String BUILD_VAR_FLAG = "buildVarFlag";
        public static final String BUILDING_IN_PROGRESS_FLAG = "buildingInProgressFlag";
        public static final String BUILT_CD = "builtCd";
        public static final String BURGLAR_ALARM_CD = "burglarAlarmCd";
        public static final String BUSINESS_FLAG = "businessFlag";
        public static final String CHILD_UNDER_16 = "hasChildUnder16";
        public static final String CLAIMS = "claims";
        public static final String CONTENTS_FLAG = "contentsFlag";
        public static final String CONVICTION_PEND_FLAG = "convictionPendFlag";
        public static final String COV_TYP_CD = "covTypCd";
        public static final String COVER_LEVEL = "coverLevel";
        public static final String COUNTY = "county";
        public static final String CURRENT_INSURER = "currentInsurer";
        public static final String CURRENT_MORTGAGE_PROVIDER = "currentMortgageProvider";
        public static final String DAY_SITU = "daySituCd";
        public static final String DAYTIME_NUM = "daytimeNum";
        public static final String DOB = "dob";
        public static final String DRIVER = "driver";
        public static final String DRIVERS = "drivers";
        public static final String DRV_RESTRICT = "drvRestrictCd";
        public static final String EMAIL = "emailAddress";
        public static final String EMERGENCY_FLAG = "emergencyFlag";
        public static final String EST_VAL = "estVal";
        public static final String EVENING_NUM = "eveningNum";
        public static final String FIRST_NAME = "firstName";
        public static final String FIRST_TIME_BUYER = "firstTimeBuyer";
        public static final String FLOOD_FLAG = "floodFlag";
        public static final String FLP_FLAG = "flpFlag";
        public static final String FOR_SALE_FLAG = "forSaleFlag";
        public static final String GENDER = "sex";
        public static final String GET_AGG_HOME = "getAggHomeQuote";
        public static final String GET_AGG_MOTOR = "getAggMotorQuote";
        public static final String HAS_MON_MOT_CONV = "hasNonMotConv";
        public static final String HOLIDAY_HOME_FLAG = "holidayHomeFlag";
        public static final String HOME_REQUEST = "homeRequest";
        public static final String HOUSE_NAME = "houseName";
        public static final String HOUSE_NUMBER = "houseNumber";
        public static final String INSURANCE_DECLINED = "insuranceDeclined";
        public static final String IS_EST_VAL = "isEstValRaw";
        public static final String IS_HOME_OWNER = "isHomeOwner";
        public static final String IS_IMPORT = "isImport";
        public static final String JOINT_PROP_BANKRUPT = "jointPropBankruptFlag";
        public static final String LAST_NAME = "lastName";
        public static final String LEGAL_OWNER = "legalOwnerCd";
        public static final String LICENSE = "license";
        public static final String LIC_RESTRICTED_CD = "licRestrictCd";
        public static final String LISTED_FLAG = "listedFlag";
        public static final String LIVED_UK_MONTH = "livedUkMonth";
        public static final String LIVED_UK_YEAR = "livedUkYear";
        public static final String LOCKS = "locks";
        public static final String MARITAL_CD = "maritalCd";
        public static final String MOTOR_COV = "motorCov";
        public static final String MOTOR_REQUEST = "motorRequest";
        public static final String NACOSS = "nacoss";
        public static final String NCD_PROTECT = "ncdProtect";
        public static final String NCD_YEARS = "ncdYrs";
        public static final String NIGHT_SITU = "nightSituCd";
        public static final String NOT_PURCHASED = "notPurchasedYet";
        public static final String NUM_ADULT_CD = "numAdultCd";
        public static final String NUM_CHILD_CD = "numChildCd";
        public static final String NUM_VEHICLE = "vehicleNums";
        public static final String OCC_CD = "occCd";
        public static final String OCC_DESC = "occDesc";
        public static final String OCCUPIED_BY_FAMILY = "occupiedByFamilyFlag";
        public static final String OTHER_VEHICLE_USAGE = "useOfOtherVehicleCd";
        public static final String OWN_CD = "ownCd";
        public static final String PERS_POSS_FLAG = "persPossFlag";
        public static final String PEST_FLAG = "pestFlag";
        public static final String POLICY = "policy";
        public static final String POSTCODE = "postcode";
        public static final String POSTCODE_IN = "postCodeIn";
        public static final String POSTCODE_OUT = "postCodeOut";
        public static final String PREF_PAY_METH_CD = "prefPayMethCd";
        public static final String PREV_INS_BLD_CD = "prevInsBldCd";
        public static final String PREV_INS_CON_CD = "prevInsConCd";
        public static final String PROP_CD = "propCd";
        public static final String PROPERTY = "property";
        public static final String PROPERTY_VALUE = "propertyValue";
        public static final String PROPOSER = "Proposer";
        public static final String PROPOSERS = "proposers";
        public static final String PURCHASE_DATE = "purchaseDate";
        public static final String REBUILDING_VALUE = "rebuildingValue";
        public static final String REG_DATE = "regDate";
        public static final String RELATION_CD = "relationCd";
        public static final String REG_KEEPER = "regKeeperCd";
        public static final String REQUIRE_COVERS = "requiredCovers";
        public static final String REQUIRE_DOC = "requireDoc";
        public static final String RES_STATUS_CD = "resStatusCd";
        public static final String REPAIR_STATE_FLAG = "repairStateFlag";
        public static final String RESIDENCY = "residency";
        public static final String RISK_POSTCODE = "riskPostcode";
        public static final String ROOF_CD = "roofCd";
        public static final String SEC_DEVICE = "secDevice";
        public static final String SELF_CONTAINED_FLAG = "selfContainedFlag";
        public static final String SOAP_ENC = "SOAP-ENC";
        public static final String SMOKERS_FLAG = "smokersFlag";
        public static final String SPECIAL_TERMS_FLAG = "specialTermsFlag";
        public static final String SPECIFIED_ITEMS_FLAG = "specifiedItemsFlag";
        public static final String START_DATE = "startDate";
        public static final String STREET_NAME = "streetName";
        public static final String SUBSIDENCE_FLAG = "subsidenceFlag";
        public static final String SUMS_INS = "sumIns";
        public static final String TALL_TREE_NEARBY_FLAG = "tallTreeNearbyFlag";
        public static final String TEST_PASSED_MONTH = "testPassedMonth";
        public static final String TEST_PASSED_YEAR = "testPassedYear";
        public static final String TITLE = "title";
        public static final String TOWN = "town";
        public static final String TRACK_DEVICE = "trackDevice";
        public static final String TREE_DEMAGE_FLAG = "treeDamageFlag";
        public static final String TYP_CD = "typCd";
        public static final String UNOCCUPIED_FLAG = "unoccupiedFlag";
        public static final String USAGE = "usage";
        public static final String VEHICLE = "vehicle";
        public static final String VRM = "vrm";
        public static final String VOL_XS = "volXs";
        public static final String VOL_XS_CD = "volXSCd";
        public static final String WALL_CD = "wallCd";
        public static final String WATCH_AREA_FLAG = "nWatchAreaFlag";
        public static final String WATCH_MEMBER_FLAG = "nWatchMemberFlag";
        public static final String XSD = "xsd";
        public static final String XSI = "xsi";
        public static final String YEARS_CURRENT_INSURER = "yearsCurrentInsurer";
        public static final String YEARS_RISK_ADDRESS = "yearsAtRiskAddress";
        public static final String YEARS_WITHOUT_CLAIM = "yearsBldInsWithoutClaim";
    }
}
