<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	
	MemberDAO dao = new MemberDAO();
	ArrayList<Integer> list = new ArrayList<>();
	ArrayList<String> list2 = new ArrayList<>();
	int[] gender = new int[2];
	int[] age = new int[5];
	MemberDTO dto = new MemberDTO();
	gender = dao.selectGender();
	age = dao.selectAge();
	
	System.out.println(gender[0]);
		
%>

 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['회원', '회원수'],
          ['남자',<%=gender[0]%>],
          ['여자',<%=gender[1]%>],
         
        ]);

        var options = {
          title: '성별 회원 (단위: 명)'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
<script src="//www.google.com/jsapi"></script>
<script>
var data = [
  ['회원수', '회원수'],
  ['10대', <%=age[0]%>],
  ['20대', <%=age[1]%>],
  ['30대', <%=age[2]%>],
  ['40대', <%=age[3]%>],
  ['50대', <%=age[4]%>],

];

var options = {
  title: '연령별 회원 (단위: 명)',
  width: 1000, height: 500
};

google.load('visualization', '1.0', {'packages':['corechart']});
google.setOnLoadCallback(function() {
  var chart = new google.visualization.ColumnChart(document.querySelector('#chart_div'));
  chart.draw(google.visualization.arrayToDataTable(data), options);

});
</script>
<div id="chart_div"></div>
<div id="piechart" style="width: 900px; height: 500px;"></div>
</body>
</html>