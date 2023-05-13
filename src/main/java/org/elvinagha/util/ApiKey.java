package org.elvinagha.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApiKey {
	public static String getApiKey(){
		String result = "";
		try {
			File myObj = new File("APIKEY");
			Scanner myReader = new Scanner(myObj);
			result = myReader.nextLine();
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
}
