package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class ImageLibrary extends BasePage {
    private static By buttonAdd = Tools.aFromId("main_btnNew");
    private static By fieldSearch = Tools.inputFromId("main_tbSearchText");
    private static By buttonSearch = Tools.inputFromId("main_Search");
    private static By selectKeywords = Tools.byFromId("select", "main_ddlSectionList");
    private static By images = Tools.byFromPropertyAndValue("input", "type", "image");

    public ImageLibraryAdd addImage (){
        click(buttonAdd);
        return Pages.imageLibraryAdd();
    }
}
