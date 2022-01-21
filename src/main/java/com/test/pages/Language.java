package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class Language extends BasePage {
    private static By buttonRemove = By.xpath("//a[@id='btnRemoveLanguage']");
    private static By fieldLangName = By.xpath("//input[@id='tbLanguageName']");
    private static By fieldCultCode = By.xpath("//input[@id='tbLanguageCode']");
    private static By buttonAdd = By.xpath("//a[@id='lbtnApply']");

    private By getLangSelector (String langName){
        String selectorXpath = "//td[text()='"+langName+"']/preceding-sibling::td/input";
        By langSelector = By.xpath(selectorXpath);
        return langSelector;
    }

    public void editLang (String langName, String newLangName, String cultCode){
        String editXpath = "//td[text()='"+langName+"']/following-sibling::td/a";
        click(By.xpath(editXpath));
        fillLangForm(newLangName, cultCode);
    }

    public Language addLang (String langName, String cultCode){
        String langXpath = "//td[text()='"+langName+"']";
        if (!verifyElementExist(By.xpath(langXpath))){
            System.out.println("Lang does not exist");
            fillLangForm(langName, cultCode);
        }
        else {
            System.out.println("Lang already exists");
        }
        return Pages.language();
    }

    private void fillLangForm (String newLangName, String cultCode){
        writeText(fieldLangName, newLangName);
        writeText(fieldCultCode, cultCode);
        click(buttonAdd);
    }

    public Language deleteLang (String langName) throws InterruptedException {
        Thread.sleep(2000);
        By langSelector = getLangSelector(langName);
        if (verifyElementExist(langSelector)){
            System.out.println("Lang exists, deleting");
            click(langSelector);
            click(buttonRemove);
            Thread.sleep(1000);
            alertAccept();
        }
        else {
            System.out.println("Lang does not exist");
        }
        return Pages.language();
    }
}
