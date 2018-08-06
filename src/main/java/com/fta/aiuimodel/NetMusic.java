package com.fta.aiuimodel;

import com.fta.test.MusicService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Admin on 2018/7/24
 */
public class NetMusic {
    private static int[] randoms = {1, 2, 11, 12, 16, 21, 22, 23, 24, 25};
    private MusicApi musicApi;

    public NetMusic() {
        musicApi = MusicSearch.musicNet().create(MusicApi.class);
    }

    //获取随机音乐
    public List<MusicModule.DataResult> radomMusic() throws IOException {
        Random random = new Random();
        int randomIndex = random.nextInt(randoms.length);
        Call<NetMusicBean> randomMusic = musicApi.getRandomMusic(randoms[randomIndex]);

//        try {
        NetMusicBean netMusicBean = randomMusic.execute().body();
        List<NetMusicBean.SongList> songLists = netMusicBean.getSongList();
        List<MusicModule.DataResult> musicResults = new ArrayList<>();
        for (int i = 0; i < songLists.size(); i++) {
            MusicModule.DataResult dataResult = new MusicModule.DataResult();
            NetMusicBean.SongList songList = songLists.get(i);
            ArrayList<String> authors = new ArrayList<>();
            authors.add(songList.getAuthor());
            dataResult.setSingernames(authors);
            dataResult.setSongname(songList.getTitle());
            String songId = songList.getSongId();

            Call<NetMusicPathBean> musicPath = musicApi.getMusicPath(songId);
            NetMusicPathBean body = musicPath.execute().body();
            String showLink = body.getBitrate().getShowLink();
            dataResult.setAudiopath(showLink);
            musicResults.add(dataResult);
        }
        return musicResults;
    }


    public List<MusicModule.DataResult> searchMusic(String searchName) throws IOException {
        Call<SearchMusicBean> searchMusicCall = musicApi.getSearchMusic("baidu.ting.search.catalogSug", searchName);
        SearchMusicBean searchMusic = searchMusicCall.execute().body();
        SearchMusicBean.Song song = searchMusic.getSong().get(0);
        String artistName = song.getArtistName();
        String songName = song.getSongName();
        String songId = song.getSongId();
        NetMusicPathBean searchMusicPath = musicApi.getMusicPath(songId).execute().body();
        String showLink = searchMusicPath.getBitrate().getShowLink();
        List<MusicModule.DataResult> musicResults = new ArrayList<>();
        MusicModule.DataResult dataResult = new MusicModule.DataResult();
        dataResult.setAudiopath(showLink);
        dataResult.setSongname(songName);
        List<String> singerNames = new ArrayList<>();
        singerNames.add(artistName);
        dataResult.setSingernames(singerNames);
        musicResults.add(dataResult);
        return musicResults;
    }
}
