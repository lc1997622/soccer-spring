package com.example.studyweb.entity;

public class Studyed {
    String videoname;
    String videoid;
    String userid;
    String url;
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getVideoname() {
        return videoname;
    }
    public void setVideoname(String videoname)
    {
        this.videoname = videoname;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public String getVideoid() {
        return videoid;
    }
}
