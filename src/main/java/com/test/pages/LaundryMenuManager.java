package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class LaundryMenuManager extends ICSStoreMenuManager{

    static {
        itemSelector="//span[@sortexpression='ItemName' and text()='%s']/parent::td/preceding-sibling::td/input";
    }

    public LaundryMenuManager addLaundryItem(String itemName) throws InterruptedException {
        addItem(itemName);
        return Pages.laundryMenuManager();
    }

    public LaundryMenuManager addLaundryItems(String[] items) throws InterruptedException {
        addItems(items);
        return Pages.laundryMenuManager();
    }
}
