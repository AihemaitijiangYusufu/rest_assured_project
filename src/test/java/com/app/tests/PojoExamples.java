package com.app.tests;

import com.app.pojos.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;

public class PojoExamples {

    @Test
    public void testGson(){

        // TODO SERIALIZATION EXAMPLE
        Person person=new Person();
        person.setName("Ahmetjan");
        person.setSurname("Joseph");
        person.setGender("male");
        person.setRegion("Earth");

        System.out.println("printing the person object: "+person);

        // gson is a class used to convert objects to json
        Gson gson=new Gson();
        // toJson -->method which converts its parameter to json
        String jsonString=gson.toJson(person);

        System.out.println("printing the json: "+jsonString);

        //TODO DESERIALIZATION

        String myJsonString="{\"name\":\"Mahmutjan\","+
                " \"surname\":\"Joseph\","+
                "  \"gender\":\"male\","+
                " \"region\":\"Earth\"}";

        // fromJson() --> converts the input to given type
         Person myPerson=gson.fromJson(myJsonString,Person.class);

        System.out.println("printing the new person object"+myPerson);
    }

    @Test
    public void testJackson() throws IOException {

        // TODO SERIALIZATION EXAMPLE
        Person person=new Person();
        person.setName("Gulbanum");
        person.setSurname("Joseph");
        person.setGender("female");
        person.setRegion("Earth");

        System.out.println("printing the person object: "+person);

        // objectMapper --> class which converts from and to pojos
        ObjectMapper objectMapper=new ObjectMapper();

        // writeValueAsString() --> takes the input and to json
        String json=objectMapper.writeValueAsString(person);
        System.out.println("printing the json String: "+json);

        // TODO DESERIALIZATION EXAMPLE

        String myJsonString= "{\"name\":\"Mahmutjan\","+
                " \"surname\":\"Joseph\","+
                "  \"gender\":\"male\","+
                " \"region\":\"Earth\"}";


        // readValue() --> converts the input to given type
        Person myPerson=objectMapper.readValue(myJsonString,Person.class);
        System.out.println("printing the new object: "+myPerson);




    }
}
