package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class ICSHeader extends BasePage {
    private static By headerContent= By.xpath("//span[contains(text(),'Content')]");
    private static By headerRequests= By.xpath("//span[contains(text(),'Requests')]");
    private static By headerMessages= By.xpath("//span[contains(text(),'Messages')]");
    private static By headerAccounts= By.xpath("//span[contains(text(),'Accounts')]");
    private static By headerHotelSetup= By.xpath("//span[contains(text(),'Hotel Setup')]");

    private static By contentStores= By.xpath("//a[@data-iframe-height='Stores']");
    private static By contentAds= By.xpath("//a[@data-iframe-height='Advertising']");
    private static By contentSysFunc= By.xpath("//a[@data-iframe-height='System Functions']");
    private static By contentMisc= By.xpath("//a[@data-iframe-height='Misc']");
    private static By contentMainMenu= By.xpath("//a[@data-iframe-height='Main Menu']");

    private static By droplistLang = By.xpath("//select[@id='ddLanguage']");
    private static By buttonContinueSection = By.xpath("//input[@id='Timeout1_btnContinue']");
    //private static By headerContent= By.xpath("//span[contains(text(),'Content')]");

    public void navigateToStores (){
        hoverAbove(headerContent);
        click(contentStores);
    }

    public void navigateToAds(){
        hoverAbove(headerContent);
        click(contentAds);
    }

    public SystemFunctions navigateToSystemFunctions () throws InterruptedException {
        switchOutOfFrame();
        System.out.println("Clicking 'Content'");
        click(headerContent);
        Thread.sleep(2000);
        System.out.println("Clicking 'SysFunc'");
        click(contentSysFunc);
        return Pages.systemFunctions();
    }

    public Misc navigateToMisc () throws InterruptedException {
        switchOutOfFrame();
        System.out.println("Clicking 'Content'");
        click(headerContent);
        System.out.println("Clicking 'Misc'");
        click(contentMisc);
        return Pages.misc();
    }

    public MainMenu navigateToMainMenu () throws InterruptedException {
        switchOutOfFrame();
        System.out.println("Clicking 'Content'");
        click(headerContent);
        System.out.println("Clicking 'Main Menu'");
        click(contentMainMenu);
        return Pages.mMenu();
    }

    public ICSWelcomeMenu switchLang (String langName){
        switchOutOfFrame();
        System.out.println("Switching to: "+langName);
        droplistSelectByName(droplistLang, langName);
        return Pages.icsWelcomeMenu();
    }

    public void check4Timeout (){
        switchOutOfFrame();
        System.out.println("Timeout?");
        if (verifyElementExist(buttonContinueSection)){
            System.out.println("yes, dismissing...");
            click(buttonContinueSection);
            System.out.println("Dismissed!");
        }
        else {
            System.out.println("No timeout!");
        }
        switch2Frame(By.xpath("//iframe"));
    }
}
