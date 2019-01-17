<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>About</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.png"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/themify/themify-icons.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/elegant-font/html-css/style.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
	<% 
		
		MemberDAO dao = new MemberDAO();
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		int[] gender = new int[2];
		int[] age = new int[5];
		MemberDTO dto = new MemberDTO();
		gender = dao.selectGender();
		age = dao.selectAge();

			
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

</head>
<body class="animsition">
	
	<!-- Header -->
	<jsp:include page="includes/header.jsp" flush="false"/>

	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(images/heading-pages-06.jpg);">
		<h2 class="l-text2 t-center">
			adminpage
		</h2>
	</section>
	
	<!-- content page -->
	<section class="bgwhite p-t-66 p-b-38">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-lg-3 p-b-75">
					<div class="p-r-90 p-r-0-lg">

						<!-- Categories -->
						<h4 class="m-text23 p-t-20 p-b-14">Categories</h4>

						<ul>
							<li class="p-t-6 p-b-8 bo6"><a href="admin-member.jsp"
								class="s-text13 p-t-5 p-b-5"> 회원관리 </a></li>

							<li class="p-t-6 p-b-8 bo7"><a href="admin-product.jsp"
								class="s-text13 p-t-5 p-b-5"> 상품관리 </a></li>

							<li class="p-t-6 p-b-8 bo7"><a href="admin-statistics.jsp"
								class="s-text13 p-t-5 p-b-5"> 통계 </a></li>
						</ul>
					</div>
				</div>				
			<div style="width: 900px; height: auto;">

			
			<div id="chart_div"></div>
			<hr>
			<div id="piechart" style="width: 900px; height: 500px;"></div>
			
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<jsp:include page="includes/footer.jsp" flush="false"/>

	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>



<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/bootstrap/js/popper.js"></script>
	<script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/select2/select2.min.js"></script>
	<script type="text/javascript">
		$(".selection-1").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
		
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect2')
		});
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>
