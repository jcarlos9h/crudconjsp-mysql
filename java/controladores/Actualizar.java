
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

@WebServlet ("/actualizar")
public class Actualizar extends HttpServlet{
    
    private static final long serialVersionUID=1L;

    public Actualizar() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String nombreAct =request.getParameter("nn");
        String direccionAct =request.getParameter("nd");
        String emailAct =request.getParameter("ne");
        String passwdAct =request.getParameter("np");
        
        HttpSession session = request.getSession();
        int idUsuario= (int)session.getAttribute("id");
        
        /* 
        System.out.println(nombreAct);
        System.out.println(direccionAct);
        System.out.println(emailAct);
        System.out.println(passwdAct);
*/
        
        RequestDispatcher dispacher=null;
        Connection coneccion = null;
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            coneccion = DriverManager.getConnection("jdbc:mysql://localhost:3306/personas?useSSL=false", "root", "17av5751");
            final String SENTENCIA = "UPDATE jsp SET nombre =?, direccion=?, email =?, passwd=? WHERE id=?";
            
            PreparedStatement psentecncia =coneccion.prepareStatement(SENTENCIA);
            
            psentecncia.setString(1, nombreAct);
            psentecncia.setString(2, direccionAct);
            psentecncia.setString(3, emailAct);
            psentecncia.setString(4, passwdAct);
            psentecncia.setInt(5, idUsuario);
            
            int numeroEjecucion = psentecncia.executeUpdate();
            
            
            if (numeroEjecucion>0) {
                session.setAttribute("nombre", nombreAct);
                session.setAttribute("direccion", direccionAct);
                session.setAttribute("email", emailAct);
                session.setAttribute("passwd", passwdAct);
                
                dispacher =request.getRequestDispatcher("index.jsp");
            }
            dispacher.forward(request, response);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
            try {
                coneccion.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
      
        
        
    }
    
    
    
    
    
}
