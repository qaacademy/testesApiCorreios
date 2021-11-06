package cenarios;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestesApiQAAcademyCorreiosValidacaoJson {

	@Test
	public void testeApiCorreiosValidaJson() throws Exception  {
		File file = new File("./src/test/resources/responseApiCorreios.json");
		
		Response response = 
				
				RestAssured.given()
						   .when()
						   		.get("https://api.zippopotam.us/BR/01000-000")
						   .then()
						   .contentType(ContentType.JSON)
						   .extract()
						   .response();

		String expectedJson = FileUtils.readFileToString(file, Charset.defaultCharset());
		
		String actualJson = response.body().asString();
		
		JSONAssert.assertEquals(expectedJson, actualJson, JSONCompareMode.STRICT);
	}

}
