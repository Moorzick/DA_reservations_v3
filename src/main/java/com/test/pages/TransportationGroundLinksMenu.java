package com.test.pages;

import com.test.base.BaseTest;
import org.json.JSONArray;
import org.json.JSONObject;

public class TransportationGroundLinksMenu extends ICSLinksMenu{

    public TransportationGroundLinksMenu scrapLinksMenu (JSONObject motherSection){
        scrapSections(motherSection);
        return Pages.transportationGroundLinksMenu();
    }

    public TransportationGroundLinksMenu fillLinksMenu (JSONArray subsections){
        fillSubsections(subsections);
        return Pages.transportationGroundLinksMenu();
    }

    public TransportationGround back (){
        BaseTest.driver.navigate().back();
        Pages.icsHeader().check4Frame();
        return Pages.transportationGround();
    }
}
