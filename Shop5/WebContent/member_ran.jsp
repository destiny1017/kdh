<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="bean.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
  table, th, td {
    border: 1px solid #bcbcbc;
  }
  table {
    width: 100%;
    height: 200px;
  }
</style>
<title>Mypage</title>
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

	<!-- Header -->
	<jsp:include page="includes/header.jsp" flush="false" />

	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m"
		style="background-image: url(images/heading-pages-06.jpg);">
		<h2 class="l-text2 t-center">Mypage</h2>
	</section>

	<section class="bgwhite p-t-60">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-lg-2 p-b-75">
					<div class="p-r-50 p-r-0-lg">

						<!-- Categories -->
						<h4 class="m-text23 p-t-20 p-b-14">Categories</h4>

						<ul>
							<li class="p-t-6 p-b-8 bo6"><a href="member_mod.jsp"
								class="s-text13 p-t-5 p-b-5"> 정보수정 </a></li>
																
							<li class="p-t-6 p-b-8 bo7"><a href="member_ord.jsp"
								class="s-text13 p-t-5 p-b-5"> 주문목록 </a></li>

							<li class="p-t-6 p-b-8 bo7"><a href="member_pur.jsp"
								class="s-text13 p-t-5 p-b-5"> 구매목록 </a></li>
							
							<li class="p-t-6 p-b-8 bo6"><a href="member_ran.jsp"
								class="s-text13 p-t-5 p-b-5"> 회원등급 </a></li>

							<li class="p-t-6 p-b-8 bo7"><a href="trackerAPI.jsp"
								class="s-text13 p-t-5 p-b-5"> 배송조회 </a></li>
						</ul>
					</div>
				</div>
				<%
				
				String id = (String) session.getAttribute("id");
				//String id = "werty45";
				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();
				dto = dao.select(id);
				
				if(id != null) {%>
				<div class="col-md-4 col-lg-10 p-b-75">
				<h4 class="m-text23 p-t-20 p-b-14"><%=id %>님의 등급은
				
				<%if(dto.getAmount()>100000 && dto.getAmount()<500000 ) { %>
				<font color="gold" size="7">gold</font>입니다
				<% }else if( dto.getAmount()>500000 ) { %>
				<font color="black" size="7">vip</font>입니다
				<% }else{ %>
				<font color="silver" size="7">silver</font>입니다
				<% } %>
				<hr>
				</h4>
				<table style="text-align: center;">
     
      				<thead>
        				<tr >
          				<th style="text-align: center; color : black ">등급</th>
          				<th style="text-align: center; color : silver ">silver</th>
          				<th style="text-align: center; color : gold ">gold</th>
          				<th style="text-align: center; color : black ">vip</th>
        				</tr>
      				</thead>
      				<tbody>
       					<tr >
         				<td >등급별 기준</td>
         				<td > 회원 </td>
          				<td > 누적금액 10만원이상</td>
          				<td > 누적금액 50만원이상</td>
        				</tr>
        				<tr >

          				<td >혜택</td>
          				<td >2%할인</td>
          				<td >5%할인</td>
          				<td >10%할인</td>
        				</tr>
      				</tbody>
     
    				</table>
					
				<%}else {
					out.println("<script language='javascript'>");
			        out.println("alert('로그인 후 이용해주세요')");
			        out.println("location.href='login.jsp'");
			        out.println("</script>");
				
				}
					
				%>		
				

				</div>
			</div>
		</div>

		<section class="bgwhite p-t-60">
			<div class="col-md-4 col-lg-3 p-b-75">
				<div class="rightbar">qwewqeqwdfq@@</div>
			</div>


		</section>



		<br> <br> <br> <br> <br> <br> <br>
		<br> <br>
		<hr>
		<br> <br> <br> <br> <br> <br>

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