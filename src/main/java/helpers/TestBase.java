package helpers;

import helpers.utility.*;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static boolean testCaseResultSuccess = true;

    public static WebDriver driver;

    /**
     * Helper method to launch the browser specified in Config file
     */
    public void launchBrowser(String browser) throws Exception {
        String OSType = System.getProperty("os.name");
        System.out.println("Your operating system is " + OSType);

        // Browser Setup (Check the OS and initialise the appropriate driver for Mac or Windows from the Driver folder with the application
        // Initialize browser
        if (OSType.equalsIgnoreCase("Mac OS X")) {
            switch (browser) {
                case "firefox":
                    System.out.println("Opening firefox driver");
                    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
                    driver = new FirefoxDriver();
                    break;

                case "chrome":
                    System.out.println("Opening chrome driver");
                    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
                    driver = new ChromeDriver();
                    break;

                case "safari":
                    driver = new SafariDriver();
                    break;

                    default:
                    System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
                    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
                    driver = new FirefoxDriver();
            }
        } else {
            switch (browser) {
                case "firefox":
                    System.out.println("Opening firefox driver");
                    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;

                case "chrome":
                    System.out.println("Opening chrome driver");
                    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;

                case "ie":
                    System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;

                    default:
                    System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
                    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
                    driver = new FirefoxDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Rule
    public TestWatcher testWatchman = new TestWatcher() {
        @Override
        protected void starting(Description d) {
            try {
                ConfigLoad.loadConfig(driver, 2);
                CardDetailsDataLoad.loadData(driver, 2);
                HomeAggregatorDataLoad.loadData(driver, 2);
                MotorAggregatorDataLoad.loadData(driver, 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void failed(Throwable e, Description description) {
            testCaseResultSuccess = false;
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File targetFile = new File(Constants.SCREENSHOTS_PATH + description.getMethodName() + "_" + timeStamp + ".png");
                FileUtils.copyFile(scrFile, targetFile);

                driver.close();
            } catch (Exception exp) {
                exp.printStackTrace();
                driver.close();
            }
        }

        @Override
        protected void succeeded(Description description) {
            driver.close();
        }
    };

}
