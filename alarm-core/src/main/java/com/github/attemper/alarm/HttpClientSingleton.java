package com.github.attemper.alarm;

import org.apache.commons.codec.CharEncoding;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class HttpClientSingleton {

    private String APPLICATION_JSON = "application/json";

    private static volatile HttpClientSingleton singleton;

    private HttpClientSingleton() {}

    public static HttpClientSingleton getInstance() {
        if (singleton == null) {
            synchronized (HttpClientSingleton.class) {
                if (singleton == null) {
                    singleton = new HttpClientSingleton();
                }
            }
        }
        return singleton;
    }

    public String post(String url, Object paramObj){
        HttpEntityEnclosingRequestBase httpRequest = new HttpPost(url);;
        String json = BeanUtil.bean2JsonStr(paramObj);
        StringEntity strEntity = new StringEntity(json, Charset.forName(CharEncoding.UTF_8));
        strEntity.setContentType(APPLICATION_JSON);
        httpRequest.setEntity(strEntity);
        return execute(httpRequest);
    }


    /**
     * @param httpUriRequest
     * @param clazz
     * @return
     */
    private String execute(HttpUriRequest httpUriRequest) {
        CloseableHttpClient httpClient = null;
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        try {
            httpClient = httpClientBuilder.build();
            HttpResponse response = httpClient.execute(httpUriRequest);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(response.getEntity());
            } else {
                throw new RuntimeException(response.getStatusLine().getStatusCode() + ":" + response.getStatusLine().getReasonPhrase());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(httpClient != null){
                    httpClient.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
