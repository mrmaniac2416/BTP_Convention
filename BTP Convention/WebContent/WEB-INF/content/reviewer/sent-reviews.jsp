<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/home-page.css">
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
<title>Sent reviews.</title>
<s:head />
</head>
<body>

	<s:include value="navbar.jsp" />


	<s:if test="sentReviewsDetails.isEmpty()">
		<div class="noUpdateMesage">No new updates to show!</div>
	</s:if>
	<s:else>
		<table>
			<tr>
				<th>Student Name</th>
				<th>Thesis title</th>
				<th>Supervisor Name</th>
				<th>Thesis Submission date</th>
				<th>Review Submission date</th>
				<th>Synopsis</th>
				<th>Thesis</th>
				<th>Review</th>

			</tr>

			<s:iterator value="sentReviewsDetails" var="sentReview">
				<tr>



					<s:iterator value="#sentReview" var="sentReview_element" begin="0"
						end="2">
						<td><s:property value="#sentReview_element" /></td>
					</s:iterator>
					
					<td><s:date name="#sentReview[3]" format="dd,MMMMM yyyy" /></td>

					<td><s:date name="#sentReview[4]" format="dd,MMMMM yyyy" /></td>

					<s:url namespace="/" action="download-synopsis" var="synopsis_url">
						<s:param name="student_id">
							<s:property value="#sentReview[5]" />
						</s:param>
					</s:url>
					<td><a href='<s:property value = "#synopsis_url"/>'
						target="_blank"> Download Synopsis</a></td>


					<s:url namespace="/" action="download-thesis" var="thesis_url">
						<s:param name="thesis_id">
							<s:property value="#sentReview[6]" />
						</s:param>
					</s:url>
					<td><a href='<s:property value = "#thesis_url"/>'
						target="_blank"> Download Thesis</a></td>
						
					
					
					<s:url namespace="/reviewer" action="download-review" var="review_url" escapeAmp="false">
						<s:param name="thesis_id">
							<s:property value="#sentReview[6]" />
						</s:param>
						<s:param name="thesis_title">
							<s:property value="#sentReview[1]" />
						</s:param>
					</s:url>
					<td><a href='<s:property value = "#review_url"/>'
						target="_blank"> Download Review</a></td>



				</tr>

			</s:iterator>
		</table>
	</s:else>






</body>
</html>