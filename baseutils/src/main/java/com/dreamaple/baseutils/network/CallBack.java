package com.dreamaple.baseutils.network;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.dreamaple.baseutils.BaseApplication;
import com.dreamaple.baseutils.R;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallBack implements Callback<Object> {
    private ACallBack aCallBack;

    public CallBack(ACallBack aCallBack) {
        this.aCallBack = aCallBack;
    }

    @Override
    public void onResponse(@NotNull Call<Object> call, @NotNull Response<Object> response) {
//        Log.e("222222",)
        if (response.code() != 200) {
            Log.e("response.code()", String.valueOf(response.code()));
            aCallBack.failed(String.format(BaseApplication.getInstance().getString(R.string.server_exception),response.code()));
            return;
        }
        if (response.body() == null) {
            aCallBack.failed(String.format(BaseApplication.getInstance().getString(R.string.server_exception), response.code()));
            return;
        }
        String s = response.body().toString();
        JSONObject jsonObject = JSONObject.parseObject(s);
        aCallBack.successed(jsonObject);
//        BaseApplication.getInstance().Toast
    }

    @Override
    public void onFailure(@NotNull Call<Object> call,@NotNull Throwable t) {
        aCallBack.failed("网络不给力嗷");
    }

    public interface ICallBack {
        void successed(JSONObject jsonObject);
    }

    public abstract static class ACallBack implements ICallBack{
        void failed(String msg){
            BaseApplication.getInstance().spdToast(msg);
        }
    }
}
