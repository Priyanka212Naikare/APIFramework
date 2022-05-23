package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class Utils {
	public  RequestSpecification req;
	public  ResponseSpecification res;
	public static  Properties prop;


	public RequestSpecification getRequestSpecification() throws IOException
	{
		if(req==null)
		{
        PrintStream stream=new PrintStream(new FileOutputStream("logging.txt"));
        req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
        		.setContentType(ContentType.JSON)
				.addQueryParam("key", "qaclick123")
				.setRelaxedHTTPSValidation()
				.addFilter(RequestLoggingFilter.logRequestTo(stream))
				.addFilter(ResponseLoggingFilter.logResponseTo(stream))
				.build();
		return req;
		}
		return req;
	}

	public ResponseSpecification getResponseSpecification() throws IOException
	{
	res = new ResponseSpecBuilder()
			.expectStatusCode(200)
			.expectHeader("Access-Control-Allow-Origin", "*")
			.build();
	return res;
	}
	public String getJsonPath(Response response,String field)
	{
      
		JsonPath js=new JsonPath(response.asString());
		return js.get(field).toString();
	}

    public static String getPropertyObject(String key) throws IOException 
    {
    	prop =new Properties();
    	FileInputStream fin=new FileInputStream("C:\\Users\\priya\\eclipse-workspace\\automation\\src\\test\\java\\resources\\global.properties");
    	prop.load(fin);
    	return prop.getProperty(key);
    	
    }

}
