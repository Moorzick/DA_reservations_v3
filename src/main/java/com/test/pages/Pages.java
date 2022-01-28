package com.test.pages;

import com.test.base.BasePage;

public class Pages extends BasePage {

    private static ICSAdvancedConfigs icsAdvancedConfigs;
    private static ICSHotelSetup icsHotelSetup;
    private static ICSWelcomeMenu icsWelcomeMenu;
    private static LoginPage loginPage;
    private static MainICSPage mainPage;
    private static ICSStoreItemAdd addItemPage;
    private static ICSMessaging messaging;
    private static ICSMessageDetails msgDetails;
    private static ICSHeader icsHeader;
    private static SystemFunctions systemFunctions;
    private static Misc misc;
    private static LanguageSetup langSetup;
    private static Language lang;
    private static MainMenu mMenu;
    private static ICEDesc iDesc;
    private static Housekeeping housekeeping;
    private static MediaLibrary mediaLibrary;
    private static ImageLibrary imageLibrary;
    private static ImageLibraryAdd imageLibraryAdd;
    private static Stores stores;
    private static ICSDiningStore diningStore;
    private static ICSStoreItemAdd diningStoreAdd;
    private static ICSStoreCategories ICSStoreCategories;
    private static ICSStoreMenu ICSStoreMenu;
    private static ICSStoreSubmenu diningICSStoreSubmenu;
    private static ICSStoreMenuManager diningMenuManager;

    public static ICSAdvancedConfigs icsAdvancedConfigs (){
        if (icsAdvancedConfigs==null){
            icsAdvancedConfigs = new ICSAdvancedConfigs();
        }
        return icsAdvancedConfigs;
    }

    public static ICSHotelSetup icsHotelSetup (){
        if (icsHotelSetup==null){
            icsHotelSetup = new ICSHotelSetup();
        }
        return icsHotelSetup;
    }

    public static ICSWelcomeMenu icsWelcomeMenu (){
        if (icsWelcomeMenu==null){
            icsWelcomeMenu = new ICSWelcomeMenu();
        }
        return icsWelcomeMenu;
    }

    public static LoginPage loginPage(){
        if (loginPage==null){
            loginPage=new LoginPage();
        }
        return loginPage;
    }

    public static MainICSPage mainICSPage (){
        if (mainPage==null){
            mainPage=new MainICSPage();
        }
        return mainPage;
    }

    public static ICSStoreItemAdd addItemPage(){
        if (addItemPage==null){
            addItemPage=new ICSStoreItemAdd();
        }
        return addItemPage;
    }

    public static ICSMessaging messaging(){
        if (messaging==null){
            messaging=new ICSMessaging();
        }
        return messaging;
    }

    public static ICSMessageDetails msgDetails(){
        if (msgDetails==null){
            msgDetails=new ICSMessageDetails();
        }
        return msgDetails;
    }

    public static ICSHeader icsHeader(){
        if (icsHeader==null){
            icsHeader=new ICSHeader();
        }
        return icsHeader;
    }

    public static SystemFunctions systemFunctions(){
        if (systemFunctions==null){
            systemFunctions=new SystemFunctions();
        }
        return systemFunctions;
    }

    public static Misc misc(){
        if (misc==null){
            misc=new Misc();
        }
        return misc;
    }

    public static LanguageSetup languageSetup(){
        if (langSetup==null){
            langSetup=new LanguageSetup();
        }
        return langSetup;
    }

    public static Language language(){
        if (lang==null){
            lang=new Language();
        }
        return lang;
    }

    public static MainMenu mMenu(){
        if (mMenu==null){
            mMenu=new MainMenu();
        }
        return mMenu;
    }

    public static ICEDesc iDesc(){
        if (iDesc==null){
            iDesc=new ICEDesc();
        }
        return iDesc;
    }

    public static Housekeeping housekeeping(){
        if (housekeeping==null){
            housekeeping=new Housekeeping();
        }
        return housekeeping;
    }

    public static MediaLibrary mediaLibrary(){
        if (mediaLibrary==null){
            mediaLibrary=new MediaLibrary();
        }
        return mediaLibrary;
    }

    public static ImageLibrary imageLibrary(){
        if (imageLibrary==null){
            imageLibrary=new ImageLibrary();
        }
        return imageLibrary;
    }

    public static ImageLibraryAdd imageLibraryAdd(){
        if (imageLibraryAdd==null){
            imageLibraryAdd=new ImageLibraryAdd();
        }
        return imageLibraryAdd;
    }

    public static Stores stores(){
        if (stores==null){
            stores=new Stores();
        }
        return stores;
    }

    public static ICSDiningStore diningStore(){
        if (diningStore==null){
            diningStore=new ICSDiningStore();
        }
        return diningStore;
    }

    public static ICSStoreItemAdd diningStoreAdd(){
        if (diningStoreAdd==null){
            diningStoreAdd=new ICSStoreItemAdd();
        }
        return diningStoreAdd;
    }

    public static ICSStoreCategories diningCategories(){
        if (ICSStoreCategories ==null){
            ICSStoreCategories =new ICSStoreCategories();
        }
        return ICSStoreCategories;
    }

    public static ICSStoreMenu diningMenu(){
        if (ICSStoreMenu ==null){
            ICSStoreMenu =new ICSStoreMenu();
        }
        return ICSStoreMenu;
    }

    public static ICSStoreSubmenu diningSubmenu(){
        if (diningICSStoreSubmenu ==null){
            diningICSStoreSubmenu =new ICSStoreSubmenu();
        }
        return diningICSStoreSubmenu;
    }

    public static ICSStoreMenuManager diningMenuManager(){
        if(diningMenuManager==null){
            diningMenuManager=new ICSStoreMenuManager();
        }
        return diningMenuManager;
    }

}
