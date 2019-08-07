package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class githubAPI {

    @BeforeClass
    public static void setUp(){

        RestAssured.baseURI="https://api.github.com";
    }

    @Test
    public void userTest(){
        //given-->prepare our request
        //submit-->submit it to url
        given().pathParam("username","aihemaitijiangyusufu").
                when().get("/users/{username}").prettyPrint();


    }
}
