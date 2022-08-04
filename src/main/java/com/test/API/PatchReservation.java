package com.test.API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class PatchReservation {
    public int patch (String env, String token, String affiliateID, String reservationID, String interviewID, String passedTimestamp){
//        String body = "{\"data\":" +
//                "{\"type\":\"reservation\"," +
//                "\"id\": \""+reservationID+"\"," +
//                "\"attributes\":" +
//                "{" +
//                "\"identity_verification_passed_timestamp\":\""+passedTimestamp+"\","+
//                "\"identity_verification_data\":{"+
//                "\"interview_id\":\""+interviewID+"\"" +
//                "}" +
//                "}" +
//                "}" +
//                "}";
        JSONObject body = new JSONObject();
        JSONObject id_ver_data = new JSONObject().put("interview_id", interviewID);
        JSONObject attributes = new JSONObject().put("inentity_verification_data", id_ver_data).put("identity_verification_passed_timestamp", passedTimestamp);
        JSONObject data = new JSONObject().put("type", "reservation")
                .put("id", reservationID)
                .put("attributes", attributes);
        body.put("data", data);
        String endpoint = env+"/affiliates/"+ affiliateID+"/reservations/"+reservationID;
        System.out.print("HTTP PATCH --> "+endpoint);
        System.out.println("\tWith payload of: "+body);
        Response response = given()
                .auth().oauth2(token)
                .contentType("application/vnd.api+json")
                .body(body.toString())
                .patch(endpoint);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());

        return response.getStatusCode();
    }
}
