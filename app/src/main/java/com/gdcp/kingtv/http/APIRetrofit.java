package com.gdcp.kingtv.http;

import com.gdcp.kingtv.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asus- on 2018/7/8.
 */

public class APIRetrofit{

    /**
     *  默认超时时间 单位/秒
     */
    private static final int DEFAULT_TIME_OUT = 30;
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;
    public static APIService getAPIService(){
        return getInstance().create(APIService.class);
    }

    private static Retrofit getInstance() {
        if (retrofit==null){
            synchronized (APIRetrofit.class){
                if (retrofit==null){
                    retrofit=new Retrofit.Builder()
                            .baseUrl(Constants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(getOkHttpClient())
                            .build();
                }
            }
        }
        return retrofit;
    }

    private static OkHttpClient getOkHttpClient() {
        if (okHttpClient==null){
            synchronized (APIRetrofit.class){
                if (okHttpClient==null){
                    okHttpClient=new OkHttpClient.Builder()
                            .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return okHttpClient;
    }

}
