package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

public class Transportation extends BasePage {
    private static String xpGroundTransportaionRow = Tools.xpFromAttributeAndValue("tr", "id", "rgSections_ctl00__0");
    private static String xpAirlineInfo = Tools.xpFromAttributeAndValue("tr", "id", "rgSections_ctl00__1");

    private static String xpGTEdit = xpGroundTransportaionRow+Tools.xpFromAttributeAndValue("a", "buttontype", "Link");
    private static String xpGT = xpGroundTransportaionRow+Tools.xpAContainsId("hyEdit");

    private static String xpAirEdit = xpAirlineInfo + Tools.xpFromAttributeAndValue("a", "buttontype", "Link");
    private static String xpAir = xpAirlineInfo + Tools.xpAContainsId("hyEdit");

    private static By fieldTitle = Tools.inputFromId("tbSectionTitle");
    private static By buttonImage = Tools.inputFromId("imgbtnSelectImage");
    private static By textareaDescription = Tools.textareaFromId("tbDescription");
    private static By buttonApply = Tools.aFromId("lbAddSection");

    public Transportation scrapTransportation (String file){
        JSONArray transportationData = new JSONArray();
        JSONObject groundData = new JSONObject();
        JSONObject airData = new JSONObject();
        click(xpGTEdit);
        scrapCard(groundData);

        return Pages.transportation();
    }

    private void scrapCard (JSONObject card){
        String cardTitle = getFieldValue(fieldTitle);
        System.out.println("Transportation card title: "+cardTitle);
        card.put("title", cardTitle);
        String cardDesc = getAText(textareaDescription);
        System.out.println("Transportation card description: "+cardDesc);
        card.put("description", cardDesc);
        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

    private void gotoGround (){
        click(xpGT);
    }

    private void gotoAir (){
        click(xpAir);
    }

}
