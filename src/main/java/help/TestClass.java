package help;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {
    @Test
    public void WeatherMessageBody()
    {
       // RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();

        // To check for sub string presence get the Response body as a String.
        // Do a String.contains
        String bodyAsString = body.asString();
        Assert.assertEquals(bodyAsString.contains("Hyderabad"), "Response body contains Hyderabad");
    }
}
