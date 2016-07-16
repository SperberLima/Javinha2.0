<%-- 
    Document   : newjsperro
    Created on : Jul 14, 2016, 5:43:10 PM
    Author     : Igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%!
String erro = "";
%>
<%
erro = (String)request.getAttribute("erro");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2><%= erro %></h2>
    <marquee>
        <pre>
                
                ░░░░░░░░▄▄▄▀▀▀▄▄███▄
                ░░░░░▄▀▀░░░░░░░▐░▀██▌
                ░░░▄▀░░░░▄▄███░▌▀▀░▀█
                ░░▄█░░▄▀▀▒▒▒▒▒▄▐░░░░█▌
                ░▐█▀▄▀▄▄▄▄▀▀▀▀▌░░░░░▐█▄
                ░▌▄▄▀▀░░░░░░░░▌░░░░▄███████▄
                ░░░░░░░░░░░░░▐░░░░▐███████████▄
                ░░░░░le░░░░░░░▐░░░░▐█████████████▄
                ░Error toucan░░▀▄░░░▐██████████████▄
                ░░░░░░has░░░░░░░░▀▄▄████████████████▄
                ░░░░░arrived░░░░░░░░░░░░█▀██████
            
        </pre>
        </marquee>    
    
    </body>
</html>
