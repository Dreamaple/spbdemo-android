package com.dreamaple.spbdemo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MainApi {
    @GET("home/index")
    Call<Object> index();
}
