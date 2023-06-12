<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2023
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Se connecter</title>
  <jsp:include page="../includes/head.jsp" ></jsp:include>
</head>
<body>
<jsp:include page="../includes/header.jsp" ></jsp:include>
<div>
  <h1>Se connecter</h1>
  <c:if test="${messageError != null}">
    <div>${messageError}</div>
  </c:if>
  <form action="${pageContext.request.contextPath}/utilisateur" method="post">
    <input type="hidden" name="action" value="login">
    <div>
      <label>Login</label>
      <input type="text" name="login">
    </div>
    <div>
      <label>Password</label>
      <input type="password" name="password">
    </div>
    <div>
      <button type="submit">Valider</button>
    </div>
  </form>
</div>
</body>
</html>
