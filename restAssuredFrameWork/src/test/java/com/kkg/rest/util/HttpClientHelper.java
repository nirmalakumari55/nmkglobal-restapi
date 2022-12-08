package com.kkg.rest.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class HttpClientHelper {
	
	public HttpResponse httpGetCall(String url) throws IOException{
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(url);
		
		return client.execute(getRequest);
	}
	
public HttpResponse httpPostCall(String url, String jsonRequest) throws IOException{
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpPost postRequest = new HttpPost(url);
		
		StringEntity strEntity = new StringEntity(jsonRequest);
		postRequest.setEntity(strEntity);
		postRequest.setHeader("Content-Type", "application/json");
		
		
		return client.execute(postRequest);
	}

}
