<%-- 
    Document   : error
    Created on : 28/05/2020, 06:58:59 AM
    Author     : Pc-Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/estilo.css">
        <title>Error</title>
    </head>
    <body>
        
        <%
            String error=(String)(request.getSession().getAttribute("error"));
        %>
        <h1 class="register-title">Hubo un error: <%=error%></h1>
        <p>
            <a href="../../login.html">Volver a Iniciar</a>
        </p>
    </body>
</html>
