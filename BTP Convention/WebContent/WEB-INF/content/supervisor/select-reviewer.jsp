<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/selectReviewer.css">
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
<sj:head jqueryui="true" />



<title>Insert title here</title>
</head>
<body>


	<s:include value="navbar.jsp" />



	<s:if test="acceptedThesis.isEmpty()">
		<div class="noUpdateMesage">No thesis to select reviewer!</div>
	</s:if>
	<s:else>
		<sj:tabbedpanel id="localtabs" cssClass="tab">
			<sj:tab id="tab1" target="tone" label="Select Reviewers" />

			<s:url action="display-reviewers" var="displayReviewers_url" />

			<sj:tab id="tab2" href="%{displayReviewers_url}" target="ttwo"
				label="Add/Edit Reviewer" />

			<div id="tone">
				<div>
					<table style="float: left">
						<tr>
							<th>Thesis ID</th>
							<th>Thesis title</th>
							<th>Student Name</th>
							<th>Submitted date</th>
						</tr>



						<s:iterator value="acceptedThesis" var="thesis">

							<tr>

								<s:url action="select-thesis-reviewer"
									var="selectThesisReviewer_url" escapeAmp="false">
									<s:param name="thesis" value="thesis" />

								</s:url>
								<s:iterator value="#thesis" var="thesis_element" begin="0"
									end="3">

									<td><sj:a href="%{selectThesisReviewer_url}"
											targets="selectReviewerTable">
											<s:property value="#thesis_element" />
										</sj:a></td>
								</s:iterator>

							</tr>



						</s:iterator>


					</table>

					<div id="selectReviewerTable" class="maggi"></div>
				</div>
			</div>


			<div id="ttwo"></div>
			
	
		</sj:tabbedpanel>

	</s:else>

</body>
</html>