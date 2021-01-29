package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javaCode.ProductNotify;
import java.util.Iterator;
import java.util.ArrayList;

public final class welcomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
 if ((session.getAttribute("username") == null) || session.getAttribute("username") == " ") {


      out.write("\n");
      out.write("you are not logged in.This is restricted page. </br>\n");
      out.write("So, Please <a href=\"index.jsp\">Login</a>\n");
} else {

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <title>welcome</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <link href=\"BootstrapAdmin/css/plugins/morris/morris-0.4.3.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"BootstrapAdmin/css/plugins/timeline/timeline.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"BootstrapAdmin/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"BootstrapAdmin/font-awesome/css/font-awesome.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"BootstrapAdmin/css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-1.10.2.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            .td-post-date {\n");
      out.write("                color: #aaa;\n");
      out.write("                display: inline-block;\n");
      out.write("                position: relative;\n");
      out.write("                top: 2px;\n");
      out.write("            }\n");
      out.write("            .title {\n");
      out.write("                font-weight: 700 ;\n");
      out.write("                color: #1f4363 !important;\n");
      out.write("                font-size: 25px;\n");
      out.write("                line-height: 33px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            .fakeimg {\n");
      out.write("                height: 200px;\n");
      out.write("                background: none;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #myBtn {\n");
      out.write("                display: none;\n");
      out.write("                position: fixed;\n");
      out.write("                bottom: 20px;\n");
      out.write("                right: 30px;\n");
      out.write("                z-index: 99;\n");
      out.write("                font-size: 18px;\n");
      out.write("                border: none;\n");
      out.write("                outline: none;\n");
      out.write("                background-color: red;\n");
      out.write("                color: white;\n");
      out.write("                cursor: pointer;\n");
      out.write("                padding: 15px;\n");
      out.write("                border-radius: 4px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #myBtn:hover {\n");
      out.write("                background-color: #555;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body style=\"overflow-x:hidden\">\n");
      out.write("\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("          \n");
      out.write("\n");
      out.write("            <div class=\"navbar-fixed-top\">\n");
      out.write("                <nav class=\"navbar navbar-default navbar-static-top \"  role=\"navigation\" style=\"margin-bottom: 0;\">\n");
      out.write("                    <div class=\"col-md-5 col-md-offset-4\" class=\"navbar-header\">\n");
      out.write("                        <h3 class=\"text-center\"><a href=\"ProductNotifications\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${spName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></h3>\n");
      out.write("                        <h5 class=\"text-center\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h5>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-top-links navbar-right\">\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                                <i class=\"fa fa-envelope fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                                <i class=\"fa fa-user fa-fw\"></i>  <i class=\"fa fa-caret-down\"></i>\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                                <li><a href=\"userProfile.jsp\"><i class=\"fa fa-user fa-fw\"></i> User Profile</a>\n");
      out.write("                                </li>\n");
      out.write("                                <li><a href=\"logoutServlet\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                            <!-- /.dropdown-user -->\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <br><br><br><br>\n");
      out.write("                <nav class=\"navbar-default navbar-static-side\" role=\"navigation\">\n");
      out.write("                    <div style=\"position:fixed;\" class=\"sidebar-collapse\">\n");
      out.write("                        <ul class=\"nav\" id=\"side-menu\">\n");
      out.write("\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"ProductNotifications\"><i class=\"fa fa-dashboard fa-fw\"></i> Dashboard </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"sellProduct.jsp\"><i class=\"fa fa-shopping-cart\">  Sell Product</i></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"insertProduct.jsp\"><i class=\"fa fa-plus-square-o\">  Add Product</i></a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"StockServlet\"><i class=\"fa fa-edit fa-fw\"></i> Stock</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-files-o fa-fw\"></i> Report<span class=\"fa arrow\"></span></a>\n");
      out.write("                                <ul class=\"nav nav-second-level\">\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"DailyReportServlet\">Daily Report</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"#\">Monthly Report</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li>\n");
      out.write("                                        <a href=\"yearlyReport.jsp\">Yearly Report</a>\n");
      out.write("                                    </li>\n");
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"page-wrapper\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"col-sm-5 pull-left\" \">\n");
      out.write("            </br></br></br></br>\n");
      out.write("            <ul>\n");
      out.write("                \n");
      out.write("                    ");
             ArrayList<ProductNotify> pn = (ArrayList) request.getAttribute("productList");
                        Iterator it = pn.iterator();
                        while (it.hasNext()) {

                            ProductNotify productNotify = (ProductNotify) it.next();

                    
      out.write("      \n");
      out.write("                    \n");
      out.write("                    <li><h4 style=\"color:OrangeRed \">");
      out.print(productNotify.getProductName());
      out.write(" is consists only ");
      out.print(productNotify.getProductQuantity());
      out.write(" pc's/kg's .");
out.print("<a href='editProduct.jsp?username=" + productNotify.getUsername() + "&&productname=" + productNotify.getProductName() + "&&productQty="+productNotify.getProductQuantity()+"&&productPrice="+productNotify.getProductPrice()+"'>Please add this product.</a>");
      out.write("</h4></li>\n");
      out.write("                        \n");
      out.write("                    \n");
      out.write("                    ");

                        }

                    
      out.write(" \n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("<h3 align=\"center\">News section</h3>\n");
      out.write("        <div  class=\"col-sm-7\" id='news' >\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${showNews}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>  \n");
      out.write("                <p>??? ????? hi</p>\n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("\n");
      out.write("<button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\">Top</button>\n");
      out.write("<!--JavaScript code for top button-->\n");
      out.write("<script>\n");
      out.write("// When the user scrolls down 20px from the top of the document, show the button\n");
      out.write("    window.onscroll = function () {\n");
      out.write("        scrollFunction()\n");
      out.write("    };\n");
      out.write("\n");
      out.write("    function scrollFunction() {\n");
      out.write("        if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {\n");
      out.write("            document.getElementById(\"myBtn\").style.display = \"block\";\n");
      out.write("        } else {\n");
      out.write("            document.getElementById(\"myBtn\").style.display = \"none\";\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("// When the user clicks on the button, scroll to the top of the document\n");
      out.write("    function topFunction() {\n");
      out.write("        document.body.scrollTop = 0;\n");
      out.write("        document.documentElement.scrollTop = 0;\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
 }
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
