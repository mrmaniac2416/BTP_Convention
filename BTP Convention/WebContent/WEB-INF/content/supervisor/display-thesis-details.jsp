<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/acceptThesis.css">
<script>
function alertUser(){
	window.alert("Thesis has been Accepted");
}
</script>
</head>
<body>

 <h2 style="text-align: center"><s:property value="thesis[1]" /></h2>
	<table class="txt">
		

		<tr>
			<th>Thesis Id:</th>
			<td><s:property value="thesis[0]" /></td>
		</tr>


		<tr>
			<th>Student Name:</th>
			<td><s:property value="thesis[2]" /></td>
		</tr>


		<tr>
			<th>Student ID:</th>
			<td><s:property value="thesis[4]" /></td>
		</tr>


		<tr>
			<th>Research area:</th>
			<td><s:property value="thesis[5]" /></td>
		</tr>


		<tr>
			<th>Synopsis date:</th>
			<td><s:property value="thesis[6]" /></td>
		</tr>


		<tr>
			<th>Synopsis:</th>
			<s:url namespace= "/" action="download-synopsis" var="synopsis_url">
					<s:param name="student_id">
						<s:property value="thesis[4]" />
					</s:param>
				</s:url>
			<td> <a href='<s:property value = "#synopsis_url"/>' target="_blank">
					Download Synopsis</a>
			</td>
		</tr>
		
		
		<tr>
			<th>Thesis date:</th>
			<td><s:property value="thesis[3]" /></td>
		</tr>
		
		<tr>
		<th>Thesis:</th>
		
		<s:url namespace="/" action="download-thesis" var="thesis_url">
				<s:param name="thesis_id"><s:property value="thesis[0]" /></s:param>
		</s:url>
			<td><a href='<s:property value = "#thesis_url"/>' target="_blank"> Download Thesis</a>
		</td>
		</tr>

	</table>
	
	<s:form action="accepted-thesis">
	<s:hidden name="thesisId" value="%{thesis[0]}" />
	 <input type="submit" onclick="alertUser()" class="btn btn-info" value="Accept">
	</s:form>


</body>
</html>