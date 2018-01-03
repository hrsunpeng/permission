<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增菜单</title>
<!-- basic styles -->
<%@ include file="/WEB-INF/view/common/common_css.jsp"%>
<!-- basic js -->
<%@ include file="/WEB-INF/view/common/common_js.jsp"%>
<script type="text/javascript" src="${baseurl}js/menu/add.js"></script>
</head> 
<body>
	<div class="page-content">

		<form id="form" name="form" class="form-horizontal" method="post"  >
			<section class="panel panel-default">
			<div class="panel-body">
				<div class="form-group">
					<div class="col-sm-3">
						<label class="control-label">菜单名称</label>
					</div>
					<div class="col-sm-9">
						<input type="text" class="form-control" placeholder="请输入菜单名称"
							name="name" id="name">
					</div>
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label">访问url地址</label>
					<div class="col-sm-9">
						<input type="text" class="form-control checkacc"
							placeholder="请输入访问地址" name="resurl" id="resurl">
					</div>
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label">唯一标识</label>
					<div class="col-sm-9">
						<input type="text" class="form-control checkacc"
							placeholder="请输入唯一标识" name="resKey" id="resKey">
					</div>
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label">描述</label>
					<div class="col-sm-9">
						<input type="text" class="form-control checkacc"
							placeholder="描述" name="permissions" id="permissions">
					</div>
				</div>
			  <div class="line line-dashed line-lg pull-in"></div>
			  <!-- 上级菜单 -->
			  <div class="form-group">
					<label class="col-sm-3 control-label">上级菜单</label>
					<input type="text" id="txt_departmentname" name="txt_departmentname" class="form-control" value="" 
					onclick="$('#treeview').show()" placeholder="上级菜单">  
                        <div id="treeview" style="display: none;">  
				</div>
				 
				 
				 
				<div class="line line-dashed line-lg pull-in"></div>
			  <!-- 菜单类型 --> 
			 <div class="form-group">
				<label class="col-sm-3 control-label">菜单类型</label>
				<div class="col-sm-9">
						<select id="type" name="resFormMap.type" class="form-control m-b"
							tabindex="-1" onchange="getBut(this)">
							<!-- ：0目录 1 菜单 2 按钮 -->
							<option value="0">------  目录  ------</option>
							<option value="1">------  菜单  ------</option>
							<option value="2">------  按扭  ------</option>
						</select>
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
