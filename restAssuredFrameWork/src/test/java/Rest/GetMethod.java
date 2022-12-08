package Rest;

import java.io.IOException;
import java.net.http.HttpRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class GetMethod {
	public void testGetUsersId() throws ClientProtocolException, IOException {
		HttpGet getReq = new HttpGet("https://reqres.in/api/users/2");

		HttpClient client = HttpClientBuilder.create().build();
		
		HttpResponse resp = client.execute(getReq);
		Assert.assertEquals(resp.getStatusLine().getStatusCode(), 200);
		Assert.assertEquals(resp.getStatusLine().getReasonPhrase(), "OK");

	}

	// TODO Auto-generated method stub

	

	private Object getStatusLine() {
		// TODO Auto-generated method stub
		return null;
	}

}
