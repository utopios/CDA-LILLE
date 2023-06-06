<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
<%--    <h1>Redirection après request</h1>--%>
<%--    <div>--%>
<%--        Nom : ${personne.getNom()}--%>
<%--        Prénom: ${personne.getPrenom()}--%>
<%--    </div>--%>
    <h2>Liste des personnes</h2>
    <c:forEach items="${personnes}" var="personne">
        <div>
            Nom : ${personne.getNom()}
            Prénom: ${personne.getPrenom()}
        </div>
    </c:forEach>
</div>
</body>
</html>
