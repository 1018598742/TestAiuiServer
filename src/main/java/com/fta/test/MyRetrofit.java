package com.fta.test;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import java.io.IOException;

/**
 * Created by Admin on 2018/7/24
 */
public class MyRetrofit {

    public static final String API_URL = "http://tingapi.ting.baidu.com";

    public static class Billboard {
        public final String name;

        public Billboard(String name) {
            this.name = name;
        }
    }

    public static class MusicBean {
        public final Billboard billboard;

        public MusicBean(Billboard billboard) {
            this.billboard = billboard;
        }
    }


    public interface MusicApi {
        @GET("/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=1&offset=0")
        Call<MusicBean> contributors();
    }

    /**
     * 构造okhttp头部
     */
    private static OkHttpClient getOkHttpClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .removeHeader("User-Agent")//移除旧的
                                .addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)")//添加真正的头部
                                .build();
                        return chain.proceed(request);
                    }
                }).build();
        return httpClient;
    }

    public static void main(String[] args) throws IOException {

        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        MusicApi musicApi = retrofit.create(MusicApi.class);

        Call<MusicBean> musicBeanCall = musicApi.contributors();
        Response<MusicBean> execute = musicBeanCall.execute();
        MusicBean body = execute.body();
        if (body == null) {
            System.out.println("空");
        } else {
            System.out.println("不空");
            String name = body.billboard.name;
            System.out.println("名字:" + name);
        }
    }

}
