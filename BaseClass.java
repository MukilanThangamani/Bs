package TestBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

    public static WebDriver driver;   // 🔥 Static = shared across all test classes
    public static Logger logger;

    // ✅ Runs ONCE before ALL tests in ALL classes
    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() throws InterruptedException {
        logger = LogManager.getLogger(this.getClass());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
      // driver.get("https://stage.fabriplay.com/");
        driver.get("https://www.fabriplay.com");
        logger.info("🔥 Browser launched and navigated to https://stage.fabriplay.com/");
    }

    // ✅ Runs ONCE after ALL tests in ALL classes
    /*@AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
            logger.info("✅ Browser closed after all tests");
        }
    }*/

    // 🔢✅ Random data generator methods – kept as you had them
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String phoneRandom() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaAnumeric() {
        String num = RandomStringUtils.randomNumeric(2);
        String nam = RandomStringUtils.randomAlphabetic(3);
        return nam + "@" + num;
    }

    public String randomAmount() {
        return RandomStringUtils.randomNumeric(3);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(5);
    }

    public String randomLength() {
        return RandomStringUtils.randomNumeric(2);
    }
}
