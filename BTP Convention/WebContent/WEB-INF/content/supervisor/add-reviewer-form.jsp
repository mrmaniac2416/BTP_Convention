<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<sj:head jqueryui="true"/>
<script
  src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
<script>



$.subscribe('refresh',function(event,data){
	  
	  
	$('#localtabs').tabs();
	$('#localtabs').tabs("load", "#tab2");
	alert("Reviewer added");
  
});


</script>
</head>
<body>


 
<s:form id="reviewer_form" action="add-reviewer">
<s:textfield key="reviewer.name" label="Name"  />
<s:textfield key="reviewer.affiliation" label="Affliation" />
<s:textfield key="reviewer.designation" label="Designation"/>
<s:textfield key="reviewer.contact_no" label="Contact No"/>
<s:textfield key="reviewer.reviewerId.email_id" label="Email ID"/>
<s:textfield key="reviewer.reviewer_type" label="Indian/Abroad"/>
<s:textarea key="reviewer.address" label="Address"/>
<sj:submit value="Submit details" targets="formResult" indicator="indicator" onCompleteTopics="refresh" />
</s:form> 


<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>  
<div id="formResult"></div>


</body>
</html>