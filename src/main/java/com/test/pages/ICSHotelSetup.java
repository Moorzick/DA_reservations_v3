package com.test.pages;

import com.test.base.BasePage;
import com.test.base.BaseTest;
import org.openqa.selenium.By;

public class ICSHotelSetup extends BasePage {
    private static String advancedSettingsURLPiece = "/Now/Settings/Config";

    public void gotoAdvancedSettings(String icsURL) {
        System.out.println("Going to advanced settings");
        BaseTest.getDriver().navigate().to(String.format("%s%s", icsURL,advancedSettingsURLPiece));
    }
}
