<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
  <caption>
    <c:choose>
      <c:when test="${empresa != null}">
        <fmt:message key="usuario.atualizar" />
      </c:when>
      <c:otherwise>
        <fmt:message key="usuario.criar" />
      </c:otherwise>
    </c:choose>
  </caption>
  <c:if test="${empresa != null}">
    <input type="hidden" name="id" value="${empresa.id}" />
  </c:if>
  <tr>
    <td>
      <label for="nome"> <fmt:message key="usuario.nome" /> </label>
    </td>
    <td>
      <input
        type="text" id="nome" name="nome" required value="${empresa.usuario.nome}"
      />
    </td>
  </tr>
  <tr>
    <td>
      <label for="cnpj"> CNPJ </label>
    </td>
    <td>
      <input
        type="text" id="cnpj" name="cnpj" required value="${empresa.CNPJ}"
      />
    </td>
  </tr>
  <tr>
    <td>
      <label for="descricao"> <fmt:message key="empresa.descricao" /> </label>
    </td>
    <td>
      <input
        type="text" id="descricao" name="descricao" required value="${empresa.descricao}"
      />
    </td>
  </tr>
  <tr>
    <td>
      <label for="cidade"> <fmt:message key="empresa.cidade" /> </label>
    </td>
    <td>
      <input
        type="text" id="cidade" name="cidade" required value="${empresa.cidade}"
      />
    </td>
  </tr>
  <tr>
    <td>
      <label for="email"> <fmt:message key="user.email" /> </label>
    </td>
    <td>
      <input type="email" id="email" name="email" required value="${empresa.usuario.email}"
      />
    </td>
  </tr>
  <tr>
    <td>
      <label for="senha"> <fmt:message key="usuario.senha" /> </label>
    </td>
    <td>
      <input
        type="password" id="senha" name="senha" required value="${empresa.usuario.senha}"
      />
    </td>
  </tr>
  <tr>
    <td>
      <label for="admin"> <fmt:message key="usuario.admin" /> </label>
    </td>
    <td>
      <input
        type="checkbox" id="admin" name="admin" value="${empresa.usuario.admin}"
      />
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <input type="submit" value="<fmt:message key="link.salvar" />" />
    </td>
  </tr>
</table>
