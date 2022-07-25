package com.test.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.GenericArrayType;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    //public WebDriver driver;
    private final WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 30);
    private final int timeoutSeconds = 30;



    //Wait Wrapper Method
    public void waitForAll(By elementBy) throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementBy));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitVisibility(String selector) throws InterruptedException {
        waitForAll(By.xpath(selector));
    }

    public void waitFor (SelenideElement element){
        element.should(Condition.appear, Duration.ofSeconds(30));
    }

    public void waitFor (String selector){
        waitFor($(By.xpath(selector)));
    }

    public void waitFor (By by){
        waitFor($(by));
    }

    public boolean waitForOptional (By elementBy) throws InterruptedException {
        int initialValue = getAllElementsCount(elementBy);
        boolean change = false;
        if (initialValue!=0){
            return true;
        }
        else {
            int tries = 15;
            int i=0;
            boolean end = false;
            while (!change && i<tries){
                Thread.sleep(200);
                System.out.print("Checking for any change.");
                int newCount = getAllElementsCount(elementBy);
                System.out.print(" i="+i);
                System.out.print(" change="+change);
                System.out.print(" initial value="+initialValue);
                System.out.println(" end="+end);
                i++;
                if (newCount!=initialValue){
                    System.out.println("number of elements has been changed");
                    change=true;
                    initialValue=newCount;
                    while (!end){
                        if (initialValue!=getAllElementsCount(elementBy)){
                            System.out.println("waiting for ending of the update");
                            Thread.sleep(200);
                        }
                        else {
                            System.out.println("Update completed");
                            end=true;
                        }
                    }
                }
            }
            if (end){
                return true;
            }
            else {
                return false;
            }
        }
    }

    //Click Method
    public void click (By elementBy) {
        SelenideElement element = $(elementBy);
        waitFor(element);
        $(elementBy).click();
        //BaseTest.getDriver().findElement(elementBy).click();
    }

    public void click (WebElement element) {
        $(element).click();
    }

    public void click (SelenideElement element){
        element.click();
    }

    public void click (String selector){
        click(By.xpath(selector));
    }

    public void rightClick (By elementBy){
        rightClick($(elementBy));
    }

    public void rightClick (SelenideElement element){
        element.contextClick();
    }

    public void rightClick (String selector){
        rightClick($(By.xpath(selector)));
    }

    public void rightClick (WebElement element){
        rightClick($(element));
    }

    //Write Text
    public void writeText (By elementBy, String text) {
        $(elementBy).should(Condition.appear, Duration.ofSeconds(timeoutSeconds)).clear();
                $(elementBy).sendKeys(text);
    }

    public void writeText (String selector, String text) {
        writeText(By.xpath(selector),text);
    }

    public void hoverAbove (By elementBy) {
        actions().moveToElement($(elementBy)).build().perform();
    }

    public void switch2Frame (By elementBy) {
        switchTo().frame($(elementBy));
    }

    public void switchOutOfFrame () {
        switchTo().parentFrame();
    }

    public boolean verifyElementExist (By elementBy) {
        return $(elementBy).is(Condition.exist);
    }
    public boolean verifyElementExist (String selector) {
        return verifyElementExist(By.xpath(selector));
    }

    public boolean verifyElementVisible (By elementBy){
        return $(elementBy).is(Condition.visible);
    }

    public String getAText(By elementBy){
        return $(elementBy).shouldHave(Condition.appear).getText();
    }

    public String getAText (String selector){
        return getAText(By.xpath(selector));
    }

    public boolean verifyIsChecked (By elementBy){
        boolean isChecked;
        String checked = $(elementBy).getAttribute("checked");
        if (checked!=null){
            isChecked=true;
        }
        else {
            isChecked=false;
        }
        return isChecked;
    }

    public boolean verifyIsChecked (String selector){
        return verifyIsChecked(By.xpath(selector));
    }

    public void alertAccept(){
        switchTo().alert().accept();
    }

    public void alertDecline(){
        switchTo().alert().dismiss();
    }

    public void waitForElementToDisappear (SelenideElement element){
        element.should(Condition.disappear, Duration.ofSeconds(timeoutSeconds));
    }

    public void waitForElementToDisappear (By by){
       waitForElementToDisappear($(by));
    }

    public void dlSelectByName (By droplistBy, String optionName){
        $(droplistBy).selectOptionContainingText(optionName);
    }

    public void dlSelectByIndex (By droplistBy, int index){
        $(droplistBy).selectOption(index);
    }

    public ElementsCollection getAllElements (By by){
        return $$(by);
    }

    public ElementsCollection getAllElements (String selector){
        return $$(By.xpath(selector));
    }

    public int getAllElementsCount (By by){
        return $$(by).size();
    }

    public String getFieldValue (By by){
        $(by).should(Condition.appear);
        String value;
        String retrievedValue = $(by).getAttribute("value");
        if (retrievedValue!=null){
            value=retrievedValue;
        }
        else {
            value="";
        }
        return value;
    }

    public String getFieldValue (String selector, int index){
        return getFieldValue(By.xpath(String.format(selector, index)));
    }

    public String getActiveOptionText (String selectId){
        String xpath = String.format("//select[@id='%s']/option[@selected='selected']", selectId);
        return getAText(By.xpath(xpath));
    }

    public void dragNdrop (By source, By target){
        actions().dragAndDrop($(source), $(target)).build().perform();
    }

    public void dragNdropWShifting (By source, By target){
        Point sourcePoint = $(source).getLocation();
        System.out.println("sourceX: "+sourcePoint.getX());
        System.out.println("sourceY: "+sourcePoint.getY());
        Point targetPoint = $(target).getLocation();
        int targetX = targetPoint.getX();
        int targetY = targetPoint.getY();
        System.out.println("targetX: "+targetX);
        System.out.println("targetY: "+targetY);
        int shiftX = 0;
        int shiftY = 0;
        int newX = targetX+shiftX;
        int newY = targetY+shiftY;
        System.out.println("dnd");
        actions().dragAndDropBy($(source), newX, newY).build().perform();
    }


    public void check (By checkbox) throws InterruptedException {
        SelenideElement cb = $(checkbox);
        if(!cb.is(Condition.checked)) {
            System.out.println("Checkbox is not checked, checking");
            click(cb);
        }
        else {
            System.out.println("Checkbox is already checked, skipping");
        }
    }

    public void check (String selector) throws InterruptedException {
        check(By.xpath(selector));
    }


    public void uncheck (By checkbox){
        SelenideElement cb = $(checkbox);
        waitFor(cb);
        if (cb.is(Condition.checked)){
            System.out.println("Checkbox is not checked, unchecking");
            click(checkbox);
        }
        else {
            System.out.println("Checkbox is already unchecked, skipping");
        }
    }

    public void uncheck (String selector){
        uncheck(By.xpath(selector));
    }

    public String getAttribute (By element, String attribute){
        return $(element).getAttribute(attribute);
    }

    public String getCurrentUrl (){
        return WebDriverRunner.url();
    }
}