package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <title>Registration Page</title>\n");
      out.write("        <link href=\"BootstrapAdmin/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"BootstrapAdmin/font-awesome/css/font-awesome.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            #password-strength-status {padding: 5px 10px;color: #FFFFFF; border-radius:4px;margin-top:5px;}\n");
      out.write("            .medium-password{background-color: #E4DB11;border:#BBB418 1px solid;}\n");
      out.write("            .weak-password{background-color: #FF6600;border:#AA4502 1px solid;}\n");
      out.write("            .strong-password{background-color: #12CC1A;border:#0FA015 1px solid;}\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body style=\"background-color: WhiteSmoke   \">\n");
      out.write("\n");
      out.write("        <div  class=\"col-md-5 col-md-offset-3\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"panel-title text-center\">\n");
      out.write("                <h1 class=\"title\">Create new Shop</h1>\n");
      out.write("                <h4 style=\"color:red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${registrationError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"panel-body\">\n");
      out.write("                <form action=\"Registration\" method=\"post\" class=\"form-horizontal\" id=\"regForm\" onsubmit=\"return myFunction()\">\n");
      out.write("\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"name\" class=\"cols-sm-2 control-label\">Your Name</label>\n");
      out.write("                        <div class=\"cols-sm-10\">\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <span class=\"input-group-addon\"><i class=\"fa fa-user fa\" aria-hidden=\"true\"></i></span>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"name\" id=\"name\"  placeholder=\"Enter your Name\" required/>\n");
      out.write("                            </div>\n");
      out.write("                            <h4 style=\"color:red\" id=\"errorMessage\"></h4>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"email\" class=\"cols-sm-2 control-label\">Your Email</label>\n");
      out.write("                        <div class=\"cols-sm-10\">\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <span class=\"input-group-addon\"><i class=\"fa fa-envelope fa\" aria-hidden=\"true\"></i></span>\n");
      out.write("                                <input  type=\"email\" class=\"form-control\" name=\"email\" id=\"myEmail\"  placeholder=\"Enter your Email\" required/>\n");
      out.write("                            </div>\n");
      out.write("                            <h4 style=\"color:red\" id=\"emailResult\"></h4>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"ShopName\" class=\"cols-sm-2 control-label\">Shop Name</label>\n");
      out.write("                        <div class=\"cols-sm-10\">\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <span class=\"input-group-addon\"><i class=\"fa fa-building-o\" aria-hidden=\"true\"></i></span>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"shopname\"   placeholder=\"Enter your Shop Name\" required/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"address\" class=\"cols-sm-2 control-label\">Address</label>\n");
      out.write("                        <div class=\"cols-sm-10\">\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <span class=\"input-group-addon\"><i class=\"fa fa-building-o\" aria-hidden=\"true\"></i></span>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"address\"  placeholder=\"Enter your Address\" required/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"myuser\" class=\"cols-sm-2 control-label\">Username</label>\n");
      out.write("                        <div class=\"cols-sm-10\">\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <span class=\"input-group-addon\"><i class=\"fa fa-users fa\" aria-hidden=\"true\"></i></span>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"username\" id=\"myuser\"   placeholder=\"Enter your Username\" required/>                                            \n");
      out.write("                            </div>\n");
      out.write("                            <h4 style=\"color:red\" id=\"result\"></h4>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label for=\"password\" class=\"cols-sm-2 control-label\">Password</label>\n");
      out.write("                        <div class=\"cols-sm-10\">\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <span class=\"input-group-addon\"><i class=\"fa fa-lock fa-lg\" aria-hidden=\"true\"></i></span>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"password\" id=\"password\"  placeholder=\"Enter your Password\" class=\"demoInputBox\" onKeyUp=\"checkPasswordStrength();\"  required/>\n");
      out.write("                            </div>                            \n");
      out.write("                            <div id=\"password-strength-status\" ></div> \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"form-group \">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-lg btn-success btn-block\">Register</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"login-register\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("              <script>\n");
      out.write("                    $(document).ready(function(){\n");
      out.write("                        $(\"#name\").change(function(){\n");
      out.write("                           var name = $(\"#name\").val();\n");
      out.write("                           \n");
      out.write("                           \n");
      out.write("                           $.ajax({\n");
      out.write("                              type:'POST',\n");
      out.write("                              data:{yourname:name},\n");
      out.write("                              url:\"checkName\",\n");
      out.write("                              success:function(res){\n");
      out.write("                                  $(\"#errorMessage\").html(res);\n");
      out.write("                              }\n");
      out.write("                           });\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("                    </script>\n");
      out.write("                    \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("<!--Existing E-mail Check-->                \n");
      out.write("      <script>\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $('#myEmail').change(function(){\n");
      out.write("                    //alert(\"visited\");\n");
      out.write("                    var myEmail = $('#myEmail').val();\n");
      out.write("                    \n");
      out.write("                    $.ajax({\n");
      out.write("                        type:'POST',\n");
      out.write("                        data:{myEmail:myEmail},\n");
      out.write("                        url:'CheckEmailServlet',\n");
      out.write("                        success:function(result){\n");
      out.write("                            $('#emailResult').html(result);\n");
      out.write("                        }         \n");
      out.write("                    });\n");
      out.write("                });  \n");
      out.write("            });\n");
      out.write("        </script>   \n");
      out.write("                \n");
      out.write("\n");
      out.write("        <!--Existing Username Check-->                \n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#myuser').change(function () {\n");
      out.write("                    var myuser = $('#myuser').val();\n");
      out.write("\n");
      out.write("                    $.ajax({\n");
      out.write("                        type: 'POST',\n");
      out.write("                        data: {myuser: myuser},\n");
      out.write("                        url: 'checkUsername',\n");
      out.write("                        success: function (result) {\n");
      out.write("                            $('#result').html(result);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>   \n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--Password strength checker-->    \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function checkPasswordStrength() {\n");
      out.write("                var number = /([0-9])/;\n");
      out.write("                var alphabets = /([a-zA-Z])/;\n");
      out.write("                var special_characters = /([~,!,@,#,$,%,^,&,*,-,_,+,=,?,>,<])/;\n");
      out.write("\n");
      out.write("                if ($('#password').val().length < 6) {\n");
      out.write("                    $('#password-strength-status').removeClass();\n");
      out.write("                    $('#password-strength-status').addClass('weak-password');\n");
      out.write("                    $('#password-strength-status').html(\"Weak (should be atleast 6 characters.)\");\n");
      out.write("                } else {\n");
      out.write("                    if ($('#password').val().match(number) && $('#password').val().match(alphabets) && $('#password').val().match(special_characters)) {\n");
      out.write("                        $('#password-strength-status').removeClass();\n");
      out.write("                        $('#password-strength-status').addClass('strong-password');\n");
      out.write("                        $('#password-strength-status').html(\"Strong\");\n");
      out.write("                    } else {\n");
      out.write("                        $('#password-strength-status').removeClass();\n");
      out.write("                        $('#password-strength-status').addClass('medium-password');\n");
      out.write("                        $('#password-strength-status').html(\"Medium (should include alphabets, numbers and special characters.)\");\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
