package com.interviews.practice;

import static org.junit.Assert.*;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredSample {
	@Test
	public void testGet() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httpRequest = RestAssured.given();
		Response resp = httpRequest.request(Method.GET, "/5");
		String responseBody = resp.getBody().asString();
		int statusCode = resp.getStatusCode();
		System.out.println("statusCode is :: " + statusCode);
		assertEquals(statusCode, 200);
		String statusLine = resp.statusLine();
		System.out.println("statusLine is ::" + statusLine + "::");
		assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}
