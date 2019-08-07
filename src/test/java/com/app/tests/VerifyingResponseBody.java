package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class VerifyingResponseBody {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
    }

    @Test
    public void testBody(){

        List<Integer> idNumbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        given().when().get().
                // body("id", --> first param is locator, gets the value from the response. it will be actual value
                then().assertThat().body("id",equalTo(idNumbers));
    }

    @Test
    public void verifyNames(){


        given().when().get().
                then().assertThat().body("name",notNullValue());

    }

    @Test
    public void verifyingEmail(){


        given().queryParam("id","2").
                when().get().
                then().assertThat().body("email",equalTo("[Shanna@melissa.tv]"));

    }

    @Test
    public void verifyingNumberOfResults(){

        given().
                when().get().
                then().assertThat().body("username",hasSize(10));


    }
}
