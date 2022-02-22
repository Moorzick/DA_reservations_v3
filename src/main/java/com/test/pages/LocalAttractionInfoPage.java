package com.test.pages;

import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;


public class LocalAttractionInfoPage extends ICSInfoPage {
    protected By fieldAddSection = Tools.inputFromId("tbName");
    protected By buttonAddImage = Tools.inputFromId("imgbtnSelectImage");
    protected By buttonAddSection = Tools.inputFromId("btnAddSection");
    protected By buttonApplyBackground = Tools.aFromId("lbtnApplyBackground");
    protected By buttonApply = Tools.aFromId("lbtnApply");
    protected By fieldSearch = Tools.inputFromId("tbFilterKey");
    protected By buttonSearch = Tools.inputFromId("imgQuery");

    protected By fieldTitle = Tools.inputFromId("tbDetailTitle");
    protected By editorBody = By.xpath("//body");
    protected By rows = Tools.byContainsPropertyWithValue("tr", "id", "rgSections_ctl00__");

    protected By iframeEditor = Tools.byFromPropertyAndValue("iframe", "id", "Editor1_designEditor");

    protected By noSections = Tools.byFromPropertyAndValue("tr", "class", "rgNoRecords");

    protected String selectorSectionName = selectorTableRow + "//span[contains(@id, 'lbldetailName')]";
    protected String selectorSectionSelector = selectorTableRow + "//input[contains(@id, 'cbSelect')]";
    protected String selectorSectionActivator = selectorTableRow + Tools.xpInputContainsId("chkActive");
    protected String selectorSectionEdit = selectorTableRow + Tools.xpFromAttributeAndValue("a", "buttontype", "Link");



    public LocalAttractionInfoPage scrapLASections(JSONObject motherSection){
        JSONArray sections = new JSONArray();
        Pages.icsHeader().check4Frame();
        if (verifyElementExist(noSections)){
            motherSection.put("subsections", java.util.Optional.ofNullable(null));
        }
        else {
            int amount = getAllElementsCount(rows);
            for (int i=0; i<amount; i++){
                click(String.format(selectorSectionEdit, i));
                scrapSection(sections, i);
            }
            motherSection.put("subsections", sections);
        }

        return Pages.localAttractionsInfoPage();
    }

    public LocalAttractions backToLA (){
        click(linkBack);
        return Pages.localAttractions();
    }

    public LocalAttractionInfoPage fillLASections (JSONArray subsections){
        fillSections(subsections);
        return Pages.localAttractionsInfoPage();
    }
}
