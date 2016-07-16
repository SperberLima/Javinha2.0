<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.inf.model.domain.*" %>
<%@page import="java.util.List" %>


<html lang="en" style="
      min-width: 100%;
      "><head>
        <meta charset="utf-8"> 
        <title>COOP</title>
        <meta name="viewport" content="width=device-width,initial-scale=1, user-scalable=no"> 
        <link rel="stylesheet" href="/scm/css/scm.css">   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>  
        <script type="text/javascript" src="/scm/js/script.js"></script>
        <link rel="icon" href="http://i.imgur.com/4LnFIn3.png">
        <link href="https://fonts.googleapis.com/css?family=Fjalla+One|Oswald:400,700|Passion+One|Anton|Source+Sans+Pro" rel="stylesheet" type="text/css">  
        <style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style></head>

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
                <ul> <a href="/scm/home.jsp"><li><span>Home</span></li></a> <a href="ajuda.html"><li><span>Ajuda</span></li></a> <a href="about.html"><li><span>Sobre nós</span></li></a> </ul>
            </div>
            <div id="wrapper" class="">
                <div style="min-width: 100%; height: 63px; padding-top: 16px; background: #668f86; box-shadow: 0px 0px 5px 6px rgba(0, 0, 0, 0.10); position: relative;">
                    <a id="openMenu" onclick="javascript: showMenu();" class=""><img class="burguer" src="http://www.sbrnetportal.com/images/hamburger.png" style=""></a>
                    <img src="http://i.imgur.com/r3Mrk7e.png" style="height: 50px;margin: 0 auto;display: block;">   
                </div>

                <div class="form_container">
                    <h1 class="form_title">Lista de departamentos</h1>

                    <form name="frmDepartamento" method="post" action="/scm/servletweb" style="padding: 0px 20px;">
                        <table class="view">
                            <tbody><tr style="
                                       ">
                                    <th>
                                        ID
                                    </th>
                                    <th>
                                        Unidade de ensino
                                    </th>
                                    <th>
                                        Nome
                                    </th>
                                    <th>
                                        Sigla
                                    </th>
                                    <th>
                                        E-mail
                                    </th>
                                    <th>
                                        Telefone
                                    </th>
                                    <th>
                                        CEP
                                    </th>
                                    <th>
                                        Site
                                    </th>

                                    <th style="
                                        padding-right: 0px;
                                        "></th><th style="
                                        padding-right: 0px;
                                               "></th>
                                </tr>			
                                <%
                                    List<Departamento> listDepto = (List<Departamento>) request.getAttribute("listDepartamento");
                                    for (Departamento depto : listDepto) {
                                %>
                                <tr style="
                                    ">
                                    <td>
                                        <%=depto.getId()%>
                                    </td>
                                    <td>
                                        <%=depto.getUnidadeEnsino()%>
                                    </td>
                                    <td>
                                        <%=depto.getNome()%>
                                    </td>
                                    <td>
                                        <%=depto.getSigla()%>
                                    </td>
                                    <td>
                                        <%=depto.getEmail()%>
                                    </td>
                                    <td>
                                        <%=depto.getTelefone()%>
                                    </td> 
                                    <td>
                                        <%=depto.getCEP()%>
                                    </td>
                                    <td>
                                        <%=depto.getSite()%>
                                    </td>
                                    <td style="
                                        padding-right: 10px;
                                        ">                            
                                        <a href="/scm/servletweb?acao=AlterarDepartamento&IdDepartamento=<%=depto.getId()%>"><div id="alterar"></div></a>
                                    </td>
                                    <td style="padding-right: 0px;">                            
                                        <button id="excluir" onclick="Excluir(<%=depto.getId()%>, document.frmDepartamento);"></button>
                                    </td>
                                </tr>
                            </tbody><%  }%></table>
                    </form>
                </div>

            </div>

        </div>  
    </body></html> 