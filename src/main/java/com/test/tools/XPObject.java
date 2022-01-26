package com.test.tools;

import org.openqa.selenium.By;

public class XPObject {
    private String xpath;

    public XPObject(String object) {
        if (object.matches("^//.*")){
            this.xpath=object;
        }
        else {
            this.xpath = String.format("//%s", object);
        }
    }

    public String getString (){
        return xpath;
    }

    public String asArg (){
        xpath.replaceAll("//", "");
        return xpath;
    }

    public XPObject withProperties (){
        xpath = xpath+"[";
        return new XPObject(xpath);
    }

    public XPObject property (String property){
        xpath = String.format(xpath+"@%s", property);
        return new XPObject(xpath);
    }

    public XPObject text(){
        xpath = xpath+"text()";
        return new XPObject(xpath);
    }

    public XPObject equals(String value){
        xpath = String.format(xpath+"='%s'", value);
        return new XPObject(xpath);
    }

    public XPObject containsProperty (String property, String value){
        xpath = String.format(xpath+"contains(@%s,'%s')", property, value);
        return new XPObject(xpath);
    }

    public XPObject containsText (String value){
        xpath = String.format(xpath+"contains(text(), '%s')", value);
        return new XPObject(xpath);
    }

    public XPObject and() {
        xpath = xpath+" and ";
        return new XPObject(xpath);
    }

    public XPObject div(){
        xpath=xpath+"/div";
        return new XPObject(xpath);
    }

    public XPObject td(){
        xpath=xpath+"/td";
        return new XPObject(xpath);
    }

    public XPObject fSibling(String xpObject){
        xpath=String.format(xpath+"/following-sibling::%s", xpObject.replaceAll("^//",""));
        return new XPObject(xpath);
    }

    public XPObject prSibling(String xpObject){
        xpath=String.format(xpath+"/preceding-sibling::%s", xpObject.replaceAll("^//",""));
        return new XPObject(xpath);
    }

    public XPObject parent(String xpObject){
        xpath=String.format(xpath+"/parent::%s", xpObject);
        return new XPObject(xpath);
    }

    public XPObject skipTo(){
        xpath=xpath+"/";
        return new XPObject(xpath);
    }

    public XPObject closeProps(){
        xpath=xpath+"]";
        return new XPObject(xpath);
    }

    public By toBy(){
        return By.xpath(xpath);
    }
}
