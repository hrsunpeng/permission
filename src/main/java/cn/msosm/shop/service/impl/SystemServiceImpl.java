package cn.msosm.shop.service.impl;
 
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import cn.msosm.shop.mapper.SystemMapper;
import cn.msosm.shop.pojo.SysPermission;
import cn.msosm.shop.pojo.SysPermissionTree;
import cn.msosm.shop.service.SystemService; 
import cn.msosm.shop.util.TreeUtil;

@Service
public class SystemServiceImpl implements SystemService {

	@Autowired
	private SystemMapper systemMapper;
	
	
	
	public List<SysPermissionTree> findMenusByUserCode(String userCode) {
 		List<SysPermissionTree> resultList = systemMapper.findMenusPermisByUserCode(userCode); 
		TreeUtil treeUtil = new TreeUtil();
		List<SysPermissionTree> ns = treeUtil.getChildTreeObjects(resultList, 0); 
		return ns;
	}

 
	public List<String> findPermisssionByUserCode(String userCode) {
		List<String> resultList = systemMapper.findPermisssionByUserCode(userCode);
		return resultList;
	}

}
