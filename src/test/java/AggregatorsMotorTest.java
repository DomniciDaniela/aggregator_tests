import helpers.TestBase;
import helpers.TestDataUtils;
import helpers.Utils;
import helpers.utility.ConfigLoad;
import helpers.utility.MotorAggregatorDataLoad;
import org.junit.Test;
import screens.*;

public class AggregatorsMotorTest extends TestBase {

    @Test
    public void testMotorGoCompareAddonSelected() throws Exception {
        String quoteId = ExtractQuotes.getMotorQuote();

        launchBrowser(ConfigLoad.ConfigLoadVariables.BROWSER);

        if (MotorAggregatorDataLoad.DataLoadVariables.brand.equalsIgnoreCase(TestDataUtils.Brands.ESURE_MOTOR)) {
            if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
                Utils.navigatoTo(TestDataUtils.Aggregators.ESURE_DEV);
            } else {
                Utils.navigatoTo(TestDataUtils.Aggregators.ESURE);
            }
        } else if(MotorAggregatorDataLoad.DataLoadVariables.brand.equalsIgnoreCase(TestDataUtils.Brands.SW_MOTOR)){
            if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
                Utils.navigatoTo(TestDataUtils.Aggregators.SW_DEV);
            } else {
                Utils.navigatoTo(TestDataUtils.Aggregators.SW);
            }
        } else {
            if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
                Utils.navigatoTo(TestDataUtils.Aggregators.FA);
            } else {
                Utils.navigatoTo(TestDataUtils.Aggregators.FA_DEV);
            }
        }

        Aggregators.waitForScreen();

        Aggregators.setQuoteID(quoteId);
        String year = MotorAggregatorDataLoad.DataLoadVariables.driverDateOfBirth.substring(0, 4);
        String month = MotorAggregatorDataLoad.DataLoadVariables.driverDateOfBirth.substring(5, 7);
        String day  = MotorAggregatorDataLoad.DataLoadVariables.driverDateOfBirth.substring(8, 10);

        Aggregators.setDateOfBirth(day + "/" + month + "/" + year);
        Aggregators.setPostCode(MotorAggregatorDataLoad.DataLoadVariables.postCodeOut + MotorAggregatorDataLoad.DataLoadVariables.postCodeIn);
        Aggregators.clickSubmit();

        TestsValidation.endToEndMotorValidation(true);
    }

    @Test
    public void testMotorGoCompareAddonNotSelected() throws Exception {
        String quoteId = ExtractQuotes.getMotorQuote();

        launchBrowser(ConfigLoad.ConfigLoadVariables.BROWSER);

        if (MotorAggregatorDataLoad.DataLoadVariables.brand.equalsIgnoreCase(TestDataUtils.Brands.ESURE_MOTOR)) {
            if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
                Utils.navigatoTo(TestDataUtils.Aggregators.ESURE_DEV);
            } else {
                Utils.navigatoTo(TestDataUtils.Aggregators.ESURE);
            }
        } else if(MotorAggregatorDataLoad.DataLoadVariables.brand.equalsIgnoreCase(TestDataUtils.Brands.SW_MOTOR)){
            if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
                Utils.navigatoTo(TestDataUtils.Aggregators.SW_DEV);
            } else {
                Utils.navigatoTo(TestDataUtils.Aggregators.SW);
            }
        } else {
            if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
                Utils.navigatoTo(TestDataUtils.Aggregators.FA);
            } else {
                Utils.navigatoTo(TestDataUtils.Aggregators.FA_DEV);
            }
        }

        Aggregators.waitForScreen();

        Aggregators.setQuoteID(quoteId);
        String year = MotorAggregatorDataLoad.DataLoadVariables.driverDateOfBirth.substring(0, 4);
        String month = MotorAggregatorDataLoad.DataLoadVariables.driverDateOfBirth.substring(5, 7);
        String day  = MotorAggregatorDataLoad.DataLoadVariables.driverDateOfBirth.substring(8, 10);

        Aggregators.setDateOfBirth(day + "/" + month + "/" + year);
        Aggregators.setPostCode(MotorAggregatorDataLoad.DataLoadVariables.postCodeOut + MotorAggregatorDataLoad.DataLoadVariables.postCodeIn);
        Aggregators.clickSubmit();

        TestsValidation.endToEndMotorValidation(false);
    }
}