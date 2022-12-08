package com.interviews.practice;

import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestSample4 {

	@Test
	public void testPost() {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		
		
		JSONObject jsonReq = new JSONObject();
		jsonReq.put("name", "ram");
		jsonReq.put("job", "lead");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(jsonReq.toString());
		
		Response resp = httpRequest.request(Method.POST, "/users/");
		String responseBody = resp.getBody().asString();
		System.out.println("responseBody is" + responseBody);
		
		
		JSONObject jsonResponse = new JSONObject(responseBody);
		System.out.println("jsonResponse is" + jsonResponse.toString());
		
		System.out.println(jsonResponse.getString("name"));
		System.out.println(jsonResponse.getString("job"));
		System.out.println(jsonResponse.getString("id"));
		System.out.println(jsonResponse.getString("createdAt"));
		
		int statusCode = resp.getStatusCode();
		System.out.println("statusCode is " + statusCode);
		Assert.assertEquals(statusCode, 201);
		String statusLine = resp.getStatusLine();
		System.out.println("statusLine is " + statusLine );
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
	

	}
}
