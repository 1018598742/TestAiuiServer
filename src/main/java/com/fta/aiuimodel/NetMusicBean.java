package com.fta.aiuimodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 2018/7/24
 */
public class NetMusicBean {
    @SerializedName("song_list")
    private List<SongList> songList;

    public List<SongList> getSongList() {
        return songList;
    }

    public void setSongList(List<SongList> songList) {
        this.songList = songList;
    }

    public static class SongList {
        @SerializedName("song_id")
        private String songId;
        private String author;
        private String title;

        public String getSongId() {
            return songId;
        }

        public void setSongId(String songId) {
            this.songId = songId;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
