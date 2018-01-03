package cn.msosm.shop.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.msosm.shop.pojo.SysPermissionTree;
 
/**
 * 把一个list集合,里面的bean含有 parentId 转为树形式
 * @author Administrator
 *
 */
public class TreeUtil {

 
	/**
	 * 根据父节点的ID获取所有子节点
	 * @param list 分类表
	 * @param typeId 传入的父节点ID
	 * @return String
	 */
	public  List<SysPermissionTree> getChildTreeObjects(List<SysPermissionTree> list,int praentId) {
		List<SysPermissionTree> returnList = new ArrayList<SysPermissionTree>();
		for (Iterator<SysPermissionTree> iterator = list.iterator(); iterator.hasNext();) {
			SysPermissionTree t = (SysPermissionTree) iterator.next();
			// 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (t.getParentid().equals(praentId)) {
				recursionFn(list, t);
				returnList.add(t);
			}
		}
		return returnList;
	}
	
	/**
	 * 递归列表
	 * @param list
	 * @param SysPermissionTree
	 */
	private void  recursionFn(List<SysPermissionTree> list, SysPermissionTree t) {
		List<SysPermissionTree> childList = getChildList(list, t);// 得到子节点列表
		t.setChildren(childList);
		for (SysPermissionTree tChild : childList) {
			if (hasChild(list, tChild)) {// 判断是否有子节点
				//returnList.add(SysPermissionTree);
				Iterator<SysPermissionTree> it = childList.iterator();
				while (it.hasNext()) {
					SysPermissionTree n = (SysPermissionTree) it.next();
					recursionFn(list, n);
				}
			}
		}
	}
	
	// 得到子节点列表
	private List<SysPermissionTree> getChildList(List<SysPermissionTree> list, SysPermissionTree t) {
		
		List<SysPermissionTree> tlist = new ArrayList<SysPermissionTree>();
		Iterator<SysPermissionTree> it = list.iterator();
		while (it.hasNext()) {
			SysPermissionTree n = (SysPermissionTree) it.next();
			if (n.getParentid().equals(t.getId())) {
				tlist.add(n);
			}
		}
		return tlist;
	} 
	List<SysPermissionTree> returnList = new ArrayList<SysPermissionTree>();
	/**
     * 根据父节点的ID获取所有子节点
     * @param list 分类表
     * @param typeId 传入的父节点ID
     * @param prefix 子节点前缀
     */
    public List<SysPermissionTree> getChildSysPermissionTrees(List<SysPermissionTree> list, int typeId,String prefix){
        if(list == null) return null;
        for (Iterator<SysPermissionTree> iterator = list.iterator(); iterator.hasNext();) {
            SysPermissionTree node = (SysPermissionTree) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (node.getParentid().equals(typeId)) {
                recursionFn(list, node,prefix);
            }
            // 二、遍历所有的父节点下的所有子节点
            /*if (node.getParentId()==0) {
                recursionFn(list, node);
            }*/
        }
        return returnList;
    }
     
    private void recursionFn(List<SysPermissionTree> list, SysPermissionTree node,String p) {
        List<SysPermissionTree> childList = getChildList(list, node);// 得到子节点列表
        if (hasChild(list, node)) {// 判断是否有子节点
            returnList.add(node);
            Iterator<SysPermissionTree> it = childList.iterator();
            while (it.hasNext()) {
            	SysPermissionTree n = (SysPermissionTree) it.next();
                n.setName(p+n.getName());
                recursionFn(list, n,p+p);
            }
        } else {
            returnList.add(node);
        }
    }

	// 判断是否有子节点
	private boolean hasChild(List<SysPermissionTree> list, SysPermissionTree t) {
		return getChildList(list, t).size() > 0 ? true : false;
	}
	
	 
}
