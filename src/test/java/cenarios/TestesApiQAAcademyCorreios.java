package cenarios;

import org.junit.Test;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext.AND;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

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
	public void testeApiCorreiosContentType() {
		String url = "https://api.zippopotam.us/BR/01000-000";

		given()
			.log().all()
		.when()
			.get(url)
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON);
		
	}
	
	
	@Test
	public void testeApiCorreiosHeader() {
		String url = "https://api.zippopotam.us/BR/01000-000";
		
		Map<String, String> map_header = new HashMap<String, String>(); 
		map_header.put("Content-Type", "application/json"); 
		map_header.put("Content-Type", "application/json"); 
		map_header.put("Content-Type", "application/json"); 
		map_header.put("Content-Type", "application/json"); 
		
		Map<String, String> map_queryParam = new HashMap<String, String>(); 
		map_queryParam.put("chave", "valor");
		
		String authententication = "asdasdasdas8484aosdhaisudha s.a6d654sd65a4sd65a4 as as46d5a4s6d5as4";

		given()
			.log().all()
			.headers(map_header)
			.queryParams(map_queryParam)
		.when()
			.get(url)
		.then()
			.log().all()
			.header("Content-Type", equalTo("application/json"))
			.assertThat()
			.statusCode(200);
		
	}
	
	@Test
	public void testeApiCorreiosSucessoEqualToExtract() {
		String url = "https://api.zippopotam.us/BR/01000-000";

	String retornoPath = 
			given()
		.when()
			.get(url)
		.then()
			.assertThat()
			.statusCode(200)
			.extract()
			.path("places[0].longitude");
	
	
	given()
	.log().all()
	.header("token", retornoPath)
.when()
	.get(url)
.then()
	.log().all()
	.header("Content-Type", equalTo("application/json"))
	.assertThat()
	.statusCode(200);
	
	System.out.println(retornoPath);
		
	}
	
	
	

}
