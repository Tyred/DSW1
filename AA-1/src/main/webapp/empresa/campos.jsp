<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                <html>
                <fmt:bundle basename="message">

                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <title>
                            <fmt:message key="acao.cadastrar" />
                        </title>
                        <link rel="icon" type="imagem/png" href="https://cdn.iconscout.com/icon/free/png-256/dashboard-1739866-1481441.png" />
                        <link href="${pageContext.request.contextPath}/index.css" rel="stylesheet" type="text/css" />

                    </head>

                    <body>
                        <div class="navbar">
                            <div class="left">
                                <img src="https://cdn.iconscout.com/icon/free/png-256/dashboard-1739866-1481441.png" />
                                <h1>
                                    <a href="${pageContext.request.contextPath}/admin" class="link">
                                        <fmt:message key="dashboard.titulo" /> | </a>
                                </h1>
                                <h1>
                                    <a href="${pageContext.request.contextPath}/usuarios" class="link">
                                        <fmt:message key="usuario.titulo" />
                                    </a>
                                </h1>
                                <h1>
                                    <a href="${pageContext.request.contextPath}/empresas" class="link">
                                        <fmt:message key="empresa.titulo" />
                                    </a>
                                </h1>


                                <h2>
                                    <a href="${pageContext.request.contextPath}/profissionais" class="link">
                                        <fmt:message key="profissional.titulo" />
                                    </a>
                                </h2>
                            </div>
                            <div class="right">
                                <p style="margin-right: 20px;">Olá, ${sessionScope.usuarioLogado.nome}! </p>
                                <a href="${pageContext.request.contextPath}/logout.jsp" class="sair">
                                    <fmt:message key="navbar.sair" />
                                </a>
                            </div>
                        </div>
                        <div class="card">
                            <h4>
                                <a href="${pageContext.request.contextPath}/empresas" class="sair">
                                    <fmt:message key="acao.voltar" />
                                </a>
                            </h4>
                            <div class="tableCadastrar">
                                <table>

                                    <caption class="title">
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
                                            <input type="text" id="nome" name="nome" required value="${empresa.usuario.nome}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="cnpj">  <fmt:message key="empresa.cnpj" /> </label>
                                        </td>
                                        <td>
                                            <input type="text" id="cnpj" name="cnpj" required value="${empresa.CNPJ}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="descricao"> <fmt:message key="empresa.descricao" /> </label>
                                        </td>
                                        <td>
                                            <input type="text" id="descricao" name="descricao" required value="${empresa.descricao}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="cidade"> <fmt:message key="empresa.cidade" /> </label>
                                        </td>
                                        <td>
                                            <input type="text" id="cidade" name="cidade" required value="${empresa.cidade}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="email"> <fmt:message key="user.email" /> </label>
                                        </td>
                                        <td>
                                            <input type="email" id="email" name="email" required value="${empresa.usuario.email}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="senha"> <fmt:message key="usuario.senha" /> </label>
                                        </td>
                                        <td>
                                            <input type="password" id="senha" name="senha" required value="${empresa.usuario.senha}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="admin"> <fmt:message key="usuario.admin" /> </label>
                                        </td>
                                        <td>
                                            <input type="checkbox" id="admin" name="admin" value="${empresa.usuario.admin}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="center">
                                            <input type="submit" value="Salvar" class="button" />
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </body>
                </fmt:bundle>

                </html>