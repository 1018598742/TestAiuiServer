package com.fta.aiuimodel;

import com.fta.utils.Base64Util;
import com.google.gson.Gson;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Admin on 2018/7/24
 */
public class AiuiModel {

    private String message;

    public AiuiModel(HttpServletRequest request) throws IOException {
        // 获取HTTP body
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
        StringBuffer stringBuffer = new StringBuffer("");
        String temp = "";
        while ((temp = bufferedReader.readLine()) != null) {
            stringBuffer.append(temp);
        }
        String message = stringBuffer.toString();//获取得到的信息
        Gson gson = new Gson();
        AiuiServerBean aiuiServerBean = gson.fromJson(message, AiuiServerBean.class);
        String content = aiuiServerBean.getMsg().getContent();
        this.message = Base64Util.base64decode(content);
    }

    public String responseString() {
        Gson gson = new Gson();
        String responseMessage = this.message;
        AiuiResponseBean aiuiResponseBean = gson.fromJson(message, AiuiResponseBean.class);
        if ("musicX".equals(aiuiResponseBean.getIntent().getService())) {
            //重新配置音乐内容
            //解析aiui传回的信息
            NetMusic netMusic = new NetMusic();
            List<MusicModule.DataResult> dataResults = new ArrayList<>();
            MusicResponeBean musicResponeBean = gson.fromJson(message, MusicResponeBean.class);
            MusicModule musicModule = musicResponeBean.getIntent();
            String intent = musicModule.getSemantics().get(0).getIntent();
            switch (intent) {
                case "PLAY":
                    try {
                        List<MusicModule.SemanticSlot> slots = musicModule.getSemantics().get(0).getSlots();
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < slots.size(); i++) {
                            stringBuilder.append(slots.get(i).getValue());
                        }
                        dataResults = netMusic.searchMusic(stringBuilder.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "RANDOM_SEARCH":
                    try {
                        dataResults = netMusic.radomMusic();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }

            MusicModule.Data data = new MusicModule.Data();
            data.setResult(dataResults);
            musicModule.setData(data);
            musicResponeBean.setIntent(musicModule);
            responseMessage = gson.toJson(musicResponeBean);

            return responseMessage;
        } else {
            return responseMessage;
        }
    }
}
