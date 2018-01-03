package cn.msosm.shop.service.impl;
 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.msosm.shop.mapper.SysUserMapper;
import cn.msosm.shop.mapper.SystemMapper;
import cn.msosm.shop.model.ResultModel;
import cn.msosm.shop.pojo.SysPermission;
import cn.msosm.shop.pojo.SysUser;
import cn.msosm.shop.pojo.SysUserExample;
import cn.msosm.shop.service.SystemUserService;
import cn.msosm.shop.util.Common;
import cn.msosm.shop.util.MD5;
import cn.msosm.shop.util.StringUtil;

@Service
public class SystemUserServiceImpl implements SystemUserService {

	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SystemMapper systemMapper;
	
	public SysUser getSysUserByUserCode(String userCode) { 
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsercodeEqualTo(userCode);
		List<SysUser> userList = userMapper.selectByExample(example );
		if(userList.size()>0) {
			return userList.get(0);
		} 
		return null;
	}

	
	

	public List<SysPermission> getSysPermissionByPams(Map<String, Object> params) {
		List<SysPermission> resultList = systemMapper.getSysPermissionByPams(params);
		return resultList;
	}
	
	
 




	public  Map<String,Object> getUserList(Integer currentPag, Integer showPage) {
		PageHelper.startPage(currentPag, showPage); 
		SysUserExample example = new SysUserExample();
		example.createCriteria().andLockedEqualTo("0");
		example.setOrderByClause(" add_time desc ");
		List<SysUser> resultList = userMapper.selectByExample(example );
		Map<String,Object>  map = new HashMap<String, Object>();
		PageInfo info = new PageInfo(resultList);
		// 总条数
		map.put("total", info.getTotal());
		// 总页数
		map.put("pages", info.getPages());
		// 当前第几页
		System.out.println("传递出去的当前页数-->"+ (info.getPageNum()+1));
		map.put("pageNum", info.getPageNum()+1); 
		// 数据
		map.put("rows", resultList);
		
		return  map;
	}




	public SysUser checkUser(String userCode) { 
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsercodeEqualTo(userCode);
		List<SysUser> userLiset = userMapper.selectByExample(example );
		if(userLiset.size()>0) {
			return userLiset.get(0);
		} 
		return null;
	}




	public ResultModel addEntity(String username, String usercode, String locked, String description) {
		 
		SysUser record = new SysUser();
		record.setUsercode(usercode);
		record.setUsername(username);
		//密码默认123456
		String salt =StringUtil.getRandomString(6); 
		String password = MD5.getMd5Pass("123456", salt, 1);
		record.setPassword(password);
		record.setSalt(salt);
		record.setLocked(locked);
		record.setAddTime(new Date());
		record.setDescription(description);
		int count = userMapper.insertSelective(record );
		if(count>0){
			return ResultModel.build(200, "创建成功");
		}
		return ResultModel.build(500, "创建失败");
	}



	
	public ResultModel editUser(String id ,String username, String usercode, String locked, String description) { 
		SysUser record = new SysUser();
		record.setId(Integer.valueOf(id));
		record.setUsername(username);
		record.setUsercode(usercode);
		record.setLocked(locked);
		record.setDescription(description);  
		int count = userMapper.updateByPrimaryKeySelective(record );
		if(count>0) {
			return ResultModel.build(200, "修改成功");
		}
		return ResultModel.build(500, "修改失败");
	}




	public ResultModel delUser(Integer userId) {
		SysUser record = new SysUser();
		record.setId(userId);
		record.setLocked("1");
		int count = userMapper.updateByPrimaryKeySelective(record);
		if(count>0) {
			return ResultModel.build(200, "删除成功");
		}
		return ResultModel.build(500, "删除失败");
	}
	
	

}
