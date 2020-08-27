package com.example.studentcommunityapp.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class Publish2 {
    private String publish_vf_title; 
    private String publish_vf_introduction; 
    private String publish_vf_CoverMap; 
    private String publish_vf_title_1; 


    public Publish2(){}
    public Publish2(String publish_vf_title, String publish_vf_introduction, String publish_vf_CoverMap, String publish_vf_title_1) {
        this.publish_vf_title = publish_vf_title;
        this.publish_vf_introduction = publish_vf_introduction;
        this.publish_vf_CoverMap = publish_vf_CoverMap;
        this.publish_vf_title_1 = publish_vf_title_1;

    }

    public Publish2(JSONObject object) throws JSONException {
        this.publish_vf_title = object.optString("title", "");
        this.publish_vf_introduction = object.optString("introduction", "");
        this.publish_vf_CoverMap = object.optString("picture", "");
        this.publish_vf_title_1 = object.optString("contend", "");
    }

    public String getPublish_vf_title() {
        return publish_vf_title;
    }

    public void setPublish_vf_title(String publish_vf_title) {
        this.publish_vf_title = publish_vf_title;
    }

    public String getPublish_vf_introduction() {
        return publish_vf_introduction;
    }

    public void setPublish_vf_introduction(String publish_vf_introduction) {
        this.publish_vf_introduction = publish_vf_introduction;
    }

    public String getPublish_vf_CoverMap() {
        return publish_vf_CoverMap;
    }

    public void setPublish_vf_CoverMap(String publish_vf_CoverMap) {
        this.publish_vf_CoverMap = publish_vf_CoverMap;
    }

    public String getPublish_vf_title_1() {
        return publish_vf_title_1;
    }

    public void setPublish_vf_title_1(String publish_vf_title_1) {
        this.publish_vf_title_1 = publish_vf_title_1;
    }
}
