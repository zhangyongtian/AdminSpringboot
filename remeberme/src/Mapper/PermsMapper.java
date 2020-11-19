package Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermsMapper {
    long countByExample(PermsExample example);

    int deleteByExample(PermsExample example);

    int insert(Perms record);

    int insertSelective(Perms record);

    List<Perms> selectByExample(PermsExample example);

    int updateByExampleSelective(@Param("record") Perms record, @Param("example") PermsExample example);

    int updateByExample(@Param("record") Perms record, @Param("example") PermsExample example);
}