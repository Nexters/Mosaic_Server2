package com.angointeam.Mosaic_Server2.SignIn.Controller;

import com.angointeam.Mosaic_Server2.Mapper.UserMapper;
import com.angointeam.Mosaic_Server2.SignIn.VO.ApiResponseMessage;
import com.angointeam.Mosaic_Server2.SignIn.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


@RestController
public class SigninController {

    @Resource(name="com.angointeam.Mosaic_Server2.Mapper.UserMapper")
    UserMapper userMapper;


    @RequestMapping(value = "/getUsers", method =  RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    private List<UserVO> getUsers() throws Exception{
        return userMapper.getUsers();
    }



    @RequestMapping(value = "/signin" ,method = RequestMethod.POST)
    @ExceptionHandler({SQLException.class,DataAccessException.class})
    public ResponseEntity<ApiResponseMessage> SignIn(@Valid @RequestBody String email) throws Exception{
        if(userMapper.findByEmail(email) != null){
            ApiResponseMessage message = new ApiResponseMessage("Fail", "", "500", "email already exist");
            return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            UserVO user = new UserVO(email,UUID.randomUUID().toString(), "asdf" );
            userMapper.insert(user);
            ApiResponseMessage message = new ApiResponseMessage("Success",user.getUuid(), "", "");
            return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
        }

    }




}
