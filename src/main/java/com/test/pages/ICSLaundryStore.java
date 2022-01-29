package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

import java.util.Random;

public class ICSLaundryStore extends ICSDiningStore{
    private static By managerCategory = Tools.aFromHref("LaundryCategoryManager.aspx");
    private static By managerMenu = Tools.aFromHref("LaundryMenuEdit.aspx");
    private static By managerOptionSets = Tools.aFromHref("LaundryOptionSetsManager.aspx");
    private static By addItem = Tools.inputFromId("btnAddItem");

    public ICSLaundryStore addItem (String title, String price, String category, String image){
        Pages.icsHeader().check4Frame();
        System.out.println("Does item "+title+ "exist?");
        if (!verifyElementExist(getItem(title))){
            System.out.println("No, creating...");
            click(addItem);
            Pages.laundryAdd().addItem(title, price,category,image);
        }
        else {
            System.out.println("Yes, skipping");
        }
        return Pages.laundryStore();
    }

    public ICSLaundryStore addItems (String[] names, String price, String category, String image){
        Random rand = new Random();
        int bound = Integer.valueOf(price);
        Pages.icsHeader().check4Frame();
        for (String name:
                names) {
            System.out.println("Does item "+name+ "exist?");
            if (!verifyElementExist(getItem(name))){
                System.out.println("No, creating...");
                click(addItem);
                Pages.laundryAdd().addItem(name, String.valueOf(rand.nextInt(bound)),category,image);
            }
            else {
                System.out.println("Yes, skipping");
            }
        }
        return Pages.laundryStore();
    }

    @Override
    public LaundryCategories gotoCategoryManager (){
        Pages.icsHeader().check4Frame();
        click(managerCategory);
        return Pages.laundryCategories();
    }

    @Override
    public LaundryMenu gotoMenuManager (){
        Pages.icsHeader().check4Frame();
        click(managerMenu);
        return Pages.laundryMenu();
    }

    protected By getItem(String name){
        String itemXpath = String.format("//span[contains(@id, 'gvItems') and contains(text(), '%s')]", name);
        return By.xpath(itemXpath);
    }

    public LaundryMenuManager editLaundryMenu (String menuName){
        String editMenulinkXp=String.format("//table[@id='gvMenu']//td[text()='%s']/following-sibling::td/a", menuName);
        click(By.xpath(editMenulinkXp));
        return Pages.laundryMenuManager();
    }


}
