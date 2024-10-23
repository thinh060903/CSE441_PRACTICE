package com.example.ex22;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

public class XMLParser {
    public String getXmlFromUrl(String url) {
        String xml = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            xml = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}

