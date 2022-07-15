package com.test.API;
import io.restassured.response.Response;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetReservation {
    public LinkedHashMap<String, Object> get(String env, String token, String affiliateID, String reservationPMSId){
        LinkedHashMap<String, Object> reservation = new LinkedHashMap<>();
        String url = env+"/affiliates/"+affiliateID+"/reservations";
        System.out.println("HTTP GET --> "+url);
        Response response = given()
                .auth()
                .oauth2(token)
                .get(url);
        ArrayList<LinkedHashMap<String, Object>> data = response.jsonPath().getJsonObject("data");
        for (LinkedHashMap<String, Object> item: data){
            LinkedHashMap<String, Object> attributes = (LinkedHashMap<String, Object>) item.get("attributes");
            if (reservationPMSId.equals(attributes.get("external_id").toString())){
                reservation=item;
                break;
            }
        }
        return reservation;
    }
}
