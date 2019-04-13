<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accept thesis</title>
<script>

function closeDialog(){
	console.log('closed dialog called.');
    $('#myclickdialog').dialog('close');
};

</script>
</head>
<body>

<div> Are you sure you want to accept the thesis?</div>
<div align="center">
<s:form action="accepted-thesis" theme="simple">
<s:hidden name="thesisId" value="%{thesisId}"/>
<s:submit value="Yes"/>
<s:submit value="No" onclick="closeDialog(); return false;"/>

</s:form>

</div>
</body>
</html>