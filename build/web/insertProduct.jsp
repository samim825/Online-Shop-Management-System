<%@ include file="header.jsp" %>
<h3  class=" col-sm-11 text-center">Add Your Product</h3><br></br>
<h3  class=" col-sm-11 text-center" style="color:DodgerBlue;">${msg}</h3><br></br>
</div>
<div>
    <form class="form-inline"  method="post" action="InsertProduct">
        <div class="col-md-offset-2">
            <input  class="form-control text-center"  value="Product Name" readonly>
            <input   class="form-control text-center" value="Quantity" readonly>
            <input class="form-control text-center" value="Product price" readonly>
        </div>
        <br/>

        <div id="inputDiv" class="col-md-offset-2">

            <input name="pName1" type="text"  placeholder="Enter product name" class="form-control productAvailable" onchange="onChangeFunction()" required>
            <input name="pQuantity1" type="number" class="form-control" step="any" placeholder="Enter Quantity" required>
            <input name="pPrice1" type="number" class="form-control" step="any" placeholder="Enter price per kg/piece" required>
            <label><input type="radio" name="optradio" checked>KG</label>
            <label><input type="radio" name="optradio">PCS</label>

            <br/><br/>
            <input id="count" name="count" type="hidden" value="1">
        </div>
        <div><h4 style="color: red; font-size: 20" id="result"></h4></div><br></br>
        <div  class='col-md-5 col-md-offset-3'>
            <button class="btn btn-info btn-block btn-md" type="button" id="add">Add More</button><br/>
            <input class="btn btn-success btn-block btn-md " type="submit" value ="Save Product">
        </div>
    </form>
</div>
<script>
    var count = 1;
    $(document).ready(function () {
        $("#add").click(function () {
            count = count + 1;
            $("#inputDiv").append('<input name="pName' + count + '" type="text"  class="form-control productAvailable" placeholder="Enter product name" onchange="onChangeFunction()"> ' +
                    '<input name="pQuantity' + count + '" type="number" step="any" class="form-control" placeholder="Enter Quantity"> ' +
                    '<input name="pPrice' + count + '" type="number" step="any" class="form-control" placeholder="Enter price">'+' <label><input type="radio" name="optradio' + count + '" checked>KG</label>'+
            '<label><input type="radio" name="optradio' + count + '">PCS</label><br/><br/>');

            $("#count").attr("value", count);
        });
    });
</script>


<!-- Check Product availability -->
<script>
    function onChangeFunction() {

        $('.productAvailable').focusout(function () {
            var productAvailable = $(this).val();
            $.ajax({
                type: 'POST',
                data: {productAvailable: productAvailable},
                url: 'productAvailability',
                success: function (result) {
                    $('#result').html(result);
                }
            });
        });
    }
</script>          
<%@ include file="footer.jsp" %>
