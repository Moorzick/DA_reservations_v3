package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class CustomMenu extends ICSStoreMenu{
    /*static {
        linkBack = By.xpath("//span[@id='BackLabel']/parent::a");
    }*/

    public ICSCustomStore backToCustomStore (){
        backToStore();
        return Pages.customStore();
    }

    public CustomMenu addCustomMenu (String menuName, String imageName){
        addSection(menuName, imageName);
        return Pages.customMenu();
    }

    public CustomSubmenu gotoCustomMenu (String menuName){
        gotoMenu(menuName);
        return Pages.customSubmenu();
    }
}
