package servlet;

import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaCode.ProductNotify;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProductNotifications", urlPatterns = {"/ProductNotifications"})
public class ProductNotifications extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        System.out.println("Notifications  page 1 visited");
        int i = 0;
        try {

            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("SELECT * from product_list where username = (?) and product_quantity<=5");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Notifications page 2 visited");
            ArrayList<ProductNotify> pn = new ArrayList<ProductNotify>();
            while (rs.next()) {
                i++;
                ProductNotify productNotify = new ProductNotify();
                productNotify.setProductName(rs.getString("product_name"));
                productNotify.setProductQuantity(Double.parseDouble(rs.getString("product_quantity")));
                productNotify.setUsername(rs.getString("username"));
                productNotify.setProductPrice(Double.parseDouble(rs.getString("product_price")));
                pn.add(productNotify);
                
                request.setAttribute("productList", pn);

                System.out.println("Notifications page 3 visited");

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductNotifications.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductNotifications.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(i>0){
                RequestDispatcher rd = request.getRequestDispatcher("welcomePage.jsp");
                rd.forward(request, response);
                System.out.println("posted");
                }
                else{
                    RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
                System.out.println("posted");
                }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
