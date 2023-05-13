package org.elvinagha.util;

import org.json.JSONObject;

public class Json {

	public static void Json(){

	}
	public static JSONObject parse(String json){

		JSONObject obj = new JSONObject(json);
		Double pageName =
				obj.getJSONObject("current")
				.getDouble("is_day");

//		if(obj.getJSONObject("current").get("is_day") instanceof Integer){
//			System.out.println("True");
//		}
//		else{
//			System.out.println("False");
//		}

//		System.out.println(pageName);

		return obj;

	}

}
