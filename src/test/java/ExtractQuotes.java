import helpers.TestDataUtils;
import helpers.Utils;
import helpers.utility.ConfigLoad;
import helpers.utility.HomeAggregatorDataLoad;
import helpers.utility.MotorAggregatorDataLoad;

import static com.jayway.restassured.RestAssured.given;

public class ExtractQuotes {

    /**
     * Helper method to get the quote id based on parameters defined in AggregatorsData.xlsx file
     *
     * @return QuoteID
     */
    public static String getHomeQuote() throws Exception {
        String quoteReference;
        if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
            quoteReference = given()
                    .header("Authorization", TestDataUtils.AuthorizationCredentials.BASIC_AUTHORIZATION)
                    .contentType("text/xml")
                    .body("<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                            "   <SOAP-ENV:Body>\n" +
                            "      <getAggHomeQuote SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns=\"http://www.esure.com/SOA/ibisservice\">\n" +
                            "         <homeRequest xmlns=\"java:com.esure.busservices.cdm.aggregator.request\">\n" +
                            "            <aggId>" + HomeAggregatorDataLoad.DataLoadVariables.aggId + "</aggId>\n" +
                            "            <brands SOAP-ENC:arrayType=\"Brand[1]\">\n" +
                            "               <Brand>\n" +
                            "                  <brand>" + HomeAggregatorDataLoad.DataLoadVariables.brand + "</brand>\n" +
                            "               </Brand>\n" +
                            "            </brands>\n" +
                            "            <assumptions>\n" +
                            "               <specialTermsFlag>" + HomeAggregatorDataLoad.DataLoadVariables.specifiedItemsFlag + "</specialTermsFlag>\n" +
                            "               <convictionPendFlag>" + HomeAggregatorDataLoad.DataLoadVariables.convictionPendFlag + "</convictionPendFlag>\n" +
                            "               <repairStateFlag>" + HomeAggregatorDataLoad.DataLoadVariables.repairStateFlag + "</repairStateFlag>\n" +
                            "               <holidayHomeFlag>" + HomeAggregatorDataLoad.DataLoadVariables.holidayHomeFlag + "</holidayHomeFlag>\n" +
                            "               <unoccupiedFlag>" + HomeAggregatorDataLoad.DataLoadVariables.unoccupiedFlag + "</unoccupiedFlag>\n" +
                            "               <floodFlag>" + HomeAggregatorDataLoad.DataLoadVariables.floodFlag + "</floodFlag>\n" +
                            "               <subsidenceFlag>" + HomeAggregatorDataLoad.DataLoadVariables.subsidenceFlag + "</subsidenceFlag>\n" +
                            "               <listedFlag>" + HomeAggregatorDataLoad.DataLoadVariables.listedFlag + "</listedFlag>\n" +
                            "               <businessFlag>" + HomeAggregatorDataLoad.DataLoadVariables.businessFlag + "</businessFlag>\n" +
                            "               <treeDamageFlag>" + HomeAggregatorDataLoad.DataLoadVariables.treeDamageFlag + "</treeDamageFlag>\n" +
                            "               <tallTreeNearbyFlag>" + HomeAggregatorDataLoad.DataLoadVariables.tallTreeNearbyFlag + "</tallTreeNearbyFlag>\n" +
                            "               <buildingInProgressFlag>" + HomeAggregatorDataLoad.DataLoadVariables.buildingInProgressFlag + "</buildingInProgressFlag>\n" +
                            "               <prevInsBldCd>" + HomeAggregatorDataLoad.DataLoadVariables.prevInsBldCd + "</prevInsBldCd>\n" +
                            "               <rebuildingValue>" + HomeAggregatorDataLoad.DataLoadVariables.rebuildingValue + "</rebuildingValue>\n" +
                            "               <yearsBldInsWithoutClaim>" + HomeAggregatorDataLoad.DataLoadVariables.yearsBldInsWithoutClaim + "</yearsBldInsWithoutClaim>\n" +
                            "               <propertyValue>" + HomeAggregatorDataLoad.DataLoadVariables.propertyValue + "</propertyValue>\n" +
                            "               <prevInsConCd>" + HomeAggregatorDataLoad.DataLoadVariables.prevInsConCd + "</prevInsConCd>\n" +
                            "               <forSaleFlag>" + HomeAggregatorDataLoad.DataLoadVariables.forSaleFlag + "</forSaleFlag>\n" +
                            "               <bankruptFlag>" + HomeAggregatorDataLoad.DataLoadVariables.bankruptFlag + "</bankruptFlag>\n" +
                            "               <smokersFlag>" + HomeAggregatorDataLoad.DataLoadVariables.smokersFlag + "</smokersFlag>\n" +
                            "               <nWatchAreaFlag>" + HomeAggregatorDataLoad.DataLoadVariables.nWatchAreaFlag + "</nWatchAreaFlag>\n" +
                            "               <nWatchMemberFlag>" + HomeAggregatorDataLoad.DataLoadVariables.nWatchMemberFlag + "</nWatchMemberFlag>\n" +
                            "               <burglarAlarmCd>" + HomeAggregatorDataLoad.DataLoadVariables.burglarAlarmCd + "</burglarAlarmCd>\n" +
                            "               <alarmProfessionalFlag>" + HomeAggregatorDataLoad.DataLoadVariables.alarmProfessionalFlag + "</alarmProfessionalFlag>\n" +
                            "               <alarmPoliceFlag>" + HomeAggregatorDataLoad.DataLoadVariables.alarmPoliceFlag + "</alarmPoliceFlag>\n" +
                            "               <jointPropBankruptFlag>" + HomeAggregatorDataLoad.DataLoadVariables.jointPropBankruptFlag + "</jointPropBankruptFlag>\n" +
                            "               <occupiedByFamilyFlag>" + HomeAggregatorDataLoad.DataLoadVariables.occupiedByFamilyFlag + "</occupiedByFamilyFlag>\n" +
                            "               <selfContainedFlag>" + HomeAggregatorDataLoad.DataLoadVariables.selfContainedFlag + "</selfContainedFlag>\n" +
                            "            </assumptions>\n" +
                            "            <buildings>\n" +
                            "               <coverLevel>" + HomeAggregatorDataLoad.DataLoadVariables.coverLevel + "</coverLevel>\n" +
                            "               <ncdProtect>" + HomeAggregatorDataLoad.DataLoadVariables.ncdProtect + "</ncdProtect>\n" +
                            "               <ncdYrs>" + HomeAggregatorDataLoad.DataLoadVariables.ncdYrs + "</ncdYrs>\n" +
                            "               <sumIns>" + HomeAggregatorDataLoad.DataLoadVariables.sumIns + "</sumIns>\n" +
                            "               <volXs>250</volXs>\n" +
                            "               <claims SOAP-ENC:arrayType=\"HomeClaim[0]\" xsi:nil=\"true\"/>\n" +
                            "            </buildings>\n" +
                            "            <policy>\n" +
                            "               <startDate>" + Utils.getLocalDate() + "T00:00:00</startDate>\n" +
                            "               <insuranceDeclined>" + HomeAggregatorDataLoad.DataLoadVariables.insuranceDeclined + "</insuranceDeclined>\n" +
                            "               <currentInsurer>" + HomeAggregatorDataLoad.DataLoadVariables.currentInsurer + "</currentInsurer>\n" +
                            "               <yearsCurrentInsurer>" + HomeAggregatorDataLoad.DataLoadVariables.yearsCurrentInsurer + "</yearsCurrentInsurer>\n" +
                            "            </policy>\n" +
                            "            <property>\n" +
                            "               <address>\n" +
                            "                  <houseNumber>" + HomeAggregatorDataLoad.DataLoadVariables.houseNumber + "</houseNumber>\n" +
                            "                  <streetName>" + HomeAggregatorDataLoad.DataLoadVariables.streetName + "</streetName>\n" +
                            "                  <town>" + HomeAggregatorDataLoad.DataLoadVariables.town + "</town>\n" +
                            "                  <county>" + HomeAggregatorDataLoad.DataLoadVariables.county + " </county>\n" +
                            "                  <postcode>\n" +
                            "                     <postCodeOut>" + HomeAggregatorDataLoad.DataLoadVariables.postCodeOut + "</postCodeOut>\n" +
                            "                     <postCodeIn>" + HomeAggregatorDataLoad.DataLoadVariables.postCodeIn + "</postCodeIn>\n" +
                            "                  </postcode>\n" +
                            "               </address>\n" +
                            "               <firstTimeBuyer>" + HomeAggregatorDataLoad.DataLoadVariables.firstTimeBuyer + "</firstTimeBuyer>\n" +
                            "               <locks>" + HomeAggregatorDataLoad.DataLoadVariables.locks + "</locks>\n" +
                            "               <nacoss>" + HomeAggregatorDataLoad.DataLoadVariables.nacoss + "</nacoss>\n" +
                            "               <bedsCd>" + HomeAggregatorDataLoad.DataLoadVariables.bedsCd + "</bedsCd>\n" +
                            "               <addRoomsCd>" + HomeAggregatorDataLoad.DataLoadVariables.addRoomsCd + "</addRoomsCd>\n" +
                            "               <numAdultCd>" + HomeAggregatorDataLoad.DataLoadVariables.numAdultCd + "</numAdultCd>\n" +
                            "               <numChildCd>" + HomeAggregatorDataLoad.DataLoadVariables.numChildCd + "</numChildCd>\n" +
                            "               <ownCd>" + HomeAggregatorDataLoad.DataLoadVariables.ownCd + "</ownCd>\n" +
                            "               <propCd>" + HomeAggregatorDataLoad.DataLoadVariables.propCd + "</propCd>\n" +
                            "               <roofCd>" + HomeAggregatorDataLoad.DataLoadVariables.roofCd + "</roofCd>\n" +
                            "               <wallCd>" + HomeAggregatorDataLoad.DataLoadVariables.wallCd + "</wallCd>\n" +
                            "               <builtCd>" + HomeAggregatorDataLoad.DataLoadVariables.builtCd + "</builtCd>\n" +
                            "               <currentMortgageProvider>" + HomeAggregatorDataLoad.DataLoadVariables.currentMortgageProvider + "</currentMortgageProvider>\n" +
                            "            </property>\n" +
                            "            <proposers SOAP-ENC:arrayType=\"HomeProposer[1]\">\n" +
                            "               <Proposer>\n" +
                            "                  <title>" + HomeAggregatorDataLoad.DataLoadVariables.proposerTitle + "</title>\n" +
                            "                  <firstName>" + HomeAggregatorDataLoad.DataLoadVariables.proposerFirstName + "</firstName>\n" +
                            "                  <lastName>" + HomeAggregatorDataLoad.DataLoadVariables.proposerLastName + "</lastName>\n" +
                            "                  <dob>" + HomeAggregatorDataLoad.DataLoadVariables.proposerDateOfBirth + "</dob>\n" +
                            "                  <sex>" + HomeAggregatorDataLoad.DataLoadVariables.proposerGender + "</sex>\n" +
                            "                  <occCd>" + HomeAggregatorDataLoad.DataLoadVariables.occCd + "</occCd>\n" +
                            "                  <occDesc>" + HomeAggregatorDataLoad.DataLoadVariables.occDesc + "</occDesc>\n" +
                            "                  <eveningNum>" + HomeAggregatorDataLoad.DataLoadVariables.eveningNum + "</eveningNum>\n" +
                            "                  <daytimeNum>" + HomeAggregatorDataLoad.DataLoadVariables.daytimeNum + "</daytimeNum>\n" +
                            "                  <emailAddress>" + HomeAggregatorDataLoad.DataLoadVariables.emailAddress + "</emailAddress>\n" +
                            "                  <maritalCd>" + HomeAggregatorDataLoad.DataLoadVariables.maritalCd + "</maritalCd>\n" +
                            "                  <relationCd>" + HomeAggregatorDataLoad.DataLoadVariables.relationCd + "</relationCd>\n" +
                            "                  <address>\n" +
                            "                  <houseNumber>" + HomeAggregatorDataLoad.DataLoadVariables.houseNumber + "</houseNumber>\n" +
                            "                  <streetName>" + HomeAggregatorDataLoad.DataLoadVariables.streetName + "</streetName>\n" +
                            "                  <town>" + HomeAggregatorDataLoad.DataLoadVariables.town + "</town>\n" +
                            "                  <county>" + HomeAggregatorDataLoad.DataLoadVariables.county + "</county>\n" +
                            "                  <postcode>\n" +
                            "                     <postCodeOut>" + HomeAggregatorDataLoad.DataLoadVariables.postCodeOut + "</postCodeOut>\n" +
                            "                     <postCodeIn>" + HomeAggregatorDataLoad.DataLoadVariables.postCodeIn + "</postCodeIn>\n" +
                            "                  </postcode>\n" +
                            "               </address>\n" +
                            "                  <residency>\n" +
                            "                     <livedUkMonth>" + HomeAggregatorDataLoad.DataLoadVariables.livedUkMonth + "</livedUkMonth>\n" +
                            "                     <livedUkYear>" + HomeAggregatorDataLoad.DataLoadVariables.livedUkYear + "</livedUkYear>\n" +
                            "                  </residency>\n" +
                            "                  <isHomeOwner>" + HomeAggregatorDataLoad.DataLoadVariables.isHomeOwner + "</isHomeOwner>\n" +
                            "                  <yearsAtRiskAddress>" + HomeAggregatorDataLoad.DataLoadVariables.yearsAtRiskAddress + "</yearsAtRiskAddress>\n" +
                            "               </Proposer>\n" +
                            "            </proposers>\n" +
                            "            <requiredCovers>\n" +
                            "               <buildVarFlag>" + HomeAggregatorDataLoad.DataLoadVariables.buildVarFlag + "</buildVarFlag>\n" +
                            "               <buildingsFlag>" + HomeAggregatorDataLoad.DataLoadVariables.buildingsFlag + "</buildingsFlag>\n" +
                            "               <contentsFlag>" + HomeAggregatorDataLoad.DataLoadVariables.contentsFlag + "</contentsFlag>\n" +
                            "               <emergencyFlag>" + HomeAggregatorDataLoad.DataLoadVariables.emergencyFlag + "</emergencyFlag>\n" +
                            "               <flpFlag>" + HomeAggregatorDataLoad.DataLoadVariables.flpFlag + "</flpFlag>\n" +
                            "               <persPossFlag>" + HomeAggregatorDataLoad.DataLoadVariables.persPossFlag + "</persPossFlag>\n" +
                            "               <pestFlag>" + HomeAggregatorDataLoad.DataLoadVariables.pestFlag + "</pestFlag>\n" +
                            "               <specifiedItemsFlag>" + HomeAggregatorDataLoad.DataLoadVariables.specifiedItemsFlag + "</specifiedItemsFlag>\n" +
                            "            </requiredCovers>\n" +
                            "         </homeRequest>\n" +
                            "      </getAggHomeQuote>\n" +
                            "   </SOAP-ENV:Body>\n" +
                            "</SOAP-ENV:Envelope>")
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
                    .body("<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                            "   <SOAP-ENV:Body>\n" +
                            "      <getAggHomeQuote SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns=\"http://www.esure.com/SOA/ibisservice\">\n" +
                            "         <homeRequest xmlns=\"java:com.esure.busservices.cdm.aggregator.request\">\n" +
                            "            <aggId>" + HomeAggregatorDataLoad.DataLoadVariables.aggId + "</aggId>\n" +
                            "            <brands SOAP-ENC:arrayType=\"Brand[1]\">\n" +
                            "               <Brand>\n" +
                            "                  <brand>" + HomeAggregatorDataLoad.DataLoadVariables.brand + "</brand>\n" +
                            "               </Brand>\n" +
                            "            </brands>\n" +
                            "            <assumptions>\n" +
                            "               <specialTermsFlag>" + HomeAggregatorDataLoad.DataLoadVariables.specifiedItemsFlag + "</specialTermsFlag>\n" +
                            "               <convictionPendFlag>" + HomeAggregatorDataLoad.DataLoadVariables.convictionPendFlag + "</convictionPendFlag>\n" +
                            "               <repairStateFlag>" + HomeAggregatorDataLoad.DataLoadVariables.repairStateFlag + "</repairStateFlag>\n" +
                            "               <holidayHomeFlag>" + HomeAggregatorDataLoad.DataLoadVariables.holidayHomeFlag + "</holidayHomeFlag>\n" +
                            "               <unoccupiedFlag>" + HomeAggregatorDataLoad.DataLoadVariables.unoccupiedFlag + "</unoccupiedFlag>\n" +
                            "               <floodFlag>" + HomeAggregatorDataLoad.DataLoadVariables.floodFlag + "</floodFlag>\n" +
                            "               <subsidenceFlag>" + HomeAggregatorDataLoad.DataLoadVariables.subsidenceFlag + "</subsidenceFlag>\n" +
                            "               <listedFlag>" + HomeAggregatorDataLoad.DataLoadVariables.listedFlag + "</listedFlag>\n" +
                            "               <businessFlag>" + HomeAggregatorDataLoad.DataLoadVariables.businessFlag + "</businessFlag>\n" +
                            "               <treeDamageFlag>" + HomeAggregatorDataLoad.DataLoadVariables.treeDamageFlag + "</treeDamageFlag>\n" +
                            "               <tallTreeNearbyFlag>" + HomeAggregatorDataLoad.DataLoadVariables.tallTreeNearbyFlag + "</tallTreeNearbyFlag>\n" +
                            "               <buildingInProgressFlag>" + HomeAggregatorDataLoad.DataLoadVariables.buildingInProgressFlag + "</buildingInProgressFlag>\n" +
                            "               <prevInsBldCd>" + HomeAggregatorDataLoad.DataLoadVariables.prevInsBldCd + "</prevInsBldCd>\n" +
                            "               <rebuildingValue>" + HomeAggregatorDataLoad.DataLoadVariables.rebuildingValue + "</rebuildingValue>\n" +
                            "               <yearsBldInsWithoutClaim>" + HomeAggregatorDataLoad.DataLoadVariables.yearsBldInsWithoutClaim + "</yearsBldInsWithoutClaim>\n" +
                            "               <propertyValue>" + HomeAggregatorDataLoad.DataLoadVariables.propertyValue + "</propertyValue>\n" +
                            "               <prevInsConCd>" + HomeAggregatorDataLoad.DataLoadVariables.prevInsConCd + "</prevInsConCd>\n" +
                            "               <forSaleFlag>" + HomeAggregatorDataLoad.DataLoadVariables.forSaleFlag + "</forSaleFlag>\n" +
                            "               <bankruptFlag>" + HomeAggregatorDataLoad.DataLoadVariables.bankruptFlag + "</bankruptFlag>\n" +
                            "               <smokersFlag>" + HomeAggregatorDataLoad.DataLoadVariables.smokersFlag + "</smokersFlag>\n" +
                            "               <nWatchAreaFlag>" + HomeAggregatorDataLoad.DataLoadVariables.nWatchAreaFlag + "</nWatchAreaFlag>\n" +
                            "               <nWatchMemberFlag>" + HomeAggregatorDataLoad.DataLoadVariables.nWatchMemberFlag + "</nWatchMemberFlag>\n" +
                            "               <burglarAlarmCd>" + HomeAggregatorDataLoad.DataLoadVariables.burglarAlarmCd + "</burglarAlarmCd>\n" +
                            "               <alarmProfessionalFlag>" + HomeAggregatorDataLoad.DataLoadVariables.alarmProfessionalFlag + "</alarmProfessionalFlag>\n" +
                            "               <alarmPoliceFlag>" + HomeAggregatorDataLoad.DataLoadVariables.alarmPoliceFlag + "</alarmPoliceFlag>\n" +
                            "               <jointPropBankruptFlag>" + HomeAggregatorDataLoad.DataLoadVariables.jointPropBankruptFlag + "</jointPropBankruptFlag>\n" +
                            "               <occupiedByFamilyFlag>" + HomeAggregatorDataLoad.DataLoadVariables.occupiedByFamilyFlag + "</occupiedByFamilyFlag>\n" +
                            "               <selfContainedFlag>" + HomeAggregatorDataLoad.DataLoadVariables.selfContainedFlag + "</selfContainedFlag>\n" +
                            "            </assumptions>\n" +
                            "            <buildings>\n" +
                            "               <coverLevel>" + HomeAggregatorDataLoad.DataLoadVariables.coverLevel + "</coverLevel>\n" +
                            "               <ncdProtect>" + HomeAggregatorDataLoad.DataLoadVariables.ncdProtect + "</ncdProtect>\n" +
                            "               <ncdYrs>" + HomeAggregatorDataLoad.DataLoadVariables.ncdYrs + "</ncdYrs>\n" +
                            "               <sumIns>" + HomeAggregatorDataLoad.DataLoadVariables.sumIns + "</sumIns>\n" +
                            "               <volXs>250</volXs>\n" +
                            "               <claims SOAP-ENC:arrayType=\"HomeClaim[0]\" xsi:nil=\"true\"/>\n" +
                            "            </buildings>\n" +
                            "            <policy>\n" +
                            "               <startDate>" + Utils.getLocalDate() + "T00:00:00</startDate>\n" +
                            "               <insuranceDeclined>" + HomeAggregatorDataLoad.DataLoadVariables.insuranceDeclined + "</insuranceDeclined>\n" +
                            "               <currentInsurer>" + HomeAggregatorDataLoad.DataLoadVariables.currentInsurer + "</currentInsurer>\n" +
                            "               <yearsCurrentInsurer>" + HomeAggregatorDataLoad.DataLoadVariables.yearsCurrentInsurer + "</yearsCurrentInsurer>\n" +
                            "            </policy>\n" +
                            "            <property>\n" +
                            "               <address>\n" +
                            "                  <houseNumber>" + HomeAggregatorDataLoad.DataLoadVariables.houseNumber + "</houseNumber>\n" +
                            "                  <streetName>" + HomeAggregatorDataLoad.DataLoadVariables.streetName + "</streetName>\n" +
                            "                  <town>" + HomeAggregatorDataLoad.DataLoadVariables.town + "</town>\n" +
                            "                  <county>" + HomeAggregatorDataLoad.DataLoadVariables.county + " </county>\n" +
                            "                  <postcode>\n" +
                            "                     <postCodeOut>" + HomeAggregatorDataLoad.DataLoadVariables.postCodeOut + "</postCodeOut>\n" +
                            "                     <postCodeIn>" + HomeAggregatorDataLoad.DataLoadVariables.postCodeIn + "</postCodeIn>\n" +
                            "                  </postcode>\n" +
                            "               </address>\n" +
                            "               <firstTimeBuyer>" + HomeAggregatorDataLoad.DataLoadVariables.firstTimeBuyer + "</firstTimeBuyer>\n" +
                            "               <locks>" + HomeAggregatorDataLoad.DataLoadVariables.locks + "</locks>\n" +
                            "               <nacoss>" + HomeAggregatorDataLoad.DataLoadVariables.nacoss + "</nacoss>\n" +
                            "               <bedsCd>" + HomeAggregatorDataLoad.DataLoadVariables.bedsCd + "</bedsCd>\n" +
                            "               <addRoomsCd>" + HomeAggregatorDataLoad.DataLoadVariables.addRoomsCd + "</addRoomsCd>\n" +
                            "               <numAdultCd>" + HomeAggregatorDataLoad.DataLoadVariables.numAdultCd + "</numAdultCd>\n" +
                            "               <numChildCd>" + HomeAggregatorDataLoad.DataLoadVariables.numChildCd + "</numChildCd>\n" +
                            "               <ownCd>" + HomeAggregatorDataLoad.DataLoadVariables.ownCd + "</ownCd>\n" +
                            "               <propCd>" + HomeAggregatorDataLoad.DataLoadVariables.propCd + "</propCd>\n" +
                            "               <roofCd>" + HomeAggregatorDataLoad.DataLoadVariables.roofCd + "</roofCd>\n" +
                            "               <wallCd>" + HomeAggregatorDataLoad.DataLoadVariables.wallCd + "</wallCd>\n" +
                            "               <builtCd>" + HomeAggregatorDataLoad.DataLoadVariables.builtCd + "</builtCd>\n" +
                            "               <currentMortgageProvider>" + HomeAggregatorDataLoad.DataLoadVariables.currentMortgageProvider + "</currentMortgageProvider>\n" +
                            "            </property>\n" +
                            "            <proposers SOAP-ENC:arrayType=\"HomeProposer[1]\">\n" +
                            "               <Proposer>\n" +
                            "                  <title>" + HomeAggregatorDataLoad.DataLoadVariables.proposerTitle + "</title>\n" +
                            "                  <firstName>" + HomeAggregatorDataLoad.DataLoadVariables.proposerFirstName + "</firstName>\n" +
                            "                  <lastName>" + HomeAggregatorDataLoad.DataLoadVariables.proposerLastName + "</lastName>\n" +
                            "                  <dob>" + HomeAggregatorDataLoad.DataLoadVariables.proposerDateOfBirth + "</dob>\n" +
                            "                  <sex>" + HomeAggregatorDataLoad.DataLoadVariables.proposerGender + "</sex>\n" +
                            "                  <occCd>" + HomeAggregatorDataLoad.DataLoadVariables.occCd + "</occCd>\n" +
                            "                  <occDesc>" + HomeAggregatorDataLoad.DataLoadVariables.occDesc + "</occDesc>\n" +
                            "                  <eveningNum>" + HomeAggregatorDataLoad.DataLoadVariables.eveningNum + "</eveningNum>\n" +
                            "                  <daytimeNum>" + HomeAggregatorDataLoad.DataLoadVariables.daytimeNum + "</daytimeNum>\n" +
                            "                  <emailAddress>" + HomeAggregatorDataLoad.DataLoadVariables.emailAddress + "</emailAddress>\n" +
                            "                  <maritalCd>" + HomeAggregatorDataLoad.DataLoadVariables.maritalCd + "</maritalCd>\n" +
                            "                  <relationCd>" + HomeAggregatorDataLoad.DataLoadVariables.relationCd + "</relationCd>\n" +
                            "                  <address>\n" +
                            "                  <houseNumber>" + HomeAggregatorDataLoad.DataLoadVariables.houseNumber + "</houseNumber>\n" +
                            "                  <streetName>" + HomeAggregatorDataLoad.DataLoadVariables.streetName + "</streetName>\n" +
                            "                  <town>" + HomeAggregatorDataLoad.DataLoadVariables.town + "</town>\n" +
                            "                  <county>" + HomeAggregatorDataLoad.DataLoadVariables.county + "</county>\n" +
                            "                  <postcode>\n" +
                            "                     <postCodeOut>" + HomeAggregatorDataLoad.DataLoadVariables.postCodeOut + "</postCodeOut>\n" +
                            "                     <postCodeIn>" + HomeAggregatorDataLoad.DataLoadVariables.postCodeIn + "</postCodeIn>\n" +
                            "                  </postcode>\n" +
                            "               </address>\n" +
                            "                  <residency>\n" +
                            "                     <livedUkMonth>" + HomeAggregatorDataLoad.DataLoadVariables.livedUkMonth + "</livedUkMonth>\n" +
                            "                     <livedUkYear>" + HomeAggregatorDataLoad.DataLoadVariables.livedUkYear + "</livedUkYear>\n" +
                            "                  </residency>\n" +
                            "                  <isHomeOwner>" + HomeAggregatorDataLoad.DataLoadVariables.isHomeOwner + "</isHomeOwner>\n" +
                            "                  <yearsAtRiskAddress>" + HomeAggregatorDataLoad.DataLoadVariables.yearsAtRiskAddress + "</yearsAtRiskAddress>\n" +
                            "               </Proposer>\n" +
                            "            </proposers>\n" +
                            "            <requiredCovers>\n" +
                            "               <buildVarFlag>" + HomeAggregatorDataLoad.DataLoadVariables.buildVarFlag + "</buildVarFlag>\n" +
                            "               <buildingsFlag>" + HomeAggregatorDataLoad.DataLoadVariables.buildingsFlag + "</buildingsFlag>\n" +
                            "               <contentsFlag>" + HomeAggregatorDataLoad.DataLoadVariables.contentsFlag + "</contentsFlag>\n" +
                            "               <emergencyFlag>" + HomeAggregatorDataLoad.DataLoadVariables.emergencyFlag + "</emergencyFlag>\n" +
                            "               <flpFlag>" + HomeAggregatorDataLoad.DataLoadVariables.flpFlag + "</flpFlag>\n" +
                            "               <persPossFlag>" + HomeAggregatorDataLoad.DataLoadVariables.persPossFlag + "</persPossFlag>\n" +
                            "               <pestFlag>" + HomeAggregatorDataLoad.DataLoadVariables.pestFlag + "</pestFlag>\n" +
                            "               <specifiedItemsFlag>" + HomeAggregatorDataLoad.DataLoadVariables.specifiedItemsFlag + "</specifiedItemsFlag>\n" +
                            "            </requiredCovers>\n" +
                            "         </homeRequest>\n" +
                            "      </getAggHomeQuote>\n" +
                            "   </SOAP-ENV:Body>\n" +
                            "</SOAP-ENV:Envelope>")
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
    public static String getMotorQuote() throws Exception {
        String quoteReference;
        if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
            quoteReference = given()
                    .header("Authorization", TestDataUtils.AuthorizationCredentials.BASIC_AUTHORIZATION)
                    .contentType("text/xml")
                    .body("<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                            "   <SOAP-ENV:Body>\n" +
                            "      <getAggMotorQuote SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns=\"http://www.esure.com/SOA/ibisservice\">\n" +
                            "         <motorRequest xmlns=\"java:com.esure.busservices.cdm.aggregator.request\">\n" +
                            "            <aggId>" + MotorAggregatorDataLoad.DataLoadVariables.aggId + "</aggId>\n" +
                            "            <brands SOAP-ENC:arrayType=\"Brand[1]\">\n" +
                            "               <brand>\n" +
                            "                  <brand>" + MotorAggregatorDataLoad.DataLoadVariables.brand + "</brand>\n" +
                            "               </brand>\n" +
                            "            </brands>\n" +
                            "            <policy>\n" + MotorAggregatorDataLoad.DataLoadVariables.policy +
                            "               <startDate>" + Utils.getLocalDate() + "T00:00:00</startDate>\n" +
                            "               <currentInsurer>" + MotorAggregatorDataLoad.DataLoadVariables.currentInsurer + "</currentInsurer>\n" +
                            "               <insuranceDeclined>" + MotorAggregatorDataLoad.DataLoadVariables.insuranceDeclined + "</insuranceDeclined>\n" +
                            "               <prefPayMethCd>" + MotorAggregatorDataLoad.DataLoadVariables.prefPayMethCd + "</prefPayMethCd>\n" +
                            "            </policy>\n" +
                            "            <motorCov>\n" +
                            "               <covTypCd>" + MotorAggregatorDataLoad.DataLoadVariables.covTypCd + "</covTypCd>\n" +
                            "               <volXSCd>" + MotorAggregatorDataLoad.DataLoadVariables.volXSCd + "</volXSCd>\n" +
                            "               <ncdProtect>" + MotorAggregatorDataLoad.DataLoadVariables.ncdProtect + "</ncdProtect>\n" +
                            "               <numChildCd>" + MotorAggregatorDataLoad.DataLoadVariables.numChildCd + "</numChildCd>\n" +
                            "               <useOfOtherVehicleCd>" + MotorAggregatorDataLoad.DataLoadVariables.useOfOtherVehicleCd + "</useOfOtherVehicleCd>\n" +
                            "               <drvRestrictCd>" + MotorAggregatorDataLoad.DataLoadVariables.drvRestrictCd + "</drvRestrictCd>\n" +
                            "               <vehicleNums>" + MotorAggregatorDataLoad.DataLoadVariables.vehicleNums + "</vehicleNums>\n" +
                            "            </motorCov>\n" +
                            "            <vehicle>\n" +
                            "               <abiCd>" + MotorAggregatorDataLoad.DataLoadVariables.abiCd + "</abiCd>\n" +
                            "               <annMileCd>" + MotorAggregatorDataLoad.DataLoadVariables.annMileCd + "</annMileCd>\n" +
                            "               <annBusMiles>" + MotorAggregatorDataLoad.DataLoadVariables.annBusMiles + "</annBusMiles>\n" +
                            "               <daySituCd>" + MotorAggregatorDataLoad.DataLoadVariables.daySituCd + "</daySituCd>\n" +
                            "               <nightSituCd>" + MotorAggregatorDataLoad.DataLoadVariables.nightSituCd + "</nightSituCd>\n" +
                            "               <isEstValRaw>" + MotorAggregatorDataLoad.DataLoadVariables.isEstValRaw + "</isEstValRaw>\n" +
                            "               <notPurchasedYet>" + MotorAggregatorDataLoad.DataLoadVariables.notPurchasedYet + "</notPurchasedYet>\n" +
                            "               <purchaseDate>" + MotorAggregatorDataLoad.DataLoadVariables.purchaseDate + "</purchaseDate>\n" +
                            "               <estVal>" + MotorAggregatorDataLoad.DataLoadVariables.estVal + "</estVal>\n" +
                            "               <regDate>" + MotorAggregatorDataLoad.DataLoadVariables.regDate + "</regDate>\n" +
                            "               <vrm>" + MotorAggregatorDataLoad.DataLoadVariables.vrm + "</vrm>\n" +
                            "               <riskPostcode>\n" +
                            "                  <postCodeOut>" + MotorAggregatorDataLoad.DataLoadVariables.postCodeOut + "</postCodeOut>\n" +
                            "                  <postCodeIn>" + MotorAggregatorDataLoad.DataLoadVariables.postCodeIn + "</postCodeIn>\n" +
                            "               </riskPostcode>\n" +
                            "               <usage>" + MotorAggregatorDataLoad.DataLoadVariables.usage + "</usage>\n" +
                            "               <secDevice>" + MotorAggregatorDataLoad.DataLoadVariables.secDevice + "</secDevice>\n" +
                            "               <trackDevice>" + MotorAggregatorDataLoad.DataLoadVariables.trackDevice + "</trackDevice>\n" +
                            "               <isImport>" + MotorAggregatorDataLoad.DataLoadVariables.isImport + "</isImport>\n" +
                            "               <regKeeperCd>" + MotorAggregatorDataLoad.DataLoadVariables.regKeeperCd + "</regKeeperCd>\n" +
                            "               <legalOwnerCd>" + MotorAggregatorDataLoad.DataLoadVariables.legalOwnerCd + "</legalOwnerCd>\n" +
                            "            </vehicle>\n" +
                            "            <drivers SOAP-ENC:arrayType=\"Driver[1]\">\n" +
                            "               <driver>\n" +
                            "                  <title>" + MotorAggregatorDataLoad.DataLoadVariables.driverTitle + "</title>\n" +
                            "                  <firstName>" + MotorAggregatorDataLoad.DataLoadVariables.driverFirstName + "</firstName>\n" +
                            "                  <lastName>" + MotorAggregatorDataLoad.DataLoadVariables.driverLastName + "</lastName>\n" +
                            "                  <dob>" + MotorAggregatorDataLoad.DataLoadVariables.driverDateOfBirth + "</dob>\n" +
                            "                  <sex>" + MotorAggregatorDataLoad.DataLoadVariables.driverGender + "</sex>\n" +
                            "                  <occCd>" + MotorAggregatorDataLoad.DataLoadVariables.occCd + "</occCd>\n" +
                            "                  <occDesc>" + MotorAggregatorDataLoad.DataLoadVariables.occDesc + "</occDesc>\n" +
                            "                  <resStatusCd>" + MotorAggregatorDataLoad.DataLoadVariables.resStatusCd + "</resStatusCd>\n" +
                            "                  <eveningNum>" + MotorAggregatorDataLoad.DataLoadVariables.eveningNum + "</eveningNum>\n" +
                            "                  <daytimeNum>" + MotorAggregatorDataLoad.DataLoadVariables.daytimeNum + "</daytimeNum>\n" +
                            "                  <emailAddress>" + MotorAggregatorDataLoad.DataLoadVariables.emailAddress + "</emailAddress>\n" +
                            "                  <maritalCd>" + MotorAggregatorDataLoad.DataLoadVariables.maritalCd + "</maritalCd>\n" +
                            "                  <ncdYrs>" + MotorAggregatorDataLoad.DataLoadVariables.ncdYrs + "</ncdYrs>\n" +
                            "                  <relationCd>" + MotorAggregatorDataLoad.DataLoadVariables.relationCd + "</relationCd>\n" +
                            "                  <license>\n" +
                            "                     <typCd>" + MotorAggregatorDataLoad.DataLoadVariables.typCd + "</typCd>\n" +
                            "                     <testPassedMonth>" + MotorAggregatorDataLoad.DataLoadVariables.testPassedMonth + "</testPassedMonth>\n" +
                            "                     <testPassedYear>" + MotorAggregatorDataLoad.DataLoadVariables.testPassedYear + "</testPassedYear>\n" +
                            "                     <licRestrictCd>" + MotorAggregatorDataLoad.DataLoadVariables.licRestrictCd + "</licRestrictCd>\n" +
                            "                  </license>\n" +
                            "                  <residency>\n" +
                            "                     <livedUkMonth>" + MotorAggregatorDataLoad.DataLoadVariables.livedUkMonth + "</livedUkMonth>\n" +
                            "                     <livedUkYear>" + MotorAggregatorDataLoad.DataLoadVariables.livedUkYear + "</livedUkYear>\n" +
                            "                  </residency>\n" +
                            "                  <requireDoc>" + MotorAggregatorDataLoad.DataLoadVariables.requireDoc + "</requireDoc>\n" +
                            "                  <hasNonMotConv>" + MotorAggregatorDataLoad.DataLoadVariables.hasNonMotConv + "</hasNonMotConv>\n" +
                            "                  <isHomeOwner>" + MotorAggregatorDataLoad.DataLoadVariables.isHomeOwner + "</isHomeOwner>\n" +
                            "                  <hasChildUnder16>" + MotorAggregatorDataLoad.DataLoadVariables.hasChildUnder16 + "</hasChildUnder16>\n" +
                            "                  <address>\n" +
                            "                     <houseNumber>" + MotorAggregatorDataLoad.DataLoadVariables.houseNumber + "</houseNumber>\n" +
                            "                     <houseName xsi:nil=\"true\"/>\n" +
                            "                     <streetName>" + MotorAggregatorDataLoad.DataLoadVariables.streetName + "</streetName>\n" +
                            "                     <town>" + MotorAggregatorDataLoad.DataLoadVariables.town + "</town>\n" +
                            "                     <county>" + MotorAggregatorDataLoad.DataLoadVariables.county + "</county>\n" +
                            "                     <postcode>\n" +
                            "                        <postCodeOut>" + MotorAggregatorDataLoad.DataLoadVariables.postCodeOut + "</postCodeOut>\n" +
                            "                        <postCodeIn>" + MotorAggregatorDataLoad.DataLoadVariables.postCodeIn + "</postCodeIn>\n" +
                            "                     </postcode>\n" +
                            "                  </address>\n" +
                            "               </driver>\n" +
                            "            </drivers>\n" +
                            "         </motorRequest>\n" +
                            "      </getAggMotorQuote>\n" +
                            "   </SOAP-ENV:Body>\n" +
                            "</SOAP-ENV:Envelope>")
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
                    .body("<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n" +
                            "   <SOAP-ENV:Body>\n" +
                            "      <getAggMotorQuote SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns=\"http://www.esure.com/SOA/ibisservice\">\n" +
                            "         <motorRequest xmlns=\"java:com.esure.busservices.cdm.aggregator.request\">\n" +
                            "            <aggId>" + MotorAggregatorDataLoad.DataLoadVariables.aggId + "</aggId>\n" +
                            "            <brands SOAP-ENC:arrayType=\"Brand[1]\">\n" +
                            "               <brand>\n" +
                            "                  <brand>" + MotorAggregatorDataLoad.DataLoadVariables.brand + "</brand>\n" +
                            "               </brand>\n" +
                            "            </brands>\n" +
                            "            <policy>\n" + MotorAggregatorDataLoad.DataLoadVariables.policy +
                            "               <startDate>" + Utils.getLocalDate() + "T00:00:00</startDate>\n" +
                            "               <currentInsurer>" + MotorAggregatorDataLoad.DataLoadVariables.currentInsurer + "</currentInsurer>\n" +
                            "               <insuranceDeclined>" + MotorAggregatorDataLoad.DataLoadVariables.insuranceDeclined + "</insuranceDeclined>\n" +
                            "               <prefPayMethCd>" + MotorAggregatorDataLoad.DataLoadVariables.prefPayMethCd + "</prefPayMethCd>\n" +
                            "            </policy>\n" +
                            "            <motorCov>\n" +
                            "               <covTypCd>" + MotorAggregatorDataLoad.DataLoadVariables.covTypCd + "</covTypCd>\n" +
                            "               <volXSCd>" + MotorAggregatorDataLoad.DataLoadVariables.volXSCd + "</volXSCd>\n" +
                            "               <ncdProtect>" + MotorAggregatorDataLoad.DataLoadVariables.ncdProtect + "</ncdProtect>\n" +
                            "               <numChildCd>" + MotorAggregatorDataLoad.DataLoadVariables.numChildCd + "</numChildCd>\n" +
                            "               <useOfOtherVehicleCd>" + MotorAggregatorDataLoad.DataLoadVariables.useOfOtherVehicleCd + "</useOfOtherVehicleCd>\n" +
                            "               <drvRestrictCd>" + MotorAggregatorDataLoad.DataLoadVariables.drvRestrictCd + "</drvRestrictCd>\n" +
                            "               <vehicleNums>" + MotorAggregatorDataLoad.DataLoadVariables.vehicleNums + "</vehicleNums>\n" +
                            "            </motorCov>\n" +
                            "            <vehicle>\n" +
                            "               <abiCd>" + MotorAggregatorDataLoad.DataLoadVariables.abiCd + "</abiCd>\n" +
                            "               <annMileCd>" + MotorAggregatorDataLoad.DataLoadVariables.annMileCd + "</annMileCd>\n" +
                            "               <annBusMiles>" + MotorAggregatorDataLoad.DataLoadVariables.annBusMiles + "</annBusMiles>\n" +
                            "               <daySituCd>" + MotorAggregatorDataLoad.DataLoadVariables.daySituCd + "</daySituCd>\n" +
                            "               <nightSituCd>" + MotorAggregatorDataLoad.DataLoadVariables.nightSituCd + "</nightSituCd>\n" +
                            "               <isEstValRaw>" + MotorAggregatorDataLoad.DataLoadVariables.isEstValRaw + "</isEstValRaw>\n" +
                            "               <notPurchasedYet>" + MotorAggregatorDataLoad.DataLoadVariables.notPurchasedYet + "</notPurchasedYet>\n" +
                            "               <purchaseDate>" + MotorAggregatorDataLoad.DataLoadVariables.purchaseDate + "</purchaseDate>\n" +
                            "               <estVal>" + MotorAggregatorDataLoad.DataLoadVariables.estVal + "</estVal>\n" +
                            "               <regDate>" + MotorAggregatorDataLoad.DataLoadVariables.regDate + "</regDate>\n" +
                            "               <vrm>" + MotorAggregatorDataLoad.DataLoadVariables.vrm + "</vrm>\n" +
                            "               <riskPostcode>\n" +
                            "                  <postCodeOut>" + MotorAggregatorDataLoad.DataLoadVariables.postCodeOut + "</postCodeOut>\n" +
                            "                  <postCodeIn>" + MotorAggregatorDataLoad.DataLoadVariables.postCodeIn + "</postCodeIn>\n" +
                            "               </riskPostcode>\n" +
                            "               <usage>" + MotorAggregatorDataLoad.DataLoadVariables.usage + "</usage>\n" +
                            "               <secDevice>" + MotorAggregatorDataLoad.DataLoadVariables.secDevice + "</secDevice>\n" +
                            "               <trackDevice>" + MotorAggregatorDataLoad.DataLoadVariables.trackDevice + "</trackDevice>\n" +
                            "               <isImport>" + MotorAggregatorDataLoad.DataLoadVariables.isImport + "</isImport>\n" +
                            "               <regKeeperCd>" + MotorAggregatorDataLoad.DataLoadVariables.regKeeperCd + "</regKeeperCd>\n" +
                            "               <legalOwnerCd>" + MotorAggregatorDataLoad.DataLoadVariables.legalOwnerCd + "</legalOwnerCd>\n" +
                            "            </vehicle>\n" +
                            "            <drivers SOAP-ENC:arrayType=\"Driver[1]\">\n" +
                            "               <driver>\n" +
                            "                  <title>" + MotorAggregatorDataLoad.DataLoadVariables.driverTitle + "</title>\n" +
                            "                  <firstName>" + MotorAggregatorDataLoad.DataLoadVariables.driverFirstName + "</firstName>\n" +
                            "                  <lastName>" + MotorAggregatorDataLoad.DataLoadVariables.driverLastName + "</lastName>\n" +
                            "                  <dob>" + MotorAggregatorDataLoad.DataLoadVariables.driverDateOfBirth + "</dob>\n" +
                            "                  <sex>" + MotorAggregatorDataLoad.DataLoadVariables.driverGender + "</sex>\n" +
                            "                  <occCd>" + MotorAggregatorDataLoad.DataLoadVariables.occCd + "</occCd>\n" +
                            "                  <occDesc>" + MotorAggregatorDataLoad.DataLoadVariables.occDesc + "</occDesc>\n" +
                            "                  <resStatusCd>" + MotorAggregatorDataLoad.DataLoadVariables.resStatusCd + "</resStatusCd>\n" +
                            "                  <eveningNum>" + MotorAggregatorDataLoad.DataLoadVariables.eveningNum + "</eveningNum>\n" +
                            "                  <daytimeNum>" + MotorAggregatorDataLoad.DataLoadVariables.daytimeNum + "</daytimeNum>\n" +
                            "                  <emailAddress>" + MotorAggregatorDataLoad.DataLoadVariables.emailAddress + "</emailAddress>\n" +
                            "                  <maritalCd>" + MotorAggregatorDataLoad.DataLoadVariables.maritalCd + "</maritalCd>\n" +
                            "                  <ncdYrs>" + MotorAggregatorDataLoad.DataLoadVariables.ncdYrs + "</ncdYrs>\n" +
                            "                  <relationCd>" + MotorAggregatorDataLoad.DataLoadVariables.relationCd + "</relationCd>\n" +
                            "                  <license>\n" +
                            "                     <typCd>" + MotorAggregatorDataLoad.DataLoadVariables.typCd + "</typCd>\n" +
                            "                     <testPassedMonth>" + MotorAggregatorDataLoad.DataLoadVariables.testPassedMonth + "</testPassedMonth>\n" +
                            "                     <testPassedYear>" + MotorAggregatorDataLoad.DataLoadVariables.testPassedYear + "</testPassedYear>\n" +
                            "                     <licRestrictCd>" + MotorAggregatorDataLoad.DataLoadVariables.licRestrictCd + "</licRestrictCd>\n" +
                            "                  </license>\n" +
                            "                  <residency>\n" +
                            "                     <livedUkMonth>" + MotorAggregatorDataLoad.DataLoadVariables.livedUkMonth + "</livedUkMonth>\n" +
                            "                     <livedUkYear>" + MotorAggregatorDataLoad.DataLoadVariables.livedUkYear + "</livedUkYear>\n" +
                            "                  </residency>\n" +
                            "                  <requireDoc>" + MotorAggregatorDataLoad.DataLoadVariables.requireDoc + "</requireDoc>\n" +
                            "                  <hasNonMotConv>" + MotorAggregatorDataLoad.DataLoadVariables.hasNonMotConv + "</hasNonMotConv>\n" +
                            "                  <isHomeOwner>" + MotorAggregatorDataLoad.DataLoadVariables.isHomeOwner + "</isHomeOwner>\n" +
                            "                  <hasChildUnder16>" + MotorAggregatorDataLoad.DataLoadVariables.hasChildUnder16 + "</hasChildUnder16>\n" +
                            "                  <address>\n" +
                            "                     <houseNumber>" + MotorAggregatorDataLoad.DataLoadVariables.houseNumber + "</houseNumber>\n" +
                            "                     <houseName xsi:nil=\"true\"/>\n" +
                            "                     <streetName>" + MotorAggregatorDataLoad.DataLoadVariables.streetName + "</streetName>\n" +
                            "                     <town>" + MotorAggregatorDataLoad.DataLoadVariables.town + "</town>\n" +
                            "                     <county>" + MotorAggregatorDataLoad.DataLoadVariables.county + "</county>\n" +
                            "                     <postcode>\n" +
                            "                        <postCodeOut>" + MotorAggregatorDataLoad.DataLoadVariables.postCodeOut + "</postCodeOut>\n" +
                            "                        <postCodeIn>" + MotorAggregatorDataLoad.DataLoadVariables.postCodeIn + "</postCodeIn>\n" +
                            "                     </postcode>\n" +
                            "                  </address>\n" +
                            "               </driver>\n" +
                            "            </drivers>\n" +
                            "         </motorRequest>\n" +
                            "      </getAggMotorQuote>\n" +
                            "   </SOAP-ENV:Body>\n" +
                            "</SOAP-ENV:Envelope>")
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
}
