package com.fta.aiuimodel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 2018/7/24
 */
public class NetMusicPathBean {

    private Bitrate bitrate;

    public Bitrate getBitrate() {
        return bitrate;
    }

    public void setBitrate(Bitrate bitrate) {
        this.bitrate = bitrate;
    }

    public static class Bitrate {
        @SerializedName("show_link")
        private String showLink;

        public String getShowLink() {
            return showLink;
        }

        public void setShowLink(String showLink) {
            this.showLink = showLink;
        }
    }
}
