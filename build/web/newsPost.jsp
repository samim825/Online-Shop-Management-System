

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>post news</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="panel-body">

        <form action="newsServlet" method="post">
            <div class="form-group col-sm-8 col-sm-offset-2">
                <p>${result}</p>
                <label for="comment">সংবাদ লিখুন</label>
                <textarea class="form-control" rows="5" name="news"></textarea><br>
                <input type="submit" value="submit">
                
                <br><br><br><br>
                <p>${news}</p>
            </div>
        </form>
        
        </div>
    </body>
</html>
