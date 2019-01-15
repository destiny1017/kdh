<%@page import="java.util.ArrayList"%>
<%@page import="bean.ProductDTO"%>
<%@page import="bean.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Product</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.png" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/themify/themify-icons.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/elegant-font/html-css/style.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body class="animsition">
	<%
		String kind = (String) request.getParameter("kind");
		ProductDAO pDAO = new ProductDAO();
		ArrayList<ProductDTO> list;
		if (kind.equals("all")) {
			list = pDAO.getInfoALL();
		} else {
			list = pDAO.getInfoCategory(kind);
		}
		ProductDTO pDTO = new ProductDTO();
	%>
	<!-- Header -->
 	<jsp:include page="includes/header.jsp" flush="false" /> 
	
	<input type="hidden" id="kind" value="<%=kind %>">
	<!-- Title Page -->
	<section class="bg-title-page p-t-50 p-b-40 flex-col-c-m"
		style="background-image: url(images/headimg2.jpg);">
		<h2 class="l-text2 t-center">For <%=kind %></h2>
		<p class="m-text13 t-center">New Arrivals <%=kind %> Collection 2018</p>
	</section>


	<!-- Content page -->
	<section class="bgwhite p-t-55 p-b-65">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-4 col-lg-3 p-b-50">
					<div class="leftbar p-r-20 p-r-0-sm">
						<!--  -->
						<h4 class="m-text14 p-b-7">Categories</h4>

						<ul class="p-b-54">
							
							<li class="p-t-4"><a href="product.jsp?kind=all" id="all" class="s-text13">	All </a></li>

							<li class="p-t-4"><a href="product.jsp?kind=women" id="women" class="s-text13"> Women </a></li>

							<li class="p-t-4"><a href="product.jsp?kind=men" id="men" class="s-text13"> Men </a></li>

							<li class="p-t-4"><a href="product.jsp?kind=kids" id="kids" class="s-text13"> Kids </a></li>
						</ul>
						<script>
							var kind = document.getElementById("kind");
							var categories = document.getElementsByClassName("s-text13");
							for (var i = 0; i < categories.length; i++) {
								if(categories[i].getAttribute("id")===kind.value){
									
								categories[i].setAttribute("class", "s-text13 active1");
								}else{
									
								categories[i].setAttribute("class", "s-text13");
								}
							}
						</script>
						<!--  -->
						

						


						
					</div>
				</div>

				<div class="col-sm-6 col-md-8 col-lg-9 p-b-50">
					<!--  -->
					<div class="flex-sb-m flex-w p-b-35">
						<div class="flex-w">
							<div class="search-product pos-relative bo4 of-hidden">
							<input class="s-text7 size6 p-l-23 p-r-50" type="text" 
								onkeypress="javascript:if(event.keyCode==13){search()}"
								name="search-product" placeholder="Search Products...">

							<button onclick="search()" class="flex-c-m size5 ab-r-m color2 color0-hov trans-0-4">
								<i class="fs-12 fa fa-search" aria-hidden="true"></i>
							</button>
						</div>

						</div>

					</div>

					<!-- Product -->
					<div class="row" id="Context">

						<%
							for (int i = 0; i < list.size(); i++) {
								if (i == 6) {
									break;
								}
						%>

						<div class="col-sm-12 col-md-6 col-lg-4 p-b-50">
							<!-- Block2 -->
							<div class="block2">
								<div
									class="block2-img wrap-pic-w of-hidden pos-relative block2-labelnew">
									<a href="product-detail.jsp?pId=<%=list.get(i).getPId()%>">
										<img src="images/clothes/<%=list.get(i).getPId()%>_1.jpg"
										alt="<%=list.get(i).getName()%>">
									</a>
									<div class="block2-overlay trans-0-4">
										<a href="#"
											class="block2-btn-addwishlist hov-pointer trans-0-4"> <i
											class="icon-wishlist icon_heart_alt" aria-hidden="true"></i>
											<i class="icon-wishlist icon_heart dis-none"
											aria-hidden="true"></i>
										</a>

										<div class="block2-btn-addcart w-size1 trans-0-4">
											<!-- Button -->
											<!-- 											<button class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4"> -->
											<!-- 												Add to Cart -->
											<!-- 											</button> -->
										</div>
									</div>
								</div>

								<div class="block2-txt p-t-20">
									<a href="product-detail.jsp?pId=<%=list.get(i).getPId()%>"
										class="block2-name dis-block s-text3 p-b-5"> <%=list.get(i).getName()%>
									</a> <span class="block2-price m-text6 p-r-5"> <%=list.get(i).getPrice()%>원
									</span>
								</div>
							</div>
						</div>
						<%
							}
						%>


					</div>
					<script type="text/javascript">
						function page(x) {
							
							var page = document.getElementsByClassName("item-pagination");
							var search = document.getElementById("search");
							if(search==null){
							$.ajax({
						        type : "GET",
						        url : "test.jsp?num="+x+"&kind="+"<%=kind%>",
						        dataType : "text",
						        error : function() {
						          alert('통신실패!!');
						        },
						        success : function(data) {
						          $('#Context').html(data);
						        }
						 
						      });
							}else{
							var search2 = document.getElementsByClassName("s-text7");
							$.ajax({
						        type : "GET",
						        url : "search.jsp?search="+search2[0].value+"&num="+x,
						        dataType : "text",
						        error : function() {
						          alert('통신실패!!');
						        },
						        success : function(data) {
						          $('#Context').html(data);
						        }
						 
						      });
							}
						     for (var i = 0; i < page.length; i++) {
							    	 page[i].setAttribute("class", "item-pagination flex-c-m trans-0-4")
								}
							page[x-1].setAttribute("class", "item-pagination flex-c-m trans-0-4 active-pagination")
							
							}
						
						
						
						function search() {
							var search = document.getElementsByClassName("s-text7");
							$.ajax({
						        type : "GET",
						        url : "search.jsp?search="+search[0].value+"&num=1",
						        dataType : "text",
						        error : function() {
						          alert('통신실패!!');
						        },
						        success : function(data) {
						          $('#Context').html(data);
						        }
						 
						      });
						}
			
					</script>

					<!-- Pagination -->
					<div class="pagination flex-m flex-w p-t-26">
						<a href="#" onclick="page(<%=1%>)" id="page(<%=1%>)"
							class="item-pagination flex-c-m trans-0-4 active-pagination">1</a>
						<%
							if (list.size() > 6) {
								int count = 1;
								for (int i = 6; i < list.size(); i++) {
									if (i % 6 == 0) {
										count++;
						%>
						<a href="#" onclick="page(<%=count%>)" id="page(<%=count%>)"
							class="item-pagination flex-c-m trans-0-4"><%=count%></a>
						<%
							}
								}
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">




	</script>

	<!-- Footer -->
	<jsp:include page="includes/footer.jsp" flush="false" />


	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top"> <i
			class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>



	<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript"
		src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/bootstrap/js/popper.js"></script>
	<script type="text/javascript"
		src="vendor/bootstrap/js/bootstrap.min.js"></script>
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
		
// 		$(window).bind("beforeunload", function (e){
// 			return "창을 닫으실래요?";
// 		});

		
	</script>
	<!--===============================================================================================-->
	<script type="text/javascript"
		src="vendor/daterangepicker/moment.min.js"></script>
	<script type="text/javascript"
		src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/slick/slick.min.js"></script>
	<script type="text/javascript" src="js/slick-custom.js"></script>
	<!--===============================================================================================-->
	<script type="text/javascript"
		src="vendor/sweetalert/sweetalert.min.js"></script>
	<script type="text/javascript">
		$('.block2-btn-addcart').each(function(){
			var nameProduct = $(this).parent().parent().parent().find('.block2-name').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to cart !", "success");
			});
		});

		$('.block2-btn-addwishlist').each(function(){
			var nameProduct = $(this).parent().parent().parent().find('.block2-name').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to wishlist !", "success");
			});
		});
		
		
	</script>

	<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/noui/nouislider.min.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>
