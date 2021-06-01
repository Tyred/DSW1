<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                <html>
                <fmt:bundle basename="message">


                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <title>
                            <fmt:message key="login.autenticacao" />
                        </title>
                        <link rel="icon" type="imagem/png" href="https://image.flaticon.com/icons/png/512/181/181534.png" />
                        <link href="${pageContext.request.contextPath}/login.css" rel="stylesheet" type="text/css" />
                    </head>

                    <body>
                        <div class="container">
                            <div class="card">
                                <div class="title">
                                    <img src="https://image.flaticon.com/icons/png/512/181/181534.png">
                                    <h1>
                                        <fmt:message key="login.autenticacao" />
                                    </h1>
                                </div>
                                <form class="form" method="post" action="index.jsp">
                                    <table>
                                        <tr>
                                            <th>
                                                <fmt:message key="login.login" /> </th>
                                            <td><input type="text" name="login" class="input" value="${param.login}" /></td>
                                        </tr>

                                        <tr>
                                            <th>
                                                <fmt:message key="login.senha" />
                                            </th>
                                            <td><input type="password" name="senha" class="input" /></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2">
                                                <input class="button" type="submit" name="bOK" value='<fmt:message key=" login.entrar " />' />
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                                <div class="erro">
                                    <c:if test="${mensagens.existeErros}">
                                        <div>
                                            <ul>
                                                <c:forEach var="erro" items="${mensagens.erros}">
                                                    <li> ${erro} </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </body>

                </fmt:bundle>

                </html>