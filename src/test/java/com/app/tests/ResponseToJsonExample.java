package com.app.tests;

import com.app.pojos.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ResponseToJsonExample {

    @Test
    public void test() throws IOException {

        Response response=given().get("https://uinames.com/api/");

        //using Rest Assuared

        // values from the json response is automatically mapped to corresponding fields
        // in the person object
        Person p1=response.as(Person.class);
        System.out.println("p1: "+p1);
        System.out.println("p1 name    : "+p1.getName());
        System.out.println("p1 surname : "+p1.getSurname());
        System.out.println("p1 gender  : "+p1.getGender());
        System.out.println("p1 region  : "+p1.getRegion());

        //using Gson
        Gson gson=new Gson();
        Person p2=gson.fromJson(response.asString(),Person.class);
        System.out.println("p2: "+p2);

        //using Jackson Databind

        ObjectMapper objectMapper=new ObjectMapper();
        Person p3=objectMapper.readValue(response.asString(),Person.class);
        System.out.println("p3: "+p3);

    }

    @Test
    public void responseListOfObjects(){
        Response response=given().
                queryParam("amount","9").
                when().get("https://uinames.com/api/");

        List<Person> people=response.jsonPath().getList("",Person.class);

        for (Person person:people){
            System.out.println(person);
        }
    }
}
