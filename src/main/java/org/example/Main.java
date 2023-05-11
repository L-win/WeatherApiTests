package org.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Main {

	@BeforeClass
	public static void main(String[] args) {
		System.out.println("Start Test.");
	}

	@Test(priority=1)
	private static void testOne(){
		String apiKey = getApiKey();
		String request = "http://api.weatherapi.com/v1/current.json?key="+apiKey+"&q=48.8567,2.3508";

		String host = "http://api.weatherapi.com/v1/";
		String q = "current.json?key=\"+apiKey+\"&q=48.8567,2.3508\"";

		given()
				.when()
					.get(request)
				.then()
				.statusCode(200);
	}

//	@Test(priority=2)
	private static void testTwo(){}

	private static String getApiKey(){
		String result = "";
		try {
			File myObj = new File("APIKEY");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				result = data;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return result;
	}

}