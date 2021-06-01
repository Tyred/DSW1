<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                <html>
                <fmt:bundle basename="message">

                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <title>
                            <fmt:message key="vaga.titulopagina" />
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

                        <% String contextPath = request.getContextPath().replace("/", ""); %>
                            <div class="table">
                                <div style="margin-top: 2rem;">

                                    <h2>
                                        <fmt:message key="vaga.lista" />
                                    </h2>
                                    <table border="1">
                                        <tr>
                                            <th>
                                                <fmt:message key="vaga.descricao" /> </th>
                                            <th>
                                                <fmt:message key="vaga.remuneracao" /> </th>
                                            <th>
                                                <fmt:message key="vaga.dataLimite" /> </th>
                                            <th>
                                                <fmt:message key="acao" />
                                            </th>
                                        </tr>

                                        <c:forEach var="vaga" items="${requestScope.listaVagas}">
                                            <tr>
                                                <td>${vaga.descricao}</td>
                                                <td>
                                                    <fmt:formatNumber value="${vaga.remuneracao}" type="currency" currencySymbol="R$" />
                                                </td>
                                                <td>${vaga.dataLimite}</td>
                                                <td>
                                                    <a href="/<%= contextPath%>/minhasvagas/editar?id=${vaga.id}">
                                                        <fmt:message key="acao.editar" />
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                <a href="${pageContext.request.contextPath}/minhasvagas/cadastrar" class="button">
                                    <fmt:message key="listavagas.inscrever" />
                                </a>
                            </div>

                    </body>

                </fmt:bundle>

                </html>