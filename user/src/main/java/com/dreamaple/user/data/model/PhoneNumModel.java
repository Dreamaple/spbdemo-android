package com.dreamaple.user.data.model;

import androidx.lifecycle.LiveData;

import com.alibaba.fastjson.JSONObject;

/**
 * @date 2019年11月29日10:30:04
 * @author dreamaple
 */
@SuppressWarnings(value = "unused")
public class PhoneNumModel extends LiveData<PhoneNumModel> {
    private JSONObject jsonObject;

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        postValue(this);
    }
}
