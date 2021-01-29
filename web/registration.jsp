
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Registration Page</title>
        <link href="BootstrapAdmin/css/bootstrap.min.css" rel="stylesheet">
        <link href="BootstrapAdmin/font-awesome/css/font-awesome.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <style>
            #password-strength-status {padding: 5px 10px;color: #FFFFFF; border-radius:4px;margin-top:5px;}
            .medium-password{background-color: #E4DB11;border:#BBB418 1px solid;}
            .weak-password{background-color: #FF6600;border:#AA4502 1px solid;}
            .strong-password{background-color: #12CC1A;border:#0FA015 1px solid;}

        </style>

    </head>

    <body style="background-color: WhiteSmoke   ">

        <div  class="col-md-5 col-md-offset-3">


            <div class="panel-title text-center">
                <h1 class="title">Create new Shop</h1>
                <h4 style="color:red;">${registrationError}</h4>

            </div>


            <div class="panel-body">
                <form action="Registration" method="post" class="form-horizontal" id="regForm" onsubmit="return myFunction()">

                    <div class="form-group">
                        <label for="name" class="cols-sm-2 control-label">Your Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="name" id="name"  placeholder="Enter your Name" required/>
                            </div>
                            <h4 style="color:red" id="errorMessage"></h4>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="cols-sm-2 control-label">Your Email</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input  type="email" class="form-control" name="email" id="myEmail"  placeholder="Enter your Email" required/>
                            </div>
                            <h4 style="color:red" id="emailResult"></h4>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ShopName" class="cols-sm-2 control-label">Shop Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-building-o" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="shopname"   placeholder="Enter your Shop Name" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="address" class="cols-sm-2 control-label">Address</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-building-o" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="address"  placeholder="Enter your Address" required/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="myuser" class="cols-sm-2 control-label">Username</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="username" id="myuser"   placeholder="Enter your Username" required/>                                            
                            </div>
                            <h4 style="color:red" id="result"></h4>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="password" class="cols-sm-2 control-label">Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password" class="demoInputBox" onKeyUp="checkPasswordStrength();"  required/>
                            </div>                            
                            <div id="password-strength-status" ></div> 
                        </div>
                    </div>



                    <div class="form-group ">
                        <button type="submit" class="btn btn-lg btn-success btn-block">Register</button>
                    </div>
                    <div class="login-register">
                    </div>
                </form>
            </div>
        </div>

              <script>
                    $(document).ready(function(){
                        $("#name").change(function(){
                           var name = $("#name").val();
                           
                           
                           $.ajax({
                              type:'POST',
                              data:{yourname:name},
                              url:"checkName",
                              success:function(res){
                                  $("#errorMessage").html(res);
                              }
                           });
                        });
                    });
                    </script>
                    
                
                
                
<!--Existing E-mail Check-->                
      <script>
            $(document).ready(function(){
                $('#myEmail').change(function(){
                    //alert("visited");
                    var myEmail = $('#myEmail').val();
                    
                    $.ajax({
                        type:'POST',
                        data:{myEmail:myEmail},
                        url:'CheckEmailServlet',
                        success:function(result){
                            $('#emailResult').html(result);
                        }         
                    });
                });  
            });
        </script>   
                

        <!--Existing Username Check-->                
        <script>
            $(document).ready(function () {
                $('#myuser').change(function () {
                    var myuser = $('#myuser').val();

                    $.ajax({
                        type: 'POST',
                        data: {myuser: myuser},
                        url: 'checkUsername',
                        success: function (result) {
                            $('#result').html(result);
                        }
                    });
                });
            });
        </script>   


        <!--Password strength checker-->    
        <script type="text/javascript">
            function checkPasswordStrength() {
                var number = /([0-9])/;
                var alphabets = /([a-zA-Z])/;
                var special_characters = /([~,!,@,#,$,%,^,&,*,-,_,+,=,?,>,<])/;

                if ($('#password').val().length < 6) {
                    $('#password-strength-status').removeClass();
                    $('#password-strength-status').addClass('weak-password');
                    $('#password-strength-status').html("Weak (should be atleast 6 characters.)");
                } else {
                    if ($('#password').val().match(number) && $('#password').val().match(alphabets) && $('#password').val().match(special_characters)) {
                        $('#password-strength-status').removeClass();
                        $('#password-strength-status').addClass('strong-password');
                        $('#password-strength-status').html("Strong");
                    } else {
                        $('#password-strength-status').removeClass();
                        $('#password-strength-status').addClass('medium-password');
                        $('#password-strength-status').html("Medium (should include alphabets, numbers and special characters.)");
                    }
                }
            }
        </script>

    </body>

</html>
