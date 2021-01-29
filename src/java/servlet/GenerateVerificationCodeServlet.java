package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javaCode.Mailer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "GenerateVerificationCodeServlet", urlPatterns = {"/GenerateVerificationCodeServlet"})
public class GenerateVerificationCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
        String name = request.getParameter("name");
        int randomCode = (int) (100000 + Math.random() * 85870);
        System.out.println("num : " + randomCode);

        String to = request.getParameter("email");
        System.out.println(to);
        String subject = "Password Reset";
        String msg = "Hi " + name + " ,\n" + "\n"
                + "We received a request to reset your Facebook password.\n"
                + "Enter the following password reset code: " + randomCode;

        //System.out.println(to + "    " + subject + "  " + msg);

        String from = "samimhossain825@gmail.com";
        String password = "smmhossain";

        Mailer.send(to, subject, msg, from, password);

        System.out.println("Mailer class visited");

        System.out.print("message has been sent successfully");

        request.getRequestDispatcher("verification.jsp").forward(request, response);
    }

}
