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
<sj:head jqueryui="true" />
<script>
$.subscribe('dialogclosetopic', function(event,ui) {
	console.log('run topic on dialog close');
	window.location.reload(true);
});

</script>
<title>Accepted and Reviewing</title>
</head>
<body>
<s:include value="dean-navbar.jsp" />

	<table>
		<tr>
			<th>Thesis title</th>
			<th>Student Name</th>
			<th>Supervisor</th>
		</tr>
		<tr>
		<s:iterator value="thesisDetails" var="detail">
				
					<td><s:property value="#detail" /></td>
		</s:iterator>
		</tr>
	</table>
	<br />
	<br />

	<h2>Indian Reviewer</h2>
	
	
	<s:if test="indianReviewers.isEmpty()">
		<div>No new updates to show!</div>
	</s:if>
	<s:else>
	<table>
		<tr>
			<th>Name</th>
			<th>Contact No.</th>
			<th>Email</th>
			<th>Accepted Date</th>
			<th>Notification</th>
		</tr>

		<s:iterator value="indianReviewers" var="indianreviewers">
			<tr>

				<s:iterator value="#indianreviewers" var="reviewer_element" begin="0" end="2">
					<td><s:property value="#reviewer_element" /></td>
				</s:iterator>
				<td><s:date name="#indianreviewers[3]" format="dd,MMMMM yyyy" /></td>
				<s:url action="send-notification-modal" var="sendNotificationModal_url"
					escapeAmp="false">
					<s:param name="email">
						<s:property value="#indianreviewers[2]" />
					</s:param>
				</s:url>
				<td><%-- <a href='<s:property value = "#sendNotification_url"/>'>Send</a> --%>
				<sj:a openDialog="myclickdialog" href='%{sendNotificationModal_url}'>
							Send
						</sj:a>
				</td>
				
				
			</tr>

		</s:iterator>
	</table>
	</s:else>
	<br />
	<br />
	<h2>Abroad Reviewer</h2>
	
	
	<s:if test="abroadReviewers.isEmpty()">
		<div>No new updates to show!</div>
	</s:if>
	<s:else>
	<table>
		<tr>
			<th>Name</th>
			<th>Contact No.</th>
			<th>Email</th>
			<th>Accepted Date</th>
			<th>Notification</th>
		</tr>

		<s:iterator value="abroadReviewers" var="abroadreviewers">
			<tr>

				<s:iterator value="#abroadreviewers" var="reviewer_element" begin="0" end="2">
					<td><s:property value="#reviewer_element" /></td>
				</s:iterator>
				<td><s:date name="#abroadreviewers[3]" format="dd,MMMMM yyyy" /></td>
				<s:url action="send-notification-modal" var="sendNotificationModal_url"
					escapeAmp="false">
					<s:param name="email">
						<s:property value="#abroadreviewers[2]" />
					</s:param>
				</s:url>
				<td><%-- <a href='<s:property value = "#sendNotificationModal_url"/>'>Send</a> --%>
				<sj:a openDialog="myclickdialog" href='%{sendNotificationModal_url}'>
							Send
						</sj:a>
				</td>
				
				
			</tr>

		</s:iterator>
	</table>
	 
	
	
	</s:else>
	
	<sj:dialog id="myclickdialog" autoOpen="false" modal="true"
		title="Send Notification Mail" showEffect="slide" hideEffect="slide"
		onCloseTopics="dialogclosetopic"
		height="400" width="800">


	</sj:dialog>
</body>
</html>