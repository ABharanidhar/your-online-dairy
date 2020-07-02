<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customers list</title>
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
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>


	<div id="wrapper">
		<div id="header">
			<h2>AB - Online Dairy</h2>
		</div>
	</div>


	<div id="container">
		<div id="content">
			<div class="card">
				<div class="card-body">
					<form:form action="saveEntry" modelAttribute="entry" method="POST">
						<form:hidden path="addedBy" />
						<div class="form-group">
							<label for="subject">Subject:</label>
							<form:input type="text" class="form-control" path="subject" />
						</div>
						<div class="form-group">
							<label for="description">Description:</label>
							<form:textarea class="form-control" rows="20" path="description" />
						</div>
						<button type="submit" class="btn btn-primary">Save</button>

						<button class="btn btn-primary"
							onclick="if(confirm('All memories will be discarded. Do you want to continue?')){ 
				document.location.href='${pageContext.request.contextPath}/dairy/home'; return false;}">
							Cancel</button>

					</form:form>
				</div>
			</div>

		</div>
	</div>





</body>
</html>