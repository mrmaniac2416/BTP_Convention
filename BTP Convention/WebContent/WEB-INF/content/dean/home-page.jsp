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
<script>
$.subscribe('dialogclosetopic', function(event,ui) {
	console.log('run topic on dialog close');
	window.location.reload(true);
});

function closeDialog(){
	console.log('closed dialog called.');
    $('#myclickdialog').dialog('close');
};

</script>
<title></title>
</head>
<body>

	<s:include value="home-navbar.jsp" />

	<s:if test="deanProfile.isEmpty()">
		<div class="noUpdateMesage">No new updates to show!</div>
	</s:if>
	
		<table style="margin-top: 1%">
		<s:else>
			<tr>
				<th>Thesis ID</th>
				<th>Thesis title</th>
				<th>Student Name</th>
				<th>Supervisor</th>
				<th>Submitted date</th>
				<th>Status</th>
				<th>Reviewer List</th>
				<th>Defended</th>
			</tr>
			<s:iterator value="deanProfile" var="thesis">
				<tr>


					<s:url action="display-reviewer-list" var="reviewer_url"
						escapeAmp="false">
						<s:param name="thesisId">
							<s:property value="#thesis[0]" />
						</s:param>
					</s:url>

					<s:iterator value="#thesis" var="thesis_element" begin="0" end="3">
						<td><s:property value="#thesis_element" /></td>
					</s:iterator>

					<td><s:date name="#thesis[4]" format="dd,MMMMM yyyy" /></td>

					<td><s:property value="#thesis[5]" /></td>



					<td><a href='<s:property value = "#reviewer_url"/>'>View
							Reviewers</a></td>
					<s:if test="#thesis[5].equals('reviewed')">		
					<s:url action="send-to-archives-modal" var="sendToArchivesModal_url"
					escapeAmp="false">
					<s:param name="thesisId">
						<s:property value="#thesis[0]" />
					</s:param>
				</s:url>		
					<td><sj:a openDialog="myclickdialog" href="%{sendToArchivesModal_url}">
							Send to archives
						</sj:a></td>
						</s:if>
					<s:else>
					<td><b>&mdash;</b></td>
					</s:else>
						

					

				</tr>
				 <sj:dialog id="myclickdialog" autoOpen="false" modal="true" title="Send to archives" 
             showEffect="slide" hideEffect="slide">
          
      
       
       
	</sj:dialog>

			</s:iterator>
			</s:else>
		</table>
            
	
	
	
</body>
</html>