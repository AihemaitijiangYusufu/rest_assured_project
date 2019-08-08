package com.app.tests;

import io.restassured.RestAssured;
import org.junit.Test;


public class RelaxedHttpsValidation {


    @Test
    public void relaxYo(){

        // we are going to trust connection with bad certificates

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.get("https://untrusted-root.badssl.com").
                then().log().all().statusCode(200);


    }


}
