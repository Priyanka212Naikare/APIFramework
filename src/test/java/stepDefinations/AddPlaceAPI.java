package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuilder;
import resources.Utils;

public class AddPlaceAPI extends Utils{
/*
	TestDataBuilder data=new TestDataBuilder();
	RequestSpecification req;
	ResponseSpecification res;
	Response response;
	String actualValue;

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String language) throws Exception {
	    

		req=given().spec(requestSpecification()).body(data.addPlace(name,address,language));

	}

	@When("user calls {string} with Http {string} request")
	public void user_calls_something_with_http_something_request(String resource, String method) throws Throwable {
        APIResources resourceApi=APIResources.valueOf(resource);
        if(method.equalsIgnoreCase("POST"))
        {
		response=req.when().post(resourceApi.getAPIResource())
				.then().spec(responseSpecification()).extract().response();
        }
        else
        {
        	response=req.when().get(resourceApi.getAPIResource())
    				.then().spec(responseSpecification()).extract().response();
        }
	}

	@Then("^API call got success with status 200$")
	public void api_call_got_success_with_status_200() throws Throwable {
		assertEquals(response.getStatusCode(),200);
	}

	@And("{string} in response body is {string}")
	public void status_in_response_body_is_something(String keyValue,String expectedValue) throws Throwable {
		actualValue=Utils.getJsonPath(response, keyValue);
		assertEquals(expectedValue.toString(), actualValue);
	} */


}
