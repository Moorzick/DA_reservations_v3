package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class LaundryMenu extends ICSStoreMenu{
    static {
        fieldTitle = Tools.inputFromId("txtEditName");
        buttonAddImage = Tools.inputFromId("imgbtnSelectImage");
        buttonSaveSection = Tools.aFromId("lbApply");

        buttonAddMenu = Tools.inputFromId("btnAddSection");
        buttonRemoveMenu = Tools.inputFromId("lbRemove");

        linkBack = Tools.aFromHref("LaundryDefault.aspx");
    }

    public LaundryMenu addLaundrySection(String title, String image){
        addSection(title,image);
        return Pages.laundryMenu();
    }

    public LaundrySubMenu gotoLaundryMenu (String sectionName){
        gotoMenu(sectionName);
        return Pages.laundrySubmenu();
    }

    public By getSectionByName (String name){
        String xp = String.format("//a[contains(@id, 'rgSections') and text()='%s']", name);
        return By.xpath(xp);
    }

    public ICSLaundryStore goBackToLaundryStore (){
        backToStore();
        return Pages.laundryStore();
    }


}