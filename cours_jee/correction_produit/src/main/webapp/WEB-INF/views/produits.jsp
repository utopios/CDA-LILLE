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
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
    <jsp:include page="../includes/header.jsp" />
    <h1>Liste des produits</h1>

    <div>
        <form action="produits" method="post" enctype="multipart/form-data">
            <div><label>Marque</label><input type="text" name="marque" /></div>
            <div><label>Prix</label><input type="text" name="prix" /></div>
            <div><label>Reference</label><input type="text" name="reference" /></div>
            <div><label>Date Achat</label><input type="text" name="dateAchat" /></div>
            <div><label>Stock</label><input type="text" name="stock" /></div>
            <div><input type="file" name="images" multiple="true" /></div>
            <div><button type="submit" >Valider</button></div>
        </form>
    </div>
    <c:choose>
        <c:when test="${produits != null}">

        </c:when>
        <c:when test="${produits == null}">

        </c:when>
    </c:choose>
    <c:if test="${produits != null}">
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
    </c:if>

</body>
</html>
