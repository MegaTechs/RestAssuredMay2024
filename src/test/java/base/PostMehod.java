package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class PostMehod {
    @Test
    public void PostTestCase(){
       //
        //RestAssured.baseURI="https://jsonplaceholder.typicode.com/";


        RestAssured.baseURI="https://reqres.in";
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        JSONObject jo = new JSONObject();
        jo.put("name","Mohammad Nazmul");
        jo.put("job","QA");

        request.body(jo.toJSONString());

        //VVI100% request.body(jo.toJSONString());


        Response response=request.post("/api/users");

        int statusCode=response.getStatusCode();
        System.out.println("statusCode"+statusCode);
        Assert.assertEquals("201","201");
        String successCode= response.jsonPath().get("statusCode");


        String bodyas_json = response.body().jsonPath().prettify();
        System.out.println("bodyas_json = "+bodyas_json);

    }
}