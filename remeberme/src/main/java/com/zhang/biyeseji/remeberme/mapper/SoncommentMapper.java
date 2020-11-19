package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.Soncomment;
import com.zhang.biyeseji.remeberme.pojo.SoncommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SoncommentMapper {
    long countByExample(SoncommentExample example);

    int deleteByExample(SoncommentExample example);

    int insert(Soncomment record);

    int insertSelective(Soncomment record);

    List<Soncomment> selectByExample(SoncommentExample example);

    int updateByExampleSelective(@Param("record") Soncomment record, @Param("example") SoncommentExample example);

    int updateByExample(@Param("record") Soncomment record, @Param("example") SoncommentExample example);
}