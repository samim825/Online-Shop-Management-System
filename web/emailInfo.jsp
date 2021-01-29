

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Forgot password</title>
        <link href="BootstrapAdmin/css/bootstrap.min.css" rel="stylesheet">
        <link href="BootstrapAdmin/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="BootstrapAdmin/css/sb-admin.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Account Info.</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="GenerateVerificationCodeServlet" method="post">
                                <fieldset>
                                    <pre><h4>Shop name   :${shopName}</h4></pre>
                                    <pre><h4>Shop Address: ${shopAddress}</h4></pre><br><br>
                                    Is this your shop ? we will send you a verification code to your E-mail.
                                    <div class="form-group">
                                        <input type="hidden" value="${name}" name="name">
                                        <input class="form-control" value="${email}" name="email" style="border:none; background:transparent;" readonly>
                                    </div>
                                    <div class="btn-toolbar">
                                        <a href="index.jsp" class="btn btn-sm btn-default pull-right">Cancel</a>
                                        <button class="btn btn-sm btn-success pull-right" type="submit">Continue</button>  
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
