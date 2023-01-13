<%-- 
    Document   : propaganda
    Created on : 21 de nov. de 2022, 15:01:03
    Author     : walla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.net.MulticastSocket"%>
<%@page import="java.net.DatagramPacket"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="1">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String sRet = "";
            String url = "";
            try{
                MulticastSocket socketMulticast = new MulticastSocket(4444);
                InetAddress grupo = InetAddress.getByName("239.0.0.1");
                socketMulticast.joinGroup(grupo);
                byte[] b = new byte[256];
                DatagramPacket datagrama = new DatagramPacket(b, b.length);
                socketMulticast.receive(datagrama);
                sRet = new String(datagrama.getData()).trim();
                System.out.println("Mensagem: " + sRet);
                if("1".equals(sRet)){
                    out.print("<img src = './images/coca-cola.jpg' width='150' heigth='300'>");
                }
                else if("2".equals(sRet)){
                    out.print("<img src = './images/fanta.jpg' width='150' heigth='300'>");
                }
                else if("3".equals(sRet)){
                    out.print("<img src = './images/pepsi.jpg' width='150' heigth='300'>");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        %>
        
    </body>
</html>
