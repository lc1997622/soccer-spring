package com.example.studyweb.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.example.studyweb.entity.VideoInfo;
import com.example.studyweb.service.GetVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


public class GetVideoURL {

    private static String accessKeyId = "LTAIUcAXcslQVldH";
    private static String accessKeySecret = "ZhjF7LCAIECqLtVnF3Xsm1uBZGqgDG";
    @Autowired
    GetVideoService getVideoService;

    DefaultAcsClient aliyunClient = getVideoService.initVodClient(accessKeyId,accessKeySecret);

    @GetMapping("/getkeys")
    public void getkey(){

    }
}
