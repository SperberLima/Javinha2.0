<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.inf.model.domain.*" %>
<%@page import="java.util.List" %>

<% Horario horario = (Horario) request.getAttribute("horario");%>

<html lang="en" style="
      min-width: 100%;
      "><head>
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
                    <h1 class="form_title">Alterar dados de horário</h1>



                    <form name="frmHorario" method="post" action="">
                        <table>
                            <tbody>
                                <tr style="">
                                    <td id="field" style="
                                        "><span style="
                                            font-size: 16px;
                                            ">ID</span></td>
                                    <td><input class="form_input" name="id" type="text" value="<%= horario.getId()%>" placeholder="ID"></td>
                                </tr>
                                <tr>
                                    <td id="field"><span>Ambiente de aprendizado</span></td>
                                    <td>
                                        <select name="ambiente" class="form_input">
                                            <%
                                                List<AmbienteAprendizagem> listAmbiente = (List<AmbienteAprendizagem>) request.getAttribute("listAmbiente");
                                                for (AmbienteAprendizagem amb : listAmbiente) {
                                            %>
                                            <option                                     
                                                value='<%= amb.getId()%>'><%= amb.getDescricao()%>
                                            </option>
                                            <%  }%>
                                        </select>
                                    </td>  
                                </tr>
                                <tr>
                                    <td id="field"><span>Turma</span></td>
                                    <td>
                                        <select name="turma" class="form_input">
                                            <%
                                                List<Turma> listTurma = (List<Turma>) request.getAttribute("listTurma");
                                                for (Turma tur : listTurma) {
                                            %>
                                            <option                                     
                                                value='<%=tur.getId()%>'><%=tur.getNome()%>
                                            </option>
                                            <%  }%>
                                        </select>
                                    </td> 
                                </tr>
                                <tr>
                                    <td id="field"><span>Professor Disciplina</span></td>
                                    <td>
                                    <td>
                                        <select name="professor" class="form_input">
                                            <%
                                                List<ProfessorDisciplina> listProfessor = (List<ProfessorDisciplina>) request.getAttribute("listProfessor");
                                                for (ProfessorDisciplina pro : listProfessor) {
                                            %>
                                            <option                                     
                                                value='<%=pro.getId()%>'><%= pro.getId()%>
                                            </option>
                                            <%  }%>
                                        </select>
                                    </td> 
                                </tr>
                                <tr style="border: 1px solid gray;">
                                    <td id="field"><span>Horário início</span></td> 
                                    <td><input class="form_input" name="inicio" type="text" value="<%= horario.getInicio()%>" placeholder="Início"></td>
                                </tr> 
                            </tbody></table>
                        <div class="butcontainer">
                            <input type="reset" value="CANCELAR" class="cancela" style=" height: 35px; width: 120px;"><button class="redefine" style="height: 35px;width: 120px;margin-left: 15px;
                                                                                                                              ">REDEFINIR</button> 

                        </div>
                </div>

            </div>

        </div>  
    </body></html>    