package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class ICSCustomRequest extends ICSRequest {

    protected String idSelectCustom = "ddlCustomType";

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
        String customType = getCustomType();
        System.out.println("Custom type: "+customType);
        switch (customType){
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
                motherCard.put("listLabel", listLabel).put("comment",comment).put("description", description);
                scrapMultiFields(motherCard);
                break;
            }

            case "Concierge":{
                scrapBasicRequestFields(motherCard);
                String listLabel = getFieldValue(fieldListLabel);
                System.out.println("Custom Concierge List label: "+listLabel);
                String comment = getFieldValue(fieldComment);
                System.out.println("Custom Concirege comment field: "+comment);
                String description = getFieldValue(fieldDescription);
                System.out.println("Custom Concierge description: "+description);
                motherCard.put("listLabel", listLabel).put("comment",comment).put("description", description);
                scrapMultiFields(motherCard);
                break;
            }

            default:{
                System.out.println("Custom type not identified");
            }
        }
    }

    private void scrapMultiFields (JSONObject motherCard){
        JSONArray fields = new JSONArray();
        for (int i=0; i<getFieldsCount(); i++){
            String fieldValue = getFieldValue(selectorItemName, i);
            System.out.println("Multifield value: "+fieldValue);
            fields.put(i, fieldValue);
        }
        motherCard.put("items", fields);
    }

    private void fillMultiFields (JSONObject motherCard){
        JSONArray fields = motherCard.getJSONArray("items");
        for (int i=0; i<fields.length(); i++){
            String fieldValue = fields.getString(i);
            System.out.println("Multifield value: "+fieldValue);
            writeText(String.format(selectorItemName,i), fieldValue);
        }
    }

    public void fillCustom (JSONObject motherCard){
        String customType = motherCard.getString("customType");
        System.out.println("Custom type: "+customType);
        switch (customType){
            case "Valet":{
                fillBasicRequestFields(motherCard);
                String valetFieldLabel = motherCard.getString("label");
                System.out.println("Custom Valet Entry Field label: "+valetFieldLabel);
                writeText(fieldValetLabel, valetFieldLabel);

                String valetDescription = motherCard.getString("description");
                System.out.println("Custom Valet description: "+valetDescription);
                writeText(fieldDescription, valetDescription);

                break;
            }
            case "Miscellaneous":{
                fillBasicRequestFields(motherCard);
                String listLabel = motherCard.getString("listLabel");
                System.out.println("Custom Misc List label: "+listLabel);
                writeText(fieldListLabel, listLabel);

                String comment = motherCard.getString("comment");
                System.out.println("Custom Misc comment field: "+comment);
                writeText(fieldComment, comment);

                String description = motherCard.getString("description");
                System.out.println("Custom Misc description: "+description);
                writeText(fieldDescription, description);

                fillMultiFields(motherCard);
                break;
            }

            case "Concierge":{
                fillBasicRequestFields(motherCard);
                String listLabel = motherCard.getString("listLabel");
                System.out.println("Custom Concierge List label: "+listLabel);
                writeText(fieldListLabel, listLabel);

                String comment = motherCard.getString("comment");
                System.out.println("Custom Concierge comment field: "+comment);
                writeText(fieldComment, comment);

                String description = motherCard.getString("description");
                System.out.println("Custom Concierge description: "+description);
                writeText(fieldDescription, description);
                fillMultiFields(motherCard);
                break;
            }

            default:{
                System.out.println("Custom type not identified");
            }
        }
        click(buttonConfirmApply);
        Pages.icsHeader().checkForSuccess();
        click(buttonTitleApply);
        Pages.icsHeader().checkForSuccess();
    }


}
