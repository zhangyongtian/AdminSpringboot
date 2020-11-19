package Mapper;

import com.zhang.biyeseji.remeberme.pojo.Blogtags;
import com.zhang.biyeseji.remeberme.pojo.BlogtagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogtagsMapper {
    long countByExample(BlogtagsExample example);

    int deleteByExample(BlogtagsExample example);

    int insert(Blogtags record);

    int insertSelective(Blogtags record);

    List<Blogtags> selectByExample(BlogtagsExample example);

    int updateByExampleSelective(@Param("record") Blogtags record, @Param("example") BlogtagsExample example);

    int updateByExample(@Param("record") Blogtags record, @Param("example") BlogtagsExample example);
}