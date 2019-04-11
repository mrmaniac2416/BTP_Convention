<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
<s:head/>
<sj:head jqueryui="true"/>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/utils.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/xhtml/validation.js"
	type="text/javascript"></script>
<script>
$.subscribe('complete', function(event,data) {
	console.log("called complete");
	/* var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	f.elements[i].readOnly = true;
	 if(f.elements[i].name=="reviewer.reviewerType" || f.elements[i].id=="save_button")
		f.elements[i].disabled=true; 
	} */
	document.getElementById("result").innerHTML="Password has been changed.<br> Please <a href=\"http://localhost:8080/BTP_Convention/login-page\"> login </a> with your new details.";  
	
	
});

</script>
</head>
<body>

<s:form id="resetPasswordForm" action="reset-password">
<s:hidden name="email" value="%{email}"/>
<s:password key="password" label="Enter your new password"></s:password>
<s:password key="confirmPassword" label="Re-enter new password"></s:password>
<sj:submit value="Submit" validate="true" targets="result" loadingText="Resetting password..."  
			onSuccessTopics="complete"/>
</s:form>

<div id="result"></div>




	
</body>
</html>