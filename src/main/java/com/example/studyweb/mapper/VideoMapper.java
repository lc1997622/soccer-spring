package com.example.studyweb.mapper;

import com.example.studyweb.entity.My;
import com.example.studyweb.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface VideoMapper {

    List<Video> getVideos();
    List<Video> sendVideos(String userid);
    List<Video> careVideos(String userid);
    List<Video> hotpeople(String userid);
    void studyed(String videoname,String videoid,String userid,String url,String title);
}
