package cenarios;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;

public class TestesApiQAAcademyCorreios {
	

	
	@Test
	public void testeApiCorreiosSucesso() {
		String url = "https://viacep.com.br/ws/06840080/json/";

		RestAssured
		.given()
			.log().all()
		.when()
			.get(url)
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body(Matchers.containsString("06840-080"))
			.and()
			.body(Matchers.containsString("Embu das Artes"))
			.and()
			.body(Matchers.containsString("3515004"));
	}

}
