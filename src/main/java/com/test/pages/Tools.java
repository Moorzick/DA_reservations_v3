package com.test.pages;

import org.openqa.selenium.By;

public class Tools {

    public static By byFromId (String type, String id){
        String xpath = String.format("//%s[@id='%s']", type, id);
        return By.xpath(xpath);
    }

}
