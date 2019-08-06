package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class BaseURIDemo {

    @Test
    public void quotesTest(){

        // baseURI --> used to save the base url for all resources
       // when we actually make requests, we only provide the path to
       // specific resource

        RestAssured.baseURI="https://got-quotes.herokuapp.com/";
        Response response= RestAssured.get("/quotes/");
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("quote"));
    }

    @Test
    public void cerseiQuoteTest(){

        RestAssured.baseURI="https://got-quotes.herokuapp.com/";
        Response response=RestAssured.get("quotes?char=cersei");
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("Cersei Lannister"));

    }
}
