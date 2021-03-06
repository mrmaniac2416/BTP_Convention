<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Accept Thesis</title>
</head>
<body>

	<s:include value="navbar.jsp" />
	<%-- <jsp:include page='supervisor-navbar.jsp' /> --%>
	<s:if test="acceptedThesis.isEmpty()">
		<div class="noUpdateMesage">No new thesis to accept!</div>
	</s:if>
	<s:else>

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

						<s:url action="display-thesis-details"
							var="displayThesisDetails_url" escapeAmp="false">
							<s:param name="thesis" value="thesis" />

						</s:url>
						<s:iterator value="#thesis" var="thesis_element" begin="0" end="3">

							<td><sj:a href="%{displayThesisDetails_url}"
									targets="thesisContent">
									<s:property value="#thesis_element" />
								</sj:a></td>
						</s:iterator>

					</tr>



				</s:iterator>


			</table>

			<div id="thesisContent" class="marg"></div>
		</div>
	</s:else>


</body>
</html>