package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;

public class LoginPage extends BasePage {


    private final By loginField = By.xpath("//input[@id='id_username']");
    private final By fieldLoginOld = Tools.inputFromId("tbUsername");
    private final By passwordField = By.xpath("//input[@id='id_password']");
    private final By fieldPassword = Tools.inputFromId("tbPassword");
    private final By signInButton = By.xpath("//input[@type='submit']");
    private final By buttonSignIn = Tools.inputFromId("btnLogin");

    private void authorization(String login, String password) {
            writeText(loginField, login);
            writeText(passwordField, password);
            click(signInButton);
        System.out.println("Signed in");
    }
    public DA authorize (String login, String password){
        authorization(login,password);
        return Pages.da();
    }
}
