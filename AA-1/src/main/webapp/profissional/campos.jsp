<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <title>Cadastrar</title>
                    <link rel="icon" type="imagem/png" href="https://cdn.iconscout.com/icon/free/png-256/dashboard-1739866-1481441.png" />
                    <link href="${pageContext.request.contextPath}/index.css" rel="stylesheet" type="text/css" />

                </head>

                <body>
                    <div class="navbar">

                        <img src="https://cdn.iconscout.com/icon/free/png-256/dashboard-1739866-1481441.png" />
                        <h1><a href="${pageContext.request.contextPath}/admin" class="link">Dashboard</a></h1>
                        <h1> <a href="${pageContext.request.contextPath}/usuarios" class="link">Usuários</a></h1>
                        <h2> <a href="${pageContext.request.contextPath}/profissionais" class="link">Profissionais</a></h2>
                        <div class="right">
                            <p style="margin-right: 20px;">Olá, ${sessionScope.usuarioLogado.nome}! ;)</p>
                            <a href="${pageContext.request.contextPath}/logout.jsp" class="sair">Sair</a>
                        </div>
                    </div>
                    <div class="card">
                        <div class="tableCadastrar">
                            <table>

                                <caption class="title">
                                    <c:choose>
                                        <c:when test="${profissional != null}">
                                            <fmt:message key="usuario.atualizar" />
                                        </c:when>
                                        <c:otherwise>
                                            <fmt:message key="usuario.criar" />
                                        </c:otherwise>
                                    </c:choose>
                                </caption>

                                <c:if test="${profissional != null}">
                                    <input type="hidden" name="id" value="${profissional.id}" />
                                </c:if>
                                <tr>
                                    <td>
                                        <label for="nome"> <fmt:message key="usuario.nome" /> </label>
                                    </td>
                                    <td>
                                        <input type="text" id="nome" name="nome" required value="${profissional.usuario.nome}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="cpf"> CPF </label>
                                    </td>
                                    <td>
                                        <input type="text" id="cpf" name="cpf" required value="${profissional.CPF}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="telefone"> <fmt:message key="profissional.telefone" /> </label>
                                    </td>
                                    <td>
                                        <input type="text" id="telefone" name="telefone" required value="${profissional.telefone}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="sexo"> <fmt:message key="profissional.genero" /> </label>
                                    </td>
                                    <td>
                                        <input type="text" id="sexo" name="sexo" required value="${profissional.sexo}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="dataNascimento"> <fmt:message key="profissional.dataNascimento" /> </label>
                                    </td>
                                    <td>
                                        <input type="text" id="dataNascimento" name="dataNascimento" required value="${profissional.dataNascimento}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="email"> <fmt:message key="user.email" /> </label>
                                    </td>
                                    <td>
                                        <input type="email" id="email" name="email" required value="${profissional.usuario.email}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="senha"> <fmt:message key="usuario.senha" /> </label>
                                    </td>
                                    <td>
                                        <input type="password" id="senha" name="senha" required value="${profissional.usuario.senha}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label for="admin"> <fmt:message key="usuario.admin" /> </label>
                                    </td>
                                    <td>
                                        <input type="checkbox" id="admin" name="admin" value="${profissional.usuario.admin}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="submit" value="Salvar" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </body>