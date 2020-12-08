package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.Parnetcomment;
import com.zhang.biyeseji.remeberme.pojo.ParnetcommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParnetcommentMapper {
    long countByExample(ParnetcommentExample example);

    int deleteByExample(ParnetcommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Parnetcomment record);

    int insertSelective(Parnetcomment record);

    List<Parnetcomment> selectByExample(ParnetcommentExample example);

    Parnetcomment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Parnetcomment record, @Param("example") ParnetcommentExample example);

    int updateByExample(@Param("record") Parnetcomment record, @Param("example") ParnetcommentExample example);

    int updateByPrimaryKeySelective(Parnetcomment record);

    int updateByPrimaryKey(Parnetcomment record);

    List<Parnetcomment> selectAllCommend();
}