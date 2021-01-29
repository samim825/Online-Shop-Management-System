package servlet;

import database.DBConnection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaCode.EncryptPassword;
import javaCode.ProductNotify;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        EncryptPassword encryptPassword = new EncryptPassword();
        String password = encryptPassword.getMd5(pass);

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("select * from register where username = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                String name = rs.getString("name");
                String email = rs.getString("email");
                String spName = rs.getString("shopname");
                String address = rs.getString("address");

                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                session.setAttribute("email", email);
                session.setAttribute("spName", spName);
                session.setAttribute("address", address);
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                int i = 0;
                try {

                    String sql = "SELECT * from product_list where username = '" + username + "' and product_quantity<=5";
                    System.out.println(sql);       
                    ResultSet ps = preparedStatement.executeQuery(sql);
                    System.out.println("login page 2 visited");
                    ArrayList<ProductNotify> pn = new ArrayList<ProductNotify>();
                    System.out.println("arraylist visited");
                    
                    while (ps.next()) {
                        i++;
                        ProductNotify productNotify = new ProductNotify();

                        System.out.println("object create visited");
                        
                        productNotify.setUsername(ps.getString("username"));
                        System.out.println("setUsername visited");
                        productNotify.setProductName(ps.getString("product_name"));
                        System.out.println("product_name visited");
                        
                        productNotify.setProductQuantity(Double.parseDouble(ps.getString("product_quantity")));
                        System.out.println("product_quantity visited");
                        productNotify.setProductPrice(Double.parseDouble(ps.getString("product_price")));
                        System.out.println("product_price visited");

                        pn.add(productNotify);
                        
                        
                         System.out.println("pn.add(productNotify) visited");
                        

                        request.setAttribute("productList", pn);

                        System.out.println("login page 3 visited");
                    }
                    
                    String newsSql = "Select news from news_paper where ID = 7";
                    System.out.println("newsSql visted");
                    ResultSet news = preparedStatement.executeQuery(newsSql);
                    System.out.println("execute newsSql");
                    if(news.next()){
                        System.out.println("visit news if block");
                        String showNews = news.getString("news");
                        System.out.println("get data from database");
                        System.out.println(showNews);
                        request.setAttribute("showNews", showNews);
                    }

                } catch (SQLException ex) {
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
            } else {
                String msg = "Wrong username or password.Please try again.";
                request.setAttribute("msg", msg);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
