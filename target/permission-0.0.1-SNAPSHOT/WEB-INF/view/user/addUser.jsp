<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<!-- basic styles -->
<%@ include file="/WEB-INF/view/common/common_css.jsp"%>
<!-- basic js -->
<%@ include file="/WEB-INF/view/common/common_js.jsp"%>
<script type="text/javascript" src="${baseurl}js/user/addUser.js"></script>
</head> 
<body>
	<div class="page-content">

		<form id="form" name="form" class="form-horizontal" method="post" action="${baseurl}user/addEntity.action" >
			<section class="panel panel-default">
			<div class="panel-body">
				<div class="form-group">
					<div class="col-sm-3">
						<label class="control-label">用户名</label>
					</div>
					<div class="col-sm-9">
						<input type="text" class="form-control" placeholder="请输入用户名"
							name="username" id="username">
					</div>
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label">账号</label>
					<div class="col-sm-9">
						<input type="text" class="form-control checkacc"
							placeholder="请输入账号" name="usercode" id="usercode">
					</div>
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label">密码</label>
					<div class="col-sm-9" style="color: red;">默认密码为:123456</div>
				</div>

				<div class="form-group" id="locked">
					<label class="col-sm-3 control-label">是否禁用</label>
					
					<div class="radio">
						<label>
							<input name="form-field-radio" type="radio" class="ace"   value="0" checked="checked"/>
							<span class="lbl">&nbsp;&nbsp;未锁定</span>
						</label>
					</div>
					<div class="radio">
						<label>
							<input name="form-field-radio" type="radio" class="ace" value="1" />
							<span class="lbl">&nbsp;&nbsp;锁定</span>
						</label>
					</div> 
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label">描述</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" placeholder="请输入账号描述"
							name="description" id="description">
					</div>
				</div>
			</div>
			<footer class="panel-footer text-right bg-light lter">
			<button class="btn btn-info" type="button"  onclick = "checkUser();">
				<i class="icon-ok bigger-110"></i> 提交
			</button>
			<button class="btn" type="reset">
				<i class="icon-undo bigger-110"></i> 重置
			</button>
			</footer> </section>
		</form>
</body>
</html>
