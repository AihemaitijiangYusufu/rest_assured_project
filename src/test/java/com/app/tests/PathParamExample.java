package com.app.tests;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class PathParamExample {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
    }

    @Test
    public void getUsersByIDTest(){

        // statement where we prepare the request
       //adding param 'char' with value 'brynden'
       // send the request
       //{char} --> will be replaces by value of the path param

      given().pathParam("id","2").
              when().get("users/{id}").prettyPrint();

    }

    @Test
    public void getPostsByIDTest(){



        given().pathParam("userId","3").
                when().get("posts/{userId}").prettyPrint();

    }

    @Test
    public void getPlaceHolderByUsernameTest(){

        given().pathParam("email","Eliseo@gardner.biz").
                when().get("comments/Eliseo@gardner.biz").prettyPrint();

    }
}
