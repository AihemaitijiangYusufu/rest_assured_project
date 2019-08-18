package com.app.tests;

import com.app.pojos.Instructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.greaterThan;


public class JsonPayloadExample {

    @Test
    public void payloadTest() throws IOException {

        Instructor instructor=new Instructor();
        String firstName=new Faker().name().firstName();
        String lastName=new Faker().name().lastName();
        int batch=new Faker().number().numberBetween(1,21);
        String subject="Java";
        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        instructor.setBatch(batch);
        instructor.setSubject(subject);

        RestAssured.baseURI="http://cybertekchicago.com/";

        // contentType() --> used to indicate what kind of payload we are sending
        //contentType.JSON -->the actual type
        // body of the request
        Response postResponse=given().
                contentType(ContentType.JSON).
                body(instructor).
                when().post("instructor/create");
        postResponse.then().log().all();

        int id = postResponse.path("id");
        System.out.println("id= "+id);

        Response getResponse=given().
                pathParam("id",id).
                when().get("instructor/{id}");

        getResponse.then().log().all().
                assertThat().statusCode(200);


        ObjectMapper objectMapper=new ObjectMapper();
        Instructor instructor2=objectMapper.readValue(getResponse.asString(),Instructor.class);
        System.out.println("instructor2= "+instructor2);

        assertThat(instructor2.getFirstName(),is(instructor.getFirstName()));
        assertThat(instructor2.getLastName(),is(instructor.getLastName()));
        assertThat(instructor2.getId(),greaterThan(0));



    }
}
