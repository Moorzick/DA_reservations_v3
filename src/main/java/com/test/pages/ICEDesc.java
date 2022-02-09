package com.test.pages;

import com.test.base.BasePage;
import com.test.base.BaseTest;
import com.test.tools.Tools;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ICEDesc extends BasePage {
    private final By descrIFrame = By.xpath("//iframe[@id='ifmain']");
    private final By droplistGroupSelector = By.xpath("//select[@id='ddlGroupGv']");
    private final By subGroupDDown = By.xpath("//select[@id='ddlSubGroup']");
    private final By nodes = By.xpath("//a[contains(@id, 'gvItems_lblNode')]");
    private final By subGroups = By.xpath("//span[contains(@id,'gvItems_lblSubGroup')]");
    private final By nodesText = By.xpath("//input[contains(@id,'gvItems_tbText')]");

    private final By droplistGroupCNode = By.xpath("//select[@id='ddlGroup']");
    private final By fieldNodeName = By.xpath("//input[@id='textNodeName']");
    private final By fieldSubGroup = Tools.inputFromId("textSubGroup");
    private final By fieldTextSize = By.xpath("//input[@id='textSize']");
    private final By buttonApplyNode = By.xpath("//a[@id='btnApplyNode']");

    private final By fieldGroupName = Tools.inputFromId("tbGroupName");
    private final By buttonAddGroup = Tools.inputFromId("btnAddGroup");

    private final By fieldSearch = By.xpath("//input[@id='tbFilterKey']");

    private final By errorNodeExists = By.xpath("//span[@id='cvNodeName' and contains(@class, 'texterror')]");


    String directoryPath = "C:\\Users\\user\\Desktop\\";
    String fileName = "ICEDescriptions.json";


    private By getNodeTextField(String nodeName) {
        String fieldXPath = String.format("//a[text()='%s']/parent::div/parent::td/following-sibling::td/div/input", nodeName);
        return By.xpath(fieldXPath);
    }

    private By getNodeTextField(int index) {
        String fieldXPath = String.format("//input[@id='gvItems_tbText_%d']", index);
        return By.xpath(fieldXPath);
    }

    private By getNodeSize(String nodeName) {
        String sizeXPath = String.format("//a[text()='%s']/parent::div/parent::td/following-sibling::td/div/span[contains(@id, 'gvItems_lblSize')]", nodeName);
        return By.xpath(sizeXPath);
    }

    private By getSubgroup(String nodeName) {
        String sGXPath = String.format("//a[contains(@id, 'gvItems_lblNode') and text()='%s']/parent::div/parent::td/preceding-sibling::td/div/span[contains(@id, 'gvItems_lblSubGroup')]", nodeName);
        By subGroup = By.xpath(sGXPath);
        return subGroup;
    }

    private String getSGText(By subGroup) {
        String text = BaseTest.driver.findElement(subGroup).getText();
        return text;
    }

    private String getNodeName(int index) {
        String nodeNameXPath = String.format("//a[@id='gvItems_lblNode_%d']", index);
        return getAText(By.xpath(nodeNameXPath));
    }

    private By getNodeByNameAndSubGroup(String nodeName, String subGroup) {
        String groupXpath = String.format("//span[contains(@id, 'gvItems_lblSubGroup') and text()='%s']/parent::div/parent::td/following-sibling::td/div/a[contains(@id, 'gvItems_lblNode') and text()='%s']", subGroup, nodeName);
        return By.xpath(groupXpath);
    }

    private By getNodeByName(String nodeName) {
        String groupXpath = String.format("//a[contains(@id, 'gvItems_lblNode') and text()='%s']", nodeName);
        return By.xpath(groupXpath);
    }

    private By getNode(int index) {
        String nodeNameXPath = String.format("//a[@id='gvItems_lblNode_%d']", index);
        return By.xpath(nodeNameXPath);
    }

    private By getSubGroup(int index) {
        String id = String.format("gvItems_lblSubGroup_%s", index);
        return Tools.byFromPropertyAndValue("span", "id", id);
    }


    private By getGroupByName(String groupName) {
        String groupXpath = String.format("//span[@id='gvItems_lblGroup_0'and text()='%s']", groupName);
        return By.xpath(groupXpath);
    }

    private By getSelectedGroup() {
        String selectedGroupXpath = "//select[@id='ddlGroupGv']/option[@selected='selected']";
        return By.xpath(selectedGroupXpath);
    }

    public ICEDesc scrapICEDescriptions() throws IOException, InterruptedException {
        Select groupsSelector = getDroplist(droplistGroupSelector);
        JSONArray data = new JSONArray();
        String currentGroup = groupsSelector.getAllSelectedOptions().get(0).getText();
        int optionsAmount = groupsSelector.getOptions().size();
        for (int i = 0; i < optionsAmount; i++) {
            System.out.println("Switching groups selector to option #" + i);
            Thread.sleep(4000);
            getDroplist(droplistGroupSelector).selectByIndex(i);
            if (verifyElementExist(By.xpath("//iframe"))) {
                switch2Frame(By.xpath("//iframe"));
            }
            if (i != 0) {
                System.out.println("Waiting for disappearing");
                waitForElementToDisappear(getGroupByName(currentGroup));
            }
            System.out.println("Getting new group...");
            currentGroup = getAText(getSelectedGroup());
            System.out.println("New current group: " + currentGroup);
            JSONObject groupData = new JSONObject();
            System.out.println("Scrapping group " + currentGroup);
            groupData.put("groupName", currentGroup);
            groupData.put("nodes", scrapGroup());
            data.add(i, groupData);
            System.out.println("Scrapping of " + currentGroup + " is completed");
            System.out.println("--------------------------------------------");
        }
        FileWriter fw = new FileWriter(directoryPath + fileName);
        char[] output = data.toString().toCharArray();
        System.out.println("Data: " + output);
        fw.write(output);
        fw.close();
        return Pages.iDesc();
    }

    private JSONArray scrapGroup() {
        JSONArray groupNodes = new JSONArray();
        int amount = getAllElementsCount(nodes);
        for (int i = 0; i < amount; i++) {
            groupNodes.add(i, scrapNode(i));
        }
        return groupNodes;
    }

    private JSONObject scrapNode(int index) {
        JSONObject node = new JSONObject();
        System.out.println("Processing node #" + index);
        String nodeName = getNodeName(index);
        System.out.println("Node name: " + nodeName);
        String subGroup = getSGText(getSubgroup(nodeName));
        System.out.println("Subgroup: " + subGroup);
        String nodeSize = getAText(getNodeSize(nodeName));
        System.out.println("Node size: " + nodeSize);
        String nodeText = getFieldValue(getNodeTextField(nodeName));
        System.out.println("Node text: " + nodeText);

        node.put("name", nodeName);
        node.put("subGroup", subGroup);
        node.put("size", nodeSize);
        node.put("text", nodeText);
        return node;
    }

    public ICEDesc fillICEDescs(String file) throws IOException, ParseException, InterruptedException {
        Pages.icsHeader().check4Frame();
        JSONParser parser = new JSONParser();
        JSONArray data = (JSONArray) parser.parse(new FileReader(file));
        for (int i = 0; i < data.size(); i++) {
            JSONObject group = (JSONObject) data.get(i);
            String groupName = group.get("groupName").toString();
            System.out.println("Got new group to process: " + groupName);
            if (!groupExist(groupName)) {
                writeText(fieldGroupName, groupName);
                click(buttonAddGroup);
                Pages.icsHeader().checkForSuccess();
            }
            JSONArray nodes = (JSONArray) group.get("nodes");
            System.out.println("Switching to group...");
            getDroplist(droplistGroupSelector).selectByVisibleText(groupName);
            Thread.sleep(4000);
            System.out.println("Starting processing the nodes");
            for (int i2 = 0; i2 < nodes.size(); i2++) {
                JSONObject node = (JSONObject) nodes.get(i2);
                String nodeName = node.get("name").toString();
                String text = node.get("text").toString();
                String subGroup;
                if (node.get("subGroup") == null) {
                    subGroup = "";
                } else {
                    subGroup = node.get("subGroup").toString();
                }
                System.out.println("Group name: " + groupName);
                System.out.println("SubGroup: " + subGroup);
                System.out.println("Node name: " + nodeName);
                System.out.println("Text: " + text);

                fillDescription(subGroup, nodeName, text);
                System.out.println("--------------------------------------------");
            }
            System.out.println("============================================");
        }
        return Pages.iDesc();
    }

    private int getNodeIndex (WebElement node){
        String id = node.getAttribute("id");
        return Integer.valueOf(id.replaceAll("gvItems_lblNode_", ""));
    }

    private void fillDescription(String subGroup, String nodeName, String text) throws InterruptedException {
        boolean sgExists = !subGroup.equals("");
        List<WebElement> foundNodes = getAllElements(getNodeByName(nodeName));
        if (foundNodes.size() != 0) {
            if (sgExists) {
                System.out.println("Processing node with subGroup");
                for (int i = 0; i < foundNodes.size(); i++) {
                    int index = getNodeIndex(foundNodes.get(i));
                    if (getAText(getSubGroup(index)).equalsIgnoreCase(subGroup)) {
                        fillTextField(getNodeTextField(index), text);
                    }
                }
            } else {
                System.out.println("Processing node without subGroup");
                getNodeTextField(nodeName);
                fillTextField(getNodeTextField(nodeName), text);
            }
        }
        else {
            System.out.println("Node " + nodeName + " doesn't exist, adding...");
            writeText(fieldNodeName, nodeName);
            writeText(fieldSubGroup, subGroup);
            writeText(fieldTextSize, "50");
            click(buttonApplyNode);
            String displaynone = getAttribute(errorNodeExists, "style");
            System.out.println("Error attribute: "+displaynone);
            if (displaynone!=null){
                Pages.icsHeader().checkForSuccess();
                fillTextField(getNodeTextField(nodeName), text);
            }
            else {
                System.out.println("Node exists with different name");
            }

        }
    }

    private void fillTextField (By textField, String text) throws InterruptedException {
        if (!text.equals("")){
            click(textField);
            String initialValue = getFieldValue(textField);
            System.out.println("Initial value: " + initialValue);
            if (getFieldValue(textField).equals("")) {
                System.out.println("Description is empty, filling with: " + text);
                writeText(textField, text);
                click(fieldSearch);
                Pages.icsHeader().checkForSuccess();
                Thread.sleep(2000);
            } else {
                System.out.println("Description is not empty, skipping");
            }
        }
        else {
            System.out.println("Text from json is empty, skipping");
        }


    }
    private boolean groupExist(String group) {
        String xp = String.format("//select[@id='ddlGroupGv']/option[text()='%s']", group);
        return verifyElementExist(By.xpath(xp));
    }
}