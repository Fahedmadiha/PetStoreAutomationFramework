package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.UserPojo;

//created to perform CRUD requests to the user API

public class UserEndpoints {
    
	// For createUser
	
	public static Response createUser(UserPojo payload)
	
	// here we are passing create user payload(json body) as an argument 
	// we are returning response "res" so we made written type of method as Response
	// UserPojo is a pojo class from where we are setting and getting data created in another package with name "api.Payload"
	
	{
		
	Response res=given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
	
	.when()
		.post(Routes.post_url);
		return res;
	}
	
	// For getuser
	
	public static Response getUser(String userName)
	{
		Response res=given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(Routes.get_url);
		return res;
		
	}
	
	//For update user
	public static Response updateuser(String userName, UserPojo payload)
	{
	
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username",userName)
				.when()
					.put(Routes.update_url);
					return res;
		
	}
	
	// for delete user
	
	public static Response deleteUser(String userName)
	{
		Response res=given()
		.accept(ContentType.JSON)
		.pathParam("username",userName)
		
		.when()
		.delete(Routes.delete_url);
		return res;
	
}
	
}
