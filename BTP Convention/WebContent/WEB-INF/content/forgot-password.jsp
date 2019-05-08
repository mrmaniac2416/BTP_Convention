<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<s:head/>
<sj:head jqueryui="true" jquerytheme="overcast"/>
<sb:head includeScripts="true"/>
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
	document.getElementById("result").innerHTML="Email sent.Please follow the instruction in the email to reset your password.";  
	
	
});



$.subscribe('clicked', function(event,data) {
	console.log("called clicked");
	/* var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	f.elements[i].readOnly = true;
	 if(f.elements[i].name=="reviewer.reviewerType" || f.elements[i].id=="save_button")
		f.elements[i].disabled=true; 
	} */

	
	
});



$.subscribe('always', function(event,data) {
	console.log("called always");
	/* var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	f.elements[i].readOnly = true;
	 if(f.elements[i].name=="reviewer.reviewerType" || f.elements[i].id=="save_button")
		f.elements[i].disabled=true; 
	} */

	
	
});


$.subscribe('error', function(event,data) {
	console.log("called error");
	/* var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	f.elements[i].readOnly = true;
	 if(f.elements[i].name=="reviewer.reviewerType" || f.elements[i].id=="save_button")
		f.elements[i].disabled=true; 
	} */
	document.getElementById("result").innerHTML="Error sending email!"; 
	
	
});



</script>


</head>
<body>


<s:form id="send-forgot-password-details" action="send-forgot-password-details" theme="bootstrap" cssClass="form-horizontal">
<s:textfield key="email" label="Enter your registered email"></s:textfield>
<sj:submit value="Submit"  validate="true" formIds="send-forgot-password-details"  targets="result" 
			loadingText="Email sent.\nPlease follow the instruction in the email to reset your password."  
			onSuccessTopics="complete" onClickTopics="clicked" onAlwaysTopics="always" onErrorTopics="error" errorElementId="result" validateFunction="bootstrapValidation"/>
</s:form>



<div id="result"></div>

</body>
</html>