package cn.msosm.shop.pojo;

import java.util.ArrayList;
import java.util.List;
 

public class SysPermissionTree {
	
		private Integer id;

	    private String name;

	    private Integer parentid;

	    private String reskey;

	    private String type;

	    private String resurl;

	    private String icon;

	    private Integer available;

	    private String description;
	    
	    private List<SysPermissionTree> children = new ArrayList<SysPermissionTree>();

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getParentid() {
			return parentid;
		}

		public void setParentid(Integer parentid) {
			this.parentid = parentid;
		}

		public String getReskey() {
			return reskey;
		}

		public void setReskey(String reskey) {
			this.reskey = reskey;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getResurl() {
			return resurl;
		}

		public void setResurl(String resurl) {
			this.resurl = resurl;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public Integer getAvailable() {
			return available;
		}

		public void setAvailable(Integer available) {
			this.available = available;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<SysPermissionTree> getChildren() {
			return children;
		}

		public void setChildren(List<SysPermissionTree> children) {
			this.children = children;
		}
	    
	    
	    
}
