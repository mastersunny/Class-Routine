<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css">

<script
	src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/javascript/jquery-ui.min.js"></script>

<link
	href="${pageContext.request.contextPath}/resources/css/teacherstyle.css"
	rel="stylesheet">

<script
	src="${pageContext.request.contextPath}/resources/javascript/create-routine.js"></script>



<title>Final Routine</title>

</head>

<body>
	<%@ include file="/WEB-INF/jsps/headerteacher.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-xs-6">
				<h2>Course List</h2>
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th>Course Code</th>
							<th>Semester</th>
							<th>Session</th>
							<th>Status</th>
							<th>Credit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="course" items="${courses}">
							<tr class="drag">
								<td data-id="${course.courseId}">${course.courseCode}</td>
								<td>${course.semester}</td>
								<td>${course.session}</td>
								<td>${course.generalTypeId.type}</td>
								<td>${course.credit}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-xs-5">
				<h2>Teacher List</h2>
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th>Employee Code</th>
							<th>Designation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="teacher" items="${teachers}">
							<tr class="drag">
								<td data-id="${teacher.instructorId}">${teacher.employeeCode}</td>
								<td>${teacher.desigId.desigName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6">
				<table class="table table-hover table-bordered" id="assign-teacher">
					<thead>
						<tr>
							<th>Course Code</th>
							<th>Teacher Code</th>
							<th>Edit / Delete</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			<div class="col-xs-5 drop"
				style="height: 30em; border: 0.1em solid black;">
				<p class="text-primary">Drop here to assign teacher course</p>
			</div>
		</div>
		<br /> <br />
		<div class="row" align="center">
			<button class="btn btn-primary btn-large" id="createRoutine">Create Routine</button>
		</div>
		<br /> <br />
	</div>
	
	<script type="text/javascript">
		var pageUrl = '${pageContext.request.contextPath}';
	</script>
</body>
</html>