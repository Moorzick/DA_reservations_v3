package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class HousekeepingEditSimple extends ICSRequest {

    protected final By fieldLead = Tools.inputFromId("tbLeadTimeMins");

    public Housekeeping back(){
        Pages.icsHeader().check4Frame();
        click(linkBack);
        return Pages.housekeeping();
    }

    public HousekeepingEditSimple scrapCard (JSONObject card){
        card.put("cardTitle", getFieldValue(fieldTitle));
        card.put("cardSubtitle", getFieldValue(fieldSubtitle));
        if(verifyElementExist(fieldLead)){
            card.put("lead", getFieldValue(fieldLead));
        }
        card.put("confTitle", getFieldValue(fieldConfirmTitle));
        card.put("confSubtitle", getFieldValue(fieldConfirmSubtitle));
        return Pages.housekeepingEdit();
    }


}
