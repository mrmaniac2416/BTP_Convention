<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home-page.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/navbar.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Supervisor Dashboard</title>
</head>
<body>
	
	<s:include value = "navbar.jsp"/>
	
	<s:if test="supervisorProfile.isEmpty()">
		<div class="noUpdateMesage">No new updates to show!</div>
	</s:if>
	<s:else>
		<table>
			<tr>
				<th>Thesis ID</th>
				<th>Thesis title</th>
				<th>Student Name</th>
				<th>Submitted date</th>
				<th>Status</th>
				<th>Synopsis</th>
				<th>Thesis</th>
			</tr>

			<s:iterator value="supervisorProfile" var="thesis">
				<tr>
					<s:iterator value="#thesis" var="thesis_element" begin="0" end="4">
						<td><s:property value="#thesis_element" /></td>
					</s:iterator>
					
					
					<s:url namespace="/" action="download-synopsis" var="synopsis_url">
				<s:param name="student_id">
					<s:property value="#thesis[5]" />
				</s:param>
			</s:url>
			<td><a href='<s:property value = "#synopsis_url"/>'
				target="_blank"> Download</a></td>
					
					<s:url namespace="/" action="download-thesis" var="thesis_url">
				<s:param name="thesis_id">
					<s:property value="#thesis[0]" />
				</s:param>
			</s:url>
			<td><a href='<s:property value = "#thesis_url"/>'
				target="_blank"> Download</a></td>
					
				</tr>

			</s:iterator>
		</table>
	</s:else>
</body>
</html>