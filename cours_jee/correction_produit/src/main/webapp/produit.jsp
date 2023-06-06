<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produit ${produit.getId()}</title>
</head>
<body>
<div>
    Marque : ${produit.getMarque()}
    Réference : ${produit.getReference()}
    Prix : ${produit.getPrix()} €
    Stock : ${produit.getStock()}
    Date Achat : ${produit.getDateAchat()}
</div>
</body>
</html>
