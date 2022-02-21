package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ICSMenu extends BasePage {

    protected static By sectionRows = By.xpath(Tools.xpContainsId("tr", "rgSections_ctl00__"));
    protected static By fieldTitle = Tools.inputFromId("tbSectionTitle");
    protected static By textareaDescription = Tools.textareaFromId("tbDescription");
    protected static By buttonSelectImage = Tools.inputFromId("imgbtnSelectImage");
    protected static By fieldURL = Tools.inputFromId("txtLink");

    protected static By rows = Tools.byContainsPropertyWithValue("tr", "id", "rgSections_ctl00__");

    protected static By buttonApply = Tools.aFromId("lbApply");
    protected static By linkBack = Tools.aContains("text()", "Back");

    protected static By buttonNew = Tools.inputFromId("btnNew");
    protected static By buttonRemove = Tools.inputFromId("lbRemoveSection");

    protected static String selectorTableRow = "//tr[@id='rgSections_ctl00__%d']";
    protected static String selectorRowByName = "//a[text()='%s']/parent::td/parent::tr";
    protected static String selectorCategorySelector = selectorTableRow+"//input[contains(@id, 'cbSelect')]";
    protected static String selectorCategoryActivator = selectorTableRow+"//input[contains(@id, 'chkActive')]";
    protected static String selectorCategoryEdit = selectorTableRow+"//a[@buttontype='Link']";
    protected static String selectorCategoryLink = selectorTableRow+"//a[contains(@id, 'hyEdit')]";


    protected int getSectionIndex (String sectionName){
        By row = By.xpath(String.format(selectorRowByName,sectionName));
        String rowId = getAttribute(row,"id");
        return Integer.parseInt(rowId.replaceAll("rgSections_ctl00__", ""));
    }

    protected void selectCategory (int index) throws InterruptedException {
        check(By.xpath(String.format(selectorCategorySelector, index)));
    }

    protected void activateCategory (int index) throws InterruptedException {
        check(getActivator(index));
    }

    protected By getActivator (int index){
        return getObjectFromSelector(selectorCategoryActivator,index);
    }

    protected void deActivateCategory (int index){
        uncheck(getActivator(index));
    }

    protected void editCategory (int index){
        click(String.format(selectorCategoryEdit, index));
    }

    protected void gotoSection (int index){
        click(getObjectFromSelector(selectorCategoryLink, index));
    }

    protected int getRowsCount (){
        return getAllElementsCount(sectionRows);
    }

    protected void saveCard(){
        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

    protected void goBack(){
        click(linkBack);
    }

}
