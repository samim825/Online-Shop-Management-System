/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author User
 */
@WebServlet(name = "checkUsername", urlPatterns = {"/checkUsername"})
public class checkUsername extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String myuser = request.getParameter("myuser");
        System.out.println(myuser);
        
        
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("SELECT * FROM register where username = ?");
            preparedStatement.setString(1, myuser);
            ResultSet rs= preparedStatement.executeQuery();
            
            System.out.println("Query executed");
            
            if(rs.next()){
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.print("This Username already has taken.");
                System.out.println("If block visited");
            }
            else{
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.print(" ");
                System.out.println("else block visited");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(checkUsername.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(checkUsername.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
