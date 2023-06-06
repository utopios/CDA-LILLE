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
    <title>Produits</title>
</head>
<body>
    <h1>Liste des produits</h1>
    <c:forEach items="${produits}" var="produit">
        <div>
            Marque : ${produit.getMarque()}
            Réference : ${produit.getReference()}
            Prix : ${produit.getPrix()} €
            Stock : ${produit.getStock()}
            Date Achat : ${produit.getDateAchat()}
            <a href="produits?id=${produit.getId()}">Detail</a>
        </div>
    </c:forEach>
</body>
</html>
