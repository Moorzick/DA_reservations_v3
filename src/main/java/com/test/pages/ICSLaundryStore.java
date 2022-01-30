package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

import java.util.Random;

public class ICSLaundryStore extends ICSStore{
    static {
    managerCategory = Tools.aFromHref("LaundryCategoryManager.aspx");
    managerMenu = Tools.aFromHref("LaundryMenuEdit.aspx");
    managerOptions = Tools.aFromHref("LaundryOptionSetsManager.aspx");
    addItem = Tools.inputFromId("btnAddItem");
    }

    public ICSLaundryStore addItem (String title, String price, String category, String image){
        Pages.icsHeader().check4Frame();
        System.out.println("Does item "+title+ "exist?");
        if (!verifyElementExist(getItem(title))){
            System.out.println("No, creating...");
            click(addItem);
            Pages.laundryAdd().addLaundryItem(title, price,category,image);
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
                Pages.laundryAdd().addLaundryItem(name, String.valueOf(rand.nextInt(bound)),category,image);
            }
            else {
                System.out.println("Yes, skipping");
            }
        }
        return Pages.laundryStore();
    }


    public LaundryCategories gotoLaundryCategoryManager(){
        Pages.icsHeader().check4Frame();
        click(managerCategory);
        return Pages.laundryCategories();
    }


    public LaundryMenu gotoLaundryMenuManager (){
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
