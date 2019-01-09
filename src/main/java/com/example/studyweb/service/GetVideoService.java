package com.example.studyweb.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.vod.model.v20170321.*;
import com.example.studyweb.entity.Key;
import com.example.studyweb.entity.VideoInfo;
import org.springframework.stereotype.Service;

@Service
public class GetVideoService {

    public static Key key = new Key();
    //获取上传权限
    public static CreateUploadVideoResponse createUploadVideo(DefaultAcsClient client, VideoInfo videoInfo) {
        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
        CreateUploadVideoResponse response = new CreateUploadVideoResponse();
        try {
            /*必选，视频源文件名称（必须带后缀, 支持 ".3gp", ".asf", ".avi", ".dat", ".dv", ".flv", ".f4v", ".gif", ".m2t", ".m3u8", ".m4v", ".mj2", ".mjpeg", ".mkv", ".mov", ".mp4", ".mpe", ".mpg", ".mpeg", ".mts", ".ogg", ".qt", ".rm", ".rmvb", ".swf", ".ts", ".vob", ".wmv", ".webm"".aac", ".ac3", ".acm", ".amr", ".ape", ".caf", ".flac", ".m4a", ".mp3", ".ra", ".wav", ".wma"）*/
            System.out.println(videoInfo.getVideoName());
            request.setFileName(videoInfo.getVideoName());

            //必选，视频名称
            request.setTitle(videoInfo.getTitle());
            //可选，分类ID
            //request.setCateId(videoInfo.getVideoKind());
            //可选，视频标签，多个用逗号分隔
            //request.setTags(videoInfo.getTag());
            //可选，视频描述
            //request.setDescription(videoInfo.getDescription());

            request.setTemplateGroupId("");
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            System.out.println("CreateUploadVideoRequest Server Exception:");
            e.printStackTrace();
            return null;
        } catch (ClientException e) {
            System.out.println("CreateUploadVideoRequest Client Exception:");
            e.printStackTrace();
            return null;
        }
        System.out.println("RequestId:"+response.getRequestId());
        System.out.println("UploadAuth:"+response.getUploadAuth());
        System.out.println("UploadAddress:"+response.getUploadAddress());
        key.UploadAddress = response.getUploadAddress();
        key.UploadAuth = response.getUploadAuth();
        key.VideoId = response.getVideoId();
        return response;
    }

    public static RefreshUploadVideoResponse refreshUploadVideo(DefaultAcsClient client, String videoId) {
        RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
        RefreshUploadVideoResponse response = null;
        try {
            request.setVideoId(videoId);
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            System.out.println("RefreshUploadVideoRequest Server Exception:");
            e.printStackTrace();
            return null;
        } catch (ClientException e) {
            System.out.println("RefreshUploadVideoRequest Client Exception:");
            e.printStackTrace();
            return null;
        }
        System.out.println("RequestId:" + response.getRequestId());
        System.out.println("UploadAuth:" + response.getUploadAuth());
        return response;
    }

    //初始化Client
    public static DefaultAcsClient initVodClient(String accessKeyId, String accessKeySecret) {
        //点播服务所在的Region，国内请填cn-shanghai，不要填写别的区域
        String regionId = "cn-shanghai";
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

    //获取播放URL
    public static GetPlayInfoResponse getPlayInfo(DefaultAcsClient client,String videoId) throws Exception {
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        request.setVideoId(videoId);
        return client.getAcsResponse(request);
    }
}
