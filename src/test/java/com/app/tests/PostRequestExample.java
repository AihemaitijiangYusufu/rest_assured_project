package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;


public class PostRequestExample {

    String accessToken;

    @BeforeClass
    public static void setUp(){

        RestAssured.baseURI="https://cybertek-reservation-api-qa.herokuapp.com/";
    }

    @Test
    public void createTeam(){

        String token=BookItRestUtility.getTeacherToken();

        // make a post request
        String team="ahmetjanyu";
        RestAssured.given().
                header("Authorization",token).
                queryParam("campus-location","VA").
                queryParam("batch-number","8").
                queryParam("team-name",team).
                post("/api/teams/team").
                then().log().all().statusCode(201).
                 body(containsString("added"));
        verifyTeamExists(team);

    }
        public static void verifyTeamExists(String team){

            DatabaseUtility.createConnection();
            String sql="select * from team where name='"+team+"';";
            System.out.println(sql);
            Map<String,Object> result = DatabaseUtility.getRowMap(sql);
            Assert.assertNotNull(result);
        }





}
