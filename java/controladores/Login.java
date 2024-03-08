package controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



@WebServlet("/login")
public class Login extends HttpServlet{
    
    private static final  long  serialVersionUID= 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String emailusuario= request.getParameter("emailusuario");
        String paswduser= request.getParameter("paswduser");
     
    // System.out.println(emailusuario);
    //  System.out.println(paswduser);

        HttpSession session= request.getSession();
        RequestDispatcher dispatcher=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/personas?useSSL=false", "root","17av5751" );
            final String SENTENCIA ="SELECT * FROM jsp  WHERE email=? and passwd=?";
            PreparedStatement ps= con.prepareStatement(SENTENCIA);
            ps.setString(1, emailusuario);
            ps.setString(2, paswduser);
            
            ResultSet rs =ps.executeQuery();
            
     
            if (rs.next()) {
                
             session.setAttribute("nombre", rs.getString(2));
               session.setAttribute("id", rs.getInt(1));
                session.setAttribute("direccion", rs.getString(3));
                session.setAttribute("email", rs.getString(4));
                
                dispatcher =request.getRequestDispatcher("datosuser.jsp");
            } else{
               request.setAttribute("satatus", "failed");
               dispatcher=request.getRequestDispatcher("login.jsp");
            
            }
                dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        finally {
        }
    
    }


   
}
    
  

        
      
       
       //   HttpSession session= request.getSession();
    /*    RequestDispatcher disp= null;
        
        
        
        try {
            Class.forName("com.mysql.jc.jdbc.Driver");
            Connection coneccion= DriverManager.getConnection("jdbc:mysql://localhost:3306/personas?useSSL=false","root" , "17av5751");
            final String SENTENCIA = "SELECT * FROM jsp WHERE email=? and passwd=?";
            PreparedStatement prepaSentencia= coneccion.prepareStatement(SENTENCIA);
            prepaSentencia.setString(2, emailusuario);
            prepaSentencia.setString(4, contraseña);
            
            ResultSet resulSet= prepaSentencia.executeQuery();
            
            System.out.println(emailusuario);
            System.out.println(contraseña);
           
            if(resulSet.next()) {	

				session.setAttribute("nombre", resulSet.getString(2));
				session.setAttribute("id", resulSet.getInt(1));
				session.setAttribute("email", resulSet.getString(4));
				session.setAttribute("direccion", resulSet.getString(3));
				
				// disp = request.getRequestDispatcher("index.jsp");
			}else {
				request.setAttribute("status", "failed");
				disp= request.getRequestDispatcher("login.jsp");
				
			}
            
            
        } catch (Exception e) {
        } finally {
        }
  */  

        
        
        
 
  
   

  

    
