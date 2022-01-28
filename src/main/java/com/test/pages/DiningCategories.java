package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class DiningCategories extends BasePage {
    private static By buttonAddCategory = Tools.aFromId("main_btnAddSection");
    private static By buttonRemoveCat = Tools.aFromId("main_btnRemoveSection");
    private static By edits = Tools.aContains("@id", "main_rgSections");
    private static By fieldTitle = Tools.inputFromId("main_tbSectionTitle");
    private static By buttonAddImage = Tools.inputFromId("main_imgbtnSelectImage");
    private static By buttonSaveCat = Tools.aFromId("main_lbtnApply");
    private static By linkBackToDining = Tools.byFromPropertyAndValue("a", "class", "link-back");

    private void assignImage (String imageName){
        click(buttonAddImage);
        Pages.imageLibrary().assignImage(imageName);
    }

    private By getEdit (String catName){
        String xp = String.format("//span [contains(@id, 'main_rgSections') and text()='%s']/parent::td/following-sibling::td/a", catName);
        return By.xpath(xp);
    }

    private By getActivator (String catName){
        String xp = String.format("//span [contains(@id, 'main_rgSections') and text()='%s']/parent::td/following-sibling::td/input[contains(@id, 'chkActive')]", catName);
        return By.xpath(xp);
    }

    private By getSelector (String catName){
        String xp = String.format("//span [contains(@id, 'main_rgSections') and text()='%s']/parent::td/preceding-sibling::td/input[@type='checkbox']",catName);
        return By.xpath(xp);
    }

    private By getUpsell (String catName){
        String xp =String.format("//span [contains(@id, 'main_rgSections') and text()='%s']/parent::td/following-sibling::td/input[contains(@id, 'cbUpsell')]", catName);
        return By.xpath(xp);
    }

    private By getCategory(String catName){
        String xp=String.format("//span[contains(@id, 'CategoryName') and text()='%s']", catName);
        return By.xpath(xp);
    }

    public ICSDiningStore backToDining (){
        Pages.icsHeader().check4Frame();
        click(linkBackToDining);
        return Pages.diningStore();
    }

    public DiningCategories addCat (String title, String imageName){
        Pages.icsHeader().check4Frame();
        waitVisibility(edits);
        System.out.println("Checking for category...");
        if (!verifyElementExist(getCategory(title))){
            System.out.println("Not detected, creating...");
            click(buttonAddCategory);
            assignImage(imageName);
            writeText(fieldTitle, title);
            click(buttonSaveCat);
            System.out.println("Categoty saved!");
        }
        else {
            System.out.println("Exists, skipping");
        }
        return Pages.diningCategories();
    }

    public DiningCategories makeUpsell (String catName){
        System.out.println("Verifying if it is upsell");
        waitVisibility(edits);
        if (!verifyIsChecked(getUpsell(catName))){
            System.out.println("It's not, checking");
            click(getUpsell(catName));
        }
        else {
            System.out.println("It is, skipping");
        }
        return Pages.diningCategories();
    }

    public DiningCategories unUpsell (String catName){
        System.out.println("Verifying if it is upsell");
        if (!verifyIsChecked(getUpsell(catName))){
            System.out.println("It's not, checking");
            click(getUpsell(catName));
        }
        else {
            System.out.println("It is, skipping");
        }
        return Pages.diningCategories();
    }


}
