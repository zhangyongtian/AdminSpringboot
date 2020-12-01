package com.zhang.biyeseji.remeberme.mapper;

import com.zhang.biyeseji.remeberme.pojo.Useryonghu;
import com.zhang.biyeseji.remeberme.pojo.UseryonghuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UseryonghuMapper {
    long countByExample(UseryonghuExample example);

    int deleteByExample(UseryonghuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Useryonghu record);

    int insertSelective(Useryonghu record);

    List<Useryonghu> selectByExample(UseryonghuExample example);

    Useryonghu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Useryonghu record, @Param("example") UseryonghuExample example);

    int updateByExample(@Param("record") Useryonghu record, @Param("example") UseryonghuExample example);

    int updateByPrimaryKeySelective(Useryonghu record);

    int updateByPrimaryKey(Useryonghu record);

    Useryonghu selectUseryonghuByname(String username);

    Useryonghu selectUseryonghuByEmail(String useremail);

    void upateByUserEmail(String userEmail, String userpassword);

    List<Useryonghu> selectAllUseryonghu();
}