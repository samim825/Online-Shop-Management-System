<%@ include file="header.jsp" %>

<div  class="col-md-5 col-md-offset-3">


    <div class="panel-title text-center">
        <h2 class="title">Profile</h2>
    </div>
    
        <form action="ProfileUpdate" method="post" class="form-horizontal">

            <div class="form-group">
                <a href="updateProfile.jsp"></a>
                <label for="name" class="cols-sm-2 control-label">Your Name</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="name" id="name"  value="${name}" required/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="email" class="cols-sm-2 control-label">Your Email</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                        <input type="email" class="form-control" name="email" id="email"  value=${email} required/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="ShopName" class="cols-sm-2 control-label">Shop Name</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-building-o" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="shopname"   value="${spName}" required/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="address" class="cols-sm-2 control-label">Address</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-building-o" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="address"  value="${address}" required/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="username" class="cols-sm-2 control-label">Username</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="username" id="username"  value=${username} readonly="readonly"/>
                    </div>
                </div>
            </div>
                    

            <div class="form-group ">
                <button type="submit" class="btn btn-lg btn-success btn-block">Save</button>
            </div>
                    
            <div class="login-register">
            </div>
        </form>
    
</div>

<%@ include file="footer.jsp" %>
