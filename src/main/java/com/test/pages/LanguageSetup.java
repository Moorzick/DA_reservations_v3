package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class LanguageSetup extends BasePage {
    private static By buttonAddLang = By.xpath("//input[@id='btnAddLanguage']");
    private static By fieldAddLangName = By.xpath("//input[@id='tbLanguageName']");
    private static By fieldExistingLangName = By.xpath("//input[@id='tbTitle']");
    private static By fieldDisplayLangName = By.xpath("//input[@id='tbDisplayName']");
    private static By buttonApplyChanges = By.xpath("//a[@id='lbApply']");
    private static By bannerSuccess = By.xpath("//span[text()='Saved Successfully']");


    private void selectLang (String langName){
        By targetLang = lang(langName);
        click(targetLang);
    }

    public void activateLang (String langName){
        String checkboxXpath = String.format("//a[text()='%s']/parent::td/following-sibling::td/input", langName);
        By checkbox = By.xpath(checkboxXpath);
        if (!verifyIsChecked(checkbox)){
            System.out.println("Target language is not active, activating...");
            click(checkbox);
            switchOutOfFrame();
            waitVisibility(bannerSuccess);
            System.out.println("Success!");
            waitForElementToDisappear(bannerSuccess);
        }
        else {
            System.out.println("Target language is already active");
        }
    }

    public void deactivateLang (String langName){
        String checkboxXpath = String.format("//a[text()='%s']/parent::td/following-sibling::td/input", langName);
        By checkbox = By.xpath(checkboxXpath);
        if (verifyIsChecked(checkbox)){
            System.out.println("Target language is active, deactivating...");
            click(checkbox);
        }
        else {
            System.out.println("Target language is already deactivated");
        }
    }

    public void editLang (String langName, String newLangName, String displayName){
        if (verifyElementExist(lang(langName))){
            System.out.println("Target language exists");
            selectLang(langName);
            writeText(fieldExistingLangName, newLangName);
            writeText(fieldDisplayLangName, displayName);
            click(buttonApplyChanges);
        }
        else {
            System.out.println("target language does not exist");
        }
    }

    public void addLang (String langName){
        waitVisibility(lang("English"));
        if (!verifyElementExist(lang(langName))){
            System.out.println("Language "+langName+" not detected");
            writeText(fieldAddLangName, langName);
            click(buttonAddLang);
        }
        else {
            System.out.println("Lang "+langName+" is already there");
        }
    }

    public void deleteLang (String langName){
        System.out.println("Going to delete ");
        waitVisibility(lang("English"));
        if (verifyElementExist(lang(langName))){
            System.out.println("Language "+langName+" exists, deleting...");
            click(By.xpath(getLangDeleteButton(langName)));
            System.out.println("Deleted");
        }
        else {
            System.out.println("Lang does not exist, nothing to delete");
        }
    }

    private By lang (String langName){
        String targetLangXPath = "//a[text()='"+langName+"']";
        return By.xpath(targetLangXPath);
    }

    private String getLangDeleteButton (String langName){
        String deleteButtonXpath = String.format("//a[text()='%s']/parent::td/preceding-sibling::td/input[@type='image']", langName);
        return deleteButtonXpath;
    }
}
