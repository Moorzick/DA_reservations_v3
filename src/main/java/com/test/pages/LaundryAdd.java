package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class LaundryAdd extends ICSStoreItemAdd{

static {
    fieldItemName = Tools.inputFromId("tbName");
    fieldPrice = Tools.inputFromId("tbPrice");
    buttonAssignImage = Tools.inputFromId("ImageButton1");
    selectCategory = Tools.selectFromId("ddlCategory");
    buttonSaveItem = Tools.aFromId("lbtnApply");
}

private static By fieldUpgrade = Tools.inputFromId("tbUpgradeName");
private static By fieldUpgrPrice = Tools.inputFromId("tbUpgradePrice");
private static By buttonAddUpgrade = Tools.inputFromId("imgbtnAddUpgrade");

private static By radiobutton24HRSYes = Tools.inputFromId("rbAllDayYes");
private static By radiobutton24HRSNo = Tools.inputFromId("rbAllDayNo");
private static By fieldLead = Tools.inputFromId("tbLeadTime");

private static By fieldTax=Tools.inputFromId("tbTax");
private static By radiobuttonTaxDefault = Tools.inputFromId("rbTaxDefault");
private static By radiobuttonTaxCustom = Tools.inputFromId("rbTaxCustom");
private static By checkboxTaxable = Tools.inputFromId("cbTaxable");

private static By selectStartHRS= Tools.selectFromId("ddlStartHour");
private static By selectStartMINS=Tools.selectFromId("ddlStartMinute");
private static By selectStAMPM=Tools.selectFromId("ddlStartAMPM");
private static By selectEndHRS=Tools.selectFromId("ddlEndHour");
private static By selectEndMINS= Tools.selectFromId("ddlEndMinute");
private static By selectEndAMPM=Tools.selectFromId("ddlEndAMPM");

private static By selectOptionSets=Tools.selectFromId("ddlOptionSets");
private static By buttonOptionSetAdd=Tools.inputFromId("imgbtnAddOptionSet");

private static By fieldDescription = Tools.byFromPropertyAndValue("textarea", "id", "tbDescription");

public ICSLaundryStore addItem (String title, String price, String category, String image){
    assignImage(image);
    fillTitle(title);
    fillPrice(price);
    selectCat(category);
    setDefaultTax();
    set24HRSAvailable();
    click(buttonSaveItem);
    return Pages.laundryStore();
}

private void setDefaultTax (){
    click(radiobuttonTaxDefault);
}

private void set24HRSAvailable (){
    click(radiobutton24HRSYes);
}

private void setTaxable (){
    System.out.println("Is taxable?");
    if(!verifyIsChecked(checkboxTaxable)){
        System.out.println("No, checking");
        click(checkboxTaxable);
    }
    else {
        System.out.println("It is already");
    }
}

private void setUnTaxable (){
    System.out.println("Is taxable?");
    if (verifyIsChecked(checkboxTaxable)){
        System.out.println("yes, unchecking");
        click(checkboxTaxable);
    }
    else {
        System.out.println("No, skipping");
    }
}

}
