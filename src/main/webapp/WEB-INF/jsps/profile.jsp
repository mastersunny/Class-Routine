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

<title>Profile</title>

</head>
<body>

	<%@ include file="/WEB-INF/jsps/headerstudent.jsp"%>

	<div class="row">
		<div class="col-xs-6">
			<ul>
				<li>${student.registrationNo}</li>
				<li>${student.emailNo}</li>
				<li>${student.contactNo}</li>
				<li>${student.firstName}</li>
				<li>${student.lastName}</li>
				<li>${student.dateOfBirth}</li>
				<li>
					<div>
						<img alt=""
							src="${pageContext.request.contextPath}/resources/img/carnival.jpg">
					</div>
				</li>

			</ul>
		</div>
	</div>

	<%@ include file="/WEB-INF/jsps/footer.jsp"%>
</body>
</html>