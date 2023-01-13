<%-- 
    Document   : mensagens
    Created on : 9 de set. de 2022, 15:27:47
    Author     : walla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.rmi.registry.Registry"%>
<%@page import="java.rmi.registry.LocateRegistry"%>
<%@page import="servidor.fileManager"%>
<%@page import="Dektop.Threads"%>

<%    
      Thread thread1;
      Thread thread2;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="frmmsg">
            <label for="txtmsg">Mensagem</label>
            <input type="text" name="txtmsg" maxlength="200" size="200"/>
            
            <label for="slemoji"> Emoji: </label>
            <select name="slemoji">
                <option value=''>Selecione</option>
                <option value='<img src="images/coracao.png" width="40" height="40"'> Coração </option>
                <option value='<img src="images/raiva.png" width="40" height="40"'> Raiva </option>
            </select>
            
            
            <input type="submit" name="btnenviar" value="enviar"/>  
        </form>
        
        <%
            
            if(request.getParameter("btnenviar")!=null){

                String msg = "<img src = '" + session.getAttribute("avatar")+"'width='40' height='40'>";
                msg+="<font color= '" + session.getAttribute("radCor")+"'>"+session.getAttribute("nick")+"</font> Diz: ";
                msg+=request.getParameter("txtmsg")+"<br>";
                
                String msg2 = "<font color= '" + session.getAttribute("radCor")+"'>"+session.getAttribute("nick")+"</font> Diz: ";
                msg2 += request.getParameter("txtmsg") + "<br>";
                
                Registry reg = LocateRegistry.getRegistry("localhost",5555);
                Registry reg2 = LocateRegistry.getRegistry("localhost",4444);
                
                fileManager obj = (fileManager) reg.lookup("manager");
                fileManager obj2 = (fileManager) reg2.lookup("manager");
                
                Threads tdesktop = new Threads();
                Threads tweb = new Threads();
                
                tdesktop.setParameters(obj2, msg2);
                tweb.setParameters(obj, msg);
                
                thread1 = new Thread(tdesktop);
                thread1.start();
                
                thread2 = new Thread(tweb);
                thread2.start();
                
           
                
            }
        %>
    </body>
</html>
