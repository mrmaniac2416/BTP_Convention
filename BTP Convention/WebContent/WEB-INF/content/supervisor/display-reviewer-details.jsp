<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
function makeEditable()
{
	var f = document.forms['reviewer_form'];
	for(var i=0,fLen=f.length;i<fLen;i++){
	f.elements[i].readOnly = false;
	}
	
}
</script>
</head>
<body>


 
<s:form id="reviewer_form">
<s:textfield key="name" label="Name" value="%{reviewer.name}" />
<s:textfield key="affliation" label="Affliation" value="%{reviewer.affiliation}" />
<s:textfield key="designation" label="Designation" value="%{reviewer.designation}" />
<s:textfield key="contact_no" label="Contact No" value="%{reviewer.contact_no}" />
<s:textfield key="email_id" label="Email ID" value="%{reviewer.reviewerId.email_id}" />
<s:textarea key="Address" label="Address" value="%{reviewer.address}" />
<s:submit type="button" onclick="makeEditable(); return false" value="Edit"/>
</s:form> 

<script>
var f = document.forms['reviewer_form'];
for(var i=0,fLen=f.length;i<fLen;i++){
f.elements[i].readOnly = true;
}
</script>

</body>
</html>