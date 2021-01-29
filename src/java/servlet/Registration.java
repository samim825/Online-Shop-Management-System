package servlet;


import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaCode.EncryptPassword;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/Registration"})
public class Registration extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String shopname = request.getParameter("shopname");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        
       
        EncryptPassword encryptPassword = new EncryptPassword();
        String password = encryptPassword.getMd5(pass);
        
        String registrationMsg = "Registered successfully.Please Log in.";
        String registrationError = "Registration failed.Please try again";
        
        
        
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("insert into register values(id,?,?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, shopname);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);
            //preparedStatement.executeUpdate();
            
            int i = preparedStatement.executeUpdate(); 
            if(i>0){
                request.setAttribute("registrationMsg", registrationMsg);
        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
        rd.forward(request,response);       
            }
            
      
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("registrationError", registrationError);
             RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");  
        rd.forward(request,response); 
        } 
         
        
        
        
    }

   

}
