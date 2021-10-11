<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title>AdminPage</title>

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
			<div class="row">
				<div class="col-md-1">
					<div class="btn-group">
						<a class="btn btn-default" href="${pageContext.request.contextPath}/">Home</a>
					</div>
				</div>
				
				
			</div>
			<h3 class="text-primary">Welcome Mr. <%=session.getAttribute("adminName")%></h3>
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
		</div>



	</div>

</body>
</html>