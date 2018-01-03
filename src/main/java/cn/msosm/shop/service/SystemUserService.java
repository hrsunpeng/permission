package cn.msosm.shop.service;

import java.util.List;
import java.util.Map;

import cn.msosm.shop.model.ResultModel;
import cn.msosm.shop.pojo.SysPermission;
import cn.msosm.shop.pojo.SysUser;

public interface SystemUserService {

	/**
	 * 查询用户
	 * @param userCode
	 * @return
	 */
	public SysUser getSysUserByUserCode(String userCode);
	
	/**
	 * 获取用户权限按钮
	 * @param params
	 * @return
	 */
	public List<SysPermission> getSysPermissionByPams(Map<String,Object> params);
	
	/**+
	 * 用户列表
	 * @param currentPag
	 * @param showPage
	 * @return
	 */
	public Map<String,Object> getUserList(Integer currentPag,Integer showPage);
	
	/**
	 * 判断帐号是否存在
	 * @param userCode
	 * @return
	 */
	public SysUser checkUser(String userCode);
	/**
	 * 新增用户
	 * @param username
	 * @param usercode
	 * @param locked
	 * @param description
	 * @return
	 */
	public ResultModel addEntity(String username,String usercode,String locked,String description) ;
	
	/**
	 * 修改用户
	 * @param username
	 * @param usercode
	 * @param locked
	 * @param description
	 * @return
	 */
	public ResultModel editUser(String id ,String username, String usercode, String locked, String description);
	
	public ResultModel delUser(Integer userId);
	
	
}
