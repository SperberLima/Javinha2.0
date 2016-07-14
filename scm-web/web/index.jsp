
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <style>
            *{
                font-family:"HelveticaNeue";
            }  
        </style></head>

    <body class="html" style="
          background: #20afae;
          ">  

        <div style="
             height: 500px;
             width: 1000px;
             background: aquamarine;
             margin: 0 auto;
             margin-top: 180px;
             box-shadow: 0px 0px 10px 1px rgba(0,0,0,.1);
             ">

            <div style="
                 float: left;
                 height: 500px;
                 width: 400px;
                 ">

                <img src="http://i.imgur.com/4LnFIn3.png" style="
                     height: 200px;
                     display: block;
                     margin: 0 auto;
                     border-radius: 100px;
                     margin-top: 135px;
                     box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.2);
                     ">

            </div>
            <div style="
                 height: 100%;
                 height: 501.5px;
                 position: relative;
                 top: -0.5px;
                 width: 600px;
                 background-color: white;
                 float: right;
                 box-shadow: -4px 0px 10px 0px rgba(0,0,0,0.1);
                 ">

                <h1 style="
                    text-align: center;
                    border-bottom: 1px solid #f1ede8;
                    padding: 20px;
                    color: hsl(173, 43%, 45%);
                    font-weight: lighter;">LOGIN</h1>


                <div style="text-align: center;margin-top: 100px;">
                    <form name="frmLogin" method='post'>
                        <input name="user" class="login_input" type="text" value="" placeholder="USUÁRIO">
                        <img src="http://image.prntscr.com/image/ae011b1c9c984e2286fd8c7b94cd4ca4.png" style="
                             position: absolute;
                             left: 140;
                             height: 20px;
                             top: 182px;
                             ">
                        <input name="password" class="login_input" type="password" value="" placeholder="SENHA">
                        <img src="http://image.prntscr.com/image/9830225b06084d9b9168925518733043.png" style="
                             position: absolute;
                             left: 140;
                             height: 20px;
                             top: 245px;
                             ">
                        <button class="login_button" onclick="validarCamposLogin()">LOGIN</button>
                    </form>        

                </div>

            </div>

        </div>


    </body></html>
