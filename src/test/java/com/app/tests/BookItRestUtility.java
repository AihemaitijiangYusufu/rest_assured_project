package com.app.tests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookItRestUtility {


    public static String getTeacherToken(){

        Response response=given().log().all().
                param("email","teacherva5@gmail.com").
                param("password","maxpayne").
                get("sign");
        response.then().log().all().
                assertThat().statusCode(200);
        return  response.jsonPath().get("accessToken");
    }

}
