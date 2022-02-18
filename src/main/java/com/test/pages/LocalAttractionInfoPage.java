package com.test.pages;

import com.codeborne.selenide.Selenide;
import com.test.base.BaseTest;
import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LocalAttractionInfoPage extends LocalAttractions {
    protected By fieldAddSection = Tools.inputFromId("tbName");
    protected By buttonAddImage = Tools.inputFromId("imgbtnSelectImage");
    protected By buttonAddSection = Tools.inputFromId("btnAddSection");
    protected By buttonApplyBackground = Tools.aFromId("lbtnApplyBackground");
    protected By buttonApply = Tools.aFromId("lbtnApply");
    protected By fieldSearch = Tools.inputFromId("tbFilterKey");
    protected By buttonSearch = Tools.inputFromId("imgQuery");

    private By fieldTitle = Tools.inputFromId("tbDetailTitle");
    private By editorBody = By.xpath("//body");
    private By rows = Tools.byContainsPropertyWithValue("tr", "id", "rgSections_ctl00__");

    private By iframeEditor = Tools.byFromPropertyAndValue("iframe", "id", "Editor1_designEditor");

    private By noSections = Tools.byFromPropertyAndValue("tr", "class", "rgNoRecords");

    private String selectorSectionName = selectorTableRow + "//span[contains(@id, 'lbldetailName')]";
    private String selectorSectionSelector = selectorTableRow + "//input[contains(@id, 'cbSelect')]";
    private String selectorSectionActivator = selectorTableRow + Tools.xpInputContainsId("chkActive");
    private String selectorSectionEdit = selectorTableRow + Tools.xpFromAttributeAndValue("a", "buttontype", "Link");

    static {
        linkBack=Tools.aFromId("lbReturnUrl");
    }

    private String getEditorText (){
        System.out.println("Switching to editor iframe");
        switch2Frame(iframeEditor);
        String text = getAText(editorBody);
        System.out.println("Switching out of editor iframe");
        switchOutOfFrame();
        System.out.println("Header iframe check");
        Pages.icsHeader().check4Frame();
        return text;
    }

    private String setEditorText (String text){
        System.out.println("Switching to editor iframe");
        switch2Frame(iframeEditor);
        writeText(editorBody, text);
        System.out.println("Switching out of editor iframe");
        switchOutOfFrame();
        System.out.println("Header iframe check");
        Pages.icsHeader().check4Frame();
        return text;
    }

    private JSONObject scrapSectionData (JSONObject section){
        String title = getFieldValue(fieldTitle);
        System.out.println("Title = "+title);
        section.put("title", title);
        String editorText = getEditorText();
        System.out.println("Editor text = "+editorText);
        section.put("text", editorText);
        return section;
    }

    private void scrapSection (JSONArray sections, int index){
        JSONObject section = new JSONObject();
        System.out.println("Working on info subsection number: "+index);
        section.put("index", index);
        section.put("isActive", verifyIsChecked(String.format(selectorSectionActivator,index)));
        System.out.println("Editing subsection...");
        click(String.format(selectorSectionEdit, index));
        scrapSectionData(section);
        sections.put(index, section);
        click(buttonApply);
        waitForElementToDisappear(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

    public LocalAttractionInfoPage scrapSections (JSONObject motherSection){
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

    public LocalAttractionInfoPage fillSections (JSONArray subsections){
        for (int i=0; i<subsections.length(); i++){
            JSONObject subsection = (JSONObject) subsections.get(i);
            int index = Integer.parseInt(subsection.get("index").toString());
            fillSubsection(index, subsection);
        }

        return Pages.localAttractionsInfoPage();
    }

    private void fillSubsection (int index, JSONObject subsection){
        click(String.format(selectorSectionEdit, index));
        String title = subsection.get("title").toString();
        System.out.println("LA Info page, subsection title: "+title);
        writeText(fieldTitle, title);
        String text = subsection.get("text").toString();
        System.out.println("LA Info page, subsection text: \n"+ text);
        if (!text.equals("")){
            setEditorText(text);
        }
        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

}
