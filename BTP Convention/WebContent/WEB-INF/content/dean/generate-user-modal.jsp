<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Generate user modal</title>
<script>
	function closeDialog() {
		console.log('closed dialog called.');
		$('#myclickdialog').dialog('close');
	};
</script>
<script>


$.subscribe('complete', function(event,data) {
	console.log("called complete");
	document.getElementById("result").innerHTML="Reviewer account details email sent";  
	
	
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
	<div id="result">
		<div>Are you sure you want to generate account for reviewer and
			send login details?</div>

		<div align="center">
			<s:form action="generate-user" theme="simple" id="generateUserForm">
				<s:hidden name="email" value="%{email}" />
				<sj:submit targets="result" formIds="generateUserForm"
					loadingText="Generating account and sending email...."
					onSuccessTopics="complete" onClickTopics="clicked"
					onAlwaysTopics="always" onErrorTopics="error"
					errorElementId="result" value="Yes"/>
				<s:submit value="No" onclick="closeDialog(); return false;" />

			</s:form>

		</div>
	</div>
</body>
</html>