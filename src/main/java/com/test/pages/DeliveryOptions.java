package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeliveryOptions extends BasePage {
    private final By buttonSaveMain = By.xpath("//div[@class='input-container' and contains(text(), 'Select delivery options offered to guests that order from this store')]/parent::div/parent::div//input[@value='Apply']");
    private final By buttonSaveDeliveryOptions = By.xpath("//div[@class='title item' and text()='Room Delivery']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private final By buttonSavePoolsideLocations =By.xpath("//div[@class='title item' and text()='Location by Text Field']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private final By buttonSavePoolsideRecent = By.xpath("//div[@class='title item' and text()='Recent Options']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private final By buttonSavePoolsideHelp = By.xpath("//div[@class='title item' and text()='Help Items']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private final By buttonSavePickup = By.xpath("//label[@for='PickupOutletName']/parent::div/parent::div/parent::div//input[@value='Apply']");

    private final By linkBack = Tools.byFromPropertyAndValue("a", "class", "link-back");

    private final By tabDelOpts = Tools.aFromId("delivery_section_link");
    private final By tabPoolside=Tools.aFromId("poolside_location_link");
    private final By tabPoolsideRecent = Tools.aFromId("poolside_recent_location_link");
    private final By tabPoolsideHelp = Tools.aFromId("poolside_help_link");
    private final By tabPickup = Tools.aFromId("pickup_options_link");

    private final String selectorImage = "//div[@data-filter='%s']/label";
    private final String selectorApply = "(//input[@type='submit' and @class='button'])[%d]";

    private final String imageOptionsAddImage = "//a[contains (@class,'open-picker-link') and @style='display: block;']";
    private final String fieldImageFilter = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front no-close ui-dialog-buttons' and contains(@style, 'display: block;')]//input[@class='filter']";
    private final String buttonImageAccept = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front no-close ui-dialog-buttons' and contains(@style, 'display: block;')]//span[@class='ui-button-text' and text()='Accept']";
    private final String buttonImageCancel = "//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front no-close ui-dialog-buttons' and contains(@style, 'display: block;')]//span[@class='ui-button-text' and text()='Cancel']";


    //Delivery Options
    private final By fieldOptionsDelOpTitle = Tools.inputFromId("DeliveryTitle");
    private final By fieldOptionsDelOpDetail = Tools.byFromPropertyAndValue("textarea", "id", "DeliveryDetail");
    private final By fieldOptionsRoomLabel = Tools.inputFromId("DeliveryRoomLabel");
    private final By fieldOptionsRoomSubtitle = Tools.inputFromId("DeliveryRoomSubtitle");
    private final By fieldOptionsPoolLabel = Tools.inputFromId("DeliveryPoolsideLabel");
    private final By fieldOptionsPoolSubtitle = Tools.inputFromId("DeliveryPoolsideSubtitle");
    private final By fieldOptionsPickupLabel = Tools.inputFromId("DeliveryPickupLabel");
    private final By fieldOptionsPickupSubtitle = Tools.inputFromId("DeliveryPickupSubtitle");


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


    //Poolside recent
    private final By fieldPRTitle = Tools.inputFromId("PoolsideLocationRemeberedTitle");
    private final By fieldPRDetail = Tools.inputFromId("PoolsideLocationRemeberedDetail");
    private final By fieldPRYes = Tools.inputFromId("PoolsideLocationRemeberedYesLabel");
    private final By fieldPRNo = Tools.inputFromId("PoolsideLocationRemeberedNoLabel");
    private final By fieldPRCancel = Tools.inputFromId("PoolsideLocationRemeberedCancelActionLabel");


    //Poolside help
    private final By fieldPHTitle = Tools.inputFromId("PoolsideLocationCaptureHelpTitle");
    private final By fieldPHBack = Tools.inputFromId("PoolsideLocationCaptureHelpBackActionLabel");

    //Pickup
    private final By fieldOutletName = Tools.inputFromId("txtOutletName");
    private final By fieldOutletAddress = Tools.byFromPropertyAndValue("textarea", "id", "txtOutletAddress");
    private final By fieldOutletPhone = Tools.inputFromId("txtOutletPhone");
    private final By fieldOutletEmail = Tools.inputFromId("txtOutletEmail");



    private By getIMGBy (String imageName){
        String xp = String.format(selectorImage, imageName);
        return By.xpath(xp);
    }

    private void selectImage (String imageName){ //1-delivery options, 2-Poolside location, 3 - Poolside recent, 4-poolside help
        System.out.println("Switching out of frame");
        switchOutOfFrame();
        System.out.println("Filtering...");
        writeText(By.xpath(fieldImageFilter), imageName);
        System.out.println("Picking the image");
        click(getIMGBy(imageName));
        click(By.xpath(buttonImageAccept));
        System.out.println("Finished. Switching back to frame");
        Pages.icsHeader().check4Frame();
    }

    private void applyChanges (int buttonIndex){
        click(By.xpath(String.format(selectorApply, buttonIndex)));
    }

    //delivery options tab
    private void delOptTitle (String title){
        writeText(fieldOptionsDelOpTitle, title);
    }

    private void delOptDetails (String details){
        writeText(fieldOptionsDelOpDetail, details);
    }

    private void delOptsRDLabel (String rdLabel){
        writeText(fieldOptionsRoomLabel, rdLabel);
    }

    private void delOptsRDSubtitle (String rdSubtitle){
        writeText(fieldOptionsRoomSubtitle, rdSubtitle);
    }

    private void delOptsPDlabel (String pdLabel){
        writeText(fieldOptionsPoolLabel, pdLabel);
    }

    private void delOptsPDSubtitle (String pdSubtitle){
        writeText(fieldOptionsPoolSubtitle, pdSubtitle);
    }

    private void delOptsPickLabel (String pickLabel){
        writeText(fieldOptionsPickupLabel, pickLabel);
    }

    private void delOptsPickSubtitle (String pickSubtitle){
        writeText(fieldOptionsPickupSubtitle, pickSubtitle);
    }

    private void delOptsImage (String imageName){
        System.out.println("Selecting the image...");
        String selectImageXp = "//div[@id='image-editor-container-for-DeliveryOptionImage']"+imageOptionsAddImage;
        click(By.xpath(selectImageXp));
        selectImage(imageName);
    }

    public DeliveryOptions fillDelOpts (String delOptTitle, String delOptDetails,
                              String delOptsRDLabel, String delOptsRDSubtitle,
                              String delOptsPDLabel, String delOptsPDSubtitle,
                              String delOptsPickLabel, String delOptsPickSubtitle,
                              String imageName){
        Pages.icsHeader().check4Frame();
        click(tabDelOpts);
        delOptTitle(delOptTitle);
        delOptDetails(delOptDetails);
        delOptsRDLabel(delOptsRDLabel);
        delOptsRDSubtitle(delOptsRDSubtitle);
        delOptsPDlabel(delOptsPDLabel);
        delOptsPDSubtitle(delOptsPDSubtitle);
        delOptsPickLabel(delOptsPickLabel);
        delOptsPickSubtitle(delOptsPickSubtitle);
        delOptsImage(imageName);
        applyChanges(2);

        return Pages.deliveryOptions();
    }


    //poolside Location tab
    private void plTitle (String plTitle){
        writeText(fieldPLTitle, plTitle);
    }

    private void plDelail (String plDetail){
        writeText(fieldPLDetail, plDetail);
    }

    private void plLocationLabel (String plLocLabel){
        writeText(fieldPLTextLocationLabel, plLocLabel);
    }

    private void plLocationHint (String plLocHint){
        writeText(fieldPLTextLocationHint, plLocHint);
    }

    private void plQRLabel (String plQRLabel){
        writeText(fieldPLQRLocationLabel, plQRLabel);
    }

    private void plQRInstruction (String plQRInstruction){
        writeText(fieldPLQRLocationInstruction, plQRInstruction);
    }

    private void plNFCLabel (String plNFCLabel){
        writeText(fieldPLNFCLabel, plNFCLabel);
    }

    private void plNFCInstruction (String plNFCInstruction){
        writeText(fieldPLNFCInstruction, plNFCInstruction);
    }

    private void plDBCancel (String plDBCancel){
        writeText(fieldPLButtonCancel, plDBCancel);
    }

    private void plDBHelp (String plDBHelp){
        writeText(fieldPLButtonHelp, plDBHelp);
    }

    private void plDBSave (String plDBSave){
        writeText(fieldPLButtonSave, plDBSave);
    }

    private void plImage (String imageName){
        String selectImageXp = "//div[@id='image-editor-container-for-PoolsideLocationCaptureImage']"+imageOptionsAddImage;
        click(By.xpath(selectImageXp));
        selectImage(imageName);
    }

    public DeliveryOptions fillPoolsideLocation (String title, String detail,
                                                  String textLabel, String textHint,
                                                  String qrLabel, String qrInstruction,
                                                  String nfcLabel, String nfcInstruction,
                                                  String dbCancel, String dbHelp, String dbSave, String imageName){
        Pages.icsHeader().check4Frame();
        click(tabPoolside);
        plTitle(title);
        plDelail(detail);
        plLocationLabel(textLabel);
        plLocationHint(textHint);
        plQRLabel(qrLabel);
        plQRInstruction(qrInstruction);
        plNFCLabel(nfcLabel);
        plNFCInstruction(nfcInstruction);
        plDBCancel(dbCancel);
        plDBHelp(dbHelp);
        plDBSave(dbSave);
        plImage(imageName);
        applyChanges(3);

        return Pages.deliveryOptions();
    }

    //Poolside recent tab
    private void plRTitle (String plRecTitle){
        writeText(fieldPRTitle, plRecTitle);
    }

    private void plRDetail (String plRecDetail){
        writeText(fieldPRDetail, plRecDetail);
    }

    private void plRYes (String plRYes){
        writeText(fieldPRYes, plRYes);
    }

    private void plRNo (String plRNo){
        writeText(fieldPRNo, plRNo);
    }

    private void plRCancel (String plRCancel){
        writeText(fieldPRCancel, plRCancel);
    }

    private void plRImage (String imageName){
        String selectImageXp = String.format("//div[@id='image-editor-container-for-PoolsideLocationRemeberedImage']"+imageOptionsAddImage);
        click(By.xpath(selectImageXp));
        selectImage(imageName);
    }

    public DeliveryOptions fillRecent (String title, String detail,
                                       String yes, String no, String cancel,
                                       String imageName){
        Pages.icsHeader().check4Frame();
        click(tabPoolsideRecent);
        plRTitle(title);
        plRDetail(detail);
        plRYes(yes);
        plRNo(no);
        plRCancel(cancel);
        plRImage(imageName);
        applyChanges(4);

        return Pages.deliveryOptions();
    }

    //poolside help
    private void phTitle (String phTitle){
        writeText(fieldPHTitle, phTitle);
    }

    private void phBack (String phBack){
        writeText(fieldPHBack, phBack);
    }

    private void phImage (String imageName){
        String selectImageXp = "//div[contains(@id,'image-editor-container-for-PoolsideLocationCaptureHelpImages')]"+imageOptionsAddImage;
        click(By.xpath(selectImageXp));
        selectImage(imageName);
    }

    public DeliveryOptions fillHelp (String title, String back, String imageName){
        Pages.icsHeader().check4Frame();
        click(tabPoolsideHelp);
        phTitle(title);
        phBack(back);
        phImage(imageName);
        applyChanges(5);

        return Pages.deliveryOptions();
    }

    //pickup options tab
    private void poOutletName (String poOName){
        writeText(fieldOutletName, poOName);
    }

    private void poOutletAddress (String poOAddr){
        writeText(fieldOutletAddress, poOAddr);
    }

    private void poOutletPhone (String poOPhone){
        writeText(fieldOutletPhone, poOPhone);
    }

    private void poOutletEmail (String poOEmail){
        writeText(fieldOutletEmail, poOEmail);
    }

    public DeliveryOptions fillPickup (String name, String address, String phone, String email){
        Pages.icsHeader().check4Frame();
        click(tabPickup);
        poOutletName(name);
        poOutletAddress(address);
        poOutletPhone(phone);
        poOutletEmail(email);
        applyChanges(6);

        return Pages.deliveryOptions();
    }

    public DeliveryOptions generalApply (){
        Pages.icsHeader().check4Frame();
        applyChanges(1);
        return Pages.deliveryOptions();
    }

    public Stores back(){
        click(linkBack);
        return Pages.stores();
    }

    public DeliveryOptions scrapDelOpts (String fileName) throws IOException {
        JSONObject delOptsData = new JSONObject();
        JSONObject delOpts = new JSONObject();
        JSONObject poolLoc = new JSONObject();
        JSONObject poolRecent = new JSONObject();
        JSONObject poolHelp = new JSONObject();
        JSONObject pickup = new JSONObject();
        Pages.icsHeader().check4Frame();
        click(tabDelOpts);
        delOpts.put("title", getFieldValue(fieldOptionsDelOpTitle));
        delOpts.put("detail", getAText(fieldOptionsDelOpDetail));
        delOpts.put("rdLabel", getFieldValue(fieldOptionsRoomLabel));
        delOpts.put("rdSubtitle", getFieldValue(fieldOptionsRoomSubtitle));
        delOpts.put("pdLabel", getFieldValue(fieldOptionsPoolLabel));
        delOpts.put("pdSubtitle", getFieldValue(fieldOptionsPoolSubtitle));
        delOpts.put("pickLabel", getFieldValue(fieldOptionsPickupLabel));
        delOpts.put("pickSubtitle", getFieldValue(fieldOptionsPickupSubtitle));

        delOptsData.put("delOpts", delOpts);

        click(tabPoolside);
        poolLoc.put("title", getFieldValue(fieldPLTitle));
        poolLoc.put("detail", getFieldValue(fieldPLDetail));
        poolLoc.put("textLabel", getFieldValue(fieldPLTextLocationLabel));
        poolLoc.put("textHint", getFieldValue(fieldPLTextLocationHint));
        poolLoc.put("qrLabel", getFieldValue(fieldPLQRLocationLabel));
        poolLoc.put ("qrInstruction", getFieldValue(fieldPLQRLocationInstruction));
        poolLoc.put ("nfcLabel", getFieldValue(fieldPLNFCLabel));
        poolLoc.put("nfcInstruction", getFieldValue(fieldPLNFCInstruction));
        poolLoc.put("cancel", getFieldValue(fieldPLButtonCancel));
        poolLoc.put("help", getFieldValue(fieldPLButtonHelp));
        poolLoc.put("save", getFieldValue(fieldPLButtonSave));

        delOptsData.put("poolLoc", poolLoc);

        click(tabPoolsideRecent);
        poolRecent.put("title", getFieldValue(fieldPRTitle));
        poolRecent.put("detail", getFieldValue(fieldPRDetail));
        poolRecent.put("yes", getFieldValue(fieldPRYes));
        poolRecent.put("no", getFieldValue(fieldPRNo));
        poolRecent.put("cancel", getFieldValue(fieldPRCancel));

        delOptsData.put("poolRecent", poolRecent);

        click(tabPoolsideHelp);
        poolHelp.put("title", getFieldValue(fieldPHTitle));
        poolHelp.put("back", getFieldValue(fieldPHBack));

        delOptsData.put("poolHelp", poolHelp);

        click(tabPickup);
        pickup.put("outName", getFieldValue(fieldOutletName));
        pickup.put("outAddress", getAText(fieldOutletAddress));
        pickup.put("outPhone", getFieldValue(fieldOutletPhone));
        pickup.put("outEmail", getFieldValue(fieldOutletEmail));

        delOptsData.put("pickup",pickup);

        FileWriter fw = new FileWriter(fileName);
        fw.write(delOptsData.toString().toCharArray());
        fw.close();
        return Pages.deliveryOptions();
    }

    public DeliveryOptions fillAllFromFile (String file, String imageName) throws IOException, ParseException {
        JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(file));
        Pages.icsHeader().check4Frame();
        JSONObject delOpts = (JSONObject) data.get("delOpts");
        JSONObject poolLoc = (JSONObject) data.get("poolLoc");
        JSONObject poolRecent = (JSONObject) data.get("poolRecent");
        JSONObject poolHelp = (JSONObject) data.get("poolHelp");
        JSONObject pickup = (JSONObject) data.get("pickup");

        System.out.println("Filling delOpts");
        fillDelOpts(
                delOpts.get("title").toString(), delOpts.get("detail").toString(),
                delOpts.get("rdLabel").toString(), delOpts.get("rdSubtitle").toString(),
                delOpts.get("pdLabel").toString(), delOpts.get("pdSubtitle").toString(),
                delOpts.get("pickLabel").toString(), delOpts.get("pickSubtitle").toString(), imageName
        );

        System.out.println("Filling poolLoc");
        fillPoolsideLocation(
                poolLoc.get("title").toString(),poolLoc.get("detail").toString(),
                poolLoc.get("textLabel").toString(), poolLoc.get("textHint").toString(),
                poolLoc.get("qrLabel").toString(), poolLoc.get ("qrInstruction").toString(),
                poolLoc.get ("nfcLabel").toString(), poolLoc.get("nfcInstruction").toString(),
                poolLoc.get("cancel").toString(), poolLoc.get("help").toString(), poolLoc.get("save").toString(),
                imageName
        );

        System.out.println("filling pool recent");
        fillRecent(
                poolRecent.get("title").toString(), poolRecent.get("detail").toString(),
                poolRecent.get("yes").toString(), poolRecent.get("no").toString(),
                poolRecent.get("cancel").toString(), imageName
        );

        System.out.println("Filling poolHelp");
        fillHelp(
                poolHelp.get("title").toString(), poolHelp.get("back").toString(), imageName
        );

        System.out.println("Filling pickup");
        fillPickup(
                pickup.get("outName").toString(),
                pickup.get("outAddress").toString(),
                pickup.get("outPhone").toString(),
                pickup.get("outEmail").toString()
        );


        return Pages.deliveryOptions();
    }

}
