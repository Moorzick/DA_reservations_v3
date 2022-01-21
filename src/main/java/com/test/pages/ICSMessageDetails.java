package com.test.pages;

import com.test.base.BasePage;
import com.test.base.BaseTest;
import org.openqa.selenium.By;

import java.util.TreeMap;

import static com.codeborne.selenide.Selenide.$;

public class ICSMessageDetails extends BasePage {
    private final By msgTypeICE = By.xpath("//label[text()='ICE']/preceding-sibling::input[@name='MessageType']");
    private final By fieldSubject = By.xpath("//input[@id='txtSubject']");
    private final By editorIFrame = By.xpath("//iframe[@id='txtMessage_designEditor']");
    private final By buttonPreviewMessage = By.xpath("//a[text()='Preview Message']");
    private final By buttonSendMessage = By.xpath("//a[@id='LinkButton1']");



    private void setMsgTypeICE(){
        click(msgTypeICE);
    }

    public void sendICEMsg(int msgNu, String guestName) throws InterruptedException {
        System.out.println("Setting msg type to ICE");
        setMsgTypeICE();
        System.out.println("Set!");
        msgNu+=1;
        String messageSubject = "msg"+msgNu;
        String message = msgNu+"!";
        System.out.println("Setting subject...");
        setSubject(messageSubject);
        System.out.println("Set!");
        System.out.println("Setting message...");
        setMessage(message);
        System.out.println("Set!");
        selectGuest(guestName);
        submitMessage();
    }

    private void setSubject (String subject){
        writeText(fieldSubject, subject);
    }

    private void setMessage (String message){
        switch2Frame(editorIFrame);
        System.out.println("Switched to second frame");
        By body = By.xpath("//body");
        click(body);
        BaseTest.driver.findElement(body).sendKeys(message);
    }

    private void selectGuest (String guestName) throws InterruptedException {
        System.out.println("Checking the guest...");
        switchOutOfFrame();
        System.out.println("Switched back to main frame");
        //switch2Frame(By.xpath("//iframe[@id='ifmain']"));
        if (verifyElementExist(By.xpath(String.format("//span[contains(text(), '%s')]", guestName)))){
            System.out.println("Guest found");
        }
        By guestCheckbox = By.xpath(String.format("//span[contains(text(), '%s')]/parent::td/preceding-sibling::td/input", guestName));
        click(guestCheckbox);
    }

    private void submitMessage () throws InterruptedException {
        click(buttonPreviewMessage);
        click(buttonSendMessage);
    }
}
