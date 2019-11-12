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

    @Test
    public void littlefingerQuoteTest(){

        RestAssured.baseURI="https://got-quotes.herokuapp.com/";
        Response response=RestAssured.get("quotes?char=littlefinger");
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("Littlefinger"));
    }

    @Test
    public void jaimeQuoteTest(){

        RestAssured.baseURI="https://got-quotes.herokuapp.com/";
        Response response=RestAssured.get("quotes?char=jaime");
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("Jaime Lannister"));


    }

    @Test
    public void branQuotes(){

        RestAssured.baseURI="https://got-quotes.herokuapp.com/";
        Response response=RestAssured.get("quotes?char=bran");
        response.prettyPrint();
        Assert.assertTrue((response.asString().contains("Bran")));
    }
}
