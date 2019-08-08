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


    @Test
    public void basincAuthentication401Validation(){
        // https://the-internet.herokuapp.com/basic_auth
      // when we try to hit and endpoint without being authorised
       // we can 401 not authorized error
        RestAssured.given().log().all().
                when().get("https://the-internet.herokuapp.com/basic_auth").
                then().log().all().statusCode(401);

    }

    @Test
    public void basicAuthentication(){

        // auth --> provides different types of authentication
       // based -->authentication using username and password

        RestAssured.given().
                auth().basic("admin","admin").
                when().get("https://the-internet.herokuapp.com/basic_auth").
                then().log().all().statusCode(200);
    }

    @Test
    public void xmlResponseExample(){

        // this is not an authorization example
        // this method is to show request which returns xml body

        RestAssured.get("http://parabank.parasoft.com/parabank/services/bank/customers/12212").
                then().log().all().statusCode(200);

    }
}
