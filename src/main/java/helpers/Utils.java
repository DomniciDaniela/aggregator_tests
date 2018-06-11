package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.TestBase.driver;

public class Utils {

    /**
     * Helper method to wait for a given webElement and check it's displayed
     *
     * @param webElement        - WebElement webElement
     * @param waitTimeInSeconds - number of seconds to wait the webElement
     * @return - true or false
     */
    public static boolean isWebElementIsDisplayed(WebElement webElement, int waitTimeInSeconds) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));

        return webElement.isDisplayed();
    }

    /**
     * Helper method to wait for a given webElement and click it after it's displayed
     *
     * @param webElement        - WebElement webElement
     * @param waitTimeInSeconds - number of seconds to wait the object
     */
    public static void clickWebElementAfterWait(WebElement webElement, int waitTimeInSeconds) throws Exception {
        if (isWebElementIsDisplayed(webElement, waitTimeInSeconds)) {
            webElement.click();
        } else {
            throw new Exception("Cannot find WebElement " + webElement);
        }
    }

    /**
     * Helper method to type text on a given element
     *
     * @param webElement - WebElement webElement
     * @param text       - text to be typed
     */
    public static void typeText(WebElement webElement, String text) throws Exception {
        if (webElement.isDisplayed()) {
            webElement.clear();
            webElement.sendKeys(text);
        } else {
            throw new Exception("Cannot find the WebElement " + webElement);
        }
    }

    /**
     * Helper method to wait for a given webElement and type the given text after it's displayed
     *
     * @param webElement        - WebElement webElement
     * @param text              - text to be typed
     * @param waitTimeInSeconds - number of seconds to wait the webElement
     */
    public static void typeTextAfterWait(WebElement webElement, int waitTimeInSeconds, String text) throws Exception {
        if (isWebElementIsDisplayed(webElement, waitTimeInSeconds)) {
            webElement.clear();
            webElement.sendKeys(text);
        } else {
            throw new Exception("Cannot find the WebElement " + webElement);
        }
    }

    /**
     * Helper method to wait for a given webElement and get text after it's displayed
     *
     * @param webElement        - WebElement webElement
     * @param waitTimeInSeconds - number of seconds to wait the webElement
     */
    public static String getTextAfterWait(WebElement webElement, int waitTimeInSeconds) throws Exception {
        if (isWebElementIsDisplayed(webElement, waitTimeInSeconds)) {
            return webElement.getText();
        } else {
            throw new Exception("Cannot find the WebElement " + webElement);
        }
    }

    /**
     * Helper method to navigate to a specific page
     */
    public static void navigatoTo(String url) throws Exception {
        driver.navigate().to(url);
    }

    /**
     * Helper method to click 'Next' button
     */
    public static void clickNext() throws Exception {
        try {
            WebElement next = driver.findElement(By.id("next"));
            clickWebElementJS(next);
        } catch (Exception e) {
            WebElement next = driver.findElement(By.cssSelector("#next_alt"));
            clickWebElementJS(next);
        }
    }

    /**
     * Helper method to scroll to element using JS
     */
    public static void scrollIntoViewJS(WebElement element) throws Exception {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    /**
     * Helper method to scroll to element using JS
     */
    public static void clickWebElementJS(WebElement element) throws Exception {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Helper method to click 'No Thanks' button
     */
    public static void clickNoThanks() throws Exception {
        WebElement button = driver.findElement(By.id("noThanksButton"));
        clickWebElementAfterWait(button, 2);
    }

    /**
     * Helper method to get the monthly cost
     */
    public static String getMonthlyCost() throws Exception {
        WebElement cost = driver.findElement(By.id("premiumAmountInstallments"));
        return cost.getText();
    }

    /**
     * Helper method to get the annual cost
     */
    public static String getAnnualCost() throws Exception {
        WebElement cost = driver.findElement(By.id("premiumAmount"));
        return cost.getText();
    }

    /**
     * Helper method to close cookie
     */
    public static void closeCookieBanner() throws Exception {
        WebElement element = driver.findElement(By.id("ensCloseBanner"));
        clickWebElementAfterWait(element, 0);
    }

    /**
     * Helper method to set 'PostCode'
     */
    public static void setPostCode(String postCode) throws Exception {
        WebElement code = driver.findElement(By.id("postCode"));
        Utils.typeTextAfterWait(code, 3, postCode);
    }

    /**
     * Helper method to verify if 'Mob Recalculate' button is displayed
     *
     * @return true/false
     */
    public static boolean isMobRecalculateButtonDisplayed() throws Exception {
        try {
            WebElement recalculate = driver.findElement(By.id("mobRecalculate"));
            return isWebElementIsDisplayed(recalculate, 1);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Helper method to verify if 'Recalculate' button is enabled
     *
     * @return true/false
     */
    public static boolean isRecalculateButtonEnabled() throws Exception {
        WebElement recalculate = driver.findElement(By.id("recalculate"));
        return recalculate.isEnabled();
    }

    /**
     * Helper method to verify if 'Recalculate' button is disabled
     *
     * @return true/false
     */
    public static boolean isRecalculateButtonDisabled() throws Exception {
        WebElement recalculate = driver.findElement(By.id("recalculateDisabled"));
        return recalculate.isDisplayed();
    }

    /**
     * Helper method to click 'Mob Recalculate' button
     */
    public static void clickMobRecalculateButton() throws Exception {
        WebElement recalculate = driver.findElement(By.id("mobRecalculate"));
        clickWebElementAfterWait(recalculate, 2);
    }

    /**
     * Helper method to click 'Recalculate' button
     */
    public static void clickRecalculateButton() throws Exception {
        WebElement recalculate = driver.findElement(By.id("recalculate"));
        clickWebElementAfterWait(recalculate, 4);
    }

    /**
     * Helper method to click 'Close' button
     */
    public static void clickCloseButton() throws Exception {
        WebElement button = driver.findElement(By.cssSelector("#context-help-travelPopUp-panel > div:nth-child(2) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
        clickWebElementJS(button);
    }

    /**
     * Helper method to get the local date
     * Format: 2018-06-04
     */
    public static String getLocalDate() throws Exception{
       String localDate = java.time.LocalDate.now().toString();

       System.out.println("Local date is:  " + localDate);
       return localDate;
    }
}
