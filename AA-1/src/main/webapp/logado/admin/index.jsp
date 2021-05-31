<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Dashboard</title>
            <link rel="icon" type="imagem/png" href="https://cdn.iconscout.com/icon/free/png-256/dashboard-1739866-1481441.png" />
            <link href="${pageContext.request.contextPath}/index.css" rel="stylesheet" type="text/css" />

        </head>

        <body>
            <div class="navbar">

                <img src="https://cdn.iconscout.com/icon/free/png-256/dashboard-1739866-1481441.png" />
                <h1><a href="${pageContext.request.contextPath}/admin" class="link">Dashboard</a></h1>
                <h2> <a href="${pageContext.request.contextPath}/usuarios" class="link">Usuários</a></h2>
                <div class="right">
                    <p style="margin-right: 20px;">Olá, ${sessionScope.usuarioLogado.nome}! ;)</p>
                    <a href="${pageContext.request.contextPath}/logout.jsp" class="sair">Sair</a>
                </div>
            </div>




        </body>

        </html>