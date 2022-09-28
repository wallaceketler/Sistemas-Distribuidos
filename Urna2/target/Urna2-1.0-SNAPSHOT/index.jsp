<%-- 
    Document   : index
    Created on : 21 de set. de 2022, 09:55:11
    Author     : walla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel ="stylesheet" href="./css/index.css"> 
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class ="navbar-container">
            <div class = "navbar-image"><img src="./images/bandeira.webp" width = "120px"></div>
            
        </div>
        <div class = "navbar-text">JUSTIÇA ELEITORAL</div>
        
        
        <div class="index-container">
            <form action="resultado.jsp" method="get">
                
                <div class = "index-input1"><input type ="radio" id = "1" value = "1" name = "escolha"> Candidato 1<br></div>
                <div class = "index-input2"><input type ="radio" id = "2" value = "2" name = "escolha"> Candidato 2<br></div>
                <div class = "index-input3"><input type ="radio" id = "3" value = "3" name = "escolha"> Candidato 3<br></div>
                
                <div class = "index-input4"><button type="submit" name = "btnvotar" value = "Votar">Votar</button></div>
            </form>
        </div>
    </body>
</html>
