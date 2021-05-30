<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Autenticação</title>
                <link rel="icon" type="imagem/png" href="https://img.icons8.com/material/452/padlock-outline.png" />
                <link href="${pageContext.request.contextPath}/login.css" rel="stylesheet" type="text/css" />
            </head>

            <body>
                <div class="container">
                    <div class="card">
                        <div class="title">
                            <img src="https://img.icons8.com/material/452/padlock-outline.png">
                            <h1>
                                Autenticação de usuário</h1>
                        </div>
                        <form class="form" method="post" action="index.jsp">
                            <table>
                                <tr>
                                    <th>login: </th>
                                    <td><input type="text" name="login" class="input" value="${param.login}" /></td>
                                </tr>

                                <tr>
                                    <th>senha: </th>
                                    <td><input type="password" name="senha" class="input" /></td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <input class="button" type="submit" name="bOK" value="Entrar" />
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

            </html>