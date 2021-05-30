<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Menu</title>
            <link rel="icon" type="imagem/png"
                href=" https://cdn3.iconfinder.com/data/icons/search-engine-optimization-plus/64/crud_create_read_update_delete-512.png" />

        </head>

        <body>
            <div class="navbar"
                style="display: flex; justify-content: space-between; justify-items: center; background-color: cyan; ">
                <h1 style="font-size: 26px; margin-left: 20px; margin-top: 30px;">Página do Administrador</h1>
                <div class="rigth" style="margin-bottom: 10px;">
                    <p style="font-size: 22px; margin-right: 20px;">Olá ${sessionScope.usuarioLogado.nome}</p>
                    <a href="${pageContext.request.contextPath}/logout.jsp"
                        style="font-size:22px; margin-left: 25px; margin-top: 10px; ">Sair</a>
                </div>

            </div>



        </body>

        </html>