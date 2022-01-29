package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreSubmenu extends ICSStoreMenu {
    protected static By buttonAddSubMenu = Tools.aFromId("main_btnAddSection");
    protected static By buttonRemoveSubMenu = Tools.aFromId("main_lbRemove");

    protected static By fieldTitle = Tools.inputFromId("main_txtEditName");
    protected static By buttonAddImage = Tools.inputFromId("main_imgbtnSelectImage");
    protected static By buttonSaveSection = Tools.aFromId("main_lbApply");

    protected static By linkBack = Tools.byFromPropertyAndValue("a", "class", "link-back");


    public ICSStoreSubmenu addDiningSubmenu(String sectionName, String imageName){
        addSubMenu(sectionName, imageName);
        return Pages.diningSubmenu();
    }

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

    public ICSStoreMenu goBacktoMenu(){
        Pages.icsHeader().check4Frame();
        click(linkBack);
        return Pages.diningMenu();
    }

    public ICSStoreMenuManager gotoDiningSubmenu(String menuName){
        gotoMenu(menuName);
        return Pages.diningMenuManager();
    }

}
