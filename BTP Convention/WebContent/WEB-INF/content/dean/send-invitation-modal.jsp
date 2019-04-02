<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="send-invitation-mail">
			<s:hidden value="%{email}" name="email_id" />
			<s:hidden value="%{thesis_id}" name="thesis_id" />
			<s:textarea label="Body" name="body"></s:textarea>
			<sj:submit></sj:submit>
		</s:form>
</body>
</html>