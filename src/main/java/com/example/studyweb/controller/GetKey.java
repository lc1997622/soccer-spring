package com.example.studyweb.controller;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.example.studyweb.entity.Key;
import com.example.studyweb.entity.User;
import com.example.studyweb.entity.VideoInfo;
import com.example.studyweb.entity.login;
import com.example.studyweb.service.GetVideoService;
import com.example.studyweb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetKey {
    @Autowired
    private VideoService videoService;

    private static String accessKeyId = "LTAIUcAXcslQVldH";
    private static String accessKeySecret = "ZhjF7LCAIECqLtVnF3Xsm1uBZGqgDG";
    @Autowired
    GetVideoService getVideoService;

    DefaultAcsClient aliyunClient = new DefaultAcsClient(DefaultProfile.getProfile("cn-shanghai",accessKeyId,accessKeySecret));

    @RequestMapping("/getkey")//
    public CreateUploadVideoResponse getkey(@RequestBody VideoInfo videoInfo){

        System.out.println("LC");
        CreateUploadVideoResponse response = getVideoService.createUploadVideo(aliyunClient,videoInfo);
        System.out.println(response.getVideoId());
        try {
            GetPlayInfoResponse getPlayInfoResponse = getVideoService.getPlayInfo(aliyunClient,response.getVideoId());
            List<GetPlayInfoResponse.PlayInfo> playInfoList = getPlayInfoResponse.getPlayInfoList();
            //播放地址
            for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
                System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
                videoService.studyed(videoInfo.getVideoName(),response.getVideoId(),videoInfo.getUserid(),playInfo.getPlayURL(),videoInfo.getTitle());
                System.out.println(videoInfo.getVideoName()+response.getVideoId()+videoInfo.getUserid()+playInfo.getPlayURL());
            }

            //videoService.studyed(studyed.getVideoname(),studyed.getVideoname(),studyed.getUserid(),playInfo.getPlayURL());
            //Base信息
            System.out.print("VideoBase.Title = " + getPlayInfoResponse.getVideoBase().getTitle()+ "\n");
            System.out.print("VideoBase.Title = " + getPlayInfoResponse.getVideoBase().getVideoId() + "\n");
            System.out.print("VideoBase.Title = " + getPlayInfoResponse.getVideoBase().getCoverURL() + "\n");
            System.out.print("VideoBase.Title = " + getPlayInfoResponse.getVideoBase().getMediaType() + "\n");
        }catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
        }
        return response;
    }
}
