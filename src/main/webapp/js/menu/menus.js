var url = baseurl+"menu/list.action?parentId=0";
TableInit();
 
function TableInit () {
	$('#menusTable').bootstrapTable({
        url: url,         // 请求后台的URL（*）
        method: 'post',                      // 请求方式（*）
        contentType : "application/x-www-form-urlencoded",
        toolbar: '#toolbar',                // 工具按钮用哪个容器
        striped: true,                      // 是否显示行间隔色
        cache: false,                       // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: false,                   // 是否显示分页（*）
        sortable: false,                     // 是否启用排序
        sortOrder: "asc",                   // 排序方式
        sidePagination: "server",           // 分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       // 初始化加载第一页，默认第一页
        pageSize: 10,                       // 每页的记录行数（*）
        pageList: [10, 25, 50, 100],        // 可供选择的每页的行数（*） 
        strictSearch: true, 
        showRefresh: false, // 是否显示刷新按钮 F5
        minimumCountColumns: 2,             // 最少允许的列数
        clickToSelect: true,                // 是否启用点击选中行
        height: 600,                        // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",            // 每一行的唯一标识，一般为主键列
        showToggle:false,                    // 是否显示详细视图和列表视图的切换按钮
        cardView: false,                    // 是否显示详细视图
        detailView: true,                   // 是否显示父子表
        singleSelect : true, // 单选checkbox
        columns: [{
            checkbox: true
        }, {
            field: 'id',
            title: '菜单ID'
        }, {
            field: 'name',
            title: '菜单名称'
        },{
            field: 'type',
            title: '菜单类型',
            formatter: typeStats
        },{
        	 field: 'resurl',
             title: '访问url地址' 
        },{
       	 field: 'available',
         title: '是否可用' ,
         formatter: availableStats
        },{
        	 field: 'description',
             title: '描述'
        }],
      //注册加载子表的事件。注意下这里的三个参数！
        onExpandRow: function (index, row, $detail) {
        	InitSubTable(index, row, $detail);
        },
        
        responseHandler: function(data) { 
	    	return {
            	"total": data.data.total,// 总条数
                "rows": data.data.rows   // 数据
             };
        },
		onLoadSuccess: function(data){  // 加载成功时执行
            },  
        onLoadError: function(){  // 加载失败时执行
              
            }
    });
	 
}
 
//初始化子表格(无线循环)
InitSubTable = function (index, row, $detail) {  
    var parentId = row.id; 
	var url = baseurl+"menu/list.action?parentId="+parentId; 
    var cur_table = $detail.html('<table></table>').find('table');
    $(cur_table).bootstrapTable({  
    	url: url,         // 请求后台的URL（*）
        method: 'post',                      // 请求方式（*）
        contentType : "application/x-www-form-urlencoded",
        toolbar: '#toolbar',                // 工具按钮用哪个容器
        striped: true,                      // 是否显示行间隔色
        cache: false,                       // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: false,                   // 是否显示分页（*）
        sortable: false,                     // 是否启用排序
        sortOrder: "asc",                   // 排序方式
        sidePagination: "server",           // 分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       // 初始化加载第一页，默认第一页
        pageSize: 10,                       // 每页的记录行数（*）
        pageList: [10, 25, 50, 100],        // 可供选择的每页的行数（*） 
        strictSearch: true, 
        showRefresh: false, // 是否显示刷新按钮 F5
        minimumCountColumns: 2,             // 最少允许的列数
        clickToSelect: true,                // 是否启用点击选中行
        height: 600,                        // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",            // 每一行的唯一标识，一般为主键列
        showToggle:false,                    // 是否显示详细视图和列表视图的切换按钮
        cardView: false,                    // 是否显示详细视图
        detailView: true,                   // 是否显示父子表
        singleSelect : true, // 单选checkbox
        columns: [{
            checkbox: true
        }, {
            field: 'id',
            title: '菜单ID'
        }, {
            field: 'name',
            title: '菜单名称'
        },{
            field: 'type',
            title: '菜单类型',
            formatter: typeStats
        },{
        	 field: 'resurl',
             title: '访问url地址' 
        } ,{
       	 field: 'available',
         title: '是否可用' ,
         formatter: availableStats
        },{
        	 field: 'description',
             title: '描述'
        }],
        responseHandler: function(data) { 
        	console.log(data);
	    	return {
            	"total": data.data.total,// 总条数
                "rows": data.data.rows   // 数据
             };
        },
        //无线循环取子表，直到子表里面没有记录
        onExpandRow: function (index, row, $Subdetail) {
            InitSubTable(index, row, $Subdetail);
        }
    });
};

function queryParams(params){
	 
	  var temp = {   // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	            limit: params.limit,   // 页面大小
	            offset: params.offset/params.limit+1  // 页码
	   }; 
	  
	  return temp;
}

$("#addAccount").click("click", function() {
	addAccount();
});
$("#editAccount").click("click", function() {
	editAccount();
});
$("#delAccount").click("click", function() {
	delAccount();
});
$("#permissions").click("click", function() {
	permissions();
});


// 新增
function addAccount(){
	pageii = layer.open({
		title : "新增",
		type : 2,
		area : [ "600px", "80%" ],
		content : baseurl + 'menu/addMenu.action'
	});
}
 
 function typeStats(value, row, index){ 
	 // 资源类型：0目录 1 菜单 2 按钮
	 if(row.type==0){
			return "目录";
		}else if(row.type==1){
			return "菜单";
		}else{
			return "按钮";
		}
 }
 
 
 function availableStats(value, row, index){
	 if(row.available==1){
		 return "可用";
	 }else{
		 return "不可用";
	 }
 }
 

  

	
	
	// 编辑
	function editAccount(){
		var a= $('#accountsTable').bootstrapTable('getSelections');   
		if(a.length==1){
			var usercode = a[0].usercode; 
			var updateUrl = baseurl + 'user/updateUser.action?usercode='+usercode; 
			pageii = layer.open({
				title : "编辑",
				type : 2,
				area : [ "600px", "60%" ],
				content : updateUrl
			}); 
			
		}else{
			layer.msg("请选中一行记录", {
     			icon : 5
     		});
     		return false; 
		}
		
	}
	
	// 删除
  function delAccount(){
	  var a= $('#accountsTable').bootstrapTable('getSelections');   
		if(a.length==1){
			layer.confirm('是否删除？', function(index) { 
				var userId = a[0].id; 
				var delUrl = baseurl + 'user/delUser.action'; 
				
				 $.post(delUrl,{'userId':userId},function(data){ 
	        		 if(data.code==200){
	        			 layer.msg("删除成功", { icon : 1 });
	        			 $('#accountsTable').bootstrapTable('refresh');
	        				return false; 
	        		 } else{
	        			 layer.msg("删除失败", { icon : 3 });
	        				return false; 
	        		 } 
	        	 }) 
			});  
		}else{
			layer.msg("请选择删除项", { icon : 3 });
			return false; 
		}
		
  }
	
	
	
	
	
	
	
	
	