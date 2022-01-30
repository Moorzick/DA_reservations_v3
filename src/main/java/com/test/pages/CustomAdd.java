package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class CustomAdd extends ICSStoreItemAdd{
    static {
        buttonAssignImage= Tools.inputFromId("ImageButton1");
    }

    public ICSCustomStore addCustomItem (String title, String price, String category, String image){
        addSimple(title,image,price,category);
        return Pages.customStore();
    }
}
