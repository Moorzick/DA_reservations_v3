package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class DAaffiliate extends BasePage {

    private final By editAffiliateButton = By.xpath("//a[@ui-sref='affiliate.view.edit']");
    private final By menuItemIntegrations = By.xpath("//a[@ui-sref='affiliate.view.integrations({id:affiliate.id})']");
    private final By buttonMockPMS = By.xpath("//a[@ui-sref='mockpms.main({affiliate_id: id})']");


    public MockPMS launchMockPMS (){
        click(menuItemIntegrations);
        click(buttonMockPMS);
        return Pages.mockPMS();
    }

    public String getAffiliateId (){
        waitFor(editAffiliateButton);
        return getCurrentUrl().split("/")[getCurrentUrl().split("/").length-1];
    }



}
