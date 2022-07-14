package com.onnet.databinding.api;


import com.onnet.databinding.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient instance = null;
    private Api mApi;

    private ApiClient(String baseUrl) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        client.addInterceptor(loggingInterceptor);
        client.connectTimeout(45, TimeUnit.SECONDS);
        client.readTimeout(45, TimeUnit.SECONDS);
        client.writeTimeout(45, TimeUnit.SECONDS);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(client.build()).build();
        mApi = retrofit.create(Api.class);
    }

    public static synchronized ApiClient getInstance(String baseUrl) {
        if (instance == null) {
            instance = new ApiClient(baseUrl);
        }
        return instance;
    }



    public Api getApi() {
        return mApi;
    }
}
