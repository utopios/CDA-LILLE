<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 07/06/2023
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patients</title>
  <jsp:include page="../includes/head.jsp" ></jsp:include>
</head>
<body>
<jsp:include page="../includes/header.jsp" ></jsp:include>
<div class="container">
    <c:if test="${messageError != null}">
        <div>${messageError}</div>
    </c:if>

    <form  method="post">
        <input type="hidden" name="action" value="search">
        <div>
            <label>Rechercher un patient : </label>
            <input type="text" name="search">
        </div>
        <div>
            <button type="submit">Valider</button>
        </div>
    </form>

<c:if test="${isLogged == true}">
    <form  method="post">
        <input type="hidden" name="action" value="add">
        <div>
            <label>Nom : </label>
            <input type="text" name="name">
        </div>
        <div>
            <label>Téléphone : </label>
            <input type="text" name="phone">
        </div>
        <div>
            <button type="submit">Valider</button>
        </div>
    </form>
</c:if>
</div>
<div class="container">
  <h1 class="row">
    Liste des patients
  </h1>
    <c:forEach items="${patients}" var="patient">
        <div>
            Nom : ${patient.getName()}
            Téléphone : ${patient.getPhone()}
            <a href="?id=${patient.getId()}">Detail</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
