<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2 align="center">
Account has been created.<br> 
You may 
<s:url action="login-page" var="login_url" />


<a href='<s:property value = "#login_url"/>'>login</a>

 with your new account.  
</h2>

</body>
</html>