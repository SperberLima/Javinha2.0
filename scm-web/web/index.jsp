<%@page contentType="text/html" pageEncoding="UTF-8" %>



<html lang="en" style="
      min-width: 100%;
      "><head>
        <meta charset="utf-8"> 
        <title>COOP</title>
        <meta name="viewport" content="width=device-width,initial-scale=1, user-scalable=no"> 
        <link rel="stylesheet" href="css/scm.css">   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>  
        <script type="text/javascript" src="js/script.js"></script>
        <link rel="icon" href="http://i.imgur.com/4LnFIn3.png">
        <link href="https://fonts.googleapis.com/css?family=Fjalla+One|Oswald:400,700|Passion+One|Anton|Source+Sans+Pro" rel="stylesheet" type="text/css">  
        <style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style><style type="text/css"></style></head>

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
                <ul> <a href="index.jsp"><li><span>Home</span></li></a> <a href="ajuda.html"><li><span>Ajuda</span></li></a> <a href="about.html"><li><span>Sobre nós</span></li></a> </ul>
            </div>
            <div id="wrapper" class="">
                <div style="min-width: 100%; height: 63px; padding-top: 16px; background: #668f86; box-shadow: 0px 0px 5px 6px rgba(0, 0, 0, 0.10); position: relative;">
                    <a id="openMenu" onclick="javascript: showMenu();" class=""><img class="burguer" src="http://www.sbrnetportal.com/images/hamburger.png" style=""></a>
                    <img src="http://i.imgur.com/r3Mrk7e.png" style="height: 50px;margin: 0 auto;display: block;">   
                </div>

                <div class="opt_container" style="
                     text-align: center;
                     ">
                    <form name="frmEscolha" method='post'>
                        <h1 class="form_title" style="
                            ">Selecione uma operação para <select id="sEscolha" name="select" style="
                                                              border: none;
                                                              background: inherit;
                                                              border-bottom: 1px solid #41a599;
                                                              outline: none;
                                                              color: rgba(191, 188, 188, 0.99);
                                                              font-size: x-large;
                                                              ">
                                <option value="ambiente">Ambiente</option>
                                <option value="curso">Curso</option>
                                <option value="departamento">Departamento</option>
                                <option value="disciplina">Disciplina</option>
                                <option value="periodo">Período</option>
                                <option value="professor">Professor</option>
                                <option value="unidade">Unidade de ensino</option>
                                <option value="Turma">Turma</option>
                                <option value="horario">Horario</option>
                                <option value="gradecurricular">Grade Curricular</option>
                                <option value="gradedisciplina">Relação Grade Disciplina</option>
                                <option value="professordisciplina">Relação Professor Disciplina</option>
                                <option value="curriculoofertado">Curriculo Ofertado</option>
                            </select></h1> </form>
                    <ul class="opt" style="">
                        <li onclick="redirect(1)" style="
                            "><span style="
                                ">Visualizar</span></li>

                        <li onclick="redirect(2)" style="
                            "><span style="
                                ">Editar</span></li>	

                        <li onclick="redirect(3)" style="
                            "><span style="
                                ">Cadastrar</span></li>
                    </ul>

                </div>

            </div>

        </div>  
    </body></html>  