package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class DiningItemAdd extends BasePage {
    private static By fieldItemName = Tools.inputFromId("main_tbName");
    private static By fieldPrice = Tools.inputFromId("main_tbPrice");
    private static By selectPrLevel = Tools.selectFromId("main_ddlPriceLevel");
    private static By selectTax=Tools.selectFromId("main_ddlTaxes");
    private static By selectCategory = Tools.selectFromId("main_ddlCategory");
    private static By fieldLeadTime = Tools.inputFromId("main_tbLeadTime");
    private static By fieldDescription=Tools.byFromPropertyAndValue("textarea", "id", "main_tbDescription");
    private static By buttonAssignImage=Tools.inputFromId("main_imgbtnSelectImage");
    private static By selectOptionSets=Tools.selectFromId("main_ddlOptionSets");
    private static By buttonAddOptionSet = Tools.inputFromId("main_imgbtnAddOptionSet");
    private static By buttonSaveItem=Tools.inputFromId("main_uiSaveButton");
    private static By buttonSaveAndAdd=Tools.inputFromId("main_uiSaveAndAddButton");

    private void fillTitle (String title){
        writeText(fieldItemName, title);
    }

    private void fillPrice (String price){
        writeText(fieldPrice, price);
    }

    private void selectTax (String tax){
        droplistSelectByName(selectTax, tax);
    }

    private void selectCat (String cat){
        droplistSelectByName(selectCategory, cat);
    }

    private void assignImage (String imageName){
        click(buttonAssignImage);
        Pages.imageLibrary().assignImage(imageName);
    }

    private void chooseOptionSet (String optionSet){
        droplistSelectByName(selectOptionSets, optionSet);
        click(buttonAddOptionSet);
    }

    public ICSDiningStore addItem (String title, String price, String category, String tax, String image){
        assignImage(image);
        fillTitle(title);
        fillPrice(price);
        selectCat(category);
        selectTax(tax);
        click(buttonSaveItem);
        return Pages.diningStore();
    }
}
