package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javaCode.Mailer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "SendingEmail", urlPatterns = {"/SendingEmail"})
public class SendingEmail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String msg = request.getParameter("msg");

        System.out.println(to + "    " + subject + "  " + msg);

        String from = "samimhossain825@gmail.com";        
        String password = "smmhossain";
        

        Mailer.send(to, subject, msg, from, password);
        
        System.out.println("Mailer class visited");

        System.out.print("message has been sent successfully");

    }

}
