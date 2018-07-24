package com.angointeam.Mosaic_Server2.Mapper;


import com.angointeam.Mosaic_Server2.SignIn.VO.UserVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("com.angointeam.Mosaic_Server2.Mapper.UserMapper")
//@Mapper
public interface UserMapper {
     @Select("SELECT * FROM User")
     List<UserVO> getUsers() throws Exception;

     @Select("INSERT INTO User(email,uuid,nickname) VALUES(#{email},#{uuid},#{nickname})")
     UserVO insert(UserVO user) throws Exception;

     @Select("SELECT * FROM User WHERE email = #{email}")
     UserVO findByEmail(String email) throws Exception;



}
