package com.test.tools;

import com.test.API.Calls;
import com.test.objects.APIData;
import com.test.objects.Parameters;
import com.test.objects.Reservation;
import com.test.pages.Pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class FlowController {

    public void cycle (String creditCard) throws IOException, InterruptedException {
        System.out.println("==================================================");
        System.out.println("Reservation will be created with following parameters:");
        System.out.println("1: Reservation type. Current value: "+Parameters.reservationType);
        System.out.println("2: ID verification. Current value: "+Parameters.idVerification);
        System.out.println("3: ID hurdle. Current value: "+Parameters.idHurdle);
        System.out.println("4: CC usage. Current value: "+Parameters.CConFile);
        System.out.println("5: Keep others. Current value: "+Parameters.keepOthers);
        System.out.println("6: Assign room. Current value: "+Parameters.assignRoom);
        System.out.println("7: Should have mobile key. Current value: "+Parameters.hasMobileKey);
        System.out.println("---------------------------------------------------");
        System.out.println("Confirm parameters and proceed: 1");
        System.out.println("Change parameters: 2");
        System.out.println("Exit: =");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice=br.readLine();
        switch (choice) {
            case "1": {
                if (Parameters.CConFile){
                    Reservation.creditCard=creditCard;
                }
                else {
                    Reservation.creditCard=null;
                }
                String reservationPMSId = Pages.mockPMS().processReservation();
                System.out.println("reservation pms id: "+reservationPMSId);
                if (!reservationPMSId.equals("not_required")){
                    patchTheIdVerification(reservationPMSId);
                }
                cycle(creditCard);
                break;
                }
            case "2": {
                changer(creditCard);
                break;
            }
            case "=":{
                System.out.print("Exiting");
                for (int i=0; i<5; i++){
                    System.out.print(".");
                    Thread.sleep(1000);
                }
                break;
            }
            default:{
                cycle(creditCard);
                break;
            }
        }
    }

    private void changer (String creditCard) throws IOException, InterruptedException {
        System.out.println("Select the option you want to switch:");
        System.out.println("1: Reservation type. Current value: "+Parameters.reservationType);
        System.out.println("2: ID verification. Current value: "+Parameters.idVerification);
        System.out.println("3: ID hurdle. Current value: "+Parameters.idHurdle);
        System.out.println("4: CC usage. Current value: "+Parameters.CConFile);
        System.out.println("5: Keep others. Current value: "+Parameters.keepOthers);
        System.out.println("6: Assign room. Current value: "+Parameters.assignRoom);
        System.out.println("7: Should have mobile key. Current value: "+Parameters.hasMobileKey);
        System.out.println("+: Confirm");
        System.out.println("=: Cancel");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice=br.readLine();
        switch (choice){
            case "1":{
                switch (Parameters.reservationType){
                    case "check_in ready":{
                        Parameters.reservationType="future";
                        break;
                    }
                    case "future":{
                        Parameters.reservationType="checked_in";
                        break;
                    }
                    case "checked_in":{
                        Parameters.reservationType="check_out ready";
                        break;
                    }
                    case "check_out ready":{
                        Parameters.reservationType="check_in ready";
                        break;
                    }
                }
                changer(creditCard);
                break;
            }
            case "2":{
                Parameters.idVerification=!Parameters.idVerification;
                changer(creditCard);
                break;
            }
            case "3":{
                Parameters.idHurdle=!Parameters.idHurdle;
                changer(creditCard);
                break;
            }
            case "4":{
                Parameters.CConFile=!Parameters.CConFile;
                changer(creditCard);
                break;
            }
            case "5":{
                Parameters.keepOthers=!Parameters.keepOthers;
                changer(creditCard);
                break;
            }
            case "6":{
                Parameters.assignRoom=!Parameters.assignRoom;
                changer(creditCard);
                break;
            }
            case "7":{
                Parameters.hasMobileKey=!Parameters.hasMobileKey;
                changer(creditCard);
                break;
            }
            case "+":{
                if (Parameters.CConFile){
                    Reservation.creditCard=creditCard;
                }
                else {
                    Reservation.creditCard=null;
                }
                String reservationPMSId = Pages.mockPMS().processReservation();
                System.out.println("reservation pms id: "+reservationPMSId);
                if (!reservationPMSId.equals("not_required")){
                    patchTheIdVerification(reservationPMSId);
                }
                cycle(creditCard);
                break;
            }
            case "=":{
                break;
            }
            default:{
                changer(creditCard);
                break;
            }
        }
    }

    private void patchTheIdVerification (String reservationPMSId) throws IOException {
        System.out.println("Import your reservation now! Type + when ready");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (br.readLine().equals("+")){
            LinkedHashMap<String, Object> reservation = Calls.getReservation().get(APIData.env,
                    APIData.token,
                    APIData.affiliateID,
                    reservationPMSId);
            String reservationApiID=reservation.get("id").toString();
            String check_in_date = ((LinkedHashMap<String, Object>) reservation.get("attributes")).get("checkin_date").toString();
            LocalDateTime check_in=LocalDateTime.parse(check_in_date, DateTimeFormatter.ISO_ZONED_DATE_TIME);
            String passedTimestamp;
            if (Parameters.idHurdle){
                System.out.println("Hurdle is required, creating reservation 25 hrs in the past");
                passedTimestamp=check_in.minus(25, ChronoUnit.HOURS).format(DateTimeFormatter.ISO_DATE_TIME)+"Z";
            }
            else {
                System.out.println("Hurdle is not required, creating reservation 6 hrs in the past");
                passedTimestamp=check_in.minus(6, ChronoUnit.HOURS).format(DateTimeFormatter.ISO_DATE_TIME)+"Z";
            }
            int patchRC = Calls.patchReservation().patch(APIData.env,
                    APIData.token,
                    APIData.affiliateID,
                    reservationApiID,
                    Reservation.interview,
                    passedTimestamp);
            if (patchRC==200){
                System.out.println("Reservation was patched successfully");
            }
            else {
                System.out.println("Something went wrong: "+patchRC);
            }
        }
        else {
            patchTheIdVerification(reservationPMSId);
        }
    }

}
