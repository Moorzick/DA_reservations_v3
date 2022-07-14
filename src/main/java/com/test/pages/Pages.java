package com.test.pages;

import com.test.base.BasePage;

public class Pages extends BasePage {

    private static LoginPage loginPage;
    private static DA da;
    private static DAaffiliate daAffiliate;
    private static MockPMS mockPMS;
//    private static MainICSPage mainPage;
//    private static DiningItemAdd addItemPage;
//    private static ICSMessaging messaging;
//    private static ICSMessageDetails msgDetails;
//    private static ICSHeader icsHeader;
//    private static SystemFunctions systemFunctions;
//    private static Misc misc;
//    private static LanguageSetup langSetup;
//    private static Language lang;
//    private static MainMenu mMenu;
//    private static ICEDesc iDesc;
//    private static Housekeeping housekeeping;
//    private static MediaLibrary mediaLibrary;
//    private static ImageLibrary imageLibrary;
//    private static ImageLibraryAdd imageLibraryAdd;
//    private static Stores stores;
//    private static ICSDiningStore diningStore;
//    private static ICSStoreItemAdd diningStoreAdd;
//    private static DiningCategories diningCategories;
//    private static DiningMenu diningMenu;
//    private static DiningSubmenu diningICSStoreSubmenu;
//    private static ICSStoreMenuManager diningMenuManager;
//    private static ICSLaundryStore laundryStore;
//    private static LaundryCategories laundryCategories;
//    private static LaundryAdd laundryAdd;
//    private static LaundryMenu laundryMenu;
//    private static LaundrySubMenu laundrySubmenu;
//    private static LaundryMenuManager laundryMenuManager;
//    private static ICSCustomStore customStore;
//    private static CustomCategories customCategories;
//    private static CustomAdd customAdd;
//    private static CustomMenu customMenu;
//    private static CustomSubmenu customSubmenu;
//    private static CustomMenuManager customMenuManager;
//    private static DeliveryOptions deliveryOptions;
//    private static HousekeepingEditSimple housekeepingEditSimple;
//    private static HousekeepingEditAdvanced housekeepingEditAdvanced;
//    private static LocalAttractions localAttractions;
//    private static LocalAttractionInfoPage laInfoPage;
//    private static LocalAttractionsLinkMenu laLinksMenu;
//    private static Transportation transportation;
//    private static TransportationGround transportationGround;
//    private static TransportationRequest transportationRequest;
//    private static TransportationGroundLinksMenu transportationGroundLinksMenu;
//    private static TransportationCustomRequest transportationCustomRequest;
//    private static TransportationAir transportationAir;
//    private static TransportationAirlines transportationAirlines;
//    private static TransportationFlightInfo transportationFlightInfo;
//    private static Hotel_Information hotelInfo;


    public static LoginPage loginPage (){
        if (loginPage ==null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public static DA da (){
        if (da ==null){
            da = new DA();
        }
        return da;
    }

    public static DAaffiliate dAaffiliate(){
        if (daAffiliate ==null){
            daAffiliate = new DAaffiliate();
        }
        return daAffiliate;
    }

    public static MockPMS mockPMS(){
        if (mockPMS==null){
            mockPMS=new MockPMS();
        }
        return mockPMS;
    }

    /*public static MainICSPage mainICSPage (){
        if (mainPage==null){
            mainPage=new MainICSPage();
        }
        return mainPage;
    }

    public static DiningItemAdd addDiningItemPage(){
        if (addItemPage==null){
            addItemPage=new DiningItemAdd();
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

    public static DiningCategories diningCategories(){
        if (diningCategories ==null){
            diningCategories =new DiningCategories();
        }
        return diningCategories;
    }

    public static DiningMenu diningMenu(){
        if (diningMenu ==null){
            diningMenu =new DiningMenu();
        }
        return diningMenu;
    }

    public static DiningSubmenu diningSubmenu(){
        if (diningICSStoreSubmenu ==null){
            diningICSStoreSubmenu =new DiningSubmenu();
        }
        return diningICSStoreSubmenu;
    }

    public static ICSStoreMenuManager diningMenuManager(){
        if(diningMenuManager==null){
            diningMenuManager=new ICSStoreMenuManager();
        }
        return diningMenuManager;
    }

    public static ICSLaundryStore laundryStore(){
        if(laundryStore==null){
            laundryStore=new ICSLaundryStore();
        }
        return laundryStore;
    }

    public static LaundryCategories laundryCategories(){
        if(laundryCategories==null){
            laundryCategories=new LaundryCategories();
        }
        return laundryCategories;
    }

    public static LaundryAdd laundryAdd(){
        if (laundryAdd==null){
            laundryAdd=new LaundryAdd();
        }
        return laundryAdd;
    }

    public static LaundryMenu laundryMenu(){
        if (laundryMenu==null){
            laundryMenu=new LaundryMenu();
        }
        return laundryMenu;
    }

    public static LaundrySubMenu laundrySubmenu(){
        if (laundrySubmenu==null){
            laundrySubmenu=new LaundrySubMenu();
        }
        return laundrySubmenu;
    }

    public static LaundryMenuManager laundryMenuManager(){
        if (laundryMenuManager==null){
            laundryMenuManager=new LaundryMenuManager();
        }
        return laundryMenuManager;
    }

    public static ICSCustomStore customStore(){
        if (customStore==null){
            customStore=new ICSCustomStore();
        }
        return customStore;
    }

    public static CustomCategories customCategories(){
        if (customCategories==null){
            customCategories=new CustomCategories();
        }
        return customCategories;
    }

    public static CustomAdd customAdd(){
        if (customAdd==null){
            customAdd=new CustomAdd();
        }
        return customAdd;
    }

    public static CustomMenu customMenu(){
        if (customMenu==null){
            customMenu=new CustomMenu();
        }
        return customMenu;
    }

    public static CustomSubmenu customSubmenu(){
        if (customSubmenu==null){
            customSubmenu=new CustomSubmenu();
        }
        return customSubmenu;
    }

    public static CustomMenuManager customMenuManager(){
        if (customMenuManager==null){
            customMenuManager=new CustomMenuManager();
        }
        return customMenuManager;
    }

    public static DeliveryOptions deliveryOptions(){
        if (deliveryOptions==null){
            deliveryOptions=new DeliveryOptions();
        }
        return deliveryOptions;
    }

    public static HousekeepingEditSimple housekeepingEdit(){
        if (housekeepingEditSimple ==null){
            housekeepingEditSimple =new HousekeepingEditSimple();
        }
        return housekeepingEditSimple;
    }

    public static HousekeepingEditAdvanced housekeepingEditAdvanced(){
        if (housekeepingEditAdvanced ==null){
            housekeepingEditAdvanced =new HousekeepingEditAdvanced();
        }
        return housekeepingEditAdvanced;
    }

    public static LocalAttractions localAttractions(){
        if (localAttractions==null){
            localAttractions=new LocalAttractions();
        }
        return localAttractions;
    }

    public static LocalAttractionInfoPage localAttractionsInfoPage(){
        if (laInfoPage==null){
            laInfoPage =new LocalAttractionInfoPage();
        }
        return laInfoPage;
    }

    public static LocalAttractionsLinkMenu localAttractionsLinkMenu(){
        if (laLinksMenu==null){
            laLinksMenu =new LocalAttractionsLinkMenu();
        }
        return laLinksMenu;
    }

    public static Transportation transportation(){
        if (transportation==null){
            transportation =new Transportation();
        }
        return transportation;
    }

    public static TransportationRequest transportationRequest(){
        if (transportationRequest==null){
            transportationRequest =new TransportationRequest();
        }
        return transportationRequest;
    }

    public static TransportationGround transportationGround(){
        if (transportationGround==null){
            transportationGround =new TransportationGround();
        }
        return transportationGround;
    }

    public static TransportationGroundLinksMenu transportationGroundLinksMenu(){
        if (transportationGroundLinksMenu==null){
            transportationGroundLinksMenu =new TransportationGroundLinksMenu();
        }
        return transportationGroundLinksMenu;
    }

    public static TransportationCustomRequest transportationCustomRequest(){
        if (transportationCustomRequest==null){
            transportationCustomRequest =new TransportationCustomRequest();
        }
        return transportationCustomRequest;
    }

    public static TransportationAir transportationAir(){
        if (transportationAir==null){
            transportationAir =new TransportationAir();
        }
        return transportationAir;
    }

    public static TransportationAirlines transportationAirlines(){
        if (transportationAirlines==null){
            transportationAirlines =new TransportationAirlines();
        }
        return transportationAirlines;
    }

    public static TransportationFlightInfo transportationFlightInfo(){
        if (transportationFlightInfo==null){
            transportationFlightInfo =new TransportationFlightInfo();
        }
        return transportationFlightInfo;
    }

    public static Hotel_Information hotelInfo(){
        if(hotelInfo==null){
            hotelInfo=new Hotel_Information();
        }
        return hotelInfo;
    }*/
}
