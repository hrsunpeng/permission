<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>账户管理</title>  
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/accounts.js"></script>
	</head>
	
	<body>
		<div class="row">
			<div class="col-xs-12"> 
				<div class="row"> 
					<div class="col-xs-12">
							<div class="table-responsive">
							 	 
							 	 <c:if test="${perm!=null}">
							 		<c:forEach  items="${perm}" var="des">
										 	<c:if test="${des.description!=null}">
											 	${des.description}
										 	</c:if> 		 		
							 		</c:forEach> 
							 	</c:if>	 
							  	 
								<table id="accountsTable" class="table table-striped table-bordered table-hover">
								  
								  
								</table>
							</div><!-- /.table-responsive -->
					</div><!-- /span -->
				</div><!-- /row --> 
			</div><!-- /.col -->
		</div><!-- /.row --> 			
 	</body>
   
</html> 