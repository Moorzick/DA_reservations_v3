package com.test.pages;

import org.json.JSONObject;

public class TransportationRequest extends ICSRequest{

    public TransportationRequest scrapGTranspRequest (JSONObject card){
        System.out.println("Getting request info...");
        scrapBasicRequestFields(card);
        return Pages.transportationRequest();
    }

    public TransportationGround back (){
        click(linkBack);
        return Pages.transportationGround();
    }

    public TransportationRequest fillGTranspRequest (JSONObject card){
        System.out.println("Filling transportation request...");
        fillBasicRequestFields(card);
        click(buttonConfirmApply);
        Pages.icsHeader().checkForSuccess();
        click(buttonTitleApply);
        Pages.icsHeader().checkForSuccess();
        return Pages.transportationRequest();
    }

}
