package com.test.pages;

import com.test.base.BasePage;
import com.test.base.BaseTest;
import com.test.tools.Tools;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

public class LocalAttractionsLinkMenu extends ICSLinksMenu {

    public LocalAttractionsLinkMenu scrapLASections (JSONObject motherSection){
        scrapSections(motherSection);
        return Pages.localAttractionsLinkMenu();
    }

    public LocalAttractions backToLA(){
        BaseTest.driver.navigate().back();
        Pages.icsHeader().check4Frame();
        return Pages.localAttractions();
    }

    public LocalAttractionsLinkMenu fillLASubsections (JSONArray subsections){
        fillSubsections(subsections);
        return Pages.localAttractionsLinkMenu();
    }




}
