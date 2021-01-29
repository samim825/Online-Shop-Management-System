
package servlet;

import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmailInfoServlet", urlPatterns = {"/EmailInfoServlet"})
public class EmailInfoServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        System.out.println(email);
        
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("Select *from register where email = ?");
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            System.err.println("execute visited");
            if(rs.next()){
                String name = rs.getString("name");
                String shopName = rs.getString("shopname");
                String address = rs.getString("address");
                System.out.println(shopName+"    "+address);
                
                request.setAttribute("name", name);
                request.setAttribute("shopName", shopName);
                request.setAttribute("shopAddress", address);
                request.setAttribute("email", email);
                
                RequestDispatcher rd = request.getRequestDispatcher("emailInfo.jsp");
                rd.forward(request, response);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmailInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmailInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    

}
