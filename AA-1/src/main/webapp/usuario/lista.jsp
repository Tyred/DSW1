<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                <html>
                <fmt:bundle basename="message">

                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <title>
                            <fmt:message key="usuario.titulo" />
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

                        <% String contextPath=request.getContextPath().replace("/", "" ); %>
                            <div class="table">
                                <div style="margin-top: 2rem;">
                                    <div class="title">
                                        <fmt:message key="usuario.lista" />
                                    </div>
                                    <table border="1">
                                        <tr>
                                            <th>
                                                <fmt:message key="usuario.nome" />
                                            </th>
                                            <th>
                                                <fmt:message key="usuario.email" />
                                            </th>
                                            <th>
                                                <fmt:message key="usuario.admin" />
                                                <th>
                                                    <fmt:message key="acao" />
                                                </th>
                                            </th>
                                        </tr>

                                        <c:forEach var="usuario" items="${requestScope.listaUsuarios}">
                                            <tr>
                                                <td>${usuario.nome}</td>
                                                <td>${usuario.email}</td>
                                                <td>${usuario.admin}</td>
                                                <td><a href="/<%= contextPath%>/usuarios/editar?id=${usuario.id}">Editar</a></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>

                                <div style="margin-top: 2rem;">
                                    <div class="title">
                                        <fmt:message key="profissional.lista" />
                                    </div>
                                    <table border="1">
                                        <tr>
                                            <th>
                                                <fmt:message key="usuario.nome" />
                                            </th>
                                            <th>
                                                <fmt:message key="usuario.email" />
                                            </th>
                                            <th>
                                                <fmt:message key="usuario.cpf" />
                                            </th>
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
                                                <td><a href="/<%= contextPath%>/profissionais/editar?id=${profissional.id}">Editar</a></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>

                                <div style="margin-top: 2rem;">
                                    <div class="title">
                                        <fmt:message key="empresa.lista" />
                                    </div>
                                    <table border="1">
                                        <tr>
                                            <th>
                                                <fmt:message key="usuario.nome" />
                                            </th>
                                            <th>
                                                <fmt:message key="usuario.email" />
                                            </th>
                                            <th>
                                                <fmt:message key="empresa.cnpj" />
                                            </th>
                                            <th>
                                                <fmt:message key="empresa.cidade" />
                                            </th>
                                            <th>
                                                <fmt:message key="acao" />
                                            </th>
                                        </tr>

                                        <c:forEach var="empresa" items="${requestScope.listaEmpresas}">
                                            <tr>
                                                <td>${empresa.usuario.nome}</td>
                                                <td>${empresa.usuario.email}</td>
                                                <td>${empresa.CNPJ}</td>
                                                <td>${empresa.cidade}</td>
                                                <td><a href="/<%= contextPath%>/empresas/editar?id=${empresa.id}">Editar</a></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>

                            </div>
                            <a href="${pageContext.request.contextPath}/usuarios/cadastrar" class="button">
                                <fmt:message key="usuario.criar" />
                            </a>
                    </body>
                </fmt:bundle>

                </html>