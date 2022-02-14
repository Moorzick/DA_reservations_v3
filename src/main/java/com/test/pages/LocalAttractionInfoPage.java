package com.test.pages;

import com.test.tools.Tools;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

public class LocalAttractionInfoPage extends LocalAttractions {
    protected By fieldAddSection = Tools.inputFromId("tbName");
    protected By buttonAddImage = Tools.inputFromId("imgbtnSelectImage");
    protected By buttonAddSection = Tools.inputFromId("btnAddSection");
    protected By buttonApplyBackground = Tools.aFromId("lbtnApplyBackground");
    protected By fieldSearch = Tools.inputFromId("tbFilterKey");
    protected By buttonSearch = Tools.inputFromId("imgQuery");

    private By fieldTitle = Tools.inputFromId("tbDetailTitle");
    private By editorBody = By.xpath("//body");
    private By rows = Tools.byContainsPropertyWithValue("tr", "id", "rgSections_ctl00__");

    private By iframeEditor = Tools.byFromPropertyAndValue("iframe", "id", "Editor1_designEditor");

    private String selectorSectionName = selectorTableRow + "//span[contains(@id, 'lbldetailName')]";
    private String selectorSectionSelector = selectorTableRow + "//input[contains(@id, 'cbSelect')]";
    private String selectorSectionActivator = selectorTableRow + Tools.xpInputContainsId("chkActive");
    private String selectorSectionEdit = selectorTableRow + Tools.xpFromAttributeAndValue("a", "buttontype", "Link");

    static {
        linkBack=Tools.aFromId("lbReturnUrl");
    }

    private String getEditorText (){
        switch2Frame(iframeEditor);
        String text = getAText(editorBody);
        switchOutOfFrame();
        return text;
    }

    private JSONObject scrapSectionData (JSONObject section){
        section.put("title", getFieldValue(fieldTitle));
        section.put("text", getEditorText());
        return section;
    }

    private void scrapSection (JSONArray sections, int index){
        JSONObject section = new JSONObject();
        section.put("index", index);
        section.put("isActive", verifyIsChecked(String.format(selectorSectionActivator,index)));
        click(String.format(selectorSectionEdit, index));
        scrapSectionData(section);
        sections.add(index, section);
    }

    public LocalAttractionInfoPage scrapSections (JSONObject motherSection){
        JSONArray sections = new JSONArray();
        Pages.icsHeader().check4Frame();
        int amount = getAllElementsCount(rows);
        for (int i=0; i<amount; i++){
            click(String.format(selectorSectionEdit, i));
            scrapSection(sections, i);
            click(buttonApply);
            waitForElementToDisappear(buttonApply);
        }
        return Pages.localAttractionsInfoPage();
    }

    public LocalAttractions backToLA (){
        click(linkBack);
        return Pages.localAttractions();
    }

}
