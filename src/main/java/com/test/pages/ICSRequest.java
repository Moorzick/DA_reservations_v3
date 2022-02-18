package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class ICSRequest extends BasePage {
    protected static By fieldTitle = Tools.inputFromId("tbMainTitle");
    protected static By fieldSubtitle = Tools.inputFromId("tbSubTitle");

    protected final By fieldConfirmTitle = Tools.inputFromId("tbConfirmMainTitle");
    protected final By fieldConfirmSubtitle = Tools.inputFromId("tbConfirmSubTitle");

    protected static By buttonSelectImage = Tools.inputFromId("imgbtnSelectImage");

    protected static By buttonTitleApply = Tools.aFromId("lbTitleApply");
    protected static By buttonConfirmApply = Tools.aFromId("lbtnConfirmApply");

    protected final By linkBack = Tools.aContains("text()", "Back");

    protected String getTitle(){
        return getFieldValue(fieldTitle);
    }

    protected String getSubtitle (){
        return getFieldValue(fieldSubtitle);
    }

    protected String getConfirmTitle (){
        return getFieldValue(fieldConfirmTitle);
    }

    protected String getConfirmSubtitle (){
        return getFieldValue(fieldConfirmSubtitle);
    }

    protected void scrapBasicRequestFields (JSONObject motherCard){
        String title = getTitle();
        System.out.println("Request title: "+title);
        String subtitle = getSubtitle();
        System.out.println("Request subtitle: "+subtitle);
        String confTitle = getConfirmTitle();
        System.out.println("Request confTitle: "+confTitle);
        String confSubtitle = getConfirmSubtitle();
        System.out.println("Request confSubtitle: "+confSubtitle);
        motherCard.put("rTitle", title).put("rSubtitle", subtitle).put("confTitle", confTitle).put("confSubtitle", confSubtitle);
    }

}
