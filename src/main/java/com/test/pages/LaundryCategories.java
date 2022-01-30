package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class LaundryCategories extends ICSStoreCategories{

    protected static By edits = Tools.byFromPropertyAndValue("a", "itemstyle-cssclass", "lnkEdit");

    static {
        buttonAddCategory = Tools.inputFromId("btnAddSection");
        buttonRemoveCat = Tools.inputFromId("btnRemoveSection");
        fieldTitle = Tools.inputFromId("tbSectionTitle");
        buttonAddImage = Tools.inputFromId("imgbtnSelectImage");
        buttonSaveCat = Tools.aFromId("lbtnApply");
        edits = Tools.aContains("id", "rgSections");

        linkBack = Tools.aFromHref("LaundryDefault.aspx");
    }

    public ICSLaundryStore backToLaundryStore(){
        backToStore();
        return Pages.laundryStore();
    }

    public LaundryCategories addLaundryCat (String title, String imageName){
        addCat(title, imageName);
        return Pages.laundryCategories();
    }
}
