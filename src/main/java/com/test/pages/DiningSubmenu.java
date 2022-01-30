package com.test.pages;

import com.test.tools.Tools;

public class DiningSubmenu extends ICSStoreSubmenu{
    static{
        buttonAddSubMenu = Tools.aFromId("main_btnAddSection");
        buttonRemoveSubMenu = Tools.aFromId("main_lbRemove");
        fieldTitle = Tools.inputFromId("main_txtEditName");
        buttonAddImage = Tools.inputFromId("main_imgbtnSelectImage");
        buttonSaveSection = Tools.aFromId("main_lbApply");

        linkBack = Tools.byFromPropertyAndValue("a", "class", "link-back");

    }

    public DiningSubmenu addDiningSubmenu(String sectionName, String imageName){
        addSubMenu(sectionName, imageName);
        return Pages.diningSubmenu();
    }

    public DiningMenu goBacktoDiningMenu(){
        goBackToMenu();
        return Pages.diningMenu();
    }

    public ICSStoreMenuManager gotoDiningSubmenu(String menuName){
        gotoMenu(menuName);
        return Pages.diningMenuManager();
    }
}
