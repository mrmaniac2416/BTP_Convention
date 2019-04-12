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

	<table class="txt">


		<tr>
			<th>Reviewer</th>
			<th>Review</th>
		</tr>

		<s:iterator value="reviewers" var="reviewer">

			<tr>
				<s:iterator value="#reviewer" var="reviewer_element" begin="0"
					end="0">
					<td><s:property value="#reviewer_element" /></td>
				</s:iterator>
				<s:url namespace="/" action="download-review" var="review_url"
					escapeAmp="false">
					<s:param name="thesis_id">
						<s:property value="#reviewer[1]" />
					</s:param>
					<s:param name="thesis_title">
						<s:property value="#reviewer[2]" />
					</s:param>
					<s:param name="reviewerId">
						<s:property value="#reviewer[3]" />
					</s:param>
				</s:url>
				<td><a href='<s:property value = "#review_url"/>'
					target="_blank"> Download</a></td>

			</tr>



		</s:iterator>

	</table>


</body>
</html>