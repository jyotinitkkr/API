package RestassuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

	public class putRequest {
	
		public static HashMap map = new HashMap();
		int id =2;

	@BeforeClass
	public void putData() {
		map.put("name", RestUtils.getName());
		map.put("job", RestUtils.getJob());
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users/"+id;
	}
	
	@Test
	public void testData() {
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.put()
		.then()
		.statusCode(200)
		.log().all(); // it will log the response in console.
	}
	
	
}
