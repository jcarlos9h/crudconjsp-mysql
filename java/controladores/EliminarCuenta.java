
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
import java.sql.SQLException;

@WebServlet("/eliminar")
public class EliminarCuenta extends HttpServlet{

private static final long SerialVersionUID= 1L;

    public EliminarCuenta() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session= request.getSession();
        RequestDispatcher dispacher= null;
        Connection coneccion =null;
        
        int idUsuario=(int)session.getAttribute("id");
        
        
        
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           coneccion=DriverManager.getConnection("jdbc:mysql://localhost:3306/personas?useSSL=false",
                   "root", "17av5751");
           final String SENTENCIA = "DELETE FROM  jsp WHERE id=?";
            PreparedStatement pSentencia= coneccion.prepareStatement(SENTENCIA);
            pSentencia.setInt(1, idUsuario);
            
            int rowCont= pSentencia.executeUpdate();
            
            if (rowCont>0) {
                session.setAttribute("nombre", null);
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("status", "failed");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                coneccion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
        
        
    }


    
    
    
}
