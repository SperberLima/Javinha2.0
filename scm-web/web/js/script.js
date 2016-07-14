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
       window.location="/scm/servletweb?acao=Cadastrar"+value;
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