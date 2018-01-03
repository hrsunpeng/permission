 

function checkUser() {   
	var locked = $("#locked div input:checked").val();  
	var username = $("#username").val();
	if (username == null || username == '') {
		layer.msg('用户名不能为空', {
			icon : 5
		});
		return false;
	}
	var usercode = $("#usercode").val();
	if (usercode == null || usercode == '') {
		layer.msg('账号不能为空', {
			icon : 5
		});
		return false;
	}

	var checkUserUrl = baseurl+'user/checkUser.action';
	
	var addUserUrl = baseurl+'user/addEntity.action';
	
	$.post( checkUserUrl, { "usercode": usercode }, function (data) {
		
	         if(data.code==200){ 
	        	 var pams  = {
	        			'username':username,
	        			'usercode':usercode,
	        			'locked':locked,
	        			'description':$("#description").val() 
	        	 }
	        	 $.post(addUserUrl,pams,function(data){ 
	        		 if (data.code == 200) {
							layer.confirm('添加成功!是否关闭窗口?', function(index) {  
								window.parent.$('#accountsTable').bootstrapTable('refresh');
								parent.layer.close(parent.pageii); 
								return false;
							});
							$("#form")[0].reset();
						} else {
							layer.alert('添加失败！', 3);
							return false;
						}
	        	 }) 
	         }else{ 
	        	 layer.msg(data.message, {
	     			icon : 5
	     		});
	     		return false; 
	        	 
	         }
	          
	         
	    })
	
}
 