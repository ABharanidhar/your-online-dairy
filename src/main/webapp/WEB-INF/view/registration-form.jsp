<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>

<title>Register New User Form</title>
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
.error {
	color: red
}
</style>

</head>

<body>
	<ul class="nav nav-tabs nav-justified">
		<li class="nav-item"><a class="nav-link" href="/login">LogIn</a>
		</li>
		<li class="nav-item"><a class="nav-link active" href="/register">Register</a>
		</li>
	</ul>

	<h2>Registration Form</h2>
	<div class="card">
		<div class="card-body">
			<form:form
				action="${pageContext.request.contextPath}/processRegistration"
				modelAttribute="crmUser">

				<c:if test="${registrationError != null}">

					<div class="alert alert-danger col-xs-offset-1 col-xs-10">
						${registrationError}</div>

				</c:if>

				<!-- User name -->
				<div class="form-group">
					<label for="userName">user name</label>
					<form:input path="userName" placeholder="username (*)"
						id="userName" class="form-control" />
					<form:errors path="userName" cssClass="error" />
				</div>

				<!-- Password -->
				<div class="form-group">
					<label for="password">Password</label>
					<form:password path="password" class="form-control"
						placeholder="password (*)" id="password" />
					<form:errors path="password" cssClass="error" />
				</div>

				<!-- Confirm Password -->
				<div class="form-group">
					<label for="matchingPassword">Password</label>
					<form:password path="matchingPassword" class="form-control"
						placeholder="confirm password (*)" id="matchingPassword" />
					<form:errors path="matchingPassword" cssClass="error" />
				</div>

				<!-- First name -->
				<div class="form-group">
					<label for="firstName">first name</label>
					<form:input path="firstName" placeholder="firstName (*)"
						id="firstName" class="form-control" />
					<form:errors path="firstName" cssClass="error" />
				</div>

				<!-- Last name -->
				<div class="form-group">
					<label for="lastName">last name</label>
					<form:input path="lastName" placeholder="last name (*)"
						id="lastName" class="form-control" />
					<form:errors path="lastName" cssClass="error" />
				</div>

				<!-- Email -->
				<div class="form-group">
					<label for="email">user name</label>
					<form:input path="email" placeholder="email (*)" id="email"
						class="form-control" />
					<form:errors path="email" cssClass="error" />
				</div>

				<!-- Register Button -->
				<button type="submit" class="btn btn-primary">Register</button>
			</form:form>
		</div>
	</div>
</body>
</html>