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
}
