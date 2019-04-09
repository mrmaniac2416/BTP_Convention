<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<body>
	<img src="${pageContext.request.contextPath}/photo/daiict.png" height="100">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav mr-5">
			<li class="nav-item nav-link fontColor" style="font-size: 150%">Welcome <%= session.getAttribute("userName")  %> !
			</li>
		</ul>
		
		
		<ul class="navbar-nav ml-auto">
				
			<s:url namespace="/" action="logout" var="logout_url"></s:url>

			<li class="nav-item"><a class="nav-link colorGreen fontColor"
				href='<s:property value = "#logout_url"/>'>Logout</a></li>

		</ul>
	</nav>
</body>
</html>