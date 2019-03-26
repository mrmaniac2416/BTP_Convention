<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
						<select id="dropdown">
							<s:iterator value="reviewerList" var="reviewerList">
								<option><s:property value="#reviewerList.name" />
								</option>
							</s:iterator>
						</select> <input type="text" id="name" />
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="collapsed card-link" data-toggle="collapse"
						href="#collapseTwo"> Reviewer - 2 </a>
				</div>
				<div id="collapseTwo" class="collapse" data-parent="#accordion">
					<div class="card-body">Lorem</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="collapsed card-link" data-toggle="collapse"
						href="#collapseThree"> Reviewer - 3 </a>
				</div>
				<div id="collapseThree" class="collapse" data-parent="#accordion">
					<div class="card-body">Lorem</div>
				</div>
			</div>
		</div>
		<input id="submitbutton" type="submit" value="Submit" /> <input
			type="button" id="addAccordion" value="Add Reviewer"></input>
	</form>

	<script>
		/* $(document).ready(function(){
		

		$(function() {
		$("#accordion").accordion({
			collapsible : true,
			active : false,
		});

		$("#addAccordion")
				.click(
						function() {
							var content = '<div class = "new_panel"><label></label><br><br><label for="in" name="question">Edit Question:</label> <input type="text" name = "question" value = ""/><br><br>'
									+ ' <label name="SQL">Edit SQL code here:</label><textarea name = "code"></textarea>';
							$("#accordion").append(content);
							$("#accordion").find("h3").not(":first").css({
								"background" : "none"
							})
							$("#accordion").accordion("refresh");
							counter++;
							$(":button").click(edit);
						});
		})  */
		var counter = 3;
		$('document')
				.ready(
						function() {

							/* $("#accordion").accordion({
							collapsible : true,
							active : false,
							}); */
							$("#addAccordion")
									.click(
											function() {
												counter = counter + 1;
												var content = '<div class="card"><div class="card-header"><a class="card-link" data-toggle="collapse" href="#collapse'+counter+'">Reviewer - '
														+ counter
														+ '</a></div><div id="collapse'+counter+'" class="collapse show" data-parent="#accordion"><div class="card-body"><input type="button" id="delete" value="Delete Reviewer"></input></div></div> </div>';
												if (counter == 5) {
													document.getElementById(
															'addAccordion')
															.remove();
												}
												$("#accordion").append(content);
												$("#accordion").accordion(
														"refresh");

											});

						});

		$('document')
				.ready(
						function() {

							/* $("#dropdown")
									.change(
											function() {
												/* var comp = document
														.getElementById("dropdown").value;
												<s:iterator value="reviewerList" var="reviewerList">
												if($('option:selected').text==<s:property value="#reviewerList.name" />){
													 $("#name")
															.val(document
																	.getElementById("dropdown").value);/* 
												}
												</s:iterator>
											}); */
						});
	</script>

</body>
</html>