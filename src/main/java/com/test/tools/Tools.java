package com.test.tools;

import org.openqa.selenium.By;

public class Tools {

    public static By byFromPropertyAndValue (String item, String property, String value){
        String xpath = String.format("//%s[@%s='%s']", item, property, value);
        return By.xpath(xpath);
    }

    public static By byFromId (String item, String value){
        return byFromPropertyAndValue(item, "id", value);
    }

    public static By inputFromId (String id){
        return byFromId("input", id);
    }

    public static By aFromId (String id){
        return byFromId("a", id);
    }
}
