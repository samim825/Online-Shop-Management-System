/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "VideoServlet", urlPatterns = {"/VideoServlet"})
public class VideoServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
               String test = "https://www.youtube.com/embed/tvTRZJ-4EyI";
               request.setAttribute("test", test);
               
               RequestDispatcher rd=request.getRequestDispatcher("videoTest.jsp");  
        rd.forward(request,response); 

    }

    
   
    

    

}
