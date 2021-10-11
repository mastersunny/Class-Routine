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

<link
	href="${pageContext.request.contextPath}/resources/css/teacherstyle.css"
	rel="stylesheet">

<title>TeacherView</title>

</head>

<body>

	<%@ include file="/WEB-INF/jsps/headerteacher.jsp"%>

	<div class="container-fluid">

		<div class="row">
			<div class="col-xs-7 col-xs-offset-1 well">
				<ul class="nav nav-pills">
					<li><a data-toggle="pill" href="#semester1">Semester 1</a></li>
					<li><a data-toggle="pill" href="#semester2">Semester 2</a></li>
					<li><a data-toggle="pill" href="#semester3">Semester 3</a></li>
					<li><a data-toggle="pill" href="#semester4">Semester 4</a></li>
				</ul>
			</div>
		</div>

		<div class="modal fade" id="alertModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<h4 class="text-success" id="successMessage"></h4>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<div class="modal-title">
							<h4 class="text-primary"></h4>
							<h4 class="text-danger"></h4>
						</div>
					</div>
					<div class="modal-body" style="overflow: auto;">
						<div id="currentCourse"></div>

						<div id="noroom">
							<h3 class="text-danger">No room available at this moment</h3>
						</div>
						<div style="display: none; text-align: center;" id="confirmDiv"
							class="well">
							<button type="button" id="confirm" class="btn btn-lg btn-primary">Confirm</button>
							<button type="button" id="cancel" class="btn btn-lg btn-danger">Cancel</button>
						</div>
						<div id="hasroom">
							<p class="text-primary"></p>
							<table id="room-info" class="table table-bordered"
								style="text-align: center;">
								<thead>
									<tr>
										<th>Number</th>
										<th>Building</th>
										<th>Type</th>
										<th>Hours Available</th>
										<th>Select</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							<p class="text-info" id="roomHourMessage">Please select a
								time less than or equal to 3 hours</p>
							<form role="form" id="update">
								<div class="room-time" style="margin-bottom: 5%;"></div>
								<button type="submit" class="btn btn-primary btn-sm">Update</button>
							</form>
							<form role="form" id="add">
								<div class="room-time" style="margin-bottom: 5%;"></div>
								<button type="submit" class="btn btn-primary btn-sm">Add</button>
							</form>

						</div>
						<div>
							<button id="delete" type="button"
								class="btn btn-danger btn-sm pull-right">Delete</button>
						</div>
						<div id="error">
							<h3 class="text-danger">Sorry your request cannot be
								processed at this moment</h3>
						</div>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<div class="tab-content">
			<div id="semester1" data-sem="${com1}"
				class="row tab-pane fade in active">
				<div class="col-xs-10">
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

							<c:forEach var="j" begin="8" end="17">

								<c:forEach var="routine" items="${routine1}">
									<c:if test="${routine.dayId.dayId==i && routine.startTime==j}">
										<c:choose>
											<c:when test="${(routine.endTime-routine.startTime)==1}">

												<div
													class='col-xs-1 col1 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com1}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${1}">

													<ul class="each-class">
														<li>${routine.teachesId.courseId.courseCode}</li>
														<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
														<li>${routine.teachesId.instructorId.employeeCode}</li>
													</ul>

												</div>

												<c:set var="flag" value="${1}"></c:set>

											</c:when>
											<c:when test="${(routine.endTime-routine.startTime)==2}">

												<div
													class='col-xs-2 col2 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com1}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${2}">

													<ul class="each-class">
														<li>${routine.teachesId.courseId.courseCode}</li>
														<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
														<li>${routine.teachesId.instructorId.employeeCode}</li>
													</ul>
												</div>

												<c:set var="flag" value="${2}"></c:set>
											</c:when>
											<c:when test="${(routine.endTime-routine.startTime)==3}">

												<div
													class='col-xs-3 col3 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com1}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${3}">

													<ul class="each-class">
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
										<c:choose>
											<c:when test="${j!=17}">
												<div class="col-xs-1 empty courseDrop clickable"
													data-dept="${teacher.deptId.deptId}" data-sem="${com1}"
													data-day="${i}" data-time="${j}"></div>
											</c:when>
											<c:otherwise>
												<div class="col-xs-1" data-sem="${com1}" data-day="${i}"
													data-time="${j}"></div>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
				<div class="col-xs-offset-10">
					<div class="availableCourse col-xs-2"
						style="position: absolute; background-color: #F0F0F0; padding: 1em;">
						<c:choose>
							<c:when test="${teaches1==null}">
								<div style="background-color: #FFFFFF;">
									<p>You have no courses available to add</p>
								</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="teach" items="${teaches1}">
									<div style="background-color: #FFFFFF" class="drag"
										data-new="newCourse" data-teaches="${teach.teachesId}">
										<p style="font-weight: bold; font-family: sans-serif;">Course
											Code: ${teach.courseId.courseCode}</p>
										<p style="font-family: sans-serif;">Available Hours:
											${teach.courseId.hour}</p>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<div id="semester2" data-sem="${com2}" class="row tab-pane fade">
				<div class="col-xs-10">
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

							<c:forEach var="j" begin="8" end="17">

								<c:forEach var="routine" items="${routine2}">
									<c:if test="${routine.dayId.dayId==i && routine.startTime==j}">
										<c:choose>
											<c:when test="${(routine.endTime-routine.startTime)==1}">

												<div
													class='col-xs-1 col1 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com2}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${1}">

													<ul class="each-class">
														<li>${routine.teachesId.courseId.courseCode}</li>
														<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
														<li>${routine.teachesId.instructorId.employeeCode}</li>
													</ul>

												</div>

												<c:set var="flag" value="${1}"></c:set>

											</c:when>
											<c:when test="${(routine.endTime-routine.startTime)==2}">

												<div
													class='col-xs-2 col2 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com2}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${2}">

													<ul class="each-class">
														<li>${routine.teachesId.courseId.courseCode}</li>
														<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
														<li>${routine.teachesId.instructorId.employeeCode}</li>
													</ul>
												</div>

												<c:set var="flag" value="${2}"></c:set>
											</c:when>
											<c:when test="${(routine.endTime-routine.startTime)==3}">

												<div
													class='col-xs-3 col3 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com2}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${3}">

													<ul class="each-class">
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
										<c:choose>
											<c:when test="${j!=17}">
												<div class="col-xs-1 empty courseDrop clickable"
													data-dept="${teacher.deptId.deptId}" data-sem="${com2}"
													data-day="${i}" data-time="${j}"></div>
											</c:when>
											<c:otherwise>
												<div class="col-xs-1" data-sem="${com2}" data-day="${i}"
													data-time="${j}"></div>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
				<div class="col-xs-offset-10">
					<div class="availableCourse col-xs-2"
						style="position: absolute; background-color: #F0F0F0; padding: 1em;">
						<c:choose>
							<c:when test="${teaches2==null}">
								<div style="background-color: #FFFFFF;">
									<p>You have no courses available to add</p>
								</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="teach" items="${teaches2}">
									<div style="background-color: #FFFFFF" class="drag"
										data-new="newCourse" data-teaches="${teach.teachesId}">
										<p style="font-weight: bold; font-family: sans-serif;">Course
											Code: ${teach.courseId.courseCode}</p>
										<p style="font-family: sans-serif;">Available Hours:
											${teach.courseId.hour}</p>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>

			<div id="semester3" data-sem="${com3}" class="row tab-pane fade">
				<div class="col-xs-10">
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

							<c:forEach var="j" begin="8" end="17">

								<c:forEach var="routine" items="${routine3}">
									<c:if test="${routine.dayId.dayId==i && routine.startTime==j}">
										<c:choose>
											<c:when test="${(routine.endTime-routine.startTime)==1}">

												<div
													class='col-xs-1 col1 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com3}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${1}">

													<ul class="each-class">
														<li>${routine.teachesId.courseId.courseCode}</li>
														<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
														<li>${routine.teachesId.instructorId.employeeCode}</li>
													</ul>

												</div>

												<c:set var="flag" value="${1}"></c:set>

											</c:when>
											<c:when test="${(routine.endTime-routine.startTime)==2}">

												<div
													class='col-xs-2 col2 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com3}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${2}">

													<ul class="each-class">
														<li>${routine.teachesId.courseId.courseCode}</li>
														<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
														<li>${routine.teachesId.instructorId.employeeCode}</li>
													</ul>
												</div>

												<c:set var="flag" value="${2}"></c:set>
											</c:when>
											<c:when test="${(routine.endTime-routine.startTime)==3}">

												<div
													class='col-xs-3 col3 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com3}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${3}">

													<ul class="each-class">
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
										<c:choose>
											<c:when test="${j!=17}">
												<div class="col-xs-1 empty courseDrop clickable"
													data-dept="${teacher.deptId.deptId}" data-sem="${com3}"
													data-day="${i}" data-time="${j}"></div>
											</c:when>
											<c:otherwise>
												<div class="col-xs-1" data-sem="${com3}" data-day="${i}"
													data-time="${j}"></div>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
				<div class="col-xs-offset-10">
					<div class="availableCourse col-xs-2"
						style="position: absolute; background-color: #F0F0F0; padding: 1em;">
						<c:choose>
							<c:when test="${teaches3==null}">
								<div style="background-color: #FFFFFF;">
									<p>You have no courses available to add</p>
								</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="teach" items="${teaches3}">
									<div style="background-color: #FFFFFF" class="drag"
										data-new="newCourse" data-teaches="${teach.teachesId}">
										<p style="font-weight: bold; font-family: sans-serif;">Course
											Code: ${teach.courseId.courseCode}</p>
										<p style="font-family: sans-serif;">Available Hours:
											${teach.courseId.hour}</p>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>


			</div>

			<div id="semester4" data-sem="${com4}" class="row tab-pane fade">
				<div class="col-xs-10">
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

							<c:forEach var="j" begin="8" end="17">

								<c:forEach var="routine" items="${routine4}">
									<c:if test="${routine.dayId.dayId==i && routine.startTime==j}">
										<c:choose>
											<c:when test="${(routine.endTime-routine.startTime)==1}">

												<div
													class='col-xs-1 col1 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com4}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${1}">

													<ul class="each-class">
														<li>${routine.teachesId.courseId.courseCode}</li>
														<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
														<li>${routine.teachesId.instructorId.employeeCode}</li>
													</ul>

												</div>

												<c:set var="flag" value="${1}"></c:set>

											</c:when>
											<c:when test="${(routine.endTime-routine.startTime)==2}">

												<div
													class='col-xs-2 col2 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com4}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${2}">

													<ul class="each-class">
														<li>${routine.teachesId.courseId.courseCode}</li>
														<li>${routine.roomId.roomNum}--${routine.roomId.buildingId.buildingName}</li>
														<li>${routine.teachesId.instructorId.employeeCode}</li>
													</ul>
												</div>

												<c:set var="flag" value="${2}"></c:set>
											</c:when>
											<c:when test="${(routine.endTime-routine.startTime)==3}">

												<div
													class='col-xs-3 col3 <c:if test="${routine.teachesId.instructorId.instructorId==teacher.instructorId}">drag clickable</c:if>'
													data-dept="${teacher.deptId.deptId}"
													data-teaches="${routine.teachesId.teachesId}"
													data-sem="${com4}" data-day="${i}"
													data-id="${routine.mainRoutineId}" data-time="${j}"
													data-hour="${3}">

													<ul class="each-class">
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
										<c:choose>
											<c:when test="${j!=17}">
												<div class="col-xs-1 empty courseDrop clickable"
													data-dept="${teacher.deptId.deptId}" data-sem="${com4}"
													data-day="${i}" data-time="${j}"></div>
											</c:when>
											<c:otherwise>
												<div class="col-xs-1" data-sem="${com4}" data-day="${i}"
													data-time="${j}"></div>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
				<div class="col-xs-offset-10">
					<div class="availableCourse col-xs-2"
						style="position: absolute; background-color: #F0F0F0; padding: 1em;">
						<c:choose>
							<c:when test="${teaches4==null}">
								<div style="background-color: #FFFFFF;">
									<p>You have no courses available to add</p>
								</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="teach" items="${teaches4}">
									<div style="background-color: #FFFFFF" class="drag"
										data-new="newCourse" data-teaches="${teach.teachesId}">
										<p style="font-weight: bold; font-family: sans-serif;">Course
											Code: ${teach.courseId.courseCode}</p>
										<p style="font-family: sans-serif;">Available Hours:
											${teach.courseId.hour}</p>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>


	<script
		src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/javascript/myscript.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/javascript/jquery-ui.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/javascript/myscript.js">
		
	</script>

	<script type="text/javascript">
		var pageUrl = '${pageContext.request.contextPath}';
	</script>

	<%@ include file="/WEB-INF/jsps/footer.jsp"%>
</body>
</html>