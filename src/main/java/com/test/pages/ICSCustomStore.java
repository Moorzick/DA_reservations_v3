package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

import java.util.Random;

public class ICSCustomStore extends ICSDiningStore{
    static {
        managerMenu = By.xpath("//span[@id='Label1']/parent::a");
        managerCategory = By.xpath("//span[@id='ItemCategoryManagerLabel']/parent::a");
        managerOptions = By.xpath("//span[@id='Label2']/parent::a");
        addItem = Tools.inputFromId("btnAddItem");
    }

    public CustomCategories gotoCustomCategories (){
        gotoCategoryManager();
        return Pages.customCategories();
    }

    public CustomMenu gotoCustomMenuManager(){
        gotoMenuManager();
        return Pages.customMenu();
    }

    private By getItem (String itemName){
        String xp= String.format("//span[contains(@id,'ItemName') and text()='%s']", itemName);
        return By.xpath(xp);
    }

    public ICSCustomStore addItems (String[] names, String price, String category, String image){
        Random rand = new Random();
        int bound = Integer.valueOf(price);
        Pages.icsHeader().check4Frame();
        for (String name:
                names) {
            System.out.println("Does item "+name+" exist?");
            if (!verifyElementExist(getItem(name))){
                System.out.println("No, creating...");
                click(addItem);
                Pages.customAdd().addCustomItem(name, String.valueOf(rand.nextInt(bound)),category,image);
            }
            else {
                System.out.println("Yes, skipping");
            }
        }
        return Pages.customStore();
    }
}
