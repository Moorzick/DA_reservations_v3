package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class DeliveryOptions extends BasePage {
    private final By buttonSaveMain = By.xpath("//div[@class='input-container' and contains(text(), 'Select delivery options offered to guests that order from this store')]/parent::div/parent::div//input[@value='Apply']");
    private final By buttonSaveDeliveryOptions = By.xpath("//div[@class='title item' and text()='Room Delivery']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private final By buttonSavePoolsideLocations =By.xpath("//div[@class='title item' and text()='Location by Text Field']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private final By buttonSavePoolsideRecent = By.xpath("//div[@class='title item' and text()='Recent Options']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private final By buttonSavePoolsideHelp = By.xpath("//div[@class='title item' and text()='Help Items']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private final By buttonSavePickup = By.xpath("//label[@for='PickupOutletName']/parent::div/parent::div/parent::div//input[@value='Apply']");

    private final By tabDelOpts = Tools.aFromId("delivery_section_link");
    private final By tabPoolside=Tools.aFromId("poolside_location_link");
    private final By tabPoolsideRecent = Tools.aFromId("poolside_recent_location_link");
    private final By tabPoolsideHelp = Tools.aFromId("poolside_help_link");
    private final By tabPickup = Tools.aFromId("pickup_options_link");

    private final String selectorImage = "//div[@data-filter='%s']/label";


    //Delivery Options
    private final By fieldOptionsDelOpTitle = Tools.inputFromId("DeliveryTitle");
    private final By fieldOptionsDelOpDetail = Tools.byFromPropertyAndValue("textarea", "id", "DeliveryDetail");
    private final By fieldOptionsRoomLabel = Tools.inputFromId("DeliveryRoomLabel");
    private final By fieldOptionsRoomSubtitle = Tools.inputFromId("DeliveryRoomSubtitle");
    private final By fieldOptionsPoolLabel = Tools.inputFromId("DeliveryPoolsideLabel");
    private final By fieldOptionsPoolSubtitle = Tools.inputFromId("DeliveryPoolsideSubtitle");
    private final By fieldOptionsPickupLabel = Tools.inputFromId("DeliveryPickupLabel");
    private final By fieldOptionsPickupSubtitle = Tools.inputFromId("DeliveryPickupSubtitle");

    private final By imageOptionsAddImage = By.xpath("//div[@class='title item' and text()='Room Delivery']/parent::div/parent::div/parent::div//a[@class='open-picker-link hidden blank']");
    private final By fieldImageFilterDevOpts = By.xpath("(//input[@class='filter'])[1]");
    private final By buttonImageDevOptsAccept = By.xpath("(//span[@class='ui-button-text' and text()='Accept'])[1]");
    private final By buttonImageDevOptsCancel = By.xpath("(//span[@class='ui-button-text' and text()='Cancel'])[1]");

    //Poolside
    private final By fieldPLTitle = Tools.inputFromId("PoolsideLocationCaputreTitle");
    private final By fieldPLDetail = Tools.inputFromId("PoolsideLocationCaputreDetail");
    private final By fieldPLTextLocationLabel = Tools.inputFromId("PoolsideLocationCaputreOptionManualLabel");
    private final By fieldPLTextLocationHint = Tools.inputFromId("PoolsideLocationCaputreOptionManualHint");
    private final By fieldPLQRLocationLabel = Tools.inputFromId("PoolsideLocationCaputreOptionQrLabel");
    private final By fieldPLQRLocationInstruction= Tools.inputFromId("PoolsideLocationCaputreOptionQrHint");
    private final By fieldPLNFCLabel = Tools.inputFromId("PoolsideLocationCaputreOptionNfcLabel");
    private final By fieldPLNFCInstruction = Tools.inputFromId("PoolsideLocationCaputreOptionNfcHint");

    private final By fieldPLButtonCancel = Tools.inputFromId("PoolsideLocationCaptureCancelActionLabel");
    private final By fieldPLButtonHelp = Tools.inputFromId("PoolsideLocationCaptureHelpActionLabel");
    private final By fieldPLButtonSave = Tools.inputFromId("PoolsideLocationCaptureSaveActionLabel");

    private final By imagePLAddImage = By.xpath("//div[@class='title item' and text()='Location by Text Field']/parent::div/parent::div/parent::div//a[@class='open-picker-link hidden blank']");
    private final By fieldPLImageFilter = By.xpath("(//input[@class='filter'])[2]");
    private final By buttonImagePLAccept = By.xpath("(//span[@class='ui-button-text' and text()='Accept'])[2]");
    private final By buttonImagePLCancel = By.xpath("(//span[@class='ui-button-text' and text()='Cancel'])[2]");

    //Poolside recent
    private final By fieldPRTitle = Tools.inputFromId("PoolsideLocationRemeberedTitle");
    private final By fieldPRDetail = Tools.inputFromId("PoolsideLocationRemeberedDetail");
    private final By fieldPRYes = Tools.inputFromId("PoolsideLocationRemeberedYesLabel");
    private final By fieldPRNo = Tools.inputFromId("PoolsideLocationRemeberedNoLabel");
    private final By fieldPRCancel = Tools.inputFromId("PoolsideLocationRemeberedCancelActionLabel");

    private final By imagePRAddImage = By.xpath("//div[@class='title item' and text()='Recent Options']/parent::div/parent::div/parent::div//a[@class='open-picker-link hidden blank']");
    private final By fieldPRImageFilter = By.xpath("(//input[@class='filter'])[3]");
    private final By buttonImagePRAccept = By.xpath("(//span[@class='ui-button-text' and text()='Accept'])[3]");
    private final By buttonImagePRCancel = By.xpath("(//span[@class='ui-button-text' and text()='Cancel'])[3]");

    //Poolside help
    private final By fieldPHTitle = Tools.inputFromId("PoolsideLocationCaptureHelpTitle");
    private final By fieldPHBack = Tools.inputFromId("PoolsideLocationCaptureHelpBackActionLabel");

    private final By imagePHAddImage = By.xpath("//div[@class='title item' and text()='Help Items']/parent::div/parent::div/parent::div//a[@class='open-picker-link hidden blank']");
    private final By fieldPHImageFilter = By.xpath("(//input[@class='filter'])[4]");
    private final By buttonImagePHAccept = By.xpath("(//span[@class='ui-button-text' and text()='Accept'])[4]");
    private final By buttonImagePHCancel = By.xpath("(//span[@class='ui-button-text' and text()='Cancel'])[4]");

    private By getIMGBy (String imageName){
        String xp = String.format(selectorImage, imageName);
        return By.xpath(xp);
    }











}
