<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
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
<title>Student Dashboard</title>
<s:head />
</head>
<body>

<script>
$(window).bind("pageshow", function(event) {
    if (event.originalEvent.persisted) {
        window.location.reload(); 
    }
});
</script>

	
	<s:include value="student-navbar.jsp" />
	<table style="max-width: 45%">
	<tr>
	<th>Student ID:</th> <td>${studentProfile.get(0)}</td>
	</tr>
	<tr>
	<th>Student Name:</th> <td>${studentProfile.get(1)}</td>
	</tr>
	<tr>
	<th>Supervisor Name:</th> <td>${studentProfile.get(6)}</td>
	</tr>
	<tr>
	<th>Research area:</th> <td>${studentProfile.get(2)}</td>
	</tr>
	<s:if test="studentProfile.get(3)==null">
	<tr>
	<th>Synopsis:</th>
	<td>
	<s:form action="submit-synopsis" method="POST"
			enctype="multipart/form-data">
			<s:file name="file" label="Select a File to upload" size="40" />
			<s:hidden name="userId" value="%{studentProfile.get(0)}" />
			<s:submit value="submit synopsis" />
		</s:form>
	</td>
	</tr>
	</s:if>


	<s:else>
	<tr>
		<th>
			Synopsis submitted date:</th>
		<td>
			<s:date name="studentProfile.get(4)" format="dd,MMMMM yyyy" /></td>
		</tr>

		<tr>
		<th>Synopsis</th>
		<td>
		<s:url namespace="/" action="download-synopsis" var="synopsis_url">
			<s:param name="student_id">${studentProfile.get(0)}</s:param>
		</s:url>
		<a href='<s:property value = "#synopsis_url"/>' target="_blank">
			Download Synopsis</a></td>
			</tr>

	</s:else>
	<s:if test="studentProfile.get(5)==null">

		<s:if test="studentProfile.get(3)!=null">
			<tr>
			<s:form action="submit-thesis" method="post"
				enctype="multipart/form-data">
				<s:textfield key="thesisName" label="Thesis Name" />
				<s:file name="file" label="Select a file to upload" />
				<s:submit value="submit Thesis" />
				<s:hidden name="userId" value="%{studentProfile.get(0)}" />
			</s:form>
			</tr>
		</s:if>

	</s:if>
	
	<s:else>
		<tr>
			<th>Thesis</th>
			<td>
			<s:url namespace="/" action="download-thesis" var="thesis_url">
				<s:param name="thesis_id">${studentProfile.get(5)}</s:param>
			</s:url>
			<a href='<s:property value = "#thesis_url"/>' target="_blank">
				Download Thesis</a></td>

		</tr>
	</s:else>
</table>
</body>
</html>