package com.fta.aiuimodel;

import com.fta.test.MyRetrofit;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Admin on 2018/7/24
 */
public interface MusicApi {

    @POST("/v1/restserver/ting?method=baidu.ting.billboard.billList&size=5&offset=0")
    @FormUrlEncoded
    Call<NetMusicBean> getRandomMusic(@Field("type") int type);

    @POST("/v1/restserver/ting")
    @FormUrlEncoded
    Call<SearchMusicBean> getSearchMusic(@Field("method") String method, @Field("query") String query);

    @POST("/v1/restserver/ting?method=baidu.ting.song.play")
    @FormUrlEncoded
    Call<NetMusicPathBean> getMusicPath(@Field("songid") String songid);
}
