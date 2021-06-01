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
                        </div>


                    </body>
                </fmt:bundle>

                </html>