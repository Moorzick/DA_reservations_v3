package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class ICSStore extends BasePage {
    protected static By managerMenu;
    protected static By managerCategory;
    protected static By managerOptions;
    protected static By addItem;

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
}
