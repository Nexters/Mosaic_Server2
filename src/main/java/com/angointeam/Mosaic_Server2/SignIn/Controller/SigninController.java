package com.angointeam.Mosaic_Server2.SignIn.Controller;

import com.angointeam.Mosaic_Server2.Mapper.UserMapper;
import com.angointeam.Mosaic_Server2.SignIn.VO.SigninResponseMessage;
import com.angointeam.Mosaic_Server2.SignIn.VO.UserVO;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SigninResponseMessage> SignIn(@Valid @RequestBody String email) throws Exception{
        if(userMapper.findUserByEmail(email) != null){
            SigninResponseMessage message = new SigninResponseMessage("Fail", "", "500", "email already exist");
            return new ResponseEntity<SigninResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            UserVO user = new UserVO(email,UUID.randomUUID().toString(), "asdf" );
            userMapper.insertUser(user);
            SigninResponseMessage message = new SigninResponseMessage("Success",user.getUuid(), "", "");
            return new ResponseEntity<SigninResponseMessage>(message, HttpStatus.OK);
        }

    }




}
