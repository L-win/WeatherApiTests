package org.elvinagha;

import io.restassured.response.Response;
import org.elvinagha.util.ApiKey;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Forecast {

	@DataProvider(name="request")
	private static Object[] getRequest(){
		String host = "http://api.weatherapi.com/v1/";
		String category = "forecast.json";
		String apiKey = "?key=" + ApiKey.getApiKey();
		String q = "&q=London";
		String request = host + category + apiKey + q;

		Response res =
				given()
						.when().get(request)
				.then()
						.statusCode(200)
				.extract()
						.response();

		// System.out.println(res.asString());
		return new Object[]{res.asString()};
	}

	@Test(priority=1,dataProvider="request")
	private static void TEMP(String request){
		System.out.println(request);
	}

	@Test(priority=1,dataProvider="request")
	private static void t1_City(String request){}
}
