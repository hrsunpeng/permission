package cn.msosm.shop.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 自定义realm
 * 
 * @author Administrator
 *
 */
public class CustomRealmMD5 extends AuthorizingRealm {

	/**
	 * 设置realm的名称
	 */
	@Override 
	public void setName(String name) {
		super.setName("customRealmMD5");
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		System.out.println("CustomRealmMD5");
		
		// 1.从token中取出用户身份信息
		String userCode = (String) token.getPrincipal();
		// 2.根据获取到的用户身份信息从数据库中查询该用户信息

		// 模拟 从数据库中查询到的用户密码 是加密后的密码
		String password = "0c4352b6d06ff36f1a795b97610da693";

		// 从数据库中获取的盐
		String salt = "qwe";

		// 如果查询到了 用户身份信息 就返回 authorizationInfo

		SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(userCode, password,
				ByteSource.Util.bytes(salt), this.getName());

		return authorizationInfo;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	 
		return null;
	}

}
