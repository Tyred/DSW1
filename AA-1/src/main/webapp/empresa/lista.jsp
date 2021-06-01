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
        <fmt:message key="empresa.lista" />
        <table border="1">
            <tr>
              <th><fmt:message key="usuario.nome" /></th>
              <th>Email</th>
              <th>CNPJ</th>
              <th><fmt:message key="empresa.descricao" /></th>
              <th><fmt:message key="empresa.cidade" /></th>
              <th><fmt:message key="acao" /></th>
            </tr>
  
            <c:forEach var="empresa" items="${requestScope.listaEmpresas}">
              <tr>
                <td>${empresa.usuario.nome}</td>
                <td>${empresa.usuario.email}</td>
                <td>${empresa.CNPJ}</td>
                <td>${empresa.descricao}</td>
                <td>${empresa.cidade}</td>
                <td><a href="/<%= contextPath%>/empresas/editar?id=${empresa.id}">Editar</a></td>
              </tr>
            </c:forEach>
          </table>
      </div>
    </body>
  </fmt:bundle>
</html>
