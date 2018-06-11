package screens.home;

import helpers.TestDataUtils;
import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.TestBase.driver;

public class QuoteDetails {

    /**
     * Helper method to wait for page to load
     */
    public static void waitForScreen() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains(TestDataUtils.PageURLs.QUOTE_DETAILS));
    }

    /**
     * Helper method to comfirm the details provided
     */
    public static void clickCorrectDeclaration() throws Exception {
        WebElement confirm = driver.findElement(By.id("detailsCorrectDeclaration"));
        Utils.clickWebElementAfterWait(confirm, 2);
    }

    /**
     * Helper method to agree terms and conditions
     */
    public static void clickTermsAndConditions() throws Exception {
        WebElement confirm = driver.findElement(By.id("confirmDetailsFlag"));
        Utils.clickWebElementAfterWait(confirm, 2);
    }
}
