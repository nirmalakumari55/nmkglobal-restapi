package com.apex.customer.test;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.core.test.ApiBaseTest;
import com.apex.core.test.HttpClientUtil;
import com.apex.core.test.UserApiConstants;


public class CustomerTestNG2 extends ApiBaseTest implements UserApiConstants {
	
	@DataProvider(name ="dp1")
	public Object[][] getDataForSuccess() throws Exception{
		/* 
		 String[][] data = {
				{"1","George","Bluth", "george.bluth@reqres.in"},
				{"2","Janet", "Weaver", "janet.weaver@reqres.in"},
				{"3","Emma", "Wong", "emma.wong@reqres.in"}
		};
		*/
		
		//getTableArray(String xlFilePath, String sheetName, String tableName);
		String[][] data = getTableArray("user_ids.xls", "Sheet1", "ReqresGetData");
		//String[][] data = getTableArray("user_ids.xls", "Sheet1", "UserSuccessIds");
		
		return data;
	}

	@Test(dataProvider="dp1")
	public void testGetUserById(String c1, String c2, String c3, String c4) throws ClientProtocolException, IOException {
		HttpGet getReq = new HttpGet("https://reqres.in/api/users/" + c1);
		
		HttpResponse resp = HttpClientUtil.sendReceive(getReq);
		
		
		assertResponseStatus(resp, HTTP_STATUS_CODE_200, HTTP_STATUS_MESSAGE_OK);

		Header[] hdrs = resp.getAllHeaders();
		for (Header header : hdrs) {
			// System.out.println(header.getName() + " :: " + header.getValue());
		}

		String strResponse = getResponseBody(resp);
		//System.out.println(c1 + "-->" + strResponse);
		
		Assert.assertTrue(strResponse.contains(c1));
		Assert.assertTrue(strResponse.contains(c2));
		Assert.assertTrue(strResponse.contains(c3));
		Assert.assertTrue(strResponse.contains(c4));
	}
	
	

	@Test
	public void testPostUser() throws ClientProtocolException, IOException {

		HttpPost postReq = new HttpPost("https://reqres.in/api/users");
		String strReq = "{" + " \"name\":\"morpheus\", " + " \"job\":\"leader\" " + "}";
		
		setRequestBody(postReq, strReq);
		
				HttpResponse resp = HttpClientUtil.sendReceive(postReq);
		assertResponseStatus(resp, HTTP_STATUS_CODE_201, HTTP_STATUS_MESSAGE_CREATED);
		
		String strResponse = getResponseBody(resp);

	}
	
    @Test
	public void testPostCreateUser() throws ClientProtocolException, IOException {
		HttpPost postReq = new HttpPost("https://dummy.restapiexample.com/api/v1/create");
		String strReq = "{" + "  \"name\":\"test\", " + "\"salary\" : \"123\"  " + "\"age\" : \"23\"  " + "}";

		StringEntity strEntity = new StringEntity(strReq);
		postReq.setEntity(strEntity);

		HttpResponse resp = HttpClientUtil.sendReceive(postReq);
		assertResponseStatus(resp, HTTP_STATUS_CODE_200, HTTP_STATUS_MESSAGE_OK);
		
		String strResponse = getResponseBody(resp);
	}

	@Test
	public void test1GetUserById() throws ClientProtocolException, IOException {
		HttpGet getReq = new HttpGet("https://reqres.in/api/unknown");
		HttpResponse resp = HttpClientUtil.sendReceive(getReq);
		assertResponseStatus(resp, HTTP_STATUS_CODE_200, HTTP_STATUS_MESSAGE_OK);
		
		String strResponse = getResponseBody(resp);
	}

	@Test
	public void test1PostUsers() throws ClientProtocolException, IOException {
		HttpPost postReq = new HttpPost("https://reqres.in/api/users");
		String strReq = "{" + "\"name\":\"morpheus\" , " + " \"job\":\"leader\"   " + "}";
		StringEntity strEntity = new StringEntity(strReq);
		postReq.setEntity(strEntity);

		HttpResponse resp = HttpClientUtil.sendReceive(postReq);
		assertResponseStatus(resp, HTTP_STATUS_CODE_201, HTTP_STATUS_MESSAGE_CREATED);
		
		String strResponse = getResponseBody(resp);
	}

	@Test
	public void testPutUsers2() throws ClientProtocolException, IOException {
		HttpPut putReq = new HttpPut("https://reqres.in/api/users/2");

		String strReq = "{" + "  \"name\":\" morpheus\", " + " \"job\":\"leader\" " + "}";
		StringEntity strEntity = new StringEntity(strReq);
		putReq.setEntity(strEntity);

		HttpResponse resp = HttpClientUtil.sendReceive(putReq);
		assertResponseStatus(resp, HTTP_STATUS_CODE_200, HTTP_STATUS_MESSAGE_OK);
		
		String strResponse = getResponseBody(resp);
	}

	@Test
	public void testDeleteUserById() throws ClientProtocolException, IOException {
		HttpDelete deleteReq = new HttpDelete("https://reqres.in/api/users/2");
		
		HttpResponse resp = HttpClientUtil.sendReceive(deleteReq);
		assertResponseStatus(resp, HTTP_STATUS_CODE_204, HTTP_STATUS_MESSAGE_NOCONTENT);
		
		String strResponse = getResponseBody(resp);

	}
	
	
}
