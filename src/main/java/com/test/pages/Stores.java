package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class Stores extends BasePage {
    private static By labelDining = Tools.byFromPropertyAndValue("span", "title", "Dining Store");
    private static By labelCustom = Tools.byFromPropertyAndValue("span", "title", "Custom Store");
    private static By fieldStoreName = Tools.inputFromId("main_txtStoreTitle");
    private static By numericLeadTime = Tools.inputFromId("main_txtLeadTime");
    private static By checkboxHideZeroPrices = Tools.inputFromId("main_cbHideZeroValues");
    private static By fieldTaxRate = Tools.inputFromId("main_txtTaxRate");
    private static By fieldServiceFee = Tools.inputFromId("main_txtServiceFee");
    private static By fieldGratuity = Tools.inputFromId("main_txtGratuity");
    private static By selectServiceFee = Tools.selectFromId("main_ddlServiceFee");
    private static By selectGratuity = Tools.selectFromId("main_ddlGratuity");
    private static By checkboxServiceFee = Tools.inputFromId("main_uiServiceFeeTaxableCheckBox");
    private static By checkboxGratuity = Tools.inputFromId("main_uiGratuityTaxableCheckBox");
    private static By selectNotif = Tools.selectFromId("main_ddlNotificationGroup");
    private static By radioBtnNotifImmed = Tools.inputFromId("main_StoresQTUC_rbImmediate");
    private static By radioBtnNotifTimed = Tools.inputFromId("main_StoresQTUC_rbAfterMinutes");
    private static By fieldNotifMinutes = Tools.inputFromId("main_StoresQTUC_txtQueueTime");
    private static By checkboxTKT = Tools.inputFromId("main_cbIntegrated");
    private static By checkboxPOS = Tools.inputFromId("main_uiSendOrderToPosInput");
    private static By checkboxAutoCompl = Tools.inputFromId("main_cbAutoCompleted");
    private static By buttonDeliveryOptions = Tools.byFromPropertyAndValue("a", "class", "ics button secondary");
    private static By buttonApply = Tools.inputFromId("main_lbtnApply");


    private static By getTargetStoreBy (String storeName){
        By targetStore = By.xpath(String.format("//div[@id='main_UpdatePanel1']//a[contains(text(),'%s')]", storeName));
        return targetStore;
    }

    public ICSDiningStore gotoDiningStore(String storeName){
        Pages.icsHeader().check4Frame();
        click(getTargetStoreBy(storeName));
        return Pages.diningStore();
    }

    public ICSLaundryStore gotoLaundryStore (String storeName){
        Pages.icsHeader().check4Frame();
        click(getTargetStoreBy(storeName));
        return Pages.laundryStore();
    }

    public ICSCustomStore gotoCustomStore (String storeName){
        Pages.icsHeader().check4Frame();
        click(getTargetStoreBy(storeName));
        return Pages.customStore();
    }

    public Stores editStore (String storeName){
        Pages.icsHeader().check4Frame();
        click(getStoreEditByName(storeName));
        return Pages.stores();
    }

    public Stores editStore (int index){
        Pages.icsHeader().check4Frame();
        click(getStoreEditByIndex(index));
        return Pages.stores();
    }

    private By getStoreEditByName (String storeName){
        String editXpath= String.format("//a[text()='%s']/parent::td/following-sibling::td/a", storeName);
        return By.xpath(editXpath);
    }

    private By getStoreEditByIndex (int index){
        String editXpath = String.format("(//td[@class='lnkEdit']/a)[%d]", index);
        return By.xpath(editXpath);
    }

    public DeliveryOptions deliveryOptions(){
        waitVisibility(buttonApply);
        click(buttonDeliveryOptions);
        return Pages.deliveryOptions();
    }

    public int getStoresCount (){
        Pages.icsHeader().check4Frame();
        return getAllElementsCount(By.xpath("//td[@class='lnkEdit']"));
    }

    public boolean check4Spa (){
        Pages.icsHeader().check4Frame();
        waitVisibility(buttonApply);
        boolean spa;
        if (verifyElementExist(buttonDeliveryOptions)){
            spa = false;
        }
        else {
            System.out.println("Spa store detected, skipping");
            spa=true;
        }
        return spa;
    }

}
