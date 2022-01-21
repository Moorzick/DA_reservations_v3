package com.test.pages;

import com.test.base.BasePage;
import org.openqa.selenium.By;

public class ICSMessaging extends BasePage {
    private final By buttonNewMessage = By.xpath("//input[@id='btnNewMessage']");
    private final By lastMessageSubject = By.xpath("//a[contains(@id, 'gvMessage_lblSubject_0')]");


    private void createNewMessage(){
        click(buttonNewMessage);
    }

    public void createNewICEMsg(String guestName) throws InterruptedException {
        switch2Frame(By.xpath("//iframe"));
        createNewMessage();
        String lastMessage;
        String messageNumber;
        int msgNu;
        if (verifyElementExist(lastMessageSubject)){
            lastMessage=getAText(lastMessageSubject);
            if (lastMessage.split("msg").length!=0){
                messageNumber=lastMessage.replaceAll("msg", "");
                msgNu=Integer.valueOf(messageNumber);
            }
            else {
                msgNu=1;
            }
        }
        else {
            msgNu=1;
        }
        Pages.msgDetails().sendICEMsg(msgNu, guestName);
        Thread.sleep(5000);
    }
}
