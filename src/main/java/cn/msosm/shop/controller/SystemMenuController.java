package cn.msosm.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import cn.msosm.shop.model.ResultModel;
import cn.msosm.shop.pojo.SysPermissionTree;
import cn.msosm.shop.service.SystemMenuService;

@Controller
@RequestMapping("/menu")
public class SystemMenuController {

	private static final Logger LOGGER = Logger.getLogger(SystemMenuController.class);
	@Autowired
	private SystemMenuService menuService;

	@RequestMapping("/list")
	@ResponseBody
	public ResultModel list(Integer parentId) { 
		List<SysPermissionTree> reusltList = menuService.selectSysPermissions(parentId); 
		Map<String,Object>  map = new HashMap<String, Object>();
		PageInfo info = new PageInfo(reusltList);
		// 总条数
		map.put("total", info.getTotal()); 
		// 数据
		map.put("rows", reusltList); 
		LOGGER.info("map--->"+JSONObject.toJSONString(map));
		
		return ResultModel.build(200, "success",map);

	}
	
	@RequestMapping("/addMenu")
	public Object addMenu(Model model) { 
		List<SysPermissionTree> reusltList = menuService.selectSysPermissions(null);
		model.addAttribute("permissions", reusltList); 
		return "menu/add";
		
		
	}
	
	@RequestMapping("/getAllPermissions")
	@ResponseBody
	public ResultModel getAllPermissions() { 
		List<SysPermissionTree> reusltList = menuService.selectSysPermissions(null);
		return ResultModel.build(200, "SUCCESS", reusltList);
		
	}
	
	
	
	
	
	
	
	

}
