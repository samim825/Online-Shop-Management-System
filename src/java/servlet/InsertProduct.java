package servlet;



import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.pkcs11.wrapper.Functions;


@WebServlet(urlPatterns = {"/InsertProduct"})
public class InsertProduct extends HttpServlet {
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
        for (int i = 1; i <= count; i++) {
            String pName = request.getParameter("pName"+i);
            
            try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("Select * from product_list where username = ? and product_name = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pName);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next()){
                continue;
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(productAvailability.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productAvailability.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
            double pQuantity =Double.parseDouble(request.getParameter("pQuantity"+i));
            double pPrice = Double.parseDouble(request.getParameter("pPrice"+i));
            try {
                PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("insert into product_list values(id,?,?,?,?)");
                preparedStatement.setString(1,username );
                preparedStatement.setString(2, pName);
                preparedStatement.setDouble(3,pQuantity );
                preparedStatement.setDouble(4, pPrice);
                preparedStatement.executeUpdate();
                System.out.println("Insert page 2");
                String msg = "Product added successfully";
                request.setAttribute("msg", msg);
                RequestDispatcher rd=request.getRequestDispatcher("insertProduct.jsp");  
        rd.forward(request,response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
    }
}
