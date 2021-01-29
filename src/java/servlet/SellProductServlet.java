
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
import javaCode.ProductMemo;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "SellProductServlet", urlPatterns = {"/SellProductServlet"})
public class SellProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        int count = Integer.parseInt(request.getParameter("count"));
        System.out.println("Insert page 1");
        System.err.println(count);

        ArrayList<ProductMemo> addProductMemos = new ArrayList<ProductMemo>();

        for (int i = 1; i <= count; i++) {

            String pName = request.getParameter("pName" + i);
            Double pQuantity = Double.parseDouble(request.getParameter("pQuantity" + i));
            System.out.println(pName + "  " + pQuantity);

            try {
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("select product_price from product_list where username = ? and product_name = ?");
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, pName);
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    Double productPrice = Double.parseDouble(rs.getString("product_price"));
                    System.out.println(productPrice);

                    Double totalPrice = pQuantity * productPrice;
                    System.out.println("Total Price : " + totalPrice);
                    ProductMemo productMemo = new ProductMemo();

                    productMemo.setUsername(username);
                    productMemo.setProductName(pName);
                    productMemo.setTotalQuantity(pQuantity);
                    productMemo.setProductPrice(productPrice);
                    productMemo.setTotalPrice(totalPrice);

                    addProductMemos.add(productMemo);

                    System.out.println("sell product  page visited");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SellProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SellProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        request.setAttribute("memoProductList", addProductMemos);

        request.getRequestDispatcher("sellProductMemo.jsp").forward(request, response);

        //response.getWriter().println(addProductMemos.toString());
    }

}
