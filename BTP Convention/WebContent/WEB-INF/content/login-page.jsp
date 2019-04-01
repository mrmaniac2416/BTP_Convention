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

<s:form id="loginForm" action="login">
<s:textfield key="userId" label="User ID"></s:textfield>
<s:password key="password" label="Password"></s:password>
<sj:submit value="login" validate="true"/>
</s:form>





<s:if test="hasActionErrors()">
<s:actionerror/>
</s:if>
		
			




	
</body>
</html>