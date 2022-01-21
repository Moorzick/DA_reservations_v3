package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MainICSPage extends BasePage {
    private final By contentHeaderMenu = By.xpath("//a[@id='hypContent']");
    private final By iceDescrMenuItem = By.xpath("//a[@id='lbtnICEDescriptions']");

    public void iceDescrAccess(){
        waitVisibility(contentHeaderMenu);
        click(contentHeaderMenu);
        //System.out.println("Tried to hover");
        click(iceDescrMenuItem);
    }

    public void switchToIFrame(){
        waitVisibility(contentHeaderMenu);

    }


}
