import helpers.TestDataUtils;
import helpers.Utils;
import helpers.utility.ConfigLoad;
import helpers.utility.HomeAggregatorDataLoad;
import helpers.utility.MotorAggregatorDataLoad;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

import java.io.ByteArrayOutputStream;

import static com.jayway.restassured.RestAssured.given;

public class ExtractQuotes {

    /**
     * Helper method to get the quote id based on parameters defined in AggregatorsData.xlsx file
     *
     * @return QuoteID
     */
    public static String getHomeQuoteID() throws Exception {
        String quoteReference;
        if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
            quoteReference = given()
                    .header("Authorization", TestDataUtils.AuthorizationCredentials.BASIC_AUTHORIZATION)
                    .contentType("text/xml")
                    .body(createHomeSoapBody())
                    .expect()
                    .statusCode(200)
                    .when().post(ConfigLoad.ConfigLoadVariables.DEV_ENVIRONMENT)
                    .then()
                    .extract()
                    .response()
                    .xmlPath()
                    .get("Envelope.Body.getAggHomeQuoteResponse.result.HomeResponse.quoteReference").toString();

            System.out.println("The quote ID is: " + quoteReference);

        } else {
            quoteReference = given()
                    .header("Authorization", TestDataUtils.AuthorizationCredentials.BASIC_AUTHORIZATION)
                    .contentType("text/xml")
                    .body(createHomeSoapBody())
                    .expect()
                    .statusCode(200)
                    .when().post(ConfigLoad.ConfigLoadVariables.TEST_ENVIRONMENT)
                    .then()
                    .extract()
                    .response()
                    .xmlPath()
                    .get("Envelope.Body.getAggHomeQuoteResponse.result.HomeResponse.quoteReference").toString();
            System.out.println("The quote ID is: " + quoteReference);
        }

        return quoteReference;
    }

    /**
     * Helper method to get the quote id based on parameters defined in AggregatorsData.xlsx file
     *
     * @return QuoteID
     */
    public static String getMotorQuoteID() throws Exception {
        String quoteReference;
        if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
            quoteReference = given()
                    .header("Authorization", TestDataUtils.AuthorizationCredentials.BASIC_AUTHORIZATION)
                    .contentType("text/xml")
                    .body(createMotorSoapBody())
                    .expect()
                    .statusCode(200)
                    .when().post(ConfigLoad.ConfigLoadVariables.DEV_ENVIRONMENT)
                    .then()
                    .extract()
                    .response()
                    .xmlPath()
                    .get("Envelope.Body.getAggMotorQuoteResponse.result.AggMotorResponse.quoteReference").toString();

            System.out.println("The quote ID is: " + quoteReference);

        } else {
            quoteReference = given()
                    .header("Authorization", TestDataUtils.AuthorizationCredentials.BASIC_AUTHORIZATION)
                    .contentType("text/xml")
                    .body(createMotorSoapBody())
                    .expect()
                    .statusCode(200)
                    .when().post(ConfigLoad.ConfigLoadVariables.TEST_ENVIRONMENT)
                    .then()
                    .extract()
                    .response()
                    .xmlPath()
                    .get("Envelope.Body.getAggMotorQuoteResponse.result.AggMotorResponse.quoteReference").toString();

            System.out.println("The quote ID is: " + quoteReference);
        }

        return quoteReference;
    }

    /**
     * Helper method to create the SOAP body request for MOTOR using GOCompare model
     * @return SOAP body request
     */
    public static String createMotorSoapBody() throws Exception {
        MessageFactory factory = MessageFactory.newInstance();

        SOAPMessage soapMsg = factory.createMessage();

        SOAPPart part = soapMsg.getSOAPPart();

        SOAPHeader header = part.getEnvelope().getHeader();
        header.detachNode();

        // Create SOAP envelope
        SOAPEnvelope envelope = part.getEnvelope();
        envelope.addNamespaceDeclaration(TestDataUtils.SoapBody.SOAP_ENC, TestDataUtils.SoapAssertions.SOAP_ENCODING);
        envelope.addNamespaceDeclaration(TestDataUtils.SoapBody.XSI, TestDataUtils.SoapAssertions.SCHEMA_INSTANCE);
        envelope.addNamespaceDeclaration(TestDataUtils.SoapBody.XSD, TestDataUtils.SoapAssertions.SOAP_SCHEMA);

        // Create SOAP body
        SOAPBody body = envelope.getBody();

        // Create getAggMotor tag
        QName getAggMotor = new QName(TestDataUtils.SoapAssertions.SOA_IBISSERVICE, TestDataUtils.SoapBody.GET_AGG_MOTOR);
        SOAPBodyElement getAggMotorQuote = body.addBodyElement(getAggMotor);

        // Create motorRequest tag
        QName motor = new QName(TestDataUtils.SoapAssertions.AGGEGATOR_REQUEST, TestDataUtils.SoapBody.MOTOR_REQUEST);
        SOAPElement motorRequest = getAggMotorQuote.addChildElement(motor);

        SOAPElement agg = motorRequest.addChildElement(TestDataUtils.SoapBody.AGG_ID);
        agg.setValue(MotorAggregatorDataLoad.DataLoadVariables.aggId);

        // Create brands tag
        SOAPElement brands = motorRequest.addChildElement(TestDataUtils.SoapBody.BRANDS);
        SOAPFactory soapFactory = SOAPFactory.newInstance();
        Name name = soapFactory.createName("arrayType", TestDataUtils.SoapBody.SOAP_ENC, TestDataUtils.SoapAssertions.SOAP_ENCODING);
        brands.addAttribute(name, "Brand[1]");

        SOAPElement brand = brands.addChildElement(TestDataUtils.SoapBody.BRAND);
        SOAPElement brand1 = brand.addChildElement(TestDataUtils.SoapBody.BRAND);
        brand1.setValue(MotorAggregatorDataLoad.DataLoadVariables.brand);

        // Create policy tag
        SOAPElement policy = motorRequest.addChildElement(TestDataUtils.SoapBody.POLICY);
        policy.setValue(MotorAggregatorDataLoad.DataLoadVariables.policy);

        SOAPElement startDate = policy.addChildElement(TestDataUtils.SoapBody.START_DATE);
        startDate.setValue(Utils.getLocalDate());
        SOAPElement currentInsurer = policy.addChildElement(TestDataUtils.SoapBody.CURRENT_INSURER);
        currentInsurer.setValue(MotorAggregatorDataLoad.DataLoadVariables.currentInsurer);

        SOAPElement insuranceDeclined = policy.addChildElement(TestDataUtils.SoapBody.INSURANCE_DECLINED);
        insuranceDeclined.setValue(MotorAggregatorDataLoad.DataLoadVariables.insuranceDeclined);
        SOAPElement prefPayMethCd = policy.addChildElement(TestDataUtils.SoapBody.PREF_PAY_METH_CD);
        prefPayMethCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.prefPayMethCd);

        // Create motorCov tag
        SOAPElement motorCov = motorRequest.addChildElement(TestDataUtils.SoapBody.MOTOR_COV);

        SOAPElement covTypCd = motorCov.addChildElement(TestDataUtils.SoapBody.COV_TYP_CD);
        covTypCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.covTypCd);

        SOAPElement volXSCd = motorCov.addChildElement(TestDataUtils.SoapBody.VOL_XS_CD);
        volXSCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.volXSCd);

        SOAPElement ncdProtect = motorCov.addChildElement(TestDataUtils.SoapBody.NCD_PROTECT);
        ncdProtect.setValue(MotorAggregatorDataLoad.DataLoadVariables.ncdProtect);

        SOAPElement numChildCd = motorCov.addChildElement(TestDataUtils.SoapBody.NUM_CHILD_CD);
        numChildCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.numChildCd);

        SOAPElement useOfOtherVehicleCd = motorCov.addChildElement(TestDataUtils.SoapBody.OTHER_VEHICLE_USAGE);
        useOfOtherVehicleCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.useOfOtherVehicleCd);

        SOAPElement drvRestrictCd = motorCov.addChildElement(TestDataUtils.SoapBody.DRV_RESTRICT);
        drvRestrictCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.drvRestrictCd);

        SOAPElement vehicleNums = motorCov.addChildElement(TestDataUtils.SoapBody.NUM_VEHICLE);
        vehicleNums.setValue(MotorAggregatorDataLoad.DataLoadVariables.vehicleNums);

        // Create vehicle tag
        SOAPElement vehicle = motorRequest.addChildElement(TestDataUtils.SoapBody.VEHICLE);
        SOAPElement abiCd = vehicle.addChildElement(TestDataUtils.SoapBody.ABI_CD);
        abiCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.abiCd);

        SOAPElement annMileCd = vehicle.addChildElement(TestDataUtils.SoapBody.ANNUAL_MILE);
        annMileCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.annMileCd);

        SOAPElement annBusMiles = vehicle.addChildElement(TestDataUtils.SoapBody.ANNUAL_BUS_MILE);
        annBusMiles.setValue(MotorAggregatorDataLoad.DataLoadVariables.annBusMiles);

        SOAPElement daySituCd = vehicle.addChildElement(TestDataUtils.SoapBody.DAY_SITU);
        daySituCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.daySituCd);

        SOAPElement nightSituCd = vehicle.addChildElement(TestDataUtils.SoapBody.NIGHT_SITU);
        nightSituCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.nightSituCd);

        SOAPElement isEstValRaw = vehicle.addChildElement(TestDataUtils.SoapBody.IS_EST_VAL);
        isEstValRaw.setValue(MotorAggregatorDataLoad.DataLoadVariables.isEstValRaw);

        SOAPElement notPurchasedYet = vehicle.addChildElement(TestDataUtils.SoapBody.NOT_PURCHASED);
        notPurchasedYet.setValue(MotorAggregatorDataLoad.DataLoadVariables.notPurchasedYet);

        SOAPElement purchaseDate = vehicle.addChildElement(TestDataUtils.SoapBody.PURCHASE_DATE);
        purchaseDate.setValue(MotorAggregatorDataLoad.DataLoadVariables.purchaseDate);

        SOAPElement estVal = vehicle.addChildElement(TestDataUtils.SoapBody.EST_VAL);
        estVal.setValue(MotorAggregatorDataLoad.DataLoadVariables.estVal);

        SOAPElement regDate = vehicle.addChildElement(TestDataUtils.SoapBody.REG_DATE);
        regDate.setValue(MotorAggregatorDataLoad.DataLoadVariables.regDate);

        SOAPElement vrm = vehicle.addChildElement(TestDataUtils.SoapBody.VRM);
        vrm.setValue(MotorAggregatorDataLoad.DataLoadVariables.vrm);

        SOAPElement riskPostcode = vehicle.addChildElement(TestDataUtils.SoapBody.RISK_POSTCODE);
        SOAPElement postCodeOut = riskPostcode.addChildElement(TestDataUtils.SoapBody.POSTCODE_OUT);
        postCodeOut.setValue(MotorAggregatorDataLoad.DataLoadVariables.postCodeOut);

        SOAPElement postCodeIn = riskPostcode.addChildElement(TestDataUtils.SoapBody.POSTCODE_IN);
        postCodeIn.setValue(MotorAggregatorDataLoad.DataLoadVariables.postCodeIn);

        SOAPElement usage = vehicle.addChildElement(TestDataUtils.SoapBody.USAGE);
        usage.setValue(MotorAggregatorDataLoad.DataLoadVariables.usage);

        SOAPElement secDevice = vehicle.addChildElement(TestDataUtils.SoapBody.SEC_DEVICE);
        secDevice.setValue(MotorAggregatorDataLoad.DataLoadVariables.secDevice);

        SOAPElement trackDevice = vehicle.addChildElement(TestDataUtils.SoapBody.TRACK_DEVICE);
        trackDevice.setValue(MotorAggregatorDataLoad.DataLoadVariables.trackDevice);

        SOAPElement isImport = vehicle.addChildElement(TestDataUtils.SoapBody.IS_IMPORT);
        isImport.setValue(MotorAggregatorDataLoad.DataLoadVariables.isImport);

        SOAPElement regKeeperCd = vehicle.addChildElement(TestDataUtils.SoapBody.REG_KEEPER);
        regKeeperCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.regKeeperCd);

        SOAPElement legalOwnerCd = vehicle.addChildElement(TestDataUtils.SoapBody.LEGAL_OWNER);
        legalOwnerCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.legalOwnerCd);

        SOAPElement drivers = motorRequest.addChildElement(TestDataUtils.SoapBody.DRIVERS);
        drivers.addAttribute(name, "Driver[1]");

        SOAPElement driver = drivers.addChildElement(TestDataUtils.SoapBody.DRIVER);
        SOAPElement title = driver.addChildElement(TestDataUtils.SoapBody.TITLE);
        title.setValue(MotorAggregatorDataLoad.DataLoadVariables.driverTitle);

        SOAPElement firstName = driver.addChildElement(TestDataUtils.SoapBody.FIRST_NAME);
        firstName.setValue(MotorAggregatorDataLoad.DataLoadVariables.driverFirstName);

        SOAPElement lastName = driver.addChildElement(TestDataUtils.SoapBody.LAST_NAME);
        lastName.setValue(MotorAggregatorDataLoad.DataLoadVariables.driverLastName);

        SOAPElement dob = driver.addChildElement(TestDataUtils.SoapBody.DOB);
        dob.setValue(MotorAggregatorDataLoad.DataLoadVariables.driverDateOfBirth);

        SOAPElement sex = driver.addChildElement(TestDataUtils.SoapBody.GENDER);
        sex.setValue(MotorAggregatorDataLoad.DataLoadVariables.driverGender);

        SOAPElement occCd = driver.addChildElement(TestDataUtils.SoapBody.OCC_CD);
        occCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.occCd);

        SOAPElement occDesc = driver.addChildElement(TestDataUtils.SoapBody.OCC_DESC);
        occDesc.setValue(MotorAggregatorDataLoad.DataLoadVariables.occDesc);

        SOAPElement resStatusCd = driver.addChildElement(TestDataUtils.SoapBody.RES_STATUS_CD);
        resStatusCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.resStatusCd);

        SOAPElement eveningNum = driver.addChildElement(TestDataUtils.SoapBody.EVENING_NUM);
        eveningNum.setValue(MotorAggregatorDataLoad.DataLoadVariables.eveningNum);

        SOAPElement daytimeNum = driver.addChildElement(TestDataUtils.SoapBody.DAYTIME_NUM);
        daytimeNum.setValue(MotorAggregatorDataLoad.DataLoadVariables.daytimeNum);

        SOAPElement emailAddress = driver.addChildElement(TestDataUtils.SoapBody.EMAIL);
        emailAddress.setValue(MotorAggregatorDataLoad.DataLoadVariables.emailAddress);

        SOAPElement maritalCd = driver.addChildElement(TestDataUtils.SoapBody.MARITAL_CD);
        maritalCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.maritalCd);

        SOAPElement ncdYrs = driver.addChildElement(TestDataUtils.SoapBody.NCD_YEARS);
        ncdYrs.setValue(MotorAggregatorDataLoad.DataLoadVariables.ncdYrs);

        SOAPElement relationCd = driver.addChildElement(TestDataUtils.SoapBody.RELATION_CD);
        relationCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.relationCd);

        SOAPElement license = driver.addChildElement(TestDataUtils.SoapBody.LICENSE);
        SOAPElement typCd = license.addChildElement(TestDataUtils.SoapBody.TYP_CD);
        typCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.typCd);

        SOAPElement testPassedMonth = license.addChildElement(TestDataUtils.SoapBody.TEST_PASSED_MONTH);
        testPassedMonth.setValue(MotorAggregatorDataLoad.DataLoadVariables.testPassedMonth);

        SOAPElement testPassedYear = license.addChildElement(TestDataUtils.SoapBody.TEST_PASSED_YEAR);
        testPassedYear.setValue(MotorAggregatorDataLoad.DataLoadVariables.testPassedYear);

        SOAPElement licRestrictCd = license.addChildElement(TestDataUtils.SoapBody.LIC_RESTRICTED_CD);
        licRestrictCd.setValue(MotorAggregatorDataLoad.DataLoadVariables.licRestrictCd);

        SOAPElement residency = driver.addChildElement(TestDataUtils.SoapBody.RESIDENCY);
        SOAPElement livedUkMonth = residency.addChildElement(TestDataUtils.SoapBody.LIVED_UK_MONTH);
        livedUkMonth.setValue(MotorAggregatorDataLoad.DataLoadVariables.livedUkMonth);

        SOAPElement livedUkYear = residency.addChildElement(TestDataUtils.SoapBody.LIVED_UK_YEAR);
        livedUkYear.setValue(MotorAggregatorDataLoad.DataLoadVariables.livedUkYear);

        SOAPElement requireDoc = driver.addChildElement(TestDataUtils.SoapBody.REQUIRE_DOC);
        requireDoc.setValue(MotorAggregatorDataLoad.DataLoadVariables.requireDoc);

        SOAPElement hasNonMotConv = driver.addChildElement(TestDataUtils.SoapBody.HAS_MON_MOT_CONV);
        hasNonMotConv.setValue(MotorAggregatorDataLoad.DataLoadVariables.hasNonMotConv);

        SOAPElement isHomeOwner = driver.addChildElement(TestDataUtils.SoapBody.IS_HOME_OWNER);
        isHomeOwner.setValue(MotorAggregatorDataLoad.DataLoadVariables.isHomeOwner);

        SOAPElement hasChildUnder16 = driver.addChildElement(TestDataUtils.SoapBody.CHILD_UNDER_16);
        hasChildUnder16.setValue(MotorAggregatorDataLoad.DataLoadVariables.hasChildUnder16);

        SOAPElement address = driver.addChildElement(TestDataUtils.SoapBody.ADDRESS);
        SOAPElement houseNumber = address.addChildElement(TestDataUtils.SoapBody.HOUSE_NUMBER);
        houseNumber.setValue(MotorAggregatorDataLoad.DataLoadVariables.houseNumber);

        SOAPElement streetName = address.addChildElement(TestDataUtils.SoapBody.STREET_NAME);
        streetName.setValue(MotorAggregatorDataLoad.DataLoadVariables.streetName);

        SOAPElement town = address.addChildElement(TestDataUtils.SoapBody.TOWN);
        town.setValue(MotorAggregatorDataLoad.DataLoadVariables.town);

        SOAPElement county = address.addChildElement(TestDataUtils.SoapBody.COUNTY);
        county.setValue(MotorAggregatorDataLoad.DataLoadVariables.county);

        SOAPElement postcode = address.addChildElement(TestDataUtils.SoapBody.POSTCODE);
        SOAPElement postCodeOut1 = postcode.addChildElement(TestDataUtils.SoapBody.POSTCODE_OUT);
        postCodeOut1.setValue(MotorAggregatorDataLoad.DataLoadVariables.postCodeOut);

        SOAPElement postCodeIn1 = postcode.addChildElement(TestDataUtils.SoapBody.POSTCODE_IN);
        postCodeIn1.setValue(MotorAggregatorDataLoad.DataLoadVariables.postCodeIn);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        soapMsg.writeTo(out);

        return out.toString();
    }

    /**
     * Helper method to create the SOAP body request for HOME using Confused model
     * @return SOAP body request
     */
    public static String createHomeSoapBody() throws Exception {
        MessageFactory factory = MessageFactory.newInstance();

        SOAPMessage soapMsg = factory.createMessage();

        SOAPPart part = soapMsg.getSOAPPart();

        SOAPHeader header = part.getEnvelope().getHeader();
        header.detachNode();

        // Create SOAP envelope
        SOAPEnvelope envelope = part.getEnvelope();
        envelope.addNamespaceDeclaration(TestDataUtils.SoapBody.SOAP_ENC, TestDataUtils.SoapAssertions.SOAP_ENCODING);
        envelope.addNamespaceDeclaration(TestDataUtils.SoapBody.XSI, TestDataUtils.SoapAssertions.SCHEMA_INSTANCE);
        envelope.addNamespaceDeclaration(TestDataUtils.SoapBody.XSD, TestDataUtils.SoapAssertions.SOAP_SCHEMA);

        // Create SOAP body
        SOAPBody body = envelope.getBody();

        // Create getAggMotor tag
        QName getAggHome = new QName(TestDataUtils.SoapAssertions.SOA_IBISSERVICE, TestDataUtils.SoapBody.GET_AGG_HOME);
        SOAPBodyElement getAggHomeQuote = body.addBodyElement(getAggHome);

        // Create homeRequest tag
        QName home = new QName(TestDataUtils.SoapAssertions.AGGEGATOR_REQUEST, TestDataUtils.SoapBody.HOME_REQUEST);
        SOAPElement homeRequest = getAggHomeQuote.addChildElement(home);

        SOAPElement agg = homeRequest.addChildElement(TestDataUtils.SoapBody.AGG_ID);
        agg.setValue(HomeAggregatorDataLoad.DataLoadVariables.aggId);

        // Create brands tag
        SOAPElement brands = homeRequest.addChildElement(TestDataUtils.SoapBody.BRANDS);
        SOAPFactory soapFactory = SOAPFactory.newInstance();
        Name name = soapFactory.createName("arrayType", TestDataUtils.SoapBody.SOAP_ENC, TestDataUtils.SoapAssertions.SOAP_ENCODING);
        brands.addAttribute(name, "Brand[1]");

        SOAPElement brand = brands.addChildElement(TestDataUtils.SoapBody.BRAND);
        SOAPElement brand1 = brand.addChildElement(TestDataUtils.SoapBody.BRAND);
        brand1.setValue(HomeAggregatorDataLoad.DataLoadVariables.brand);

        // Create assumptions tag
        SOAPElement assumptions = homeRequest.addChildElement(TestDataUtils.SoapBody.ASSUMPTIONS);

        SOAPElement specialTermsFlag = assumptions.addChildElement(TestDataUtils.SoapBody.SPECIAL_TERMS_FLAG);
        specialTermsFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.specialTermsFlag);

        SOAPElement convictionPendFlag = assumptions.addChildElement(TestDataUtils.SoapBody.CONVICTION_PEND_FLAG);
        convictionPendFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.convictionPendFlag);

        SOAPElement repairStateFlag = assumptions.addChildElement(TestDataUtils.SoapBody.REPAIR_STATE_FLAG);
        repairStateFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.repairStateFlag);

        SOAPElement holidayHomeFlag = assumptions.addChildElement(TestDataUtils.SoapBody.HOLIDAY_HOME_FLAG);
        holidayHomeFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.holidayHomeFlag);

        SOAPElement unoccupiedFlag = assumptions.addChildElement(TestDataUtils.SoapBody.UNOCCUPIED_FLAG);
        unoccupiedFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.unoccupiedFlag);

        SOAPElement floodFlag = assumptions.addChildElement(TestDataUtils.SoapBody.FLOOD_FLAG);
        floodFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.floodFlag);

        SOAPElement subsidenceFlag = assumptions.addChildElement(TestDataUtils.SoapBody.SUBSIDENCE_FLAG);
        subsidenceFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.subsidenceFlag);

        SOAPElement listedFlag = assumptions.addChildElement(TestDataUtils.SoapBody.LISTED_FLAG);
        listedFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.listedFlag);

        SOAPElement businessFlag = assumptions.addChildElement(TestDataUtils.SoapBody.BUSINESS_FLAG);
        businessFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.businessFlag);

        SOAPElement treeDamageFlag = assumptions.addChildElement(TestDataUtils.SoapBody.TREE_DEMAGE_FLAG);
        treeDamageFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.treeDamageFlag);

        SOAPElement tallTreeNearbyFlag = assumptions.addChildElement(TestDataUtils.SoapBody.TALL_TREE_NEARBY_FLAG);
        tallTreeNearbyFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.tallTreeNearbyFlag);

        SOAPElement buildingInProgressFlag = assumptions.addChildElement(TestDataUtils.SoapBody.BUILDING_IN_PROGRESS_FLAG);
        buildingInProgressFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.buildingInProgressFlag);

        SOAPElement prevInsBldCd = assumptions.addChildElement(TestDataUtils.SoapBody.PREV_INS_BLD_CD);
        prevInsBldCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.prevInsBldCd);

        SOAPElement rebuildingValue = assumptions.addChildElement(TestDataUtils.SoapBody.REBUILDING_VALUE);
        rebuildingValue.setValue(HomeAggregatorDataLoad.DataLoadVariables.rebuildingValue);

        SOAPElement yearsBldInsWithoutClaim = assumptions.addChildElement(TestDataUtils.SoapBody.YEARS_WITHOUT_CLAIM);
        yearsBldInsWithoutClaim.setValue(HomeAggregatorDataLoad.DataLoadVariables.yearsBldInsWithoutClaim);

        SOAPElement propertyValue = assumptions.addChildElement(TestDataUtils.SoapBody.PROPERTY_VALUE);
        propertyValue.setValue(HomeAggregatorDataLoad.DataLoadVariables.propertyValue);

        SOAPElement prevInsConCd = assumptions.addChildElement(TestDataUtils.SoapBody.PREV_INS_CON_CD);
        prevInsConCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.prevInsConCd);

        SOAPElement forSaleFlag = assumptions.addChildElement(TestDataUtils.SoapBody.FOR_SALE_FLAG);
        forSaleFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.forSaleFlag);

        SOAPElement bankruptFlag = assumptions.addChildElement(TestDataUtils.SoapBody.BANKRUPT_FLAG);
        bankruptFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.bankruptFlag);

        SOAPElement smokersFlag = assumptions.addChildElement(TestDataUtils.SoapBody.SMOKERS_FLAG);
        smokersFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.smokersFlag);

        SOAPElement nWatchAreaFlag = assumptions.addChildElement(TestDataUtils.SoapBody.WATCH_AREA_FLAG);
        nWatchAreaFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.nWatchAreaFlag);

        SOAPElement nWatchMemberFlag = assumptions.addChildElement(TestDataUtils.SoapBody.WATCH_MEMBER_FLAG);
        nWatchMemberFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.nWatchMemberFlag);

        SOAPElement burglarAlarmCd = assumptions.addChildElement(TestDataUtils.SoapBody.BURGLAR_ALARM_CD);
        burglarAlarmCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.burglarAlarmCd);

        SOAPElement alarmProfessionalFlag = assumptions.addChildElement(TestDataUtils.SoapBody.ALARM_PROFESSIONAL);
        alarmProfessionalFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.alarmProfessionalFlag);

        SOAPElement alarmPoliceFlag = assumptions.addChildElement(TestDataUtils.SoapBody.ALARM_POLICE);
        alarmPoliceFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.alarmPoliceFlag);

        SOAPElement jointPropBankruptFlag = assumptions.addChildElement(TestDataUtils.SoapBody.JOINT_PROP_BANKRUPT);
        jointPropBankruptFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.jointPropBankruptFlag);

        SOAPElement occupiedByFamilyFlag = assumptions.addChildElement(TestDataUtils.SoapBody.OCCUPIED_BY_FAMILY);
        occupiedByFamilyFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.occupiedByFamilyFlag);

        SOAPElement selfContainedFlag = assumptions.addChildElement(TestDataUtils.SoapBody.SELF_CONTAINED_FLAG);
        selfContainedFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.selfContainedFlag);

        // Create buildings tag
        SOAPElement buildings = homeRequest.addChildElement(TestDataUtils.SoapBody.BUILDINGS);

        SOAPElement coverLevel = buildings.addChildElement(TestDataUtils.SoapBody.COVER_LEVEL);
        coverLevel.setValue(HomeAggregatorDataLoad.DataLoadVariables.coverLevel);

        SOAPElement ncdProtect = buildings.addChildElement(TestDataUtils.SoapBody.NCD_PROTECT);
        ncdProtect.setValue(HomeAggregatorDataLoad.DataLoadVariables.ncdProtect);

        SOAPElement ncdYears = buildings.addChildElement(TestDataUtils.SoapBody.NCD_YEARS);
        ncdYears.setValue(HomeAggregatorDataLoad.DataLoadVariables.ncdYrs);

        SOAPElement sumIns = buildings.addChildElement(TestDataUtils.SoapBody.SUMS_INS);
        sumIns.setValue(HomeAggregatorDataLoad.DataLoadVariables.sumIns);

        SOAPElement volXs = buildings.addChildElement(TestDataUtils.SoapBody.VOL_XS);
        volXs.setValue(HomeAggregatorDataLoad.DataLoadVariables.volXs);

        SOAPElement claims = buildings.addChildElement(TestDataUtils.SoapBody.CLAIMS);
        claims.addAttribute(name, "HomeClaim[0]");

        // Create policy tag
        SOAPElement policy = homeRequest.addChildElement(TestDataUtils.SoapBody.POLICY);
        SOAPElement startDate = policy.addChildElement(TestDataUtils.SoapBody.START_DATE);
        startDate.setValue(Utils.getLocalDate());

        SOAPElement insuranceDeclined = policy.addChildElement(TestDataUtils.SoapBody.INSURANCE_DECLINED);
        insuranceDeclined.setValue(HomeAggregatorDataLoad.DataLoadVariables.insuranceDeclined);

        SOAPElement currentInsurer = policy.addChildElement(TestDataUtils.SoapBody.CURRENT_INSURER);
        currentInsurer.setValue(HomeAggregatorDataLoad.DataLoadVariables.currentInsurer);

        SOAPElement yearsCurrentInsurer = policy.addChildElement(TestDataUtils.SoapBody.YEARS_CURRENT_INSURER);
        yearsCurrentInsurer.setValue(HomeAggregatorDataLoad.DataLoadVariables.yearsCurrentInsurer);

        // Create property tag
        SOAPElement property = homeRequest.addChildElement(TestDataUtils.SoapBody.PROPERTY);
        SOAPElement address = property.addChildElement(TestDataUtils.SoapBody.ADDRESS);

        SOAPElement houseNumber = address.addChildElement(TestDataUtils.SoapBody.HOUSE_NUMBER);
        houseNumber.setValue(HomeAggregatorDataLoad.DataLoadVariables.houseNumber);

        SOAPElement streetName = address.addChildElement(TestDataUtils.SoapBody.STREET_NAME);
        streetName.setValue(HomeAggregatorDataLoad.DataLoadVariables.streetName);

        SOAPElement town = address.addChildElement(TestDataUtils.SoapBody.TOWN);
        town.setValue(HomeAggregatorDataLoad.DataLoadVariables.town);

        SOAPElement county = address.addChildElement(TestDataUtils.SoapBody.COUNTY);
        county.setValue(HomeAggregatorDataLoad.DataLoadVariables.county);

        SOAPElement postCode = address.addChildElement(TestDataUtils.SoapBody.POSTCODE);
        SOAPElement postCodeOut = postCode.addChildElement(TestDataUtils.SoapBody.POSTCODE_OUT);
        postCodeOut.setValue(HomeAggregatorDataLoad.DataLoadVariables.postCodeOut);

        SOAPElement postCodeIn = postCode.addChildElement(TestDataUtils.SoapBody.POSTCODE_IN);
        postCodeIn.setValue(HomeAggregatorDataLoad.DataLoadVariables.postCodeIn);

        SOAPElement firstTimeBuyer = property.addChildElement(TestDataUtils.SoapBody.FIRST_TIME_BUYER);
        firstTimeBuyer.setValue(HomeAggregatorDataLoad.DataLoadVariables.firstTimeBuyer);

        SOAPElement locks = property.addChildElement(TestDataUtils.SoapBody.LOCKS);
        locks.setValue(HomeAggregatorDataLoad.DataLoadVariables.locks);

        SOAPElement nacoss = property.addChildElement(TestDataUtils.SoapBody.NACOSS);
        nacoss.setValue(HomeAggregatorDataLoad.DataLoadVariables.nacoss);

        SOAPElement bedsCd = property.addChildElement(TestDataUtils.SoapBody.BEDS_CD);
        bedsCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.bedsCd);

        SOAPElement addRoomsCd = property.addChildElement(TestDataUtils.SoapBody.ADD_ROOMS_CD);
        addRoomsCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.addRoomsCd);

        SOAPElement numAdultCd = property.addChildElement(TestDataUtils.SoapBody.NUM_ADULT_CD);
        numAdultCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.numAdultCd);

        SOAPElement numChildCd = property.addChildElement(TestDataUtils.SoapBody.NUM_CHILD_CD);
        numChildCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.numChildCd);

        SOAPElement ownCd = property.addChildElement(TestDataUtils.SoapBody.OWN_CD);
        ownCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.ownCd);

        SOAPElement propCd = property.addChildElement(TestDataUtils.SoapBody.PROP_CD);
        propCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.propCd);

        SOAPElement roofCd = property.addChildElement(TestDataUtils.SoapBody.ROOF_CD);
        roofCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.roofCd);

        SOAPElement wallCd = property.addChildElement(TestDataUtils.SoapBody.WALL_CD);
        wallCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.wallCd);

        SOAPElement builtCd = property.addChildElement(TestDataUtils.SoapBody.BUILT_CD);
        builtCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.builtCd);

        SOAPElement currentMortgageProvider = property.addChildElement(TestDataUtils.SoapBody.CURRENT_MORTGAGE_PROVIDER);
        currentMortgageProvider.setValue(HomeAggregatorDataLoad.DataLoadVariables.currentMortgageProvider);

        // Create proposers tag
        SOAPElement proposers = homeRequest.addChildElement(TestDataUtils.SoapBody.PROPOSERS);
        proposers.addAttribute(name, "HomeProposer[1]");

        SOAPElement proposer = proposers.addChildElement(TestDataUtils.SoapBody.PROPOSER);
        SOAPElement title = proposer.addChildElement(TestDataUtils.SoapBody.TITLE);
        title.setValue(HomeAggregatorDataLoad.DataLoadVariables.proposerTitle);

        SOAPElement firstName = proposer.addChildElement(TestDataUtils.SoapBody.FIRST_NAME);
        firstName.setValue(HomeAggregatorDataLoad.DataLoadVariables.proposerFirstName);

        SOAPElement lastName = proposer.addChildElement(TestDataUtils.SoapBody.LAST_NAME);
        lastName.setValue(HomeAggregatorDataLoad.DataLoadVariables.proposerLastName);

        SOAPElement dob = proposer.addChildElement(TestDataUtils.SoapBody.DOB);
        dob.setValue(HomeAggregatorDataLoad.DataLoadVariables.proposerDateOfBirth);

        SOAPElement sex = proposer.addChildElement(TestDataUtils.SoapBody.GENDER);
        sex.setValue(HomeAggregatorDataLoad.DataLoadVariables.proposerGender);

        SOAPElement occCd = proposer.addChildElement(TestDataUtils.SoapBody.OCC_CD);
        occCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.occCd);

        SOAPElement occDesc = proposer.addChildElement(TestDataUtils.SoapBody.OCC_DESC);
        occDesc.setValue(HomeAggregatorDataLoad.DataLoadVariables.occDesc);

        SOAPElement eveningNum = proposer.addChildElement(TestDataUtils.SoapBody.EVENING_NUM);
        eveningNum.setValue(HomeAggregatorDataLoad.DataLoadVariables.eveningNum);

        SOAPElement daytimeNum = proposer.addChildElement(TestDataUtils.SoapBody.DAYTIME_NUM);
        daytimeNum.setValue(HomeAggregatorDataLoad.DataLoadVariables.daytimeNum);

        SOAPElement emailAddress = proposer.addChildElement(TestDataUtils.SoapBody.EMAIL);
        emailAddress.setValue(HomeAggregatorDataLoad.DataLoadVariables.emailAddress);

        SOAPElement maritalCd = proposer.addChildElement(TestDataUtils.SoapBody.MARITAL_CD);
        maritalCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.maritalCd);

        SOAPElement relationCd = proposer.addChildElement(TestDataUtils.SoapBody.RELATION_CD);
        relationCd.setValue(HomeAggregatorDataLoad.DataLoadVariables.relationCd);

        SOAPElement address1 = proposer.addChildElement(TestDataUtils.SoapBody.ADDRESS);
        SOAPElement houseNumber1 = address1.addChildElement(TestDataUtils.SoapBody.HOUSE_NUMBER);
        houseNumber1.setValue(HomeAggregatorDataLoad.DataLoadVariables.houseNumber);

        SOAPElement streetName1 = address1.addChildElement(TestDataUtils.SoapBody.STREET_NAME);
        streetName1.setValue(HomeAggregatorDataLoad.DataLoadVariables.streetName);

        SOAPElement town1 = address1.addChildElement(TestDataUtils.SoapBody.TOWN);
        town1.setValue(HomeAggregatorDataLoad.DataLoadVariables.town);

        SOAPElement county1 = address1.addChildElement(TestDataUtils.SoapBody.COUNTY);
        county1.setValue(HomeAggregatorDataLoad.DataLoadVariables.county);

        SOAPElement postcode1 = address1.addChildElement(TestDataUtils.SoapBody.POSTCODE);
        SOAPElement postCodeOut1 = postcode1.addChildElement(TestDataUtils.SoapBody.POSTCODE_OUT);
        postCodeOut1.setValue(HomeAggregatorDataLoad.DataLoadVariables.postCodeOut);

        SOAPElement postCodeIn1 = postcode1.addChildElement(TestDataUtils.SoapBody.POSTCODE_IN);
        postCodeIn1.setValue(HomeAggregatorDataLoad.DataLoadVariables.postCodeIn);

        SOAPElement residency = proposer.addChildElement(TestDataUtils.SoapBody.RESIDENCY);
        SOAPElement livedUkMonth = residency.addChildElement(TestDataUtils.SoapBody.LIVED_UK_MONTH);
        livedUkMonth.setValue(HomeAggregatorDataLoad.DataLoadVariables.livedUkMonth);

        SOAPElement livedUkYear = residency.addChildElement(TestDataUtils.SoapBody.LIVED_UK_YEAR);
        livedUkYear.setValue(HomeAggregatorDataLoad.DataLoadVariables.livedUkYear);

        SOAPElement isHomeOwner = proposer.addChildElement(TestDataUtils.SoapBody.IS_HOME_OWNER);
        isHomeOwner.setValue(HomeAggregatorDataLoad.DataLoadVariables.isHomeOwner);

        SOAPElement yearsAtRiskAddress = proposer.addChildElement(TestDataUtils.SoapBody.YEARS_RISK_ADDRESS);
        yearsAtRiskAddress.setValue(HomeAggregatorDataLoad.DataLoadVariables.yearsAtRiskAddress);

        // Create requiredCovers tag
        SOAPElement requiredCovers = homeRequest.addChildElement(TestDataUtils.SoapBody.REQUIRE_COVERS);
        SOAPElement buildVarFlag = requiredCovers.addChildElement(TestDataUtils.SoapBody.BUILD_VAR_FLAG);
        buildVarFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.buildVarFlag);

        SOAPElement buildingsFlag = requiredCovers.addChildElement(TestDataUtils.SoapBody.BUILDINGS_FLAG);
        buildingsFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.buildingsFlag);

        SOAPElement contentsFlag = requiredCovers.addChildElement(TestDataUtils.SoapBody.CONTENTS_FLAG);
        contentsFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.contentsFlag);

        SOAPElement emergencyFlag = requiredCovers.addChildElement(TestDataUtils.SoapBody.EMERGENCY_FLAG);
        emergencyFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.emergencyFlag);

        SOAPElement flpFlag = requiredCovers.addChildElement(TestDataUtils.SoapBody.FLP_FLAG);
        flpFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.flpFlag);

        SOAPElement persPossFlag = requiredCovers.addChildElement(TestDataUtils.SoapBody.PERS_POSS_FLAG);
        persPossFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.persPossFlag);

        SOAPElement pestFlag = requiredCovers.addChildElement(TestDataUtils.SoapBody.PEST_FLAG);
        pestFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.pestFlag);

        SOAPElement specifiedItemsFlag = requiredCovers.addChildElement(TestDataUtils.SoapBody.SPECIFIED_ITEMS_FLAG);
        specifiedItemsFlag.setValue(HomeAggregatorDataLoad.DataLoadVariables.specifiedItemsFlag);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        soapMsg.writeTo(out);

        return out.toString();
    }
}
