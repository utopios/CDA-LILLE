<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produit ${produit.getId()}</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
<jsp:include page="../includes/header.jsp" />
<div>
    Marque : ${produit.getMarque()}
    Réference : ${produit.getReference()}
    Prix : ${produit.getPrix()} €
    Stock : ${produit.getStock()}
    Date Achat : ${produit.getDateAchat()}
    <c:forEach items="${produit.getImages()}" var="image">
        <img src="${image.getUrl()}">
    </c:forEach>
</div>
</body>
</html>
