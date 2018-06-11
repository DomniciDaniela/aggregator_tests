package helpers.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Verification {
    static WebDriver driver;

    @SuppressWarnings("unused")
    private static WebElement element = null;

    //Check Validation Text Is Present. Method to see if text is present on page
    public static void verifyContent(String destinationText, String SourceText) {
        System.out.println("Expected Text = " + SourceText + " ... " + "Actual Text = " + destinationText);
        try {
            //Clean up the destination text string to remove any commas and retain full values before comparing
            String UpdatedDestinationText = destinationText.replaceAll("[�,]", "");

            //Run a boolean statement to see of the text found in that field matches the text passed through into the method
            boolean b = UpdatedDestinationText.contentEquals(SourceText);
            if (b == true) {
                System.out.println("PASS: The text - " + destinationText + " - matched the entry in the source file.");
                //WriteToLogFile.main("PASS: The text - " + destinationText + " - successfully match the entry in the source file.");
            } else {
                System.out.println("FAIL: The text - " + destinationText + " - DID NOT match the entry in the source file.");
            }
        } catch (Exception e) {
            //WriteToLogFile.main("FAIL: The text - " + destinationText + " - DID NOT match the entry in the source file.");
        }
    }


}
