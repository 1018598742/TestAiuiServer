package com.fta.test;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by Admin on 2018/7/24
 */
public interface MusicService {

    @POST("v1/restserver/ting")
    @Multipart
    Call<Music> getMusic(@Part("method") RequestBody method, @Part("type") RequestBody type, @Part("size") RequestBody size, @Part("offset") RequestBody offset);

    @POST("v1/restserver/ting?method=baidu.ting.billboard.billList")
    @FormUrlEncoded
    Call<Music> getMusicString(@Field("type") int type, @Field("size") int size, @Field("offset") int offset);

    @POST("v1/restserver/ting?method=baidu.ting.billboard.billList")
    @FormUrlEncoded
    Call<Music> getMusicString(@Field("type") String type, @Field("size") String size, @Field("offset") String offset);

    @GET("/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=1&offset=0")
    Call<Music> getMusicGet();
}
