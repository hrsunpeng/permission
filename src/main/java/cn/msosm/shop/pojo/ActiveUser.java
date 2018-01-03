package cn.msosm.shop.pojo;

import java.io.Serializable;
import java.util.List; 

public class ActiveUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int id;// 用户ID

	public String userCode;//用户标识
	
	public String userName;//用户名称
	  
	List<SysPermissionTree> permaission;//权限

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<SysPermissionTree> getPermaission() {
		return permaission;
	}

	public void setPermaission(List<SysPermissionTree> permaission) {
		this.permaission = permaission;
	}
	
	
	
	
}
