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