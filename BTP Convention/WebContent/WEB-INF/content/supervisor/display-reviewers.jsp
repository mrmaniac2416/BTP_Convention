<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<sj:head jqueryui="true"/>

</head>
<body>

	<ol>
		<s:iterator value="reviewers" var="reviewer">
			<s:url action="display-reviewer-details"
				var="displayReviewerDetails_url" escapeAmp="false">
 				<s:param name="reviewer_email_id"><s:property value="#reviewer.reviewerId.email_id"/> </s:param> 
 				<s:param name="reviewer_supervisor_id"><s:property value="#reviewer.reviewerId.supervisor_id"/> </s:param>
				

			</s:url>

			<li><sj:a href="%{displayReviewerDetails_url}" targets="reviewerDetails" >
					<s:property value="#reviewer.name" />
				</sj:a></li>
		</s:iterator>
	</ol>


	<div id="reviewerDetails"></div>


</body>
</html>