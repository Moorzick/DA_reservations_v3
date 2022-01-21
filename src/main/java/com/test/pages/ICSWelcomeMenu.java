package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class ICSWelcomeMenu extends BasePage {
    private static By hotelSetup = By.xpath("//a[@class='module ics-settings']");
    private static By requestManager = By.xpath("//a[@class='module ics-requests']");
    private static By messages = By.xpath("//a[@class='module ics-messaging']");
    private static By guests = By.xpath("//a[@class='module ics-guest-accounts']");
    private static By staff = By.xpath("//a[@class='module ics-hotel-accounts']");
    private static By content = By.xpath("//a[@class='module ics-content']");
    //private static By requestManager = By.xpath("//a[@class='module ics-requests']");

    public void gotoHotelSetup (){
        System.out.println("Clicking hotel setup card");
        click(hotelSetup);
        System.out.println("Clicked!");
    }

    public void gotoRequestManager (){
        System.out.println("Clicking request manager card");
        click(requestManager);
        System.out.println("Clicked!");
    }

    public void gotoMessages (){
        System.out.println("Clicking messages card");
        click(messages);
        System.out.println("Clicked!");
    }

    public void gotoGuests (){
        System.out.println("Clicking guests card");
        click(guests);
        System.out.println("Clicked!");
    }

    public void gotoStaff (){
        System.out.println("Clicking hotel accounts card");
        click(staff);
        System.out.println("Clicked!");
    }

    public MainMenu gotoContent (){
        System.out.println("Clicking hotel setup card");
        click(content);
        System.out.println("Clicked!");
        return Pages.mMenu();
    }
}
