package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	
	
	public static RequestSpecification httprequest;
	public static Response Response;
	public static String responsebody;
	//public static String mobile_number = RandomGenerator.getRandomMobileNumber();
	public static String Success = "Request processed succssesfully";
	public static int statuscode;
	public static Properties requestdata = new Properties();
	public static String sheet;
	public static String score;
	static String Token = "f52e01fba3341e14acf772f4e9db418dc84733fac1291af2392a380be5b840";
	
	
	@Parameters({"browser", "PL_report_URL"})
	@BeforeSuite
	public void settingBaseURI() throws IOException
	{
		
		RestAssured.baseURI="https://reqres.in/";
		
		httprequest = RestAssured.given();
		httprequest.contentType("application/json");	
		loadpropertyfile();
		
		
		
	}
	
	
	public void loadpropertyfile() throws IOException
	{
		
		Properties p=new Properties();
	
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\propertyfile\\data.properties");
		
		p.load(objfile);
		
	    String s=p.getProperty("baseuri");
	    System.out.println(s);
		
		
		
	}
	
	

}
