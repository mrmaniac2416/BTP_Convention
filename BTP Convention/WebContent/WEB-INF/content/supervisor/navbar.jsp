<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<body>
	<img src="${pageContext.request.contextPath}/photo/daiict.png" height="100">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav mr-5">
			<s:url action="home-page" var="supervisorHomePage_url"></s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#supervisorHomePage_url"/>'>Home</a></li>

			<s:url action="accept-thesis" var="acceptThesis_url"></s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#acceptThesis_url"/>'>Accept Thesis</a></li>


			<s:url action="select-reviewer" var="selectReviewer_url"></s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#selectReviewer_url"/>'>Reviewing</a></li>
				
				<s:url action="thesis-review" var="thesisReview_url"></s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#thesisReview_url"/>'>Reviews</a></li>
				
			<s:url action="archives-thesis" var="archivesThesis_url"></s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#archivesThesis_url"/>'>Archives</a></li>
		</ul>
		<ul class="navbar-nav ml-auto">
			<s:url namespace="/" action="logout" var="logout_url"></s:url>

			<li class="nav-item"><a class="nav-link colorGreen fontColor"
				href='<s:property value = "#logout_url"/>'>Logout</a></li>

		</ul>
	</nav>

</body>
</html>