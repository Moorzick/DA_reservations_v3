package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

import java.util.Random;

public class ICSDiningStore extends BasePage {
    protected static By managerMenu = By.xpath("//div[@class='ics six wide column panel']//a[@class='manager button item']");
    protected static By managerCategory = By.xpath("//a[contains(@href, 'DiningCategory')]");
    protected static By managerOptions = By.xpath("//a[contains(@href, 'DiningOptionSetsManager')]");
    protected static By addItem = By.xpath("//a[@id='main_btnAddItem']");

    public ICSStoreMenu gotoMenuManager (){
        Pages.icsHeader().check4Frame();
        click(managerMenu);
        return Pages.diningMenu();
    }

    public ICSStoreCategories gotoCategoryManager (){
        Pages.icsHeader().check4Frame();
        click(managerCategory);
        return Pages.diningCategories();
    }

    public void gotoOptionSetsManager(){
        click(managerOptions);
    }

    public ICSDiningStore addItem (String title, String price, String category, String tax, String image){
        Pages.icsHeader().check4Frame();
        System.out.println("Does item "+title+ "exist?");
        if (!verifyElementExist(getItem(title))){
            System.out.println("No, creating...");
            click(addItem);
            Pages.addItemPage().addItem(title, price,category,tax,image);
        }
        else {
            System.out.println("Yes, skipping");
        }

        return Pages.diningStore();
    }

    public ICSDiningStore addItems (String[] names, String price, String category, String tax, String image){
        Random rand = new Random();
        int bound = Integer.valueOf(price);
        Pages.icsHeader().check4Frame();
        for (String name:
             names) {
            System.out.println("Does item "+name+ "exist?");
            if (!verifyElementExist(getItem(name))){
                System.out.println("No, creating...");
                click(addItem);
                Pages.addItemPage().addItem(name, String.valueOf(rand.nextInt(bound)),category,tax,image);
            }
            else {
                System.out.println("Yes, skipping");
            }
        }
        return Pages.diningStore();
    }

    private String getItemName (int index){
        String itemNameXpath = String.format("//table[@id='main_gvItems']//tr[%d]/td[2]", index+1);
        return getAText(By.xpath(itemNameXpath));
    }

    protected By getItem(String name){
        String itemXpath = String.format("//table[@id='main_gvItems']//td[text()='%s']", name);
        return By.xpath(itemXpath);
    }

    private String getItemDescr (int index){
        String itemDescXpath = String.format("//table[@id='main_gvItems']//tr[%d]/td[3]/span", index+1);
        return getAText(By.xpath(itemDescXpath));
    }

}
