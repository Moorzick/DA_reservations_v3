package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class DiningSubmenu extends DiningMenu {
    private static By buttonAddSubMenu = Tools.aFromId("main_btnAddSection");
    private static By buttonRemoveSubMenu = Tools.aFromId("main_lbRemove");

    private static By fieldTitle = Tools.inputFromId("main_txtEditName");
    private static By buttonAddImage = Tools.inputFromId("main_imgbtnSelectImage");
    private static By buttonSaveSection = Tools.inputFromId("main_lbApply");

    private static By linkBackToDining = Tools.byFromPropertyAndValue("a", "class", "link-back");


    public DiningSubmenu addSubMenu (String sectionName, String  imageName){
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

    public DiningMenu goBackToDiningMenu(){
        Pages.icsHeader().check4Frame();
        click(linkBackToDining);
        return Pages.diningMenu();
    }

    public DiningMenuManager gotoSubmenu(String menuName){
        gotoMenu(menuName);
        return Pages.diningMenuManager();
    }

}
