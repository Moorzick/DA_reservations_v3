package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreMenuManager extends ICSStoreMenu {
    private static By selectMenus = Tools.selectFromId("main_ddlMenu");
    private static By selectSubmenus = Tools.selectFromId("main_ddlSubMenu");

    private static By buttonAddItems = Tools.aFromId("main_lbtnApply");


    private By getSelectorToAdd (String itemName){
        String xp=String.format("//td[@class='pretty-wrap-please' and text()='%s']/preceding-sibling::td/input", itemName);
        return By.xpath(xp);
    }

    public ICSStoreMenuManager addItem(String itemName){
        Pages.icsHeader().check4Frame();
        click(getSelectorToAdd(itemName));
        click(buttonAddItems);
        Pages.icsHeader().checkForSuccess();
        return Pages.diningMenuManager();
    }

    public ICSStoreMenuManager addItems(String[] items){
        Pages.icsHeader().check4Frame();
        for (String i:items){
            click(getSelectorToAdd(i));
        }
        click(buttonAddItems);
        Pages.icsHeader().checkForSuccess();
        return Pages.diningMenuManager();
    }
}
