package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ICSStoreItemAdd extends BasePage {
    protected static By fieldItemName = Tools.inputFromId("tbName");
    protected static By fieldPrice = Tools.inputFromId("tbPrice");

    protected static By selectCategory = Tools.selectFromId("ddlCategory");
    protected static By fieldLeadTime = Tools.inputFromId("tbLeadTime");
    protected static By fieldDescription=Tools.byFromPropertyAndValue("textarea", "id", "tbDescription");
    protected static By buttonAssignImage=Tools.inputFromId("imgbtnSelectImage");
    protected static By selectOptionSets=Tools.selectFromId("ddlOptionSets");
    protected static By buttonAddOptionSet = Tools.inputFromId("imgbtnAddOptionSet");
    protected static By buttonSaveItem=Tools.aFromId("lbtnApply");

    protected static By radiobuttonTaxDefault = Tools.inputFromId("rbTaxDefault");
    protected static By radiobuttonTaxCustom = Tools.inputFromId("rbTaxCustom");
    protected static By checkboxTaxable = Tools.inputFromId("cbTaxable");

    private static By radiobutton24HRSYes = Tools.inputFromId("rbAllDayYes");
    private static By radiobutton24HRSNo = Tools.inputFromId("rbAllDayNo");
    private static By fieldLead = Tools.inputFromId("tbLeadTime");

    protected static By selectStartHRS= Tools.selectFromId("ddlStartHour");
    protected static By selectStartMINS=Tools.selectFromId("ddlStartMinute");
    protected static By selectStAMPM=Tools.selectFromId("ddlStartAMPM");
    protected static By selectEndHRS=Tools.selectFromId("ddlEndHour");
    protected static By selectEndMINS= Tools.selectFromId("ddlEndMinute");
    protected static By selectEndAMPM=Tools.selectFromId("ddlEndAMPM");


    protected void fillTitle (String title){
        writeText(fieldItemName, title);
    }

    protected void fillPrice (String price){
        writeText(fieldPrice, price);
    }

    protected void selectCat (String cat){
        droplistSelectByName(selectCategory, cat);
    }

    protected void assignImage (String imageName){
        click(buttonAssignImage);
        Pages.imageLibrary().assignImage(imageName);
    }

    protected void chooseOptionSet (String optionSet){
        droplistSelectByName(selectOptionSets, optionSet);
        click(buttonAddOptionSet);
    }

    protected void addSimple(String title, String image, String price, String category){
        assignImage(image);
        fillTitle(title);
        fillPrice(price);
        selectCat(category);
        setDefaultTax();
        set24HRSAvailable();
        click(buttonSaveItem);
    }

    private void setDefaultTax (){
        click(radiobuttonTaxDefault);
    }

    private void set24HRSAvailable (){
        click(radiobutton24HRSYes);
    }

    protected void setTaxable (){
        System.out.println("Is taxable?");
        if(!verifyIsChecked(checkboxTaxable)){
            System.out.println("No, checking");
            click(checkboxTaxable);
        }
        else {
            System.out.println("It is already");
        }
    }

    protected void setUnTaxable (){
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
