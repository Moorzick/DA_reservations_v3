package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private final By loginField = By.xpath("//input[@id='id_username']");
    private final By passwordField = By.xpath("//input[@id='id_password']");
    private final By signInButton = By.xpath("//input[@type='submit']");

    public void authorization(String login, String password) {
        waitVisibility(loginField);
        writeText(loginField, login);
        writeText(passwordField, password);
        click(signInButton);
        System.out.println("Signed in");
    }
}
