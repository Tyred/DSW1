<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Autenticação</title>
                <link rel="icon" type="imagem/png" href="https://png.pngtree.com/png-vector/20190804/ourlarge/pngtree-padlock-icon-png-image_1657626.jpg" />
                <link href="/main.css" rel="stylesheet" type="text/css" />
            </head>

            <body>
                <div class="header" style="background-color:cyan;  height: 176px; margin-bottom: 80px;"></div>

                <div class="card" style="margin: auto;justify-content: center;border:solid 1px;
                border-radius:20px; border-color: #A9A9A9;  width: 600px;">
                
                    <div class="title" style="display: flex;justify-content: center;">
                        <h1
                            style="margin-top:50px; margin-bottom:30px;font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
                            Autenticação de usuário</h1>
                    </div>
                    <form method="post" action="index.jsp"
                        style="display: flex; justify-content: center; margin-left: 30px; margin-bottom: 20px;">
                        <table>
                            <div class="login" style="margin-bottom: 10px;">
                                <tr>
                                    <th
                                        style="font-size: 22px; font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
                                        login: </th>
                                    <td><input type="text" name="login" value="${param.login}" style="  border: 0;
                        border-bottom: 2px solid #9e9e9e;
                        outline: none;
                        transition: .2s ease-in-out;
                        box-sizing: border-box;
                      
                        width: 240px;
                        " /></td>
                                </tr>
                            </div>
                            <tr >
                                <th
                                    style="font-size: 22px; margin-right: 15px;font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
                                    senha: </th>
                                <td><input type="password" name="senha" style="  border: 0;
                        border-bottom: 2px solid #9e9e9e;
                        outline: none;
                        transition: .2s ease-in-out;
                        box-sizing: border-box;
                        
                        width: 240px;
                        " /></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input style="justify-items: center;  margin-left: 100px; margin-top: 20px; background-color: #4CAF50; /* Green */
                                border: none;
                                border-radius: 4px;
                                color: white;
                                padding: 12px 29px;
                                text-align: center;
                                text-decoration: none;
                                display: inline-block;
                                margin-top: 30px;
                                font-size: 18px;" type="submit" name="bOK" value="Entrar" />
                                </td>
                            </tr>
                        </table>
                    </form>
                    <div class="erro" style="display: flex; justify-content: center; font-size: 16px; color: red;">
                        <c:if test="${mensagens.existeErros}">
                            <div id="erro">
                                <ul>
                                    <c:forEach var="erro" items="${mensagens.erros}">
                                        <li> ${erro} </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                    </div>
                </div>
                <div class="footer" style="background-color:cyan;  height: 176px; margin-top: 80px;"></div>
            </body>

            </html>