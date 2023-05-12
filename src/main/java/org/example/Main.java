package org.example;

import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Main {

	@BeforeMethod
	public static void main(String[] args) {
		System.out.println("Start Test.");
	}

	@DataProvider(name="apikey")
	private static Object[] apiKey(){ return new Object[]{getApiKey()}; }

	@Test(priority=1, description="Connect to API", dataProvider="apikey")
	private static void testOne(String apikey){
		String host = "http://api.weatherapi.com/v1/";
		String category = "current.json";
		String apiKey = "?key=" + apikey;
		String q = "&q=48.8567,2.3508";
		String request = host + category + apiKey + q;

		given().when().get(request).then().statusCode(200);
	}

	// @Test(priority=2)
	private static void testTwo(){ }

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