package com.test.tools;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class Tools {

    public static By byFromPropertyAndValue(String item, String property, String value) {
        String xpath = String.format("//%s[@%s='%s']", item, property, value);
        return By.xpath(xpath);
    }

    public static String xpFromAttributeAndValue (String item, String attribute, String value){
        return String.format("//%s[@%s='%s']", item, attribute, value);
    }

    public static By byContainsPropertyWithValue(String item, String property, String value) {
        String xpath;
        if (property.equals("text()")){
            xpath=String.format("//%s[contains(%s, '%s')]", item, property, value);
        }
        else {
            xpath = String.format("//%s[contains(@%s, '%s')]", item, property, value);
        }
        return By.xpath(xpath);
    }

    public static String xpContainsAttributeWithValue (String item, String attribute, String value){
        String xpath;
        if (attribute.equals("text()")){
            xpath=String.format("//%s[contains(%s, '%s')]", item, attribute, value);
        }
        else {
            xpath = String.format("//%s[contains(@%s, '%s')]", item, attribute, value);
        }
        return xpath;
    }

    public static By byFromId(String item, String value) {
        return byFromPropertyAndValue(item, "id", value);
    }
    public static String xpFromId (String item, String value) {return  xpFromAttributeAndValue(item, "id", value);}
    public static String xpContainsId (String item, String idPiece) {return xpContainsAttributeWithValue(item, "id", idPiece);}

    public static By inputFromId(String id) {
        return byFromId("input", id);
    }
    public static String xpInputFromId (String id) {return xpFromId("input", id); }
    public static String xpInputContainsId (String id) {return xpContainsId("input", id);}

    public static By aFromId(String id) {
        return byFromId("a", id);
    }
    public static String xpAFromId (String id) {return xpFromId("a", id);}
    public static String xpAContainsId (String idPiece) {return xpContainsId("a", idPiece);}

    public static By selectFromId(String id) {
        return byFromId("select", id);
    }
    public static String xpSelectFromId (String id) {return  xpFromId("select", id);}

    public static String xpSpanContainsId (String idPiece) {return  xpContainsId("span", idPiece);}
    public static String xpTRContainsId (String idPiece) {return  xpContainsId("tr", idPiece);}

    public static JSONArray jsonArrayClearNulls(JSONArray ja) {
        for (int i = 0; i < ja.toList().size(); i++) {
            Object obj = ja.get(i);
            if (obj.equals(null)) {
                ja.remove(i);
            }
        }
        return ja;
    }

    public static By aFromHref(String href) {
        return byFromPropertyAndValue("a", "href", href);
    }

    public static By aContains(String property, String value) {
        return byContainsPropertyWithValue("a", property, value);
    }

    public static String[] arrayPacker (String itemName, int itemsNumber){
        ArrayList<String> itemNames = new ArrayList<>();
        for(int i = 0;i<itemsNumber;i++)
    {
        if (0 <= i && i < 100) {
            itemNames.add(itemName + "00" + (i + 1));
        }
    }

    String[] items = new String[itemNames.size()];
    items =itemNames.toArray(items);
    return items;
}

}
