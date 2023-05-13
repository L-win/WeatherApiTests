package org.elvinagha;

import io.restassured.response.Response;
import org.elvinagha.util.ApiKey;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Forecast {

	@Test(priority=7)
	private static void ForeCast(){
		String host = "http://api.weatherapi.com/v1/";
		String category = "forecast.json";
		String apiKey = "?key=" + ApiKey.getApiKey();
		String q = "&q=London";
		String request = host + category + apiKey + q;

		Response res = given().when().get(request)
				.then().statusCode(200)
				.log().body().extract().response();

		String response = res.asString();
	}
}
