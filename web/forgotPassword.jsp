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
                <br><br><br>
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please Enter Your E-mail.</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="EmailInfoServlet" method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="E-mail" name="email" type="text" autofocus required>
                                    </div>
                                    <div class="btn-toolbar">
                                        <a href="index.jsp" class="btn btn-sm btn-default pull-right">Cancel</a>
                                        <button class="btn btn-sm btn-success pull-right" type="submit">Search</button>  
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

