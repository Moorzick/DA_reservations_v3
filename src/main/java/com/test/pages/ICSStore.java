package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class ICSStore extends BasePage {
    protected static By managerMenu;
    protected static By managerCategory;
    protected static By managerOptions;
    protected static By addItem;

    protected static String locatorCategory = "//table[contains(@id, 'gvItemCategory')]//td[text()='%s']";

    protected void gotoMenuManager(){
        Pages.icsHeader().check4Frame();
        click(managerMenu);
    }

    protected void gotoCategoryManager(){
        Pages.icsHeader().check4Frame();
        click(managerCategory);
    }

    protected void gotoOptionSetsManager(){
        click(managerOptions);
    }

    private By getItem(String itemName){
        return By.xpath("");
    }

    protected By getCategory (String catName){
        return By.xpath(String.format(locatorCategory, catName));
    }

    protected boolean doesCategoryExist (String catName){
        Pages.icsHeader().check4Frame();
        boolean exists = verifyElementExist(getCategory(catName));
        return exists;
    }
}
