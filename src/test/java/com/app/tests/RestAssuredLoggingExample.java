package com.app.tests;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestAssuredLoggingExample {

    @Test
    public void loggingAllTest(){
         //logging request
        //log -->provides logging options for request
        given().log().all().
                when().get("https://jsonplaceholder.typicode.com/users");

        System.out.println("**************************************************");
        //log response
        Response response=RestAssured.get("https://jsonplaceholder.typicode.com/users");
        response.then().log().all();
    }

    @Test
    public void loggingHeadersTest(){

        given().log().headers().
                when().get("https://jsonplaceholder.typicode.com/users");

        System.out.println("**************************************************");

        Response response=RestAssured.get("https://jsonplaceholder.typicode.com/users");
        response.then().log().headers();
    }

    @Test
    public void loggingBodyTest(){

        given().log().body().
                when().get("https://jsonplaceholder.typicode.com/users");

        System.out.println("**************************************************");

        Response response=RestAssured.get("https://jsonplaceholder.typicode.com/users");
        response.then().log().body();
    }
}
