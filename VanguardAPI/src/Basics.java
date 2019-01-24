import io.restassured.RestAssured;
import sourceValues.resource;
import io.restassured.http.ContentType;
import io.restassured.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import sourceValues.ReusableMethods;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basics {

	Properties prop = new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Selenium Workspace\\VanguardAPI\\src\\sourceValues\\env.properties");
		prop.load(fis);
		
	}
	
	@Test
	public void NavPriceArray()
	{
		// TODO Auto-generated method stub
           
		RestAssured.baseURI=prop.getProperty("Host");
	    Response res =	given().
	                    when().get(resource.placeGetData()).
	                    then().
	                   // assertThat().statusCode(200).and().contentType(ContentType.JSON).
	                    extract().response();
	                   JsonPath js = ReusableMethods.rawToJson(res);
	
	String responseString = res.asString();
	System.out.println(responseString);
	
	List<Map<String, Object>> NavPriceArray = get(resource.placeGetData()).as(new TypeRef<List<Map<String, Object>>>() {});
	
	//JsonPath js = new JsonPath(responseString);
	//String portID[] = js.get("portID");
	//System.out.println(portID);
	//System.out.println(js.get("portId"));
	  
/*	int count = js.get("navPriceArray.size()");
	for (int i=0; i<count; i++)
{
	System.out.println(js.get("navPriceArray["+i+"].portId"));
}
	System.out.println(count); */
	
	          
	}

	private ResponseBodyExtractionOptions get(String placeGetData) {
		// TODO Auto-generated method stub
		return null;
	}

}
