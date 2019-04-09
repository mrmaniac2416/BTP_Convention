<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav mr-5">
			<s:url action="home-page" var="deanHomePage_url"></s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#deanHomePage_url"/>'>Home</a></li>

			<s:url action="" var="#">
			</s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#"/>'>Archives</a></li>
		</ul>
		
		
		<ul class="navbar-nav ml-auto">
		
		<s:url action="change-account-details" var="changeAccountDetails_url"></s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#changeAccountDetails_url"/>'>Change Email/Password</a></li>
				
			<s:url namespace="/" action="logout" var="logout_url"></s:url>

			<li class="nav-item"><a class="nav-link colorGreen fontColor"
				href='<s:property value = "#logout_url"/>'>Logout</a></li>

		</ul>
	</nav>
</body>
</html>