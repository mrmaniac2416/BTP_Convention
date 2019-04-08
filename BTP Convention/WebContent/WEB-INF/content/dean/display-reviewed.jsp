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
<title>Reviewed</title>
</head>
<body>
<s:include value="dean-navbar.jsp" />

	<table>
		<tr>
			<th>Thesis title</th>
			<th>Student Name</th>
			<th>Supervisor</th>
		</tr>

		<s:iterator value="thesisDetails" var="detail">		
					<td><s:property value="#detail" /></td>
		</s:iterator>
	</table>
	<br />
	<br />

	<h2>Indian Reviewer</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Contact No.</th>
			<th>Email</th>
			<th>Reviewed Date</th>
			<th>Review</th>
			<th>Send to Supervisor</th>
		</tr>

		<s:iterator value="indianReviewers" var="indianreviewers">
			<tr>

				<s:iterator value="#indianreviewers" var="reviewer_element" begin="0" end="2">
					<td><s:property value="#reviewer_element" /></td>
				</s:iterator>
				<td><s:date name="#indianreviewers[3]" format="dd,MMMMM yyyy" /></td>
				<s:url namespace="/" action="download-review" var="review_url" escapeAmp="false">
						<s:param name="thesis_id">
							<s:property value="#session.thesisId" />
						</s:param>
						<s:param name="thesis_title">
							<s:property value="thesisDetails[0]" />
						</s:param>
						<s:param name="reviewerId">
							<s:property value="#indianreviewers[2]" />
						</s:param>
					</s:url>
					<td><a href='<s:property value = "#review_url"/>'
						target="_blank">View</a></td>
				
			</tr>

		</s:iterator>
	</table>
	<br />
	<br />
	<h2>Abroad Reviewer</h2>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Contact No.</th>
			<th>Email</th>
			<th>Reviewed Date</th>
			<th>Review</th>
			<th>Send to Supervisor</th>
		</tr>

		<s:iterator value="abroadReviewers" var="abroadreviewers">
			<tr>

				<s:iterator value="#abroadreviewers" var="reviewer_element" begin="0" end="2">
					<td><s:property value="#reviewer_element" /></td>
				</s:iterator>
				<td><s:date name="#abroadreviewers[3]" format="dd,MMMMM yyyy" /></td>
				<s:url action="generate-user" var="generateUser_url"
					escapeAmp="false">
					<s:param name="email">
						<s:property value="#abroadreviewers[2]" />
					</s:param>
				</s:url>
				<td><a href='<s:property value = "#generateUser_url"/>'>Generate</a></td>
				
				
			</tr>

		</s:iterator>
	</table>
</body>
</html>