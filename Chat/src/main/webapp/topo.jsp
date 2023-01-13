<%-- 
    Document   : topo
    Created on : 9 de set. de 2022, 15:24:41
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
        <img src ="<%=session.getAttribute("avatar")%>" width="50" height="50"/>
        <font color="<%=session.getAttribute("cor")%>" size="5">
            <%=session.getAttribute("nick")%>
        </font> 
    </body>
</html>
