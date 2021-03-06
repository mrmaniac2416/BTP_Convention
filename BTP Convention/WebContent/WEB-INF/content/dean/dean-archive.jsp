
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Dean AP Dashboard</title>
</head>
<body>

<s:include value="home-navbar.jsp" />

	<s:if test="archiveThesis.isEmpty()">
		<div class="noUpdateMesage">No new updates to show!</div>
	</s:if>
	<s:else>
		<table>
			<tr>
				<th>Thesis ID</th>
				<th>Thesis title</th>
				<th>Student Name</th>
				<th>Supervisor</th>
				<th>Submitted date</th>
				<th>Reviewer List</th>
			</tr>

			<s:iterator value="archiveThesis" var="thesis">
				<tr>
					
					
					<s:url action="archive-reviewer-list" var="reviewer_url" escapeAmp="false">
						<s:param name="thesisId">
							<s:property value="#thesis[0]" />
						</s:param>
					</s:url>
					
					<s:iterator value="#thesis" var="thesis_element" begin="0" end="3">
						<td><s:property value="#thesis_element" /></td>
					</s:iterator>
					
					<td><s:date name="#thesis[4]" format="dd,MMMMM yyyy" /></td>


					
					<td><a href='<s:property value = "#reviewer_url"/>'>View Reviewers</a></td>


				</tr>

			</s:iterator>
		</table>
	</s:else>
</body>
</html>