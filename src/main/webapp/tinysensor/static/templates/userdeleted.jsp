<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Teacher: ${requestScope.user.id} ${requestScope.user.firstname} ${requestScope.user.lastname} was deleted</p>
	<a href="${pageContext.request.contextPath}/tinysensor/static/templates/usersmenu.jsp">Back</a>
</body>
</html>
