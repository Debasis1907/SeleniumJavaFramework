package com.store.TestCases;

import com.store.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    String URL = readConfig.getBaseURL();
    String browserName = readConfig.getBrowser();

    public static WebDriver driver;

    @BeforeClass
    public void initializeBrowser() throws Exception {
        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new Exception("No browser matched");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public void captureScreenshot(WebDriver driver,String testName) throws IOException {

        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir")+"//src//test//resources//Screenshots//" + testName + ".png");
        FileUtils.copyFile(src,destination);
    }

}
