package com.fta.test;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 2018/7/24
 */
public class Music {

    private Billboard billboard;

    public Billboard getBillboard() {
        return billboard;
    }

    public void setBillboard(Billboard billboard) {
        this.billboard = billboard;
    }

    public static class Billboard {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
