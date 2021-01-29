
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
@WebServlet(name = "DailyReportServlet", urlPatterns = {"/DailyReportServlet"})
public class DailyReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String var1 = "1000";
        String var2 = "1500";
        String var3 = "1000";
        String var4 = "1500";
        String var5 = "2000";
        String var6 = "1000";
        String var7 = "1500";
        String var8 = "1000";
        String var9 = "2000";
        String var10 = "1500";
        String var11 = "1000";
        String var12 = "2000";
        
        request.setAttribute("1", var1);
        request.setAttribute("2", var2);
        request.setAttribute("3", var3);
        request.setAttribute("4", var4);
        request.setAttribute("5", var5);
        request.setAttribute("6", var6);
        request.setAttribute("7", var7);
        request.setAttribute("8", var8);
        request.setAttribute("9", var9);
        request.setAttribute("10", var10);
        request.setAttribute("11", var11);
        request.setAttribute("12", var12);
        
        RequestDispatcher rd = request.getRequestDispatcher("dailyReport.jsp");
        rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   

}
