<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Dairy</title>
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
</head>
<body>


	<div id="wrapper">
		<div id="header">
			<h2>AB - Online Dairy</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<c:if test="${showAddButton}">
				<button type="button" class="btn btn-primary"
					onclick="window.location.href='${pageContext.request.contextPath}/dairy/newEntry';return false;"
					class="add-button">Add Entry</button>
				<br>
				<br>
			</c:if>

			<ul class="list-group list-group-flush">
				<c:forEach var="entry" items="${entries}">
					<c:url var="viewLink" value="/dairy/view">
						<c:param name="dairyId" value="${entry.id }"></c:param>
					</c:url>
					<c:url var="editLink" value="/dairy/edit">
						<c:param name="dairyId" value="${entry.id }"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/dairy/delete">
						<c:param name="dairyId" value="${entry.id }"></c:param>
					</c:url>

					<li class="list-group-item">${entry.entryOn}<a
						href="${viewLink}"> view </a> | <a href="${editLink}"> edit </a> |
						<a href="${deleteLink}"
						onclick="if(!confirm('Are you sure?')) return false;"> delete
					</a>
					</li>
				</c:forEach>
			</ul>

		</div>
	</div>

	<br>
	<br>
	<br>
	<br>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<button class="btn btn-primary" type="submit">Logout</button>

	</form:form>






</body>
</html>