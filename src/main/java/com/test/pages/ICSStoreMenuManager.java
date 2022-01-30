package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreMenuManager extends ICSStoreMenu {
    private static By selectMenus = Tools.selectFromId("ddlMenu");
    private static By selectSubmenus = Tools.selectFromId("ddlSubMenu");
    protected static By buttonAddItems = Tools.aFromId("lbtnApply");
    protected static String itemSelector = "//td[@class='pretty-wrap-please' and text()='%s']/preceding-sibling::td/input";


    protected By getSelectorToAdd (String itemName){
        String xp=String.format(itemSelector, itemName);
        return By.xpath(xp);
    }

    protected void addItem (String itemName){
        Pages.icsHeader().check4Frame();
        check(getSelectorToAdd(itemName));
        click(buttonAddItems);
        Pages.icsHeader().checkForSuccess();
    }

    protected void addItems (String[] items){
        Pages.icsHeader().check4Frame();
        for (String i:items){
            System.out.println("Adding: "+i);
            check(getSelectorToAdd(i));
        }
        click(buttonAddItems);
        Pages.icsHeader().checkForSuccess();
    }

    public ICSStoreMenuManager addDiningItem(String itemName){
        addItem(itemName);
        return Pages.diningMenuManager();
    }

    public ICSStoreMenuManager addDiningItems(String[] items){
        addItems(items);
        return Pages.diningMenuManager();
    }
}
