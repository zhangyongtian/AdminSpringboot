package Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogclassfiyMapper {
    long countByExample(BlogclassfiyExample example);

    int deleteByExample(BlogclassfiyExample example);

    int insert(Blogclassfiy record);

    int insertSelective(Blogclassfiy record);

    List<Blogclassfiy> selectByExample(BlogclassfiyExample example);

    int updateByExampleSelective(@Param("record") Blogclassfiy record, @Param("example") BlogclassfiyExample example);

    int updateByExample(@Param("record") Blogclassfiy record, @Param("example") BlogclassfiyExample example);
}