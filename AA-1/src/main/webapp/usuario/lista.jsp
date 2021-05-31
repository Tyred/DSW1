<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                <html>
                <fmt:bundle basename="message">

                    <head>
                        <title>Lista de usuarios</title>
                        <link href="${pageContext.request.contextPath}/index.css" rel="stylesheet" type="text/css" />
                    </head>
                </fmt:bundle>

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
                    <h3>Lista de usuários</h3>

                    <% String contextPath=request.getContextPath().replace("/", "" ); %>

                        <h4>Usuários</h4>

                        <div class="table">
                            <fmt:message key="users.list" />
                            <table border="1">

                                <tr>
                                    <th>Nome</th>
                                    <th>Email</th>
                                    <th>Admin</th>
                                    <th>Ação</th>
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

                        <h4>Profissionais</h4>

                        <div class="table">
                            <fmt:message key="profissionais.list" />
                            <table border="1">

                                <tr>
                                    <th>Nome</th>
                                    <th>Email</th>
                                    <th>CPF</th>
                                    <th>Data de nascimento</th>
                                    <th>Ação</th>
                                </tr>

                                <c:forEach var="profissional" items="${requestScope.listaProfissionais}">
                                    <tr>
                                        <td>${profissional.usuario.nome}</td>
                                        <td>${profissional.usuario.email}</td>
                                        <td>${profissional.CPF}</td>
                                        <td>${profissional.dataNascimento}</td>
                                        <td><a href="/<%= contextPath%>/profissionais/editar?id=${usuario.id}">Editar</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>

                        <h4>Empresas</h4>

                        <div class="table">
                            <fmt:message key="empresas.list" />
                            <table border="1">
                                <tr>
                                    <th>Nome</th>
                                    <th>Email</th>
                                    <th>CNPJ</th>
                                    <th>Cidade</th>
                                    <th>Ação</th>
                                </tr>

                                <c:forEach var="empresa" items="${requestScope.listaEmpresas}">
                                    <tr>
                                        <td>${empresa.usuario.nome}</td>
                                        <td>${empresa.usuario.email}</td>
                                        <td>${empresa.CNPJ}</td>
                                        <td>${empresa.cidade}</td>
                                        <td><a href="/<%= contextPath%>/empresas/editar?id=${usuario.id}">Editar</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <button class="button"> <a href="${pageContext.request.contextPath}/usuarios/cadastrar"
                class="sair">Cadastrar usuário</a>
            </button>
                </body>

                </html>