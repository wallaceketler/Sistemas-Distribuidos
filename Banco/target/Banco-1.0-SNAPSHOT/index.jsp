<%-- 
    Document   : index
    Created on : 30 de set. de 2022, 14:07:12
    Author     : walla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.rmi.registry.Registry"%>
<%@page import="java.rmi.registry.LocateRegistry"%>
<%@page import="servidorBradesco.bradescoInterface"%>
<%@page import="servidorItau.itauInterface"%>

<!DOCTYPE html>
<html>
    <link rel ="stylesheet" href="style/index.css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form method="get">
            <div>
                <div>
                    Valor do Empréstimo
                    <input type = "text" name ="valorTotal">    
                </div>

                <div>
                    Quantidade de parcelas
                    <input type ="text" name ="parcelas">

                </div>

                <div>
                    Itaú<input type ="radio" name = "banco" value="itau">
                    Bradesco<input type ="radio" name = "banco" value = "bradesco">
                </div>

               

                <button type ="submit" name = "consulta">Consultar</button>
            </div>
        </form>
        
        <%
            float valor = 0;
            if(request.getParameter("consulta") != null){



                if(request.getParameter("banco").equals("itau")){
                Registry itau = LocateRegistry.getRegistry("localhost",10000);
                itauInterface itauObj = (itauInterface) itau.lookup("servidorItau");
                valor = itauObj.taxa(Integer.parseInt(request.getParameter("valorTotal")),Integer.parseInt(request.getParameter("parcelas")));
                   
                }
                else if(request.getParameter("banco").equals("bradesco"))
                {
                Registry bradesco = LocateRegistry.getRegistry("localhost",10001);
                bradescoInterface bradescoObj = (bradescoInterface) bradesco.lookup("servidorBradesco");
                valor = bradescoObj.taxa(Integer.parseInt(request.getParameter("valorTotal")),Integer.parseInt(request.getParameter("parcelas")));
                }
          
            }
                
        %>
        
        <div>Valor a pagar: <%=valor%></div>

    </body>
</html>
