<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Users Found..</title>

</head>
<body>
  <div>
    <table>
      <tr>
        <th>ID</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Address</th>
        <th>Delete</th>
        <th>Update</th>
      </tr>
      <c:forEach var = "user" items = "${requestScope.users}">
        <tr>
          <td>${user.id}</td>
          <td>${user.firstname}</td>
          <td>${user.lastname}</td>
          <td>${user.email}</td>
          <td>${user.address}</td>
          <td><a href="${pageContext.request.contextPath}/tinysensor/delete?id=${user.id}&firstname=${user.firstname}&lastname=${user.lastname}&email=${user.email}&address=${user.address}">Delete</a></td>
          <td><a href="${pageContext.request.contextPath}/tinysensor/static/templates/userupdate.jsp?id=${user.id}&firstname=${user.firstname}&lastname=${user.lastname}&email=${user.email}&address=${user.address}">Update</a></td>
        </tr>
      </c:forEach>
    </table>
  </div>

  <div>
    <a href="${pageContext.request.contextPath}/tinysensor/static/templates/usersmenu.jsp">Back</a>
  </div>

  <div>
    <c:if test="${requestScope.deleteAPIError}">
      <p>Something went wrong in Delete</p>
    </c:if>
  </div>

  <div>
    <c:if test="${requestScope.updateAPIError}">
      <p>Something went wrong in Update</p>
    </c:if>
  </div>

</body>
</html>
