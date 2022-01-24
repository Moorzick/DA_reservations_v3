package com.test.pages;

import com.test.base.BasePage;
import com.test.base.BaseTest;
import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Housekeeping extends BasePage {
    private static By edits = Tools.byFromPropertyAndValue("a", "itemstyle-cssclass","lnkEdit");
    private static By buttonAddCard = Tools.byFromId("input", "btnNewMenu");
    private static By buttonRemoveCard = Tools.byFromId("input", "lbRemove");
    private static By fieldSearh = Tools.inputFromId("tbFilterKey");
    private static By buttonSearch = Tools.inputFromId("imgQuery");
    private static By fieldCardTitle = Tools.inputFromId("tbSectionTitle");
    private static By fieldLink = Tools.inputFromId("txtLink");
    private static By selectSysFunc = Tools.byFromId("select", "ddlSectionList");
    private static By selectNotifGroup = Tools.byFromId("select", "ddlGroup");
    private static By buttonSaveCard = Tools.aFromId("lbAddSection");
    private static By buttonImage = Tools.inputFromId("imgbtnSelectImage");

    public Housekeeping scrapCards (String file) throws InterruptedException, IOException {
        Pages.icsHeader().check4Frame();
        waitVisibility(edits);
        Thread.sleep(2000);
        int amount = getAllElementsCount(edits);
        System.out.println("Edits amount: "+amount);
        JSONArray housekeepingCards = new JSONArray();
        for (int i=1; i<=amount; i++){
            System.out.println("Scrapping: "+getSectionNameByIndex(i));
            click(getEditByIndex(i));
            housekeepingCards.put(i, scrapCard(i));
            System.out.println("======================");
        }
        FileWriter fw = new FileWriter(file);
        fw.write(Tools.jsonArrayClearNulls(housekeepingCards).toString().toCharArray());
        fw.close();
        return Pages.housekeeping();
    }

    public Housekeeping localizeCards (String file) throws IOException, ParseException, InterruptedException {
        Pages.icsHeader().check4Frame();
        org.json.simple.JSONArray cards = (org.json.simple.JSONArray) new JSONParser ().parse(new FileReader(file));
        for (int i=0; i<cards.size(); i++){
            org.json.simple.JSONObject card = (org.json.simple.JSONObject) cards.get(i);
            String title = card.get("title").toString();
            System.out.println("Working on: "+title);
            editCard(Integer.valueOf(card.get("index").toString()));
            if (card.get("sysFunc").toString().contains("Link\n")){
                String link = card.get("linkURL").toString();
                localizeCard(title, link);
            }
            else {
                localizeCard(title);
            }
            System.out.println("-------------");
        }
        return Pages.housekeeping();
    }

    public Housekeeping activateCard (int index){
        Pages.icsHeader().check4Frame();
        waitVisibility(edits);
        System.out.println("Activating "+getSectionNameByIndex(index));
        By activator = getCardActivator(index);
        if (verifyIsChecked(activator)){
            System.out.println("Already active");
        }
        else {
            System.out.println("Not active, clicking");
            click(activator);
        }
        return Pages.housekeeping();
    }

    public Housekeeping activateCard (String cardName){
        Pages.icsHeader().check4Frame();
        waitVisibility(edits);
        System.out.println("Activating "+cardName);
        By activator = getCardActivator(cardName);
        if (verifyIsChecked(activator)){
            System.out.println("Already active");
        }
        else {
            System.out.println("Not active, clicking");
            click(activator);
        }
        return Pages.housekeeping();
    }

    public Housekeeping deleteCard (int index){
        Pages.icsHeader().check4Frame();
        waitVisibility(edits);
        System.out.println("Deleting "+getSectionNameByIndex(index));
        click(getCardSelector(index));
        click(buttonRemoveCard);
        alertAccept();
        Pages.icsHeader().checkForSuccess();
        return Pages.housekeeping();
    }

    public Housekeeping deleteCard (String cardName){
        Pages.icsHeader().check4Frame();
        waitVisibility(edits);
        System.out.println("Deleting "+cardName);
        click(getCardSelector(cardName));
        click(buttonRemoveCard);
        alertAccept();
        Pages.icsHeader().checkForSuccess();
        return Pages.housekeeping();
    }

    private JSONObject scrapCard (int index) throws InterruptedException {
        JSONObject card = new JSONObject();
        String title = getFieldValue(fieldCardTitle);
        System.out.println("Card title: "+title);
        card.put("index", index);
        card.put("title", title);
        if (verifyElementExist(selectNotifGroup)){
            System.out.println("Notification select exist, getting active value...");
            card.put("notify", getActiveOptionText("ddlGroup"));
        }
        else {
            System.out.println("No notification group needed");
            card.put("notify", "null");
        }
        String sysFunc = getAText(selectSysFunc);
        if (sysFunc.contains("Link") && !sysFunc.contains("Links Menu")){
            System.out.println("Link card detected!");
            card.put("linkURL", getFieldValue(fieldLink));
            System.out.println("Link: "+getFieldValue(fieldLink));
        }
        card.put("sysFunc", getAText(selectSysFunc));
        saveCard();
        return card;
    }

    public Housekeeping addLinkCard (String cardTitle, String url, String imageName){
        Pages.icsHeader().check4Frame();
        System.out.println("Clicking add button");
        click(buttonAddCard);
        System.out.println("Assigning the image...");
        addImage(imageName);
        System.out.println("Selecting function");
        droplistSelectByName(selectSysFunc, "Link");
        waitVisibility(fieldLink);
        writeText(fieldCardTitle, cardTitle);
        writeText(fieldLink, url);
        click(buttonSaveCard);
        return Pages.housekeeping();
    }

    public Housekeeping addCustomCard (String cardTitle, String imageName){
        Pages.icsHeader().check4Frame();
        System.out.println("Clicking add button");
        click(buttonAddCard);
        System.out.println("Assigning the image...");
        addImage(imageName);
        System.out.println("Selecting function");
        droplistSelectByName(selectSysFunc, "Custom");
        writeText(fieldCardTitle, cardTitle);

        click(buttonSaveCard);

        return Pages.housekeeping();
    }



    private void addImage (String imageName){
        click(buttonImage);
        Pages.imageLibrary().assignImage (imageName);
    }

    private By getEditByIndex (int index){
        String xpath = String.format("(//a[@itemstyle-cssclass='lnkEdit'])[%d]", index);
        return By.xpath(xpath);
    }

    private String getSectionNameByIndex (int index){
        return getAText(By.xpath(String.format("(//tr[contains(@id, 'rgSections_ctl00')]/td[3]/a)[%d]", index)));
    }

    private void saveCard () throws InterruptedException {
        //BaseTest.driver.switchTo().activeElement().findElement(buttonSaveCard);
        Thread.sleep(1000);
        click(buttonSaveCard);
        Pages.icsHeader().checkForSuccess();
    }

    private By getCardActivator (String cardName){
        String xpath = String.format("//a[contains(text(), '%s')]/parent::td/following-sibling::td/input[@type='checkbox']", cardName);
        return By.xpath(xpath);
    }

    private By getCardActivator (int index){
        String xpath = String.format("(//td[5]/input[@type='checkbox'])[%d]", index);
        return By.xpath(xpath);
    }

    private By getCardSelector (String cardName){
        String xpath = String.format("//a[contains(text(), '%s')]/parent::td/preceding-sibling::td/input[@type='checkbox']", cardName);
        return By.xpath(xpath);
    }

    private By getCardSelector (int index){
        String xpath = String.format("(//td[2]/input[@type='checkbox'])[%d]", index);
        return By.xpath(xpath);
    }

    private void localizeCard (String title) throws InterruptedException {
        writeText(fieldCardTitle, title);
        saveCard();
    }

    private void localizeCard (String title, String link) throws InterruptedException {
        System.out.println("Filling title");
        writeText(fieldCardTitle, title);
        System.out.println("Filling link");
        writeText(fieldLink, link);
        System.out.println("Saving the card");
        click(fieldSearh);
        saveCard();
    }

    private void editCard (int index){
        click(getEditByIndex(index));
    }

}
