package com.interviews.practice;

import org.json.JSONObject;

public class Test2 {
	public static void main(String[] ar) {
		JSONObject customerAttributes = new JSONObject();
		customerAttributes.put("firstName", "Nirmal Kumari");
		customerAttributes.put("lastName", "Bellala");
		customerAttributes.put("age", "40 ");
		
		JSONObject customer = new JSONObject();
		customer.put("customer", customerAttributes);
		
		JSONObject address = new JSONObject();
		address.put("addressLine1", "50 Boshra Ct");
		address.put("addressLine2", "");
		address.put("city", "Mountain House");
		address.put("state", "CA");
		address.put("zipcode", "95391");
		customerAttributes.put("address",address ); 
		
		System.out.println(customer.toString());
		

	}
}
