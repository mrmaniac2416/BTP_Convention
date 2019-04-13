<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/acceptThesis.css">
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
<title>Archives Thesis</title>
</head>
<body>

	<s:include value="navbar.jsp" />
	
	
	<s:if test="archivesThesis.isEmpty()">
		<div class="noUpdateMesage">No thesis to Display!</div>
	</s:if>
	<s:else>

		<div>
			<table style="float: left">
				<tr>
					<th>Thesis ID</th>
					<th>Thesis title</th>
					<th>Student Name</th>
					<th>Thesis Submitted date</th>
					<th>Student ID</th>
					<th>Research Area</th>
					<th>Synopsis date</th>
			
				</tr>



				<s:iterator value="archivesThesis" var="archivethesis">

					<tr>

						<s:url action="display-archives-thesis"
							var="displayArchivesThesis_url" escapeAmp="false">
							<s:param name="archivethesis" value="#archivethesis" />

						</s:url>
						<s:iterator value="#archivethesis" var="thesis_element">

							<td><sj:a href="%{displayArchivesThesis_url}"
									targets="archivesThesisContent">
									<s:property value="#thesis_element" />
								</sj:a></td>
						</s:iterator>

					</tr>



				</s:iterator>


			</table>

			<div id="archivesThesisContent" class="marg"></div>
		</div>
	</s:else>


</body>
</html>