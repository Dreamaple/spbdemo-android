package com.dreamaple.baseutils.network;

import android.util.Log;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class NetFactory extends Converter.Factory {
    static NetFactory create() {
        return new NetFactory();
    }

    private NetFactory() {
        super();
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Log.e("11111", String.valueOf(type == Object.class));
        if (type == Object.class) {
            return new NetFactoryConverter<Object>();
        }
        return null;
    }

    // 一个Converter类，T就是上面接口中的List了
    private static class NetFactoryConverter<T> implements Converter<ResponseBody, T> {
        NetFactoryConverter() {
        }
        //在这个方法中处理response
        @Override
        public T convert(@NonNull ResponseBody value) throws IOException {
            return (T) value.string();
        }
    }
}
