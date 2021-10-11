<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>HomePage</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/javascript/myscript.js"></script>

</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1 class="text-primary">Welcome to routine system</h1>
			<a class="btn btn-default pull-right"
				href="${pageContext.request.contextPath}/users/login">Login </a>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<form role="form" id="directSearch" name="directSearch" class="well"
					method="get"
					action="${pageContext.request.contextPath}/normal/normalview">
					<div class="form-group">
						<h3 class="text-info">Department</h3>
						<select class="form-control" name="deptCode" id="dept">
							<c:forEach var="depts" items="${depts}">
								<option value="${depts.deptCode}">${depts.deptCode}</option>
							</c:forEach>
						</select>
						<h3 class="text-info">Semester</h3>
						<select class="form-control" name="semester" id="semester">
							<c:forEach var="examCommittee" items="${examCommittees}">
								<c:choose>
									<c:when test="${examCommittee.semester==11}">
										<option value="11">1 / 1</option>
									</c:when>
									<c:when test="${examCommittee.semester==21}">
										<option value="21">2 / 1</option>
									</c:when>
									<c:when test="${examCommittee.semester==31}">
										<option value="31">3 / 1</option>
									</c:when>
									<c:when test="${examCommittee.semester==41}">
										<option value="41">4 / 1</option>
									</c:when>
									<c:when test="${examCommittee.semester==12}">
										<option value="12">1 / 2</option>
									</c:when>
									<c:when test="${examCommittee.semester==22}">
										<option value="22">2 / 2</option>
									</c:when>
									<c:when test="${examCommittee.semester==32}">
										<option value="32">3 / 2</option>
									</c:when>
									<c:when test="${examCommittee.semester==42}">
										<option value="42">4 / 2</option>
									</c:when>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>
	
	<script
		src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/javascript/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/javascript/home.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/javascript/jquery-ui.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/javascript/myscript.js">
		
	</script>
	<script type="text/javascript">
		
	</script>
	<%@ include file="/WEB-INF/jsps/footer.jsp"%>
</body>
</html>