package stepDefinations;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuilder;
import resources.Utils;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class EndToEndScenario extends Utils {
	  RequestSpecification req;
	  ResponseSpecification res;
	Response response;
	static String place_id;//this variable should be same as your json field
	TestDataBuilder data = new TestDataBuilder();

	@Given("Add place with payload with {string} {string} {string}")
	public void add_place_with_payload_with(String name, String address, String language) throws Exception 
	{
		req = given().spec(getRequestSpecification()).body(data.addPlace(name, address,language));
	}

	@When("user calls {string} with http {string} method")
	public void user_calls_with_http_method(String resource, String method) throws IOException
	{
		  APIResources APIresource =APIResources.valueOf(resource);
		  if(method.equalsIgnoreCase("POST")) 
		  {
			  response=req.when().post(APIresource.getAPIResource());
		  }
		  else if(method.equalsIgnoreCase("GET"))
		  {
			  response=req.when().get(APIresource.getAPIResource());
		  }
		  else if(method.equalsIgnoreCase("DELETE"))
		  {
			  response=req.when().delete(APIresource.getAPIResource());
			  System.out.println("delete response:"+response.asString());
		  }
	}

	@Then("get the {string} from response body")
	public void get_the_from_response_body(String placeId) 
	{
		place_id=getJsonPath(response,placeId); 
	}

	@Then("user calls {string} to verify details of place like {string} {string} {string}")
	public void user_calls_to_verify_details_of_place_like(String resource, String name, String address,
			String language) throws Exception 
	{
	
		   req=given().spec(getRequestSpecification())
				      .queryParam("place_id", place_id)
				      .relaxedHTTPSValidation();
		   user_calls_with_http_method(resource,"GET");    
		   //System.out.println("last response:"+response.asString());
		  System.out.println("name:"+getJsonPath(response, "name")+"address:"+getJsonPath(response, "address")+"language:"+getJsonPath(response, "language"));
	}

	@Then("user call {string} with http {string} method to delete {string}")
	public void user_call_with_http_method_to_delete(String resource, String method, String placeId) throws IOException {
	 
		req=given().spec(getRequestSpecification()).body(data.DeleteLocation(place_id));//data.DeleteLocation(place_id)- this variable should be same as your json field
		 user_calls_with_http_method(resource,method);
		 System.out.println("delete response:"+response.asString());
		 assertEquals(getJsonPath(response,"status"), "OK");
	}

}
