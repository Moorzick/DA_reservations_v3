package com.test.pages;

import org.openqa.selenium.By;

public class CustomMenuManager extends ICSStoreMenuManager{
    static {
        itemSelector="//span[contains(@id, 'gvItems') and text()='%s']/parent::td/preceding-sibling::td/input[@type='checkbox']";
    }

    private static By labelMenuManager = By.xpath("//span[text()='Menu Manager']");



    public ICSCustomStore addItemsToMenu (String [] items) throws InterruptedException {
        Pages.icsHeader().check4Frame();
        waitVisibility(labelMenuManager);
        addItems(items);
        return Pages.customStore();
    }

    public CustomMenuManager addItemToMenu (String item) throws InterruptedException {
        Pages.icsHeader().check4Frame();
        waitVisibility(labelMenuManager);
        addItem(item);
        return Pages.customMenuManager();
    }

}
