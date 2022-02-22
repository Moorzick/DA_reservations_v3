package com.test.pages;

import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class TransportationGround extends ICSMenu {
    static {
        buttonApply= Tools.aFromId("lbApplySection");
    }

    private static By fieldLeadTime = Tools.inputFromId("tbLeadTime");
    private static String idSelectFunction = "ddlSectionList";
    private static By selectFunction = Tools.selectFromId(idSelectFunction);



    public TransportationGround scrapGroundTransportation (JSONObject motherCard){
        JSONArray subSectionsData = new JSONArray();
        int amount = getRowsCount();
        for (int i=0; i<amount; i++){
            click(String.format(selectorCategoryEdit, i));
            JSONObject cardData = new JSONObject();
            cardData.put("index", i);
            scrapCard(cardData);
            String function = cardData.getString("function");

            if(!function.equals("Custom")) {
                if (!function.contains("Link")){
                    if (!function.equals("Video")){
                        gotoSection(i);
                        Pages.transportationRequest().scrapGTranspRequest(cardData).back();
                    }
                }
                else {
                    if(function.equals("Links Menu")){
                        gotoSection(i);
                        Pages.transportationGroundLinksMenu().scrapLinksMenu(cardData).back();
                    }
                }
            }
            else {
                gotoSection(i);
                Pages.transportationCustomRequest().scrapCustomTrans(cardData).back();
            }
            subSectionsData.put(i, cardData);
        }
        motherCard.put("groundTrans", subSectionsData);
        return Pages.transportationGround();
    }

    private void scrapCard (JSONObject card){
        String title = getFieldValue(fieldTitle);
        System.out.println("GT card title: "+title);
        if (verifyElementExist(fieldLeadTime)){
            String lead = getFieldValue(fieldLeadTime);
            System.out.println("GT card lead: "+lead);
            card.put("lead", lead);
        }
        String function = getActiveOptionText(idSelectFunction);
        System.out.println("GT card function: "+function);
        card.put("title", title).put("function", function);

        if (function.equals("Link")){
            String link = getFieldValue(fieldURL);
            System.out.println("GT card link: "+link);
            card.put("link", link);
        }

        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

    private void fillCard (JSONObject card){
        String function = card.getString("function");
        writeText(fieldTitle, card.getString("title"));
        if (function.equals("Link")){
            writeText(fieldURL, card.getString("link"));
        }
        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

    public Transportation back(){
        click(linkBack);
        return Pages.transportation();
    }

    public TransportationGround fillCards (JSONArray cards){
        for (int i=0; i<cards.length(); i++){
            JSONObject card = cards.getJSONObject(i);
            int index = card.getInt("index");
            editCategory(index);
            fillCard(card);

            String function = card.getString("function");
            if(!function.equals("Custom")) {
                if (!function.contains("Link")){
                    if (!function.equals("Video")){
                        gotoSection(index);
                        Pages.transportationRequest().fillGTranspRequest(card).back();
                    }
                }
                else {
                    if(function.equals("Links Menu")){
                        gotoSection(index);
                        Pages.transportationGroundLinksMenu().fillLinksMenu(card.getJSONArray("subsections")).back();
                    }
                }
            }
            else {
                gotoSection(index);
                Pages.transportationCustomRequest().fillCustomTrans(card).back();
            }
        }

        return Pages.transportationGround();
    }
}
