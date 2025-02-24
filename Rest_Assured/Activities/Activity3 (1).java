package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {

	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;

	@BeforeClass
	public void setUp() {
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("https://petstore.swagger.io/v2/pet")
				.addHeader("Content-Type", "application/json")
				.build();

		responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType("application/json")
				.expectBody("status", equalTo("alive"))
				.build();
	}

	@DataProvider(name = "petInfo")
	public Object[][] petInfoProvider() {
		// Setting parameters to pass to test case
		Object[][] testData = new Object[][] { 
			{ 11011, "Johney", "alive" }, 
			{ 20989, "Bansal", "alive" } 
		};
		return testData;
	}

	@Test(priority=1, dataProvider = "petInfo")
	// Test case using a DataProvider
	public void addPets(int petId, String petName, String petStatus) {
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		given()
			.spec(requestSpec)
			.body(reqBody)
		.when()
			.post()
		.then().spec(responseSpec)
		.body("name", equalTo(petName));
	}

	// Test case using a DataProvider
	@Test( priority=2, dataProvider = "petInfo")
	public void getPets(int petId, String petName, String petStatus) {
		given()
			.spec(requestSpec)
			.pathParam("petId", petId)
			.log().all()
		.when()
			.get("/{petId}")
		.then()
			.spec(responseSpec)
		    .body("name", equalTo(petName))
		    .log().all(); // Log for request details
	}

	// Test case using a DataProvider
	@Test(priority=3, dataProvider = "petInfo")
	public void deletePets(int petId, String petName, String petStatus) {
		given()
			.spec(requestSpec)
			.pathParam("petId", petId)
		.when()
			.delete("/{petId}")
		.then()
			.body("code", equalTo(200))
			.body("message", equalTo(""+petId));
	}
}
