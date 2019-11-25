package com.dreamaple.baseutils.network;

import retrofit2.Retrofit;

public class NetworkUtil {
    public static Retrofit getIns(){
        Retrofit retrofit = new Retrofit.Builder()
                //设置数据解析器
//            .addConverterFactory(GsonConverterFactory.create())
                //设置网络请求的Url地址
                .baseUrl("http://192.168.0.189:8080/")
                .addConverterFactory(NetFactory.create())
                .build();
// 创建网络请求接口的实例
//        retrofit.create(APi.class);
        return retrofit;
    }
    public static Retrofit getInsBilibili(){
        Retrofit retrofit = new Retrofit.Builder()
                //设置数据解析器
//            .addConverterFactory(GsonConverterFactory.create())
                //设置网络请求的Url地址
                .baseUrl("https://api.bilibili.com")
                .addConverterFactory(NetFactory.create())
                .build();
// 创建网络请求接口的实例
//        retrofit.create(APi.class);
        return retrofit;
    }
}
