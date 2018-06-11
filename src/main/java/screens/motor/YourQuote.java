package screens.motor;

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
     * Helper method to select 'Full Protection'
     */
    public static void selectFullProtection() throws Exception {
        WebElement protection = driver.findElement(By.id("radio_bundleSelectRadio_1"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to select 'Just In Case'
     */
    public static void selectJustInCase() throws Exception {
        WebElement protection = driver.findElement(By.id("radio_bundleSelectRadio_2"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to select 'Motor Legal Protection'
     */
    public static void selectMLP() throws Exception {
        WebElement protection = driver.findElement(By.id("radio_bundleSelectRadio_3"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to select 'No Cover'
     */
    public static void selectNoCover() throws Exception {
        WebElement protection = driver.findElement(By.id("radio_bundleSelectRadio_4"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to validate if MLP popup si displayed
     */
    public static boolean isMLPPopupDisplayed() throws Exception {
        WebElement mlp = driver.findElement(By.id("callCentreUpSellModal-panel_c"));
        return Utils.isWebElementIsDisplayed(mlp, 2);
    }
}
