package api.endpoints;

/*
 Swagger URI ...> https://petstore.swagger.io/
 
 create user(Post): https://petstore.swagger.io/v2/user
 Get user(Get): https://petstore.swagger.io/v2/user/{username}
 update user(Put): https://petstore.swagger.io/v2/user/{username}
 Delete user(delete): https://petstore.swagger.io/v2/user/{username}

 
  
  
 */

public class Routes {
	
	// base url is set into String type variable "base_url" and made it as public so that it can be used any where in the project and it is made static so that it can be called using class's name directly
	public static String base_url="https://petstore.swagger.io/v2";
	
	// For User Model
	
	public static String post_url= base_url+"/user";
	public static String get_url= base_url+"/user/{username}";
	public static String update_url= base_url+"/user/{username}";
	public static String delete_url= base_url+"/user/{username}";

 // If we have more models then create their Urls too. Base url ""https://petstore.swagger.io/v2" will be same for all models only end points differs
	// similarly, for pet model create it's own end points
	
	// similarly, for store model create it's own end points
	
	
	
}
