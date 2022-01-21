package com.test.pages;

import com.test.base.BasePage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

import java.io.FileWriter;
import java.io.IOException;

public class Housekeeping extends BasePage {
    private static By linkEditItem = By.xpath("//a[@itemstyle-cssclass='lnkEdit']");
    private static By fieldCardName = Tools.byFromId("input", "tbSectionTitle");
    private static By buttonSaveCard = By.xpath("//a[@id='lbAddSection']");
    private static By ddownSystemFunction = By.xpath("//select[@id='ddlSectionList']");

    private static By buttonAddNew = By.xpath("//input[@id='btnNewMenu']");
    private static By buttonRemove = By.xpath("//input[@id='lbRemove']");
    private static By buttonSearch = By.xpath("//input[@id='imgQuery']");

    public Housekeeping scrapHousekeepingCards(String file) throws InterruptedException, IOException {
        switch2Frame(By.xpath("//iframe"));
        waitVisibility(linkEditItem);
        Thread.sleep(2000);
        int amount = getAllElementsCount(linkEditItem);
        System.out.println("Amount: "+amount);
        JSONArray cards = new JSONArray();
        for (int i=1; i<=amount; i++){
            Thread.sleep(2000);
            click(getEditByIndex(i));
            cards.add(i, scrapCard(i));
        }

        FileWriter fw = new FileWriter(file);
        fw.write(cards.toString().toCharArray());
        fw.close();

        return Pages.housekeeping();
    }

    private By getEditByIndex (int index){
        String editXpath = String.format("(//a[@itemstyle-cssclass='lnkEdit'])[%d]", index);
        return By.xpath(editXpath);
    }

    private JSONObject scrapCard (int index){
        JSONObject card = new JSONObject();
        card.put("index", index);
        waitVisibility(fieldCardName);
        String cardName = getElementValue(fieldCardName);
        String systemFunction = getAText(ddownSystemFunction);
        saveCard();

        return card;
    }

    private void saveCard (){
        click(buttonSaveCard);
        Pages.icsHeader().successBannerCheck();
    }

}
