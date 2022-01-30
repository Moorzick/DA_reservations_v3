package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class DiningCategories extends ICSStoreCategories{

    static{
        buttonAddCategory = Tools.aFromId("main_btnAddSection");
        buttonRemoveCat = Tools.aFromId("main_btnRemoveSection");
        edits = Tools.aContains("id", "main_rgSections");
        fieldTitle = Tools.inputFromId("main_tbSectionTitle");
        buttonAddImage = Tools.inputFromId("main_imgbtnSelectImage");
        buttonSaveCat = Tools.aFromId("main_lbtnApply");
        linkBack = Tools.byFromPropertyAndValue("a", "class", "link-back");
    }



    public DiningCategories removeDiningUpsell (String catName){
        unUpsell(catName);
        return Pages.diningCategories();
    }

    public DiningCategories makeDiningUpsell (String catName){
        makeUpsell(catName);
        return Pages.diningCategories();
    }

    public DiningCategories addDiningCat (String title, String imageName){
        addCat(title,imageName);
        return Pages.diningCategories();
    }

    public ICSDiningStore backToDiningStore(){
        backToStore();
        return Pages.diningStore();
    }

}
