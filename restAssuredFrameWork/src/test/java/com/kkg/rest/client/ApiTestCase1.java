package com.kkg.rest.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kkg.rest.util.HttpClientHelper;

public class ApiTestCase1 {

	@Test
	public void testcase_get_user_by_id() throws IOException {
		HttpClientHelper clientHelper = new HttpClientHelper();
		HttpResponse httpResponse = clientHelper.httpGetCall("https://reqres.in/api/users/2");

		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(httpResponse.getStatusLine().getReasonPhrase(), "OK");

		HttpEntity httpEntity = httpResponse.getEntity();

		if (httpEntity != null) {
			String strResponse = EntityUtils.toString(httpEntity);
			System.out.println("GET response : " + strResponse);

			JSONObject jsonResponse = new JSONObject(strResponse);
			/*
			{
			    "data": {
			        "id": 2,
			        "email": "janet.weaver@reqres.in",
			        "first_name": "Janet",
			        "last_name": "Weaver",
			        "avatar": "https://reqres.in/img/faces/2-image.jpg"
			    },
			    "support": {
			        "url": "https://reqres.in/#support-heading",
			        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
			    }
			}
			 */
			Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("id"), 2);
			Assert.assertEquals(jsonResponse.getJSONObject("data").getString("email"), "janet.weaver@reqres.in");
			Assert.assertEquals(jsonResponse.getJSONObject("data").getString("first_name"), "Janet");

			Assert.assertEquals(jsonResponse.getJSONObject("support").getString("url"),
					"https://reqres.in/#support-heading");
		}
	}

	@Test
	public void testcase_post_user_login() throws IOException {
		HttpClientHelper clientHelper = new HttpClientHelper();
		/*
		HashMap dataMap = new HashMap();
		dataMap.put("email","evo.holt@regres.in");
		dataMap.put("password","cityslicka");
		
		JSONObject jsonResponse = new JSONObject(strPostRequest);
		*/
		
		String strPostRequest = "{" +
								"	\"email\":\"evo.holt@regres.in\"," +
								"	\"password\":\"cityslicka\"" +
							"}";
		
		
		System.out.println("POST request" + strPostRequest);
		JSONObject jsonResponse = new JSONObject(strPostRequest);
		
		System.out.println("POST request2" + jsonResponse.toString());
		
		HttpResponse httpResponse = clientHelper.httpPostCall("https://reqres.in/api/login", jsonResponse.toString());
		HttpEntity httpEntity = httpResponse.getEntity();

		if (httpEntity != null) {
			String strResponse = EntityUtils.toString(httpEntity);
			System.out.println("Post response : " + strResponse);
		}
		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(httpResponse.getStatusLine().getReasonPhrase(), "OK");
	}

}
