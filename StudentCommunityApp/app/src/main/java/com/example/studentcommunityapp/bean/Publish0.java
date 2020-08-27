package com.example.studentcommunityapp.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class Publish0 {
    private String publish_article_title; 
    private String publish_article_introduction; 
    private String publish_article_CoverMap; 
    private String publish_article_title_1; 


    public Publish0(){}
    public Publish0(String publish_article_title, String publish_article_introduction, String publish_article_CoverMap, String publish_article_title_1) {
        this.publish_article_title = publish_article_title;
        this.publish_article_introduction = publish_article_introduction;
        this.publish_article_CoverMap = publish_article_CoverMap;
        this.publish_article_title_1 = publish_article_title_1;

    }

    public Publish0(JSONObject object) throws JSONException {
        this.publish_article_title = object.optString("title", "");
        this.publish_article_introduction = object.optString("introduction", "");
        this.publish_article_CoverMap = object.optString("picture", "");
        this.publish_article_title_1 = object.optString("content", "");
    }

    public String getPublish_article_title() {
        return publish_article_title;
    }

    public void setPublish_article_title(String publish_article_title) {
        this.publish_article_title = publish_article_title;
    }

    public String getPublish_article_introduction() {
        return publish_article_introduction;
    }

    public void setPublish_article_introduction(String publish_article_introduction) {
        this.publish_article_introduction = publish_article_introduction;
    }

    public String getPublish_article_CoverMap() {
        return publish_article_CoverMap;
    }

    public void setPublish_article_CoverMap(String publish_article_CoverMap) {
        this.publish_article_CoverMap = publish_article_CoverMap;
    }

    public String getPublish_article_title_1() {
        return publish_article_title_1;
    }

    public void setPublish_article_title_1(String publish_article_title_1) {
        this.publish_article_title_1 = publish_article_title_1;
    }
}
