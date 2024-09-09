package com.amazon.base;

import com.amazon.propertyreader.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        String browser = PropertyReader.readProperties("browser");
        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--incongnito");
            chromeOptions.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(chromeOptions);

        } else if(browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--private");
            firefoxOptions.addArguments("--width=1200", "--height=800");
            driver = new FirefoxDriver(firefoxOptions);

        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }

        driver.get(PropertyReader.readProperties("url"));
    }

    @AfterClass
    public void tearDown() {
        waitFor3Seconds();
        driver.quit();
    }

    protected void waitFor3Seconds() {
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            System.out.println("Interrupted Exception thrown from wait method in BaseTest");
        }
    }
}
