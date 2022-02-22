package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class ICSInfoPage extends BasePage {

    protected static String selectorTableRow = "//tr[@id='rgSections_ctl00__%d']";
    protected String selectorSectionName = selectorTableRow + "//span[contains(@id, 'lbldetailName')]";
    protected String selectorSectionSelector = selectorTableRow + "//input[contains(@id, 'cbSelect')]";
    protected String selectorSectionActivator = selectorTableRow + Tools.xpInputContainsId("chkActive");
    protected String selectorSectionEdit = selectorTableRow + Tools.xpFromAttributeAndValue("a", "buttontype", "Link");

    protected By buttonAddSection = Tools.inputFromId("btnAddSection");
    protected By buttonRemoveSection = Tools.inputFromId("lbRemove");

    protected By buttonApply = Tools.aFromId("lbtnApply");
    protected By fieldTitle = Tools.inputFromId("tbSectionTitle");

    protected By iframeEditor = Tools.byFromPropertyAndValue("iframe", "id", "Editor1_designEditor");
    protected By noSections = Tools.byFromPropertyAndValue("tr", "class", "rgNoRecords");

    protected By editorBody = By.xpath("//body");
    protected By textareaEditor = Tools.textareaFromId("Editor1");
    protected By rows = Tools.byContainsPropertyWithValue("tr", "id", "rgSections_ctl00__");
    protected By html = By.xpath("//td[@id='Editor1_htmlModeTab']//img[@unselectable='on']");

    protected By linkBack = Tools.aContains("text()", "Back");

    private String getEditorText (){
        System.out.println("Switching to editor iframe");
        //switch2Frame(iframeEditor);

        click(html);
        String text = getAText(textareaEditor);
        System.out.println("Switching out of editor iframe");
        switchOutOfFrame();
        System.out.println("Header iframe check");
        Pages.icsHeader().check4Frame();
        return text;
    }

    private String setEditorText (String text){
        System.out.println("Switching to editor iframe");
        //switch2Frame(iframeEditor);
        click(html);
        writeText(textareaEditor, text);
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

    protected void scrapSection (JSONArray sections, int index){
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

    protected void scrapSections (JSONObject motherSection){
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
    }

    protected MainMenu back (){
        click(linkBack);
        return Pages.mMenu();
    }

    protected void fillSections (JSONArray subsections){
        for (int i=0; i<subsections.length(); i++){
            JSONObject subsection = (JSONObject) subsections.get(i);
            int index = Integer.parseInt(subsection.get("index").toString());
            fillSubsection(index, subsection);
        }
    }

    private void fillSubsection (int index, JSONObject subsection){
        click(String.format(selectorSectionEdit, index));
        String title = subsection.get("title").toString();
        System.out.println("Info page, subsection title: "+title);
        writeText(fieldTitle, title);
        String text = subsection.get("text").toString();
        System.out.println("Info page, subsection text: \n"+ text);
        if (!text.equals("")){
            setEditorText(text);
        }
        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

}
