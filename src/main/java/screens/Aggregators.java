package screens;

import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.TestBase.driver;

public class Aggregators {

    /**
     * Helper method to wait for page to load
     */
    public static void waitForScreen() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains("testlink.jsp"));
    }


    /**
     * Helper method to set 'QuoteID'
     */
    public static void setQuoteID(String number) throws Exception {
        WebElement quote = driver.findElement(By.id("quoteId"));
        Utils.typeText(quote, number);
    }

    /**
     * Helper method to set 'Date of Birth'
     */
    public static void setDateOfBirth(String dob) throws Exception {
        WebElement date = driver.findElement(By.id("dob"));
        Utils.typeText(date, dob);
    }

    /**
     * Helper method to set 'PostCode'
     */
    public static void setPostCode(String postcode) throws Exception {
        WebElement postcode1 = driver.findElement(By.id("postcode"));
        Utils.typeText(postcode1, postcode);
    }

    /**
     * Helper method to click Submit button
     */
    public static void clickSubmit() throws Exception {
        WebElement submit = driver.findElement(By.className("submit-btn"));
        Utils.clickWebElementAfterWait(submit, 2);
    }


}
