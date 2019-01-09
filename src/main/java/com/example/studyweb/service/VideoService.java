package com.example.studyweb.service;

import com.example.studyweb.entity.My;
import com.example.studyweb.entity.Video;
import com.example.studyweb.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoMapper videoMapper;

    public List<Video> getVideos(){ return videoMapper.getVideos();}

    public List<Video> sendVideos(String userid)
    {
        return videoMapper.sendVideos(userid);
    }
    public List<Video> careVideo(String userid)
    {
        return videoMapper.careVideos(userid);
    }
    public List<Video> hotpeople(String userid)
    {
        return videoMapper.hotpeople(userid);
    }

    public void studyed(String videoname,String videoid,String userid,String url,String title){
        //System.out.println(videoname+userid);
        videoMapper.studyed(videoname,videoid,userid,url,title);
    }

}
