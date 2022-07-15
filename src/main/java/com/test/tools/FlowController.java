package com.test.tools;

import com.test.API.Calls;
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
    private boolean idVerification = false;
    private boolean idVerificationHurdle = true;
    private boolean CC = true;
    private String reservationType = "check_in ready";
    private boolean keepOthers = false;
    private boolean assignRoom = true;
    private boolean hasMobileKey = true;

    public void cycle (HashMap<String, Object> parameters, HashMap<String, String> reservationData, String creditCard) throws IOException, InterruptedException {
        System.out.println("==================================================");
        System.out.println("Reservation will be created with next parameters:");
//--------------------------------------------------------------------------
        if (parameters.get("idVerification")==null){
            idVerification = false;
        }
        else {
            String  tempVer = parameters.get("idVerification").toString();
            idVerification = Boolean.parseBoolean(tempVer);
        }
        System.out.println("idVerifiacation: "+idVerification);
//--------------------------------------------------------------------------
        if (parameters.get("hurdle")==null){
            idVerificationHurdle = true;
        }
        else {
            String tempHur = parameters.get("idVerification").toString();
            idVerificationHurdle = Boolean.parseBoolean(tempHur);
        }
        System.out.println("idVerificationHurdle "+idVerificationHurdle);
//--------------------------------------------------------------------------
        if (parameters.get("CC")==null){
            CC = true;
        }
        else {
            String tempCC = parameters.get("CC").toString();
            idVerificationHurdle = Boolean.parseBoolean(tempCC);
        }
        System.out.println("CC on file "+CC);
//--------------------------------------------------------------------------
        if (parameters.get("reservation_type")==null){
            reservationType = "check_in ready";
        }
        else {
            String tempRes = parameters.get("reservation_type").toString();
            reservationType = tempRes;
        }
        System.out.println("Reservation type "+reservationType);
//--------------------------------------------------------------------------
        if (parameters.get("keep_others")==null){
            keepOthers = false;
        }
        else {
            String tempKO = parameters.get("keep_others").toString();
            idVerificationHurdle = Boolean.parseBoolean(tempKO);
        }
        System.out.println("keep_others on file "+keepOthers);
//--------------------------------------------------------------------------
        if (parameters.get("assign_room")==null){
            assignRoom = true;
        }
        else {
            String tempAR = parameters.get("assign_room").toString();
            assignRoom = Boolean.parseBoolean(tempAR);
        }
        System.out.println("assign_room "+assignRoom);
//--------------------------------------------------------------------------
        if (parameters.get("has_key")==null){
            hasMobileKey = true;
        }
        else {
            String tempHK = parameters.get("has_key").toString();
            hasMobileKey = Boolean.parseBoolean(tempHK);
        }
        System.out.println("has_key "+hasMobileKey);
//--------------------------------------------------------------------------
        System.out.println("---------------------------------------------------");
        System.out.println("Confirm parameters and proceed: 1");
        System.out.println("Change parameters: 2");
        System.out.println("Exit: =");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice=br.readLine();
        switch (choice) {
            case "1": {
                packParameters(parameters);
                if (CC){
                    reservationData.put("CC", creditCard);
                }
                else {
                    reservationData.remove("CC");
                }
                String reservationPMSId = Pages.mockPMS().processReservation(parameters, reservationData);
                System.out.println("reservation pms id: "+reservationPMSId);
                if (!reservationPMSId.equals("not_required")){
                    patchTheIdVerification(parameters, reservationData, reservationPMSId);
                }
                cycle(parameters, reservationData,creditCard);
                break;
                }
            case "2": {
                changer(parameters, reservationData, creditCard);
                break;
            }
            case "=":{
                System.out.println("Exiting");
                break;
            }
            default:{
                cycle(parameters, reservationData, creditCard);
                break;
            }
        }
    }

    private void changer (HashMap<String, Object> parameters, HashMap<String, String> reservationData, String creditCard) throws IOException, InterruptedException {
        System.out.println("Select the option you want to switch:");
        System.out.println("1: Reservation type. Current value: "+reservationType);
        System.out.println("2: ID verification. Current value: "+idVerification);
        System.out.println("3: ID hurdle. Current value: "+idVerificationHurdle);
        System.out.println("4: CC usage. Current value: "+CC);
        System.out.println("5: Keep others. Current value: "+keepOthers);
        System.out.println("6: Assign room. Current value: "+assignRoom);
        System.out.println("+: Confirm");
        System.out.println("=: Cancel");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice=br.readLine();
        switch (choice){
            case "1":{
                switch (reservationType){
                    case "check_in ready":{
                        reservationType="future";
                        break;
                    }
                    case "future":{
                        reservationType="checked_in";
                        break;
                    }
                    case "checked_in":{
                        reservationType="check_out ready";
                        break;
                    }
                    case "check_out ready":{
                        reservationType="check_in ready";
                        break;
                    }
                }
                changer(parameters, reservationData,creditCard);
                break;
            }
            case "2":{
                idVerification=!idVerification;
                changer(parameters, reservationData, creditCard);
                break;
            }
            case "3":{
                idVerificationHurdle=!idVerificationHurdle;
                changer(parameters, reservationData, creditCard);
                break;
            }
            case "4":{
                CC=!CC;
                changer(parameters, reservationData, creditCard);
                break;
            }
            case "5":{
                keepOthers=!keepOthers;
                changer(parameters, reservationData, creditCard);
                break;
            }
            case "6":{
                assignRoom=!assignRoom;
                changer(parameters, reservationData, creditCard);
                break;
            }
            case "+":{
                packParameters(parameters);
                if (CC){
                    reservationData.put("CC", creditCard);
                }
                else {
                    reservationData.remove("CC");
                }
                String reservationPMSId = Pages.mockPMS().processReservation(parameters, reservationData);
                System.out.println("reservation pms id: "+reservationPMSId);
                if (!reservationPMSId.equals("not_required")){
                    patchTheIdVerification(parameters, reservationData, reservationPMSId);
                }
                cycle(parameters, reservationData, creditCard);
                break;
            }
            case "=":{
                break;
            }
            default:{
                changer(parameters, reservationData, creditCard);
                break;
            }
        }
    }

    private void packParameters(HashMap<String, Object> parameters){
        parameters.put("idVerification", idVerification);
        parameters.put("hurdle", idVerificationHurdle);
        parameters.put("CC", CC);
        parameters.put("reservation_type", reservationType);
        parameters.put("keep_others", keepOthers);
        parameters.put("assign_room", assignRoom);
        parameters.put("has_key", hasMobileKey);
    }

    private void patchTheIdVerification (HashMap<String, Object> parameters, HashMap<String, String> reservationData, String reservationPMSId) throws IOException {
        System.out.println("Import your reservation now! Type + when ready");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (br.readLine().equals("+")){
            LinkedHashMap<String, Object> reservation = Calls.getReservation().get(parameters.get("env").toString(),
                    parameters.get("token").toString(),
                    parameters.get("affiliate").toString(),
                    reservationPMSId);
            String reservationApiID=reservation.get("id").toString();
            String check_in_date = ((LinkedHashMap<String, Object>) reservation.get("attributes")).get("checkin_date").toString();
            LocalDateTime check_in=LocalDateTime.parse(check_in_date, DateTimeFormatter.ISO_ZONED_DATE_TIME);
            String passedTimestamp = "initial_value";
            if (Boolean.parseBoolean(parameters.get("hurdle").toString())){
                passedTimestamp=check_in.minus(25, ChronoUnit.HOURS).format(DateTimeFormatter.ISO_DATE_TIME)+"Z";
            }
            else {
                passedTimestamp=check_in.minus(6, ChronoUnit.HOURS).format(DateTimeFormatter.ISO_DATE_TIME)+"Z";
            }
            int patchRC = Calls.patchReservation().patch(parameters.get("env").toString(),
                    parameters.get("token").toString(),
                    parameters.get("affiliate").toString(),
                    reservationApiID,
                    reservationData.get("interview"),
                    passedTimestamp);
            if (patchRC==200){
                System.out.println("Reservation was patched successfully");
            }
            else {
                System.out.println("Something went wrong: "+patchRC);
            }
        }
        else {
            patchTheIdVerification(parameters, reservationData, reservationPMSId);
        }


    }

}
