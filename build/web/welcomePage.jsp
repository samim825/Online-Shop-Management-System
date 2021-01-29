<%@page import="javaCode.ProductNotify"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <div class="col-sm-5 pull-left">
            </br></br></br></br>
            
            
            <ul>
                
                    <%             ArrayList<ProductNotify> pn = (ArrayList) request.getAttribute("productList");
                        Iterator it = pn.iterator();
                        while (it.hasNext()) {

                            ProductNotify productNotify = (ProductNotify) it.next();

                    %>      
                    
                    <li><h4 style="color:OrangeRed "><%=productNotify.getProductName()%> is consists only <%=productNotify.getProductQuantity()%> pc's/kg's .<%out.print("<a href='editProduct.jsp?username=" + productNotify.getUsername() + "&&productname=" + productNotify.getProductName() + "&&productQty="+productNotify.getProductQuantity()+"&&productPrice="+productNotify.getProductPrice()+"'>Please add this product.</a>");%></h4></li>
                        
                    
                    <%
                        }

                    %> 
                </ul>

        </div>
<h3 align="center">News section</h3>
        <div  class="col-sm-7" id='news' >
                <script>
                jQuery(document)
                        .ready(
                                function ($) {

                                    var url = 'https://newsapi.org/v2/everything?'
                                            + 'q=business&'
                                            + 'apiKey=7656601f3e794edb88b4fae5ec7ba553';
                                    var newsdata = "";
                                    $
                                            .ajax({
                                                url: url,
                                                dataType: 'json',
                                                success: function (data) {

                                                    //	for ( var k in data) {
                                                    data['articles']
                                                            .forEach(function (
                                                                    element, index) {
                                                                if (element['urlToImage'] != null) {
                                                                    newsdata += '<h3 class="title">'
                                                                            + element['title']
                                                                            + '</h3>';
                                                                    newsdata += '<h5>'
                                                                            + element['description']
                                                                            + '</h5>';
                                                                    newsdata += '<span class="td-post-date">'
                                                                            + element['publishedAt']
                                                                            + '</span>';
                                                                    newsdata += '<div class="fakeimg"><img src='
                                                                            + element['urlToImage']
                                                                            + ' width="75%" height="100%" alt="Not Loaded"></div>';
                                                                    newsdata += '<p>'
                                                                            + element['content']
                                                                            + '</p>';
                                                                    newsdata += '<a href=' + element['url'] + '>See More...</a><br><hr>';
                                                                }
                                                            });
                                                    //}
                                                    $('#news').html(newsdata);
                                                }
                                            });

                                });
            </script> 
        </div>

<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
<!--JavaScript code for top button-->
<script>
// When the user scrolls down 20px from the top of the document, show the button
    window.onscroll = function () {
        scrollFunction()
    };

    function scrollFunction() {
        if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
            document.getElementById("myBtn").style.display = "block";
        } else {
            document.getElementById("myBtn").style.display = "none";
        }
    }

// When the user clicks on the button, scroll to the top of the document
    function topFunction() {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    }
</script>

<%@ include file="footer.jsp" %>
