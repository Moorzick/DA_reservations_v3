package com.test.API;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRoomNumbers {

    public ArrayList<HashMap<String, String>> get(String env, String token, String affiliateID){
        ArrayList<Object> array = given()
                .auth()
                .oauth2(token)
                .get(env+"/affiliates/"+affiliateID+"/locations")
                .then()
                .extract().response()
                .jsonPath().getJsonObject("data");
        //System.out.println(array);
        ArrayList<HashMap<String, String>> rooms = new ArrayList<>();
        for (int i=0; i<array.size(); i++){
            HashMap<String, String> room = new HashMap<>();
            HashMap<Object, Object> location = ((HashMap<Object, Object>) array.get(i));
            HashMap<Object, Object> attributes = (HashMap<Object, Object>) location.get("attributes");
            //System.out.println(attributes);
            room.put("number", attributes.get("external_id").toString());
            Object lockType =attributes.get("lock_type");
            if (lockType!=null){
                room.put("lock", lockType.toString());
            }
            else {
                room.put("lock", "null");
            }
            rooms.add(i, room);
        }
        return rooms;
    }
}
