package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LocalAttractions extends BasePage {
    protected static By edits = Tools.byFromPropertyAndValue("a", "itemstyle-cssclass", "lnkEdit");
    protected static By fieldTitle = Tools.inputFromId("tbSectionTitle");
    protected static By fieldUrl = Tools.inputFromId("txtLink");
    protected static By buttonSelectImage = Tools.inputFromId("imgbtnSelectImage");

    protected static By radiobuttonInfoPage = Tools.inputFromId("rbinfo");
    protected static By radiobuttonWeb = Tools.inputFromId("rbwebsite");
    protected static By radiobuttonLinksMenu = Tools.inputFromId("rblinksmenu");
    protected static By radiobuttonVideo = Tools.inputFromId("rbvideo");
    protected static By rows = Tools.byContainsPropertyWithValue("tr", "id", "rgSections_ctl00__");

    protected static By buttonApply = Tools.aFromId("lbApply");
    protected static By linkBack = Tools.aContains("text()", "Back");

    protected static By buttonNew = Tools.inputFromId("btnNew");
    protected static By buttonRemove = Tools.inputFromId("lbRemoveSection");

    protected static String selectorEdit = "//a[contains (@id, 'rgSections') and @itemstyle-cssclass='lnkEdit']";
    protected static String selectorTableRow = "//tr[@id='rgSections_ctl00__%d']";
    protected static String selectorRowByName = "//a[text()='%s']/parent::td/parent::tr";
    protected static String selectorCategorySelector = selectorTableRow+"//input[contains(@id, 'cbSelect')]";
    protected static String selectorCategoryActivator = selectorTableRow+"//input[contains(@id, 'chkActive')]";
    protected static String selectorCategoryEdit = selectorTableRow+"//a[@buttontype='Link']";
    protected static String selectorCategoryLink = selectorTableRow+"//a[contains(@id, 'hyEdit')]";



    protected int getSectionIndex (String sectionName){
        By row = By.xpath(String.format(selectorRowByName,sectionName));
        String rowId = getAttribute(row,"id");
        return Integer.parseInt(rowId.replaceAll("rgSections_ctl00__", ""));
    }

    protected void selectCategory (int index) throws InterruptedException {
        check(By.xpath(String.format(selectorCategorySelector, index)));
    }

    protected void activateCategory (int index) throws InterruptedException {
        check(getObjectFromSelector(selectorCategoryActivator,index));
    }

    protected void deActivateCategory (int index){
        uncheck(String.format(selectorCategoryActivator,index));
    }

    protected void editCategory (int index){
        click(String.format(selectorCategoryEdit, index));
    }

    protected String returnRadioButton (){
        String value="null";
        if (verifyIsChecked(radiobuttonInfoPage)) {value="InfoPage";}
        if (verifyIsChecked(radiobuttonLinksMenu)){value="Links";}
        if (verifyIsChecked(radiobuttonWeb)){value="Web";}
        if (verifyIsChecked(radiobuttonVideo)){value="Video";}
        return value;
    }

    private void fillCard (JSONObject card){
        System.out.println("Filling title...");
        writeText(fieldTitle, card.get("title").toString());
        if (card.get("cardType").toString().equals("Web")){
            String url = card.get("url").toString();
            System.out.println("Local Attraction, card url = "+url);
            writeText(fieldUrl, url);
        }
        System.out.println("Saving changes...");
        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

    public MainMenu back(){
        click(linkBack);
        return Pages.mMenu();
    }

    public void gotoSection (int index){
        click(getObjectFromSelector(selectorCategoryLink, index));
    }

    public LocalAttractions scrapSections (String file) throws IOException {
        JSONArray localAttractions = new JSONArray();
        int amount = getAllElementsCount(rows);
        for (int i = 0; i<amount; i++){
            Pages.icsHeader().check4Frame();
            JSONObject category = new JSONObject();
            System.out.println("Scrapping LA section of index: "+i);
            category.put("index", i);
            click(String.format(selectorCategoryEdit, i));
            String title = getFieldValue(fieldTitle);
            System.out.println("Title: "+title);
            category.put("title", title);
            String cardType = returnRadioButton();
            System.out.println("Radiobutton: "+cardType);
            category.put("cardType", cardType);
            category.put("isActive", verifyIsChecked(String.format(selectorCategoryActivator, i)));

            switch (cardType){
                case ("InfoPage"):{
                    click(buttonApply);
                    Pages.icsHeader().checkForSuccess();
                    gotoSection(i);
                    Pages.localAttractionsInfoPage().scrapSections(category).backToLA();
                    break;
                }
                case ("Links"):{
                    click(buttonApply);
                    Pages.icsHeader().checkForSuccess();
                    gotoSection(i);
                    Pages.localAttractionsLinkMenu().scrapSections(category).backToLA();
                    break;
                }
                case ("Web"):{
                    category.put("url", getFieldValue(fieldUrl));
                    click(buttonApply);
                    Pages.icsHeader().checkForSuccess();
                    break;
                }

                default:{
                    click(buttonApply);
                    waitForElementToDisappear(buttonApply);
                }
            }
            localAttractions.add(i, category);
            System.out.println("=====================");
        }

        FileWriter fw = new FileWriter(file);
        fw.write(localAttractions.toString().toCharArray());
        fw.close();

        return Pages.localAttractions();
    }

    public LocalAttractions fillLocalAttractions (String file) throws ParseException, IOException {
        String json = new String(Files.readAllBytes(Paths.get(file)));
        JSONArray data = (JSONArray) new JSONParser().parse(json);
        for (int i=0; i<data.size(); i++){
            JSONObject section = (JSONObject) data.get(i);
            int index =Integer.parseInt(section.get("index").toString());
            editCategory(index);
            fillCard(section);
            String cardType = section.get("cardType").toString();
            switch (cardType){
                case "InfoPage":{
                    Object subsections = section.get("subsections");
                    if (subsections!=null){
                        click(String.format(selectorCategoryLink,index));
                        Pages.localAttractionsInfoPage().fillSections((JSONArray) subsections).backToLA();
                    }
                    else {
                        System.out.println("No subsections detected");
                    }
                    break;
                }
                case "Links":{
                    Object subsections = section.get("subsections");
                    if (subsections!=null){
                        click(String.format(selectorCategoryLink,index));
                        Pages.localAttractionsLinkMenu().fillSubsections((JSONArray) subsections).backToLA();
                    }
                    break;
                }
                default:{
                    break;
                }
            }
        }
        return Pages.localAttractions();
    }


}
