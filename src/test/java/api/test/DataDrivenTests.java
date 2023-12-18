package api.test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.UserPojo;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	//dataProvider and dataProviderClass will provide data to the below method
    @Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testpostuser(String userID, String username, String fname, String lname, String email, String pwd, String ph)// here we create variable as arguments to receive data provided by data provider
	{ 
		// Need to use Pojo class to set/add the data to the variables in the arguments
		UserPojo payload=new UserPojo();
		
		payload.setId(Integer.parseInt(userID));
		payload.setUsername(username);
		payload.setFirstName(fname);
		payload.setLastName(lname);
		payload.setEmail(email);
		payload.setPassword(pwd);
		payload.setPhone(ph);
		
		// Validation part
		
	Response res=UserEndpoints.createUser(payload);
	
	Assert.assertEquals(res.getStatusCode(),200);
		
	}
    
    @Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
    public void testdeleteUserByName(String username)
    {
    	
    	
    	Response res=UserEndpoints.deleteUser(username);
    	Assert.assertEquals(res.getStatusCode(),200);

    	
    }
	
}
