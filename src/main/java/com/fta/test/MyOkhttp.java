package com.fta.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * Created by Admin on 2018/7/24
 */
public class MyOkhttp {

    public static void main(String[] args) {
        new MyOkhttp().myokhttp();
    }

    private void myokhttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Request request = new Request.Builder()
                .url("http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=1&offset=0")
                .removeHeader("User-Agent")
                .addHeader("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)")
                .get()
                .build();
        try {
            Response execute = okHttpClient.newCall(request).execute();
            ResponseBody body = execute.body();
            String string = body.string();
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
