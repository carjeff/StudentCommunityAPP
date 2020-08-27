package com.example.studentcommunityapp.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class Publish1 {
    private String publish_video_title; 
    private String publish_video_introduction; 
    private String publish_video_CoverMap; 
    private String publish_video_title_1; 


    public Publish1(){}
    public Publish1(String publish_video_title, String publish_video_introduction, String publish_video_CoverMap, String publish_video_title_1) {
        this.publish_video_title = publish_video_title;
        this.publish_video_introduction = publish_video_introduction;
        this.publish_video_CoverMap = publish_video_CoverMap;
        this.publish_video_title_1 = publish_video_title_1;

    }

    public Publish1(JSONObject object) throws JSONException {
        this.publish_video_title = object.optString("title", "");
        this.publish_video_introduction = object.optString("introduction", "");
        this.publish_video_CoverMap = object.optString("picture", "");
        this.publish_video_title_1 = object.optString("content", "");
    }

    public String getPublish_video_title() {
        return publish_video_title;
    }

    public void setPublish_video_title(String publish_video_title) {
        this.publish_video_title = publish_video_title;
    }

    public String getPublish_video_introduction() {
        return publish_video_introduction;
    }

    public void setPublish_video_introduction(String publish_video_introduction) {
        this.publish_video_introduction = publish_video_introduction;
    }

    public String getPublish_video_CoverMap() {
        return publish_video_CoverMap;
    }

    public void setPublish_video_CoverMap(String publish_video_CoverMap) {
        this.publish_video_CoverMap = publish_video_CoverMap;
    }

    public String getPublish_video_title_1() {
        return publish_video_title_1;
    }

    public void setPublish_video_title_1(String publish_video_title_1) {
        this.publish_video_title_1 = publish_video_title_1;
    }
}
