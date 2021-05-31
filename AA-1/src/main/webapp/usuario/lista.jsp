<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
  <fmt:bundle basename="message">
    <head>
      <title>Lista de usuarios</title>
    </head>

    <body>
      <% String contextPath = request.getContextPath().replace("/", ""); %>

      <div align="center" style="margin-top: 2rem;">
        <fmt:message key="usuario.lista" />
        <table border="1">
          <tr>
            <th><fmt:message key="usuario.nome" /></th>
            <th>Email</th>
            <th>Admin</th>
            <th><fmt:message key="acao" /></th>
          </tr>

          <c:forEach var="usuario" items="${requestScope.listaUsuarios}">
            <tr>
              <td>${usuario.nome}</td>
              <td>${usuario.email}</td>
              <td>${usuario.admin}</td>
              <td><a href="/<%= contextPath%>/usuarios/editar?id=${usuario.id}">Editar</a></td>
            </tr>
          </c:forEach>
        </table>
      </div>

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
              <td><a href="/<%= contextPath%>/profissionais/editar?id=${profissional.id}">Editar</a></td>
            </tr>
          </c:forEach>
        </table>
      </div>

      <div align="center" style="margin-top: 2rem;">
        <fmt:message key="empresa.lista" />
        <table border="1">
          <tr>
            <th><fmt:message key="usuario.nome" /></th>
            <th>Email</th>
            <th>CNPJ</th>
            <th><fmt:message key="empresa.cidade" /></th>
            <th>Ação</th>
          </tr>

          <c:forEach var="empresa" items="${requestScope.listaEmpresas}">
            <tr>
              <td>${empresa.usuario.nome}</td>
              <td>${empresa.usuario.email}</td>
              <td>${empresa.CNPJ}</td>
              <td>${empresa.cidade}</td>
              <td><a href="/<%= contextPath%>/empresas/editar?id=${empresa.id}">Editar</a></td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </body>
  </fmt:bundle>
</html>
