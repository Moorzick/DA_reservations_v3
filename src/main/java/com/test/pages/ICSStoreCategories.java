package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreCategories extends BasePage {
    protected static By buttonAddCategory = Tools.aFromId("main_btnAddSection");
    protected static By buttonRemoveCat = Tools.aFromId("main_btnRemoveSection");
    private static By edits = Tools.aContains("id", "main_rgSections");
    protected static By fieldTitle = Tools.inputFromId("main_tbSectionTitle");
    protected static By buttonAddImage = Tools.inputFromId("main_imgbtnSelectImage");
    protected static By buttonSaveCat = Tools.aFromId("main_lbtnApply");
    protected static By linkBack = Tools.byFromPropertyAndValue("a", "class", "link-back");

    protected void assignImage(String imageName){
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

    protected By getCategory(String catName){
        String xp=String.format("//span[contains(@id, 'CategoryName') and text()='%s']", catName);
        return By.xpath(xp);
    }

    public ICSDiningStore backToDiningStore(){
        backToStore();
        return Pages.diningStore();
    }

    protected void backToStore (){
        Pages.icsHeader().check4Frame();
        click(linkBack);
    }


    public ICSStoreCategories addCat (String title, String imageName){
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

    public ICSStoreCategories makeUpsell (String catName){
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

    public ICSStoreCategories unUpsell (String catName){
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
