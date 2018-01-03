package cn.msosm.shop.controller;
 
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.msosm.shop.model.ResultModel;
import cn.msosm.shop.pojo.SysUser;
import cn.msosm.shop.service.SystemUserService;

/**
 * 用户操作
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class SystemUserController {

	private static final Logger LOGGER = Logger.getLogger(SystemUserController.class);
	
	@Autowired
	private SystemUserService userService;

	/**
	 * 账户列表
	 * 
	 * @param currentPag
	 * @param showPage
	 * @return
	 */
	@RequestMapping("/getAccounts")
	@RequiresPermissions("user:query") // 表示如果需要执行 这个方法需要 user:query 这个权限
	@ResponseBody
	public ResultModel getAccounts(@RequestParam(name = "offset", defaultValue = "1") Integer offset,
			@RequestParam(name = "limit", defaultValue = "10") Integer limit) { 
		Map<String, Object> resultList = userService.getUserList(offset, limit);
		return ResultModel.build(200, "success", resultList);
	}

	/**
	 * 新增用户页面
	 * 
	 * @return
	 */
	@RequestMapping("/addUser")
	@RequiresPermissions("user:add")
	public Object addUser() {
		return "user/addUser";
	}

	/**
	 * 新增用户
	 * 
	 * @return
	 */
	@RequestMapping("/addEntity")
	@RequiresPermissions("user:add")
	@ResponseBody
	public ResultModel addEntity(String username, String usercode, String locked, String description) {
		LOGGER.info("addEntity --username->"+username);
		LOGGER.info("addEntity --usercode->"+usercode);
		LOGGER.info("addEntity --locked->"+locked);
		LOGGER.info("addEntity --description->"+description);
		ResultModel result = userService.addEntity(username, usercode, locked, description);

		return result;

	}
 
	
	@RequestMapping("/checkUser")
	@ResponseBody
	public ResultModel checkUser(String usercode) {
		SysUser user = userService.checkUser(usercode);
		if (user != null) {
			return ResultModel.build(500, "帐号已经存在", user);
		}
		return ResultModel.build(200, "可以注册");
	}

	
	@RequestMapping("/updateUser")
	@RequiresPermissions("user:update")
	public Object updateUser(Model model,String usercode) { 
		SysUser user = userService.getSysUserByUserCode(usercode);
		model.addAttribute("user", user);
		return "user/updateUser";

	}
	
	@RequestMapping("/editUser")
	@RequiresPermissions("user:update")
	@ResponseBody
	public ResultModel editUser(String id ,String username, String usercode, String locked, String description) { 
		ResultModel  result = userService.editUser(id, username, usercode, locked, description); 
		return result; 
	}
	
	

	@RequestMapping("/delUser")
	@RequiresPermissions("user:delete")
	@ResponseBody
	public Object delUser(Integer userId) {
		ResultModel  result = userService.delUser(userId);
		return result; 

	}

}
