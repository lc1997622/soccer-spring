package com.example.studyweb.mapper;

import com.example.studyweb.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

   User login(String userid,String password);
   User register(String userid,String password,String tel);
   Useruser careuser(String meid, String otherid);
   Uservideo carevideo(String userid,String videoid);
}
