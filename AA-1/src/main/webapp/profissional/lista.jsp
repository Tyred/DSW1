<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                <html>
                <fmt:bundle basename="message">

                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <title>Profissionais</title>
                        <link rel="icon" type="imagem/png" href="https://cdn.iconscout.com/icon/free/png-256/dashboard-1739866-1481441.png" />
                        <link href="${pageContext.request.contextPath}/index.css" rel="stylesheet" type="text/css" />

                    </head>

                    <body>
                        <div class="navbar">
                            <div class="left">
                                <img src="https://cdn.iconscout.com/icon/free/png-256/dashboard-1739866-1481441.png" />
                                <h1><a href="${pageContext.request.contextPath}/admin" class="link">Dashboard</a></h1>
                                <h1> <a href="${pageContext.request.contextPath}/usuarios" class="link">Usuários</a></h1>
                                <h1> <a href="${pageContext.request.contextPath}/empresas" class="link">Empresas</a></h1>
                                <h1> <a href="${pageContext.request.contextPath}/vagas" class="link">Vagas</a></h1>
                                <h1> <a href="${pageContext.request.contextPath}/candidaturas" class="link">Candidaturas</a></h1>
                                <h2> <a href="${pageContext.request.contextPath}/profissionais" class="link">Profissionais</a></h2>
                            </div>
                            <div class="right">
                                <p style="margin-right: 20px;">Olá, ${sessionScope.usuarioLogado.nome}! </p>
                                <a href="${pageContext.request.contextPath}/logout.jsp" class="sair">Sair</a>
                            </div>
                        </div>


                        <% String contextPath=request.getContextPath().replace("/", "" ); %>
                            <div class="table">

                                <div style="margin-top: 2rem;">
                                    <div class="title">
                                        <fmt:message key="profissional.lista" />
                                    </div>
                                    <table border="1">
                                        <tr>
                                            <th>
                                                <fmt:message key="usuario.nome" />
                                            </th>
                                            <th>Email</th>
                                            <th>CPF</th>
                                            <th>
                                                <fmt:message key="profissional.genero" />
                                            </th>
                                            <th>
                                                <fmt:message key="profissional.dataNascimento" />
                                            </th>
                                            <th>
                                                <fmt:message key="acao" />
                                            </th>
                                        </tr>

                                        <c:forEach var="profissional" items="${requestScope.listaProfissionais}">
                                            <tr>
                                                <td>${profissional.usuario.nome}</td>
                                                <td>${profissional.usuario.email}</td>
                                                <td>${profissional.CPF}</td>
                                                <td>${profissional.sexo}</td>
                                                <td>${profissional.dataNascimento}</td>
                                                <td>
                                                    <a href="/<%= contextPath%>/profissionais/editar?id=${profissional.id}">
                                                        <fmt:message key="acao.editar" />
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                            <a href="${pageContext.request.contextPath}/profissionais/cadastrar" class="button">Cadastrar
                  profissional</a>
                    </body>
                </fmt:bundle>

                </html>