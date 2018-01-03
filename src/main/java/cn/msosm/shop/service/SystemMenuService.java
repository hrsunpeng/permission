package cn.msosm.shop.service;

import java.util.List;

import cn.msosm.shop.pojo.SysPermissionTree;

public interface SystemMenuService {

	/**
	 * 查询菜单
	 * @return
	 */
	 List<SysPermissionTree> selectSysPermissions(Integer parentid);
	
	 
	 
}
