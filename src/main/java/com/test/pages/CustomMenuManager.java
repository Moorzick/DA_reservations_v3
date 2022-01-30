package com.test.pages;

import org.openqa.selenium.By;

public class CustomMenuManager extends ICSStoreMenuManager{
    static {
        itemSelector="//span[contains(@id, 'gvItems') and text()='%s']/parent::td/preceding-sibling::td/input[@type='checkbox']";
    }



    public CustomMenuManager addItemsToMenu (String [] items){
        addItems(items);
        return Pages.customMenuManager();
    }

    public CustomMenuManager addItemToMenu (String item){
        addItem(item);
        return Pages.customMenuManager();
    }

}
