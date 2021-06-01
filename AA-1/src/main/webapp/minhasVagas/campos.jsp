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
                                    <a href="${pageContext.request.contextPath}/minhasvagas" class="link">
                                        <fmt:message key="vaga.titulo" />
                                    </a>
                                </h1>
                                <h1>
                                    <a href="${pageContext.request.contextPath}/minhasvagas/cadastrar" class="link">
                                        <fmt:message key="acao.cadastrar" />
                                    </a>
                                </h1>
                            </div>
                            <div class="right">
                                <p style="margin-right: 20px;">
                                    <fmt:message key="navbar.ola" />, ${sessionScope.usuarioLogado.nome}! </p>
                                <a href="${pageContext.request.contextPath}/logout.jsp" class="sair">
                                    <fmt:message key="navbar.sair" />
                                </a>
                            </div>
                        </div>

                        <div class="card">
                            <div class="tableCadastrar">
                                <table>

                                    <caption class="title">
                                        <c:choose>
                                            <c:when test="${vaga != null}">
                                                <fmt:message key="vagas.atualizar" />
                                            </c:when>
                                            <c:otherwise>
                                                <fmt:message key="vagas.criar" />
                                            </c:otherwise>
                                        </c:choose>
                                    </caption>

                                    <c:if test="${vaga != null}">
                                        <input type="hidden" name="id" value="${vaga.id}" />
                                    </c:if>
                                    <tr>
                                        <td>
                                            <label for="descricao"> <fmt:message key="vaga.descricao" /> </label>
                                        </td>
                                        <td>
                                            <input type="text" id="descricao" name="descricao" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="remuneracao"> <fmt:message key="vaga.remuneracao" /> </label>
                                        </td>
                                        <td>
                                            <input type="text" id="remuneracao" name="remuneracao" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="dataLimite"> <fmt:message key="vaga.dataLimite" /> </label>
                                        </td>
                                        <td>
                                            <input type="text" id="dataLimite" name="dataLimite" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" align="center">
                                            <input type="submit" value='<fmt:message key=" acao.salvar " />' class="button" />
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                    </body>
                </fmt:bundle>

                </html>