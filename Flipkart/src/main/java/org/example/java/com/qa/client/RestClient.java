package com.qa.client;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
   //	1 get method
	public void get(String url) throws ClientProtocolException, IOException {
	CloseableHttpClient	httpclient =HttpClients.createDefault();
      HttpGet httpget = new HttpGet(url);  // http get request
     CloseableHttpResponse closeablehttpresponse=httpclient.execute(httpget); //hit the get url
     
     //a. status code
       int statuscode =  closeablehttpresponse.getStatusLine().getStatusCode();
       System.out.println("status code----" + statuscode);
    
       //b.  json string
     String responseString = EntityUtils.toString(closeablehttpresponse.getEntity(), "UTF-8");
     JSONObject responsejson = new JSONObject(responseString);
     System.out.println("response json from api-----" +responsejson);
     
     // all headers
     Header[] headersarray = closeablehttpresponse.getAllHeaders();
     HashMap<String,String> allheaders = new HashMap<String,String>();
     for(Header header : headersarray) {
    	 allheaders.put(header.getName(), header.getValue());
     }
     System.out.println("headers array ----" +allheaders);
     
     
	}

}
