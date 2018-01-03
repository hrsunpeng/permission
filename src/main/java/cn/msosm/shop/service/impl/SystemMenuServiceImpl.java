package cn.msosm.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.msosm.shop.mapper.SysPermissionMapper; 
import cn.msosm.shop.pojo.SysPermissionTree;
import cn.msosm.shop.service.SystemMenuService;
import cn.msosm.shop.util.TreeUtil;

@Service
public class SystemMenuServiceImpl implements SystemMenuService {

	@Autowired
	private SysPermissionMapper permissionMapper;

	public List<SysPermissionTree> selectSysPermissions(Integer parentid) {
		List<SysPermissionTree> resultList = permissionMapper.selectPermissions(parentid);
		List<SysPermissionTree> ns = null;
		if (resultList.size() > 0) {
			TreeUtil treeUtil = new TreeUtil();
			if(parentid==null) {
				parentid = 0;
			}
			ns = treeUtil.getChildTreeObjects(resultList, parentid);
		}

		return ns;
	}

 

}
