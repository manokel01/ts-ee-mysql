<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Users Search</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/tinysensor/static/styles/usersmenu.css">
</head>
<body>
  <div class="center">
    <p>Hello ${sessionScope.username}</p>
  </div>

  <div class="center">
    <div class="search-wrapper">
      <div class="bot-gap">
        <span class="title">Search User</span>
      </div>
      <div class="bot-gap">
        <form method="POST" action="${pageContext.request.contextPath}/tinysensor/search">
          <input name="lastname" type="text" class="search rounded" placeholder="Insert user's lastname" autofocus/>
          <br><br>
          <button class="search-btn rounded color-btn" type="submit">Search</button>
        </form>
      </div>
    </div>

    <div class="insert-wrapper">
      <div class="bot-gap">
        <span class="title">Insert User</span>
      </div>
      <div class="bot-gap">
        <form method="POST" action="${pageContext.request.contextPath}/tinysensor/insert">
          <input name="firstname" type="text" value="${requestScope.insertedUser.firstname}" class="insert rounded" placeholder="Firstname" autofocus/><br>
          <input name="lastname" type="text" value="${requestScope.insertedUser.lastname}" class="insert rounded" placeholder="Lastname" autofocus/><br>
          <input name="email" type="text" value="${requestScope.insertedUser.email}" class="insert rounded" placeholder="Email" autofocus/><br>
          <input name="address" type="text" value="${requestScope.insertedUser.address}" class="insert rounded" placeholder="Address" autofocus/>
          <br><br>
          <button class="search-btn rounded color-btn" type="submit">Insert</button>
        </form>
      </div>
    </div>
  </div>

  <div class="center">
    <c:if test="${requestScope.isError}">
      <p>${requestScope.message}</p>
    </c:if>
  </div>

  <div class="center">
    <c:if test="${requestScope.usersNotFound}">
      <p>No users found</p>
    </c:if>

    <p>${requestScope.error}</p>
  </div>
</body>
</html>


