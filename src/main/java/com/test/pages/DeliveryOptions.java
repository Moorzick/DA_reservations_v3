package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class DeliveryOptions extends BasePage {
    private By buttonSaveMain = By.xpath("//div[@class='input-container' and contains(text(), 'Select delivery options offered to guests that order from this store')]/parent::div/parent::div//input[@value='Apply']");
    private By buttonSaveDeliveryOptions = By.xpath("//div[@class='title item' and text()='Room Delivery']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private By buttonSavePoolsideLocations =By.xpath("//div[@class='title item' and text()='Location by Text Field']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private By buttonSavePoolsideRecent = By.xpath("//div[@class='title item' and text()='Recent Options']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private By buttonSavePoolsideHelp = By.xpath("//div[@class='title item' and text()='Help Items']/parent::div/parent::div/parent::div//input[@value='Apply']");
    private By buttonSavePickup = By.xpath("//label[@for='PickupOutletName']/parent::div/parent::div/parent::div//input[@value='Apply']");

    private By fieldDelOpTitle = Tools.inputFromId("DeliveryTitle");
    private By fieldDelOpDetail = Tools.byFromPropertyAndValue("textarea", "id", "DeliveryDetail");
    private By fieldRoomLabel = Tools.inputFromId("DeliveryRoomLabel");
    private By fieldRoomSubtitle = Tools.inputFromId("DeliveryRoomSubtitle");
    private By fieldPoolLabel = Tools.inputFromId("DeliveryPoolsideLabel");
    private By fieldPoolSubtitle = Tools.inputFromId("DeliveryPoolsideSubtitle");
    private By fieldPickupLabel = Tools.inputFromId("DeliveryPickupLabel");
    private By fieldPickupSubtitle = Tools.inputFromId("DeliveryPickupSubtitle");





}
