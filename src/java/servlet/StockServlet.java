package servlet;


import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaCode.ProductRetrieve;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.pkcs11.wrapper.Functions;


@WebServlet(urlPatterns = {"/StockServlet"})
public class StockServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        System.out.println("stock page");
        
        //ArrayList<String> pr = new ArrayList<String>();
        try {
            
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("select username, product_name,product_quantity,product_price  from product_list where username = (?)");
            preparedStatement.setString(1, username);            
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("query execute");
            ArrayList<ProductRetrieve> pr = new ArrayList<ProductRetrieve>();
           
            while(rs.next()){
                
                System.out.println(rs.getString("product_name"));
                ProductRetrieve productRetrieve = new ProductRetrieve();
                productRetrieve.setUsername(rs.getString("username"));
                productRetrieve.setProductName(rs.getString("product_name"));
                productRetrieve.setProductQuantity(Double.parseDouble(rs.getString("product_quantity")));
                productRetrieve.setProductPrice(Double.parseDouble(rs.getString("product_price")));
                
                System.out.println(productRetrieve);
                
                pr.add(productRetrieve);
                 

                request.setAttribute("productList", pr);
                
                
                System.out.println("stock page visited");
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(StockServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
     RequestDispatcher rd = request.getRequestDispatcher("stock.jsp");rd.forward(request, response);  
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    

}
