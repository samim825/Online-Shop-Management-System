
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


@WebServlet(name = "QuantityCheckServlet", urlPatterns = {"/QuantityCheckServlet"})
public class QuantityCheckServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        double quantityCheck = Double.parseDouble(request.getParameter("quantityCheck"));
        String productName = request.getParameter("productName");
        System.out.println(username+"   "+productName+"    "+quantityCheck);
        
        
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("Select product_quantity from product_list where username = ? and product_name = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, productName);
            ResultSet rs = preparedStatement.executeQuery();
            
            System.out.println("Query executed");
            //ResultSet rs = preparedStatement.executeQuery();
            //System.out.println("Resulset visited");
            
            if(rs.next()){
                
              double quantity = Double.parseDouble(rs.getString("product_quantity"));
                System.out.println(quantity);
                
                if(quantityCheck > quantity){
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.print("Sorry!!! "+quantityCheck+ " "+productName+" is not available .You have only "+quantity+" "+productName);
                    System.out.println("This product is low quantity");
                System.out.println("If block visited");
                }
            }         
            
        } catch (SQLException ex) {
            Logger.getLogger(QuantityCheckServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuantityCheckServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
