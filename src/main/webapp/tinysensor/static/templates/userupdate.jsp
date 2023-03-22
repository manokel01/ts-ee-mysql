<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Update</title>
</head>
<body>
	<div>
		<form method="POST" action="${pageContext.request.contextPath}/tinysensor/update">
			<label for="tid">ID</label>
			<input id="tid" type="text" name="id" value="${param.id}" readonly><br>
			<label for="firstname">Firstname</label>
			<input id="firstname" type="text" name="firstname" value="${param.firstname}"><br>
			<label for="lastname">Lastname</label>
			<input id="lastname" type="text" name="lastname" value="${param.lastname}"><br>
			<label for="email">Email</label>
			<input id="email" type="text" name="email" value="${param.email}"><br>
			<label for="address">Address</label>
			<input id="address" type="text" name="address" value="${param.address}"><br><br>
			<br>
			<button type="submit">Update User</button>
		</form>	
	</div>	

	<c:if test="${requestScope.isError}">
		<p>${requestScope.message}</p>
	</c:if>
</body>
</html>
