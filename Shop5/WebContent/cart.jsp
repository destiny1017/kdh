<!DOCTYPE html>
<%@page import="bean.ProductDTO"%>
<%@page import="bean.AddCartDTO"%>
<%@page import="bean.ProductDAO"%>
<%@page import="bean.AddCartDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<title>Cart</title>
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
		String uId = "root";
		AddCartDAO cartDao = new AddCartDAO();
		
		ProductDAO pDao = new ProductDAO();
		ArrayList<String> recommend = (ArrayList<String>) session.getAttribute("recommend");
		if(recommend!=null){
						
			pDao.insertHit(recommend);
			session.removeAttribute("recommend");
		}
		
		ArrayList<AddCartDTO> list2 = (ArrayList) session.getAttribute("list");
		if (list2 != null) {
			for (int i = 0; i < list2.size(); i++) {
				String pId = list2.get(i).getpId();
				String size = list2.get(i).getSize();
				String count2 = list2.get(i).getCount();
				cartDao.insertInfo(uId, pId, size, count2);
			}
			session.removeAttribute("list");
		}

		ArrayList<AddCartDTO> list = cartDao.getInfo(uId);
		int count = 0;
		String test = (String) session.getAttribute("test");
	%>

	<!-- Header -->
	<jsp:include page="includes/header.jsp" flush="false" />

	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m"
		style="background-image: url(images/heading-pages-01.jpg);">
		<h2 class="l-text2 t-center">Cart</h2>
	</section>

	<!-- Cart -->
	<section class="cart bgwhite p-t-70 p-b-100">
		<div class="container">
			<!-- Cart item -->
			<div class="container-table-cart pos-relative">
				<div class="wrap-table-shopping-cart bgwhite">
					<table class="table-shopping-cart">
						<tr class="table-head">
							<th class="column-1"></th>
							<th class="column-2">Product</th>
							<th class="column-3">Price</th>
							<th class="column-4 p-l-30">Quantity</th>
							<th class="column-5">Total</th>
						</tr>
						<script type="text/javascript">
                    	 
                     function plsBtn(x){ //클릭한 버튼의 인덱스를 받아옴
                    	 
                    	 //해당하는 상품의 가격과 수량을 대입
                    	 var price = parseInt(document.getElementById("price" + x).innerHTML)
                    	 var quantity = parseInt(document.getElementById("quantity" + x).value) + 1
                	 	 
                    	 //토탈란에 연산하여 대입
                    	 document.getElementById("total" + x).innerHTML = (price * quantity) + "원"  
                    	 
                    	 //총 합 계산
                    	 var subtotal = document.getElementById("subtotal");
                     	 var allquantity = document.getElementsByName("num-product1");
                     	 var allprice = document.getElementsByName("price");
                     	 var sum = 0;
                     	 
                     	 for (var i = 0; i < allprice.length; i++) {
            	 
							sum += allquantity[i].value*allprice[i].value
                     		 
						}
                     	 sum += price;
                     	 subtotal.innerHTML = sum+"원";
                     	 
                     }
                     
                     function mnsBtn(x){
                  	                  	 
                    	 var price = parseInt(document.getElementById("price" + x).innerHTML)
                    	 var quantity = parseInt(document.getElementById("quantity" + x).value) - 1
                    	 
                    	 //1이하로는 수량이 안내려 가도록 조건 설정
                    	 if(quantity > 0){ 
	                    	 document.getElementById("total" + x).innerHTML = (price * quantity) + "원"                  		 
                    	
	                   	//총 합 계산
                    	 var subtotal = document.getElementById("subtotal");
                     	 var allquantity = document.getElementsByName("num-product1");
                     	 var allprice = document.getElementsByName("price");
                     	 var sum = 0;
                     	 
                     	 for (var i = 0; i < allprice.length; i++) {
            	 
							sum += allquantity[i].value*allprice[i].value
                     		 
						}
                     	 sum -= price;
                     	 subtotal.innerHTML = sum+"원";
                    	 }

                     }

                     function deleteAddCart(x) {                   	 
                    	 
                    	 	var uid = document.getElementById("uid");
                    	 	var pid = document.getElementById("pid"+x);
                    	 	var size = document.getElementById("size"+x);
							var tr = document.getElementById("tr"+x);
							tr.innerHTML="";
		

						
						$.ajax({
					        type : "GET",
					        url : "deleteAddcart.jsp?pid="+pid.value+"&size="+size.value+"&uid="+uid.value,
					        dataType : "text",
					        error : function() {
					          alert('통신실패!!');
					        },
					        success : function(data) {
					          $('#Context').html(data);
					        }
					 
					      });
						
						//총 합 계산
                   		 var subtotal = document.getElementById("subtotal");
                    	 var allquantity = document.getElementsByName("num-product1");
                    	 var allprice = document.getElementsByName("price");
                    	 var sum = 0;
                    	 
                    	 for (var i = 0; i < allprice.length; i++) {	
        
							sum += allquantity[i].value*allprice[i].value; 
						}
                    	 subtotal.innerHTML = sum+"원";
                   	 
                   	 	}
						
                     	function checkout() {
							
                     		$.ajax({
    					        type : "GET",
    					        url : "checkout.jsp",
    					        dataType : "text",
    					        error : function() {
    					          alert('통신실패!!');
    					        },
    					        success : function(data) {
    					          $('#Context').html(data);
    					        }
    					 
    					      });
                     		
                     		var tr = document.getElementsByClassName("table-row");
							for (var i = 0; i < tr.length; i++) {
								tr[i].innerHTML = "";
								
							}
						}
                  </script>
						<input type="hidden" id="uid" value ="<%=uId%>">
						<input type="hidden" class="block2-name" id="Context">
						<%
							if (list.size() != 0) {
								for (int i = 0; i < list.size(); i++) {
									ProductDTO pDto = pDao.getInfo(list.get(i).getpId());
						%>
						<tr class="table-row" id="tr<%=i%>">
						<input type="hidden" id="pid<%=i%>" value="<%=pDto.getPId()%>">
						<input type="hidden" id="size<%=i%>" value="<%=list.get(i).getSize()%>">
						<input type="hidden" name="price" value="<%=pDto.getPrice()%>">
							<td class="column-1">
								<div class="cart-img-product b-rad-4 o-f-hidden"
									onclick="deleteAddCart(<%=i%>)">
									<img src="images/clothes/<%=pDto.getPId()%>_1.jpg"
										alt="IMG-PRODUCT">
								</div>
							</td>
							<td class="column-2"><%=pDto.getName() + "(" + list.get(i).getSize() + ")"%></td>
							<td class="column-3" id="price<%=i%>"><%=pDto.getPrice()%>원</td>
							<%-- 가격 구분을 위해 id에 인덱스값 대입 --%>
							<td class="column-4">
								<div class="flex-w bo5 of-hidden w-size17">
									<button onclick="mnsBtn(<%=i%>)"
										<%-- 버튼이벤트로 전달할 매개변수 값을 버튼을 생성할 떄 미리 인덱스로 지정 --%>
                              class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
										<i class="fs-12 fa fa-minus" aria-hidden="true"></i>
									</button>

									<input class="size8 m-text18 t-center num-product"
										type="number" name="num-product1" id="quantity<%=i%>"
										<%-- 수량 구분을 위해 id에 인덱스값 대입 --%>
                              value="<%=list.get(i).getCount()%>">

									<button onclick="plsBtn(<%=i%>)"
										<%-- 버튼이벤트로 전달할 매개변수 값을 버튼을 생성할 떄 미리 인덱스로 지정 --%>
                          		class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
										<i class="fs-12 fa fa-plus" aria-hidden="true"></i>
									</button>
								</div>
							</td>
							<td class="column-5" id="total<%=i%>"><%=Integer.parseInt(pDto.getPrice()) * Integer.parseInt(list.get(i).getCount())%>원</td>
						</tr>
						<%
							}
							} else {
						%>
						<tr class="table-row" id="tr0">
							<%
								}
							%>
						
					</table>
				</div>
			</div>

			<div
				class="flex-w flex-sb-m p-t-25 p-b-25 bo8 p-l-35 p-r-60 p-lr-15-sm">
				<div class="flex-w flex-m w-full-sm">
				</div>

				<div class="size10 trans-0-4 m-t-10 m-b-10">
					<!-- Button -->
					<button
						class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
						Update Cart</button>
				</div>
			</div>

			<!-- Total -->
			<div
				class="bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm">
				<h5 class="m-text20 p-b-24">Cart Totals</h5>

				<!--  -->
				<div class="flex-w flex-sb-m p-b-12">
					<span class="s-text18 w-size19 w-full-sm"> Subtotal: </span> 
					<span class="m-text21 w-size20 w-full-sm" id="subtotal"> $39.00 </span>
				</div>
				<script>
				
					var subtotal = document.getElementById("subtotal");
	           		var allquantity = document.getElementsByName("num-product1");
	           	 	var allprice = document.getElementsByName("price");
	           	 	var sum = 0;
	           	 	for (var i = 0; i < allprice.length; i++) {
	  	 	
							sum += allquantity[i].value*allprice[i].value
	           			 
						}
	           	 	subtotal.innerHTML = sum+"원";
	           	 	
				</script>
				<!--  -->
				<div class="flex-w flex-sb bo10 p-t-15 p-b-20">
					<span class="s-text18 w-size19 w-full-sm"> Shipping: </span>

					<div class="w-size20 w-full-sm">
						<p class="s-text8 p-b-23">There are no shipping methods
							available. Please double check your address, or contact us if you
							need any help.</p>

					</div>
				</div>

				<!--  -->

				<div class="hi size15 trans-0-4">
					<!-- Button -->
					<button
						class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4" onclick="checkout()">
						Proceed to Checkout</button>
				</div>
			</div>
		</div>
	</section>



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
         minimumResultsForSearch : 20,
         dropdownParent : $('#dropDownSelect1')
      });

      $(".selection-2").select2({
         minimumResultsForSearch : 20,
         dropdownParent : $('#dropDownSelect2')
      });
   </script>
   <script type="text/javascript" src="vendor/sweetalert/sweetalert.min.js"></script>
	<script type="text/javascript">
		$('.hi').each(function(){
			var nameProduct = $(this).parent().parent().parent().find('.block2-name').html();
			$(this).on('click', function(){
				swal(nameProduct, "success checkout", "success");
			});
		});
	</script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>