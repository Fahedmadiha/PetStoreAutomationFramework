package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.UserPojo;
import io.restassured.response.Response;

public class UserTests2 {

	// we have to prepare data for sending payload(request) for that we are going to use Faker library and JSON Object class
	
	Faker faker; // object reference of Faker library is created here to generate data
	UserPojo payload; // Object reference of POJO class "UserPojo" is created here
	public Logger logger;
	
	
	@BeforeClass // Before class annotation of TestNG will help to run this method before starting our valifdations
	public void setUpData() // we create a method to set data in to Pojo class
	{
		faker=new Faker();
		payload=new UserPojo();
		
	payload.setId(faker.idNumber().hashCode()); 
	payload.setUsername(faker.name().username());
	payload.setUsername(faker.name().firstName());
	payload.setUsername(faker.name().lastName());
	payload.setUsername(faker.internet().emailAddress());
	payload.setUsername(faker.internet().password());
	payload.setUsername(faker.phoneNumber().cellPhone());
	
	//logs
	
	logger=LogManager.getLogger(this.getClass());
	
	logger.debug("debugging.................");
	
	}
	
	@Test(priority=1)
	public void testpostuser()
	
	{
		logger.info("************Creating User*****************");
		Response res=UserEndpoints2.createUser(payload); // Here we called "UserEndpoints" class and createUser method and passed body present in "payload" variable as an argument
		// as we passed payload we got response and that response body is send to the variable "res"
		
		// validations are written below here
		
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	logger.info("************Created User*****************");

	}
	
	@Test(priority=2)
	public void testgetUserByName()
	{
		logger.info("************Get User info*****************");

		Response res=UserEndpoints2.getUser(this.payload.getUsername()); // By using this keyword we can refer to the payload and using getter method we get the username from the payload
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		logger.info("************Get User info successful*****************");

	}
	
	@Test(priority=3)
	public void testupdateuserByName()
	{
		logger.info("************Update User*****************");

		// Update some data using payload
		payload.setUsername(faker.name().firstName());
		payload.setUsername(faker.name().lastName());
		payload.setUsername(faker.internet().emailAddress());
		
		
		Response res=UserEndpoints2.updateuser(this.payload.getUsername(), payload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		
		logger.info("************ User Updated *****************");

		
		// validating data after update, it is same as getUser 
		
		Response resafterUpdate=UserEndpoints2.getUser(this.payload.getUsername()); // By using this keyword we can refer to the payload and using getter method we get the username from the payload
		resafterUpdate.then().log().all();
		Assert.assertEquals(resafterUpdate.getStatusCode(),200);
		
	}
	
	@Test(priority=4)
	public void testdeleteUserByName()
	{
		logger.info("************ User delete request *****************");

		Response res=UserEndpoints2.deleteUser(this.payload.getUsername());
	      res.then().log().all();
	      Assert.assertEquals(res.getStatusCode(), 200);
			logger.info("************ User deleted *****************");

	}
	
}
