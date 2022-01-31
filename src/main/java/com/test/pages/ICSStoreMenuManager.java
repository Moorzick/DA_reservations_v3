package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreMenuManager extends ICSStoreMenu {
    private static By selectMenus = Tools.selectFromId("ddlMenu");
    private static By selectSubmenus = Tools.selectFromId("ddlSubMenu");
    protected static By buttonAddItems = Tools.aFromId("lbtnApply");
    protected static String itemSelector = "//td[@class='pretty-wrap-please' and text()='%s']/preceding-sibling::td/input";
    protected static String itemDetector = "//span[contains(@id,'rgSections') and text()='%s']";


    protected By getSelectorToAdd (String itemName){
        String xp=String.format(itemSelector, itemName);
        return By.xpath(xp);
    }

    protected void addItem (String itemName) throws InterruptedException {
        Pages.icsHeader().check4Frame();
        check(getSelectorToAdd(itemName));
        click(buttonAddItems);
        Pages.icsHeader().checkForSuccess();
    }

    protected boolean checkItemInMenu (String itemName){
        Pages.icsHeader().check4Frame();
        boolean inMenu = false;
        if(verifyElementExist(By.xpath(String.format(itemDetector, itemName)))){
            inMenu=true;
        }
        return inMenu;
    }

    protected void addItems (String[] items) throws InterruptedException {
        Pages.icsHeader().check4Frame();
        boolean wasAdded = false;
        for (int i=0; i<items.length;i++){
            System.out.println("Checking for "+items[i]);
            if (!checkItemInMenu(items[i])){
                System.out.println("Adding!");
                check(getSelectorToAdd(items[i]));
                wasAdded = true;
            }
            else {
                System.out.println("Item was already added");
            }
        }
        if (wasAdded){
            System.out.println("Saving changes...");
            click(buttonAddItems);
            Pages.icsHeader().checkForSuccess();
        }
        backToStore();
    }

    public ICSStoreMenuManager addDiningItem(String itemName) throws InterruptedException {
        addItem(itemName);
        return Pages.diningMenuManager();
    }

    public ICSStoreMenuManager addDiningItems(String[] items) throws InterruptedException {
        addItems(items);
        return Pages.diningMenuManager();
    }

    @Override
    protected void backToStore() {
        super.backToStore();
    }
}
