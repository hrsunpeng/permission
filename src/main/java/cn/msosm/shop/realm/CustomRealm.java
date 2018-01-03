package cn.msosm.shop.realm;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
 
import cn.msosm.shop.pojo.ActiveUser;
import cn.msosm.shop.pojo.SysPermissionTree;
import cn.msosm.shop.pojo.SysUser;
import cn.msosm.shop.service.SystemService;
import cn.msosm.shop.service.SystemUserService; 
 

/**
 * 自定义realm
 * 
 * @author Administrator
 *
 */
public class CustomRealm extends AuthorizingRealm {

	private static final Logger LOGGER = Logger.getLogger(CustomRealm.class);
	
	@Autowired
	private SystemUserService userService;
	 
	@Autowired
	private SystemService systemService;
	
	
	/**
	 * 设置realm的名称
	 */ 
	@Override
	public void setName(String name) {
		super.setName("CustomRealm");
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1.从token中取出用户身份信息
		String userCode = (String) token.getPrincipal();
		// 2.根据获取到的用户身份信息从数据库中查询该用户信息
		SysUser userInfo =null;
		try {
			  userInfo = userService.getSysUserByUserCode(userCode);
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		if(userInfo==null) {
			return null;
		}
		  
		// 模拟 从数据库中查询到的用户密码
		String dbPassword = userInfo.getPassword(); 
		LOGGER.info("dbPassword--->"+dbPassword);
		
		//数据库的盐
		String salt = userInfo.getSalt();
		LOGGER.info("salt--->"+salt);
		
		// 如果查询到了 用户身份信息 就返回 authorizationInfo
		ActiveUser activeUser = new ActiveUser();
		activeUser.setId(userInfo.getId());
		activeUser.setUserCode(userInfo.getUsercode());
		activeUser.setUserName(userInfo.getUsername());
		//用户菜单
		List<SysPermissionTree> permissions = systemService.findMenusByUserCode(userCode);
		activeUser.setPermaission(permissions);
		
		SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(activeUser, dbPassword, ByteSource.Util.bytes(salt),this.getName());
 
		return authorizationInfo;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// 从principals 这个里面获取主身份信息
		// 把getPrimaryPrincipal 方法返回的值转为真实的身份类型（也就是doGetAuthenticationInfo
		// 这个方法里面认证通过以后在SimpleAuthenticationInfo 这个里面填充的身份信息）
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();
		// 根据身份信息获取权限信息,（从数据库里查询该用户的权限）
		List<String> permissions = 	systemService.findPermisssionByUserCode(activeUser.getUserCode()); 
		
		 
		// 查到权限数据，就返回authorizationInfo授权信息(包含permissions) 
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 把数据库里查询出来的用户权限信息填充到 authorizationInfo对象里面
		authorizationInfo.addStringPermissions(permissions);

		return authorizationInfo;
	}

}
