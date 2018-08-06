package com.fta.aiuimodel;

import java.util.List;

/**
 * Created by Admin on 2018/7/24
 */
public class MusicModule {
    private String sid;
    private int rc;
    private Data data;
    private List<Semantic> semantic;//语义集合
    private String uuid;
    private String text;
    private Answer answer;
    private String service;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Semantic> getSemantics() {
        return semantic;
    }

    public void setSemantics(List<Semantic> semantics) {
        this.semantic = semantics;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public static class Answer {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }


    public static class Semantic {
        private String intent;

        private List<SemanticSlot> slots;

        public List<SemanticSlot> getSlots() {
            return slots;
        }

        public void setSlots(List<SemanticSlot> slots) {
            this.slots = slots;
        }

        public String getIntent() {
            return intent;
        }

        public void setIntent(String intent) {
            this.intent = intent;
        }
    }

    public static class SemanticSlot {
        private String name;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class Data {
        private List<DataResult> result;

        public List<DataResult> getResult() {
            return result;
        }

        public void setResult(List<DataResult> result) {
            this.result = result;
        }
    }

    public static class DataResult {
        private String audiopath;
        private String songname;
        private List<String> singernames;

        public String getAudiopath() {
            return audiopath;
        }

        public void setAudiopath(String audiopath) {
            this.audiopath = audiopath;
        }

        public String getSongname() {
            return songname;
        }

        public void setSongname(String songname) {
            this.songname = songname;
        }

        public List<String> getSingernames() {
            return singernames;
        }

        public void setSingernames(List<String> singernames) {
            this.singernames = singernames;
        }
    }
}
