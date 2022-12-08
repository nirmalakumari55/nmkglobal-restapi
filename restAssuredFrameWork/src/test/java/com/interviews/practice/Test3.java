package com.interviews.practice;

import org.json.JSONObject;

public class Test3 {

	public static void main(String[] args) {
		String strResponse = "{\n"
				+ "	\"customer\" : {\n"
				+ "		\"firstName\" : \"Nirmal Kumari\",\n"
				+ "		\"lastName\" : \"Bellala\",\n"
				+ "		\"age\" : 40,\n"
				+ "		\"address\" :{\n"
				+ "			\"addressLine1\" : \"50 Boshra Ct\",\n"
				+ "			\"addressLine2\" : \"\",\n"
				+ "			\"city\" : \"Mountain House\",\n"
				+ "			\"state\" : \"CA\",\n"
				+ "			\"zipcode\" : \"95391\"\n"
				+ "		}\n"
				+ "	}\n"
				+ "}";

		JSONObject jsonResponse = new JSONObject(strResponse);
		JSONObject customer = jsonResponse.getJSONObject("customer");
		
		System.out.println("firstName :: " + customer.getString("firstName"));
		System.out.println("lastName :: " + customer.getString("lastName"));
		System.out.println("age :: " + customer.getInt("age"));
		
		JSONObject address = customer.getJSONObject("address");
		System.out.println(address.getString("addressLine1"));
	}

}
