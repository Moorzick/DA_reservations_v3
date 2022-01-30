package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class DiningItemAdd extends ICSStoreItemAdd {
    static {
        fieldItemName = Tools.inputFromId("main_tbName");
        fieldPrice = Tools.inputFromId("main_tbPrice");
        selectCategory = Tools.selectFromId("main_ddlCategory");
        fieldLeadTime = Tools.inputFromId("main_tbLeadTime");
        fieldDescription=Tools.byFromPropertyAndValue("textarea", "id", "main_tbDescription");
        buttonAssignImage=Tools.inputFromId("main_imgbtnSelectImage");
        selectOptionSets=Tools.selectFromId("main_ddlOptionSets");
        buttonAddOptionSet = Tools.inputFromId("main_imgbtnAddOptionSet");
        buttonSaveItem=Tools.inputFromId("main_uiSaveButton");
    }

    private static By selectPrLevel = Tools.selectFromId("main_ddlPriceLevel");
    private static By selectTax=Tools.selectFromId("main_ddlTaxes");
    private static By buttonSaveAndAdd=Tools.inputFromId("main_uiSaveAndAddButton");

    private void selectTax (String tax){
        droplistSelectByName(selectTax, tax);
    }

    public ICSDiningStore addDiningItem (String title, String price, String category, String tax, String image){
        assignImage(image);
        fillTitle(title);
        fillPrice(price);
        selectCat(category);
        selectTax(tax);
        click(buttonSaveItem);
        return Pages.diningStore();
    }

}
