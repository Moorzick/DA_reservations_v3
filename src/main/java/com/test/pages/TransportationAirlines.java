package com.test.pages;

import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;

public class TransportationAirlines extends ICSMenu{
    static {
        buttonApply= Tools.aFromId("lbApply");
    }


    private void scrapCard (JSONObject card){
        String title = getFieldValue(fieldTitle);
        System.out.println("Airline card title: "+title);
        String link = getFieldValue(fieldURL);
        System.out.println("Airline card link: "+link);
        card.put("title", title).put("link", link);
        click(this.buttonApply);
        //Pages.icsHeader().checkForSuccess();
        saveCardHandler();
    }

    private void fillCard (JSONObject card){
        String title = card.getString("title");
        System.out.println("Airline card title: "+title);
        writeText(fieldTitle, title);

        String link = card.getString("link");
        System.out.println("Airline card link: "+link);
        writeText(fieldURL, link);

        click(this.buttonApply);
        //Pages.icsHeader().checkForSuccess();
        saveCardHandler();
    }

    public TransportationAirlines scrapCards (JSONObject motherCard){
        JSONArray cards = new JSONArray();
        for (int i=0; i<getRowsCount(); i++){
            JSONObject card = new JSONObject();
            click(String.format(selectorCategoryEdit, i));
            scrapCard(card);
            card.put("isActive", verifyIsChecked(getActivator(i)));
            cards.put(i, card);
        }
        motherCard.put("airlines", cards);
        return Pages.transportationAirlines();
    }

    public TransportationAirlines fillCards (JSONObject motherCard){
        JSONArray cards = motherCard.getJSONArray("airlines");
        for (int i=0; i<cards.length(); i++){
            JSONObject card = cards.getJSONObject(i);
            click(String.format(selectorCategoryEdit, i));
            fillCard(card);
        }
        return Pages.transportationAirlines();
    }

    public TransportationAir back(){
        goBack();
        return Pages.transportationAir();
    }

    private void saveCardHandler (){
        try{waitForElementToDisappear(buttonApply);}
        catch (Exception e){
            System.out.println("Caught exception. Button is probably gone already");
        }
    }


}
