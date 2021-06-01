<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

                <html>
                    <fmt:bundle basename="message">
                        <head>
                            <title><fmt:message key = "vaga.titulo"/></title>
                        </head>
                    

                        <body>
                            <% String contextPath = request.getContextPath().replace("/", ""); %>

                            <div align="center" style="margin-top: 2rem;">
                            <fmt:message key = "vaga.lista"/>
                            <table border="1">
                                <tr>
                                    <th>Empresa</th>
                                    <th>Descrição</th>
                                    <th>Remuneração</th>
                                    <th>Data Limite</th>
                                    <th>
                                        <fmt:message key = "acao" />
                                    </th>
                                </tr>

                                <c:forEach var="vaga" items="${requestScope.listaVagas}">
                                <tr>
                                    <td>${vaga.empresa.usuario.nome}</td>
                                    <td>${vaga.descricao}</td>
                                    <td>${vaga.remuneracao}</td>
                                    <td>${vaga.dataLimite}</td>
                                    <td><a href="/<%= contextPath%>/minhasvagas/editar?id=${vaga.id}">Editar</a></td>
                                </tr>
                                </c:forEach>
                            </table>
                            </div>
                        </body>
                        
                    </fmt:bundle>
                </html>