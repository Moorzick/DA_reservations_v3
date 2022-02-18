package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class ICSCustomRequest extends ICSRequest {

    protected String idSelectCustom = "ddlGroup";

    //Misc+Concierge
    protected String selectorRow = "//tr[@id='rgSections_ctl00__%d']";
    protected String selectorSelector=selectorRow+Tools.xpInputContainsId("cbSelect");
    protected String selectorItemName = selectorRow+Tools.xpInputContainsId("txtItemName");
    protected String selectorActivator = selectorRow+Tools.xpInputContainsId("chkActive");

    protected By fieldListLabel = Tools.inputFromId("tbRequestTypeLabel");
    protected By fieldComment = Tools.inputFromId("tbRequestCommentLabel");
    protected By fieldDescription = Tools.inputFromId("tbFieldDescription");

    protected By fieldValetLabel = Tools.inputFromId("tbRequestMsgLabel");

    //Valet only
    protected By fieldLead = Tools.inputFromId("tdLeadTime");

    private String getCustomType (){
        return getActiveOptionText(idSelectCustom);
    }

    private int getFieldsCount (){
        return getAllElementsCount(By.xpath(Tools.xpContainsAttributeWithValue("tr", "id", "rgSections_ctl00")));
    }

    protected void scrapCustom (JSONObject motherCard){
        switch (getCustomType()){
            case "Valet":{
                scrapBasicRequestFields(motherCard);
                String valetFieldLabel = getFieldValue(fieldValetLabel);
                System.out.println("Custom Valet Entry Field label: "+valetFieldLabel);
                String valetDescription = getFieldValue(fieldDescription);
                System.out.println("Custom Valet description: "+valetDescription);
                String lead = getFieldValue(fieldLead);
                System.out.println("Custom valet lead: "+lead);
                motherCard.put("label", valetFieldLabel).put("description", valetDescription).put("lead", lead);
                break;
            }
            case "Miscellaneous":{
                scrapBasicRequestFields(motherCard);
                String listLabel = getFieldValue(fieldListLabel);
                System.out.println("Custom Misc List label: "+listLabel);
                String comment = getFieldValue(fieldComment);
                System.out.println("Custom Misc comment field: "+comment);
                String description = getFieldValue(fieldDescription);
                System.out.println("Custom Misc description: "+description);
                scrapMultiFields(motherCard);
            }

            case "Concierge":{
                scrapBasicRequestFields(motherCard);
                String listLabel = getFieldValue(fieldListLabel);
                System.out.println("Custom Concierge List label: "+listLabel);
                String comment = getFieldValue(fieldComment);
                System.out.println("Custom Concirege comment field: "+comment);
                String description = getFieldValue(fieldDescription);
                System.out.println("Custom Concierge description: "+description);
                scrapMultiFields(motherCard);
            }
        }
    }

    private void scrapMultiFields (JSONObject motherCard){
        JSONArray fields = new JSONArray();
        for (int i=0; i<getFieldsCount(); i++){
            String fieldValue = getFieldValue(By.xpath(String.format(selectorItemName)));
            System.out.println("Multifield value: "+fieldValue);
            fields.put(i, fieldValue);
        }
        motherCard.put("items", fields);
    }


}
