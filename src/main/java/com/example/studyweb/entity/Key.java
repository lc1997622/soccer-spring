package com.example.studyweb.entity;

public class Key {
    public String UploadAuth;
    public String UploadAddress;
    public String VideoId;

    public String getUploadAddress() {
        return UploadAddress;
    }

    public String getUploadAuth() {
        return UploadAuth;
    }

    public String getVideoId() {
        return VideoId;
    }

    public void setUploadAddress(String uploadAddress) {
        UploadAddress = uploadAddress;
    }

    public void setUploadAuth(String uploadAuth) {
        UploadAuth = uploadAuth;
    }

    public void setVideoId(String videoId) {
        VideoId = videoId;
    }
}
