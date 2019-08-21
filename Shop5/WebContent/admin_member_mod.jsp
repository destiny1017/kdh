<%@page import="bean.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.MemberDAO"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

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

							<li class="p-t-6 p-b-8 bo7"><a href="admin-statistics.jsp"
								class="s-text13 p-t-5 p-b-5"> 통계 </a></li>
						</ul>
					</div>
				</div>					
				<div style="background: white; width: 900px; height: auto;" id="memTb">
					
						<%
					// 세션정보 가져오기

					//String id = (String) session.getAttribute("id");
					String uId = request.getParameter("uId");
					//String id = "werty45";

					if (uId != null) { //null체크시 else가 안먹힘.

						String url = "jdbc:mysql://localhost:3306/shop";
						String user = "root";
						String password = "1234";
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection(url, user, password);
						String sql = "select * from member where id = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, uId);

						ResultSet rs = ps.executeQuery();
				%>

				<div class="col-md-4 col-lg-10 p-b-75">
					<form action="_modify.jsp">
					<h4 class="m-text23 p-t-20 p-b-14">Modify Info</h4>
					<hr>
					<table class="table-shopping-cart">
					<%
						if (rs.next()) {
					%>
					<tr>
					<td style="align-items: center;"><h5>ID :</h5></td>
					<td>
					<div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden sizefull s-text7 p-l-22 p-r-22">
							<%=rs.getString("id")%>
						</div>
					</div>
					</td>
					</tr>
					<tr>
					<td><h5>PW :</h5></td>
					<td>
					<div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden">
							<input class="sizefull s-text7 p-l-22 p-r-22" type="password" 
								name="pw" value="<%=rs.getString("pw")%>">
						</div>
					</div>
					</td>
					</tr>
					<tr>
					<td><h5>Name :</h5></td>
					<td>
					<div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden">
							<input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="name"
								value="<%=rs.getString("name")%>">
						</div>
					</div>
					</td>
					</tr>
					<tr>
					<td><h5>ResNum :</h5></td>
					<td>
					<div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden">
							<input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="resNum"
								value="<%=rs.getString("resNum")%>">
						</div>
					</div>
					</td>
					</tr>
					<tr>
					<td><h5>Tel :</h5></td>
					<td>
					<div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden">
							<input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="tel"
								value="<%=rs.getString("tel")%>">
						</div>
						
						
					</div>
					</td>
					</tr>
					<tr>
					<td><h5>Address :</h5></td>
					<td>
					<div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden">
							<input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="address"
								value="<%=rs.getString("address")%>">
						</div>
					</div>
					</td>
					</tr>
					<tr>
					<td><h5>누적금액 :</h5></td>
					<td>
					<div class="p-r-230 p-r-230-lg">
						<div class="search-product pos-relative bo4 of-hidden sizefull s-text7 p-l-22 p-r-22">
							<%=rs.getString("amount")%>원
						</div>
					</div>
					</td>
					</tr>
					</table>
					<br>
					<table>
						<tr>
							<td align="center" class="p-r-10">
							<input type="submit" class="flex-c-m size2 bg1 bo-rad-23 hov1 m-text3 trans-0-4"
								value="변경" style="width: 100px"></td>
							<td><input type="button" value="회원 탈퇴" 
								class="flex-c-m size2 bg1 bo-rad-23 hov1 m-text3 trans-0-4" style="width: 100px"
								onClick="my_delete()"></td>
						</tr>
					</table>
					</form>
					<%
						}else{%>
							외부 아이디로 로그인 시 정보 수정이 불가능합니다.
						<%}
						con.close();
						ps.close();
						
						} else {
					 		out.println("<script language='javascript'>");
					    	out.println("alert('회원가입후 이용해주세요')");
					    	out.println("location.href='login.jsp'");
					    	out.println("</script>");
						}
					%>

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