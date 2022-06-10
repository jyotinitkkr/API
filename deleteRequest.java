package RestassuredTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class deleteRequest {
	
	@Test
	public void deleteData() {
		
		int id =2;
		
		Response response =
		given()
		.when()
		.delete("https://reqres.in/api/users/" +id)
		.then()
		.statusCode(204)
		.log().all()
		.extract().response();
		
		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains(""), true);
	}
}
