package screens.home;

import helpers.TestDataUtils;
import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.TestBase.driver;

public class YourQuote {

    /**
     * Helper method to wait for page to load
     */
    public static void waitForScreen() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains(TestDataUtils.PageURLs.YOUR_QUOTE));
    }

    /**
     * Helper method to select 'Family Protection'
     */
    public static void selectFamilyProtection() throws Exception {
        WebElement protection = driver.findElement(By.id("checkboxflp"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to select 'Home Emergency'
     */
    public static void selectHomeEmergency() throws Exception {
        WebElement protection = driver.findElement(By.id("checkboxhe"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to select 'Travel Insurance'
     */
    public static void selectTravelInsurance() throws Exception {
        WebElement protection = driver.findElement(By.id("checkboxtr"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to select 'Pest Cover'
     */
    public static void selectPestCover() throws Exception {
        WebElement protection = driver.findElement(By.id("checkboxpes"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to select 'Winter Sport Cover'
     */
    public static void selectWinterSportCover() throws Exception {
        WebElement protection = driver.findElement(By.id("checkboxwin"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to validate if MLP popup si displayed
     */
    public static boolean isHelpPopupDisplayed() throws Exception {
        try {
            WebElement popup = driver.findElement(By.id("freeAddOnsPopup-panel"));
            return popup.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Helper method to validate if travel popup si displayed
     */
    public static boolean isTravelPopupDisplayed() throws Exception {
        WebElement popup = driver.findElement(By.id("context-help-testPopUp-panel"));
        return Utils.isWebElementIsDisplayed(popup, 2);
    }
    /**
     * Helper method to validate if travel popup si displayed
     */
    public static boolean isWinterSportsPopupDisplayed() throws Exception {
        WebElement popup = driver.findElement(By.id("context-help-possessionPopUp-panel"));
        return Utils.isWebElementIsDisplayed(popup, 2);
    }
}



