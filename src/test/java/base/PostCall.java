package base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class PostCall {
    @Test
    public void PostTest(){
       // RestAssured.baseURI="https://jsonplaceholder.typicode.com/";

        RestAssured.baseURI="https://reqres.in";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");



        JSONObject jo = new JSONObject();

        jo.put("name","Nazmul");

        jo.put("job","QA Lead");

        request.body(jo.toJSONString());

      //VVI100% request.body(jo.toJSONString());
        Response response= request.request(Method.POST,"/api/users/");
        //Response response=request.post("/api/users/");

       // Response response=request.post("/register\"");
        int statusCode=response.getStatusCode();
        Assert.assertEquals("201","201");
        String successCode= response.jsonPath().get("statusCode");


        //=========================================


        System.out.println("============================================");
        String bodyasstring = response.body().asString();

        System.out.println("Bodys"+bodyasstring);

        bodyasstring.contains("title");

        System.out.println("============================================");
        response.body().jsonPath();
        String bodyas_json = response.body().jsonPath().prettify();
        System.out.println("bodyas_json = "+bodyas_json);
        String bodyas_json_title = response.body().jsonPath().get("title");
        System.out.println("Bodyas_json_title = "+bodyas_json_title);
        String bodyas_json_id = response.body().jsonPath().get("id");
        System.out.println("Bodyas_json_id = "+bodyas_json_id);

        String bodyas_json_userId = response.body().jsonPath().get("userId");
        System.out.println("Bodyas_json_userId = "+bodyas_json_userId);


    }
}
