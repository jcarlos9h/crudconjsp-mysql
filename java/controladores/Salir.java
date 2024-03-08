
package controladores;

import com.mysql.cj.util.StringUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/salir")
public class Salir extends HttpServlet{

    private static final long  serialVersionUID = 1L;

    public Salir() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         HttpSession session= request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

  
    
   
    
    
}
