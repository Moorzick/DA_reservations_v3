package com.test.pages;

import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class HousekeepingEditAdvanced extends HousekeepingEditSimple{
    private final String selectorItems = "//input[contains(@id,'txtItemName')]";
    private final By selectCustomType = Tools.selectFromId("ddlCustomType");
    private final By customBack = Tools.aFromId("btnBack");

    private JSONArray scrapItems (){
        int amount = getAllElementsCount(By.xpath(selectorItems));
        JSONArray items = new JSONArray();
        for (int i=1; i<=amount; i++){
            By item = By.xpath(String.format("("+selectorItems+")[%d]", i));
            items.put(i, getFieldValue(item));
        }
        return items;
    }

    public HousekeepingEditAdvanced scrapCardWItems (JSONObject card){
        //card.put("cardTitle", getFieldValue(fieldTitle));
        card.put("cardSubtitle", getFieldValue(fieldSubtitle));
        if (verifyElementExist(fieldLead)){
            card.put("lead", getFieldValue(fieldLead));
        }
        card.put("confTitle", getFieldValue(fieldConfirmTitle));
        card.put("confSubtitle", getFieldValue(fieldConfirmSubtitle));
        card.put("items", scrapItems());
        return Pages.housekeepingEditAdvanced();
    }

    public HousekeepingEditAdvanced scrapCustom (JSONObject card){
        String currentOption = getActiveOptionText("ddlCustomType");
        if (currentOption.contains("Concierge")||currentOption.contains("Miscellaneous")){
            scrapCardWItems(card);
        }
        if (currentOption.contains("Valet")){
            scrapCard(card);
        }
        return Pages.housekeepingEditAdvanced();
    }

    public Housekeeping back(){
        Pages.icsHeader().check4Frame();
        if (verifyElementExist(linkBack)){
            click(linkBack);
        }
        else {
            if (verifyElementExist(customBack)){
                click(customBack);
            }
        }

        return Pages.housekeeping();
    }

    public HousekeepingEditAdvanced fillEngineering (org.json.simple.JSONObject card){
        writeText(fieldTitle, card.get("title").toString());
        writeText(fieldSubtitle,card.get("cardSubtitle").toString());
        writeText(fieldLead, card.get("lead").toString());
        writeText(fieldConfirmTitle, card.get("confTitle").toString());
        writeText(fieldConfirmSubtitle, card.get("confSubtitle").toString());
        org.json.simple.JSONArray items = (org.json.simple.JSONArray) card.get("items");
        for (int i=1; i<items.size(); i++){
            writeText(By.xpath(String.format("("+selectorItems+")[%d]", i)), items.get(i).toString());
        }
        click(buttonConfirmApply);
        Pages.icsHeader().checkForSuccess();
        click(buttonTitleApply);
        Pages.icsHeader().checkForSuccess();

        return Pages.housekeepingEditAdvanced();
    }

    public HousekeepingEditAdvanced fillCustom (org.json.simple.JSONObject card){
        String currentOption = getActiveOptionText("ddlCustomType");
        writeText(fieldSubtitle,card.get("cardSubtitle").toString());
        if (verifyElementExist(fieldLead)){
            writeText(fieldLead, card.get("lead").toString());
        }
        writeText(fieldConfirmTitle, card.get("confTitle").toString());
        writeText(fieldConfirmSubtitle, card.get("confSubtitle").toString());
        if (!currentOption.contains("Valet")){
            org.json.simple.JSONArray items = (org.json.simple.JSONArray) card.get("items");
            for (int i=1; i<items.size(); i++){
                writeText(By.xpath(String.format("("+selectorItems+")[%d]", i)), items.get(i).toString());
            }
        }
        click(buttonConfirmApply);
        Pages.icsHeader().checkForSuccess();
        click(buttonTitleApply);
        Pages.icsHeader().checkForSuccess();

        return Pages.housekeepingEditAdvanced();
    }
}
