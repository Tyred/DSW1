<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
  <fmt:bundle basename="message">
    <head>
      <title>Lista de profissionais</title>
    </head>

    <body>
      <% String contextPath = request.getContextPath().replace("/", ""); %>

      <div align="center" style="margin-top: 2rem;">
        <fmt:message key="profissional.lista" />
        <table border="1">
          <tr>
            <th><fmt:message key="usuario.nome" /></th>
            <th>Email</th>
            <th>CPF</th>
            <th><fmt:message key="profissional.genero" /></th>
            <th><fmt:message key="profissional.dataNascimento" /></th>
            <th><fmt:message key="acao" /></th>
          </tr>

          <c:forEach var="profissional" items="${requestScope.listaProfissionais}">
            <tr>
              <td>${profissional.usuario.nome}</td>
              <td>${profissional.usuario.email}</td>
              <td>${profissional.CPF}</td>
              <td>${profissional.sexo}</td>
              <td>${profissional.dataNascimento}</td>
              <td><a href="/<%= contextPath%>/profissionais/editar?id=${profissional.id}"><fmt:message key="acao.editar" /></a></td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </body>
  </fmt:bundle>
</html>
