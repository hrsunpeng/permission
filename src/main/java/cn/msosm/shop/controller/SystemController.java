package cn.msosm.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

import cn.msosm.shop.pojo.ActiveUser;
import cn.msosm.shop.pojo.SysPermission;
import cn.msosm.shop.service.SystemUserService;
import cn.msosm.shop.util.Common;

/**
 * 系统管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/system")
public class SystemController {

	private static final Logger LOGGER = Logger.getLogger(SystemController.class);

	@Autowired
	private SystemUserService userService;

	/**
	 * 账户管理
	 * 
	 * @return
	 */
	@RequestMapping("/accounts")
	@RequiresPermissions("user:query") // 表示如果需要执行 这个方法需要 user:query 这个权限
	public String accounts(String parentId, Model model) {

		// 获取登录用户信息和传递参数
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 用户唯一编码
		String userCode = activeUser.getUserCode();
		// 根据UserCode查询权限内的按钮
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userCode", userCode);
		params.put("parentId", parentId);
		List<SysPermission> resultList = userService.getSysPermissionByPams(params);
		List<SysPermission> finalList = new ArrayList<SysPermission>();
		for (SysPermission sysPermission : resultList) {
			String description = sysPermission.getDescription();
			if (!StringUtils.isEmpty(description)) {
				LOGGER.info("description--->" + JSONObject.toJSONString(description));
				String str = Common.stringtohtml(description);
				sysPermission.setDescription(str);
				finalList.add(sysPermission);
			}
		}
		model.addAttribute("perm", finalList);
		return "user/accounts";

	}

	/**
	 * 菜单管理
	 * 
	 * @return
	 */
	@RequestMapping("/menus")
	public Object menus(String parentId, Model model) {
		// 获取登录用户信息和传递参数
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal(); 
		// 用户唯一编码
		String userCode = activeUser.getUserCode();
		// 根据UserCode查询权限内的按钮
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userCode", userCode);
		params.put("parentId", parentId);
		List<SysPermission> resultList = userService.getSysPermissionByPams(params);
		List<SysPermission> finalList = new ArrayList<SysPermission>();
		for (SysPermission sysPermission : resultList) {
			String description = sysPermission.getDescription();
			if (!StringUtils.isEmpty(description)) {
				LOGGER.info("description--->" + JSONObject.toJSONString(description));
				String str = Common.stringtohtml(description);
				sysPermission.setDescription(str);
				finalList.add(sysPermission);
			}
		}
		model.addAttribute("perm", finalList);

		return "menu/menus";

	}

}
