package com.example.studyweb.service;

import com.example.studyweb.entity.*;
import com.example.studyweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

   public User login(String userid,String password){
       User user;
       user = this.userMapper.login(userid,password);
       return user;
   }
   public User register(String userid,String password,String tel)
   {
        User user;
        user = this.userMapper.register(userid,password,tel);
        return user;
   }
   public Useruser careuser(String meid, String otherid)
   {
       Useruser people;
       people = this.userMapper.careuser(meid,otherid);
       return people;
   }

   public Uservideo carevideo(String userid,String videoid)
   {
       Uservideo thevideo;
       thevideo = this.userMapper.carevideo(userid,videoid);
       return thevideo;
   }

}
