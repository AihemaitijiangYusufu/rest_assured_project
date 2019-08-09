package com.app.tests;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class JsonPathExample {

    Logger log = Logger.getLogger(JsonPathExample.class);

    @Test
    public void test(){

        String token=BookItRestUtility.getTeacherToken();

        Response response=given().header("Authorization", token).get("/api/clusters");

        JsonPath jsonPath=response.jsonPath();

        Object id=jsonPath.get("id");
        System.out.println(id);

       // get the list of IDs in the top level
        List<String> idString=jsonPath.get("id");
        System.out.println(idString);

        String idOfFirstObject=jsonPath.getString("id[0]");
        log.info(idOfFirstObject);

        Integer idOfFirstObjectNumber = jsonPath.getInt("id[0]");
        log.info(idOfFirstObjectNumber);

        List<String> isListSt=jsonPath.getList("id");
        log.info(isListSt);

        String harvard=jsonPath.getString("rooms[0].name[0]");
        log.info(harvard);

        // get all rooms in every cluster

        List<String> allrooms =jsonPath.getList("rooms.name");
        log.info("size: "+allrooms.size());
        log.info(allrooms);

        // get the first cluster in the resp

        Map<String,Object> cluster1=jsonPath.getMap("[0]");
        for (Object s:cluster1.keySet()){
            log.info(s);
            log.info(cluster1.get(s));
        }

        Map<String,String> harv=jsonPath.getMap("[0].rooms[0]");
        System.out.println(harv);
        for (String s:harv.keySet() ){
            log.info(harv.get(s));
        }

        //Casting
        Map<String,String> harv2=jsonPath.getMap("[0].rooms[0]",String.class,String.class);
        System.out.println(harv);
        for (String s:harv.keySet() ){
            log.info(harv2.get(s));
        }

        //get ID as double

        List<Double> id2=jsonPath.getList("id",Double.class);
        System.out.println(id2);



    }
}
