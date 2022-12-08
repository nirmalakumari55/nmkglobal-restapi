package com.global;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest2 {
	@Test

	public void postTest() {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
		requestParam.put("name", "ram");
		requestParam.put("age", "11");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParam.toString());
		
		Response resp = httpRequest.request(Method.POST, "/users");
		String respBody = resp.getBody().asString();
		int statusCode = resp.getStatusCode();
		
		System.out.println("respStatusCode" + "::" + statusCode);
		assertEquals(statusCode, 201);
		String statusLine = resp.getStatusLine();
		System.out.println("statusLine is" + "::" + statusLine);
		
		assertEquals(statusLine, "HTTP/1.1 201 Created");
		JSONObject jsonResp = new JSONObject(respBody);
		assertEquals(jsonResp.getString("name"), "ram");
		System.out.println(jsonResp.getString("name"));

	}

}
