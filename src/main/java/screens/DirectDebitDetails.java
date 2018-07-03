package screens;

import helpers.TestDataUtils;
import helpers.Utils;
import helpers.utility.CardDetailsDataLoad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.TestBase.driver;

public class DirectDebitDetails {

    /**
     * Helper method to wait for page to load
     */
    public static void waitForScreen() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains(TestDataUtils.PageURLs.DIRECT_DEBIT));
    }

    /**
     * Helper method to click 'Account Holder Yes'
     */
    public static void clickAccountHolderYes() throws Exception {
        WebElement button = driver.findElement(By.id("soleOwner_0"));
        Utils.clickWebElementJS(button);
    }

    /**
     * Helper method to click 'Account Holder No'
     */
    public static void clickAccountHolderNo() throws Exception {
        WebElement button = driver.findElement(By.id("soleOwner_1"));
        Utils.clickWebElementJS(button);
    }

    /**
     * Helper method to set 'Account owner'
     */
    public static void setAccountOwner(String owner) throws Exception {
        WebElement owner1 = driver.findElement(By.id("accountHolderName"));
        Utils.typeText(owner1, owner);
    }

    /**
     * Helper method to set 'Sort Code'
     */
    public static void setSortCode(String sortCodePart1, String sortCodePart2, String sortCodePart3) throws Exception {
        WebElement sortcode1 = driver.findElement(By.id("sortCodePart1"));
        WebElement sortcode2 = driver.findElement(By.id("sortCodePart2"));
        WebElement sortcode3 = driver.findElement(By.id("sortCodePart3"));
        Utils.typeText(sortcode1, sortCodePart1);
        Utils.typeText(sortcode2, sortCodePart2);
        Utils.typeText(sortcode3, sortCodePart3);
    }

    /**
     * Helper method to set 'Account number'
     */
    public static void setAccountNumber(String accountNo) throws Exception {
        WebElement number = driver.findElement(By.id("accountNo"));
        Utils.typeText(number, accountNo);
    }

    /**
     * Helper method to set 'Bank names'
     */
    public static void setBankName(String name) throws Exception {
        WebElement bankName = driver.findElement(By.id("bankName"));
        Utils.typeText(bankName, name);
    }

    /**
     * Helper method to set card details
     */
    public static void enterCardDetails() throws Exception {
        if (CardDetailsDataLoad.DataLoadVariables.sAccountHolder.equalsIgnoreCase(TestDataUtils.Flags.YES)) {
            clickAccountHolderYes();
        } else {
            clickAccountHolderNo();
        }

        setAccountOwner(CardDetailsDataLoad.DataLoadVariables.sHolderName);
        setSortCode(CardDetailsDataLoad.DataLoadVariables.sSortCodePart1,
                CardDetailsDataLoad.DataLoadVariables.sSortCodePart2, CardDetailsDataLoad.DataLoadVariables.sSortCodePart3);
        setAccountNumber(CardDetailsDataLoad.DataLoadVariables.sAccountNumber);
        setBankName(CardDetailsDataLoad.DataLoadVariables.sBankName);
    }
}
