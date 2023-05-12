package org.example;

import io.restassured.response.Response;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

public class Main {

	@DataProvider(name="requestData")
	private static Object[] firstRequest(){
		String host = "http://api.weatherapi.com/v1/";
		String category = "current.json";
		String apiKey = "?key=" + getApiKey();
		String q = "&q=48.8567,2.3508";
		String request = host + category + apiKey + q;
		Response res =
					given()
						.when()
						.get(request)
						.then()
						.statusCode(200)
						.log()
						.body().extract().response();
		String response = res.asString();
		return new Object[]{response};
	}

	@Test(priority=1, dataProvider = "requestData")
	private static void t1_Name(String requestData){
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

	@Test(priority=7)
	private static void secondRequest(){
		String host = "http://api.weatherapi.com/v1/";
		String category = "current.json";
		String apiKey = "?key=" + getApiKey();
		String q = "&q=London";
		String request = host + category + apiKey + q;
		Response res =
					given()
						.when()
						.get(request)
						.then()
						.statusCode(200)
						.log()
						.body().extract().response();
		String response = res.asString();
	}

	private static String getApiKey(){
		String result = "";
		try {
			File myObj = new File("APIKEY");
			Scanner myReader = new Scanner(myObj);
			result = myReader.nextLine();
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return result;
	}

}