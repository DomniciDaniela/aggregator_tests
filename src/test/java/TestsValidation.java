import helpers.Utils;
import org.junit.Assert;
import screens.CardDetails;
import screens.PaymentConfirmation;
import screens.PaymentOptions;
import screens.QuoteDetails;
import screens.motor.BreakdownsOptions;
import screens.motor.YourQuote;

import static helpers.TestBase.driver;

public class TestsValidation {

    public enum Protection {
        FULL_PROTECTION, JUST_IN_CASE_PROTECTION, MLP_PROTECTION, NO_PROTECTION
    }

    public enum Breakdowns {
        ROAD_ASSISTANCE, RA_HOME_RESCUE, FULL_COVER, NO_COVER
    }

    public enum HomeCover {
        FAMILY_COVER, HOME_EMERGENCY, TRAVEL_INSURANCE, PEST_COVER, WINTER_SPORTS
    }

    public static void endToEndMotorValidation(boolean selectAddon) throws Exception {
        YourQuote.waitForScreen();

        //Check for the Cookie Prompt and close if this is shown
        try {
            driver.switchTo().parentFrame();
            Utils.closeCookieBanner();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("No cookie prompt was shown and therefore ignored");
        }

        String monthlyCost = Utils.getMonthlyCost();
        String annualCost = Utils.getAnnualCost();

        if (selectAddon) {
            Assert.assertTrue("'Recalculate' button is not disabled", Utils.isRecalculateButtonDisabled());

            selectProtection(Protection.FULL_PROTECTION);
            Assert.assertNotEquals("FULL_PROTECTION - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("FULL_PROTECTION - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectProtection(Protection.JUST_IN_CASE_PROTECTION);
            Assert.assertNotEquals("JUST_IN_CASE_PROTECTION - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("JUST_IN_CASE_PROTECTION - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectProtection(Protection.MLP_PROTECTION);
            Assert.assertNotEquals("MLP_PROTECTION - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("MLP_PROTECTION - The annual cost is not updated", annualCost, Utils.getAnnualCost());
        } else {
            selectProtection(Protection.NO_PROTECTION);
            Assert.assertEquals("NO_PROTECTION - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertEquals("NO_PROTECTION - The annual cost is not updated", annualCost, Utils.getAnnualCost());

        }

        Utils.clickNext();

        // Dismiss MLP popup
        if (!selectAddon) {
            if (YourQuote.isMLPPopupDisplayed()) {
                Utils.clickNoThanks();
            }
        }

        BreakdownsOptions.waitForScreen();

        String breakdownMonthlyCost = Utils.getMonthlyCost();
        String breakdownAnnualCost = Utils.getAnnualCost();

        if (selectAddon) {
            Assert.assertTrue("'Recalculate' button is not disabled", Utils.isRecalculateButtonDisabled());

            selectCover(Breakdowns.ROAD_ASSISTANCE);
            Assert.assertNotEquals("ROAD_ASSISTANCE - The monthly cost is not updated", breakdownMonthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("ROAD_ASSISTANCE - The annual cost is not updated", breakdownAnnualCost, Utils.getAnnualCost());

            selectCover(Breakdowns.RA_HOME_RESCUE);
            Assert.assertNotEquals("RA_HOME_RESCUE - The monthly cost is not updated", breakdownMonthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("RA_HOME_RESCUE - The annual cost is not updated", breakdownAnnualCost, Utils.getAnnualCost());

            selectCover(Breakdowns.FULL_COVER);
            Assert.assertNotEquals("FULL_COVER - The monthly cost is not updated", breakdownMonthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("FULL_COVER - The annual cost is not updated", breakdownAnnualCost, Utils.getAnnualCost());
        } else {
            selectCover(Breakdowns.NO_COVER);
            Assert.assertEquals("NO_COVER - The monthly cost is not updated", breakdownMonthlyCost, Utils.getMonthlyCost());
            Assert.assertEquals("NO_COVER - The annual cost is not updated", breakdownAnnualCost, Utils.getAnnualCost());

        }
        Utils.clickNext();

        QuoteDetails.waitForScreen();
        QuoteDetails.clickConfirmDetails();
        QuoteDetails.clickProvideProof();
        QuoteDetails.clickTermsAndConditions();

        Utils.clickNext();
        payAnnualPolicy();
    }

    private static void selectProtection(Protection protection) throws Exception {
        switch (protection) {
            case FULL_PROTECTION:
                YourQuote.selectFullProtection();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickMobRecalculateButton();
                break;

            case JUST_IN_CASE_PROTECTION:
                YourQuote.selectJustInCase();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickRecalculateButton();
                break;

            case MLP_PROTECTION:
                YourQuote.selectMLP();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickMobRecalculateButton();
                break;

            case NO_PROTECTION:
                YourQuote.selectNoCover();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickMobRecalculateButton();
                break;
        }
    }

    private static void selectCover(Breakdowns breakdown) throws Exception {
        switch (breakdown) {
            case ROAD_ASSISTANCE:
                BreakdownsOptions.selectRoadsideAssisstance();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickMobRecalculateButton();
                break;

            case RA_HOME_RESCUE:
                BreakdownsOptions.selectRAAndHomeRescue();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickRecalculateButton();
                break;

            case FULL_COVER:
                BreakdownsOptions.selectFullCover();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickMobRecalculateButton();
                break;

            case NO_COVER:
                BreakdownsOptions.selectNoCover();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickMobRecalculateButton();
                break;
        }
    }

    public static void selectHomeCover(HomeCover cover) throws Exception {
        switch (cover) {
            case FAMILY_COVER:
                screens.home.YourQuote.selectFamilyProtection();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickMobRecalculateButton();
                break;

            case HOME_EMERGENCY:
                screens.home.YourQuote.selectHomeEmergency();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickRecalculateButton();
                break;

            case TRAVEL_INSURANCE:
                screens.home.YourQuote.selectTravelInsurance();
                if (screens.home.YourQuote.isTravelPopupDisplayed()) {
                    Utils.clickCloseButton();

                }

                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickRecalculateButton();
                break;

            case PEST_COVER:
                screens.home.YourQuote.selectPestCover();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickRecalculateButton();
                break;

            case WINTER_SPORTS:
                screens.home.YourQuote.selectWinterSportCover();
                Assert.assertTrue("'Mob Recalculate' button is not displayed", Utils.isMobRecalculateButtonDisplayed());
                Assert.assertTrue("'Recalculate' button is not enabled", Utils.isRecalculateButtonEnabled());
                Utils.clickRecalculateButton();
                break;
        }
    }

    /**
     * Helper method to generate Home Quote based on TestData input file
     */
    public static void endToEndHomeValidation(boolean selectAddon) throws Exception {
        screens.home.YourQuote.waitForScreen();
        // Check for the Cookie Prompt and close if this is shown
        try {
            driver.switchTo().parentFrame();
            Utils.closeCookieBanner();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("No cookie prompt was shown and therefore ignored");
        }

        String monthlyCost = Utils.getMonthlyCost();
        String annualCost = Utils.getAnnualCost();

        if (selectAddon) {
            selectHomeCover(HomeCover.FAMILY_COVER);
            Assert.assertEquals("FAMILY_COVER - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertEquals("FAMILY_COVER - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectHomeCover(HomeCover.HOME_EMERGENCY);
            Assert.assertEquals("HOME_EMERGENCY - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertEquals("HOME_EMERGENCY - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectHomeCover(HomeCover.TRAVEL_INSURANCE);
            Assert.assertNotEquals("TRAVEL_INSURANCE - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("TRAVEL_INSURANCE - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectHomeCover(HomeCover.PEST_COVER);
            Assert.assertNotEquals("PEST_COVER - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("PEST_COVER - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectHomeCover(HomeCover.WINTER_SPORTS);
            Assert.assertNotEquals("WINTER_SPORTS - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("WINTER_SPORTS - The annual cost is not updated", annualCost, Utils.getAnnualCost());
        }

        Utils.clickNext();

        if (!selectAddon) {
            if (screens.home.YourQuote.isHelpPopupDisplayed()) {
                Utils.clickNoThanks();
            }
        }

        screens.home.MoreDetails.waitForScreen();
        screens.home.MoreDetails.enterMoreDetails();

        Utils.clickNext();
        screens.home.QuoteDetails.waitForScreen();
        screens.home.QuoteDetails.clickCorrectDeclaration();
        screens.home.QuoteDetails.clickTermsAndConditions();

        Utils.clickNext();
        payAnnualPolicy();
    }

    public static void payAnnualPolicy() throws Exception {
        PaymentOptions.waitForScreen();
        PaymentOptions.clickAnnualPayment();
        PaymentOptions.clickBillingAddressSameAsPolicyYes();
        PaymentOptions.clickCardOwnerNo();

        Utils.clickNext();
        // Sometimes the following warning is visible and the user has to click 'Next' again
        // WARNING. Please don't use the back or forward buttons on your browser as you may lose your quote information.
        try {
            CardDetails.waitForScreen();
        } catch (Exception e) {
            Utils.clickNext();
            CardDetails.waitForScreen();
        }

        CardDetails.enterCardDetails();
        CardDetails.clickBuyButton();

        // Sometimes there is an error when trying to complete the payment
        // We have been unable to complete your card payment. This can be for one of a number of reasons including your card failing the 3D Secure security checks or a lack of funds.
        // Please check your card details, choose another card or
        try {
            PaymentConfirmation.waitForScreen();
        } catch (Exception e) {
            CardDetails.enterCardDetails();
            CardDetails.clickBuyButton();
            PaymentConfirmation.waitForScreen();
        }
    }
}
