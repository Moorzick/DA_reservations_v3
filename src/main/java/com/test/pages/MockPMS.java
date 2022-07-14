package com.test.pages;

import com.test.base.BasePage;
import com.test.base.BaseTest;
import com.test.tools.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MockPMS extends BasePage {

    private By reservationItem = By.xpath("//tr[@ng-click='select(res)']");
    private By buttonAddNew = By.xpath("//button[@ng-click='addNew()']");

    private By fieldResName =By.xpath("//input[@ng-model='newRes.FullName']");
    private By fieldResEmail=By.xpath("//input[@ng-model='newRes.GuestEmail']");
    private By fieldPhone = By.xpath("//input[@ng-model='newRes.Phone']");
    private By fieldCC = By.xpath("//input[@ng-model='newRes.CreditCard']");

    private By buttonArrivalMonth = By.xpath("//label[text()='Arrival']/following-sibling::div//button[contains(@id, 'datepicker')]");
    private String selectorArrivalMonthButton = "//label[text()='Arrival']/following-sibling::div//span[text()='%s']/parent::button";
    private String selectorArrivalDayButton = "//label[text()='Arrival']/following-sibling::div//span[@class!='ng-binding text-muted' and text()='%s']";

    private By buttonDepMonth = By.xpath("//label[text()='Departure']/following-sibling::div//button[contains(@id, 'datepicker')]");
    private String selectorDepMonthButton = "//label[text()='Departure']/following-sibling::div//span[text()='%s']/parent::button";
    private String selectorDepDayButton = "//label[text()='Departure']/following-sibling::div//span[@class!='ng-binding text-muted' and text()='%s']";

    private By buttonSaveRes = Tools.byFromPropertyAndValue("button", "ng-click", "save()");

    private String selectorResByEmail = "//tr/td[3][text()='%s']";

    private By valueReservationID = By.xpath("//dt[text()='Reservation ID:']/following-sibling::dd");
    private By buttonAssignRoom = By.xpath("//button[@ng-click='openRoomAssign(selected)']");
    private By buttonCheckIn = By.xpath("//button[@ng-click='checkin(selected)']");
    private By buttonCheckOut = By.xpath("//button[@ng-click='checkout(selected)']");

    private By fieldRoomNumber = By.xpath("//input[@ng-model='selected.RoomNumber']");
    private By buttonSaveRoom = By.xpath("//button[@ng-click='assignRoom(selected)']");
    private By bannerFailedAssign = By.xpath("//div[@class='flash ng-binding flash-error']");
    private By bannerSuccessAssign = By.xpath("//div[@class='flash ng-binding flash-info']");

    private By valueRoomNumber = By.xpath("//tr[@contextmenu-item='res']/td[1]");

    private By menuItemCancel = By.xpath("//a[@ng-click='cancel(meta.contextmenu.item)']");
    private By menuItemCheckout = By.xpath("//a[@ng-click='checkout(meta.contextmenu.item)']");



    private List<WebElement> searchForTargetReservations (String email){
        return getAllElements(String.format(selectorResByEmail,email));
    }

    private boolean hasReservationsBooked (String email){
        waitVisibility(buttonAddNew);
        boolean hasBooked = true;
        if (searchForTargetReservations(email).size()==0){
            hasBooked=false;
        }
        return hasBooked;
    }

    private void refresh (){
        BaseTest.driver.navigate().refresh();
        waitVisibility(By.xpath("//table[@contextmenu-container='meta.contextmenu']/tbody"));
        waitVisibility(buttonAddNew);
        System.out.println("Refresh wait completed");
    }

    private String getYear (LocalDate date){
        return String.valueOf(date.getYear());
    }

    private String getMonth (LocalDate date){
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    private String getDay (LocalDate date){
        int day = date.getDayOfMonth();
        String stringDay = String.valueOf(day);
        if (day<10){
            stringDay = "0"+stringDay;
        }
        return stringDay;
    }

    private HashMap<String, String> putStayDates(LocalDate arrDate, LocalDate depDate, HashMap<String, String> resData){
        resData.put("arrDay", getDay(arrDate));
        resData.put("arrMonth", getMonth(arrDate));
        resData.put("arrYear", getYear(arrDate));
        resData.put("depDay", getDay(depDate));
        resData.put("depMonth", getMonth(depDate));
        resData.put("depYear", getYear(depDate));
        return resData;
    }


    private void createReservation (HashMap <String, String> data) throws InterruptedException {
        System.out.println("[createReservation]");
        int initialResAmount = getAllElementsCount(reservationItem);
        click(buttonAddNew);
        writeText(fieldResName, data.get("name"));
        writeText(fieldResEmail, data.get("resEmail"));
        click(buttonArrivalMonth);
        click(String.format(selectorArrivalMonthButton, data.get("arrMonth")));
        click(String.format(selectorArrivalDayButton, data.get("arrDay")));
        click(buttonDepMonth);
        click(String.format(selectorDepMonthButton, data.get("depMonth")));
        click(String.format(selectorDepDayButton, data.get("depDay")));

        String phone = data.get("phone");
        if (phone!=null){
            writeText(fieldPhone, phone);
        }

        String CC = data.get("CC");
        if (CC!=null){
            writeText(fieldCC, CC);
        }
        click(buttonSaveRes);
        successChecker();
        System.out.println("[/createReservation]");
    }

    private void checkIn (String reservationID) throws InterruptedException {
        System.out.println("[checkIn]");
        selectReservationByResID(reservationID);
        Thread.sleep(500);
        if(verifyElementExist(buttonCheckIn)){
            System.out.println("Check In button exists");
            click(buttonCheckIn);
            successChecker();
        }
        else {
            System.out.println("Check in button does not exist");
        }
    }

    //private void assignRoom (int room)

    private ArrayList<String> checkInReady (HashMap<String, String> resData) throws InterruptedException {
        System.out.println("[checkInReady(noCC)]");
        LocalDate arrival = LocalDate.now();
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure, resData);
        ArrayList<String> previousResIDs = getReservationIDs(resData.get("resEmail"));
        resData.remove("CC");
        createReservation(resData);
        ArrayList<String> newResIds = getNewlyCreatedReservationIDs(resData.get("resEmail"), previousResIDs);
        System.out.println("Created new reservations:\n"+newResIds);
        System.out.println("[/checkInReady(noCC)]");
        return newResIds;
    }

    private ArrayList<String> checkInReady (HashMap<String, String> resData, String CC) throws InterruptedException {
        System.out.println("[checkInReady(wCC)]");
        LocalDate arrival = LocalDate.now();
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure, resData);
        ArrayList<String> previousResIDs = getReservationIDs(resData.get("resEmail"));
        createReservation(resData);
        ArrayList<String> newResIds = getNewlyCreatedReservationIDs(resData.get("resEmail"), previousResIDs);
        System.out.println("Created new reservations:\n"+newResIds);
        System.out.println("[/checkInReady(wCC)]");
        return newResIds;
    }

    private ArrayList<String> upcoming (HashMap<String, String> resData) throws InterruptedException {
        System.out.println("[upcoming(noCC)]");
        LocalDate arrival = LocalDate.now().plusDays(1);
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure, resData);
        ArrayList<String> previousResIDs = getReservationIDs(resData.get("resEmail"));
        createReservation(resData);
        ArrayList<String> newResIds = getNewlyCreatedReservationIDs(resData.get("resEmail"), previousResIDs);
        System.out.println("Created new reservations:\n"+newResIds);
        System.out.println("[/upcoming(wCC)]");
        return newResIds;
    }

    private ArrayList<String> upcoming (HashMap<String, String> resData, String CC) throws InterruptedException {
        System.out.println("[upcoming(wCC)]");
        LocalDate arrival = LocalDate.now().plusDays(1);
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure, resData);
        ArrayList<String> previousResIDs = getReservationIDs(resData.get("resEmail"));
        resData.put("CC", CC);
        createReservation(resData);
        ArrayList<String> newResIds = getNewlyCreatedReservationIDs(resData.get("resEmail"), previousResIDs);
        System.out.println("Created new reservations:\n"+newResIds);
        System.out.println("[/upcoming(wCC)]");
        return newResIds;
    }

    private ArrayList<String> checkedIn (HashMap<String, String> resData, HashMap<String, Object> params) throws InterruptedException {
        System.out.println("[checkedIn(noCC)]");
        LocalDate arrival = LocalDate.now().plusDays(1);
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure, resData);
        ArrayList<String> previousResIDs = getReservationIDs(resData.get("resEmail"));
        createReservation(resData);
        ArrayList<String> newResIds = getNewlyCreatedReservationIDs(resData.get("resEmail"), previousResIDs);
        System.out.println("Created new reservations:\n"+newResIds);
        assignRoomInitiator(resData, params, newResIds.get(0));
        checkIn(newResIds.get(0));
        System.out.println("[/checkedIn(wCC)]");
        return newResIds;
    }

    private ArrayList<String> checkedIn (HashMap<String, String> resData, HashMap<String, Object> params, String CC) throws InterruptedException {
        System.out.println("[checkedIn(wCC)]");
        LocalDate arrival = LocalDate.now().plusDays(1);
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure, resData);
        ArrayList<String> previousResIDs = getReservationIDs(resData.get("resEmail"));
        resData.put("CC", CC);
        createReservation(resData);
        ArrayList<String> newResIds = getNewlyCreatedReservationIDs(resData.get("resEmail"), previousResIDs);
        System.out.println("Created new reservations:\n"+newResIds);
        assignRoomInitiator(resData, params, newResIds.get(0));
        checkIn(newResIds.get(0));
        System.out.println("[/checkedIn(wCC)]");
        return newResIds;
    }

    private ArrayList<String> checkOutReady (HashMap<String, String> resData, HashMap<String, Object> params) throws InterruptedException {
        System.out.println("[checkedIn(noCC)]");
        LocalDate arrival = LocalDate.now().plusDays(1);
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure, resData);
        ArrayList<String> previousResIDs = getReservationIDs(resData.get("resEmail"));
        createReservation(resData);
        ArrayList<String> newResIds = getNewlyCreatedReservationIDs(resData.get("resEmail"), previousResIDs);
        System.out.println("Created new reservations:\n"+newResIds);
        assignRoomInitiator(resData, params, newResIds.get(0));
        checkIn(newResIds.get(0));
        System.out.println("[/checkedIn(wCC)]");
        return newResIds;
    }

    private ArrayList<String> checkOutReady (HashMap<String, String> resData, HashMap<String, Object> params, String CC) throws InterruptedException {
        System.out.println("[checkedIn(wCC)]");
        LocalDate arrival = LocalDate.now().minusDays(1);
        LocalDate departure = LocalDate.now();
        putStayDates(arrival, departure, resData);
        ArrayList<String> previousResIDs = getReservationIDs(resData.get("resEmail"));
        resData.put("CC", CC);
        createReservation(resData);
        ArrayList<String> newResIds = getNewlyCreatedReservationIDs(resData.get("resEmail"), previousResIDs);
        System.out.println("Created new reservations:\n"+newResIds);
        assignRoomInitiator(resData, params, newResIds.get(0));
        checkIn(newResIds.get(0));
        System.out.println("[/checkedIn(wCC)]");
        return newResIds;
    }

    private ArrayList<String> getReservationIDs (String email){
        System.out.println("[getReservationIDs(email)]");
        List<WebElement> reservations = getAllElements(String.format(selectorResByEmail, email));
        ArrayList<String> reservationIDs = new ArrayList<>();
        for (WebElement reservation : reservations) {
            click(reservation);
            reservationIDs.add(getAText(valueReservationID));
        }
        System.out.println("Reservation ids found:\n"+reservationIDs);
        System.out.println("[/getReservationIDs()]");
        return reservationIDs;
    }

    private ArrayList<String> getReservationIDs (List<WebElement> reservations){
        System.out.println("[getReservationIDs(webelement list)]");
        ArrayList<String> reservationIDs = new ArrayList<>();
        for (WebElement reservation : reservations) {
            click(reservation);
            reservationIDs.add(getAText(valueReservationID));
        }
        System.out.println("Reservation ids found:+\n"+reservationIDs);
        System.out.println("[/getReservationIDs()]");
        return reservationIDs;
    }

    private void selectReservationByResID (String targetReservationID){
        System.out.println("[selectReservationByResID]");
        System.out.println("targetReservationID: "+targetReservationID);
        List<WebElement> allReservations = getAllElements(reservationItem);
        for (WebElement reservation: allReservations){
            click(reservation);
            String currentResID=getAText(valueReservationID);
            System.out.println("comparing existing resID: "+currentResID);
            if (currentResID.equals(targetReservationID)){
                System.out.println("Match found, breaking");
                break;
            }
        }
        System.out.println("[/selectReservationByResID]");
    }

    private ArrayList<String> getNewlyCreatedReservationIDs (String email, ArrayList<String> previousListOfResIDs){
        System.out.println("[getNewlyCreatedReservationIDs]");
        ArrayList<String> currentResIDs = getReservationIDs(email);
        System.out.println("Current list of resIDs:\n"+currentResIDs);
        System.out.println("Removing previous list of resIDs");
        currentResIDs.removeAll(previousListOfResIDs);
        System.out.println("List of ids to return:\n"+currentResIDs);
        System.out.println("[/getNewlyCreatedReservationIDs]");
        return currentResIDs;
    }

    private void purge (String email) throws InterruptedException {
        System.out.println("Purge --->");
        refresh();
        Thread.sleep(2000);
        System.out.println("Searching for email: "+email);
        List<WebElement> targetReservations = searchForTargetReservations(email);
        System.out.println("Reservations found: "+targetReservations.size());
        if (targetReservations.size()!=0){
            for (WebElement targetReservation : targetReservations) {
                rightClick(targetReservation);

                if (verifyElementExist(menuItemCancel)) {
                    Thread.sleep(500);
                    System.out.println("Cancel menu exists, clicking");
                    click(menuItemCancel);
                    successChecker();
                } else {
                    System.out.println("Cancel doesn't exist");
                    if (verifyElementExist(menuItemCheckout)) {
                        Thread.sleep(500);
                        System.out.println("Checkout exists");
                        click(menuItemCheckout);
                        successChecker();
                    }
                }
            }
        }
        System.out.println(">--Purge");
    }

    private ArrayList<String> getVacantRooms (HashMap<String, Object> parameters){
        System.out.println("[getVacantRooms]");
        ArrayList<HashMap<String, String>> rooms = (ArrayList<HashMap<String, String>>)parameters.get("rooms");
        System.out.println("Got rooms from parameters:\n"+rooms);
        boolean hasKey = Boolean.parseBoolean(parameters.get("has_key").toString());
        System.out.println("has_key: "+hasKey);
        List<WebElement> roomNumbersElements = getAllElements(valueRoomNumber);
        ArrayList<String> roomNumbersOccupied = new ArrayList<>();
        System.out.println("Getting occupied room numbers...");
        for (int i=0; i<roomNumbersElements.size(); i++){
            String number = roomNumbersElements.get(i).getText();
            System.out.println("Found number: \""+number+"\"");
            if (!number.equals("")){
                System.out.println("Number not empty, adding to the list");
                roomNumbersOccupied.add(number);
            }
        }
        System.out.println("Getting all existing rooms that match the criteria...");
        for (int i=0; i<rooms.size(); i++){
            HashMap<String, String> room = rooms.get(i);
            System.out.println("Processing: "+room);
            if (room.get("lock").equals("null")&&hasKey){
                System.out.println("Removing because of null lock_type");
                rooms.remove(i);
            }
            if (!room.get("lock").equals("null")&&!hasKey){
                System.out.println("Removing because of non-null lock_type");
                rooms.remove(i);
            }
        }
        System.out.println("Removing occupied rooms from the existing list");
        System.out.println("Occupied rooms: "+roomNumbersOccupied);
        rooms.removeAll(roomNumbersOccupied);
        System.out.println("Available rooms list:\n"+rooms);
        ArrayList<String> vacantRooms = new ArrayList<>();
        for (int i=0; i<rooms.size(); i++){
            vacantRooms.add(rooms.get(i).get("number"));
        }
        System.out.println("Returning: "+vacantRooms);
        System.out.println("[/getVacantRooms]");
        return vacantRooms;
    }

    private void assignRoomHandler (HashMap<String, Object> parameters, String resId) throws InterruptedException {
        System.out.println("[assignRoomHandler]");
        selectReservationByResID(resId);
        assignRoom(getVacantRooms(parameters));
        System.out.println("[/assignRoomHandler]");
    }

    private void assignRoomHandler (String room, String resId, HashMap<String, Object> parameters) throws InterruptedException {
        System.out.println("[assignRoomHandler]");
        selectReservationByResID(resId);
        assignRoom(room, getVacantRooms(parameters));
        System.out.println("[/assignRoomHandler]");
    }

    private void assignRoom (ArrayList<String> vacantRoomNumbers) throws InterruptedException {
        System.out.println("[assignRoom]");
        Thread.sleep(2000);
        click(buttonAssignRoom);
        for (String roomNumber: vacantRoomNumbers){
            System.out.println("Trying to assign: "+roomNumber);
            writeText(fieldRoomNumber, roomNumber);
            click(buttonSaveRoom);
            if (successChecker()){
                break;
            }
        }
        System.out.println("[/assignRoom]");
    }

    private void assignRoom (String roomNumber, ArrayList<String> vacantRoomNumbers) throws InterruptedException {
        System.out.println("[assignRoom]");
        Thread.sleep(2000);
        click(buttonAssignRoom);
        writeText(fieldRoomNumber, roomNumber);
        click(buttonSaveRoom);
        if (!successChecker()){
            assignRoom(vacantRoomNumbers);
        }
        System.out.println("[/assignRoom]");
    }

    private boolean successChecker() throws InterruptedException {
        System.out.println("[successChecker]");
        boolean success=false;
        if (verifyElementExist(bannerSuccessAssign)){
            System.out.println("Success!");
            success=true;
            waitForElementToDisappear(bannerSuccessAssign);
        }
        else {
            if (verifyElementExist(bannerFailedAssign)){
                System.out.println("Failed");
                waitForElementToDisappear(bannerFailedAssign);
            }
            else {
                Thread.sleep(500);
                success= successChecker();
            }
        }
        System.out.println("[/successChecker]");
        return success;
    }

    private void assignRoomInitiator (HashMap<String, String> reservationData, HashMap<String, Object> parameters, String resId) throws InterruptedException {
        String room = reservationData.get("room");
        System.out.println("Having room from reservation data: "+room);
        if (room==null){
            System.out.println("Room is null, so assigning something else");
            assignRoomHandler(parameters, resId);
        }
        else {
            System.out.println("Room is not null, trying to assign");
            assignRoomHandler(room, resId, parameters);
        }
    }




    public String processReservation (HashMap<String, Object> parameters, HashMap<String, String>reservationData) throws InterruptedException {
        boolean ccOnFile = Boolean.parseBoolean(parameters.get("CC").toString());
        boolean keepOthers = Boolean.parseBoolean(parameters.get("keep_others").toString());
        boolean assignRoom = Boolean.parseBoolean(parameters.get("assign_room").toString());
        boolean idVerification = Boolean.parseBoolean(parameters.get("idVerification").toString());
        boolean hurdle = Boolean.parseBoolean(parameters.get("hurdle").toString());

        String reservationID = "not_required";

        if (!keepOthers){
            purge(reservationData.get("resEmail"));
        }

        switch (parameters.get("reservation_type").toString()) {
            case "check_in ready":{
                String resId = "none";
                if (ccOnFile){
                    resId = checkInReady(reservationData, reservationData.get("CC")).get(0);
                }
                else {
                    resId = checkInReady(reservationData).get(0);
                }
                if (assignRoom){
                    assignRoomInitiator(reservationData, parameters, resId);
                }
                if (idVerification){
                    reservationID=resId;
                }
                break;
            }
            case "future":{
                String resId = "none";
                if (ccOnFile){
                    resId = upcoming(reservationData, reservationData.get("CC")).get(0);
                }
                else {
                    resId = upcoming(reservationData).get(0);
                }
                if (assignRoom){
                    assignRoomInitiator(reservationData, parameters, resId);
                }
                if (idVerification){
                    reservationID=resId;
                }
                break;
            }
            case "checked_in":{
                String resId = "none";
                if (ccOnFile){
                    resId = checkedIn(reservationData, parameters, reservationData.get("CC")).get(0);
                }
                else {
                    resId = checkedIn(reservationData, parameters).get(0);
                }
                break;
            }
            case "check_out ready":{
                String resId = "none";
                if (ccOnFile){
                    resId = checkOutReady(reservationData, parameters, reservationData.get("CC")).get(0);
                }
                else {
                    resId = checkOutReady(reservationData, parameters).get(0);
                }
                break;
            }
        }
        return reservationID;
    }
}
