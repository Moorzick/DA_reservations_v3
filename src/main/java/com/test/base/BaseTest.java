package com.test.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeClass
//    public void setup () {
//        //Create a Chrome driver. All test classes use this.
//        //System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\ICS temp files\\chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        //Maximize Window
//        driver.manage().window().maximize();
//    }
    public void setup(){
        Configuration.browser = "chrome";
        Configuration.startMaximized=true;
        Configuration.screenshots=false;
        Configuration.pageLoadStrategy="normal";//eager ?
    }


    @AfterClass
    public void teardown () {
        closeWebDriver();
    }

    public void openURL(String url) throws InterruptedException {
        open(url);
        //WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}
