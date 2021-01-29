
package servlet;

import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CheckEmailServlet", urlPatterns = {"/CheckEmailServlet"})
public class CheckEmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String userEmail = request.getParameter("myEmail");
        System.out.println(userEmail);
        
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("SELECT * FROM register where email = ?");
            preparedStatement.setString(1, userEmail);
            ResultSet rs= preparedStatement.executeQuery();
            
            System.out.println("Query executed");
            
            if(rs.next()){
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.print("This E-mail already exist.Please try with another E-mail.");
                System.out.println("If block visited");
            }
            else{
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.print(" ");
                System.out.println("else block visited");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CheckEmailServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckEmailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
