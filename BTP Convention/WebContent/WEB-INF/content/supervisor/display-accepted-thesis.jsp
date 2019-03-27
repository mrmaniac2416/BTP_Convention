<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<sj:head jqueryui="true" />
</head>
<body>

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
									<s:param name="thesis_id">
									<s:property value="#thesis[0]"/>
									</s:param>

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

</body>
</html>