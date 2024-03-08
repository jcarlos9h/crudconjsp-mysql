<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
    <head>
         <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">   
        <title>tus datos</title>
    </head>
    
    

    <body>
        <div class="container">
            <a class="nav-link active fs-4 text-black links me-5" 
               aria-current="page" href="datosuser.jsp" style="text-decoration: none">
                Usuario = <%=session.getAttribute("nombre") %> </a>
                
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 " >
                <li class="nav-item">
                    <a class="nav-link active fs-4 text-black links me-5" aria-current="page"
                       href="datosuser.jsp" style="text-decoration: none"> 
                        id = <%=session.getAttribute("id") %> </a>
                </li>
        </div>

        <section>

            <div class="container">
                <ul class="col  col-xs-4 col-lg-4 " id="datosPersonalesparaOcultar"  >
                    <li class="list-group-item">Nombre : <%=session.getAttribute("nombre") %></li>

                    <li class="list-group-item">Direccion: <%=session.getAttribute("direccion") %></li>

                    <li class="list-group-item">email <%=session.getAttribute("email") %></li>

                </ul>

            </div>
        </section>
                    
        <div>
            <a href="salir"> salir</a>      
        </div>            
    </body>
</html>
