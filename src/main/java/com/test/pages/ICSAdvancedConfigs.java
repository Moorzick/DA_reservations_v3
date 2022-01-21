package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class ICSAdvancedConfigs extends BasePage {
    private static By sideMenuPush = By.xpath("//a[@href='#section-pushnotifications']");
    private static By pushPusherURL = By.xpath("//input[@id='PushNotifications_IOSPushUrl']");
    private static By pushButtonApply = By.xpath("//form[@id='section-pushnotifications']//input[@type='submit']");

    public void gotoPush (){
        System.out.println("Switching to Push Messages section");
        click(sideMenuPush);
        System.out.println("Switched");
    }

    public void setPusherURL (String pusherURL){
        gotoPush();
        System.out.println("Changing push to: "+pusherURL);
        writeText(pushPusherURL, pusherURL);
        click(pushButtonApply);
        System.out.println("Changes applied");
    }
}
