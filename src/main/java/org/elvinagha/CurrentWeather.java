package org.elvinagha;

import io.restassured.response.Response;
import org.elvinagha.util.ApiKey;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

public class CurrentWeather {

	@DataProvider(name="requestData")
	private static Object[] CurrentParisLongLat(){
		String host = "http://api.weatherapi.com/v1/";
		String category = "current.json";
		String apiKey = "?key=" + ApiKey.getApiKey();
		String q = "&q=48.8567,2.3508";
		String request = host + category + apiKey + q;

		Response res = given().when().get(request)
						.then().statusCode(200)
						.log().body().extract().response();

		String response = res.asString();
		return new Object[]{response};
	}

	@Test(priority=1, dataProvider = "requestData")
	private static void t1_City(String requestData){
		assertTrue(requestData.contains("Paris"));
	}

	@Test(priority=2, dataProvider = "requestData")
	private static void t2_Region(String requestData){
		assertTrue(requestData.contains("Ile-de-France"));
	}

	@Test(priority=3, dataProvider = "requestData")
	private static void t3_Country(String requestData){
		assertTrue(requestData.contains("France"));
	}

	@Test(priority=4, dataProvider = "requestData")
	private static void t4_TimeZone(String requestData){
		assertTrue(requestData.contains("Europe/Paris"));
	}

	@Test(priority=5, dataProvider = "requestData")
	private static void t5_Latitude(String requestData){
		assertTrue(requestData.contains("48.86"));
	}

	@Test(priority=6, dataProvider = "requestData")
	private static void t6_Longitude(String requestData){
		assertTrue(requestData.contains("2.35"));
	}

}