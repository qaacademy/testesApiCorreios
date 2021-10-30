package cenarios;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TesteRequestSpecification {
	private static RequestSpecification requestSpec;

	@BeforeClass
	public static void requestSpecification() {
		requestSpec = new RequestSpecBuilder().setBaseUri("https://api.zippopotam.us").build();

	}
	
	@Test
	public void testeComRequestSpec() {

		
		given()
		.spec(requestSpec)
		.log().all()
	.when()
		.get("/br/01000-000")
	.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
	
	@Test
	public void testeComRequestSpec2() {

		
		given()
		.spec(requestSpec)
		.log().all()
	.when()
		.get("/BR/01000-000")
	.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
	
	
	@Test
	public void testeComRequestSpec1() {

		
		given()
		.spec(requestSpec)
		.log().all()
	.when()
		.get("/br/01000-000")
	.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}
	

}
