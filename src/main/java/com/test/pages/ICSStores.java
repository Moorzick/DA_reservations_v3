package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class ICSStores extends BasePage {

    private static By getTargetStoreBy (String storeName){
        By targetStore = By.xpath(String.format("//div[@id='main_UpdatePanel1']//a[contains(text(),'%s')]", storeName));
        return targetStore;
    }

    public void gotoSpecificStore(String storeName){
        click(getTargetStoreBy(storeName));
    }


}
