package com.apex.customer.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.core.test.ApiBaseTest;
import com.apex.core.test.HttpClientUtil;
import com.apex.core.test.UserApiConstants;

public class TestNG5 extends ApiBaseTest implements UserApiConstants {

	@Test
	public void test5getUsersId() throws ClientProtocolException, IOException {
		HttpGet getRequest = new HttpGet("https://reqres.in/api/users/5");

		HttpResponse resp = HttpClientUtil.sendReceive(getRequest);
		assertResponseStatus(resp, HTTP_STATUS_CODE_200, HTTP_STATUS_MESSAGE_OK);

	}

	@Test
	public void test6PostUsers() throws ClientProtocolException, IOException {
		HttpPost postReq = new HttpPost("https://reqres.in/api/users");
		HttpResponse resp = HttpClientUtil.sendReceive(postReq);

		// "name": "morpheus",
		// "job": "leader"

		String strReq = "(" + "  \"name\" :\"morpheus\"," + " \"job\":\"leader\"  " + ")";
		setRequestBody(postReq, strReq);
		assertResponseStatus(resp, HTTP_STATUS_CODE_201, HTTP_STATUS_MESSAGE_CREATED);

	}

	@Test
	public void test7PutUsers() throws ClientProtocolException, IOException {
		HttpPut putReq = new HttpPut("https://reqres.in/api/users/2");
		HttpResponse resp = HttpClientUtil.sendReceive(putReq);

		// "name": "morpheus",
		// "job": "zion resident"

		String strReq = "(" + " \"name\":\"morpheus\", " + " \"job\":\"zin resident\"  " + " )";
		setRequestBody(putReq, strReq);
		assertResponseStatus(resp, HTTP_STATUS_CODE_200, HTTP_STATUS_MESSAGE_OK);

	}

	@Test
	public void test9DeleteUsers() throws ClientProtocolException, IOException {
	}

	@DataProvider(name = "dp1")
	public Object[][] getDataForSuccess() throws Exception {
		String[][] data = getTableArray("user_ids.xls", "Sheet1", "ReqresGetData");

		return data;

	}

	@Test(dataProvider = "dp1")
	public void test7GetUserId(String c1, String c2, String c3, String c4) throws ClientProtocolException, IOException {
		HttpGet getReq = new HttpGet("https://reqres.in/api/users/5" + c1);
		HttpResponse resp = HttpClientUtil.sendReceive(getReq);

		assertResponseStatus(resp, HTTP_STATUS_CODE_200, HTTP_STATUS_MESSAGE_OK);
		String StrResp = getResponseBody(resp);

	}

	@Test
	public void test15GetUserId() throws ClientProtocolException, IOException {
		HttpGet getReq = new HttpGet("https://reqres.in/api/users?page=2");
		HttpResponse resp = HttpClientUtil.sendReceive(getReq);
		assertResponseStatus(resp, HTTP_STATUS_CODE_200, HTTP_STATUS_MESSAGE_OK);

	}

	@Test
	public void test110PostUser() throws ClientProtocolException, IOException {
		HttpPost postReq = new HttpPost("https://reqres.in/api/users");
		HttpResponse resp = HttpClientUtil.sendReceive(postReq);
		/*
		 * { "id": "284", "createdAt": "2022-02-14T18:51:18.223Z" }
		 */
		String stringReq = "(" + "\"id \" :\" 284\"," + " \"createdAt\" :\"2022-14T18:51:18.223Z\" " + ")";
		setRequestBody(postReq, stringReq);
		assertResponseStatus(resp, HTTP_STATUS_CODE_201, HTTP_STATUS_MESSAGE_CREATED);
	}

}
