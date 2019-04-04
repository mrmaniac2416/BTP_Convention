
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<s:head/>
<sj:head jqueryui="true" jquerytheme="overcast"/>

<!-- This files are needed for AJAX Validation of XHTML Forms -->
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
	document.getElementById("result").innerHTML="Email sent";  
	
	
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


<sb:head includeScripts="true"/>
</head>
<body>

 <div id="result">
	<s:form id="emailForm" action="send-invitation-mail" theme="bootstrap" cssClass="form-horizontal">
		
		<s:hidden value="%{email}" name="email" /> 
		<s:textarea label="Body" name="body" />
		<s:hidden value="%{thesisId}" name="thesisId" />


		<sj:submit targets="result" 
			 formIds="emailForm"  
			loadingText="Sending email...."  
			onSuccessTopics="complete" onClickTopics="clicked" onAlwaysTopics="always" onErrorTopics="error" errorElementId="result"/>
	</s:form>
	
	
	</div>

</body>
</html>