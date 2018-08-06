package com.fta.aiuimodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 2018/7/24
 */
public class SearchMusicBean {
    private List<Song> song;

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    public static class Song {
        @SerializedName("songname")
        private String songName;
        @SerializedName("songid")
        private String songId;
        @SerializedName("artistname")
        private String artistName;

        public String getSongName() {
            return songName;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }

        public String getSongId() {
            return songId;
        }

        public void setSongId(String songId) {
            this.songId = songId;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }
    }
}
