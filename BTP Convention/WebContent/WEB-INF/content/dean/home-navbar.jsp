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
	
	<img src="${pageContext.request.contextPath}/photo/daiict.png"
		height="100">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav mr-5">
			<s:url action="home-page" var="deanHomePage_url"></s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#deanHomePage_url"/>'>Home</a></li>

			<s:url action="dean-archive" var="#archive">
			</s:url>
			<li class="nav-item margin"><a class="nav-link fontColor"
				href='<s:property value = "#archive"/>'>Archives</a></li>
		</ul>

		<s:url action="change-account-details" var="changeAccountDetails_url"></s:url>
		<s:url action="change-invitation-mail-details"
			var="changeInvitationMailDetails_url" />
		<s:url action="change-notification-mail-details"
			var="changeNotificationMailDetails_url" />
		<ul class="navbar-nav ml-auto">

			<li class="nav-item dropdown mr-4"><a
				class="nav-link dropdown-toggle fontColor" href="#"
				id="navbarDropdown" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> Settings </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href='<s:property value = "#changeAccountDetails_url"/>'>Change
						Email/Password</a> 
						<a class="dropdown-item"
						href='<s:property value = "#changeInvitationMailDetails_url"/>'>Edit
						Invitation Mail</a> 
						<a class="dropdown-item"
						href='<s:property value = "#changeNotificationMailDetails_url"/>'>Edit
						 Notification Mail</a>




				</div>
				</li>

			<s:url namespace="/" action="logout" var="logout_url"></s:url>

			<li class="nav-item mr-1"><a class="nav-link colorGreen fontColor"
				href='<s:property value = "#logout_url"/>'>Logout</a></li>

		</ul>
	</nav>
</body>
</html>