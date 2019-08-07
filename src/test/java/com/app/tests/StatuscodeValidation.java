package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class StatuscodeValidation {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
    }

    @Test
    public void testOK(){

        //given --> prep request
        given().
        //submit request
        when().get().
        //then verify request
         //verify statuscode
        then().statusCode(200);


    }


    @Test
    public void notFoundTest(){

               given().
                when().get("jahsdbajdb").
                then().statusCode(404);

    }
}
