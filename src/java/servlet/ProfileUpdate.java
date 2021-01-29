package servlet;

import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.jni.User;


@WebServlet(urlPatterns = {"/ProfileUpdate"})
public class ProfileUpdate extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
         String password = (String) session.getAttribute("password");
         
        
        String updateName = request.getParameter("name");
        String updateEmail = request.getParameter("email");
        String updateShopName = request.getParameter("shopname");
        String updateAddress = request.getParameter("address");
        
        
        String sql = "update register set name = '"+updateName+"',email = '"+updateEmail+"',shopname = '"+updateShopName+"',address = '"+updateAddress+"' where username='"+username + "' and password ='"+password+"';";
        
        System.out.println(sql);
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sql);
       
            System.out.println("Updated successfully");
            
            
            preparedStatement.executeUpdate();
            
                session.setAttribute("name", updateName);
                session.setAttribute("email", updateEmail);
                session.setAttribute("spName", updateShopName);
                session.setAttribute("address", updateAddress);
                session.setAttribute("username", username);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfileUpdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfileUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       response.sendRedirect("userProfile.jsp");
    }

    
}
