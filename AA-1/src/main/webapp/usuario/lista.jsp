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

    <div align="center" style="margin-top: 2rem;">
      <fmt:message key="users.list" />
      <table border="1">
        <tr>
          <th>Nome</th>
          <th>Email</th>
          <th>Admin</th>
          <th>Ação</th>
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
      <fmt:message key="profissionais.list" />
      <table border="1">
        <tr>
          <th>Nome</th>
          <th>Email</th>
          <th>CPF</th>
          <th>Data de nascimento</th>
          <th>Ação</th>
        </tr>

        <c:forEach var="profissional" items="${requestScope.listaProfissionais}">
          <tr>
            <td>${profissional.usuario.nome}</td>
            <td>${profissional.usuario.email}</td>
            <td>${profissional.CPF}</td>
            <td>${profissional.dataNascimento}</td>
            <td><a href="/<%= contextPath%>/profissionais/editar?id=${usuario.id}">Editar</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>

    <div align="center" style="margin-top: 2rem;">
      <fmt:message key="empresas.list" />
      <table border="1">
        <tr>
          <th>Nome</th>
          <th>Email</th>
          <th>CNPJ</th>
          <th>Cidade</th>
          <th>Ação</th>
        </tr>

        <c:forEach var="empresa" items="${requestScope.listaEmpresas}">
          <tr>
            <td>${empresa.usuario.nome}</td>
            <td>${empresa.usuario.email}</td>
            <td>${empresa.CNPJ}</td>
            <td>${empresa.cidade}</td>
            <td><a href="/<%= contextPath%>/empresas/editar?id=${usuario.id}">Editar</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
