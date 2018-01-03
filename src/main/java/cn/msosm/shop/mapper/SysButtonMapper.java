package cn.msosm.shop.mapper;

import cn.msosm.shop.pojo.SysButton;
import cn.msosm.shop.pojo.SysButtonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysButtonMapper {
    int countByExample(SysButtonExample example);

    int deleteByExample(SysButtonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysButton record);

    int insertSelective(SysButton record);

    List<SysButton> selectByExample(SysButtonExample example);

    SysButton selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysButton record, @Param("example") SysButtonExample example);

    int updateByExample(@Param("record") SysButton record, @Param("example") SysButtonExample example);

    int updateByPrimaryKeySelective(SysButton record);

    int updateByPrimaryKey(SysButton record);
}