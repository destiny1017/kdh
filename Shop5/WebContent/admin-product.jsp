<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
<%@page import="db.ProductDTO"%>
<%@page import="db.ProductDAO"%>
<%@page import="db.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ProductDAO dao = new ProductDAO();
	ArrayList<ProductDTO> list = dao.getInfoALL();
	String[][] pages = new String[list.size()/8 + 1][8]; //페이징
	HashSet<String> categories = new HashSet<>();	
	for(int i = 0; i < list.size(); i++){
		categories.add(list.get(i).getCategory());
	}
	Iterator<String> iter = categories.iterator();
%>
<!DOCTYPE html>
<html>
<head>
	<title>Adminpage</title>
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
</head>
<body class="animsition">

	<!-- Header -->
	<jsp:include page="includes/header.jsp" flush="false" />
	
	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(images/heading-pages-06.jpg);">
		<h2 class="l-text2 t-center">
			AdminPage
		</h2>
	</section>
	
		<section class="bgwhite p-t-60">
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

							<li class="p-t-6 p-b-8 bo7"><a href="#"
								class="s-text13 p-t-5 p-b-5"> 게시판관리 </a></li>
						</ul>
					</div>
				</div>					
				<div style="background: white; width: 900px; height: auto;">
										
					<%for(int i = 0; i < categories.size(); i++){ 
						String category = iter.next();
						ArrayList<Integer> index = new ArrayList<>();
					%>
					
						<div class="wrap-dropdown-content bo6 p-t-15 p-b-14">	
							<h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text20 p-b-6 color0-hov trans-0-4">
								<%= category %>
								<i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
								<i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
							</h5>
							<div class="dropdown-content dis-none p-t-15 p-b-23">
								<p class="s-text8">
									<table class="table-shopping-cart table-hover">
										<tr class="table-head">
											<td>상품ID</td>
											<td>사진</td>
											<td>상품명</td>
											<td>가격</td>
										<tr>
										<% for(int j = 0; j < list.size(); j++) { 
											if(category.equals(list.get(j).getCategory())){
												index.add(j);
											} 
										}
										
										pages = new String[index.size()/8 + 1][8];
										
										for(int j = 0; j < index.size(); j++) { 
												
											%>
												<tr class="table-row" onclick="javascript:location.href='#'">
													<td><%= list.get(j).getPId() %></td>
													<td><img src="images/<%=list.get(j).getPId()%>_1.jpg" width="100"></td>
													<td><%= list.get(j).getName() %></td>
													<td><%= list.get(j).getPrice() %></td>
													
												<tr>
										<%} %>
									</table>
								<br>
								<button class="flex-c-m size2 bg4 bo-rad-23 hov1 m-text3 trans-0-4">상품 등록</button>
							</div>
						</div>
					<%} %>
								<br><button class="flex-c-m size2 bg4 bo-rad-23 hov1 m-text3 trans-0-4" style="width: 200px">카테고리 등록</button>
				</div>
				</div>
			</div>

		
	<br>
	<br>
	
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
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="js/map-custom.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>