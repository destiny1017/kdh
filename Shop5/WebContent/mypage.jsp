<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Mypage</title>
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
			Mypage
		</h2>
	</section>
	
		<section class="bgwhite p-t-60">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-lg-2 p-b-75">
					<div class="p-r-50 p-r-0-lg">

						<!-- Categories -->
						<h4 class="m-text23 p-t-20 p-b-14">Categories</h4>

						<ul>
							<li class="p-t-6 p-b-8 bo6"><a href="#"
								class="s-text13 p-t-5 p-b-5"> Fashion </a></li>

							<li class="p-t-6 p-b-8 bo7"><a href="#"
								class="s-text13 p-t-5 p-b-5"> Beauty </a></li>

							<li class="p-t-6 p-b-8 bo7"><a href="#"
								class="s-text13 p-t-5 p-b-5"> Street Style </a></li>

							<li class="p-t-6 p-b-8 bo7"><a href="#"
								class="s-text13 p-t-5 p-b-5"> Life Style </a></li>

							<li class="p-t-6 p-b-8 bo7"><a href="#"
								class="s-text13 p-t-5 p-b-5"> DIY & Crafts </a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4 col-lg-10 p-b-75">
					<h4 class="m-text23 p-t-20 p-b-14">Modify Info</h4>
					<hr>
					
					<h5>ID : </h5><div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden">
								<input class="s-text7 size4 p-l-200 p-r-200" type="text" name="search-product" >
						</div>					
					</div>
					<h5>PW : </h5><div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden">
								<input class="s-text7 size4 p-l-200 p-r-200" type="text" name="search-product" >
						</div>					
					</div>
					<h5>Name : </h5><div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden">
								<input class="s-text7 size4 p-l-200 p-r-200" type="text" name="search-product" >
						</div>					
					</div>
					<h5>Address : </h5><div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden">
								<input class="s-text7 size4 p-l-200 p-r-200" type="text" name="search-product" >
						</div>					
					</div>
					<h5> age : </h5><div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden">
								<input class="s-text7 size4 p-l-200 p-r-200" type="text" name="search-product">
						</div>					
					</div>
					
					
					
					

				</div>
			</div>
		</div>

		<section class="bgwhite p-t-60">
			<div class="col-md-4 col-lg-3 p-b-75">
					<div class="rightbar">
						</div>
					</div>


		</section>
		


		<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<hr>
	<br>
	<br>
	<br>
	<br>
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
	<script src="js/main.js"></script>

</body>
</html>