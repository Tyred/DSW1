<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<fmt:bundle basename="message">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <fmt:message key="dashboard.titulo" />
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


                <h1>
                    <a href="${pageContext.request.contextPath}/profissionais" class="link">
                        <fmt:message key="profissional.titulo" />
                    </a>
                </h1>
            </div>
            <div class="right">
                <p style="margin-right: 20px;">Olá, ${sessionScope.usuarioLogado.nome}! </p>
                <a href="${pageContext.request.contextPath}/logout.jsp" class="sair">
                    <fmt:message key="navbar.sair" />
                </a>
            </div>
        </div>

        <img src="https://devporai.com.br/wp-content/uploads/2021/01/O-que-e-CRUD-740x414.jpg" class="imgCrud" />

    </body>

</fmt:bundle>

</html>