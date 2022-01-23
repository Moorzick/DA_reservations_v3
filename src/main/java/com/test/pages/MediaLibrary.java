package com.test.pages;

import com.test.base.BasePage;
import com.test.tools.Tools;
import org.openqa.selenium.By;

public class MediaLibrary extends BasePage {
    private static By images = Tools.aFromHref("ImageLibrary.aspx");
    private static By videos = Tools.aFromHref("VideoLibrary.aspx");

    public ImageLibrary gotoImages (){
        Pages.icsHeader().check4Frame();
        click(images);
        return Pages.imageLibrary();
    }

}
