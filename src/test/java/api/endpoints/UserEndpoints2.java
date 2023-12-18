package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.UserPojo;

//created to perform CRUD requests to the user API

public class UserEndpoints2 {
   
	// Method created for getting URLs from properties file
	static ResourceBundle getURL()
	{
		
		ResourceBundle routes=ResourceBundle.getBundle("routes");// This loads properties file 
	   return routes;// all url routes which got from routes.properties file are stored in routes variable and that is returned to method getURL()
	
	}
	
	
	// For createUser
	
	public static Response createUser(UserPojo payload)
	
	
	{
		String post_url=getURL().getString("post_url");// From above getURL() method (which have all the url routes). we get particular url using getString() method and store that url in variable "post_url" 
		
	Response res=given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
	
	.when()
		.post(post_url);// the url fetched from above method geturl().getString() is passed here
		return res;
	}
	
	// For getuser
	
	public static Response getUser(String userName)
	{
		String get_url =getURL().getString("get_url");
		Response res=given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(get_url);
		return res;
		
	}
	
	//For update user
	public static Response updateuser(String userName, UserPojo payload)
	{
      String update_url=getURL().getString("update_url");
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username",userName)
				.when()
					.put(update_url);
					return res;
		
	}
	
	// for delete user
	
	public static Response deleteUser(String userName)
	{
		String delete_url=getURL().getString("delete_url");
		Response res=given()
		.accept(ContentType.JSON)
		.pathParam("username",userName)
		
		.when()
		.delete(delete_url);
		return res;
	
}
	
}
