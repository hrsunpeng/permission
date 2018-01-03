package cn.msosm.shop.controller;
  
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.msosm.shop.pojo.ActiveUser; 
  
@Controller
public class FirstController {

	private static final Logger LOGGER = Logger.getLogger(FirstController.class);
	
	
	@RequestMapping("/first")
	public String first(Model model) {
		System.out.println("first---->");
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject(); 
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal(); 
		LOGGER.info(JSONObject.toJSON(activeUser));
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser); 
		return "/first";
	}
 
}
