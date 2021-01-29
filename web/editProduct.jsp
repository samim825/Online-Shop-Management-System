<%@ include file="header.jsp" %>
<%    String username = request.getParameter("username");
    String productName = request.getParameter("productname");
    String productQty = request.getParameter("productQty");
    String productPrice = request.getParameter("productPrice");
%>

<h3  class=" col-sm-11 text-center">Update Your Product</h3>

</div>

<form class="form-inline"  method="post" action="EditProductServlet" align = "center">
    </br></br></br></br>
    <input  class="form-control text-center"  value="Product Name" readonly>
    <input   class="form-control text-center" value="Quantity" readonly>
    <input class="form-control text-center" value="Product price" readonly>
    <br/><br/>

    <div>
        <input type="hidden" name="username" value="<%=request.getParameter("username")%>">
        <input name="pName" type="text" class="form-control text-center"  value="<%=request.getParameter("productname")%>" readonly>
        <input name="pQuantity" type="number" class="form-control" step="any"value="<%=request.getParameter("productQty")%>" required>
        <input name="pPrice" type="number" class="form-control" step="any" value="<%=request.getParameter("productPrice")%>" required><br/><br/>               
    </div>
    <div  class='col-md-5 col-md-offset-3'>
        <input class="btn btn-success btn-block btn-md " type="submit" value ="Update Product">
        <div>
            </form>
            <%@ include file="footer.jsp" %>

