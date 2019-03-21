<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<s:form action="login">
<s:textfield key="userId" label="User ID"></s:textfield>
<s:password key="password" label="Password"></s:password>
<s:submit value="login" />
</s:form>

<s:if test="hasActionErrors()">
<s:actionerror/>
</s:if>
		
			




	
</body>
</html>