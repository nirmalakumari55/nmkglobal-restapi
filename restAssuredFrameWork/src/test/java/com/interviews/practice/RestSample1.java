package com.interviews.practice;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class RestSample1 {
	@Test
	public void testGet() {
		RestAssured.baseURI = "https://gorest.co.in/public-api/users";
		RequestSpecification httpRequest = RestAssured.given();
		Response resp = httpRequest.request(Method.GET, "/137");
		String respBody = resp.getBody().asString();
		System.out.println("resp body is" + respBody);
		int statusCode = resp.getStatusCode();
		System.out.println("statusCode is " + statusCode);
		Assert.assertEquals(statusCode, 200);
		String statusLine = resp.getStatusLine();
		System.out.println("status line is" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}
