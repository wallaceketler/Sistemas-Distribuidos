<%-- 
    Document   : error
    Created on : 22 de set. de 2022, 21:28:28
    Author     : walla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <link rel ="stylesheet" href="./css/resultado.css"/>
    <link rel ="stylesheet" href ="./css/error.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class ="navbar-container">
            <div class = "navbar-image"><img src="./images/bandeira.webp" width = "120px"></div>
        </div>
        <div class = "navbar-text">JUSTIÇA ELEITORAL</div>
        
        <div class ="resultado-container">
            
        <% if(response.getStatus() == 500){ %>
            <div class = "erro"<font color="red">Erro: <%=exception.getMessage() %></div><br>
        <%}%>
    </body>
</html>
