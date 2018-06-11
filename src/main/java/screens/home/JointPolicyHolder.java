package screens.home;

import helpers.TestDataUtils;
import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.TestBase.driver;

public class JointPolicyHolder {

    /**
     * Helper method to wait for page to load
     */
    public static void waitForScreen() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains(TestDataUtils.PageURLs.YOUR_JOINT_POLICY_HOLDER));
    }

    /**
     * Helper method to select 'Title'
     */
    public static void selectTitle(String dropdownValue) throws Exception {
        Select dropdown = new Select(driver.findElement(By.id("title")));
        dropdown.selectByVisibleText(dropdownValue);
    }

    /**
     * Helper method to set 'FirstName'
     */
    public static void setFirstName(String firstName) throws Exception {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        Utils.typeText(firstNameField, firstName);
    }

    /**
     * Helper method to set 'LastName'
     */
    public static void setLastName(String lastName) throws Exception {
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        Utils.typeText(lastNameField, lastName);
    }

    /**
     * Helper method to set 'Gender' - Male
     */
    public static void clickGenderMale() throws Exception {
        WebElement gender = driver.findElement(By.id("label_gender_0"));
        Utils.clickWebElementAfterWait(gender, 2);
    }

    /**
     * Helper method to set 'UK Residence' - Female
     */
    public static void clickGenderFemale() throws Exception {
        WebElement gender = driver.findElement(By.id("label_gender_1"));
        Utils.clickWebElementAfterWait(gender, 2);
    }

    /**
     * Helper method to select 'MaritalStatus'
     */
    public static void selectMaritalStatus(String dropdownValue) throws Exception {
        Select dropdown = new Select(driver.findElement(By.id("maritalStatus")));
        dropdown.selectByVisibleText(dropdownValue);
    }

    /**
     * Helper method to set 'Occupation'
     */
    public static void setOcupation(String ocupation) throws Exception {
        WebElement occupationOther = driver.findElement(By.id("occupation"));
        Utils.typeText(occupationOther, ocupation);
    }

    /**
     * Helper method to select 'Relationship'
     */
    public static void selectRelationship(String dropdownValue) throws Exception {
        Select dropdown = new Select(driver.findElement(By.id("relationship")));
        dropdown.selectByVisibleText(dropdownValue);
    }

    /**
     * Helper method to set 'Birthday'
     */
    public static void setBirthday(String day, String month, String year) throws Exception {
        WebElement dob = driver.findElement(By.id("input-dob.day"));
        WebElement mob = driver.findElement(By.id("input-dob.month"));
        WebElement yob = driver.findElement(By.id("input-dob.year"));
        Utils.typeText(dob, day);
        Utils.typeText(mob, month);
        Utils.typeText(yob, year);
    }


}
