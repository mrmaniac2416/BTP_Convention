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


<s:head/>


<title>Pending reviews</title>
</head>

<body>

<s:include value="navbar.jsp" />


<s:if test="pendingReviewsDetails.isEmpty()">
		<div class="noUpdateMesage">No new updates to show!</div>
	</s:if>
	<s:else>
		<table>
			<tr>
				<th>Student Name</th>
				<th>Thesis title</th>
				<th>Supervisor Name</th>
				<th>Submission date</th>
				
			</tr>

			<s:iterator value="pendingReviewsDetails" var="pendingReview">
				<tr>
					
					
					<s:url action="pending-review-details"
							var="pendingReviewDetails_url" escapeAmp="false">
							<s:param name="pendingReview" value="pendingReview" />

					</s:url>
					
					<s:iterator value="#pendingReview" var="pendingReview_element" begin="0" end="3">
						<td><a href='<s:property value = "#pendingReviewDetails_url"/>'>
									<s:property value="#pendingReview_element" />
								</a></td>
					</s:iterator>
					
				

			  </tr>

			</s:iterator>
		</table>
	</s:else>
	
	

</body>
</html>