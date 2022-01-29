package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class LaundrySubMenu extends ICSStoreSubmenu{
    static {
        buttonAddSubMenu = Tools.inputFromId("btnAddSection");
        buttonRemoveSubMenu = Tools.inputFromId("lbRemove");

        fieldTitle = Tools.inputFromId("txtEditName");
        buttonAddImage = Tools.inputFromId("imgbtnSelectImage");
        buttonSaveSection = Tools.aFromId("lbApply");

        linkBack = Tools.aFromHref("LaundryMenuEdit.aspx");
    }

    public LaundrySubMenu addLaundrySubmenu (String sectionName, String image){
        addSubMenu(sectionName, image);
        return Pages.laundrySubmenu();
    }

    public LaundryMenu goBackToLaundryMenu(){
        goBacktoMenu();
        return Pages.laundryMenu();
    }

}
