<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>New User Details</h1>
	<p>user ${requestScope.user.firstname}</p>
	<p>user ${requestScope.user.lastname}</p>
	<p>user ${requestScope.user.email}</p>
	<p>user ${requestScope.user.address}</p>
	<a href="${pageContext.request.contextPath}/tinysensor/static/templates/usersmenu.jsp">Back</a>
</body>
</html>
