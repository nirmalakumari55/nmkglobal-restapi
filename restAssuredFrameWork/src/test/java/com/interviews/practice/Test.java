package com.interviews.practice;

import org.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		String str ="{\n"
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
	
		
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("{\n");
		strBuffer.append("\"customer\" : {\n");
		strBuffer.append("\"firstName\" : \"Nirmal Kumari\",\n");
		strBuffer.append("\"lastName\" : \"Bellala\",\n");
		strBuffer.append("\"age\" : 40,");
		strBuffer.append("\"address\" :{\n");
		strBuffer.append("\"addressLine1\" : \"50 Boshra Ct\",\n");
		strBuffer.append("\"addressLine2\" : \"\",\n");
		strBuffer.append("\"city\" : \"Mountain House\",\n");
		strBuffer.append("\"state\" : \"CA\",\n");
		strBuffer.append("\"zipcode\" : \"95391\"\n");
		strBuffer.append("}\n");
		strBuffer.append("}\n");
		strBuffer.append("}");
		
		//System.out.println(strBuffer);
		/*
			 {
			  "customer": {
			    "firstName": "Nirmal Kumari",
			    "lastName": "Bellala",
			    "age": 40
			  }
			}
		 */
		
		JSONObject customerAttributes = new JSONObject();
		customerAttributes.put("firstName", "Nirmal Kumari");
		customerAttributes.put("lastName", "Bellala");
		customerAttributes.put("age", 40);
		
		JSONObject addressAttributes = new JSONObject();
		addressAttributes.put("addressLine1", "50 Boshra Ct");
		addressAttributes.put("addressLine2", "");
		addressAttributes.put("city", "Mountain House");
		addressAttributes.put("state", "CA");
		addressAttributes.put("zipcode", "95391");
		
		
		customerAttributes.put("address", addressAttributes);
		
		
		JSONObject customer = new JSONObject();
		customer.put("customer", customerAttributes);
		
		System.out.println(customer.toString());
	}

	public static void stringOp() {
		String s1 = null;
		System.out.println("First one ::" + "book".equals(s1));
		System.out.println("Second one ::" + s1.equals("book"));
	}

}
