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

public class Transportation extends BasePage {
    private static String xpGroundTransportaionRow = Tools.xpFromAttributeAndValue("tr", "id", "rgSections_ctl00__0");
    private static String xpAirlineInfo = Tools.xpFromAttributeAndValue("tr", "id", "rgSections_ctl00__1");

    private static String xpGTEdit = xpGroundTransportaionRow+Tools.xpFromAttributeAndValue("a", "buttontype", "Link");
    private static String xpGT = xpGroundTransportaionRow+Tools.xpAContainsId("hyEdit");

    private static String xpAirEdit = xpAirlineInfo + Tools.xpFromAttributeAndValue("a", "buttontype", "Link");
    private static String xpAir = xpAirlineInfo + Tools.xpAContainsId("hyEdit");

    private static By fieldTitle = Tools.inputFromId("tbSectionTitle");
    private static By buttonImage = Tools.inputFromId("imgbtnSelectImage");
    private static By textareaDescription = Tools.textareaFromId("tbDescription");
    private static By buttonApply = Tools.aFromId("lbAddSection");

    public Transportation scrapTransportation (String file) throws IOException {
        JSONArray transportationData = new JSONArray();
        JSONObject groundData = new JSONObject();
        JSONObject airData = new JSONObject();
        click(xpGTEdit);
        scrapCard(groundData);
        gotoGround().scrapGroundTransportation(groundData).back();
        click(xpAirEdit);
        scrapCard(airData);
        gotoAir().scrapAirTrans(airData).back();
        transportationData.put(0, groundData).put(1, airData);

        FileWriter fw = new FileWriter(file);
        fw.write(transportationData.toString().toCharArray());
        fw.close();

        return Pages.transportation();
    }

    private void scrapCard (JSONObject card){
        String cardTitle = getFieldValue(fieldTitle);
        System.out.println("Transportation card title: "+cardTitle);
        card.put("title", cardTitle);
        String cardDesc = getAText(textareaDescription);
        System.out.println("Transportation card description: "+cardDesc);
        card.put("description", cardDesc);
        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

    public TransportationGround gotoGround (){
        click(xpGT);
        return Pages.transportationGround();
    }

    public TransportationAir gotoAir (){
        click(xpAir);
        return Pages.transportationAir();
    }

    public MainMenu back() {
        Pages.icsHeader().navigateToMainMenu();
        return Pages.mMenu();
    }

    public Transportation fillTransportation (String file) throws IOException {
        JSONArray transportationData = new JSONArray(new String(Files.readAllBytes(Paths.get(file))));
        JSONObject groundTrans = transportationData.getJSONObject(0);
        JSONObject airTrans = transportationData.getJSONObject(1);

        click(xpGTEdit);
        fillCard(groundTrans);
        gotoGround();
        Pages.transportationGround().fillCards(groundTrans.getJSONArray("groundTrans")).back();

        click(xpAirEdit);
        fillCard(airTrans);
        gotoAir();
        Pages.transportationAir().fillAirTrans(airTrans.getJSONArray("subsections")).back();

        return Pages.transportation();
    }

    private void fillCard (JSONObject card){
        String title = card.getString("title");
        System.out.println("Filling Ground transportation title: "+title);
        writeText(fieldTitle, title);
        String description = card.getString("description");
        System.out.println("Filling ground transportation description: "+description);
        writeText(textareaDescription, description);
        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }




}
