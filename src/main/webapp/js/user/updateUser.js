function editUser(){ 
	var usercode = $("#usercode").val();
	
	var editUserUrl = baseurl+"user/editUser.action"
	
	var locked = $("#locked div input:checked").val();  
	var username = $("#username").val();
	var usercode = $("#usercode").val();
	 var pams  = {
			 'id':$("#userId").val(),
 			'username':username,
 			'usercode':usercode,
 			'locked':locked,
 			'description':$("#description").val() 
 	 }
	 
	$.post(editUserUrl,pams,function(data){ 
		 if (data.code == 200) {
				layer.confirm('修改成功!是否关闭窗口?', function(index) { 
					window.parent.$('#accountsTable').bootstrapTable('refresh');
					parent.layer.close(parent.pageii);   
					return false;
				});
				$("#form")[0].reset();
			} else {
				layer.alert('修改失败！', 3);
				return false;
			}
	 }) 
	
	
}