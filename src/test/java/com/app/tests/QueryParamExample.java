package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class QueryParamExample {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";

    }

    @Test
    public void testID(){

        given().//provide the key and value of query param
                queryParam("id",3).
              when().get().prettyPrint();
        
    }

    @Test
    public void testName(){
        given().queryParam("name","Leanne Graham").
                when().get().prettyPrint();

    }

    @Test
    public void testUsername(){

        given().queryParam("username","Karianne").
                when().get().prettyPrint();

    }


}
