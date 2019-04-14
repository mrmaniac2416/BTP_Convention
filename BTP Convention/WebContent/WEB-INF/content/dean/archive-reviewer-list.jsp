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
<sj:head jqueryui="true" />
<title></title>
</head>
<body>

	<s:include value="archive-navbar.jsp" />

	<table>
		<tr>
			<th>Thesis title</th>
			<th>Student Name</th>
			<th>Supervisor</th>
		</tr>
		<tr>
			<s:iterator value="thesisDetails" var="detail">

				<td><s:property value="#detail" /></td>



			</s:iterator>
		</tr>
	</table>
	<br />
	<br />

	<h2>Indian Reviewer</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Affiliation</th>
			<th>Designation</th>
			<th>Contact No.</th>
			<th>Email</th>
			<th>Mail Sent Date</th>
			<th> Dean Accepted Date</th>
			<th>Accept/Status</th>
		</tr>

		<s:iterator value="indianReviewers" var="indianreviewers">
			<tr>

				<s:iterator value="#indianreviewers" var="reviewer_element"
					begin="0" end="3">
					<td><s:property value="#reviewer_element" /></td>
				</s:iterator>
				<s:url action="send-invitation-modal" var="email_url"
					escapeAmp="false">
					<s:param name="email">
						<s:property value="#indianreviewers[4]" />
					</s:param>

					<s:param name="thesisId">
						<s:property value="thesisId" />
					</s:param>
				</s:url>

				<td>
						<s:property value="#indianreviewers[4]" /></td>

				<td><s:if test="#indianreviewers[5]!=null">
						<s:date name="#indianreviewers[5]" format="dd,MMMMM yyyy" />
					</s:if> <s:else>
						<b>&mdash;</b>
					</s:else></td>
					
				<td><s:if test="#indianreviewers[7]!=null">
						<s:date name="#indianreviewers[7]" format="dd,MMMMM yyyy" />
					</s:if> <s:else>
						<b>&mdash;</b>
					</s:else></td>

				<td><s:if test="#indianreviewers[6].equals('revieweraccepted')">
						Reviewer Accepted
					</s:if> <s:elseif
						test="!(#indianreviewers[6].equals('revieweraccepted') || #indianreviewers[6].equals('selected'))">
						<div>
						 <s:if test="#indianreviewers[6].equals('deanaccepted')">
						 Accepted by dean
						 </s:if>
						 <s:elseif test="#indianreviewers[6].equals('addedToDashboard')">
						 Reviewing
						 </s:elseif>
						 <s:elseif test="#indianreviewers[6].equals('reviewSent')">
						 Review sent by reviewer
						 </s:elseif>
						 <s:else>
						 Review sent to supervisor
						 </s:else>
						
						</div>
					</s:elseif> <s:elseif test="#indianreviewers[5]!=null">
					Mail Sent</s:elseif> <s:else>
						<b>&mdash;</b>
					</s:else></td>


			</tr>

		</s:iterator>
	</table>

	<br />
	<br />
	<h2>Abroad Reviewer</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Affiliation</th>
			<th>Designation</th>
			<th>Contact No.</th>
			<th>Email</th>
			<th>Mail Sent Date</th>
			<th>Dean Accepted Date</th>
			<th>Accept/Status</th>
		</tr>

		<s:iterator value="abroadReviewers" var="abroadreviewers">
			<tr>

				<s:iterator value="#abroadreviewers" var="reviewer_element"
					begin="0" end="3">
					<td><s:property value="#reviewer_element" /></td>
				</s:iterator>
				<s:url action="send-invitation-modal" var="email_url"
					escapeAmp="false">
					<s:param name="email">
						<s:property value="#abroadreviewers[4]" />
					</s:param>

					<s:param name="thesisId">
						<s:property value="thesisId" />
					</s:param>
				</s:url>

				<td>
						<s:property value="#abroadreviewers[4]" /></td>

				<td><s:if test="#abroadreviewers[5]!=null">
						<s:date name="#abroadreviewers[5]" format="dd,MMMMM yyyy" />
					</s:if> <s:else>
						<b>&mdash;</b>
					</s:else></td>
					
					<td><s:if test="#abroadreviewers[7]!=null">
						<s:date name="#abroadreviewers[7]" format="dd,MMMMM yyyy" />
					</s:if> <s:else>
						<b>&mdash;</b>
					</s:else></td>



				<td><s:if test="#abroadreviewers[6].equals('revieweraccepted')">
						Reviewer Accepted
					</s:if> <s:elseif
						test="!(#abroadreviewers[6].equals('revieweraccepted') || #abroadreviewers[6].equals('selected'))">
						<div>
						
						 <s:if test="#abroadreviewers[6].equals('deanaccepted')">
						 Accepted by dean
						 </s:if>
						 <s:elseif test="#abroadreviewers[6].equals('addedToDashboard')">
						 Reviewing
						 </s:elseif>
						 <s:elseif test="#abroadreviewers[6].equals('reviewSent')">
						 Review sent by reviewer
						 </s:elseif>
						 <s:else>
						 Review sent to supervisor
						 </s:else>
						
						</div>
					</s:elseif> <s:elseif test="#abroadreviewers[5]!=null">
					Mail Sent</s:elseif> <s:else>
						<b>&mdash;</b>
					</s:else></td>
			</tr>

		</s:iterator>
	</table>
	<br/>
	<br/>


</body>
</html>