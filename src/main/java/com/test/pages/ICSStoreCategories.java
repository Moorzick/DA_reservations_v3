package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreCategories extends BasePage {
    protected static By buttonAddCategory = Tools.inputFromId("btnAddSection");
    protected static By buttonRemoveCat = Tools.inputFromId("btnRemoveSection");
    protected static By edits = Tools.aContains("id", "rgSections");
    protected static By fieldTitle = Tools.inputFromId("tbSectionTitle");
    protected static By buttonAddImage = Tools.inputFromId("imgbtnSelectImage");
    protected static By buttonSaveCat = Tools.aFromId("lbtnApply");
    protected static By linkBack;

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
        String xp = String.format("//span [contains(@id, 'rgSections') and text()='%s']/parent::td/preceding-sibling::td/input[@type='checkbox']",catName);
        return By.xpath(xp);
    }

    private By getUpsell (String catName){
        String xp = String.format("//span [contains(@id, 'rgSections') and text()='%s']/parent::td/following-sibling::td/input[contains(@id, 'cbUpsell')]", catName);
        return By.xpath(xp);
    }

    protected By getCategory(String catName){
        String xp=String.format("//span[contains(@id, 'CategoryName') and text()='%s']", catName);
        return By.xpath(xp);
    }

    protected void backToStore (){
        Pages.icsHeader().check4Frame();
        click(linkBack);
    }

    protected void addCat (String title, String imageName){
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
    }

    protected void makeUpsell (String catName){
        System.out.println("Verifying if it is upsell");
        By upsellCb = getUpsell(catName);
        waitVisibility(upsellCb);
        if (!verifyIsChecked(upsellCb)){
            System.out.println("It's not, checking");
            click(getUpsell(catName));
            Pages.icsHeader().checkForSuccess();
        }
        else {
            System.out.println("It is, skipping");
        }
    }

    protected void unUpsell (String catName){
        System.out.println("Verifying if it is upsell");
        By upsellCb = getUpsell(catName);
        waitVisibility(upsellCb);
        if (verifyIsChecked(upsellCb)){
            System.out.println("It is, unchecking");
            click(getUpsell(catName));
            Pages.icsHeader().checkForSuccess();
        }
        else {
            System.out.println("It is not, skipping");
        }
    }


}
