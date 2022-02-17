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
    private String ddlSysFuncId = "ddlSystemFunctions";
    private String selectXPFunction = Tools.xpSelectFromId(ddlSysFuncId);

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
            sectionsData.add(i, section);
        }
        motherSection.put("subsections", sectionsData);
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
        String name = getFieldValue(fieldName);
        System.out.println("Link name: "+name);
        section.put("name", name);
        String title = getFieldValue(fieldTitle);
        System.out.println("Link title: "+title);
        section.put("title", title);
        String sectionType = getSelectionOnRB();
        System.out.println("Link type: "+sectionType);
        section.put("type", sectionType);
        switch (sectionType){
            case ("Web"):{
                section.put("link", getFieldValue(fieldURL));
                click(buttonApply);
                Pages.icsHeader().checkForSuccess();
                break;
            }
            case ("SysFunc"):{
                section.put("function", getActiveOptionText(ddlSysFuncId));
                click(buttonApply);
                Pages.icsHeader().checkForSuccess();
                break;
            }
            default:{
                click(buttonApply);
                Pages.icsHeader().checkForSuccess();
                break;
            }
        }
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
