package cn.msosm.shop.mapper;

import cn.msosm.shop.pojo.SysUserPermission;
import cn.msosm.shop.pojo.SysUserPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserPermissionMapper {
    int countByExample(SysUserPermissionExample example);

    int deleteByExample(SysUserPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserPermission record);

    int insertSelective(SysUserPermission record);

    List<SysUserPermission> selectByExample(SysUserPermissionExample example);

    SysUserPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUserPermission record, @Param("example") SysUserPermissionExample example);

    int updateByExample(@Param("record") SysUserPermission record, @Param("example") SysUserPermissionExample example);

    int updateByPrimaryKeySelective(SysUserPermission record);

    int updateByPrimaryKey(SysUserPermission record);
}