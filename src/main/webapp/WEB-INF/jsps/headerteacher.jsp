<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"> </span> <span class="icon-bar"> </span> <span
					class="icon-bar"> </span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}"> Home </a></li>
			</ul>
			<c:if test="${flag!=false}">
				<h3 class="navbar-text text-primary"
					style="position: relative; left: 31%;">Routine: ${department}
				</h3>
			</c:if>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${flag!=false}">
						<li><a id="logOut"
							href="${pageContext.request.contextPath}/teacher/profile/?employeeCode=${teacher.employeeCode}"><span
								class="glyphicon glyphicon-user"></span> Profile </a></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="${pageContext.request.contextPath}/teacher/teacherview/"><span
								class="glyphicon"></span> Routine </a></li>
					</c:otherwise>
				</c:choose>

				<li><a id="logOut"
					href="<c:url value='/j_spring_security_logout'/>"><span
						class="glyphicon glyphicon-log-in"></span> LogOut </a></li>

			</ul>
		</div>

	</div>
</nav>
