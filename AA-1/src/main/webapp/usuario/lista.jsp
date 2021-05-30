<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
  <fmt:bundle basename="message">
    <head>
      <title>Lista de usuarios</title>
    </head>
  </fmt:bundle>

  <body>
    <% String contextPath = request.getContextPath().replace("/", ""); %>
    <c:forEach var="usuario" items="${requestScope.listaUsuarios}">
      <p>Nome: ${usuario.nome}</p>
      <p>Email: ${usuario.email}</p>
      <p>Senha: ${usuario.senha}</p>
      <p>Admin: ${usuario.admin}</p>
      <hr style="margin-bottom: 20px;">
    </c:forEach>
  </body>
</html>
