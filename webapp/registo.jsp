<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="ISO-8859-1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <title>JAVA</title>
    </head>
    <body>

        <div class=" container mt-5"> 
            <div class="row">
                <div class="col-sm">  
                                <form action="registro" method="post">
                        <div class="mb-4">
                            <label for="nombreuser" class="mb-1" >Ingresa tu nombre</label>
                            <input type="text" class="form-control" name="nombreuser" id="nombreuser" required="">
                        </div>
                        <div class="mb-4">
                            <label class="mb-1">direccion</label>
                            <input type="text" class="form-control" name="direccion" id="direccion" required=""  >
                        </div>
                          <div class="mb-4">
                            <label class="mb-1" >Email</label>
                            <input type="Email" class="form-control" name="mail" id="mail" required=""  >
                        </div>          
                        <div class="mb-4">
                            <label class="mb-1"> password</label>
                            <input type="password" class="form-control" name="password" id="password" required="" >
                        </div>     
                                    
                        <button type="submit" class="btn btn-primary" value="registrarse" >registrarse</button>
                        <a class="btn btn-danger btn-sm m-1" style="width:100px ;" href="index.jsp" role="button">Atras</a>
                    </form>
                </div>
            </div>
                </div>
    </body>
</html>
