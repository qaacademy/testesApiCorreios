package cenarios;

import org.junit.Test;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext.AND;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class TestesApiQAAcademyCorreios {
	

	
	@Test
	public void testeApiCorreiosSucesso() {
		String url = "https://viacep.com.br/ws/06840080/json/";

		given()
			.log().all()
		.when()
			.get(url)
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body(containsString("06840-080"))
			.and()
			.body(containsString("Embu das Artes"));		
	}
	
	@Test
	public void testeApiCorreiosSucessoEqualTo() {
		String url = "https://api.zippopotam.us/BR/01000-000";

		given()
			.log().all()
		.when()
			.get(url)
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body("places[0].longitude",equalTo("-46.635"))
			.and()
			.body("places[0].'place name'", equalTo("São Paulo"));
		
	}
	

}
