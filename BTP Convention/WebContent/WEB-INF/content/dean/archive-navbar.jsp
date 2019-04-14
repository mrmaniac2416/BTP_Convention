<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<body>

	<script>
		$(window).bind("pageshow", function(event) {
			if (event.originalEvent.persisted) {
				window.location.reload();
			}
		});
	</script>
	
	<img src="${pageContext.request.contextPath}/photo/daiict.png" height="100">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav mr-5">
			<s:url action="dean-archive" var="archivePage_url"></s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#archivePage_url"/>'>Archives</a></li>

			<s:url action="display-reviewer-list" var="reviewerlist_url">
				<s:param name="thesisId">
					<%= session.getAttribute("thesisId")  %>
				</s:param>
			</s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#reviewerlist_url"/>'>Reviewer List</a></li>


			<s:url action="archive-reviewed" var="displayReviewed_url"></s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#displayReviewed_url"/>'>Reviewed</a></li>

		
		</ul>
		
		
		<ul class="navbar-nav ml-auto">
				
			<s:url namespace="/" action="logout" var="logout_url"></s:url>

			<li class="nav-item"><a class="nav-link colorGreen fontColor"
				href='<s:property value = "#logout_url"/>'>Logout</a></li>

		</ul>
	</nav>
</body>
</html>