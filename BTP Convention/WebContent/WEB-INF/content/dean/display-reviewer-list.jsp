<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title></title>
</head>
<body>

	<table>
		<tr>
			<th>Thesis title</th>
			<th>Student Name</th>
			<th>Supervisor</th>
		</tr>

		<s:iterator value="thesisDetails" var="detail">
			<tr>

				<s:iterator value="#detail" var="thesis_element">
					<td><s:property value="#thesis_element" /></td>
				</s:iterator>


			</tr>

		</s:iterator>
	</table>
	<br/>
	<br/>
	<div><s:property value="thesis_id"/></div>
	
	<h2>Indian Reviewer</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Affiliation</th>
			<th>Designation</th>
			<th>Contact No.</th>
			<th>Email</th>
			<th>Mail Sent Date</th>
		</tr>

		<s:iterator value="indianReviewers" var="indianreviewers">
			<tr>

				<s:iterator value="#indianreviewers" var="reviewer_element"
					begin="0" end="3">
					<td><s:property value="#reviewer_element" /></td>
				</s:iterator>
				<s:url action="send-invitation-modal" var="email_url"
					escapeAmp="false">
					<s:param name="email">
						<s:property value="#indianreviewers[4]" />
					</s:param>
					<s:param name="thesis_id">
					<s:property value="thesis_id" />
					</s:param>
				</s:url>

				<td><sj:a openDialog="myclickdialog" href='%{email_url}'>
						<s:property value="#indianreviewers[4]" />
					</sj:a></td>

				<td><s:property value="#indianreviewers[5]" /></td>
			</tr>

		</s:iterator>
	</table>

	<br />
	<br />
	<h2>Abroad Reviewer</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Affiliation</th>
			<th>Designation</th>
			<th>Contact No.</th>
			<th>Email</th>
			<th>Mail Sent Date</th>
			<th>Accept</th>
		</tr>

		<s:iterator value="abroadReviewers" var="abroadreviewers">
			<tr>

				<s:iterator value="#abroadreviewers" var="reviewer_element"
					begin="0" end="3">
					<td><s:property value="#reviewer_element" /></td>
				</s:iterator>
				<s:url action="send-invitation-modal" var="email_url"
					escapeAmp="false">
					<s:param name="email">
						<s:property value="#abroadreviewers[4]" />
					</s:param>
					<s:param name="thesis_id">
					<s:property value="thesis_id" />
					</s:param>
				</s:url>

				<td><sj:a openDialog="myclickdialog" href='%{email_url}'>
						<s:property value="#abroadreviewers[4]" />
					</sj:a></td>

				<td><s:property value="#abroadreviewers[5]" /></td>
				
			</tr>

		</s:iterator>
	</table>

	<sj:dialog id="myclickdialog" autoOpen="false" modal="true"
		title="Give Body">

		
	</sj:dialog>



</body>
</html>