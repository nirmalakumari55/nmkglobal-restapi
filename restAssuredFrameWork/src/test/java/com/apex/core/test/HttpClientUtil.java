package com.apex.core.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientUtil {

	public static HttpResponse sendReceive(HttpUriRequest request) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(request);
		return response;
	}
}
