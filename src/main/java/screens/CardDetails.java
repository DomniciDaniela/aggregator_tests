package screens;

import helpers.TestDataUtils;
import helpers.Utils;
import helpers.utility.CardDetailsDataLoad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.TestBase.driver;

public class CardDetails {

    /**
     * Helper method to wait for page to load
     */
    public static void waitForScreen() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains(TestDataUtils.PageURLs.CARD_DETAILS));
    }

    /**
     * Helper method to select 'CardType'
     */
    public static void selectCardType(String dropdownValue) throws Exception {
        Select dropdown = new Select(driver.findElement(By.id("capf1")));
        dropdown.selectByValue(dropdownValue);
    }

    /**
     * Helper method to set 'Card owner'
     */
    public static void setCardOwner(String owner) throws Exception {
        WebElement owner1 = driver.findElement(By.id("capf2"));
        Utils.typeText(owner1, owner);
    }

    /**
     * Helper method to set 'Card number'
     */
    public static void setCardNumber(String number) throws Exception {
        WebElement card = driver.findElement(By.id("card_number"));
        Utils.typeText(card, number);
    }

    /**
     * Helper method to select 'Card Expiry Month'
     */
    public static void selectCardExpiryMonth(String dropdownValue) throws Exception {
        Select dropdown = new Select(driver.findElement(By.name("exp_month")));
        dropdown.selectByValue(dropdownValue);
    }

    /**
     * Helper method to select 'Card Expiry Year'
     */
    public static void selectCardExpiryYear(String dropdownValue) throws Exception {
        Select dropdown = new Select(driver.findElement(By.name("exp_year")));
        dropdown.selectByValue(dropdownValue);
    }

    /**
     * Helper method to set 'Card security code'
     */
    public static void setCardSecurityCode(String code) throws Exception {
        WebElement card = driver.findElement(By.id("cv2_number"));
        Utils.typeText(card, code);
    }

    /**
     * Helper method to click 'Buy'
     */
    public static void clickBuyButton() throws Exception {
        WebElement buyButton = driver.findElement(By.id("continue"));
        Utils.scrollIntoViewJS(buyButton);
        Utils.clickWebElementJS(buyButton);
    }

    /**
     * Helper method to set card details
     */
    public static void enterCardDetails() throws Exception {
        // The card form is within an iframe
        driver.switchTo().frame("cardDetailsFrame");

        selectCardType(CardDetailsDataLoad.DataLoadVariables.sType);
        setCardOwner(CardDetailsDataLoad.DataLoadVariables.sCardOwner);
        setCardNumber(CardDetailsDataLoad.DataLoadVariables.sCardNumber);
        selectCardExpiryMonth(CardDetailsDataLoad.DataLoadVariables.sExpiryMonth);
        selectCardExpiryYear(CardDetailsDataLoad.DataLoadVariables.sExpiryYear);
        setCardSecurityCode(CardDetailsDataLoad.DataLoadVariables.sSecurityCode);
    }
}
