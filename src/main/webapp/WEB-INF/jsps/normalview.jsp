<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/javascript/myscript.js"></script>

<link
	href="${pageContext.request.contextPath}/resources/css/mystyle.css"
	rel="stylesheet">

<title>NormalView</title>

</head>
<body>

	<%@ include file="/WEB-INF/jsps/header.jsp"%>

	<div class="container-fluid">

		<div class="row">
			<div id="directLogin"
				class="col-md-offset-9 col-xs-offset-9 col-md-3">
				<form role="form" id="loginform" class="well" method="post"
					action="${pageContext.request.contextPath}/api/login">
					<div class="form-group">
						<label for="userid">User ID:</label> <input class="form-control"
							type="text" id="userid" name="userReg" />
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input
							class="form-control" type="text" id="password" name="password" />
					</div>
					<div class="btn-group">
						<button type="submit" class="btn btn-primary">login</button>
					</div>
					<div class="btn-group pull-right">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#myModal">Sign Up</button>
					</div>
				</form>
			</div>
		</div>

		<div class="row" style="position: relative;">
			<div class="col-xs-9">
				<div class="row">
					<div class="col-xs-offset-1 col-xs-1 col">
						<h4>DAY</h4>
					</div>
					<div class="col-xs-1 col">
						<h5>08-09</h5>
					</div>
					<div class="col-xs-1 col">
						<h5>09-10</h5>
					</div>
					<div class="col-xs-1 col">
						<h5>10-11</h5>
					</div>
					<div class="col-xs-1 col">
						<h5>11-12</h5>
					</div>
					<div class="col-xs-1 col">
						<h5>12-01</h5>
					</div>
					<div class="col-xs-1 col">
						<h5>01-02</h5>
					</div>
					<div class="col-xs-1 col">
						<h5>02-03</h5>
					</div>
					<div class="col-xs-1 col">
						<h5>03-04</h5>
					</div>
					<div class="col-xs-1 col">
						<h5>04-05</h5>
					</div>
				</div>
				<c:forEach var="i" begin="1" end="7">
					<div class="row">
						<c:choose>
							<c:when test="${i==1}">
								<div class="col-xs-offset-1 col-xs-1 col">
									<h4>Sun</h4>
								</div>
							</c:when>
							<c:when test="${i==2}">
								<div class="col-xs-offset-1 col-xs-1 col">
									<h4>Mon</h4>
								</div>
							</c:when>
							<c:when test="${i==3}">
								<div class="col-xs-offset-1 col-xs-1 col">
									<h4>Tue</h4>
								</div>
							</c:when>
							<c:when test="${i==4}">
								<div class="col-xs-offset-1 col-xs-1 col">
									<h4>Wed</h4>
								</div>
							</c:when>
							<c:when test="${i==5}">
								<div class="col-xs-offset-1 col-xs-1 col">
									<h4>Thu</h4>
								</div>
							</c:when>
							<c:when test="${i==6}">
								<div class="col-xs-offset-1 col-xs-1 col">
									<h4>Fri</h4>
								</div>
							</c:when>
							<c:when test="${i==7}">
								<div class="col-xs-offset-1 col-xs-1 col">
									<h4>Sat</h4>
								</div>
							</c:when>
						</c:choose>

						<c:set var="flag" value="${0}"></c:set>

						<c:forEach var="j" begin="8" end="16">
							<c:forEach var="routine" items="${routines}">
								<c:if test="${routine.dayId.dayId==i && routine.startTime==j}">
									<c:choose>
										<c:when test="${(routine.endTime-routine.startTime)==1}">
											<div class="col-xs-1 col1">
												<ul>
													<li>${routine.teachesId.courseId.courseCode}</li>
													<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
													<li>${routine.teachesId.instructorId.employeeCode}</li>
												</ul>
											</div>
											<c:set var="flag" value="${1}"></c:set>
										</c:when>
										<c:when test="${(routine.endTime-routine.startTime)==2}">
											<div class="col-xs-2 col2">
												<ul>
													<li>${routine.teachesId.courseId.courseCode}</li>
													<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
													<li>${routine.teachesId.instructorId.employeeCode}</li>
												</ul>
											</div>
											<c:set var="flag" value="${2}"></c:set>
										</c:when>
										<c:when test="${(routine.endTime-routine.startTime)==3}">
											<div class="col-xs-3 col3">
												<ul>
													<li>${routine.teachesId.courseId.courseCode}</li>
													<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
													<li>${routine.teachesId.instructorId.employeeCode}</li>
												</ul>
											</div>
											<c:set var="flag" value="${3}"></c:set>
										</c:when>
									</c:choose>
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${flag!=0}">
									<c:set var="flag" value="${flag-1}"></c:set>
								</c:when>
								<c:otherwise>
									<div class="col-xs-1 empty"></div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
		</div>

	</div>

	<script type="text/javascript">
		
	</script>

</body>
</html>