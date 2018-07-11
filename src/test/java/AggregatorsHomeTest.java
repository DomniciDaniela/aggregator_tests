import helpers.TestBase;
import helpers.TestDataUtils;
import helpers.Utils;
import helpers.utility.ConfigLoad;
import helpers.utility.HomeAggregatorDataLoad;
import org.junit.Test;
import screens.Aggregators;

import static helpers.utility.ConfigLoad.ConfigLoadVariables.BROWSER;

public class AggregatorsHomeTest extends TestBase {

    @Test
    public void testHomeAggregatorAddonNotSelected_Esure() throws Exception {
        HomeAggregatorDataLoad.loadData(driver, 2);

        reachQuotePage();
        TestsValidation.endToEndHomeValidation(false);
    }

    @Test
    public void testHomeAggregatorAddonNotSelected_SW() throws Exception {
        HomeAggregatorDataLoad.loadData(driver, 2);

        reachQuotePage();
        TestsValidation.endToEndHomeValidation(false);
    }

    @Test
    public void testHomeAggregatorAddonSelected_Esure() throws Exception {
        HomeAggregatorDataLoad.loadData(driver, 2);

        reachQuotePage();
        TestsValidation.endToEndHomeValidation(true);
    }

    @Test
    public void testHomeAggregatorAddonSelected_SW() throws Exception {
        HomeAggregatorDataLoad.loadData(driver, 3);

        reachQuotePage();
        TestsValidation.endToEndHomeValidation(true);
    }

    private void reachQuotePage() throws Exception {
        String quoteId = ExtractQuotes.getHomeQuoteID();

        launchBrowser(BROWSER);

        if (HomeAggregatorDataLoad.DataLoadVariables.brand.equalsIgnoreCase(TestDataUtils.Brands.ESURE_HOME)) {
            if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
                Utils.navigatoTo(TestDataUtils.Aggregators.ESURE_DEV);
            } else {
                Utils.navigatoTo(TestDataUtils.Aggregators.ESURE);
            }
        } else {
            if (ConfigLoad.ConfigLoadVariables.IS_DEV.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
                Utils.navigatoTo(TestDataUtils.Aggregators.SW_DEV);
            } else {
                Utils.navigatoTo(TestDataUtils.Aggregators.SW);
            }
        }

        Aggregators.waitForScreen();

        Aggregators.setQuoteID(quoteId);
        String year = HomeAggregatorDataLoad.DataLoadVariables.proposerDateOfBirth.substring(0, 4);
        String month = HomeAggregatorDataLoad.DataLoadVariables.proposerDateOfBirth.substring(5, 7);
        String day  = HomeAggregatorDataLoad.DataLoadVariables.proposerDateOfBirth.substring(8, 10);

        Aggregators.setDateOfBirth(day + "/" + month + "/" + year);
        Aggregators.setPostCode(HomeAggregatorDataLoad.DataLoadVariables.postCodeOut + HomeAggregatorDataLoad.DataLoadVariables.postCodeIn);
        Aggregators.clickSubmit();
    }
}
