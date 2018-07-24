package com.angointeam.Mosaic_Server2.Mapper;



import com.angointeam.Mosaic_Server2.Script.VO.ScriptVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("com.angointeam.Mosaic_Server2.Mapper.ScriptMapper")
//@Mapper
public interface ScriptMapper {
    @Select("SELECT * FROM Script ")
    List<ScriptVO> getScripts() throws Exception;

    @Select("INSERT INTO Script(title,content,uuid,categories) VALUES(#{title},#{content},#{uuid},#{categories})")
    ScriptVO insertScript(ScriptVO script) throws Exception;

    @Select("SELECT * FROM User WHERE index = #{index}")
    ScriptVO findScriptByIndex(int index) throws Exception;



}
