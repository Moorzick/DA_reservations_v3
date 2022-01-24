package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ImageLibraryAdd extends BasePage {
    private static By fieldName = Tools.inputFromId("tbName");
    private static By fieldFile = Tools.inputFromId("uploadFile");
    private static By fieldKeyword = Tools.inputFromId("tbKeyword");
    private static By buttonKeywordAdd = Tools.inputFromId("btnAddKey");
    private static By buttonSave = Tools.inputFromId("lbAddSection");

    private void fillName (String name){
        writeText(fieldName, name);
    }

    private void attachFile (String file){
        sendKeys(fieldFile, file);
    }

    private void addKeyword (String keyWord){
        writeText(fieldKeyword, keyWord);
        click(buttonKeywordAdd);
        String xpath = String.format("//td[contains(text(),'%s')]", keyWord);
        waitVisibility(By.xpath(xpath));
    }


    public void addFile (String name, String file, String keyWord){
        fillName(name);
        attachFile(file);
        addKeyword(keyWord);
        click(buttonSave);
        System.out.println("Clicked save");
    }
}
