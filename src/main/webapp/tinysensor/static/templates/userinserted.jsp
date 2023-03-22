<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertion Successful</title>
</head>
<body>
	<h1>Teacher inserted successfully</h1>
	<div>
		<p>${requestScope.insertedUser.firstname}</p>
		<p>${requestScope.insertedUser.lastname}</p>
		<p>${requestScope.insertedUser.email}</p>
		<p>${requestScope.insertedUser.address}</p>

		<p></p>
	</div>	
	 	
	<div>
		<a href="${pageContext.request.contextPath}/tinysensor/static/templates/usersmenu.jsp">Back</a>
	</div> 	
</body>
</html>