package cn.msosm.shop.mapper;

import java.util.List;
import java.util.Map;

import cn.msosm.shop.pojo.SysPermission;
import cn.msosm.shop.pojo.SysPermissionTree;
 

public interface SystemMapper {

	/**
	 * 根据用户标识查询菜单
	 * @param userCode
	 * @return
	 */
	public List<SysPermissionTree> findMenusPermisByUserCode(String userCode);
	
	/**
	 * 根据用户标识和parentId查询用户权限
	 * @param params
	 * @return
	 */
	public List<SysPermission> getSysPermissionByPams(Map<String,Object> params);
	
	
	/**
	 * 查询用户权限
	 * @param userCode
	 * @return
	 */
	List<String> findPermisssionByUserCode(String userCode);
}
