package com.angointeam.Mosaic_Server2.Script.Controller;

import com.angointeam.Mosaic_Server2.Mapper.ScriptMapper;
import com.angointeam.Mosaic_Server2.Script.VO.ScriptResponseMessage;
import com.angointeam.Mosaic_Server2.Script.VO.ScriptVO;
import com.angointeam.Mosaic_Server2.SignIn.VO.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
public class SriptController {

    @Resource(name="com.angointeam.Mosaic_Server2.Mapper.ScriptMapper")
    ScriptMapper scriptMapper;


    @RequestMapping(value = "/getScripts", method =  RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    private List<ScriptVO> getScripts() throws Exception{
        return scriptMapper.getScripts();
    }



    @RequestMapping(value = "/script" ,method = RequestMethod.POST)
    public ResponseEntity<ScriptResponseMessage> SignIn(@Valid @RequestBody ScriptVO script) throws Exception{
        scriptMapper.insertScript(script);
        ScriptResponseMessage message = new ScriptResponseMessage("Success","asfd" , "", "");
        return new ResponseEntity<ScriptResponseMessage>(message, HttpStatus.OK);
    }




}
