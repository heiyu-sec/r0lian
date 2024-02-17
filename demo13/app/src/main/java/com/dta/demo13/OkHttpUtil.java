package com.dta.demo13;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {

    static OkHttpClient client = null;
    public static InputStream in_cer = null;

    private static OkHttpClient getClient(){
        if (client == null){
            try {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                return builder.build();
            }catch (Exception e){
                return null;
            }
        }
        return client;
    }

    public static void post(String url, Map<String, String> headers, String body, Callback callback) {
        Request.Builder requestBuilder = new Request.Builder()
                .url(url);
        for (String key : headers.keySet()){
            requestBuilder.addHeader(key,headers.get(key));
        }
        //FormBody formBody = new FormBody.Builder().
        try {
            RequestBody requestBody = RequestBody.create(body.getBytes("UTF-8"));
            Request request = requestBuilder.post(requestBody).build();
            getClient().newCall(request).enqueue(callback);
        }catch (Exception e){

        }

    }
}
