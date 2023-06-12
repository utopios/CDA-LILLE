<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2023
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Patient ${patient.getName()}</title>
  <jsp:include page="../includes/head.jsp" ></jsp:include>
</head>
<body>
<jsp:include page="../includes/header.jsp" ></jsp:include>
<div>
  Nom : ${patient.getName()}
</div>
<div>
  Téléphone : ${patient.getPhone()}
</div>
<div>
  <div>
    <h2>Ajouter une consultations</h2>
    <form action="consultation" method="post">
      <input type="hidden" name="patientId" value="${patient.getId()}">
      <div>
        <button type="submit">Valider</button>
      </div>
    </form>
  </div>
  <h2>Liste des consultations</h2>
  <c:forEach items="${patient.getConsultations()}" var="consultation">
    <div>
      id : ${consultation.getId()}
      date : ${consultation.getDateConsultation()}
      <a href="${pageContext.request.contextPath}/consultation?id=${consultation.getId()}">Detail de la consultation</a>
    </div>
  </c:forEach>
</div>
</body>
</html>
