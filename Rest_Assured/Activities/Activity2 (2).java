package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Activity2 {
	@Test(priority=1)
	public void addNewUserFromFile() throws IOException {
		// Import JSON file
		FileInputStream inputJSON = new FileInputStream("src/test/java/activities/userInfo.json");

		Response response = 
			given().
				baseUri("https://petstore.swagger.io/v2/user").
				header("Content-Type", "application/json").
				body(inputJSON).
			when().
				post(); 

		inputJSON.close();

		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("9901"));
	}
	
	@Test(priority=2)
	public void getUserInfo() {
		// Import JSON file to write to
		File outputJSON = new File("src/test/java/activities/userGETResponse.json");

		Response response = 
			given().
				baseUri("https://petstore.swagger.io/v2/user").
				header("Content-Type", "application/json").
				pathParam("username", "justinc").
			when().
				get("/{username}");
		
		String resBody = response.getBody().asPrettyString();

		try {
			// Create JSON file
			outputJSON.createNewFile();
			// Write response body to external file
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}
		
		// Assertion
		response.then().body("id", equalTo(9901));
		response.then().body("username", equalTo("justinc"));
		response.then().body("firstName", equalTo("Justin"));
		response.then().body("lastName", equalTo("Case"));
		response.then().body("email", equalTo("justincase@mail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9812763450"));
	}
	
	@Test(priority=3)
	public void deleteUser() throws IOException {
		Response response = 
			given().
				baseUri("https://petstore.swagger.io/v2/user").
				header("Content-Type", "application/json").
				pathParam("username","justinc").
			when().
				delete("/{username}");

		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("justinc"));
	}
}
