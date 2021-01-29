package servlet;

import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
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
import sun.text.normalizer.UTF16;

@WebServlet(name = "newsServlet", urlPatterns = {"/newsServlet"})
public class newsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // response.setContentType("text/html;charset=UTF-8");
        String news = request.getParameter("news");
        
        System.out.println(news);

        String decode = URLDecoder.decode(news, "UTF-8");
        System.out.println(decode);
        //String decoded = URLDecoder.decode(news,);
        //System.out.println(URLDecoder.decode("à¦?à§?à¦¨à§? à¦¨à¦¿à¦°à§?à¦¦à¦¿à¦·à§?à¦? à¦¸à¦®à§?à§?, à¦¸à¦¾à¦§à¦¾à¦°à¦£à¦¤ à¦?à¦? à¦¬à¦?à¦°à§? à¦?à§?à¦¨à§? à¦¦à§?à¦¶à§?à¦° à¦?à¦¨à¦?à¦£ à¦®à§?à¦? à¦¯à§? à¦ªà¦°à¦¿à¦®à¦¾à¦£ à¦?à§?à§?à¦¾à¦¨à§?à¦¤ à¦¦à§?à¦°à¦¬à§?à¦¯ à¦¬à¦¾ à¦¸à§?à¦¬à¦¾ à¦?à§?à¦ªà¦¾à¦¦à¦¨ à¦?à¦°à§?, à¦¤à¦¾à¦° à¦?à¦°à§?à¦¥à¦®à§?à¦²à§?à¦¯à¦?à§? à¦®à§?à¦? à¦?à¦¾à¦¤à§?à§? à¦?à§?à¦ªà¦¾à¦¦à¦¨ à¦¬à¦²à§?à¥¤ à¦?à¦¾à¦¤à§?à§? à¦?à§?à¦ªà¦¾à¦¦à¦¨à§?à¦° à¦®à¦§à§?à¦¯à§? à¦¦à§?à¦¶à§?à¦° à¦?à¦­à§?à¦¯à¦¨à§?à¦¤à¦°à§? à¦¬à¦¸à¦¬à¦¾à¦¸à¦?à¦¾à¦°à§? à¦? à¦?à¦°à§?à¦®à¦°à¦¤ à¦¬à¦¿à¦¦à§?à¦¶à¦¿ à¦¬à§?à¦¯à¦?à§?à¦¤à¦¿ à¦? à¦¸à¦?à¦¸à§?à¦¥à¦¾à¦° à¦?à§?à¦ªà¦¾à¦¦à¦¨ à¦¬à¦¾ à¦?à§? à¦?à¦¨à§?à¦¤à¦°à§?à¦­à§?à¦?à§?à¦¤ à¦¹à¦¬à§? à¦¨à¦¾à¥¤ à¦¤à¦¬à§? à¦¬à¦¿à¦¦à§?à¦¶à§? à¦¬à¦¸à¦¬à¦¾à¦¸à¦?à¦¾à¦°à§? à¦? à¦?à¦°à§?à¦®à¦°à¦¤ à¦¦à§?à¦¶à¦¿ à¦¨à¦¾à¦?à¦°à¦¿à¦?, à¦¸à¦?à¦¸à§?à¦¥à¦¾ à¦? à¦ªà§?à¦°à¦¤à¦¿à¦·à§?à¦ à¦¾à¦¨à§?à¦° à¦?à§?à¦ªà¦¾à¦¦à¦¨ à¦¬à¦¾ à¦?à§? à¦?à¦¨à§?à¦¤à¦°à§?à¦­à§?à¦?à§?à¦¤ à¦¹à¦¬à§?à¥¤ à¦¸à§?à¦¤à¦°à¦¾à¦? à¦¬à¦¾à¦?à¦²à¦¾à¦¦à§?à¦¶à§?à¦° à¦¨à¦¾à¦?à¦°à¦¿à¦?à§?à¦°à¦¾ à¦¯à§? à¦¯à§?à¦?à¦¾à¦¨à§?à¦? à¦¥à¦¾à¦?à§?à¦?, à¦¤à¦¾à¦¦à§?à¦° à¦?à§?à¦ªà¦¾à¦¦à¦¨ à¦¬à¦¾ à¦?à§? à¦?à¦¿à¦?à¦¨à¦ªà¦¿à¦¤à§? à¦?à¦¨à§?à¦¤à¦°à§?à¦­à§?à¦?à§?à¦¤ à¦¹à¦¬à§?à¥¤ ", "UTF-8"));
        //String sql = "insert into news_paper values(ID,'" + decode + "' ,date)";
        //System.out.println(sql);
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select news from news_paper where ID = 1");

            System.out.println("news query visited");
            ResultSet rs = ps.executeQuery();
            System.out.println("query executed");
            if (rs.next()) {
                
              String  dbNews = rs.getString("news");
                System.out.println(dbNews);
                String result = "সুন্দর ভাবে পোষ্টটি জমা হয়েছে";
                request.setAttribute("result", result);
                request.setAttribute("news", dbNews);

                request.getRequestDispatcher("newsPost.jsp").forward(request, response);
            }  

        } catch (SQLException ex) {
            Logger.getLogger(newsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(newsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
