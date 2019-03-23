<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
script type="text/javascript">
    $(document).ready(function(){
        $("#reviewer_form :input").prop("disabled", true);
    });
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

</s:form> 



</body>
</html>