package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class LaundryCategories extends ICSStoreCategories{

    private static By edits = Tools.byFromPropertyAndValue("a", "itemstyle-cssclass", "lnkEdit");

    static {
        buttonAddCategory = Tools.inputFromId("btnAddSection");
        buttonRemoveCat = Tools.inputFromId("btnRemoveSection");
        fieldTitle = Tools.inputFromId("tbSectionTitle");
        buttonAddImage = Tools.inputFromId("imgbtnSelectImage");
        buttonSaveCat = Tools.aFromId("lbtnApply");

        linkBack = Tools.aFromHref("LaundryDefault.aspx");
    }

    public ICSLaundryStore backToLaundryStore(){
        backToStore();
        return Pages.laundryStore();
    }

    public LaundryCategories addLaundryCat (String title, String imageName){
        Pages.icsHeader().check4Frame();
        waitVisibility(edits);
        System.out.println("Checking for category...");
        if (!verifyElementExist(getCategory(title))){
            System.out.println("Not detected, creating...");
            click(buttonAddCategory);
            assignImage(imageName);
            writeText(fieldTitle, title);
            click(buttonSaveCat);
            System.out.println("Category saved!");
        }
        else {
            System.out.println("Exists, skipping");
        }
        return Pages.laundryCategories();
    }
}
