//ESTÉTICA

$(window).scroll(function () { 
  if ( $(this).scrollTop() > 80 && !$('header').hasClass('fixed') ) {
    $('header').addClass('fixed');  
    $('#content').addClass('pad');
    $('header').slideDown(280);   
    $('#content').slideDown(280);   
   } else if ( $(this).scrollTop() <= 80 ) {
    $('header').removeClass('fixed');  
    $('#content').removeClass('pad');
     $('header').slideUp(150);     
  } 
});                


function showMenu(){ 
     
    var menu = document.getElementById("menu");
    var opmenu = document.getElementById("openMenu");
    var wrapper = document.getElementById("wrapper");
       
    wrapper.classList.add("push"); 
    opmenu.classList.add("hidee");  
    menu.classList.remove("hide"); 
    menu.classList.add("menu");      
    
    opmenu.setAttribute( "onclick", "closeMenu();" );  
    
    document.getElementsByClassName("burguer").classList.add("oneburguer");
     
}  

function closeMenu(){  
    
    var menu = document.getElementById("menu");
    var opmenu = document.getElementById("openMenu");
    var wrapper = document.getElementById("wrapper");
    
    wrapper.classList.remove("push"); 
    opmenu.classList.remove("hidee");
    menu.classList.add("hide");
    menu.classList.remove("menu");  
       
    opmenu.setAttribute( "onClick", "javascript: showMenu();" );    
    
    document.getElementsByClassName("oneburguer").classList.remove("oneburguer");
}   


// REDIRECIONAMENTO

function redirect(op){ 
    var e = document.getElementById("sEscolha");
    var value = e.options[e.selectedIndex].value;
    /*
    if(op==1){
           window.location="visualizar/"+value+".jsp";      
    }else
    if(op==2){
           window.location="alterar/"+value+".jsp";      
    }else
    if(op==3){
           window.location="cadastrar/"+value+".jsp";      
    }
     */
    
    alert(value);
    
    if(op==1 || op==2){        
       window.location="/scm/servletweb?acao=Visualizar"+value;
    }else
    if(op==3){        
       window.location="/scm/servletweb?acao=Inserir"+value;
    }
}

function GravarInsercao(frm){
    var table = frm.table.value;
    caminhourl = "/scm/servletweb?acao=GravarInsercao"+table;  
    frm.action = caminhourl;
    frm.submit();
}


function GravarAlteracao(frm){
    var table = frm.table.value;
    caminhourl = "/scm/servletweb?acao=GravarAlteracao"+table;
    frm.action = caminhourl;
    frm.submit();
}


function Excluir(chave, frm) {
    alert(frm.name);
    var table = frm.name;

    if (table == "frmAmbiente") {
        if(confirm('Deseja excluir o ambiente de Aprendizagem de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirAmbienteAprendizagem";
           frm.submit();
        }
    }
    else if (table == "frmCurriculo") {
        if(confirm('Deseja excluir o currículo de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirCurriculoOferta";
           frm.submit();
        }
    }
    else if (table == "frmCurso") {
        if(confirm('Deseja excluir o curso de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirCurso";
           frm.submit();
        }
    }
    else if (table == "frmDepartamento") {
        if(confirm('Deseja excluir o departamento de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirDepartamento";
           frm.submit();
        }
    }
    else if (table == "frmDisciplina") {
        if(confirm('Deseja excluir a disciplina de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirDisciplina";
           frm.submit();
        }
    }
    else if (table == "frmGradeCurricular") {
        if(confirm('Deseja excluir a grade curricular de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirGradeCurricular";
           frm.submit();
        }
    }
    else if (table == "frmGradeDisciplina") {
        if(confirm('Deseja excluir a relação grade disciplina de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirGradeDisciplina";
           frm.submit();
        }
    }
    else if (table == "frmHorario") {
        if(confirm('Deseja excluir o horario de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirHorario";
           frm.submit();
        }
    }
    else if (table == "frmPeriodo") {
        if(confirm('Deseja excluir o periodo de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirPeriodoLetivo";
           frm.submit();
        }
    }
    else if (table == "frmProfessor") {
        if(confirm('Deseja excluir o professor de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirProfessor";
           frm.submit();
        }
    }
    else if (table == "frmProfessorDisciplina") {
        if(confirm('Deseja excluir a relação professor disciplina de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirProfessorDisciplina";
           frm.submit();
        }
    }else if (table == "frmTurma") {
        if(confirm('Deseja excluir a turma de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirTurma";
           frm.submit();
        }
    }
    else if (table == "frmUnidade") {
        if(confirm('Deseja excluir a unidade de ensino de ID: '+ chave+'?')){
           frm.action="/scm/servletweb?acao=ExcluirUnidadeEnsino";
           frm.submit();
        }
    }
    
    
}

// VALIDAÇOES 

function validarCamposLogin() {
    var frm = document.frmLogin;
    var user = frm.user.value;
    var senha = frm.password.value;

    if (user == "") {
        alert("Favor, preencha o campo usuário!");
        frm.user.focus();
        return false;
    } else if (senha == "") {
        alert("Favor, preencha o campo senha!");
        frm.senha.focus();
        return false;
    } else {
        caminhourl = "/scm/servletweb?acao=Logar";
        document.forms[0].action = caminhourl;
        window.document.forms[0].submit();
        return true;
    }
}

