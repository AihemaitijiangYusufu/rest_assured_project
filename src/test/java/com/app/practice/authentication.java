package com.app.practice;

import io.restassured.RestAssured;
import org.junit.Test;

public class authentication {

    @Test
    public void APIKeyAuthentication(){

        RestAssured.given().log().all().
                queryParam("t","ironman").
                queryParam("apikey","f51dff94").
                when().get("http://www.omdbapi.com/").
                then().log().all().statusCode(200);
    }


    @Test
    public void preemtiveAuthentication(){

        RestAssured.given().
                auth().preemptive().basic("admin","admin").
                when().get("https://the-internet.herokuapp.com/basic_auth").
                then().log().all().statusCode(200);
    }


    @Test
    public void challengedAuthentication(){

        RestAssured.given().
                auth().basic("admin","admin").
                when().get("https://the-internet.herokuapp.com/basic_auth").
                then().log().all().statusCode(200);
    }
}
