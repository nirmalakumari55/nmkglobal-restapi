package com.kkg.rest.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JsonObject;

public class GetSample1 {

	
	
	public void testGet() {
		
		Response resp = RestAssured.get("https://gorest.co.in/public/v1/users");
		
		int statusCode = resp.getStatusCode();
		String strResp = resp.asString();
		
		System.out.println("Status code GET =" + statusCode);
		
		System.out.println("--------------------------");
		System.out.println(strResp);
		System.out.println("--------------------------");
		
		Assert.assertEquals(statusCode, 200);
		

	}
	
	
	public void testPost() {
		RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		
		JsonObject requestObj = new JsonObject();
		requestObj.put("name", "Kkg"); 
		requestObj.put("salary", "120000");
		requestObj.put("age", "38");
		
		// Add the Json to the body of the request
		request.body(requestObj.toJson());
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Post the request and check the response
		Response response = request.post("/create");
		
		
		int statusCode = response.getStatusCode();
		String strResp = response.asString();
		
		System.out.println("Status code POST =" + statusCode);
		
		System.out.println("--------------------------");
		System.out.println(strResp);
		System.out.println("--------------------------");
		
		Assert.assertEquals(statusCode, 200);
		

	}
	
	@Test
	public void testPost1() {
		//https://reqres.in/
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		
		JsonObject requestObj = new JsonObject();
		requestObj.put("name","ss");
		requestObj.put("number"," 45");
		requestObj.put("id","9");
		
		request.body(requestObj.toJson());
		request.header("Cantent-Type","application/Json");
		
		Response response = request.post("/create");
		
		int statusCode = response.getStatusCode();
		String strResp = response.asString();
		
		System.out.println("Status Code Post2 is " + statusCode);
		Assert.assertEquals(statusCode,200);
		
	}
	
	@Test
	public void testGetSample() {
		Response resp =  RestAssured.get("https://reqres.in/api/users/2");
			int statusCode = resp.getStatusCode();
			String strResp = resp.asString();
			System.out.println("Status Code GET" + statusCode);
			  
			
			
			System.out.println(strResp);
		
	}
	
	/*
	@DataProvider
	public Object[][] getDataforSuccess(){
		String[][]data = {
			{"1", "john"},
			{"2", "ss"}
			
			
			
		
		
	};
		return data;
	
	}
	
	
	@Test(dataprovider = "dp1")
	pupbli void testGETUserWith SuccessData(String id, String name)throws clientProtocalException, IdException{
		
	}
	*/
	
	/*
	@Test
	public void testSample1() {
		
		System.out.println("sssssssssssssssss Sample1");
		Assert.assertEquals(400, 400);
		Assert.assertEquals(300, 300);
	}
	
	@Test
	public void testSample2() {
		Assert.assertEquals(500, 500);
		System.out.println("sssssssssssssssss Sample2");
		Assert.assertEquals(300, 400);
	}
	*/
	
}