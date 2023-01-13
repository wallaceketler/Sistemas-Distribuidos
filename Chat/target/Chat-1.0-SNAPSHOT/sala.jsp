<%-- 
    Document   : sala
    Created on : 9 de set. de 2022, 15:21:27
    Author     : walla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%  //ao fazer isso posso escrever códigos Java
            
            session.setAttribute("nick",  request.getParameter("txtnick"));
            session.setAttribute("cor",   request.getParameter("radcor"));
            session.setAttribute("avatar",request.getParameter("radavatar"));
            
        %>
        
        <iframe src="topo.jsp" width="800" height="100"></iframe>
        <iframe src="conversa.jsp" width="800" height="600"></iframe>
        <iframe src="mensagens.jsp" width="800" height="200"></iframe>
        
        
        
    </body>
</html>
