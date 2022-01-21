package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class SystemFunctions extends BasePage {
    private static By systemFunction= By.xpath("//a[@id='SystemFunctionList']");
    private static By functionRoleManager= By.xpath("//a[@href='HotelUserRoleFunctionList.aspx?section=System']");
    private static By metricsCategoryManager= By.xpath("//a[@href='SFMetrics.aspx']");
    private static By SIDs= By.xpath("//a[@href='SIDManager.aspx']");
    private static By language = By.xpath("//a[contains(@href, 'SystemLanguageList.aspx')]");

    private void goTo (By target){
        click(target);
    }

    public void gotoSystemFunctions(){
        switch2Frame(By.xpath("//iframe"));
        goTo(systemFunction);
    }

    public void goToFunctionRoles(){
        switch2Frame(By.xpath("//iframe"));
        goTo(functionRoleManager);
    }

    public void goToMetrics()
    {
        switch2Frame(By.xpath("//iframe"));
        goTo(metricsCategoryManager);
    }

    public void goToSIDs(){
        switch2Frame(By.xpath("//iframe"));
        goTo(SIDs);
    }

    public Language goToLang(){
        switch2Frame(By.xpath("//iframe"));
        goTo(language);
        return Pages.language();}
}
