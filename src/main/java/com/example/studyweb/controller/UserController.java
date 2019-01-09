package com.example.studyweb.controller;

import com.example.studyweb.entity.*;
import com.example.studyweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/dologin")
    public User dologin(@RequestBody login user){
        //System.out.println(user.getUserid()+user.getPassword());
        return userService.login(user.getUserid(),user.getPassword());
    }
    @RequestMapping("/doregister")
    public String doregister(@RequestBody register user)
    {
         userService.register(user.getUserid(),user.getPassword(),user.getTel());
         return "OK";
    }

    @RequestMapping("/docareuser")//收藏用户
    public Useruser docareuser(@RequestBody Useruser people)
    {
        return userService.careuser(people.getMeid(),people.getOtherid());
    }
    @RequestMapping("/docarevideo")//收藏视频
    public Uservideo docarevideo(@RequestBody Uservideo uvideo)
    {
        return userService.carevideo(uvideo.getUserid(),uvideo.getVideoid());
    }

}
