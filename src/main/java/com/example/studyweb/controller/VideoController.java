package com.example.studyweb.controller;

import com.example.studyweb.entity.My;
import com.example.studyweb.entity.Studyed;
import com.example.studyweb.entity.User;
import com.example.studyweb.entity.Video;
import com.example.studyweb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;
    @RequestMapping("/videos")//热门视频
    public List<Video> lists(){
        return videoService.getVideos();
    }

    @RequestMapping("/hotwritter")
    public List<Video> hotlists(@RequestBody My my)
    {
        return videoService.hotpeople(my.getUserid());
    }
    @RequestMapping("/mysend")//我的视频
    public List<Video> sendlists(@RequestBody My my)
    {
        return videoService.sendVideos(my.getUserid());
    }

    @RequestMapping("/mycare")//我的收藏视频
    public List<Video> carelists(@RequestBody My my)
    {
        return videoService.careVideo(my.getUserid());
    }

    //@RequestMapping("/")
    @RequestMapping("/studyed")
    public void studyed(@RequestBody Studyed studyed)
    {
        videoService.studyed(studyed.getVideoname(),studyed.getVideoname(),studyed.getUserid(),studyed.getUrl(),studyed.getTitle());
    }
}
