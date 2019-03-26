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
<script>
function makeEditable()
{
	var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	if(f.elements[i].name!="reviewer.name" && f.elements[i].name!="reviewer.reviewerId.email_id")
	   f.elements[i].readOnly = false;
	}
	document.getElementById("saveSuccessMsg").innerHTML="";
	
}

$.subscribe('complete', function(event,data) {
	var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	f.elements[i].readOnly = true;
	}
	document.getElementById("saveSuccessMsg").innerHTML="Reviewer saved";
	
	
});


</script>
</head>
<body>


 
<s:form id="reviewer_form" action="edit-review">
<s:textfield key="reviewer.name" label="Name" value="%{reviewer.name}" />
<s:textfield key="reviewer.affiliation" label="Affliation" value="%{reviewer.affiliation}" />
<s:textfield key="reviewer.designation" label="Designation" value="%{reviewer.designation}" />
<s:textfield key="reviewer.contact_no" label="Contact No" value="%{reviewer.contact_no}" />
<s:textfield key="reviewer.reviewerId.email_id" label="Email ID" value="%{reviewer.reviewerId.email_id}" />
<s:textfield key="reviewer.reviewer_type" label="Indian/Abroad" value="%{reviewer.reviewer_type}" />
<s:textarea key="reviewer.address" label="Address" value="%{reviewer.address}" />
<s:submit type="button" onclick="makeEditable(); return false" value="Edit"/>
<sj:submit value="Save" targets="formResult" indicator="indicator" onCompleteTopics="complete"/>
</s:form> 

<script>
var f = document.forms['reviewer_form'];
for(var i=0,fLen=f.length;i<fLen;i++){
f.elements[i].readOnly = true;
}
</script>
<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>  
<div id="formResult"></div>

<div id="saveSuccessMsg"></div>

</body>
</html>