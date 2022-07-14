package com.test.API;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class AuthProd {
    private static final String clientId = "GNTXTHCSRHNJV9EZ";
    private static final String clientSecret = "2ST2SeyFYJM8DzPuX67aGNuwa61o6stepTNuA3oFFqcOO4PSMnztZSdVQYM6dedgUcYCzVbARH3Yk6jE3Hycq0Op2d4fziq359I9g4cwSbcG7P4fiYuRbCFcSHBqpQAD";
    private static final String callBackUrl = "https://www.keypr.com/oauth2/callback";
    private static final String authorizeUrl = "https://account.keyprstg.com/oauth/authorize";

    public static String redirectUri = "some_redirect_uri";
    public static String scope = "public";

    public static String getToken() {

        String body = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s&audience=public", clientId, clientSecret);

        String token =
                given()
                        .contentType(ContentType.URLENC)
                        .body(body)
                        .post("https://account.keyprprod.com/oauth/token")
                        .then()
                        .extract().response()
                        .jsonPath().getString("access_token");
        return token;
    }
}
