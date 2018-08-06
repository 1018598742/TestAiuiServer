package com.fta.aiuimodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 2018/7/24
 */
public class AiuiServerBean {
    @SerializedName("Msg")
    private ServerMsg msg;

    public ServerMsg getMsg() {
        return msg;
    }

    public void setMsg(ServerMsg msg) {
        this.msg = msg;
    }

    public static class ServerMsg {
        @SerializedName("Content")
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
