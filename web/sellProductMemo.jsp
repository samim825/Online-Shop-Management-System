<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javaCode.ProductMemo"%>
<%@ include file="header.jsp" %>
<h3  class=" col-sm-5 text-center">Sell Your Product</h3><br></br><br></br>
</div>

<div class="col-sm-6">
    <form class="form-inline"  method="post"  align = "center">
        <input class="form-control text-center"   value="Product Name" readonly>
        <input class="form-control text-center" value="Quantity" readonly><br></br>
        <div id="inputDiv" >
            <input name="pName1" type="text" class="form-control" placeholder="Enter product name" required>
            <input name="pQuantity1" type="number" step="any" class="form-control" placeholder="Enter Quantity" required>
            <br/><br/>
            <input id="count" name="count" type="hidden" value="1">
        </div>

        <div class="col-md-10 col-md-offset-1">
            <button  type="button" class="btn btn-primary btn-block" id="add">Add More</button><br/>
            <button id='show' type="button" class="btn btn-success btn-block btn-md" >Sell Product</button>
        </div>

    </form>
</div>

<div class="col-sm-6">
    <div id='table' >
        <table   class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Product name</th>
                    <th>price per kg/piece</th>
                    <th>Total quantity</th>
                    <th>Total price</th>
                </tr>
            </thead>
            <tbody>

                <%                    double totalAmmount = 0;
                    ArrayList<ProductMemo> addProductMemos = (ArrayList<ProductMemo>) request.getAttribute("memoProductList");
                    
                    request.setAttribute("addProductMemos", addProductMemos);
                    
                    Iterator it = addProductMemos.iterator();
                    while (it.hasNext()) {

                        ProductMemo productMemo = (ProductMemo) it.next();


                %> 

                <tr>
                    <td><%=productMemo.getProductName()%></td>
                    <td><%=productMemo.getProductPrice()%></td>
                    <td><%=productMemo.getTotalQuantity()%></td>
                    <td><%=productMemo.getTotalPrice()%></td>
                </tr>

                <%
                        totalAmmount = totalAmmount + productMemo.getTotalPrice();
                    }

                %>

                <tr>
                    <th colspan="3" class="text-center">Discount</th>

                    <td><input id="discount"  style="border:none; background:transparent;" type="number" step="any" value="0.0"></input></td>
                </tr>
                <tr>
                    <th colspan="3" class="text-center">Total Ammount</th>

                    <td><input id="totalAmmount" style="border:none; background:transparent;" type="number" step="any" value=<%=totalAmmount%> readonly></input></td>
                </tr>
            </tbody>
        </table>
        <div class="btn-toolbar">
            <a href="SellButtonServlet" class="btn btn-sm btn-info pull-right col-sm-2">Sell</a>
            <button class="btn btn-sm btn-success pull-right col-sm-2" type="submit">Print</button>  
        </div>
    </div>

</div>


              
<script>
    $(document).ready(function () {
        $("#discount").change(function () {
            var discount = parseInt($('#discount').val());
            var totalAmount = $('#totalAmmount').val();
            var ammount = totalAmount - discount;
            $("#totalAmmount").val(ammount);
        });

    });



</script>


<!--JavaScript/jQuery code for add more button -->                 
<script>
    var count = 1;
    $(document).ready(function () {
        $("#add").click(function () {
            count = count + 1;
            $("#inputDiv").append('<input name="pName' + count + '" type="text" class="form-control" placeholder="Enter product name" required> ' +
                    '<input name="pQuantity' + count + '" type="number" class="form-control" step="any" placeholder="Enter Quantity" required> ' + '<br/><br/>');

            $("#count").attr("value", count);
        });
    });
</script>

<!--Table showing code-->
<script>

    $(document).ready(function () {
        $("#show").click(function () {
            $("#table").show();
        });
    });
    
 
    
</script>






<%@ include file="footer.jsp" %>




