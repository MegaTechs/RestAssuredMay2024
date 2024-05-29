package help;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

@Test
public class GetMethodTest {
 public void test1() {
  RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
 // https://jsonplaceholder.typicode.com/posts
  RequestSpecification httpRequest = given();
  Response response = httpRequest.get("posts");

  int statusCode = response.statusCode();
  System.out.println(statusCode);
  Assert.assertEquals(statusCode,200);

  String StatusLine = response.getStatusLine();
  System.out.println(response.getStatusLine());

  String statusLine = response.getStatusLine();
  Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
  //System.out.println(statusLine);

  Headers AllHeaders = response.getHeaders();
System.out.println(AllHeaders);

  String contentType = response.header("Content-Type");
  Assert.assertEquals("application/json; charset=utf-8" , contentType );
  System.out.println(contentType);

     ResponseBody body = response.getBody();
     String bodyAsString = body.asString();
    // Assert.assertEquals(bodyAsString.contains("");
     System.out.println(bodyAsString);

 }
}