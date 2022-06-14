package RestassuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * Validations in JSON Response
-----------------------------------
1) Test Status Code
2) Logging Response
3) Verifying Single content in Response body
4) Verifying Multiple contents in Response body
5) Setting Parameters & Headers

 * */

public class apiValidations {
	// 1) Test Status Code
	@Test(priority = 1)
	public void testStatusCode() {
		// can remove given() if there is no pre-requisites.
		when().get("http://jsonplaceholder.typicode.com/posts/5").then().statusCode(200).log().all();

	}

	// 2) Log Response, basically using log all is logging the whole response.
	@Test(priority = 2)
	public void logResponse() {
		given().when().get("http://jsonplaceholder.typicode.com/posts/5").then().statusCode(200).log().all();
	}

	@Test(priority = 3)
	// 3) Verifying Single content in Response body
	public void singleContentResponse() {
		given().when().get("http://jsonplaceholder.typicode.com/posts/5").then().statusCode(200)
				.body("title", equalTo("nesciunt quas odio")).log().all();
	}

	@Test(priority = 4)
//4) Verifying multiple  content in Response body
	public void multipleContentResponse() {
		given().when().get("https://flask-rest-api-demo.herokuapp.com/users").then().statusCode(200)
				.body("users.id", hasItems(1, 2, 3)) // i was using double quotes with numbers,
				.log().all(); // that was the reason for TC failure

	}

//5) Setting Parameters & Headers
	@Test(priority = 5)
	public void testParamHeader() {
		given().param("Myname", "Jyoti").headers("MyHeader", "India").when()
				.get("https://flask-rest-api-demo.herokuapp.com/users").then().statusCode(200).log().all();

	}

}
