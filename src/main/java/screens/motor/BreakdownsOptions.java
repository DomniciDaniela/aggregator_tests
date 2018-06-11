package screens.motor;

import helpers.TestDataUtils;
import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.TestBase.driver;

public class BreakdownsOptions {

    /**
     * Helper method to wait for page to load
     */
    public static void waitForScreen() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains(TestDataUtils.PageURLs.BREAKDOWN_OPTIONS));
    }

    /**
     * Helper method to select 'Roadside Assistance'
     */
    public static void selectRoadsideAssisstance() throws Exception {
        WebElement protection = driver.findElement(By.id("breakdownCover_0"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to select 'Roadside Assistance and Home Rescue'
     */
    public static void selectRAAndHomeRescue() throws Exception {
        WebElement protection = driver.findElement(By.id("breakdownCover_1"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to select 'Roadside Assistance, Home Rescue and Recovery'
     */
    public static void selectFullCover() throws Exception {
        WebElement protection = driver.findElement(By.id("breakdownCover_2"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }

    /**
     * Helper method to select 'No Cover'
     */
    public static void selectNoCover() throws Exception {
        WebElement protection = driver.findElement(By.id("breakdownCover_3"));

        Utils.scrollIntoViewJS(protection);
        Utils.clickWebElementJS(protection);
    }
}
