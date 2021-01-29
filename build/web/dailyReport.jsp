<%@ include file="header.jsp" %>


<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<div id="columnReportDiv"></div>

<script>

    $(document).ready(function () {
        columnReport();

        function columnReport() {
            var jan = <%= Integer.parseInt((String) request.getAttribute("1"))%>;
            var feb = <%= Integer.parseInt((String) request.getAttribute("2"))%>;
            var march = <%= Integer.parseInt((String) request.getAttribute("3"))%>;
            var april = <%= Integer.parseInt((String) request.getAttribute("4"))%>;
            var may = <%= Integer.parseInt((String) request.getAttribute("5"))%>;
            var jun = <%= Integer.parseInt((String) request.getAttribute("6"))%>;
            var july = <%= Integer.parseInt((String) request.getAttribute("7"))%>;
            var aug = <%= Integer.parseInt((String) request.getAttribute("8"))%>;
            var sep = <%= Integer.parseInt((String) request.getAttribute("9"))%>;
            var oct = <%= Integer.parseInt((String) request.getAttribute("10"))%>;
            var nov = <%= Integer.parseInt((String) request.getAttribute("11"))%>;
            var dec = <%= Integer.parseInt((String) request.getAttribute("12"))%>;

            var chart = Highcharts.chart('columnReportDiv', {
                title: {
                    text: 'Daily Report'
                },
                xAxis: {
                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
                },
                series: [{
                        type: 'column',
                        colorByPoint: true,
                        data: [jan, feb, march, april, may, jun, july, aug, sep, oct, nov, dec],
                        //data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
                        showInLegend: false
                    }]
            });
        }
    });

</script>


<%@ include file="footer.jsp" %>
