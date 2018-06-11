package screens;

import helpers.TestDataUtils;
import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.TestBase.driver;

public class PaymentOptions {

    /**
     * Helper method to wait for page to load
     */
    public static void waitForScreen() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains(TestDataUtils.PageURLs.PAYMENT_OPTIONS));
    }

    /**
     * Helper method to select monthly payment
     */
    public static void clickMonthlyPayment() throws Exception {
        WebElement payment = driver.findElement(By.id("paymentOption_0"));
        Utils.clickWebElementAfterWait(payment, 2);
    }

    /**
     * Helper method to select annual payment
     */
    public static void clickAnnualPayment() throws Exception {
        WebElement payment = driver.findElement(By.id("paymentOption_1"));
        Utils.clickWebElementAfterWait(payment, 2);
    }

    /**
     * Helper method to set the 'Billing Address Same As Policy' -Yes
     */
    public static void clickBillingAddressSameAsPolicyYes() throws Exception {
        WebElement billing = driver.findElement(By.id("billingAddrSameAsPolicyAddr_0"));
        Utils.clickWebElementAfterWait(billing, 2);
    }

    /**
     * Helper method to set the 'Billing Address Same As Policy' -No
     */
    public static void clickBillingAddressSameAsPolicyNo() throws Exception {
        WebElement billing = driver.findElement(By.id("billingAddrSameAsPolicyAddr_1"));
        Utils.clickWebElementAfterWait(billing, 2);
    }

    /**
     * Helper method to set the 'Card Owner' -Yes
     */
    public static void clickCardOwnerYes() throws Exception {
        WebElement owner = driver.findElement(By.id("cardOwnerPolicyHolder_0"));
        Utils.clickWebElementAfterWait(owner, 2);
    }

    /**
     * Helper method to set the 'Card Owner' - No
     */
    public static void clickCardOwnerNo() throws Exception {
        WebElement owner = driver.findElement(By.id("cardOwnerPolicyHolder_1"));
        Utils.clickWebElementJS(owner);
    }
}
