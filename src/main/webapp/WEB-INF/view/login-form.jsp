<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>My Login Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
.failed {
	color: red;
}
</style>


</head>

<body>

	<ul class="nav nav-tabs nav-justified">
		<li class="nav-item"><a class="nav-link active" href="/login">LogIn</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="/register">Register</a>
		</li>
	</ul>


	<h2>Login Form</h2>

	<c:if test="${param.error != null }">
		<p class="failed">Invalid user name/password</p>
	</c:if>

	<c:if test="${param.logout!= null }">
		<p>
			<i> User successfully logged out </i>
		</p>
	</c:if>

	<p>
		<i> ${registrationMessage} </i>
	</p>

	<form:form class="form-inline"
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<label for="username" class="mr-sm-2">UserName:</label>
		<input type="text" name="username" class="form-control mb-2 mr-sm-2"
			id="username" />
		<br>
		<label for="password" class="mr-sm-2">Password:</label>
		<input type="password" name="password" id="password"
			class="form-control mb-2 mr-sm-2" />
		<br>
		<br>
		<br>
		<button type="submit" class="btn btn-primary mb-2">log In</button>
	</form:form>

	<br>
	<br>

	<div>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/register" role="button">New?
			Register Here</a>
	</div>

</body>
</html>