package com.onnet.databinding.api;

import com.onnet.databinding.pojo.SingleDataItem;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


public interface Api {
    String BASE_URL = "http://134.209.148.41:8753/";
    String API_PREFIX = "epicon/api/";


    @GET(API_PREFIX + "contents/getCatalogList")
    Call<List<SingleDataItem>> getDashboardData();


}
