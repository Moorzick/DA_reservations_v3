package com.test.pages;

import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class TransportationAir extends ICSMenu{

    static {
        fieldURL = Tools.inputFromId("tbLink");
    }

    private final By buttonApply = Tools.aFromId("lbAddSection");

    public TransportationAirlines gotoAirline (){
        gotoSection(0);
        return Pages.transportationAirlines();
    }

    public TransportationFlightInfo gotoFlightInfo(){
        gotoSection(1); return Pages.transportationFlightInfo();
    }

    public TransportationAir scrapAirTrans (JSONObject motherCard){
        JSONArray transJson = new JSONArray();
        editCategory(0);
        JSONObject airlines = new JSONObject();
        scrapCard(airlines);
        gotoAirline().scrapCards(airlines).back();
        editCategory(1);
        JSONObject flightInfo = new JSONObject();
        scrapCard(flightInfo);
        gotoFlightInfo().scrapAirports(flightInfo).back();
        transJson.put(0, airlines).put(1, flightInfo);
        motherCard.put("subsections", transJson);
        return Pages.transportationAir();
    }

    private void scrapCard (JSONObject card){
        String title = getFieldValue(fieldTitle);
        System.out.println("Air Trans card title: "+title);
        String description = getAText(textareaDescription);
        System.out.println("Air Trans card description: "+description);
        card.put("title", title).put("description", description);
        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

    private void fillCard (JSONObject card){
        String title = card.getString("title");
        System.out.println("Air Trans card title: "+title);
        writeText(fieldTitle, title);

        String description = card.getString("description");
        System.out.println("Air Trans card description: "+description);
        writeText(textareaDescription, description);

        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

    public Transportation back(){
        goBack();
        return Pages.transportation();
    }

    public TransportationAir fillAirTrans (JSONArray subsections){
        JSONObject flightInfo = subsections.getJSONObject(1);
        JSONObject airlines = subsections.getJSONObject(0);

        editCategory(0);
        fillCard(airlines);
        gotoSection(0);
        Pages.transportationAirlines().fillCards(airlines).back();

        editCategory(1);
        fillCard(flightInfo);
        gotoSection(1);
        Pages.transportationFlightInfo().fillAirports(flightInfo).back();

        return Pages.transportationAir();
    }

}
