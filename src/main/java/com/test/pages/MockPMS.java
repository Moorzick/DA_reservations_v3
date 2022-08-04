package com.test.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.test.base.BasePage;
import com.test.objects.APIData;
import com.test.objects.Parameters;
import com.test.objects.Reservation;
import com.test.tools.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.refresh;

public class MockPMS extends BasePage {

    private final By reservationItem = By.xpath("//tr[@ng-click='select(res)']");
    private final By buttonAddNew = By.xpath("//button[@ng-click='addNew()']");

    private final By fieldResName =By.xpath("//input[@ng-model='newRes.FullName']");
    private final By fieldResEmail=By.xpath("//input[@ng-model='newRes.GuestEmail']");
    private final By fieldPhone = By.xpath("//input[@ng-model='newRes.Phone']");
    private final By fieldCC = By.xpath("//input[@ng-model='newRes.CreditCard']");
    private final By fieldSearch = By.xpath("//input[@ng-model='search']");

    private final By buttonArrivalMonth = By.xpath("//label[text()='Arrival']/following-sibling::div//button[contains(@id, 'datepicker')]");
    private final String selectorArrivalMonthButton = "//label[text()='Arrival']/following-sibling::div//span[text()='%s']/parent::button";
    private final String selectorArrivalDayButton = "//label[text()='Arrival']/following-sibling::div//span[@class!='ng-binding text-muted' and text()='%s']";

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

    private String currendReservationPMSid = "not_required";


    private ElementsCollection searchForTargetReservations (String email){
        return getAllElements(String.format(selectorResByEmail,email));
    }


    private void refreshPMS(){
        refresh();
        waitFor(By.xpath("//table[@contextmenu-container='meta.contextmenu']/tbody"));
        waitFor(buttonAddNew);
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

    private void putStayDates(LocalDate arrDate, LocalDate depDate){
        Reservation.arrivalDay= getDay(arrDate);
        Reservation.arrivalMonth= getMonth(arrDate);
        Reservation.arrivalYear= getYear(arrDate);
        Reservation.departureDay= getDay(depDate);
        Reservation.departureMonth= getMonth(depDate);
        Reservation.departureYear= getYear(depDate);
    }


    private void createReservation () throws InterruptedException {
        System.out.println("[createReservation]");
        int initialResAmount = getAllElementsCount(reservationItem);
        click(buttonAddNew);
        writeText(fieldResName, Reservation.name);
        writeText(fieldResEmail,  Reservation.email);
        click(buttonArrivalMonth);
        click(String.format(selectorArrivalMonthButton, Reservation.arrivalMonth));
        click(String.format(selectorArrivalDayButton, Reservation.arrivalDay));
        click(buttonDepMonth);
        click(String.format(selectorDepMonthButton, Reservation.departureMonth));
        click(String.format(selectorDepDayButton, Reservation.departureDay));


        if (Reservation.phone!=null){
            writeText(fieldPhone, Reservation.phone);
        }

        if (Reservation.creditCard!=null){
            writeText(fieldCC, Reservation.creditCard);
        }
        click(buttonSaveRes);
        if (successChecker().equals("failed")){
            //checkIfReservastionNumberChanged(initialResAmount, email);
            System.out.println("success checker failed");
        }
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

    private void checkInReady () throws InterruptedException {
        System.out.println("[checkInReady(noCC)]");
        LocalDate arrival = LocalDate.now();
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure);
        ArrayList<String> previousResIDs = getReservationIDs(Reservation.email);
        Reservation.creditCard=null;
        createReservation();
        currendReservationPMSid = getNewlyCreatedReservationIDs(Reservation.email, previousResIDs).get(0);
        System.out.println("Created new reservations:\n"+currendReservationPMSid);
        System.out.println("[/checkInReady(noCC)]");
    }

    private void checkInReadyWCC () throws InterruptedException {
        System.out.println("[checkInReady(wCC)]");
        LocalDate arrival = LocalDate.now();
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure);
        ArrayList<String> previousResIDs = getReservationIDs(Reservation.email);
        createReservation();
        currendReservationPMSid = getNewlyCreatedReservationIDs(Reservation.email, previousResIDs).get(0);
        System.out.println("Created new reservations:\n"+currendReservationPMSid);
    }

    private void upcoming() throws InterruptedException {
        System.out.println("[upcoming(noCC)]");
        LocalDate arrival = LocalDate.now().plusDays(1);
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure);
        ArrayList<String> previousResIDs = getReservationIDs(Reservation.email);
        Reservation.creditCard=null;
        createReservation();
        currendReservationPMSid = getNewlyCreatedReservationIDs(Reservation.email, previousResIDs).get(0);
        System.out.println("Created new reservations:\n"+currendReservationPMSid);
        System.out.println("[/upcoming(wCC)]");
    }

    private void upcomingWCC () throws InterruptedException {
        System.out.println("[upcoming(wCC)]");
        LocalDate arrival = LocalDate.now().plusDays(1);
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure);
        ArrayList<String> previousResIDs = getReservationIDs(Reservation.email);
        createReservation();
        currendReservationPMSid = getNewlyCreatedReservationIDs(Reservation.email, previousResIDs).get(0);
        System.out.println("Created new reservations:\n"+currendReservationPMSid);
        System.out.println("[/upcoming(wCC)]");
    }

    private void checkedIn () throws InterruptedException {
        System.out.println("[checkedIn(noCC)]");
        LocalDate arrival = LocalDate.now().plusDays(1);
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure);
        ArrayList<String> previousResIDs = getReservationIDs(Reservation.email);
        Reservation.creditCard=null;
        createReservation();
        currendReservationPMSid = getNewlyCreatedReservationIDs(Reservation.email, previousResIDs).get(0);
        System.out.println("Created new reservations:\n"+currendReservationPMSid);
        assignRoomInitiator();
        checkIn(currendReservationPMSid);
        System.out.println("[/checkedIn(wCC)]");
    }

    private void checkedInWCC () throws InterruptedException {
        System.out.println("[checkedIn(wCC)]");
        LocalDate arrival = LocalDate.now().plusDays(1);
        LocalDate departure = arrival.plusDays(1);
        putStayDates(arrival, departure);
        ArrayList<String> previousResIDs = getReservationIDs(Reservation.email);
        createReservation();
        currendReservationPMSid = getNewlyCreatedReservationIDs(Reservation.email, previousResIDs).get(0);
        System.out.println("Created new reservations:\n"+currendReservationPMSid);
        assignRoomInitiator();
        checkIn(currendReservationPMSid);
        System.out.println("[/checkedIn(wCC)]");
    }


    private void checkOutReady () throws InterruptedException {
        System.out.println("[checkOutReady]");
        LocalDate arrival = LocalDate.now().minusDays(1);
        LocalDate departure = LocalDate.now();
        putStayDates(arrival, departure);
        ArrayList<String> previousResIDs = getReservationIDs(Reservation.email);
        createReservation();
        currendReservationPMSid = getNewlyCreatedReservationIDs(Reservation.email, previousResIDs).get(0);
        System.out.println("Created new reservations:\n"+currendReservationPMSid);
        assignRoomInitiator();
        checkIn(currendReservationPMSid);
        System.out.println("[/checkOutReady]");
    }

    private ArrayList<String> getReservationIDs (String email){
        System.out.println("[getReservationIDs(email)]");
        ElementsCollection reservations = getAllElements(String.format(selectorResByEmail, email));
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
        ElementsCollection allReservations = getAllElements(reservationItem);
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

    private ArrayList<String> getNewlyCreatedReservationIDs (String email, ArrayList<String> previousListOfResIDs) throws InterruptedException {
        System.out.println("[getNewlyCreatedReservationIDs]");
        waitForOptional(reservationItem);
        ArrayList<String> currentResIDs = getReservationIDs(email);
        System.out.println("Current list of resIDs:\n"+currentResIDs);
        System.out.println("Removing previous list of resIDs");
        currentResIDs.removeAll(previousListOfResIDs);
        System.out.println("List of ids to return:\n"+currentResIDs);
        System.out.println("[/getNewlyCreatedReservationIDs]");
        return currentResIDs;
    }

    private boolean checkIfReservastionNumberChanged (int previousReservationsNum, String email) throws InterruptedException {
        int currentResNumber = searchForTargetReservations(email).size();
        int wait = 3000;
        Thread.sleep(wait);
        if (currentResNumber!=0){
            return previousReservationsNum != currentResNumber;
        }
        else {
            return true;
        }

    }

    private void purgeWrapper() throws InterruptedException {
        System.out.println("Purge --->");
        refreshPMS();
        if (waitForOptional(reservationItem)){
            System.out.println("purging");
            purge();
        }
        System.out.println(">--Purge");
    }

    private void purge() throws InterruptedException {;
        System.out.println("Searching for email: "+Reservation.email);
        ArrayList<String> resIds = getReservationIDs(Reservation.email);
        for (String reservationID: resIds){
            ElementsCollection allReservations = getAllElements(reservationItem);
            System.out.println("Current amount of all reservations: "+allReservations.size());
            for (SelenideElement reservation: allReservations){
                click(reservation);
                String currentResID=getAText(valueReservationID);
                System.out.println("comparing existing resID: "+currentResID);
                if (currentResID.equals(reservationID)){
                    System.out.println("Match found, breaking");
                    rightClick(reservation);
                    if (verifyElementExist(menuItemCancel)) {
                        Thread.sleep(500);
                        System.out.println("Cancel menu exists, clicking");
                        click(menuItemCancel);
                        waitForElementToDisappear(reservation);
                    } else {
                        System.out.println("Cancel doesn't exist");
                        if (verifyElementExist(menuItemCheckout)) {
                            Thread.sleep(500);
                            System.out.println("Checkout exists");
                            click(menuItemCheckout);
                            waitForElementToDisappear(reservation);
                        }
                    }
                    break;
                }
            }
        }
    }

    private ArrayList<String> getVacantRooms (){
        System.out.println("[getVacantRooms]");
        System.out.println("Got rooms from parameters:\n"+APIData.rooms);
        System.out.println("has_key: "+Parameters.hasMobileKey);
        ElementsCollection roomNumbersElements = getAllElements(valueRoomNumber);
        ArrayList<String> roomNumbersOccupied = new ArrayList<>();
        System.out.println("Getting occupied room numbers...");
        for (SelenideElement roomNumbersElement : roomNumbersElements) {
            String number = roomNumbersElement.getText();
            System.out.println("Found number: \"" + number + "\"");
            if (!number.equals("")) {
                System.out.println("Number not empty, adding to the list");
                roomNumbersOccupied.add(number);
            }
        }
        System.out.println("Getting all existing rooms that match the criteria...");
        for (int i=0; i<APIData.rooms.size(); i++){
            HashMap<String, String> room = APIData.rooms.get(i);
            System.out.println("Processing: "+room);
            if (room.get("lock").equals("null")&&Parameters.hasMobileKey){
                System.out.println("Removing because of null lock_type");
                APIData.rooms.remove(i);
            }
            if (!room.get("lock").equals("null")&&!Parameters.hasMobileKey){
                System.out.println("Removing because of non-null lock_type");
                APIData.rooms.remove(i);
            }
        }
        System.out.println("Removing occupied rooms from the existing list");
        System.out.println("Occupied rooms: "+roomNumbersOccupied);
        ArrayList<String> vacantRooms = new ArrayList<>();
        for (HashMap<String, String> room : APIData.rooms) {
            vacantRooms.add(room.get("number"));
        }
        System.out.println("Available rooms list:\n"+vacantRooms);
        vacantRooms.removeAll(roomNumbersOccupied);
        System.out.println("Returning: "+vacantRooms);
        System.out.println("[/getVacantRooms]");
        return vacantRooms;
    }

    private void assignRoomHandler () throws InterruptedException {
        System.out.println("[assignRoomHandler]");
        selectReservationByResID(currendReservationPMSid);
        assignRoom(getVacantRooms());
        System.out.println("[/assignRoomHandler]");
    }

    private void assignRoomHandler (String room) throws InterruptedException {
        System.out.println("[assignRoomHandler]");
        selectReservationByResID(currendReservationPMSid);
        ArrayList<String> vacantRooms = getVacantRooms();
        if (vacantRooms.contains(room)){
            assignRoom(room, vacantRooms);
        }
        else {
            assignRoom(vacantRooms);
        }
        System.out.println("[/assignRoomHandler]");
    }

    private void assignRoom (ArrayList<String> vacantRoomNumbers) throws InterruptedException {
        System.out.println("[assignRoom]");
        //Thread.sleep(2000);
        click(buttonAssignRoom);
        for (String roomNumber: vacantRoomNumbers){
            System.out.println("Trying to assign: "+roomNumber);
            writeText(fieldRoomNumber, roomNumber);
            click(buttonSaveRoom);
            String result = successChecker();
            if (result.equals("true")){
                break;
            }
        }
        System.out.println("[/assignRoom]");
    }

    private void assignRoom (String roomNumber, ArrayList<String> vacantRoomNumbers) throws InterruptedException {
        System.out.println("[assignRoom]");
        //Thread.sleep(2000);
        click(buttonAssignRoom);
        writeText(fieldRoomNumber, roomNumber);
        click(buttonSaveRoom);
        if (!successChecker().equals("true")){
            for (String room : vacantRoomNumbers){
                System.out.println("Trying to assign: "+ room);
                writeText(fieldRoomNumber, room);
                click(buttonSaveRoom);
                if (successChecker().equals("true")){
                    break;
                }
            }
        }
        System.out.println("[/assignRoom]");
    }

    private String successChecker() throws InterruptedException {
        System.out.println("[successChecker]");
        String success="false";
        if (verifyElementExist(bannerSuccessAssign)){
            System.out.println("Success!");
            success="true";
            waitForElementToDisappear(bannerSuccessAssign);
        }
        else {
            if (verifyElementExist(bannerFailedAssign)){
                System.out.println("Failed");
                waitForElementToDisappear(bannerFailedAssign);
            }
            else {
                Thread.sleep(500);
                success= successChecker(0);
            }
        }
        System.out.println("[/successChecker]");
        return success;
    }

    private String successChecker(int tries) throws InterruptedException {
        System.out.println("[successChecker with tries]");
        int maxTries = 10;
        String success="false";
        if (verifyElementExist(bannerSuccessAssign)){
            System.out.println("Success!");
            success="true";
            waitForElementToDisappear(bannerSuccessAssign);
        }
        else {
            if (verifyElementExist(bannerFailedAssign)){
                System.out.println("Failed");
                waitForElementToDisappear(bannerFailedAssign);
            }
            else {
                Thread.sleep(500);
                if (tries<maxTries){
                    tries++;
                    success= successChecker(tries);
                }
                else {
                    success="failed";
                }
            }
        }
        System.out.println("[/successChecker]");
        return success;
    }

    private void assignRoomInitiator () throws InterruptedException {
        System.out.println("Having room from reservation data: "+Reservation.room);
        if (Reservation.room==null){
            System.out.println("Room is null, so assigning something else");
            assignRoomHandler();
        }
        else {
            System.out.println("Room is not null, trying to assign");
            assignRoomHandler(Reservation.room);
        }
    }

    public String processReservation () throws InterruptedException {
        String reservationID = "not_required";

        if (!Parameters.keepOthers){
            purgeWrapper();
        }

        switch (Parameters.reservationType) {
            case "check_in ready":{
                String resId = "none";
                if (Parameters.CConFile){
                    checkInReadyWCC();
                }
                else {
                    checkInReady();
                }
                if (Parameters.assignRoom){
                    assignRoomInitiator();
                }
                System.out.println("idVerification: "+Parameters.idVerification);
                if (Parameters.idVerification){
                    reservationID=currendReservationPMSid;
                }
                break;
            }
            case "future":{
                if (Parameters.CConFile){
                    upcomingWCC();
                }
                else {
                    upcoming();
                }
                if (Parameters.assignRoom){
                    assignRoomInitiator();
                }
                if (Parameters.idVerification){
                    reservationID=currendReservationPMSid;
                }
                break;
            }
            case "checked_in":{
                if (Parameters.CConFile){
                    checkedInWCC();
                }
                else {
                    checkedIn();
                }
                break;
            }
            case "check_out ready":{
                checkOutReady();
                break;
            }
        }
        return reservationID;
    }
}
