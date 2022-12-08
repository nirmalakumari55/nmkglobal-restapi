package com.interviews.practice;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestSample2 {
	@Test
	public void test1Post() {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "ram");
		requestParams.put("job", "lead");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());

		Response resp = httpRequest.request(Method.POST, "/users/");
		String responseBody = resp.getBody().asString();
		
		
		int statusCode = resp.getStatusCode();
		System.out.println("statusCode is " + statusCode);
		assertEquals(statusCode, 201);	

		String statusLine = resp.getStatusLine();
		System.out.println("statusLine is " + statusLine);
		

		JSONObject jsonResponse = new JSONObject(responseBody);
		assertEquals(jsonResponse.getString("name"), "ram");
		assertEquals(jsonResponse.getString("job"), "lead");
		System.out.println(jsonResponse.getString("name"));

	}

}
