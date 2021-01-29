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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaCode.ProductRetrieve;
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
@WebServlet(name = "DeleteProduct", urlPatterns = {"/DeleteProduct"})
public class DeleteProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Delete page visited");
        String username = request.getParameter("username");
        String productname = request.getParameter("productname");
        System.out.println(username + productname);
        String Query = "delete from product_list where username ='" + username + "' && product_name = '" + productname + "'";
        String selQuery = "select username, product_name,product_quantity,product_price  from product_list where username = '" + username + "'";

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(Query);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DeleteProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("select username, product_name,product_quantity,product_price  from product_list where username = (?)");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("query execute");
            ArrayList<ProductRetrieve> pr = new ArrayList<ProductRetrieve>();
            while (rs.next()) {

                ProductRetrieve productRetrieve = new ProductRetrieve();
                productRetrieve.setUsername(rs.getString("username"));
                productRetrieve.setProductName(rs.getString("product_name"));
                productRetrieve.setProductQuantity(Double.parseDouble(rs.getString("product_quantity")));
                productRetrieve.setProductPrice(Double.parseDouble(rs.getString("product_price")));

                pr.add(productRetrieve);
                request.setAttribute("productList", pr);

                System.out.println("stock page visited");

            }
        } catch (SQLException ex) {
            Logger.getLogger(StockServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rd = request.getRequestDispatcher("stock.jsp");
        rd.forward(request, response);
    }

}
