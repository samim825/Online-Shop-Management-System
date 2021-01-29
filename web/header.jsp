<% if ((session.getAttribute("username") == null) || session.getAttribute("username") == " ") {

%>
you are not logged in.This is restricted page. </br>
So, Please <a href="index.jsp">Login</a>
<%} else {
%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>welcome</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <link href="BootstrapAdmin/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
        <link href="BootstrapAdmin/css/plugins/timeline/timeline.css" rel="stylesheet">
        <link href="BootstrapAdmin/css/bootstrap.min.css" rel="stylesheet">
        <link href="BootstrapAdmin/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="BootstrapAdmin/css/sb-admin.css" rel="stylesheet">



        <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <link type="text/css" rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />


        <style>

            .td-post-date {
                color: #aaa;
                display: inline-block;
                position: relative;
                top: 2px;
            }
            .title {
                font-weight: 700 ;
                color: #1f4363 !important;
                font-size: 25px;
                line-height: 33px;
                text-decoration: none;
            }
            .fakeimg {
                height: 200px;
                background: none;
                width: 100%;
            }

            #myBtn {
                display: none;
                position: fixed;
                bottom: 20px;
                right: 30px;
                z-index: 99;
                font-size: 18px;
                border: none;
                outline: none;
                background-color: red;
                color: white;
                cursor: pointer;
                padding: 15px;
                border-radius: 4px;
            }

            #myBtn:hover {
                background-color: #555;
            }



        </style>

    </head>

    <body style="overflow-x:hidden">

        <div id="wrapper">

          

            <div class="navbar-fixed-top">
                <nav class="navbar navbar-default navbar-static-top "  role="navigation" style="margin-bottom: 0;">
                    <div class="col-md-5 col-md-offset-4" class="navbar-header">
                        <h3 class="text-center"><a href="ProductNotifications"> ${spName}</a></h3>
                        <h5 class="text-center">${address}</h5>
                    </div>

                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                            </a>
                        </li>


                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="userProfile.jsp"><i class="fa fa-user fa-fw"></i> User Profile</a>
                                </li>
                                <li><a href="logoutServlet"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                </li>
                            </ul>
                            <!-- /.dropdown-user -->
                        </li>
                    </ul>

                </nav>
            </div>
            <div>
                <br><br><br><br>
                <nav class="navbar-default navbar-static-side" role="navigation">
                    <div style="position:fixed;" class="sidebar-collapse">
                        <ul class="nav" id="side-menu">

                            <li>
                                <a href="ProductNotifications"><i class="fa fa-dashboard fa-fw"></i> Dashboard </a>
                            </li>
                            <li>
                                <a href="sellProduct.jsp"><i class="fa fa-shopping-cart">  Sell Product</i></a>
                                <!--<a href="#"><i class="fa fa-shopping-cart">  Sell Product</i></a>-->
                            </li>
                            <li>
                                <a href="insertProduct.jsp"><i class="fa fa-plus-square-o">  Add Product</i></a>
                            </li>
                            <li>
                                <a href="StockServlet"><i class="fa fa-edit fa-fw"></i> Stock</a>
                            </li>
                            <li>
                                <a href="cost.jsp"><i class="fa fa-minus-circle fa-fw"></i> Cost</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-files-o fa-fw"></i> Report<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="DailyReportServlet">Daily Report</a> 
                                        <!--<a href="#">Daily Report</a>-->
                                    </li>
                                    <li>
                                        <a href="#">Monthly Report</a>
                                    </li>
                                    <li>
                                        <a href="yearlyReport.jsp">Yearly Report</a> 
                                         <!--<a href="#">Yearly Report</a>-->
                                    </li>

                                </ul>

                            </li>
                        </ul>
                    </div>
                </nav>

            </div>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">

