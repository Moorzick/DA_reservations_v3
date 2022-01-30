package com.test.pages;

import com.test.tools.Tools;
import org.openqa.selenium.By;

public class CustomCategories extends ICSStoreCategories{

    static {

        linkBack= By.xpath("//span[@id='BackLabel']/parent::a");
    }

    public ICSCustomStore backToCustomStore(){
        backToStore();
        return Pages.customStore();
    }

    public CustomCategories addCustomCat (String title, String image){
        addCat(title, image);
        return Pages.customCategories();
    }

    public CustomCategories makeCustomUpsell (String catName){
        makeUpsell(catName);
        return Pages.customCategories();
    }

    public CustomCategories removeCustomUpsell (String catName){
        unUpsell(catName);
        return Pages.customCategories();
    }

}
