<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<s:head/>
<sj:head jqueryui="true"/>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/utils.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/xhtml/validation.js"
	type="text/javascript"></script>
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
<sj:submit value="login" validate="true"/>
</s:form>


<s:url action="forgot-password" var="forgotPassword_url"/>



<sj:dialog
	id="dialog"
	autoOpen="false"
	modal="true"
	title="Forgot Password"
	height="300"
	width="500"
/>


<sj:a
	openDialog="dialog"
	href="%{forgotPassword_url}"	
>
	Forgot Password?
</sj:a>


<%-- <a href='<s:property value = "#forgotPassword_url"/>'>
			Forgot Password?</a> --%>



<s:if test="hasActionErrors()">
<s:actionerror/>
</s:if>
		
			




	
</body>
</html>