<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<s:head/>
<sj:head jqueryui="true" jquerytheme="overcast"/>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/utils.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/xhtml/validation.js"
	type="text/javascript"></script>
<script>



$.subscribe('complete', function(event,data) {
	console.log("called complete");
	document.getElementById("result").innerHTML="Email sent.Please follow the instructions in the email to activate your account.";
	
	
});


$.subscribe('aftervalidation', function(event,data) {
	console.log("called after validation");
	
	  
	
	
});


$.subscribe('clicked', function(event,data) {
	console.log("called clicked");
	
	
	
});



$.subscribe('always', function(event,data) {
	console.log("called always");
	
	
});


$.subscribe('error', function(event,data) {
	console.log("called error");

	document.getElementById("result").innerHTML="Error sending email!"; 
	
	
});



</script>


</head>
<body>

<h2 align="center">Enter your details !</h2>

<s:form id="submit-student-details" action="submit-student-details" theme="bootstrap" cssClass="form-horizontal">
<s:textfield key="email" label="Email"></s:textfield>
<s:password key="password" label="Password"></s:password>
<s:password key="repassword" label="Renter Password"></s:password>
<s:textfield key="name" label="Student Name" />
<s:select key="supervisor" list="supervisors" label="Supervisor"
 headerKey="-1" headerValue="Select supervisor" listKey="user_id"
 listValue="user_name"
 />
 <s:textfield key="researchArea" label="Research Area"></s:textfield>
<sj:submit value="Submit"  validate="true" formIds="submit-student-details"  targets="result" 
            loadingText="Email sent.Please follow the instructions in the email to activate your account."
			onSuccessTopics="complete" onClickTopics="clicked" onAlwaysTopics="always" onErrorTopics="error" errorElementId="result"
			onAfterValidationTopics="aftervalidation"
			validateFunction="bootstrapValidation"/>
</s:form>



<div id="result"></div>

</body>
</html>