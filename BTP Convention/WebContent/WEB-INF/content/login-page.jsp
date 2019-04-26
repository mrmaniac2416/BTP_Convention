<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<s:head />
<sj:head jqueryui="true" />
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/utils.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/xhtml/validation.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login-page.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
<sb:head includeScripts="true" />
</head>
<body>

	<script>
		$(window).bind("pageshow", function(event) {
			if (event.originalEvent.persisted) {
				window.location.reload();
			}
		});
	</script>

	<%-- 	<s:form id="loginForm" action="login">
		<s:textfield key="userId" label="User ID"></s:textfield>
		<s:password key="password" label="Password"></s:password>
		<sj:submit value="login" validate="true" />
	</s:form>


	<s:url action="forgot-password" var="forgotPassword_url" />



	<sj:dialog id="dialog" autoOpen="false" modal="true"
		title="Forgot Password" height="300" width="500" />


	<sj:a openDialog="dialog" href="%{forgotPassword_url}">
	Forgot Password?
</sj:a> --%>


	<%-- <a href='<s:property value = "#forgotPassword_url"/>'>
			Forgot Password?</a> --%>



	<s:if test="hasActionErrors()">
		<s:actionerror />
	</s:if>

  



	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="${pageContext.request.contextPath}/photo/dalogo.jpg"
							class="brand_logo" alt="Logo">
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
					<s:form id="loginForm" action="login" theme="bootstrap">
						<div class="input-group mb-3">
							<%-- <div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div> --%>
							<!-- <input type="text" name="" class="form-control input_user"
								value="" placeholder="username"> -->
							<s:textfield key="userId" label="User ID"
								cssClass="form-control input_user"></s:textfield>
						</div>
						<div class="input-group mb-2">
							<%-- <div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" name="" class="form-control input_pass"
								value="" placeholder="password"> --%>
							<s:password key="password" label="Password"
								cssClass="form-control input_pass"></s:password>
						</div>
						<div class="d-flex justify-content-center mt-3 login_container">
							<sj:submit value="login" validate="true"
								validateFunction="bootstrapValidation" cssClass="btn login_btn" />
						</div>
					</s:form>
				</div>
				<div class="d-flex justify-content-center links">
					<s:url action="forgot-password" var="forgotPassword_url" />



					<sj:dialog id="dialog" autoOpen="false" modal="true"
						title="Forgot Password" height="300" width="500" />


					<sj:a openDialog="dialog" href="%{forgotPassword_url}" cssClass="fontcolor">
	Forgot Password?
</sj:a>
				</div>
			</div>
		</div>
	</div>
	</div>

</body>
</html>