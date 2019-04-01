<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/utils.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="${pageContext.request.contextPath}/struts/xhtml/validation.js"
	type="text/javascript"></script>
<sj:head jqueryui="true" />
<%-- <sb:head includeScripts="true"/> --%>
<script
  src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>
 
 <script>
 $.subscribe('refresh',function(event,data){
	  
	  
		$('#localtabs').tabs();
		$('#localtabs').tabs("load", "#tab2");
		$('#localtabs').tabs("load", "#tab1");
		alert("Reviewers list submitted");
	  
	});
 </script>
<title>Insert title here</title>
</head>
<body>

       

	 	<s:form id="reviewer" action="submit-reviewers" theme="bootstrap">
		<div id="accordion">
			<div class="card">
				<div class="card-header">
					<a class="card-link" data-toggle="collapse" href="#collapseOne">
						Reviewer - 1 </a>
				</div>
				<div id="collapseOne" class="collapse show" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerIndianEmails" id="r1"
							 headerKey="-1" name="reviewersIndianEmail"
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
						<sj:select href="%{remoteurl}" list="reviewerIndianEmails" id="r2"
							 headerKey="-1" name="reviewersIndianEmail"
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
						<sj:select href="%{remoteurl}" list="reviewerIndianEmails" id="r3"
							headerKey="-1" name="reviewersIndianEmail"
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
						<sj:select href="%{remoteurl}" list="reviewerIndianEmails" id="r4"
							 headerKey="-1" name="reviewersIndianEmail"
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
						<sj:select href="%{remoteurl}" list="reviewerIndianEmails" id="r5"
							 headerKey="-1" name="reviewersIndianEmail"
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		<div>Abroad Reviewers</div>
		
		<div id="accordion">
			<div class="card">
				<div class="card-header">
					<a class="card-link" data-toggle="collapse" href="#collapseSix">
						Reviewer - 1 </a>
				</div>
				<div id="collapseSix" class="collapse show" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerAbroadEmails" id="r6"
							 headerKey="-1" name="reviewersAbroadEmail"
							headerValue="Please Select a reviewer" />
						<br />
						<s:textfield id="r6Name" label="Name"></s:textfield>
						<s:textfield id="r6Designation" label="Designation"></s:textfield>
						<s:textfield id="r6Affiliation" label="Affiliation"></s:textfield>
						<s:textfield id="r6ContactNo" label="Contact No"></s:textfield>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="collapsed card-link" data-toggle="collapse"
						href="#collapseSeven"> Reviewer - 2 </a>
				</div>
				<div id="collapseSeven" class="collapse" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerAbroadEmails" id="r7"
							 headerKey="-1" name="reviewersAbroadEmail"
							headerValue="Please Select a reviewer" />
						<br />
						<s:textfield id="r7Name" label="Name"></s:textfield>
						<s:textfield id="r7Designation" label="Designation"></s:textfield>
						<s:textfield id="r7Affiliation" label="Affiliation"></s:textfield>
						<s:textfield id="r7ContactNo" label="Contact No"></s:textfield>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="collapsed card-link" data-toggle="collapse"
						href="#collapseEigth"> Reviewer - 3 </a>
				</div>
				<div id="collapseEigth" class="collapse" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerAbroadEmails" id="r8"
							 headerKey="-1" name="reviewersAbroadEmail"
							headerValue="Please Select a reviewer" />

						<br />
						<s:textfield id="r8Name" label="Name"></s:textfield>
						<s:textfield id="r8Designation" label="Designation"></s:textfield>
						<s:textfield id="r8Affiliation" label="Affiliation"></s:textfield>
						<s:textfield id="r8ContactNo" label="Contact No"></s:textfield>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="collapsed card-link" data-toggle="collapse"
						href="#collapseNine"> Reviewer - 4 </a>
				</div>
				<div id="collapseNine" class="collapse" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerAbroadEmails" id="r9"
							 headerKey="-1" name="reviewersAbroadEmail"
							headerValue="Please Select a reviewer" />
						<br />
						<s:textfield id="r9Name" label="Name"></s:textfield>
						<s:textfield id="r9Designation" label="Designation"></s:textfield>
						<s:textfield id="r9Affiliation" label="Affiliation"></s:textfield>
						<s:textfield id="r9ContactNo" label="Contact No"></s:textfield>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="collapsed card-link" data-toggle="collapse"
						href="#collapseTen"> Reviewer - 5 </a>
				</div>
				<div id="collapseTen" class="collapse" data-parent="#accordion">
					<div class="card-body">
						<s:url var="remoteurl" action="get-reviewer-emails" />
						<sj:select href="%{remoteurl}" list="reviewerAbroadEmails" id="r10"
							 headerKey="-1" name="reviewersAbroadEmail"
							headerValue="Please Select a reviewer" />
						<br />
						<s:textfield id="r10Name" label="Name"></s:textfield>
						<s:textfield id="r10Designation" label="Designation"></s:textfield>
						<s:textfield id="r10Affiliation" label="Affiliation"></s:textfield>
						<s:textfield id="r10ContactNo" label="Contact No"></s:textfield>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<s:hidden name="thesis_id" value="%{thesis_id}" />
		<sj:submit value="Submit" validate="true" targets="errorShowing" validateFunction="bootstrapValidation" onCompleteTopics="refresh"></sj:submit>
		<!-- <input id="submitbutton" type="submit" value="Submit" /> -->
	</s:form>
	
<s:if test="hasActionErrors()">
<s:actionerror/>
</s:if>
<div id="errorShowing"></div>





















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
																				data.reviewerFromEmail.contact);

															}
														});
											});
						});
	</script>

</body>
</html>