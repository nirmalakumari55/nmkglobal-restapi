package com.global;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest1 {
	@Test
	public void getTest() {
		RestAssured.baseURI = "https://gorest.co.in/public-api/users";
		RequestSpecification httpRequest = RestAssured.given();
		Response resp = httpRequest.request(Method.GET, "/137");
		String respBody = resp.getBody().asString();
		int statusCode = resp.getStatusCode();
		System.out.println("statusCode is" + statusCode);
		assertEquals(statusCode, 200);
		String statusLine = resp.getStatusLine();
		System.out.println("statusLine is" + statusLine);
		assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

	@Test
	public void getTest2() {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();

		Response resp = httpRequest.request(Method.GET, "/users/1");

		int statusCode = resp.getStatusCode();
		System.out.println(resp.getStatusCode());
		assertEquals(statusCode, 200);

		String statusLine = resp.getStatusLine();
		System.out.println(resp.getStatusLine());
		assertEquals(statusLine, "HTTP/1.1 200 OK");

		JSONObject jsonresp = new JSONObject(resp.getBody().asString());
		System.out.println(jsonresp);

		String fn = jsonresp.getJSONObject("data").getString("first_name");
		assertEquals(fn, "George");

	}

}
