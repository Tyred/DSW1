<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<fmt:bundle basename="message">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <fmt:message key="candidatura.titulopagina" />
        </title>
        <link rel="icon" type="imagem/png" href="https://cdn.iconscout.com/icon/free/png-256/dashboard-1739866-1481441.png" />
        <link href="${pageContext.request.contextPath}/index.css" rel="stylesheet" type="text/css" />

    </head>


    <body>

        <div class="navbar">
            <div class="left">
                <img src="https://cdn.iconscout.com/icon/free/png-256/dashboard-1739866-1481441.png" />
                <h1>
                    <a href="${pageContext.request.contextPath}/vagas/" class="link">
                        <fmt:message key="vagasAbertasTitulo" />
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
                        <fmt:message key="candidatura.lista" />
                    </h2>
                    <table border="1">
                        <tr>
                            <th>
                                <fmt:message key="vaga.descricao" /> </th>
                            <th>
                                <fmt:message key="vaga.remuneracao" /> </th>
                            <th>
                                <fmt:message key="vaga.dataLimite" /> </th>
                            <th> Status </th>
                        </tr>

                        <c:forEach var="candidatura" items="${requestScope.listaCandidaturas}">
                            <tr>
                                <td>${candidatura.vaga.descricao}</td>
                                <td>
                                    <fmt:formatNumber value="${candidatura.vaga.remuneracao}" type="currency" currencySymbol="R$" />
                                </td>
                                <td>${candidatura.vaga.dataLimite}</td>
                                <td>${candidatura.status}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

    </body>

</fmt:bundle>

</html>