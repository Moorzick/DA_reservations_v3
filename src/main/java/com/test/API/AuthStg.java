package com.test.API;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class AuthStg {
    private static final String clientId = "NHTHZJ3DTANBW8JA";
    private static final String clientSecret = "0ZxtE3VABoMLoafkEgoBuZVTScLrvalN7sL1A3RiVtzFAdDAKckanhQLRoOK0lrKGwSzc2Lome8IWlFzSo7P8WC4fUR83dVlZJTY4vL4svuwHtgW8GZ7lWxplh7mC7bI";
    private static final String callBackUrl = "https://www.keypr.com/oauth2/callback";
    private static final String authorizeUrl = "https://account.keyprstg.com/oauth/authorize";

    public static String redirectUri = "some_redirect_uri";
    public static String scope = "public";

    public static String getToken() {

        String body = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s&audience=public", clientId, clientSecret);
        //System.out.println(body);

        String token =
                given()
                        .contentType(ContentType.URLENC)
                        .body(body)
                        .post("https://account.keyprstg.com/oauth/token")
                        .then()
                        .extract().response()
                        .jsonPath().getString("access_token");
        return token;
    }

}
