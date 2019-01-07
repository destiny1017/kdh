<!DOCTYPE html>
<%@page import="db.ProductDTO"%>
<%@page import="db.AddCartDTO"%>
<%@page import="db.ProductDAO"%>
<%@page import="db.AddCartDAO"%>
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
      ArrayList<AddCartDTO> list = cartDao.getInfo(uId);
      int count = 0;
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
                     }
                     
                     function mnsBtn(x){
                  	                  	 
                    	 var price = parseInt(document.getElementById("price" + x).innerHTML)
                    	 var quantity = parseInt(document.getElementById("quantity" + x).value) - 1
                    	 
                    	 //1이하로는 수량이 안내려 가도록 조건 설정
                    	 if(quantity > 0){ 
	                    	 document.getElementById("total" + x).innerHTML = (price * quantity) + "원"                  		 
                    	 }

                     }

                  </script>
                  <%
                     for (int i = 0; i < list.size(); i++) {
                        ProductDTO pDto = pDao.getInfo(list.get(i).getpId());
                  %>

                  <tr class="table-row">
                     <td class="column-1">
                        <div class="cart-img-product b-rad-4 o-f-hidden">
                           <img src="images/clothes/<%=pDto.getPId()%>_1.jpg"
                              alt="IMG-PRODUCT">
                        </div>
                     </td>
                     <td class="column-2"><%=pDto.getName() + "(" + list.get(i).getSize() + ")"%></td>
                     <td class="column-3" id="price<%=i%>"><%=pDto.getPrice()%>원</td> <%-- 가격 구분을 위해 id에 인덱스값 대입 --%>
                     <td class="column-4">
                        <div class="flex-w bo5 of-hidden w-size17">
                           <button
                              onclick="mnsBtn(<%=i%>)" <%-- 버튼이벤트로 전달할 매개변수 값을 버튼을 생성할 떄 미리 인덱스로 지정 --%>
                              class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
                              <i class="fs-12 fa fa-minus" aria-hidden="true"></i>
                           </button>

                           <input 
                              class="size8 m-text18 t-center num-product"
                              type="number" name="num-product1" id="quantity<%=i%>" <%-- 수량 구분을 위해 id에 인덱스값 대입 --%>
                              value="<%=list.get(i).getCount()%>">

                           <button 
                           		onclick="plsBtn(<%=i %>)" <%-- 버튼이벤트로 전달할 매개변수 값을 버튼을 생성할 떄 미리 인덱스로 지정 --%>
                          		class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
                              <i class="fs-12 fa fa-plus" aria-hidden="true"></i>
                           </button>
                        </div>
                     </td>
                     <td class="column-5" id="total<%=i%>"><%=Integer.parseInt(pDto.getPrice()) * Integer.parseInt(list.get(i).getCount())%>원</td>
                  </tr>
                  <%
                     }
                  %>
               </table>
            </div>
         </div>

         <div
            class="flex-w flex-sb-m p-t-25 p-b-25 bo8 p-l-35 p-r-60 p-lr-15-sm">
            <div class="flex-w flex-m w-full-sm">
               <div class="size11 bo4 m-r-10">
                  <input class="sizefull s-text7 p-l-22 p-r-22" type="text"
                     name="coupon-code" placeholder="Coupon Code">
               </div>

               <div class="size12 trans-0-4 m-t-10 m-b-10 m-r-10">
                  <!-- Button -->
                  <button
                     class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
                     Apply coupon</button>
               </div>
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
               <span class="s-text18 w-size19 w-full-sm"> Subtotal: </span> <span
                  class="m-text21 w-size20 w-full-sm"> $39.00 </span>
            </div>

            <!--  -->
            <div class="flex-w flex-sb bo10 p-t-15 p-b-20">
               <span class="s-text18 w-size19 w-full-sm"> Shipping: </span>

               <div class="w-size20 w-full-sm">
                  <p class="s-text8 p-b-23">There are no shipping methods
                     available. Please double check your address, or contact us if you
                     need any help.</p>

                  <span class="s-text19"> Calculate Shipping </span>

                  <div
                     class="rs2-select2 rs3-select2 rs4-select2 bo4 of-hidden w-size21 m-t-8 m-b-12">
                     <select class="selection-2" name="country">
                        <option>Select a country...</option>
                        <option>US</option>
                        <option>UK</option>
                        <option>Japan</option>
                     </select>
                  </div>

                  <div class="size13 bo4 m-b-12">
                     <input class="sizefull s-text7 p-l-15 p-r-15" type="text"
                        name="state" placeholder="State /  country">
                  </div>

                  <div class="size13 bo4 m-b-22">
                     <input class="sizefull s-text7 p-l-15 p-r-15" type="text"
                        name="postcode" placeholder="Postcode / Zip">
                  </div>

                  <div class="size14 trans-0-4 m-b-10">
                     <!-- Button -->
                     <button
                        class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
                        Update Totals</button>
                  </div>
               </div>
            </div>

            <!--  -->
            <div class="flex-w flex-sb-m p-t-26 p-b-30">
               <span class="m-text22 w-size19 w-full-sm"> Total: </span> <span
                  class="m-text21 w-size20 w-full-sm"> $39.00 </span>
            </div>

            <div class="size15 trans-0-4">
               <!-- Button -->
               <button
                  class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
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
   <!--===============================================================================================-->
   <script src="js/main.js"></script>

</body>
</html>