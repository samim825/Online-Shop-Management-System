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
@WebServlet(name = "EditProductServlet", urlPatterns = {"/EditProductServlet"})
public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("edit page visited");
        String username = request.getParameter("username");
        String productName = request.getParameter("pName");
        String productQuantity = request.getParameter("pQuantity");
        String productPrice = request.getParameter("pPrice");
        
        String updateMsg = "Data Updated Successfully";
        System.out.println("edit page again  visited");
        System.out.println(username + "    " + productName + "    " + productQuantity + "  " + productPrice);
        System.out.println("edit page again and again  visited");

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("Update product_list set product_quantity = ? ,product_price = ? where username = ? and product_name = ?");
            preparedStatement.setString(1, productQuantity);
            preparedStatement.setString(2, productPrice);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, productName);
            preparedStatement.executeUpdate();

            System.out.println("Edit page Update block visited");

        } catch (SQLException ex) {
            Logger.getLogger(EditProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("select username, product_name,product_quantity,product_price  from product_list where username = (?)");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Edit page Data Retrieve");
            ArrayList<ProductRetrieve> pr = new ArrayList<ProductRetrieve>();
            while (rs.next()) {

                ProductRetrieve productRetrieve = new ProductRetrieve();
                productRetrieve.setUsername(rs.getString("username"));
                productRetrieve.setProductName(rs.getString("product_name"));
                productRetrieve.setProductQuantity(Double.parseDouble(rs.getString("product_quantity")));
                productRetrieve.setProductPrice(Double.parseDouble(rs.getString("product_price")));

                pr.add(productRetrieve);
                request.setAttribute("productList", pr);

            }
        } catch (SQLException ex) {
            Logger.getLogger(StockServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("updateMsg", updateMsg);
        RequestDispatcher rd = request.getRequestDispatcher("stock.jsp");
        rd.forward(request, response);

    }
}
