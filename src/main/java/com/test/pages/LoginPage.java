package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private final By loginField = By.xpath("//input[@id='id_username']");
    private final By fieldLoginOld = Tools.inputFromId("tbUsername");
    private final By passwordField = By.xpath("//input[@id='id_password']");
    private final By fieldPassword = Tools.inputFromId("tbPassword");
    private final By signInButton = By.xpath("//input[@type='submit']");
    private final By buttonSignIn = Tools.inputFromId("btnLogin");

    public void authorization(String login, String password) {
        if (verifyElementExist(loginField)){
            writeText(loginField, login);
            writeText(passwordField, password);
            click(signInButton);
        }
        else {
            writeText(fieldLoginOld, login);
            writeText(fieldPassword, password);
            click(buttonSignIn);
        }
        System.out.println("Signed in");
    }
}
