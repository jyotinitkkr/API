package RestassuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest {
	
	@Test
	public void getWeatherDetails() {
		/* if given method is not recognized, import restassured 
		and hamcrest packages as mentioned above the program 
		*/
		given()
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.statusCode(200)
		.assertThat().body("total",equalTo(12))
		.header("Content-Type", "application/json; charset=utf-8")
		.body("data.id[1]", equalTo(2))
		.log().all();
	}
	
	}


