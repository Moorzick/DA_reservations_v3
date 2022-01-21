package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class Misc extends BasePage {
    private static By miscLanguage= By.xpath("//td[text()='Language']/following-sibling::td/a");
    private static By miscDesc= By.xpath("//a[@href='ICELabel.aspx']");
    private static By metricsCategoryManager= By.xpath("//a[@href='SFMetrics.aspx']");
    private static By SIDs= By.xpath("//a[@href='SIDManager.aspx']");

    private void goTo (By target){
        click(target);
    }

    public LanguageSetup gotoLanguage(){
        switch2Frame(By.xpath("//iframe"));
        goTo(miscLanguage);
        return Pages.languageSetup();
    }

    public ICEDesc gotoICEDesc(){
        switch2Frame(By.xpath("//iframe"));
        goTo(miscDesc);
        return Pages.iDesc();
    }

    /*public void goToFunctionRoles(){
        switch2Frame(By.xpath("//iframe"));
        goTo(functionRoleManager);
    }

    public void goToMetrics(){
        switch2Frame(By.xpath("//iframe"));
        goTo(metricsCategoryManager);
    }

    public void goToSIDs(){
        switch2Frame(By.xpath("//iframe"));
        goTo(SIDs);
    }*/
}
