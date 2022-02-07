package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class HousekeepingEditSimple extends BasePage {
    protected final By fieldTitle = Tools.inputFromId("tbMainTitle");
    protected final By fieldSubtitle = Tools.inputFromId("tbSubTitle");
    protected final By fieldLead = Tools.inputFromId("tbLeadTimeMins");
    protected final By buttonSelectImage = Tools.inputFromId("imgbtnSelectImage");
    protected final By buttonTitleApply = Tools.aFromId("lbTitleApply");

    protected final By fieldConfirmTitle = Tools.inputFromId("tbConfirmMainTitle");
    protected final By fieldConfirmSubtitle = Tools.inputFromId("tbConfirmSubTitle");
    protected final By buttonConfirmApply = Tools.aFromId("lbtnConfirmApply");

    protected final By linkBack = Tools.aFromHref("HousekeepingList.aspx");

    public Housekeeping back(){
        Pages.icsHeader().check4Frame();
        click(linkBack);
        return Pages.housekeeping();
    }

    public HousekeepingEditSimple scrapCard (JSONObject card){
        //card.put("cardTitle", getFieldValue(fieldTitle));
        card.put("cardSubtitle", getFieldValue(fieldSubtitle));
        card.put("lead", getFieldValue(fieldLead));
        card.put("confTitle", getFieldValue(fieldConfirmTitle));
        card.put("confSubtitle", getFieldValue(fieldConfirmSubtitle));
        return Pages.housekeepingEdit();
    }


}
