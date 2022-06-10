package RestassuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBodyData;

public class PostRequest {
	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void postData() {
		map.put("name", RestUtils.getName());
		map.put("job", RestUtils.getJob());
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users";
	}
	
	@Test
	public void testData() {
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.post()
		.then()
		.statusCode(201)
		.log().all();
		
	}

}
