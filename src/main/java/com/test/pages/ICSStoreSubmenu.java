package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreSubmenu extends ICSStoreMenu {
    protected static By buttonAddSubMenu = Tools.inputFromId("btnAddSection");
    protected static By buttonRemoveSubMenu = Tools.inputFromId("lbRemove");

    protected static By fieldTitle = Tools.inputFromId("txtEditName");
    protected static By buttonAddImage = Tools.inputFromId("imgbtnSelectImage");
    protected static By buttonSaveSection = Tools.aFromId("lbApply");

    protected static By linkBack = By.xpath("//span[@id='BackLabel']/parent::a");

    protected void addSubMenu (String sectionName, String  imageName) {
        Pages.icsHeader().check4Frame();
        System.out.println("Checking for submenu");
        if (!verifyElementExist(getSectionByName(sectionName))) {
            System.out.println("Submenu doesn't exist, creating...");
            click(buttonAddSubMenu);
            click(buttonAddImage);
            Pages.imageLibrary().assignImage(imageName);
            writeText(fieldTitle, sectionName);
            click(buttonSaveSection);
            System.out.println("Created");
        } else {
            System.out.println("Already exists");
        }
    }

    protected void goBackToMenu(){
        Pages.icsHeader().check4Frame();
        click(linkBack);
    }

}
