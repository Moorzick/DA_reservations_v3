package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreMenu extends BasePage {
    protected static By fieldTitle = Tools.inputFromId("main_txtEditName");
    protected static By buttonAddImage = Tools.inputFromId("main_imgbtnSelectImage");
    protected static By buttonSaveSection = Tools.aFromId("main_lbApply");
    private static By buttonAddSchedule = Tools.aFromId("main_imgbtnAddPeriod");
    private static By buttonRemoveScedule = Tools.aFromId("main_btnRemovePeriod");
    private static By selectPeriod = Tools.selectFromId("main_ddlPeriod");
    private static By selectHoursStart = Tools.selectFromId("main_ddlStartHour");
    private static By selectMinsStart = Tools.selectFromId("main_ddlStartMinute");
    private static By selectAMPMStart = Tools.selectFromId("main_ddlStartAMPM");
    private static By selectHoursEnd = Tools.selectFromId("main_ddlEndHour");
    private static By selectMinsEnd = Tools.selectFromId("main_ddlEndMinute");
    private static By selectAMPMEnd = Tools.selectFromId("main_ddlEndAMPM");
    private static By buttonSaveSchedule = Tools.aFromId("main_lbtApplyPeriod");

    protected static By buttonAddMenu = Tools.aFromId("main_btnAddSection");
    protected static By buttonRemoveMenu = Tools.aFromId("main_lbRemove");

    protected static By linkBack = Tools.byFromPropertyAndValue("a", "class", "link-back");

    private static By optionPeriodDaily = Tools.byFromPropertyAndValue("option", "value", "DAILY");


    public By getSectionByName (String name){
        String xp = String.format("//a[contains(@id, 'rgSections') and text()='%s']", name);
        return By.xpath(xp);
    }

    private By getSelector (String sectionName){
        String xp = String.format("//a[contains(@id, 'rgSections') and text()='%s']/parent::td/preceding-sibling::td/input[@type='checkbox']", sectionName);
        return By.xpath(xp);
    }

    private By getActivator (String sectionName){
        String xp = String.format("//a[contains(@id, 'rgSections') and text()='%s']/parent::td/following-sibling::td/input[@type='checkbox']", sectionName);
        return By.xpath(sectionName);
    }

    private By getEdit (String sectionName){
        String xp = String.format("//a[contains(@id, 'rgSections') and text()='%s']/parent::td/following-sibling::td/a", sectionName);
        return By.xpath(xp);
    }

    private void setSchedule (String period, int sHrs, int sMins, String sAMPM, int eHrs, int eMins, String eAMPM){
        click(buttonAddSchedule);
        droplistSelectByName(selectPeriod, period);
        droplistSelectByIndex(selectHoursStart, sHrs-1);
        droplistSelectByIndex(selectMinsStart, sMins);
        droplistSelectByName(selectAMPMStart, sAMPM);
        droplistSelectByIndex(selectHoursEnd, eHrs-1);
        droplistSelectByIndex(selectMinsEnd, eMins);
        droplistSelectByName(selectAMPMEnd, eAMPM);
        click(buttonSaveSchedule);
    }

    public void addSchedule (String sectionName, String period, int sHrs, int sMins, String sAMPM, int eHrs, int eMins, String eAMPM){
        Pages.icsHeader().check4Frame();
        click(getEdit(sectionName));
        setSchedule(period, sHrs, sMins, sAMPM, eHrs, eMins, eAMPM);
        click(buttonSaveSection);
        Pages.icsHeader().checkForSuccess();
    }

    public ICSStoreMenu addDailySchedule (String sectionName){
        click(getEdit(sectionName));
        if (verifyElementExist(optionPeriodDaily)){
            System.out.println("Setting daily period");
            setSchedule("DAILY", 12, 0, "AM", 11, 59, "PM");
        }
        else {
            System.out.println("Already has daily period");
        }
        return Pages.diningMenu();
    }

    public ICSStoreMenu addDailySchedule (String sectionName, int sHrs, int sMins, String sAMPM, int eHrs, int eMins, String eAMPM ){
        click(getEdit(sectionName));
        if (verifyElementExist(optionPeriodDaily)){
            System.out.println("Setting daily period");
            setSchedule("DAILY", sHrs, sMins, sAMPM, eHrs, eMins, eAMPM);
        }
        else {
            System.out.println("Already has daily period");
        }
        return Pages.diningMenu();
    }

    public ICSStoreMenu addDiningSection(String sectionName, String  imageName){
        addSection(sectionName,imageName);
        return Pages.diningMenu();
    }

    protected void addSection (String sectionName, String  imageName) {
        Pages.icsHeader().check4Frame();
        System.out.println("Checking if this menu exists");
        if (!verifyElementExist(getSectionByName(sectionName))) {
            System.out.println("Its not, creating...");
            click(buttonAddMenu);
            click(buttonAddImage);
            Pages.imageLibrary().assignImage(imageName);
            writeText(fieldTitle, sectionName);
            click(buttonSaveSection);
            System.out.println("Saved!");
        } else {
            System.out.println("It exists, skipping");
        }
    }

    public ICSStoreSubmenu gotoDiningMenu (String sectionName){
        gotoMenu(sectionName);
        return Pages.diningSubmenu();
    }

    protected void gotoMenu (String sectionName){
        Pages.icsHeader().check4Frame();
        click(getSectionByName(sectionName));
    }

    public ICSDiningStore backToDiningStore (){
        backToStore();
        return Pages.diningStore();
    }

    protected void backToStore(){
        Pages.icsHeader().check4Frame();
        click(linkBack);
    }

}
