package org.elvinagha;

import io.restassured.response.Response;
import org.elvinagha.util.ApiKey;
import org.elvinagha.util.Json;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

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

		return new Object[]{res.asString()};
	}

	@Test(priority=1, dataProvider="request")
	private static void TEMP(String request){
		System.out.println(request);
	}

	@Test(priority=1, dataProvider="request")
	private static void t_isDay_Integer(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("is_day") instanceof Integer);
	}

	@Test(priority=1, dataProvider="request")
	private static void t1_City(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("wind_mph") instanceof Double);
	}

	@Test(priority=1, dataProvider="request")
	private static void type_pressure_mb(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("pressure_mb") instanceof Double);
	}
	@Test(priority=1, dataProvider="request")
	private static void type_pressure_in(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("pressure_in") instanceof Double);
	}
	@Test(priority=1, dataProvider="request")
	private static void type_precip_mm(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("precip_mm") instanceof Double);
	}
	@Test(priority=1, dataProvider="request")
	private static void type_precip_in(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("precip_in") instanceof Double);
	}
	@Test(priority=1, dataProvider="request")
	private static void type_feelslike_c(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("feelslike_c") instanceof Double);

	}
	@Test(priority=1, dataProvider="request")
	private static void type_feelslike_f(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("feelslike_f") instanceof Double);

	}
	@Test(priority=1, dataProvider="request")
	private static void type_vis_km(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("vis_km") instanceof Double);

	}
	@Test(priority=1, dataProvider="request")
	private static void type_vis_miles(String request){

	}
	@Test(priority=1, dataProvider="request")
	private static void type_uv(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("uv") instanceof Double);

	}
	@Test(priority=1, dataProvider="request")
	private static void type_gust_mph(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("gust_mph") instanceof Double);

	}
	@Test(priority=1, dataProvider="request")
	private static void type_gust_kph(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("gust_kph") instanceof Double);
	}

	@Test(priority=1, dataProvider="request")
	private static void type_wind_degree(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("wind_degree") instanceof Integer);
	}
	@Test(priority=1, dataProvider="request")
	private static void type_humidity(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("humidity") instanceof Integer);
	}
	@Test(priority=1, dataProvider="request")
	private static void type_cloud(String request){
		assertTrue(Json.parse(request).getJSONObject("current").get("cloud") instanceof Integer);
	}




}
