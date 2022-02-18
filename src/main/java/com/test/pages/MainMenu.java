package com.test.pages;

import com.test.base.BasePage;
import org.json.JSONArray;
import org.openqa.selenium.By;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class MainMenu extends BasePage {
    private static By linkEditItem = By.xpath("//a[@itemstyle-cssclass='lnkEdit']");
    private static By buttonNewCard = By.xpath("//a[@id='main_btnNewMenu']");

    private static By fieldItemTitle = By.xpath("//input[@id='main_tbMenuTitle']");
    private static By selectAppModule = By.xpath("//select[@id='main_ddlSectionList']");
    private static By checkboxGrid = By.xpath("//input[@id='main_cbIncludeInCards']");
    private static By checkboxCarousel=By.xpath("//input[@id='main_cbIncludeInCarousel']");
    private static By checkboxCheckerBoard = By.xpath("//input[@id='main_cbIncludeInCheckerboard']");
    private static By fieldHeadline = By.xpath("//input[@id='main_tbHeadline']");
    private static By fieldSubtitle = By.xpath("//input[@id='main_tbSubtitle']");
    private static By buttonSaveCard = By.xpath("//a[@id='main_lbApply']");
    private static By buttonRemoveCard = By.xpath("//a[@id='main_lbRemove']");

    private static By bannerSuccess = By.xpath("//span[text()='Saved Successfully']");

    private static String selectorCategoryRow = "//tr[@id='ctl00_main_rgMainMenu_ctl00__%d']";
    private static String selectorCategoryLink = selectorCategoryRow+"//a[contains(@id, 'ctl00_main_rgMainMenu')]";

    public MainMenu selectCard (String cardName){
        click(getCardEdit(cardName));
        return Pages.mMenu();
    }

    public MainMenu selectCard (int index){
        System.out.println("Selecting the card by index: "+index);
        Pages.icsHeader().check4Frame();
        click(getCardEdit(index));
        return Pages.mMenu();
    }

    public LocalAttractions openLocalAttractions (int index){
        System.out.println("Switching to card by index: "+index);
        openCategory(index);
        return Pages.localAttractions();
    }

    public Transportation openTransportation (int index){
        System.out.println("Switching to card by index: "+index);
        openCategory(index);
        return Pages.transportation();
    }

    private void openCategory (int index){
        Pages.icsHeader().check4Frame();
        click(String.format(selectorCategoryLink, index));
    }

    private By getCardEdit (String cardName){
        String cardEdit = String.format("//a[text()='%s']/parent::td/following-sibling::td/a", cardName);
        return By.xpath(cardEdit);
    }

    private By getCardEdit (int index){
        String xpath = String.format("(//a[@buttontype='Link'])[%d]", index);
        return By.xpath(xpath);
    }

    private String getCardTitle (){
        waitVisibility(fieldItemTitle);
        System.out.println("Getting card title...");
        String title = getFieldValue(fieldItemTitle);
        System.out.println("Card title: "+title);
        return title;
    }

    private String getCardAppModule (){
        waitVisibility(selectAppModule);
        System.out.println("Getting app module...");
        String appModule = getAText(selectAppModule);
        System.out.println("App module: "+appModule);
        return appModule;
    }

    private String getHeadline (){
        String headline;
        System.out.println("Getting headline");
        waitVisibility(checkboxCarousel);
        if (verifyIsChecked(checkboxCarousel)||verifyIsChecked(checkboxCheckerBoard)){
            System.out.println("Headline is visible");
            headline = getFieldValue(fieldHeadline);
        }
        else {
            System.out.println("Carousel and chboard are not enabled");
            headline="";
        }
        return headline;
    }

    private String getSubtitle (){
        String subtitle;
        System.out.println("Getting subtitle");
        waitVisibility(checkboxCheckerBoard);
        if (verifyIsChecked(checkboxCarousel)||verifyIsChecked(checkboxCheckerBoard)){
            System.out.println("Subtitle is visible");
            subtitle = getFieldValue(fieldSubtitle);
        }
        else {
            System.out.println("Carousel and chboard are not enabled");
            subtitle ="";
        }
        return subtitle;
    }

    private void saveChanges (){
        System.out.println("Saving...");
        click(buttonSaveCard);
        Pages.icsHeader().checkForSuccess();
    }

    private void removeCard (){
        System.out.println("Removing the card...");
        click(buttonRemoveCard);
        System.out.println("Removed");
    }

    private void addACard (){
        System.out.println("Creating a card...");
        click(buttonNewCard);
    }

    public MainMenu scrapItems () throws IOException, InterruptedException {
        waitVisibility(linkEditItem);
        Thread.sleep(2000);
        int amount = getAllElementsCount(linkEditItem);
        System.out.println("edits amount: "+amount);
        JSONArray data = new JSONArray();
        for (int i=1; i<=amount; i++){
            System.out.println("Selecting card...");
            selectCard(i);
            System.out.println("Starting scrapping card info");
            JSONObject cardData = scrapCardInfo(i);
            System.out.println("Finished. Adding json to array");
            data.put(i, cardData);
        }
        FileWriter fw = new FileWriter("C:\\Users\\user\\Desktop\\mainMenuCards.json");
        fw.write(data.toString());
        fw.close();
        return Pages.mMenu();
    }

    private JSONObject scrapCardInfo (){
        Pages.icsHeader().check4Timeout();
        JSONObject json = new JSONObject();
        json.put("title", getCardTitle());
        json.put("app_module", getCardAppModule());
        if (verifyIsChecked(checkboxGrid)){
            json.put("grid", "true");
        }
        else {
            json.put("grid", "false");
        }

        if (verifyIsChecked(checkboxCarousel)||verifyIsChecked(checkboxCheckerBoard)) {
            json.put("headline", getHeadline());
            json.put("subtitle", getSubtitle());
        }
        if (verifyIsChecked(checkboxCarousel)){
                json.put("carousel", "true");
        }
        else {
                json.put("carousel", "false");
        }
        if (verifyIsChecked(checkboxCheckerBoard)){
                json.put("chckboard", "true");
        }
        else {
                json.put("chckboard", "false");
        }

        return json;
    }

    private JSONObject scrapCardInfo (int index){
        //Pages.icsHeader().check4Timeout();
        JSONObject json = new JSONObject();
        json.put("index", index);

        json.put("title", getCardTitle());
        json.put("app_module", getCardAppModule());
        if (verifyIsChecked(checkboxGrid)){
            json.put("grid", "true");
            System.out.println("Grid = true");
        }
        else {
            json.put("grid", "false");
            System.out.println("Grid = false");
        }

        if (verifyIsChecked(checkboxCarousel)||verifyIsChecked(checkboxCheckerBoard)) {
            System.out.println("Carousel OR checkerboard is enambed");
            json.put("headline", getHeadline());
            json.put("subtitle", getSubtitle());
        }
        else {
            System.out.println("Carousel or checkerboard are not enabled, skipping headline and subtitle");
        }

        if (verifyIsChecked(checkboxCarousel)){
            json.put("carousel", "true");
            System.out.println("Carousel true");
        }
        else {
            json.put("carousel", "false");
            System.out.println("Carousel false");
        }
        if (verifyIsChecked(checkboxCheckerBoard)){
            json.put("chckboard", "true");
            System.out.println("Checkerboard true");
        }
        else {
            json.put("chckboard", "false");
            System.out.println("Checkerboard false");
        }

        saveChanges();
        return json;
    }

    public MainMenu switch2Frame (){
        switch2Frame(By.xpath("//iframe"));
        return Pages.mMenu();
    }

    public MainMenu setCardTitle (String title){
        writeText(fieldItemTitle, title);
        return Pages.mMenu();
    }

    public MainMenu setHeadline (String headline){
        writeText(fieldHeadline, headline);
        return Pages.mMenu();
    }

    public MainMenu setSubtitle (String subtitle){
        writeText(fieldSubtitle, subtitle);
        return Pages.mMenu();
    }

    public MainMenu fillCard (JSONObject json){
        setCardTitle(json.get("title").toString());
        if (json.get("chckboard").toString()=="true"||json.get("carousel").toString()=="true"){
            System.out.println("Setting headline and subtitle...");
            setHeadline(json.get("headline").toString());
            setSubtitle(json.get("subtitle").toString());
        }
        else{
            System.out.println("Checkerboard and subtitle are disabled");
        }
        saveChanges();
        return Pages.mMenu();
    }
}
