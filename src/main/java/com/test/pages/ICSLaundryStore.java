package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

import java.util.Random;

public class ICSLaundryStore extends ICSDiningStore{
    static {
        managerCategory = Tools.aFromHref("LaundryCategoryManager.aspx");
        managerMenu = Tools.aFromHref("LaundryMenuEdit.aspx");
        managerOptions = Tools.aFromHref("LaundryOptionSetsManager.aspx");
        addItem = By.xpath("//a[@id='btnAddItem']");
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
}
