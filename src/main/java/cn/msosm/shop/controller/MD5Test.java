package cn.msosm.shop.controller;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {
	public static void main(String[] args) {

		String source = "111111";
		String salt = "uiwueylm";
		int hashIterations = 1;
		/**
		 * source : 数据源 明文原始密码 salt ： 盐 hashIterations ：迭代次数 也就是加密次数 散列次数md5(md5("明文"))
		 */
		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		System.out.println(md5Hash.toString());
		// 0c4352b6d06ff36f1a795b97610da693

		// algorithmName : 散列的算法名称
		// source： 数据源 明文原始密码
		// salt：盐
		// hashIterations：迭代次数 也就是加密次数 散列次数md5(md5("明文"))
		SimpleHash simpleHash = new SimpleHash("md5", source, salt, hashIterations);
		System.out.println(simpleHash.toString());
		// 0c4352b6d06ff36f1a795b97610da693

	}
}
