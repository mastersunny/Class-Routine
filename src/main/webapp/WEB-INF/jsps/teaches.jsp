<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>Room</title>

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
											<th>Room Number</th>
											<th>Building Name</th>
											<th>Department name</th>
											<th>General type</th>
											<th>Lab or not</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><input type="text" class="form-control"
												id="roomNumber" name="roomNumber"></td>
											<td><input type="text" class="form-control"
												id="buildingName" name="buildingName"></td>
											<td><select class="form-control" name="deptName">
													<option value="CSE">Computer Science and
														Engineerig</option>
													<option value="MAT">Mathematics</option>
													<option value="CEP">Chemical Engineering</option>
													<option value="EEE">Electrical Engineering</option>
													<option value="Che">Chemistry</option>
													<option value="PSS">Political Studies</option>
													<option value="FET">Forestry And Environmental
														Science</option>
													<option value="Phy">Physics</option>
											</select></td>
											<td><input type="text" class="form-control"
												id="generalTypeId" name="generalTypeId"></td>
											<td>
												<div class="radio">
													<label><input type="radio" name="optradio"
														value="1">yes</label>
												</div>
												<div class="radio">
													<label><input type="radio" name="optradio"
														value="0">no</label>
												</div>
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
					<li><a href="${pageContext.request.contextPath}/admin/examcommittee">Exam
							Committee</a></li>
				</ul>

			</div>
			<div class="col-md-10 col-lg-10">

				<div class="row">
					<div class="col-md-10">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Teacher Name</th>
									<th>Course Code</th>
									
								</tr>
							</thead>
							<tbody>

								<%-- 								<c:forEach var="room" items="${rooms}"> --%>
								<!-- 									<tr> -->
								<%-- 										<td>${course.courseCode}</td> --%>
								<%-- 										<td>${course.courseTitle}</td> --%>
								<%-- 										<td>${course.semester}</td> --%>
								<%-- 										<td>${course.session}</td> --%>
								<%-- 										<td>${course.offeringDept}</td> --%>
								<!-- 										<td><input class="select" type="radio" name="optradio" -->
								<%-- 											value="${course.courseId}"></td> --%>
								<!-- 									</tr> -->
								<%-- 								</c:forEach> --%>

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
		$(document).ready(
				function() {

					$('button#add').on('click', function() {

						$('#removeDiv').hide();
						$('#addDiv').show();
						$('.modal-title').text("Add Room");
					});

					var roomNumberSelected = "";
					$("tbody input.select").on("click", function() {

						roomNumberSelected = $('input:checked').val();
						console.log(roomNumberSelected);
					});

					$('button#remove').on(
							'click',
							function() {

								$('#addDiv').hide();
								$('.modal-title').text("Delete Room");
								$('#removeDiv').show();

								if (roomNumberSelected == "") {

									$('#removeDiv h4').empty().append(
											"please select a room to delete")
											.addClass('text-warning');
								} else {

									$('.modal-title').text(
											"Delete Room -- "
													+ roomNumberSelected);
									$('#removeDiv h4').empty().append(
											"Your deleting the room  "
													+ roomNumberSelected)
											.addClass('text-danger');

								}

							});

					$('#addForm').submit(function(e) {
						e.preventDefault();
						console.log($(this).serialize());

					});
					$('#removeForm').submit(function(e) {
						e.preventDefault();
						console.log(roomNumberSelected);
					})

					$('button#update').on(
							'click',
							function() {

								$('.modal-title').text("Update Room");
								$('#addDiv').hide();
								$('#removeDiv').show();
								if (roomNumberSelected == "") {
									$('#removeDiv h4').empty().append(
											"please select a room to update")
											.addClass('text-warning');
								} else {

									$('.modal-title').text(
											"Update Room -- "
													+ roomNumberSelected);
									$('#addDiv').show();
									$('#removeDiv').hide();
								}
							});

					$('#removeForm').submit(function(e) {
						e.preventDefault();
						console.log($(this).serialize());
					})

				});
	</script>


</body>
</html>