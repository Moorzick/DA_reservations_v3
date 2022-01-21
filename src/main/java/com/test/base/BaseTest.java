package com.test.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\ICS temp files\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }
    public void openURL(String url) throws InterruptedException {
        driver.get(url);
    }
}
