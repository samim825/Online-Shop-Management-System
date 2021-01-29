<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javaCode.ProductRetrieve"%>
<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3 style="text-align: center">Stock</h3>
<h3 style="text-align: center; color:DodgerBlue;" style="color:DodgerBlue;">${updateMsg}</h3>

<table id='table' class="table table-hover table-bordered">
    <thead>
        <tr>
            <th> Product_Name </th>
            <th> Product_Quantity </th>
            <th>Product_Price </th>
            <th style="text-align: center">Edit</th>
            <th style="text-align: center">Delete</th>
        </tr>
    </thead>
    <tbody>

        <%            ArrayList<ProductRetrieve> product = (ArrayList) request.getAttribute("productList");
            //Iterator it = product.iterator();
            //while (it.hasNext())
            int i = 0;
            for (ProductRetrieve productRetrieve : product) {

                i++;
                // ProductRetrieve productRetrieve = (ProductRetrieve) it.next();

        %>    
        <tr>
            <td id="pName"><%=productRetrieve.getProductName()%></td>
            <td id="pQuantity"><%=productRetrieve.getProductQuantity()%></td>
            <td id="pPrice"><%=productRetrieve.getProductPrice()%> Tk</td>
            <!--<td style="text-align: center"><button type='button' class='btn btn-info btn-md' data-toggle='modal' data-target='#myModal<%=i%>'id="edit" >Edit</button></td>-->
            <td style="text-align: center"><%out.print("<a href='editProduct.jsp?username=" + productRetrieve.getUsername() + "&&productname=" + productRetrieve.getProductName() + "&&productQty=" + productRetrieve.getProductQuantity() + "&&productPrice=" + productRetrieve.getProductPrice() + "'> <button type='button' class='btn btn-info btn-md'>Update</button></a>");%></td>
            <td style="text-align: center"><%out.print("<a href='DeleteProduct?username=" + productRetrieve.getUsername() + "&&productname=" + productRetrieve.getProductName() + "'> <button type='button' class='btn btn-danger btn-md'>Delete</button></a>");%></td>

        </tr>

   
<!-- Modal -->

<div class="modal fade" id="myModal<%=i%>">
    
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Edit product's Quantity and Price</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>              
            </div>
            <div class="modal-body">
                <form action="EditProduct" method="GET" class="form-horizontal" role="form">
                    <div class="form-group">
                        <input id="username" name="username" type="hidden" value="${username}">
                        <label for="productQuantity">Product Name:</label>
                        <input id="productName" name="productName" type="text" class="form-control text-center" value="<%=productRetrieve.getProductName()%>" readonly>
                    </div>
                    <div>
                        <label for="productQuantity">Product Quantity:</label>
                        <input type="number" name="productQuantity" class="form-control" id="productQuantity" value="<%=productRetrieve.getProductQuantity()%>">
                    </div>
                    <div class="form-group">
                        <label for="productPrice">Product Price:</label>
                        <input type="number" name="productPrice" class="form-control" id="productPrice" value="<%=productRetrieve.getProductPrice()%>">
                    </div>
                    <button type="submit" class="btn btn-default" id="pEdit">Save</button>
                </form>
            </div>
           
        </div>
    </div>
                                      
</div>

<%
    }

%>

 </tbody>   
</table>
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


<script>
    $(document).ready(function () {

        $("#table").DataTable();

    });
</script>



<!--Edit product using ajax-->
<script>
    $(document).ready(function () {
        $('#pEdit').click(function () {
            var pName = document.getElementById("pName");
            var pQuantity = $('#pQuantity').val();
            var pPrice = $('#pPrice').val();

            $.ajax({
                type: 'POST',
                data: {pName: pName, pQuantity: pQuantity, pPrice: pPrice},
                url: 'EditProduct'
            });
        });
    });
</script>

<%@ include file="footer.jsp" %>