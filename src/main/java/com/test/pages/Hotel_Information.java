package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hotel_Information extends ICSInfoPage {
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
    protected By rows = Tools.byContainsPropertyWithValue("tr", "id", "rgSections_ctl00__");

    protected By linkBack = Tools.aContains("text()", "Back");


    public Hotel_Information scrapHISections (String file) throws IOException {
        JSONObject hotelInfo = new JSONObject();
        scrapSections(hotelInfo);
        FileWriter fw = new FileWriter(file);
        fw.write(hotelInfo.toString().toCharArray());
        fw.close();
        return Pages.hotelInfo();
    }


    public Hotel_Information fillHISections (String file) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(file)));
        JSONObject hotelInfo = new JSONObject(json);
        JSONArray subsections = hotelInfo.getJSONArray("subsections");
        fillSections(subsections);
        return Pages.hotelInfo();
    }
}
