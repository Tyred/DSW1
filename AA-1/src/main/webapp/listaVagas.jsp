<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Vagas</title>
            <link rel="icon" type="imagem/png" href="https://img.icons8.com/ios/452/ingredients-list.png" />
            <link href="${pageContext.request.contextPath}/vagas.css" rel="stylesheet" type="text/css" />

        </head>

        <body>
            <div class="navbar">

                <img src="https://img.icons8.com/ios/452/ingredients-list.png" />
                <h1>Vagas</h1>
                <div class="rigth">
                    <a href="${pageContext.request.contextPath}/login.jsp" class="vagas">login</a>
                </div>


            </div>
            <div class="tabelaVagas">
                <h2> Olá candidato, é um prazer te receber. As vagas com inscrição em aberto são as seguintes:</h2>
                <table border="1">
                    <tr>
                        <th style="width: 400px;">Vaga</th>
                        <th style="width: 200px;">Inscrição aberta até</th>
                        <th style="width: 150px;"></th>
                    </tr>
                    <tr>
                        <td>Ted</td>
                        <td>22</td>
                        <td><a href="#"> inscreva-se </a></td>
                    </tr>
                    <tr>
                        <td>Ralf</td>
                        <td>26</td>
                        <td><a href="#"> inscreva-se </a></td>
                    </tr>
                    <tr>
                        <td>Ralf</td>
                        <td>26</td>
                        <td><a href="#"> inscreva-se </a></td>
                    </tr>
                    <tr>
                        <td>Ralf</td>
                        <td>26</td>
                        <td><a href="#"> inscreva-se </a></td>
                    </tr>
                    <tr>
                        <td>Ralf</td>
                        <td>26</td>
                        <td><a href="#"> inscreva-se </a></td>
                    </tr>
                </table>
            </div>


        </body>

        </html>