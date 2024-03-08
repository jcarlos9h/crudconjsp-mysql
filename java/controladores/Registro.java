package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
@WebServlet("/registro")
public class Registro extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // creamos las variables y les ppasamos los nombres del formulario
        String uname = request.getParameter("nombreuser");
        String udireccion = request.getParameter("direccion");
        String umail = request.getParameter("mail");
        String upaswd = request.getParameter("password");
        
        System.out.println(uname);
        System.out.println(udireccion);
        System.out.println(umail);
        System.out.println(upaswd);
       
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/personas?useSSL=false", "root", "17av5751");
            System.out.println(con);

            final String STATEMENT = "insert into jsp (nombre, direccion, email, passwd) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(STATEMENT);

            pst.setString(1, uname);
            System.out.println("uname");
            pst.setString(2, udireccion);
            System.out.println("udireccion");
            pst.setString(3, umail);
            System.out.println("umai");
            pst.setString(4, upaswd);
            System.out.println("upaswd");
            
            int rowCount = pst.executeUpdate();
            System.out.println(rowCount);

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
