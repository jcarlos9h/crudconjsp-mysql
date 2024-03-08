<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
 <meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

        <title>INICIO DE SESSION</title>
    </head>
            <body>

                 <form action="login" method="post">
            <div class="container">    
                <div>
                    <label for="emailusuario">ingresa tu email</label>
                    <input type="email" name="emailusuario" class="form-control" id="emailusuario" required="">
                </div>
                
                <div> 
                 <label for="paswduser" >contraseña</label>    
                <input type="password" name="paswduser" class="form-control" id="paswduser" required="">
                </div>
               
                <button type="submit" value="enviar">Ingresar</button>
                
                <a class="btn btn-danger btn-sm m-1" style="width:100px ;" href="index.jsp" role="button">Atras</a>
                
            </div>
        </form>
    </body>
</html>
