package com.fta.test;

import okhttp3.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Created by Admin on 2018/7/24
 */
public class TestRetrofit {

    public static void main(String[] args) {
        new TestRetrofit().retrofitGet();
    }

    private OkHttpClient getOkhttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .removeHeader("User-Agent")
                                .addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        return okHttpClient;
    }

    private void retrofitGet() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .client(getOkhttpClient())
//                .baseUrl("http://tingapi.ting.baidu.com/")
//                .addConverterFactory(GsonConverterFactory.create()).build();
//        MusicService musicService = retrofit.create(MusicService.class);
//        MediaType textType = MediaType.parse("text/plain");
//        RequestBody method = RequestBody.create(textType, "baidu.ting.billboard.billList");
//        RequestBody type = RequestBody.create(textType, "1");
//        RequestBody size = RequestBody.create(textType, "10");
//        RequestBody offset = RequestBody.create(textType, "0");
//        Call<Music> music = musicService.getMusic(method, type, size, offset);
//        try {
//            Response<Music> execute = music.execute();
//            Music body = execute.body();
//            System.out.println(body.getBillboard().getName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkhttpClient())
                .baseUrl("http://tingapi.ting.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MusicService musicService = retrofit.create(MusicService.class);

//        Call<Music> musicString = musicService.getMusicString(1, 10, 0);
        Call<Music> musicString = musicService.getMusicString("1", "10", "0");

//        Call<Music> musicString = musicService.getMusicGet();
//
        musicString.enqueue(new Callback<Music>() {
            @Override
            public void onResponse(Call<Music> call, Response<Music> response) {
                System.out.println("请求成功");
                if (response.isSuccessful()) {
                    Music body = response.body();
                    if (body == null) {
                        System.out.println("返回空");
                    } else {
                        String errorCode = body.getBillboard().getName();
                        System.out.println("结果是：" + errorCode);
                    }
                } else {
                    System.out.println("没有成功");
                    String message = response.message();
                    System.out.println(message);
                    ResponseBody responseBody = response.errorBody();
                    try {
                        String string = responseBody.string();
                        System.out.println(string);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void onFailure(Call<Music> call, Throwable throwable) {
                System.out.println("请求失败");
            }
        });
//        try {
//            Response<Music> execute = musicString.execute();
//            Music music = execute.body();
//            if (music != null) {
//                int body = music.getErrorCode();
//
//                System.out.println("返回东西：" + body);
//            } else {
//                System.out.println("是空");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        PostRequest_Interface request = retrofit.create(PostRequest_Interface.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<Translation1> call = request.getCall("I love you");

        try {
            Response<Translation1> execute = call.execute();
            Translation1 body = execute.body();
            String type = body.getType();
            System.out.println(type);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //步骤6:发送网络请求(异步)
//        call.enqueue(new Callback<Translation1>() {
//
//            //请求成功时回调
//            @Override
//            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
//                // 请求处理,输出结果
//                // 输出翻译的内容
//                System.out.println("翻译是：" + response.body().getTranslateResult().get(0).get(0).getTgt());
//            }
//
//            //请求失败时回调
//            @Override
//            public void onFailure(Call<Translation1> call, Throwable throwable) {
//                System.out.println("请求失败");
//                System.out.println(throwable.getMessage());
//            }
//        });
    }
}
