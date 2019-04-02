<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
 <sj:head jqueryui="true" /> 
<!-- This files are needed for AJAX Validation of XHTML Forms -->
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/utils.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/xhtml/validation.js"
	type="text/javascript"></script>
	<script
  src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<s:head/>

<script>



$(document).ready(function() {
	 // executes when HTML-Document is loaded and DOM is ready
	console.log("called ready");
	var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	f.elements[i].readOnly = true;
	if(f.elements[i].name=="reviewer.reviewerType" || f.elements[i].id=="save_button")
		f.elements[i].disabled=true;
	}
	});




function makeEditable()
{
	console.log("called editable");
	var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	if(f.elements[i].name!="reviewer.name" && f.elements[i].name!="reviewer.reviewerId.email")
	   f.elements[i].readOnly = false;
	if(f.elements[i].name=="reviewer.reviewerType" || f.elements[i].id=="save_button")
		f.elements[i].disabled=false;
	}
	document.getElementById("saveSuccessMsg").innerHTML="";
	
}





$.subscribe('complete', function(event,data) {
	console.log("called complete");
	/* var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	f.elements[i].readOnly = true;
	 if(f.elements[i].name=="reviewer.reviewerType" || f.elements[i].id=="save_button")
		f.elements[i].disabled=true; 
	} */
	document.getElementById("formResult").innerHTML="Reviewer saved";
	
	
});








</script>
</head>
<body>


 <div id="formResult">
<s:form id="reviewer_form" action="edit-review" theme="bootstrap" cssClass="well form-horizontal" style="max-width: 50%">
<s:textfield key="reviewer.name" label="Name" value="%{reviewer.name}" />
<s:textfield key="reviewer.affiliation" label="Affliation" value="%{reviewer.affiliation}" />
<s:textfield key="reviewer.designation" label="Designation" value="%{reviewer.designation}" />
<s:textfield key="reviewer.contact" label="Contact No" value="%{reviewer.contact}" />
<s:textfield key="reviewer.reviewerId.email" label="Email ID" value="%{reviewer.reviewerId.email}" />
<s:select label="Indian/Abroad" 
		headerKey="-1" headerValue="Select reviewer type"
		list="#{'indian':'indian', 'abroad':'abroad'}"
		key="reviewer.reviewerType" 
		value="%{reviewer.reviewerType}" />
<s:textarea key="reviewer.address" label="Address" value="%{reviewer.address}" /> 
<s:submit type="button" onclick="makeEditable(); return false" value="Edit"/>
<sj:submit id="save_button" value="Save" targets="formResult" loadingText="Loading..." onSuccessTopics="complete" validate="true" validateFunction="bootstrapValidation" />
</s:form> 

</div>



</body>
</html>