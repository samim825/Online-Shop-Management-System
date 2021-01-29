<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Login Page</title>
        <link href="BootstrapAdmin/css/bootstrap.min.css" rel="stylesheet">
        <link href="BootstrapAdmin/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="BootstrapAdmin/css/sb-admin.css" rel="stylesheet">

    </head>

    <body>
        <br></br><h4 align="center" style="color:DodgerBlue;">${registrationMsg}</h4>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please Sign In</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="LoginServlet" method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <h5 style="color:red;">${msg}</h5>
                                        <input class="form-control" placeholder="Username" name="username" type="text" autofocus required>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="password" id="password1" type="password" required>
                                    </div>
                                   <!-- <div class="checkbox">
                                        <label>
                                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                        </label>
                                    </div>
                                   -->
                                    <div>
                                        <a href="forgotPassword.jsp">Forgot password</a>. Yet not registered!! <a href="registration.jsp">Register here</a> 
                                    </div>
                                    <br>
                                    <!-- Change this to a button or input when using this as a form -->
                                    <button class="btn btn-lg btn-success btn-block" type="submit">Login</button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        

    </body>

</html>
