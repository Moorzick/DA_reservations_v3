package com.test.pages;

import com.test.base.BasePage;

public class Pages extends BasePage {

    private static LoginPage loginPage;
    private static DA da;
    private static DAaffiliate daAffiliate;
    private static MockPMS mockPMS;



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


}
