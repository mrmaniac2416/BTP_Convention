<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<sj:head jqueryui="true" />
<title>Insert title here</title>
</head>
<body>

	<form id="reviewer">
		<div id="accordion">
			<div class="card">
				<div class="card-header">
					<a class="card-link" data-toggle="collapse" href="#collapseOne">
						Reviewer - 1 </a>
				</div>
				<div id="collapseOne" class="collapse show" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerEmails" id="r1"
							emptyOption="true" headerKey="-1" name="reviewersEmail"
							headerValue="Please Select a reviewer" />
						<br />
						<s:textfield id="r1Name" label="Name"></s:textfield>
						<s:textfield id="r1Designation" label="Designation"></s:textfield>
						<s:textfield id="r1Affiliation" label="Affiliation"></s:textfield>
						<s:textfield id="r1ContactNo" label="Contact No"></s:textfield>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="collapsed card-link" data-toggle="collapse"
						href="#collapseTwo"> Reviewer - 2 </a>
				</div>
				<div id="collapseTwo" class="collapse" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerEmails" id="r2"
							emptyOption="true" headerKey="-1" name="reviewersEmail"
							headerValue="Please Select a reviewer" />
						<br />
						<s:textfield id="r2Name" label="Name"></s:textfield>
						<s:textfield id="r2Designation" label="Designation"></s:textfield>
						<s:textfield id="r2Affiliation" label="Affiliation"></s:textfield>
						<s:textfield id="r2ContactNo" label="Contact No"></s:textfield>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="collapsed card-link" data-toggle="collapse"
						href="#collapseThree"> Reviewer - 3 </a>
				</div>
				<div id="collapseThree" class="collapse" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerEmails" id="r3"
							emptyOption="true" headerKey="-1" name="reviewersEmail"
							headerValue="Please Select a reviewer" />

						<br />
						<s:textfield id="r3Name" label="Name"></s:textfield>
						<s:textfield id="r3Designation" label="Designation"></s:textfield>
						<s:textfield id="r3Affiliation" label="Affiliation"></s:textfield>
						<s:textfield id="r3ContactNo" label="Contact No"></s:textfield>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="collapsed card-link" data-toggle="collapse"
						href="#collapseFour"> Reviewer - 4 </a>
				</div>
				<div id="collapseFour" class="collapse" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerEmails" id="r4"
							emptyOption="true" headerKey="-1" name="reviewersEmail"
							headerValue="Please Select a reviewer" />
						<br />
						<s:textfield id="r4Name" label="Name"></s:textfield>
						<s:textfield id="r4Designation" label="Designation"></s:textfield>
						<s:textfield id="r4Affiliation" label="Affiliation"></s:textfield>
						<s:textfield id="r4ContactNo" label="Contact No"></s:textfield>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="collapsed card-link" data-toggle="collapse"
						href="#collapseFive"> Reviewer - 5 </a>
				</div>
				<div id="collapseFive" class="collapse" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerEmails" id="r5"
							emptyOption="true" headerKey="-1" name="reviewersEmail"
							headerValue="Please Select a reviewer" />
						<br />
						<s:textfield id="r5Name" label="Name"></s:textfield>
						<s:textfield id="r5Designation" label="Designation"></s:textfield>
						<s:textfield id="r5Affiliation" label="Affiliation"></s:textfield>
						<s:textfield id="r5ContactNo" label="Contact No"></s:textfield>
					</div>
				</div>
			</div>
		</div>
		<input id="submitbutton" type="submit" value="Submit" />
	</form>

	<script>
		/* var counter = 3;
		$('document')
				.ready(
						function() {

							$("#addAccordion")
									.click(
											function() {
												counter = counter + 1;
												var content = '<div class="card"><div class="card-header"><a class="card-link" data-toggle="collapse" href="#collapse'+counter+'">Reviewer - '
														+ counter
														+ '</a></div><div id="collapse'+counter+'" class="collapse show" data-parent="#accordion"><div id="selectadd" class="card-body"><select id="r'+counter+'"><s:iterator value="reviewerList" var="reviewerList"><option><s:property value="#reviewerList.reviewerId.email_id" /></option></s:iterator></select><br /><s:textfield id="r3Name" label="Name"></s:textfield><s:textfield id="r3Designation" label="Designation"></s:textfield><s:textfield id="r3Affiliation" label="Affiliation"></s:textfield><s:textfield id="r3ContactNo" label="Contact No"></s:textfield></div></div> </div>';
												if (counter == 5) {
													document.getElementById(
															'addAccordion')
															.remove();
												}
												$("#accordion").append(content);
												$("#accordion").accordion(
														"refresh");

											});

						}); */

		$('document')
				.ready(
						function() {

							$('select')
									.change(
											function() {
												var dropdownId = $(this).attr(
														'id');
												var reviewerEmail = $(this)
														.val();
												$
														.ajax({
															type : 'GET',
															url : '/BTP_Convention/supervisor/get-reviewer-from-email?email='
																	+ reviewerEmail,
															success : function(
																	data) {
																$(
																		'#'
																				+ dropdownId
																				+ 'Name')
																		.val(
																				data.reviewerFromEmail.name);
																$(
																		'#'
																				+ dropdownId
																				+ 'Designation')
																		.val(
																				data.reviewerFromEmail.designation);
																$(
																		'#'
																				+ dropdownId
																				+ 'Affiliation')
																		.val(
																				data.reviewerFromEmail.affiliation);
																$(
																		'#'
																				+ dropdownId
																				+ 'ContactNo')
																		.val(
																				data.reviewerFromEmail.contact_no);

															}
														});
											});
						});
	</script>

</body>
</html>