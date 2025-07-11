
package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;

public class BaseTest {
    public static WebDriver driver;
    public static Properties configProp;
    public static Properties locatorsProp;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeTest
    public void loadFiles() throws IOException {
        configProp = new Properties();
        configProp.load(new FileInputStream("src/test/resources/properties/config.properties"));

        locatorsProp = new Properties();
        locatorsProp.load(new FileInputStream("src/test/resources/properties/locators.properties"));

        extent = ExtentReportManager.getReportInstance();
    }

    @BeforeMethod
    public void setup(Method method) {
        test = extent.createTest(method.getName());

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
        driver.manage().window().maximize();

        driver.get(configProp.getProperty("url"));
        test.info("Navigated to: " + configProp.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}
