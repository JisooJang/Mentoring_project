<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="charset=UTF-8">
<title>Google Chart - Servlet 3</title>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
%>
</head>
<body>
	<div style="width: 600px;">
		<div id="chart_div"></div>
	</div>

	<script type="text/javascript">
    // Load the Visualization API and the piechart package.
   google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
 
    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {
 
        // Create the data table.
         var data = google.visualization.arrayToDataTable([
                                                              ['Country', 'Area(square km)'],
                                                              <c:forEach items="${pieDataList}" var="entry">
                                                                  [ '${entry.key}', ${entry.value} ],
                                                              </c:forEach>
                                                        ]);
 
              
        // Set chart options
        var options = {
            'title' : 'Senior Mentoring Matching Team', //title which will be shown right above the Google Pie Chart
            titleTextStyle : {
            	fontSize : 30
            },
            is3D : true, //render Google Pie Chart as 3D
            pieSliceText: 'label', //on mouse hover show label or name of the Country
            tooltip :  {showColorCode: true}, // whether to display color code for a Country on mouse hover
            'width' : 1300, //width of the Google Pie Chart
            'height' : 800 //height of the Google Pie Chart
        };
 
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }
    
</script>
</body>
</html>