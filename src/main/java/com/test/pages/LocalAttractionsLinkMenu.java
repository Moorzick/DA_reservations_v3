package com.test.pages;

import com.test.base.BasePage;
import com.test.base.BaseTest;
import com.test.tools.Tools;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

public class LocalAttractionsLinkMenu extends LocalAttractions {
    protected static String selectorTableRow = "//tr[@id='rgSections_ctl00__%d']";
    private String selectorSectionEdit = selectorTableRow + Tools.xpFromAttributeAndValue("a", "buttontype", "Link");
    private String selectXPFunction = Tools.xpSelectFromId("ddlSystemFunctions");

    private By rows = Tools.byContainsPropertyWithValue("tr", "id", "rgSections_ctl00__");

    protected static By buttonNewMenu = Tools.inputFromId("btnNewMenu");
    protected static By fieldName = Tools.inputFromId("tbName");
    protected static By fieldTitle = Tools.inputFromId("tbTitle");
    protected static By rbWeb = Tools.inputFromId("rbWebsite");
    protected static By rbVideo = Tools.inputFromId("rbVideo");
    protected static By rbSystemFunc = Tools.inputFromId("rbSystemFunction");
    protected static By fieldURL = Tools.inputFromId("tbLink");
    protected static By buttonImage = Tools.inputFromId("imgbtnSelectImage");

    protected static By buttonApply = Tools.aFromId("lbApply");
    protected static By buttonRemove = Tools.aFromId("lbRemove");




    public LocalAttractionsLinkMenu scrapSections (JSONObject motherSection){
        int amount = getAllElementsCount(rows);
        JSONArray sectionsData = new JSONArray();
        for (int i=0; i<amount; i++){
            JSONObject section = new JSONObject();
            section.put("index", i);
            editSection(i);
            scrapSection(section);
        }

        return Pages.localAttractionsLinkMenu();
    }

    public LocalAttractions backToLA(){
        BaseTest.driver.navigate().back();
        return Pages.localAttractions();
    }

    private void editSection (int index){
        click(By.xpath(String.format(selectorSectionEdit, index)));
    }

    private void scrapSection (JSONObject section){
        section.put("name", getFieldValue(fieldName));
        section.put("title", getFieldValue(fieldTitle));

    }

    private String getSelectionOnRB (){
        String option;
        if (verifyIsChecked(rbWeb)){
            option="Web";
        }
        else {
            if (verifyIsChecked(rbVideo)){
                option="Video";
            }
            else {
                option="SysFunc";
            }
        }
        return option;
    }


}
