package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuthenticationExample {




    @Test
    public void usingApiKey(){

        RestAssured.given().log().all().
                queryParam("t","ironman").
                queryParam("apikey","f51dff94").
                when().get("http://www.omdbapi.com/").
                then().log().all().statusCode(200);

    }
}
