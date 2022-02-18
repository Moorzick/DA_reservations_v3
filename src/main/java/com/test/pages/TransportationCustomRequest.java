package com.test.pages;

import org.json.JSONObject;

public class TransportationCustomRequest extends ICSCustomRequest {

    public TransportationCustomRequest scrapCustomTrans (JSONObject motherCard){
        scrapCustom(motherCard);
        return Pages.transportationCustomRequest();
    }

    public TransportationGround back(){
        click(linkBack);
        return Pages.transportation().gotoGround();
    }


}
