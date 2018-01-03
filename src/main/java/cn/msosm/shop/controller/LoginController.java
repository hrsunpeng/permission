package cn.msosm.shop.controller;
 
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.msosm.shop.exception.CustomException;

/**
 * 登录退出
 * 
 * @author Administrator
 *
 */
@Controller
public class LoginController {

	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	/**
	 * 登录 登录提交的地址一定要和applicationContext-shiro.xml 中配置的loginUrl 一致
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request) throws Exception {
		// 如果登录失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限类名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		LOGGER.info("login--exceptionClassName-->" + exceptionClassName);
		// 根据shiro返回的异常类路径判断，抛出指定异常信息
		if (exceptionClassName != null) {
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				throw new CustomException("帐号不存在");
			}
			if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				throw new CustomException("用户名/密码错误");
			} 
			if(AuthenticationException.class.getName().equals(exceptionClassName)) {
				throw new CustomException("凭证错误");
			}
			else {
				throw new Exception();
			}

		}
		//此方法不处理登录成功，登录成功（认证成功） shiro认证成功会自动跳转到上一个请求路径
		return "/login";

	}

}
