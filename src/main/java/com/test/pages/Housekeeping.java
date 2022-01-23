package com.test.pages;

import com.test.base.BasePage;
import com.test.base.BaseTest;
import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

import java.io.FileWriter;
import java.io.IOException;

public class Housekeeping extends BasePage {
    private static By edits = Tools.byFromPropertyAndValue("a", "itemstyle-cssclass","lnkEdit");
    private static By buttonAddCard = Tools.byFromId("input", "btnNewMenu");
    private static By buttonRemoveCard = Tools.byFromId("input", "lbRemove");
    private static By fieldSearh = Tools.inputFromId("tbFilterKey");
    private static By buttonSearch = Tools.inputFromId("imgQuery");
    private static By fieldCardTitle = Tools.inputFromId("tbSectionTitle");
    private static By selectSysFunc = Tools.byFromId("select", "ddlSectionList");
    private static By selectNotifGroup = Tools.byFromId("select", "ddlGroup");
    private static By buttonSaveCard = Tools.aFromId("lbAddSection");

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
        fw.write(housekeepingCards.toString().toCharArray());
        fw.close();
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

    private JSONObject scrapCard (int index){
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
        card.put("sysFunc", getAText(selectSysFunc));
        saveCard();
        return card;
    }


    private By getEditByIndex (int index){
        String xpath = String.format("(//a[@itemstyle-cssclass='lnkEdit'])[%d]", index);
        return By.xpath(xpath);
    }

    private String getSectionNameByIndex (int index){
        return getAText(By.xpath(String.format("(//tr[contains(@id, 'rgSections_ctl00')]/td[3]/a)[%d]", index)));
    }

    private void saveCard (){
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



}
