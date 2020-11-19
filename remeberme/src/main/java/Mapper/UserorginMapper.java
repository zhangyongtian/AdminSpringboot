package Mapper;

import com.zhang.biyeseji.remeberme.pojo.Userorgin;
import com.zhang.biyeseji.remeberme.pojo.UserorginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserorginMapper {
    long countByExample(UserorginExample example);

    int deleteByExample(UserorginExample example);

    int insert(Userorgin record);

    int insertSelective(Userorgin record);

    List<Userorgin> selectByExample(UserorginExample example);

    int updateByExampleSelective(@Param("record") Userorgin record, @Param("example") UserorginExample example);

    int updateByExample(@Param("record") Userorgin record, @Param("example") UserorginExample example);
}