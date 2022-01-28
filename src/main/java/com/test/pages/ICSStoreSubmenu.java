package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreSubmenu extends ICSStoreMenu {
    private static By buttonAddSubMenu = Tools.aFromId("main_btnAddSection");
    private static By buttonRemoveSubMenu = Tools.aFromId("main_lbRemove");

    private static By fieldTitle = Tools.inputFromId("main_txtEditName");
    private static By buttonAddImage = Tools.inputFromId("main_imgbtnSelectImage");
    private static By buttonSaveSection = Tools.aFromId("main_lbApply");

    private static By linkBackToDining = Tools.byFromPropertyAndValue("a", "class", "link-back");


    public ICSStoreSubmenu addSubMenu (String sectionName, String  imageName){
        Pages.icsHeader().check4Frame();
        System.out.println("Checking for submenu");
        if (!verifyElementExist(getSectionByName(sectionName))){
            System.out.println("Submenu doesn't exist, creating...");
            click(buttonAddSubMenu);
            click(buttonAddImage);
            Pages.imageLibrary().assignImage(imageName);
            writeText(fieldTitle, sectionName);
            click(buttonSaveSection);
            System.out.println("Created");
        }
        else {
            System.out.println("Already exists");
        }
        return Pages.diningSubmenu();
    }

    public ICSStoreMenu goBackToDiningMenu(){
        Pages.icsHeader().check4Frame();
        click(linkBackToDining);
        return Pages.diningMenu();
    }

    public ICSStoreMenuManager gotoSubmenu(String menuName){
        gotoMenu(menuName);
        return Pages.diningMenuManager();
    }

}
