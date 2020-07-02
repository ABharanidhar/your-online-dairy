<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customers list</title>
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
			Subject: ${dairy.subject } <br> <br> 
			Description: ${dairy.description } <br> <br>
		</div>
	</div>



	<div>
		<a href="${pageContext.request.contextPath}/dairy/home"> back to home</a>
	</div>


</body>
</html>