<%-- 
    Document   : conversa
    Created on : 9 de set. de 2022, 15:27:40
    Author     : walla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.rmi.registry.Registry"%>
<%@page import="java.rmi.registry.LocateRegistry"%>
<%@page import="servidor.fileManager"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content=1;"conversa.jsp">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Registry reg = LocateRegistry.getRegistry("localhost",5555);
            fileManager obj = (fileManager) reg.lookup("manager");
            out.print(obj.retrieve());
        %>
    </body>
</html>
{