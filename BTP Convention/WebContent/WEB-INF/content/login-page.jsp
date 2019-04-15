<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<s:head />
<sj:head jqueryui="true" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login-page.css">
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/utils.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/xhtml/validation.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
</head>
<body>

	<script>
		$(window).bind("pageshow", function(event) {
			if (event.originalEvent.persisted) {
				window.location.reload();
			}
		});
	</script>

	<s:form id="loginForm" action="login">
		<s:textfield key="userId" label="User ID"></s:textfield>
		<s:password key="password" label="Password"></s:password>
		<sj:submit value="login" validate="true" />
	</s:form>


	<s:url action="forgot-password" var="forgotPassword_url" />



	<sj:dialog id="dialog" autoOpen="false" modal="true"
		title="Forgot Password" height="300" width="500" />


	<sj:a openDialog="dialog" href="%{forgotPassword_url}">
	Forgot Password?
</sj:a>


	<%-- <a href='<s:property value = "#forgotPassword_url"/>'>
			Forgot Password?</a> --%>



	<s:if test="hasActionErrors()">
		<s:actionerror />
	</s:if>

</body>
</html>