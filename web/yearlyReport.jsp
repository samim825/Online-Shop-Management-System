<%@ include file="header.jsp" %>

<div class="col-lg-8">
    <div class="panel panel-default">
        <div class="panel-heading">
            Pie Chart Example
        </div>
        <!-- /.panel-heading -->
        <div class="panel-body">
            <div class="flot-chart" id="piechart"></div>
            <div id="columnChartDiv"></div>
            <div id="pieChartDiv" style="height: 600px; width: 500px;"></div>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <script src="https://code.highcharts.com/highcharts.js"></script>
            <script src="https://code.highcharts.com/modules/exporting.js"></script>

            <script type="text/javascript">
                // Load google charts
                google.charts.load('current', {'packages': ['corechart']});
                google.charts.setOnLoadCallback(drawChart);

                // Draw the chart and set the chart values
                function drawChart() {
                    var data = google.visualization.arrayToDataTable([
                        ['Task', 'Hours per Day'],
                        ['January', 3],
                        ['February', 3],
                        ['March', 3],
                        ['April', 2],
                        ['May', 2],
                        ['June', 2],
                        ['July', 2],
                        ['August', 1],
                        ['September', 1],
                        ['October', 1],
                        ['November', 1],
                        ['December', 2]


                    ]);

                    // Optional; add a title and set the width and height of the chart
                    var options = {'title': 'My Average Day', 'width': 650, 'height': 400};

                    // Display the chart inside the <div> element with id="piechart"
                    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                    chart.draw(data, options);
                }

                $(document).ready(function () {
                    drawColumnChart();
                    drawPieChart();
                    
                    function drawColumnChart() {
                        Highcharts.chart('columnChartDiv', {
                            chart: {
                                type: 'column'
                            },
                            title: {
                                text: 'Monthly Average Rainfall'
                            },
                            subtitle: {
                                text: 'Source: WorldClimate.com'
                            },
                            xAxis: {
                                categories: [
                                    'Jan',
                                    'Feb',
                                    'Mar',
                                    'Apr',
                                    'May',
                                    'Jun',
                                    'Jul',
                                    'Aug',
                                    'Sep',
                                    'Oct',
                                    'Nov',
                                    'Dec'
                                ],
                                crosshair: true
                            },
                            yAxis: {
                                min: 0,
                                title: {
                                    text: 'Rainfall (mm)'
                                }
                            },
                            tooltip: {
                                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                        '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                                footerFormat: '</table>',
                                shared: true,
                                useHTML: true
                            },
                            plotOptions: {
                                column: {
                                    pointPadding: 0.2,
                                    borderWidth: 0
                                }
                            },
                            series: [{
                                    name: 'Tokyo',
                                    data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]

                                }, {
                                    name: 'New York',
                                    data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]

                                }, {
                                    name: 'London',
                                    data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]

                                }, {
                                    name: 'Berlin',
                                    data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]

                                }]
                        });

                    }

                    function drawPieChart() {
                        Highcharts.chart('pieChartDiv', {
                            chart: {
                                plotBackgroundColor: null,
                                plotBorderWidth: null,
                                plotShadow: false,
                                type: 'pie'
                            },
                            title: {
                                text: 'Browser market shares in January, 2018'
                            },
                            tooltip: {
                                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: true,
                                        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                                    }
                                }
                            },
                            series: [{
                                    name: 'Brands',
                                    colorByPoint: true,
                                    data: [{
                                            name: 'Chrome',
                                            y: 61.41,
                                            sliced: true,
                                            selected: true
                                        }, {
                                            name: 'Internet Explorer',
                                            y: 11.84
                                        }, {
                                            name: 'Firefox',
                                            y: 10.85
                                        }, {
                                            name: 'Edge',
                                            y: 4.67
                                        }, {
                                            name: 'Safari',
                                            y: 4.18
                                        }, {
                                            name: 'Sogou Explorer',
                                            y: 1.64
                                        }, {
                                            name: 'Opera',
                                            y: 1.6
                                        }, {
                                            name: 'QQ',
                                            y: 1.2
                                        }, {
                                            name: 'Other',
                                            y: 2.61
                                        }]
                                }]
                        });

                    }
                });

            </script>                


        </div>
    </div>
    <!-- /.panel-body -->
</div>
<!-- /.panel -->
</div>



<%@ include file="footer.jsp" %>