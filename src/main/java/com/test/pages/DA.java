package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DA extends BasePage {

    private By buttonAffiliates = Tools.aFromHref("#/affiliate/list");
    private By fieldSearch = Tools.byFromPropertyAndValue("input", "ng-model", "searchText");
    private By affiliateItem = Tools.byFromPropertyAndValue("a", "ng-click", "select(affiliate)");

    private final By affListLoadingIndicator = By.xpath("//div[@class='affiliates-loading-text']");


    private void affListLoadingWait () throws InterruptedException {
        waitFor(affListLoadingIndicator);
        while (verifyElementExist(affListLoadingIndicator)){
            Thread.sleep(3000);
        }
    }

    private By getTargetPropertyBy (String propertyName){
        return Tools.aContains("text()", propertyName);
    }

    public DAaffiliate changeAffiliate (String affiliate) throws InterruptedException {
        click(buttonAffiliates);
        affListLoadingWait();
        waitForAll(affiliateItem);
        writeText(fieldSearch, affiliate);
        click(getTargetPropertyBy(affiliate));
        return Pages.dAaffiliate();
    }
}
