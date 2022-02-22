package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class TransportationFlightInfo extends BasePage {
    private String selectorAirCode = "//span[@id='gvAirport_lbAirportCode_%d']";
    private String selectorAirport = "//span[@id='gvAirport_lbAirportName_%d']";
    private String selectorIsDefault = "//input[@id='gvAirport_rbdefault_%d']";
    private String selectorAirportEdit = "//a[contains(@href, 'Edit$%d')]";

    private By radiobuttons = Tools.byContainsPropertyWithValue("input", "id", "gvAirport_rbdefault_");

    private By buttonAdd = Tools.inputFromId("imgbtnAddAirport");
    private By buttonRemove = Tools.inputFromId("btnRemoveAirport");
    private By fieldAirCode = Tools.inputFromId("txtAirportCode");
    private By fieldAirport = Tools.inputFromId("txtAirportName");
    private By buttonApply = Tools.aFromId("lbtApplyAirport");

    private By linkBack = Tools.aContains("text()", "Back");

    private String getAirCode (int index){
        return getAText(String.format(selectorAirCode,index));
    }

    private String getAirport (int index){
        return getAText(String.format(selectorAirport, index));
    }

    private boolean isDefault (int index){
        return verifyIsChecked(String.format(selectorIsDefault,index));
    }

    public TransportationFlightInfo scrapAirports (JSONObject flightInfo){
        JSONArray airports = new JSONArray();
        for (int i=0; i<getAllElementsCount(radiobuttons); i++){
            JSONObject airport = new JSONObject();
            airport.put("code", getAirCode(i)).put("airport", getAirport(i)).put("isDefault", isDefault(i));
            airports.put(i, airport);
        }
        flightInfo.put("airports", airports);
        return Pages.transportationFlightInfo();
    }

    public TransportationFlightInfo fillAirports (JSONObject flightInfo){
        JSONArray airports = flightInfo.getJSONArray("airports");
        for (int i=0; i<airports.length(); i++){
            JSONObject airport = airports.getJSONObject(i);
            click(String.format(selectorAirportEdit, i));
            fillAirport(airport);
        }
        flightInfo.put("airports", airports);
        return Pages.transportationFlightInfo();
    }

    private void fillAirport (JSONObject airport){
        String code = airport.getString("code");
        System.out.println("Filling airport code: "+code);
        writeText(fieldAirCode, code);

        String airportTitle = airport.getString("airport");
        System.out.println("Filling airport title: "+airportTitle);
        writeText(fieldAirport, airportTitle);

        click(buttonApply);
        Pages.icsHeader().checkForSuccess();
    }

    public TransportationAir back(){
        click(linkBack);
        return Pages.transportationAir();
    }
}
