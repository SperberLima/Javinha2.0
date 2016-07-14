<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.inf.model.domain.*" %>
<%@page import="java.util.List" %> 


<html lang="en" style="    min-width: 100%;"><head>
        <meta charset="utf-8"> 
        <title>COOP</title>
        <meta name="viewport" content="width=device-width,initial-scale=1, user-scalable=no"> 
        <link rel="stylesheet" href="../css/scm.css">   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>  
        <script type="text/javascript" src="../js/script.js"></script>
        <link rel="icon" href="http://i.imgur.com/4LnFIn3.png">
        <link href="https://fonts.googleapis.com/css?family=Fjalla+One|Oswald:400,700|Passion+One|Anton|Source+Sans+Pro" rel="stylesheet" type="text/css">  
        <style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style></head>

    <body class="html">  

        <header id="header" class="" style="display: none;">  
            <nav class="main"> 

                <div style="margin: 0 auto;">
                    <img src="http://imgur.com/eqKINnm.png" style="height: 50px;margin-top: 16px;">   
                </div>
            </nav>   
        </header>    

        <div id="content" class="" style="">  
            <div id="menu" class="hide">   
                <h1>MENU</h1>
                <ul> <a href="../index.jsp"><li><span>Home</span></li></a> <a href="ajuda.html"><li><span>Ajuda</span></li></a> <a href="about.html"><li><span>Sobre nós</span></li></a> </ul>
            </div>
            <div id="wrapper" class="">
                <div style="min-width: 100%; height: 63px; padding-top: 16px; background: #668f86; box-shadow: 0px 0px 5px 6px rgba(0, 0, 0, 0.10); position: relative;">
                    <a id="openMenu" onclick="javascript: showMenu();" class=""><img class="burguer" src="http://www.sbrnetportal.com/images/hamburger.png" style=""></a>
                    <img src="http://i.imgur.com/r3Mrk7e.png" style="height: 50px;margin: 0 auto;display: block;">   
                </div>

                <div class="form_container">
                    <h1 class="form_title">Cadastro de Turma</h1>



                    <form name="frmTurma" method="post" action=""><table style="
                                                                         ">
                            <tbody>
                                <tr style="">
                                    <td id="field" style="
                                        "><span style="
                                            font-size: 16px;
                                            ">ID</span></td>
                                    <td><input class="form_input" name="id" type="text" placeholder="ID"></td>
                                </tr>
                                <tr>
                                    <td id="field"><span>Currículo em oferta</span></td>
                                    <td>
                                        <select name="curriculo" class="form_input">
                                            <%
                                                List<CurriculoOferta> listCurriculo = (List<CurriculoOferta>) request.getAttribute("listCurriculo");
                                                for (CurriculoOferta cur : listCurriculo) {
                                            %>
                                            <option                                     
                                                value='<%=cur.getId()%>'><%=cur.getId()%>
                                            </option>
                                            <%  }%>
                                        </select>
                                    </td> 
                                </tr>
                                <tr>
                                    <td id="field"><span>Nome</span></td>
                                    <td><input class="form_input" name="nome" type="text" placeholder="Nome"></td>
                                </tr>  
                            </tbody></table>
                    </form> 	
                    <div class="butcontainer">
                        <input type="reset" value="CANCELAR" class="cancela" style=" height: 35px; width: 120px;">
                        <button onclick="" class="confirma" style="
                                height: 35px;
                                width: 120px;
                                margin-left: 15px;
                                ">CONFIRMA</button> 

                    </div>
                </div>

            </div>

        </div>  
    </body></html>    