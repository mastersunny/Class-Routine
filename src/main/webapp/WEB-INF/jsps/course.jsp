<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>Course</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/javascript/myscript.js"></script>

<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	padding: 1em;
	overflow: hidden;
}

li {
	float: left;
}

a:link, a:visited {
	display: block;
	padding-right: 2em;
	padding-left: 2em;
	padding-top: 1em;
	padding-bottom: 1em;
	font-weight: bold;
	background-color: #FFFFFF;
	text-align: center;
	text-decoration: none;
	text-transform: uppercase;
}

a:hover, a:active {
	background-color: #888888;
}

p {
	display: inline;
	font-weight: bold;
	font-family: sans-serif;
}
</style>

</head>
<body>
	<div class="container">
		<div class="jumbotron" style="text-align: center;">
			<h1>Hello Admin</h1>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="text-align: center;">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title text-primary"></h4>
					</div>
					<div class="modal-body" style="overflow: auto;">
						<div id="addDiv" style="display: none;">
							<form role="form" id="addForm">


								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Course Code</th>
											<th>Course Title</th>
											<th>Semester</th>
											<th>Session</th>
											<th>Offering Dept</th>
											<th>Credit</th>
											<th>General type</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input type="text" class="form-control"
												id="courseCode" name="courseCode"></td>
											<td><input type="text" class="form-control"
												id="courseTitle" name="courseTitle"></td>
											<td><select class="form-control" name="semester">
													<option value="11">1st year 1st semester</option>
													<option value="12">1st year 2nd semester</option>
													<option value="21">2nd year 1st semester</option>
													<option value="22">2nd year 2nd semester</option>
													<option value="31">3rd year 1st semester</option>
													<option value="32">3rd year 2nd semester</option>
													<option value="41">4th year 1st semester</option>
													<option value="42">4th year 2nd semester</option>
											</select></td>
											<td><input type="text" class="form-control" id="session"
												name="session"></td>
											<td><select class="form-control" name="offeringDept" id="offeringDept">
													<c:forEach var="depts" items="${depts}">
														<option value="${depts.deptName}">${depts.deptName}</option>
													</c:forEach>
											</select></td>
											<td><input type="text" class="form-control" id="credit"
												name="credit"></td>
											<td>
											  <select class="form-control" name="generalTypeId.generalTypeId">
											   
													<c:forEach var="gtlist" items="${gtlist}">
														<option value="${gtlist.generalTypeId}">${gtlist.type}</option>
													</c:forEach>
													
											</select>
										   </td>
										</tr>
									</tbody>
								</table>
								<div class="btn-group pull-right">
									<button type="submit" class="btn btn-default">Confirm</button>
								</div>
							</form>
						</div>

						<div id="removeDiv" style="display: none;">
							<h4></h4>
							<form role="form" id="removeForm">
								<div class="btn-group pull-right">
									<button type="submit" class="btn btn-default">Confirm</button>
								</div>
							</form>
						</div>

						<div id="updateDiv" style="display: none;">
							<form role="form" id="updateForm">

								<table class="table table-bordered">
									<thead>
										<tr>
											<th>Course Code</th>
											<th>Course Title</th>
											<th>Semester</th>
											<th>Session</th>
											<th>Offering Dept</th>
											<th>Credit</th>
											<th>General type</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input type="text" class="form-control"
												id="courseCode" name="courseCode"></td>
											<td><input type="text" class="form-control"
												id="courseTitle" name="courseTitle"></td>
											<td><select class="form-control" name="semester">
													<option value="11">1st year 1st semester</option>
													<option value="12">1st year 2nd semester</option>
													<option value="21">2nd year 1st semester</option>
													<option value="22">2nd year 2nd semester</option>
													<option value="31">3rd year 1st semester</option>
													<option value="32">3rd year 2nd semester</option>
													<option value="41">4th year 1st semester</option>
													<option value="42">4th year 2nd semester</option>
											</select></td>
											<td><input type="text" class="form-control" id="session"
												name="session"></td>
											<td><select class="form-control" name="offeringDept">
													<c:forEach var="depts" items="${depts}">
														<option value="${depts.deptId}">${depts.deptName}</option>
													</c:forEach>
											</select></td>
											<td><input type="text" class="form-control" id="credit"
												name="credit"></td>
											<td><input type="text" class="form-control"
												id="generalTypeId" name="generalTypeId.generalTypeId"></td>
										</tr>
									</tbody>
								</table>
								<div class="btn-group pull-right">
									<button type="submit" class="btn btn-default">Confirm</button>
								</div>
							</form>
						</div>


					</div>
				</div>

			</div>
		</div>

		<div class="row">
			<div class="col-md-2 col-lg-2 col-sm-3">

				<ul>
					<li><a href="${pageContext.request.contextPath}/admin/course">Course</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/room">Room</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/teacher">Teacher</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/teaches">Teaches</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/exam">Exam</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/examcommittee">Exam
							Committee</a></li>
				</ul>
			</div>
			<div class="col-md-10 col-lg-10">

				<div class="row">
					<div class="col-md-10">
						<table class="table table-bordered" id="showCourses">
							<thead>
								<tr>
									<th>Course Code</th>
									<th>Course Title</th>
									<th>Semester</th>
									<th>Session</th>
									<th>Offering Dept</th>
									<th>credit</th>
									<th>General Type</th>
									<th>Select To change</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="course" items="${courses}">
									<tr>
										<td>${course.courseCode}</td>
										<td>${course.courseTitle}</td>
										<td>${course.semester}</td>
										<td>${course.session}</td>
										<td>${course.offeringDept}</td>
										<td>${course.credit}</td>
										<td>${course.generalTypeId.type}</td>
										<td><input class="select" type="radio" name="courseCode"
											value="${course.courseCode}"></td>

									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<div class="btn-group-vertical" style="position: relative;">
						<button id="add" type="button" class="btn btn-success"
							data-toggle="modal" data-target="#myModal">
							<span class="glyphicon glyphicon-plus-sign"></span> Add
						</button>
						<button id="remove" type="button" class="btn btn-danger"
							data-toggle="modal" data-target="#myModal">
							<span class="glyphicon glyphicon-minus-sign"></span> Remove
						</button>
						<button id="update" type="button" class="btn btn-primary"
							data-toggle="modal" data-target="#myModal">
							<span class="glyphicon glyphicon-edit"></span> Update
						</button>
					</div>
				</div>

			</div>
		</div>



	</div>


	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							$('button#add').on('click', function() {

								$('#removeDiv').hide();
								$('#updateDiv').hide();
								$('#addDiv').show();
								$('.modal-title').text("Add Course");
							});

							var courseCodeSelected = "";
							var update = false;
							$("tbody input.select").on("click", function() {

								courseCodeSelected = $('input:checked').val();
								//console.log(courseCodeSelected);

							});

							$('button#remove')
									.on(
											'click',
											function() {

												$('#addDiv').hide();
												$('#updateDiv').hide();
												$('.modal-title').text(
														"Delete Course");
												$('#removeDiv').show();

												if (courseCodeSelected == "") {

													$('#removeDiv h4')
															.empty()
															.append(
																	"please select a course to remove")
															.addClass(
																	'text-warning');
												} else {

													$('.modal-title')
															.text(
																	"Delete Course -- "
																			+ courseCodeSelected);
													$('#removeDiv h4')
															.empty()
															.append(
																	"Your deleting the course  "
																			+ courseCodeSelected)
															.addClass(
																	'text-danger');

												}

											});

							$('#addForm').submit(function(e) {
                                  
								e.preventDefault();
								
								console.log($(this).serialize());
								    
								$.ajax({
									
									url : '${pageContext.request.contextPath}/admin/addcourse',
									type : 'POST',
									dataType: 'json', 
									data : $(this).serialize(),
									success : function(data) {
                                     
										$('#showCourses tbody')
									    .append("<tr>"
									    +"<td>"+data.courseCode+"</td>"
									    +"<td>"+data.courseTitle+"</td>"
							            +"<td>"+data.semester+"</td>"
									    +"<td>"+data.session+"</td>"
								        +"<td>"+data.offeringDept+"</td>"
									    +"<td>"+data.credit+"</td>"
									    +"<td>"+data.generalTypeId.type+"</td>"
									    +"<td><input class='new' type='radio' name='courseCode' value="
									    + data.courseCode + "></td>"
									    +"</tr>");
										
										$('#showCourses tbody input.new').click(function(){
											
											courseCodeSelected = $('input:checked').val();
											console.log(courseCodeSelected);
											
										});
										
									},
									error : function(data,status,er) {
							             alert("error: "+ data+ " status: "	+ status + " er:" + er);
									}
								});
									
									
									

						 });

							$('#removeForm')
									.submit(
											function(e) {

												e.preventDefault();
												if (courseCodeSelected != "") {

													$
															.ajax({
																url : '${pageContext.request.contextPath}/admin/deletecourse',
																type : 'POST',
																//dataType: 'json', 
																data : {
																	courseCode : courseCodeSelected
																},
																//contentType: 'application/json',
																//mimeType: 'application/json',
																success : function(
																		data) {

																	window
																			.alert("ok")
																},
																error : function(
																		data,
																		status,
																		er) {
																	alert("error: "
																			+ data
																			+ " status: "
																			+ status
																			+ " er:"
																			+ er);
																}
															});
												}

											});

							$('button#update')
									.on(
											'click',
											function() {

												$('.modal-title').text(
														"Update Course");
												$('#addDiv').hide();
												$('#removeDiv').show();
												$('#updateDiv').hide();

												if (courseCodeSelected == "") {
													$('#removeDiv h4')
															.empty()
															.append(
																	"please select a course to update")
															.addClass(
																	'text-warning');
												} else {

													$('.modal-title')
															.text(
																	"Update Course -- "
																			+ courseCodeSelected);
													$('#updateDiv').show();
													$('#removeDiv').hide();

													$
															.ajax({
																url : '${pageContext.request.contextPath}/admin/getCourseByCourseCode',
																type : 'POST',
																dataType : 'json',
																data : {
																	courseCode : courseCodeSelected
																},

																success : function(
																		data) {

																	console
																			.log(data.courseCode);
																	$(
																			'#updateForm input#courseCode')
																			.val(
																					data.courseCode);
																	$(
																			'#updateForm input#courseTitle')
																			.val(
																					data.courseTitle);
																	$(
																			'#updateForm input#session')
																			.val(
																					data.session);
																	$(
																			'#updateForm input#credit')
																			.val(
																					data.credit);
																	$(
																			'#updateForm input#generalTypeId')
																			.val(
																					data.generalTypeId);

																},
																error : function(
																		data,
																		status,
																		er) {
																	alert("error: "
																			+ data
																			+ " status: "
																			+ status
																			+ " er:"
																			+ er);
																}
															});

												}
											});
							$('#updateForm')
									.on(
											'submit',
											function(e) {

												e.preventDefault();
												var course = $(this)
														.serialize();
												console.log(course);
												if (courseCodeSelected != "") {

													$
															.ajax({
																url : '${pageContext.request.contextPath}/admin/updatecourse',
																type : 'POST',
																//dataType: 'json', 
																data : $(this)
																		.serialize(),
																success : function(
																		data) {

																	window
																			.alert("ok");
																},
																error : function(
																		data,
																		status,
																		er) {
																	alert("error: "
																			+ data
																			+ " status: "
																			+ status
																			+ " er:"
																			+ er);
																}
															});
												}

											});

						});
	</script>

</body>
</html>