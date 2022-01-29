package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class LaundryMenuManager extends ICSStoreMenuManager{

    static {
        buttonAddItems = Tools.aFromId("lbtnApply");
    }

    private By getSelectorToAdd (String itemName){
        String xp=String.format("//span[@sortexpression='ItemName' and text()='%s']/parent::td/preceding-sibling::td/input", itemName);
        return By.xpath(xp);
    }

    public LaundryMenuManager addItem(String itemName){
        Pages.icsHeader().check4Frame();
        click(getSelectorToAdd(itemName));
        click(buttonAddItems);
        Pages.icsHeader().checkForSuccess();
        return Pages.laundryMenuManager();
    }

    public LaundryMenuManager addItems(String[] items){
        Pages.icsHeader().check4Frame();
        for (String i:items){
            click(getSelectorToAdd(i));
        }
        click(buttonAddItems);
        Pages.icsHeader().checkForSuccess();
        return Pages.laundryMenuManager();
    }
}
