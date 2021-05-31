<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<table border="1">
  <caption>
    <c:choose>
      <c:when test="${usuario != null}">
        <fmt:message key="usuario.atualizar" />
      </c:when>
      <c:otherwise>
        <fmt:message key="usuario.criar" />
      </c:otherwise>
    </c:choose>
  </caption>
  <c:if test="${usuario != null}">
    <input type="hidden" name="id" value="${usuario.id}" />
  </c:if>
  <tr>
    <td>
      <label for="nome"> <fmt:message key="usuario.nome" /> </label>
    </td>
    <td>
      <input
        type="text" id="nome" name="nome" required value="${usuario.nome}"
      />
    </td>
  </tr>
  <tr>
    <td>
      <label for="email"> <fmt:message key="user.email" /> </label>
    </td>
    <td>
      <input type="email" id="email" name="email" required value="${usuario.email}"
      />
    </td>
  </tr>
  <tr>
    <td>
      <label for="senha"> <fmt:message key="usuario.senha" /> </label>
    </td>
    <td>
      <input
        type="password" id="senha" name="senha" required value="${usuario.senha}"
      />
    </td>
  </tr>
  <tr>
    <td>
      <label for="admin"> <fmt:message key="usuario.admin" /> </label>
    </td>
    <td>
      <input
        type="checkbox" id="admin" name="admin" value="${usuario.admin}"
      />
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <input type="submit" value="<fmt:message key="link.salvar" />" />
    </td>
  </tr>
</table>
