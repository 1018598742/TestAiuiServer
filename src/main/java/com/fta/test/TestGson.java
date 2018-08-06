package com.fta.test;

import com.fta.aiuimodel.MusicModule;
import com.google.gson.Gson;

/**
 * Created by Admin on 2018/7/24
 */
public class TestGson {

    public static void main(String[] args) {
        Gson gson = new Gson();
        String message = "{\n" +
                "    \"data\": {\n" +
                "        \"error\": {\n" +
                "            \"code\": 4,\n" +
                "            \"message\": \"信源未申请或不可用\"\n" +
                "        },\n" +
                "        \"result\": []\n" +
                "    },\n" +
                "    \"rc\": 3,\n" +
                "    \"semantic\": [\n" +
                "        {\n" +
                "            \"intent\": \"RANDOM_SEARCH\",\n" +
                "            \"slots\": []\n" +
                "        }\n" +
                "    ],\n" +
                "    \"service\": \"musicX\",\n" +
                "    \"uuid\": \"atn010c43df@dx00070eb227b2a10e01\",\n" +
                "    \"text\": \"播放音乐\",\n" +
                "    \"state\": {\n" +
                "        \"fg::musicX::default::default\": {\n" +
                "            \"state\": \"default\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"used_state\": {\n" +
                "        \"state_key\": \"fg::musicX::default::default\",\n" +
                "        \"state\": \"default\"\n" +
                "    },\n" +
                "    \"answer\": {\n" +
                "        \"text\": \"身体出了一点小故障，给我些时间调整\"\n" +
                "    },\n" +
                "    \"dialog_stat\": \"dataInvalid\",\n" +
                "    \"save_history\": true,\n" +
                "    \"sid\": \"atn010c43df@dx00070eb227b2a10e01\"\n" +
                "}";
        MusicModule musicModule = gson.fromJson(message, MusicModule.class);
        System.out.println(musicModule.getAnswer().getText().toString());
    }
}
