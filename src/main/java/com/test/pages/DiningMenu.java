package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class DiningMenu extends BasePage {
    private static By fieldTitle = Tools.inputFromId("main_txtEditName");
    private static By buttonAddImage = Tools.inputFromId("main_imgbtnSelectImage");
    private static By buttonSaveSection = Tools.inputFromId("main_lbApply");
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

    private static By buttonAddMenu = Tools.aFromId("main_btnAddSection");
    private static By buttonRemoveMenu = Tools.aFromId("main_lbRemove");

    private static By linkBack = Tools.byFromPropertyAndValue("a", "class", "link-back");


    public By getSectionByName (String name){
        String xp = String.format("//a[contains(@id, 'main_rgSections') and text()='%s']", name);
        return By.xpath(xp);
    }

    private By getSelector (String sectionName){
        String xp = String.format("//a[contains(@id, 'main_rgSections') and text()='%s']/parent::td/preceding-sibling::td/input[@type='checkbox']", sectionName);
        return By.xpath(xp);
    }

    private By getActivator (String sectionName){
        String xp = String.format("//a[contains(@id, 'main_rgSections') and text()='%s']/parent::td/following-sibling::td/input[@type='checkbox']", sectionName);
        return By.xpath(sectionName);
    }

    private By getEdit (String sectionName){
        String xp = String.format("//a[contains(@id, 'main_rgSections') and text()='%s']/parent::td/following-sibling::td/a", sectionName);
        return By.xpath(xp);
    }

    private void setSchedule (String period, int sHrs, int sMins, String sAMPM, int eHrs, int eMins, String eAMPM){
        click(buttonAddSchedule);
        droplistSelectByName(selectPeriod, period);
        droplistSelectByIndex(selectHoursStart, sHrs);
        droplistSelectByIndex(selectMinsStart, sMins);
        droplistSelectByName(selectAMPMStart, sAMPM);
        droplistSelectByIndex(selectHoursEnd, eHrs);
        droplistSelectByIndex(selectMinsEnd, eMins);
        droplistSelectByName(selectAMPMEnd, eAMPM);
        click(buttonSaveSchedule);
    }

    public void addSchedule (String sectionName, String period, int sHrs, int sMins, String sAMPM, int eHrs, int eMins, String eAMPM){
        Pages.icsHeader().check4Frame();
        click(getEdit(sectionName));
        setSchedule(period, sHrs, sMins, sAMPM, eHrs, eMins, eAMPM);
        click(buttonSaveSection);
    }

    public DiningMenu addDailySchedule (String sectionName){
        addSchedule(sectionName, "DAILY", 12, 00, "AM", 11, 59, "PM");
        return Pages.diningMenu();
    }

    public DiningMenu addSection (String sectionName, String  imageName){
        Pages.icsHeader().check4Frame();

        click(buttonAddImage);
        Pages.imageLibrary().assignImage(imageName);
        writeText(fieldTitle, sectionName);
        click(buttonSaveSection);
        return Pages.diningMenu();
    }

    public DiningSubmenu gotoMenu (String sectionName){
        Pages.icsHeader().check4Frame();
        click(getSectionByName(sectionName));
        return Pages.diningSubmenu();
    }

    public ICSDiningStore backToDiningStore (){
        Pages.icsHeader().check4Frame();
        click(linkBack);
        return Pages.diningStore();
    }

}
