package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreMenu extends BasePage {
    protected static By fieldTitle = Tools.inputFromId("txtEditName");
    protected static By buttonAddImage = Tools.inputFromId("imgbtnSelectImage");
    protected static By buttonSaveSection = Tools.aFromId("lbApply");

    protected static By buttonAddMenu = Tools.inputFromId("btnAddSection");
    protected static By buttonRemoveMenu = Tools.inputFromId("lbRemove");

    protected static By linkBack = By.xpath("//span[@id='BackLabel']/parent::a");


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

    protected void addSection (String sectionName, String imageName) {
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

    protected void gotoMenu (String sectionName){
        Pages.icsHeader().check4Frame();
        click(getSectionByName(sectionName));
    }

    protected void backToStore(){
        Pages.icsHeader().check4Frame();
        click(linkBack);
    }

}
