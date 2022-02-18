package com.test.pages;

import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;

public class TransportationAir extends ICSMenu{

    public TransportationAirlines gotoAirline (){
        gotoSection(0);
        return Pages.transportationAirlines();
    }

    public void gotoFlightInfo(){
        gotoSection(1);
    }

    public TransportationAir scrapAirTrans (JSONArray transJson){
        editCategory(0);
        JSONObject airlines = new JSONObject();
        scrapCard(airlines);
        gotoAirline();

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

}
