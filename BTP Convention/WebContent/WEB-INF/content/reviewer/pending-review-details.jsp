<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/navbar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/acceptThesis.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<s:head/>
</head>

<body>
    
    
    <s:include value="navbar.jsp" />
	<table class="txt">


		<tr>
			<th>Student Name:</th>
			<td><s:property value="pendingReview[0]" /></td>
		</tr>


		<tr>
			<th>Thesis title:</th>
			<td><s:property value="pendingReview[1]" /></td>
		</tr>


		<tr>
			<th>Supervisor Name:</th>
			<td><s:property value="pendingReview[2]" /></td>
		</tr>


		<tr>
			<th>Submission date:</th>
			<td><s:date name="pendingReview[3]" format="dd,MMMMM yyyy" /></td>
		</tr>




		<tr>
			<th>Synopsis:</th>
			<s:url namespace="/" action="download-synopsis" var="synopsis_url">
				<s:param name="student_id">
					<s:property value="pendingReview[4]" />
				</s:param>
			</s:url>
			<td><a href='<s:property value = "#synopsis_url"/>'
				target="_blank"> Download Synopsis</a></td>
		</tr>




		<tr>
			<th>Thesis:</th>

			<s:url namespace="/" action="download-thesis" var="thesis_url">
				<s:param name="thesis_id">
					<s:property value="pendingReview[5]" />
				</s:param>
			</s:url>
			<td><a href='<s:property value = "#thesis_url"/>'
				target="_blank"> Download Thesis</a></td>
		</tr>



		<tr>
			<th>Upload review file:</th>
			<td><s:form action="submit-review" enctype="multipart/form-data" method="POST">
					<s:hidden name="thesisId" value="%{pendingReview[5]}" />
					<s:hidden name="pendingReview" value="%{pendingReview[0]}"/>
					<s:hidden name="pendingReview" value="%{pendingReview[1]}"/>
					<s:hidden name="pendingReview" value="%{pendingReview[2]}"/>
					<s:hidden name="pendingReview" value="%{pendingReview[3]}"/>
					<s:hidden name="pendingReview" value="%{pendingReview[4]}"/>
					<s:hidden name="pendingReview" value="%{pendingReview[5]}"/>
					<s:file name="file" label="Select a File to upload" size="40"/>
					<s:submit value="Submit review"/>
				</s:form></td>
		</tr>







	</table>
	
	





</body>
</html>