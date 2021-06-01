<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                <html>
                <fmt:bundle basename="message">


                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <title>
                            <fmt:message key="vaga.titulo" />
                        </title>
                        <link rel="icon" type="imagem/png" href="https://img.icons8.com/ios/452/ingredients-list.png" />
                        <link href="${pageContext.request.contextPath}/index.css" rel="stylesheet" type="text/css" />

                    </head>

                    <body>
                        <div class="navbar">
                            <div class="left">
                                <img src="https://img.icons8.com/ios/452/ingredients-list.png" />
                                <h1>
                                    <fmt:message key="vaga.titulo" />
                                </h1>
                            </div>
                            <div class="right">
                                <a href="${pageContext.request.contextPath}/login.jsp" class="sair">
                                    <fmt:message key="login.loginS" />
                                </a>
                            </div>


                        </div>
                        <div class="table">
                            <h3 style="margin-top: 30px;">
                                <fmt:message key="listavaga.descricao" />
                            </h3>
                            <div style="margin-top: 2rem;">

                                    <h2>
                                        <fmt:message key="vagas_abertas.lista" />
                                    </h2>
                                    <table border="1">
                                        <tr>
                                            <th>
                                                <fmt:message key="vaga.empresa" /> </th>
                                            <th>
                                                <fmt:message key="vaga.descricao" /> </th>
                                            <th>
                                                <fmt:message key="vaga.remuneracao" /> </th>
                                            <th>
                                                <fmt:message key="vaga.dataLimite" /> </th>
                                        </tr>

                                        <c:forEach var="vaga" items="${requestScope.listaVagasAbertas}">
                                            <tr>
                                                <td>${vaga.empresa.usuario.nome}</td>
                                                <td>${vaga.descricao}</td>
                                                <td>
                                                    <fmt:formatNumber value="${vaga.remuneracao}" type="currency" currencySymbol="R$" />
                                                </td>
                                                <td>${vaga.dataLimite}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                        </div>


                    </body>
                </fmt:bundle>

                </html>