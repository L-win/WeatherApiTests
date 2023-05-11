package org.example;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Main {

	private static final String API_KEY = "";

	public static void main(String[] args) {
		System.out.println("Start Test.");
	}

	@Test(priority=1)
	private static void testOne(){
		String q = "";
		String request = "http://api.weatherapi.com/v1/q="+q+"/key"+API_KEY;
		request = "http://api.weatherapi.com/v1/q=48.8567,2.3508/current.json";
		request = "http://api.weatherapi.com/v1/current.json?key="+API_KEY+"&q=48.8567,2.3508";

		given()
				.when()
					.get(request)
				.then()
				.statusCode(200);
	}

//	@Test(priority=2)
	private static void testTwo(){}


}