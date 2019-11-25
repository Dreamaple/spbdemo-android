package com.example.spd_video;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VideoApi {
    @GET("/recommend")
    Call<Object> recommend();
}
