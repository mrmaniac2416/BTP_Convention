<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/acceptThesis.css">
</head>
<body>

	<h2 style="text-align: center">
		<s:property value="archivethesis[1]" />
	</h2>
	<table class="txt">


		<tr>
			<th>Thesis Id:</th>
			<td><s:property value="archivethesis[0]" /></td>
		</tr>


		<tr>
			<th>Student Name:</th>
			<td><s:property value="archivethesis[2]" /></td>
		</tr>


		<tr>
			<th>Status:</th>
			<td><s:property value="archivethesis[4]" /></td>
		</tr>


		<tr>
			<th>Student ID:</th>
			<td><s:property value="archivethesis[5]" /></td>
		</tr>


		<tr>
			<th>Research area:</th>
			<td><s:property value="archivethesis[6]" /></td>
		</tr>


		<tr>
			<th>Synopsis date:</th>
			<td><s:property value="archivethesis[7]" /></td>
		</tr>


		<tr>
			<th>Synopsis:</th>
			<s:url namespace="/" action="download-synopsis" var="synopsis_url">
				<s:param name="student_id">
					<s:property value="archivethesis[5]" />
				</s:param>
			</s:url>
			<td><a href='<s:property value = "#synopsis_url"/>'
				target="_blank"> Download Synopsis</a></td>
		</tr>


		<tr>
			<th>Thesis date:</th>
			<td><s:property value="archivethesis[3]" /></td>
		</tr>

		<tr>
			<th>Thesis:</th>

			<s:url namespace="/" action="download-thesis" var="thesis_url">
				<s:param name="thesis_id">
					<s:property value="archivethesis[0]" />
				</s:param>
			</s:url>
			<td><a href='<s:property value = "#thesis_url"/>'
				target="_blank"> Download Thesis</a></td>
		</tr>

	</table>


</body>
</html>