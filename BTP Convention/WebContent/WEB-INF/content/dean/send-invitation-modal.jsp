<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>


$.subscribe('complete', function(event,data) {
	console.log("called complete");
	/* var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	f.elements[i].readOnly = true;
	 if(f.elements[i].name=="reviewer.reviewerType" || f.elements[i].id=="save_button")
		f.elements[i].disabled=true; 
	} */
	document.getElementById("successMsg").innerHTML="Email sent";
	
	
});
</script>

<sj:head jqueryui="true"/>
</head>
<body>

<div id="successMsg">
<s:form action="send-invitation-mail">
			<s:hidden value="%{email}" name="email" />
			<s:hidden value="%{thesis_id}" name="thesis_id" />
			<s:textarea label="Body" name="body"></s:textarea>
			<sj:submit loadingText="Sending Email..." targets="successMsg" onSuccessTopics="complete"></sj:submit>
		</s:form>
</div>
<s:property value="thesis_id"/>
</body>
</html>