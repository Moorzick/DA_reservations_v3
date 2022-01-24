package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class ICSDiningStore extends BasePage {
    private static By managerMenu = By.xpath("//div[@class='ics six wide column panel']//a[@class='manager button item']");
    private static By managerCategory = By.xpath("//a[contains(@href, 'DiningCategory')");
    private static By managerOptions = By.xpath("//a[contains(@href, 'DiningOptionSetsManager')]");
    private static By addItem = By.xpath("//a[@id='main_btnAddItem']");

    public void gotoMenuManager (){
        click(managerMenu);
    }

    public void gotoCategoryManager (){
        click(managerCategory);
    }

    public void gotoOptionSetsManager(){
        click(managerOptions);
    }

    private ICSAddItemPage addItem (){
        click(addItem);
        return Pages.addItemPage();
    }

    private String getItemNameByIndex (int index){
        String itemNameXpath = String.format("//table[@id='main_gvItems']//tr[%d]/td[2]", index+1);
        return getAText(By.xpath(itemNameXpath));
    }

    private String getItemDescr (int index){
        String itemDescXpath = String.format("//table[@id='main_gvItems']//tr[%d]/td[3]/span", index+1);
        return getAText(By.xpath(itemDescXpath));
    }

}
