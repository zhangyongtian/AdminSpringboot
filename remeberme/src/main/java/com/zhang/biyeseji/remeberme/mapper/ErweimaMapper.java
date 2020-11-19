package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.Erweima;
import com.zhang.biyeseji.remeberme.pojo.ErweimaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErweimaMapper {
    long countByExample(ErweimaExample example);

    int deleteByExample(ErweimaExample example);

    int insert(Erweima record);

    int insertSelective(Erweima record);

    List<Erweima> selectByExample(ErweimaExample example);

    int updateByExampleSelective(@Param("record") Erweima record, @Param("example") ErweimaExample example);

    int updateByExample(@Param("record") Erweima record, @Param("example") ErweimaExample example);
}