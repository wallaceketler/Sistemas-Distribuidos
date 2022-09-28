<%-- 
    Document   : resultado.jsp
    Created on : 21 de set. de 2022, 09:58:35
    Author     : walla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage = "error.jsp" %>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<!DOCTYPE html>
<html>
    
    <link rel ="stylesheet" href="./css/index.css"> 
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <link rel ="stylesheet" href="./css/resultado.css"/>
    
    
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
            <%

                String voto = request.getParameter("escolha");
                if(voto == null){
                    throw new ServletException("Preencha seu candidato!");
                }
                float totalVotos = 0;
                float total1 = 0;
                float total2 = 0;
                float total3 = 0;
                float porcentagem1 = 0;
                float porcentagem2 = 0;
                float porcentagem3 = 0;
                session.setAttribute("escolha",voto);


            %>


            <div class = "resultado-seu-voto">Você votou no candidato : <%=session.getAttribute("escolha")%></div><br>


            <%
                //Gravação dos votos nos arquivos
                if(Integer.parseInt(voto) == 1){
                    FileWriter gravador = new FileWriter("C:/Users/walla/OneDrive/Documentos/NetBeansProjects/Urna2/src/main/webapp/files/Candidato1.txt",true);
                    gravador.write(voto);
                    gravador.close();
                }    
                else if(Integer.parseInt(voto) == 2){
                    FileWriter gravador = new FileWriter("C:/Users/walla/OneDrive/Documentos/NetBeansProjects/Urna2/src/main/webapp/files/Candidato2.txt",true);
                    gravador.write(voto);
                    gravador.close();
                }
                else if(Integer.parseInt(voto) == 3){
                    FileWriter gravador = new FileWriter("C:/Users/walla/OneDrive/Documentos/NetBeansProjects/Urna2/src/main/webapp/files/Candidato3.txt",true);
                    gravador.write(voto);
                    gravador.close();
                }
            %>


            <%
                //contagem dos votos
                Path caminho = Paths.get("C:/Users/walla/OneDrive/Documentos/NetBeansProjects/Urna2/src/main/webapp/files/Candidato1.txt");
                try{
                    byte[] texto = Files.readAllBytes(caminho);
                    String leitura = new String(texto);
                    //out.print(leitura.length());
                    totalVotos = leitura.length() + totalVotos;
                    total1 = leitura.length();
                }catch(Exception erro){}

            %>


            <%
                //contagem dos votos
                Path caminho2 = Paths.get("C:/Users/walla/OneDrive/Documentos/NetBeansProjects/Urna2/src/main/webapp/files/Candidato2.txt");
                try{
                    byte[] texto = Files.readAllBytes(caminho2);
                    String leitura = new String(texto);
                    //out.print(leitura.length());
                    totalVotos = leitura.length() + totalVotos;
                    total2 = leitura.length();
                }catch(Exception erro){}
            %>


            <%
                //contagem dos votos
                Path caminho3 = Paths.get("C:/Users/walla/OneDrive/Documentos/NetBeansProjects/Urna2/src/main/webapp/files/Candidato3.txt");
                try{
                    byte[] texto = Files.readAllBytes(caminho3);
                    String leitura = new String(texto);
                    //out.print(leitura.length());
                    totalVotos = leitura.length() + totalVotos;
                    total3 = leitura.length();
                }catch(Exception erro){}
            %>

            <div class = "resultado-total-votos">Total de Votos:<%=totalVotos%></div><br>

            <div class = "resultado-p1">Porcentagem Candidato 1</div><br>
            
            <div class = "resultado-p-value">
                <%//contagem percentual
                    porcentagem1 = (total1/totalVotos) * 100;

                %>
                <div class = "resultado-barra"  style = "width : <%=porcentagem1%>px" style ="height : 10px"> </div>

                <div class = "resultado-p"><%=porcentagem1%> %</div>
            </div>

            <div class = "resultado-p2">Porcentagem Candidato 2</div><br>
 
            
            <div class ="resultado-p-value">
                <%//contagem percentual
                    porcentagem2 = (total2/totalVotos) * 100;

                %>
                <div class = "resultado-barra" style = "width : <%=porcentagem2%>px" style ="height : 10px"> </div>

                <div class = "resultado-p"><%=porcentagem2%> %</div>
            </div>
            
            <div class = "resultado-p3">Porcentagem Candidato 3</div><br>

            <div class ="resultado-p-value">
                <%//contagem percentual
                    porcentagem3 = (total3/totalVotos) * 100;

                %>
                <div class = "resultado-barra"  style = "width : <%=porcentagem3%>px" style ="height : 10px"> </div>

                <div class = "resultado-p"><%=porcentagem3%> %</div>
            </div>
        </div>
        
    </body>
</html>
