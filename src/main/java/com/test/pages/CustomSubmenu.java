package com.test.pages;

public class CustomSubmenu extends ICSStoreSubmenu{

    public CustomSubmenu addCustomSubmenu(String title, String image){
        addSubMenu(title, image);
        return Pages.customSubmenu();
    }

    public CustomMenu goBackToCustomMenu (){
        goBackToMenu();
        return Pages.customMenu();
    }
}
