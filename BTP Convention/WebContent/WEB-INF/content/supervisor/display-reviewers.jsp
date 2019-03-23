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

<ol>
<s:iterator value="reviewers" var="reviewer">
     <li><s:property value="#reviewer.name"/>
</s:iterator>
</ol>


</body>
</html>