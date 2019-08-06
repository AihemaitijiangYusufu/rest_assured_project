package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SimpleRestDemo {


    @Test
    public void test1(){

        //this is class from rest assured library, it contains methods and objects for
       //creating and sending requests
        //get--> method for making a get request,accepts the resources url as parameter
        //response --> represents the response that came back from server based on out request

       Response response = RestAssured.get("https://got-quotes.herokuapp.com/quotes/");
        //print the response
        response.prettyPrint();

        //asString --> converts the response to string
        String resString=response.asString();
        Assert.assertTrue(resString.contains("character"));

        // statusCode returns the response
        int code=response.statusCode();

        //The HTTP 200 OK success status response code indicates that the request has succeeded.
        Assert.assertEquals(200,code);


    }

    @Test
    public void headersTest(){
        Response response=RestAssured.get("https://got-quotes.herokuapp.com/quotes/");
        System.out.println(response.headers());

        String contentType=response.header("Content-Type");
        System.out.println(contentType);

        Assert.assertEquals("application/json; charset=utf-8",contentType);
    }

    @Test
    public void statusLineTest(){

        Response response=RestAssured.get("https://got-quotes.herokuapp.com/quotes/");
       //statusLine --> returns all the information in the status line of the reponse
        String statusLine=response.statusLine();
        System.out.println(statusLine);
        Assert.assertTrue(statusLine.contains("200"));


    }
}
