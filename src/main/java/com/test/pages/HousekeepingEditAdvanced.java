package com.test.pages;

import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class HousekeepingEditAdvanced extends HousekeepingEditSimple{
    private final String selectorItems = "//input[contains(@id,'txtItemName')]";
    private final By selectCustomType = Tools.selectFromId("ddlCustomType");

    private JSONArray scrapItems (){
        int amount = getAllElementsCount(By.xpath(selectorItems));
        JSONArray items = new JSONArray();
        for (int i=0; i<amount; i++){
            By item = By.xpath(String.format("("+selectorItems+")[%d]", i));
            items.put(i, getFieldValue(item));
        }
        return items;
    }

    public HousekeepingEditAdvanced scrapCardWItems (JSONObject card){
        //card.put("cardTitle", getFieldValue(fieldTitle));
        card.put("cardSubtitle", getFieldValue(fieldSubtitle));
        card.put("lead", getFieldValue(fieldLead));
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
}
