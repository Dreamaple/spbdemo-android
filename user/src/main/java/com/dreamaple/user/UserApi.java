package com.dreamaple.user;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserApi {
    @POST("user/register")
    @FormUrlEncoded
    Call<Object> register(@Field("username") String username,
                          @Field("nickname") String nickname,
                          @Field("pwd") String pwd,
                          @Field("sex") String sex,
                          @Field("tel") String tel,
                          @Field("birth") String birth,
                          @Field("email") String email,
                          @Field("signature") String signature,
                          @Field("local") String local);

    @GET("home/index")
    Call<Object> index();


    @GET("/recommend")
    Call<Object> recommend();
}
