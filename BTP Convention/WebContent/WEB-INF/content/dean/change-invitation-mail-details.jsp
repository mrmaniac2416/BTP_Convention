<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/navbar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/home-page.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/utils.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/xhtml/validation.js"
	type="text/javascript"></script>
<sj:head jqueryui="true" />
<s:head/>

<script>
$.subscribe('success', function(event,data) {
	console.log("called success");
	
	document.getElementById("formresult").innerHTML="Invitation mail details saved";
	
	
});

function refresh(){
	console.log("called before");
	
	 document.getElementById("formresult").innerHTML=""; 
	
	
};


</script>
<title>Change invitation mail details</title>
</head>
<body>
<s:include value="home-navbar.jsp" />

<s:form id="changeInvitationMailDetailsForm" action="change-invitation-details">
    <s:textfield key="invitationMailSubject" label="Invitation mail subject" value="%{subject}" cssStyle="white-space: pre-wrap;"/>
    <s:textarea key="invitationMailBody" label="Invitation mail body" value="%{body}" cssStyle="white-space: pre-wrap;"/>
    
    <sj:submit value="Submit details" targets="formresult" loadingText="Saving details..." onSuccessTopics="success" onclick="refresh();" validate="true"/>
    
</s:form>

<div id="formresult"> </div>


<s:if test="hasActionErrors()">
<s:actionerror/>
</s:if>

</body>
</html>