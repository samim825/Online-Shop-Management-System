
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
import javax.servlet.http.HttpSession;


@WebServlet(name = "productAvailability", urlPatterns = {"/productAvailability"})
public class productAvailability extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String productName = request.getParameter("productAvailable");
        System.out.println(productName);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("Select * from product_list where username = ? and product_name = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, productName);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next()){
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.print("This Product Already exists");
                System.out.println("If block visited");
            }
            else{
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.print(" ");
                System.out.println("else block visited");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(productAvailability.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productAvailability.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
