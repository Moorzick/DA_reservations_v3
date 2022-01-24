package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

public class ImageLibrary extends BasePage {
    private static By buttonAdd = Tools.aFromId("main_btnNew");
    private static By fieldSearch = Tools.inputFromId("main_tbSearchText");
    private static By buttonSearch = Tools.inputFromId("main_Search");
    private static By selectKeywords = Tools.byFromId("select", "main_ddlSectionList");
    private static By images = Tools.byFromPropertyAndValue("input", "type", "image");
    private static By currentImage = By.xpath("//img[contains(@id, 'main_dlDeviceList')]");
    private static By buttonAssignImage = Tools.aFromId("main_Button2");

    private static By firstImage = Tools.byFromPropertyAndValue("img", "id", "ctl00_main_dlImageList_ctl00_imgView");

    public ImageLibraryAdd addImage (){
        click(buttonAdd);
        return Pages.imageLibraryAdd();
    }

    public ImageLibrary assignImage (String imageName){
        System.out.println("Selecting 'All' keyword filter");
        droplistSelectByName(selectKeywords, "All");
        //writeText(fieldSearch, imageName);
        //click(buttonSearch);
        By targetImage = getImageByName(imageName);
        System.out.println("Waiting for image");
        waitVisibility(targetImage);
        System.out.println("Performing dragNdrop");
        dragNdrop(targetImage, currentImage);
        click(buttonAssignImage);
        return Pages.imageLibrary();
    }

    private By getImageByName (String imageName){
        String xpath = String.format("//span[contains(@id, 'main_dlImageList') and text()='%s']/following-sibling::img", imageName);
        return By.xpath(xpath);
    }



}
