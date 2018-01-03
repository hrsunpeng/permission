package cn.msosm.shop.service;

import java.util.List;

import cn.msosm.shop.pojo.SysPermission;
import cn.msosm.shop.pojo.SysPermissionTree; 

public interface SystemService {

	/**
	 * 根据用户标识查询菜单
	 * @param userCode
	 * @return
	 */
	public List<SysPermissionTree> findMenusByUserCode(String userCode);
 
	/**
	 * 根据用户权限
	 * @param userCode
	 * @return
	 */
	public List<String> findPermisssionByUserCode(String userCode);
}
