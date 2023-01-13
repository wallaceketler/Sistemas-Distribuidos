
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name = "frmlogin"  action="sala.jsp" method="get">
            <table>
                <tr>
                    <td bgcolor="tomato" align ="center">
                        <font color ="white" size ="5">CHAT</font>
                    </td>
                </tr>
                
                <tr>
                    <td>Apelido:</td>
                    <td> <input type ="text" name ="txtnick"></td>
                </tr>
                
                <tr>
                    <td>Cor:</td>
                    <td> 
                        <input type="radio" name ="radcor" value ="blue">  
                        <font color ="blue">Azul</font><br>
                        
                        <input type="radio" name ="radcor" value ="green">
                        <font color ="green">Verde</font><br>
                        
                        <input type="radio" name ="radcor" value ="red">
                        <font color ="red">Vermelho</font><br>
                    </td>
                </tr>
            
                <tr>
                    <td>
                        <input type ="radio" name ="radavatar" value="images/m.png">
                        <img src ="images/m.png" width="30" height="30">
                        
                        <input type ="radio" name ="radavatar" value="images/f.png">
                        <img src ="images/f.png" width="30" height="30">
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type ="submit" name ="btnetrar" value="entrar">      
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
