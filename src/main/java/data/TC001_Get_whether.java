package data;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Excelread;

public class TC001_Get_whether extends Baseclass {
	
	@Test(dataProvider = "providelogindata")
	void get(String name,String path)
	{
		
		Response=httprequest.request(Method.GET,path);

		System.out.println("gfkjfjdffd");
    }
	

@DataProvider(name="providelogindata")
public Object[][] logindata() throws Exception
{
	Object[][] a =Excelread.getTableArray(System.getProperty("user.dir")+"\\data\\payload.xlsx","get");
   
    
   return a;

}


}