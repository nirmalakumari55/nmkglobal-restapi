package com.apex.customer.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTestNG {
	int two_hundred = 200;

	@Test
	public void testGetUserById() throws ClientProtocolException, IOException {
		HttpGet getReq = new HttpGet("https://gorest.co.in/public/v1/users/2490");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse resp = client.execute(getReq);
		

		Assert.assertEquals(resp.getStatusLine().getStatusCode(),two_hundred );
		Assert.assertEquals(resp.getStatusLine().getReasonPhrase(), "OK");

		Header[] hdrs = resp.getAllHeaders();
		for (Header header : hdrs) {
			// System.out.println(header.getName() + " :: " + header.getValue());
		}

		HttpEntity entity = resp.getEntity();
		String strResponse = EntityUtils.toString(entity);

		// Assert.assertEquals(strResponse.contains("name"), true);
		Assert.assertTrue(strResponse.contains("name"));

		/*
		 * for (int i=0; i< hdrs.length; i++) { Header header = hdrs[i];
		 * System.out.println(header.getName() + " :: " + header.getValue()); }
		 */

	}

	@Test
	public void testPostUser() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost postReq = new HttpPost("https://reqres.in/api/users");

		/*
		 * { "name": "morpheus", "job": "leader" }
		 */
		String strReq = "{" + " \"name\":\"morpheus\", " + " \"job\":\"leader\" " + "}";
		StringEntity strEntity = new StringEntity(strReq);
		postReq.setEntity(strEntity);

		HttpResponse resp = client.execute(postReq);
		Assert.assertEquals(resp.getStatusLine().getStatusCode(), 201);
		Assert.assertEquals(resp.getStatusLine().getReasonPhrase(), "Created");

	}

	@Test
	public void testPostCreateUser() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost postReq = new HttpPost("https://dummy.restapiexample.com/api/v1/create");

		String strReq = "{" + "  \"name\":\"test\", " + "\"salary\" : \"123\"  " + "\"age\" : \"23\"  " + "}";
		

		System.out.println(strReq);
		StringEntity strEntity = new StringEntity(strReq);
		postReq.setEntity(strEntity);
		HttpResponse resp = client.execute(postReq);
		
		Assert.assertEquals(resp.getStatusLine().getStatusCode(),two_hundred  );
		Assert.assertEquals(resp.getStatusLine().getReasonPhrase(), "OK");

	}

	@Test
	public void test1GetUserById() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getReq = new HttpGet("https://reqres.in/api/unknown");
		HttpResponse resp = client.execute(getReq);
		Assert.assertEquals(resp.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(resp.getStatusLine().getReasonPhrase(), "OK");

	}

	@Test
	public void test1PostUser2() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost postReq = new HttpPost("https://reqres.in/api/users");
		String strReq = "{" + "\"name\":\"morpheus\" , " + " \"job\":\"leader\"   " + "}";
		StringEntity strEntity = new StringEntity(strReq);
		postReq.setEntity(strEntity);

		HttpResponse resp = client.execute(postReq);
		Assert.assertEquals(resp.getStatusLine().getStatusCode(), 201);
		Assert.assertEquals(resp.getStatusLine().getReasonPhrase(), "Created");

	}

	@Test
	public void testPutUsers2() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPut putReq = new HttpPut("https://reqres.in/api/users/2");

/*	{
		    "name": "morpheus",
		    "job": "leader"
		}*/

		String strReq = "{" + "  \"name\":\" morpheus\", " + " \"job\":\"leader\" "  + "}";
		StringEntity strEntity = new StringEntity(strReq);
		putReq.setEntity(strEntity);
		HttpResponse resp = client.execute(putReq);
		Assert.assertEquals(resp.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(resp.getStatusLine().getReasonPhrase(), "OK");

	}

	@Test
	public void testDeleteUserById() throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete deleteReq = new HttpDelete("https://reqres.in/api/users/2");


		HttpResponse resp = client.execute(deleteReq);
		Assert.assertEquals(resp.getStatusLine().getStatusCode(), 204);
		Assert.assertEquals(resp.getStatusLine().getReasonPhrase(), "No Content");

	}
}
