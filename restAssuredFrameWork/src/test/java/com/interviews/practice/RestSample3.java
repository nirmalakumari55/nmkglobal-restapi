	package com.interviews.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestSample3 {
	@Test
	public void test1Get() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httpRequest = RestAssured.given();
		Response resp = httpRequest.request(Method.GET, "/5");
		String respBody = resp.getBody().asString();
		System.out.println("respBody " + respBody);
		
		int statusCode = resp.getStatusCode();
		System.out.println("respBody is" + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = resp.getStatusLine();
		System.out.println("statusLine is" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}
