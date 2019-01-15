<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@page import="bean.ProductDTO"%>
<%@page import="bean.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
	<title>Product Detail</title>
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
	<%
		String pId = request.getParameter("pId");
		ArrayList<String> recommend = (ArrayList<String>)session.getAttribute("recommend");
		if(recommend ==null){
			recommend = new ArrayList<String>();
			recommend.add(pId);
			session.setAttribute("recommend", recommend);
		}else{
			recommend.add(pId);
			session.setAttribute("recommend", recommend);			
		}		
		ProductDAO pDAO = new ProductDAO();
		ProductDTO pDTO = pDAO.getInfo(pId);
		ArrayList<ProductDTO> kindList =pDAO.getInfoCategory(pDTO.getCategory());
		
		File file = new File("C:\\Users\\user\\git\\shopping\\Shop5\\WebContent\\images\\clothes");
		String[] list = file.list();
		ArrayList<String> list2 = new ArrayList<>();
		for(int i = 0; i<list.length; i++){
			String name = list[i].substring(0, list[i].toString().indexOf("_"));
			if(pId.equals(name)){
			list2.add(list[i].toString());
			}
		}
	%>
	<input type="hidden" id="Context" value="hi">
	<input type='hidden' id="sizeS" value="<%= pDTO.getSizeS()%>">
	<input type='hidden' id="sizeM" value="<%= pDTO.getSizeM()%>">
	<input type='hidden' id="sizeL" value="<%= pDTO.getSizeL()%>">
	<input type='hidden' id="sizeXL" value="<%= pDTO.getSizeXL()%>">
	<input type='hidden' id="pId" value="<%= pId%>">
	<!-- Header -->
	<jsp:include page="includes/header.jsp" flush="false"/>
	
	<!-- breadcrumb -->
	<div class="bread-crumb bgwhite flex-w p-l-52 p-r-15 p-t-30 p-l-15-sm">
		<a href="index.jsp" class="s-text16">
			Home
			<i class="fa fa-angle-right m-l-8 m-r-9" aria-hidden="true"></i>
		</a>

		<a href="product.jsp?kind=<%=pDTO.getCategory() %>" class="s-text16">
			<%=pDTO.getCategory() %>
			<i class="fa fa-angle-right m-l-8 m-r-9" aria-hidden="true"></i>
		</a>

<!-- 		<a href="#" class="s-text16"> -->
<!-- 			T-Shirt -->
<!-- 			<i class="fa fa-angle-right m-l-8 m-r-9" aria-hidden="true"></i> -->
<!-- 		</a> -->

		<span class="s-text17">
			<%= pDTO.getName() %>
		</span>
	</div>

	<!-- Product Detail -->
	<div class="container bgwhite p-t-35 p-b-80">
		<div class="flex-w flex-sb">
			<div class="w-size13 p-t-30 respon5">
				<div class="wrap-slick3 flex-sb flex-w">
					<div class="wrap-slick3-dots"></div>

					<div class="slick3">
					<%for(int i = 0; i<list2.size(); i++){ %>
						<div class="item-slick3" data-thumb="images/clothes/<%=list2.get(i) %>">
							<div class="wrap-pic-w">
								<img src="images/clothes/<%=list2.get(i) %>" alt="IMG-PRODUCT">
							</div>
						</div>
					<%} %>
					</div>
				</div>
			</div>

			<div class="w-size14 p-t-30 respon5">
				<h4 class="product-detail-name m-text16 p-b-13">
					<%= pDTO.getName() %>
				</h4>

				<span class="m-text17">
					<%= pDTO.getPrice() %>원
				</span>

				<p class="s-text8 p-t-10">
					<%= pDTO.getExplanation() %>
				</p>

				<!--  -->
				<div class="p-t-33 p-b-60">
					<div class="flex-m flex-w p-b-10">
						<div class="s-text15 w-size15 t-center">
							Size
						</div>
						
						<div class="rs2-select2 rs3-select2 bo4 of-hidden w-size16">
							<select class="selection-2" name="size" onclick="check2()">
<!-- 								<option>Choose an option</option> -->
								<% if(!pDTO.getSizeS().equals("0")){%>
								<option value="sizeS" >Size S</option>
								<%}%>
								<% if(!pDTO.getSizeM().equals("0")){%>
								<option value="sizeM">Size M</option>
								<%}%>
								<% if(!pDTO.getSizeL().equals("0")){%>
								<option value="sizeL">Size L</option>
								<%}%>
								<% if(!pDTO.getSizeXL().equals("0")){%>
								<option value="sizeXL">Size XL</option>
								<%}%>
							</select>
						</div>
					</div>

					<div class="flex-m flex-w">
<!-- 						<div class="s-text15 w-size15 t-center"> -->
<!-- 							Color -->
<!-- 						</div> -->

<!-- 						<div class="rs2-select2 rs3-select2 bo4 of-hidden w-size16"> -->
<!-- 							<select class="selection-2" name="color"> -->
<!-- <!-- 								<option>Choose an option</option> --> 
<!-- 								<option>Gray</option> -->
<!-- 								<option>Red</option> -->
<!-- 								<option>Black</option> -->
<!-- 								<option>Blue</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
					</div>

					<div class="flex-r-m flex-w p-t-10">
						<div class="w-size16 flex-m flex-w">
							<div class="flex-w bo5 of-hidden m-r-22 m-t-10 m-b-10">
							<script type="text/javascript">
							
							
							function plusbt() {
								var plusbt = document.getElementById("plusbt");
								var number = document.getElementsByName("num-product");
// 								number[0].value;
								var size = document.getElementsByName("size");
								
								if(size[0].value==="sizeS"){
									var sizeS = document.getElementById("sizeS");
									if(number[0].value+1>=sizeS.value){
										plusbt.disabled="disabled";
										number[0].value= number[0].value-1;
									}
								}else if(size[0].value==="sizeM"){
									
									var sizeM = document.getElementById("sizeM");
									if(number[0].value+1>=sizeM.value){
										plusbt.disabled="disabled";
										number[0].value= number[0].value-1;
									}
								}else if(size[0].value==="sizeL"){
									var sizeL = document.getElementById("sizeL");
									if(number[0].value+1>=sizeL.value){
										plusbt.disabled="disabled";
										number[0].value= number[0].value-1;
									}
								}else if(size[0].value==="sizeXL"){
									var sizeXL = document.getElementById("sizeXL");
									if(number[0].value+1>=sizeXL.value){
										plusbt.disabled="disabled";
										number[0].value= number[0].value-1;
									}
								}
								
							}
							
							function minusbt(){
								var plusbt = document.getElementById("plusbt");
								plusbt.removeAttribute("disabled");
								
							}
							
							function addCart() {
								var number = document.getElementsByName("num-product");
								var pId = document.getElementById("pId");
								var size = document.getElementsByName("size");
								
								
// 							location.href = "addCart.jsp?pId="+pId.value+"&count="+number[0].value;
							
							$.ajax({
						        type : "GET",
						        url : "addCart.jsp?pId="+pId.value+"&count="+number[0].value+"&size="+size[0].value,
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
							
								<button onclick="minusbt()" class="btn-num-product-down color1 flex-c-m size7 bg8 eff2" id="minusbt">
									<i class="fs-12 fa fa-minus" aria-hidden="true"></i>
								</button>

								<input class="size8 m-text18 t-center num-product" type="number" name="num-product" value="1">

								<button onclick="plusbt()" class="btn-num-product-up color1 flex-c-m size7 bg8 eff2" id="plusbt">
									<i class="fs-12 fa fa-plus" aria-hidden="true"></i>
								</button>
							</div>

							<div class="btn-addcart-product-detail size9 trans-0-4 m-t-10 m-b-10">
								<!-- Button -->
								<button onclick="addCart()" class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
									Add to Cart
								</button>
							</div>
						</div>
					</div>
				</div>

				<div class="p-b-45">
					<span class="s-text8 m-r-35">SKU: MUG-01</span>
					<span class="s-text8">Categories: Mug, Design</span>
				</div>

				<!--  -->
				<div class="wrap-dropdown-content bo6 p-t-15 p-b-14 active-dropdown-content">
					<h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text19 color0-hov trans-0-4">
						Description
						<i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
						<i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
					</h5>

					<div class="dropdown-content dis-none p-t-15 p-b-23">
						<p class="s-text8">
							Fusce ornare mi vel risus porttitor dignissim. Nunc eget risus at ipsum blandit ornare vel sed velit. Proin gravida arcu nisl, a dignissim mauris placerat
						</p>
					</div>
				</div>

				<div class="wrap-dropdown-content bo7 p-t-15 p-b-14">
					<h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text19 color0-hov trans-0-4">
						Additional information
						<i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
						<i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
					</h5>

					<div class="dropdown-content dis-none p-t-15 p-b-23">
						<p class="s-text8">
							Fusce ornare mi vel risus porttitor dignissim. Nunc eget risus at ipsum blandit ornare vel sed velit. Proin gravida arcu nisl, a dignissim mauris placerat
						</p>
					</div>
				</div>

				<div class="wrap-dropdown-content bo7 p-t-15 p-b-14">
					<h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text19 color0-hov trans-0-4">
						Reviews (0)
						<i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
						<i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
					</h5>

					<div class="dropdown-content dis-none p-t-15 p-b-23">
						<p class="s-text8">
							Fusce ornare mi vel risus porttitor dignissim. Nunc eget risus at ipsum blandit ornare vel sed velit. Proin gravida arcu nisl, a dignissim mauris placerat
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div align="center">
		<img src="images/explain/<%=pId %>.jpg">
	</div>

	<!-- Relate Product -->
	<section class="relateproduct bgwhite p-t-45 p-b-138">
		<div class="container">
			<div class="sec-title p-b-60">
				<h3 class="m-text5 t-center">
					Related Products
				</h3>
			</div>

			<!-- Slide2 -->
			<div class="wrap-slick2">
				<div class="slick2">
				<%for(int i =0; i<kindList.size(); i++){
					pDTO = kindList.get(i);
					if(pDTO.getPId().equals(pId)){
						continue;
					}
					%>
					<div class="item-slick2 p-l-15 p-r-15">
						<!-- Block2 -->
						<div class="block2">
							<div class="block2-img wrap-pic-w of-hidden pos-relative block2-labelnew">
								<img src="images/clothes/<%=pDTO.getPId() %>_1.jpg" alt="IMG-PRODUCT">

								<div class="block2-overlay trans-0-4">
									<a href="#" class="block2-btn-addwishlist hov-pointer trans-0-4">
										<i class="icon-wishlist icon_heart_alt" aria-hidden="true"></i>
										<i class="icon-wishlist icon_heart dis-none" aria-hidden="true"></i>
									</a>

									<div class="block2-btn-addcart w-size1 trans-0-4">
										<!-- Button -->
										<button class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4">
											Add to Cart
										</button>
									</div>
								</div>
							</div>

							<div class="block2-txt p-t-20">
								<a href="product-detail.jsp?pId=<%=pDTO.getPId() %>" class="block2-name dis-block s-text3 p-b-5">
									<%=pDTO.getName() %>
								</a>

								<span class="block2-price m-text6 p-r-5">
									<%=pDTO.getPrice() %>원
								</span>
							</div>
						</div>
					</div>
				<%} %>

				</div>
			</div>

		</div>
	</section>


	<!-- Footer -->
	<jsp:include page="includes/footer.jsp" flush="false" />


	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>


	<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
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
	<script type="text/javascript" src="vendor/slick/slick.min.js"></script>
	<script type="text/javascript" src="js/slick-custom.js"></script>
<!--===============================================================================================-->
	<script type="text/javascript" src="vendor/sweetalert/sweetalert.min.js"></script>
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

		$('.btn-addcart-product-detail').each(function(){
			var nameProduct = $('.product-detail-name').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to cart !", "success");
			});
		});
		
		
		
	</script>

<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>
