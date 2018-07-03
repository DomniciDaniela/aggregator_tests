import helpers.Utils;
import org.junit.Assert;
import screens.*;
import screens.motor.BreakdownsOptions;
import screens.motor.YourQuote;

import static helpers.TestBase.driver;
import static helpers.utility.ConfigLoad.ConfigLoadVariables.WEB_APP_ENVIRONMENT;

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
            if (!WEB_APP_ENVIRONMENT.equalsIgnoreCase("d")) {
                Assert.assertTrue("'Recalculate' button is not disabled", Utils.isRecalculateButtonDisabled());
            }

            selectProtection(Protection.FULL_PROTECTION);
            Thread.sleep(3000);
            Assert.assertNotEquals("FULL_PROTECTION - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("FULL_PROTECTION - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectProtection(Protection.JUST_IN_CASE_PROTECTION);
            Thread.sleep(3000);
            Assert.assertNotEquals("JUST_IN_CASE_PROTECTION - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("JUST_IN_CASE_PROTECTION - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectProtection(Protection.MLP_PROTECTION);
            Thread.sleep(3000);
            Assert.assertNotEquals("MLP_PROTECTION - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("MLP_PROTECTION - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectProtection(Protection.NO_PROTECTION);
            Thread.sleep(3000);
            Assert.assertEquals("NO_PROTECTION - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertEquals("NO_PROTECTION - The annual cost is not updated", annualCost, Utils.getAnnualCost());
        }

        Utils.clickNext();

        // Dismiss MLP popup
        if (selectAddon) {
            if (YourQuote.isMLPPopupDisplayed()) {
                Utils.clickNoThanks();
            }
        }

        BreakdownsOptions.waitForScreen();

        String breakdownMonthlyCost = Utils.getMonthlyCost();
        String breakdownAnnualCost = Utils.getAnnualCost();

        if (selectAddon) {
            if (!WEB_APP_ENVIRONMENT.equalsIgnoreCase("d")) {
                Assert.assertTrue("'Recalculate' button is not disabled", Utils.isRecalculateButtonDisabled());
            }

            selectCover(Breakdowns.ROAD_ASSISTANCE);
            Thread.sleep(3000);
            Assert.assertNotEquals("ROAD_ASSISTANCE - The monthly cost is not updated", breakdownMonthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("ROAD_ASSISTANCE - The annual cost is not updated", breakdownAnnualCost, Utils.getAnnualCost());

            selectCover(Breakdowns.RA_HOME_RESCUE);
            Thread.sleep(3000);
            Assert.assertNotEquals("RA_HOME_RESCUE - The monthly cost is not updated", breakdownMonthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("RA_HOME_RESCUE - The annual cost is not updated", breakdownAnnualCost, Utils.getAnnualCost());

            selectCover(Breakdowns.FULL_COVER);
            Thread.sleep(3000);
            Assert.assertNotEquals("FULL_COVER - The monthly cost is not updated", breakdownMonthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("FULL_COVER - The annual cost is not updated", breakdownAnnualCost, Utils.getAnnualCost());

            selectCover(Breakdowns.NO_COVER);
            Thread.sleep(3000);
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
                break;

            case JUST_IN_CASE_PROTECTION:
                YourQuote.selectJustInCase();
                break;

            case MLP_PROTECTION:
                YourQuote.selectMLP();
                break;

            case NO_PROTECTION:
                YourQuote.selectNoCover();
                break;
        }
    }

    private static void selectCover(Breakdowns breakdown) throws Exception {
        switch (breakdown) {
            case ROAD_ASSISTANCE:
                BreakdownsOptions.selectRoadsideAssisstance();
                break;

            case RA_HOME_RESCUE:
                BreakdownsOptions.selectRAAndHomeRescue();
                break;

            case FULL_COVER:
                BreakdownsOptions.selectFullCover();
                break;

            case NO_COVER:
                BreakdownsOptions.selectNoCover();
                break;
        }
    }

    public static void selectHomeCover(HomeCover cover) throws Exception {
        switch (cover) {
            case FAMILY_COVER:
                screens.home.YourQuote.selectFamilyProtection();
                break;

            case HOME_EMERGENCY:
                screens.home.YourQuote.selectHomeEmergency();
                break;

            case TRAVEL_INSURANCE:
                screens.home.YourQuote.selectTravelInsurance();
                if (screens.home.YourQuote.isTravelPopupDisplayed()) {
                    Utils.clickCloseButton();
                }
                break;

            case PEST_COVER:
                screens.home.YourQuote.selectPestCover();
                break;

            case WINTER_SPORTS:
                screens.home.YourQuote.selectWinterSportCover();
                if (screens.home.YourQuote.isWinterSportsPopupDisplayed()) {
                    Utils.clickCloseButton();
                }
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
            Thread.sleep(3000);
            Assert.assertEquals("FAMILY_COVER - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertEquals("FAMILY_COVER - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectHomeCover(HomeCover.HOME_EMERGENCY);
            Thread.sleep(3000);
            Assert.assertEquals("HOME_EMERGENCY - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertEquals("HOME_EMERGENCY - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectHomeCover(HomeCover.TRAVEL_INSURANCE);
            Thread.sleep(3000);
            Assert.assertNotEquals("TRAVEL_INSURANCE - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("TRAVEL_INSURANCE - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectHomeCover(HomeCover.PEST_COVER);
            Thread.sleep(3000);
            Assert.assertNotEquals("PEST_COVER - The monthly cost is not updated", monthlyCost, Utils.getMonthlyCost());
            Assert.assertNotEquals("PEST_COVER - The annual cost is not updated", annualCost, Utils.getAnnualCost());

            selectHomeCover(HomeCover.WINTER_SPORTS);
            Thread.sleep(3000);
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
        payMonthlyPolicy();
    }

    /**
     * Helper method to pay annually
     */
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

    /**
     * Helper method to pay monthly
     */
    public static void payMonthlyPolicy() throws Exception {
        PaymentOptions.waitForScreen();
        PaymentOptions.clickMonthlyPayment();
        PaymentOptions.clickBillingAddressSameAsPolicyYes();
        PaymentOptions.clickCardOwnerNo();

        Utils.clickNext();
        // Sometimes the following warning is visible and the user has to click 'Next' again
        // WARNING. Please don't use the back or forward buttons on your browser as you may lose your quote information.
        try {
            DirectDebitDetails.waitForScreen();
        } catch (Exception e) {
            Utils.clickNext();
            DirectDebitDetails.waitForScreen();
        }

        DirectDebitDetails.enterCardDetails();
        Utils.clickNext();

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
