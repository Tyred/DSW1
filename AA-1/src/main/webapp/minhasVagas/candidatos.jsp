<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<fmt:bundle basename="message">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <fmt:message key="candidatos.titulopagina" />
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
                        <fmt:message key="candidatos.lista" />
                    </h2>
                    <table border="1">
                        <tr>
                            <th>
                                <fmt:message key="usuario.nome" /> 
                            </th>
                            <th>
                                Curriculum 
                            </th>
                            <th>
                                Status 
                            </th>
                        </tr>

                        <c:forEach var="candidatura" items="${requestScope.listaCandidatos}">
                            <tr>
                                <td>${candidatura.profissional.usuario.nome}</td>
                                <td>${candidatura.curriculo}</td>
                                <td>${candidatura.status}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

    </body>

</fmt:bundle>

</html>