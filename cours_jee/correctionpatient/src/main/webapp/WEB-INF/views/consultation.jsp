<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2023
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Consultation ${consultation.getId()}</title>
  <jsp:include page="../includes/head.jsp" ></jsp:include>
</head>
<body>
<jsp:include page="../includes/header.jsp" ></jsp:include>
<div>
  <h1>Consultation : ${consultation.getId()}, ${consultation.getDateConsultation()}</h1>
</div>
<div>
  <h2>Fiche soins</h2>
  <c:if test="${consultation.getFicheSoins() != null}">
    <div>
      ${consultation.getFicheSoins().getContent()}
    </div>
  </c:if>
  <c:if test="${consultation.getFicheSoins() == null}">
    <form action="${pageContext.request.contextPath}/soins" method="post">
      <input type="hidden" name="consultationId" value="${consultation.getId()}">
      <div>
        <label>Contenu</label>
        <textarea name="content"></textarea>
      </div>
      <div>
        <button type="submit">Valider</button>
      </div>
    </form>
  </c:if>

  <h2>Préscription</h2>
  <c:if test="${consultation.getPrescription() != null}">
    <div>
        ${consultation.getPrescription().getContent()}
    </div>
  </c:if>
  <c:if test="${consultation.getPrescription() == null}">
    <form action="${pageContext.request.contextPath}/prescription" method="post">
      <input type="hidden" name="consultationId" value="${consultation.getId()}">
      <div>
        <label>Contenu</label>
        <textarea name="content"></textarea>
      </div>
      <div>
        <button type="submit">Valider</button>
      </div>
    </form>
  </c:if>
</div>
</body>
</html>
