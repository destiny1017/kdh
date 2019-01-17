<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="bean.*"%>
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
<%-- jQuery CDN --%>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<%-- BootStrap CDN --%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
				
				if(id != null) {
				
				%>
				
				<div class="col-md-4 col-lg-10 p-b-75">
					<h4 class="m-text23 p-t-20 p-b-14"><%=id %>님의 주문리스트</h4>
					<hr>
									
				<br>
				<table border='1'>
					<tr>
						<th width='3%' style="text-align: center;"> 번호 </th>
						<th width='10%'> 상품이미지 </th>
						<th width='10%'> 상품명 </th>
						<th width='7%'> 사이즈S </th>
						<th width='7%'> 사이즈M </th>
						<th width='7%'> 사이즈L </th>
						<th width='8%'> 사이즈XL </th>
						<th width='8%'> 가격 </th>
						<th width='3%' style="text-align: center;"> pId </th>
						<th width='10%' style="text-align: center;"> 택배사 </th>
						<th width='10%' style="text-align: center;"> 운송번호 </th>
						<th width='3%' style="text-align: center;"> - </th>
						<th width='10%' style="text-align: center;"> 구매확정</th>
						<th width='20%' style="text-align: center;"> 주문취소</th>
						</tr>
						
				<%
	
				String url = "jdbc:mysql://localhost:3306/shop";
				String user = "root";
				String password = "1234";
	
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);
				String sql = "select * from orderlist where id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,id);
			
				ResultSet rs = ps.executeQuery();
		
				int i = 1; int sum = 0;
	
					while (rs.next()) {
				%>	
				
					<tr>
						<td style="text-align: center;"> <%=i %></td> <!-- 번호 -->
						<td> <%=i %> </td> <!-- 상품이미지 -->
						<td> <%=rs.getString("name") %> </td> <!-- 상품명 -->
						<td> <%=rs.getInt("sizeS") %>개 </td> <!-- 사이즈S -->
						<td> <%=rs.getInt("sizeM") %>개 </td> <!-- 사이즈M -->
						<td> <%=rs.getInt("sizeL") %>개 </td> <!-- 사이즈L -->
						<td> <%=rs.getInt("sizeXL") %>개 </td> <!-- 사이즈XL -->
						<td> <%=rs.getInt("price") %>원 </td> <!-- 가격 -->
						<td style="text-align: center;"> <%=rs.getInt("pId") %> </td> <!-- pId -->
						<td style="text-align: center;"> <%=rs.getString("transName") %> </td> <!-- 택배사 -->
						<td style="text-align: center;"> <%=rs.getString("transNum") %> </td> <!-- 운송번호 -->
						<td style="text-align: center;"> <a href = "trackerAPI.jsp?transNum=<%=rs.getString("transNum") %>&transName=<%=rs.getString("transName") %>">조회</a></td> <!-- 운송조회 -->
						<td style="text-align: center;"> <a href = "_confirm.jsp?pId=<%=rs.getInt("pId") %>&name=<%=rs.getString("name") %>&sizeS=<%=rs.getString("sizeS") %>&sizeM=<%=rs.getString("sizeM") %>&sizeL=<%=rs.getString("sizeL") %>&sizeXL=<%=rs.getString("sizeXL") %>&price=<%=rs.getString("price") %>"> 구매확정 </a> </td> <!-- 구매확정 -->
						<td style="text-align: center;"> <a href = "_delete.jsp?orpId=<%=rs.getInt("pId") %>"> 주문취소 </a> </td></tr> <!-- 코드 삭제 -->
				<%
				i++;
				sum += (rs.getInt("sizeS")+ rs.getInt("sizeM") + rs.getInt("sizeL") + rs.getInt("sizeXL")) * rs.getInt("price");
				}
				
				
				con.close();
				ps.close();
				%>
	 				<tr>
	 					<td colspan="14" align="right">
	 					<div>
	 					<div  style="float: right; width: 20%">
	 					<input type="submit" value="확인" class="btn btn-primary btn-large btn-block" style="width: 100px">
	 					</div>
	 					</div>
	 					<div style="float: right; width: 30%">
	 					<h5 style="float: right; width: 50%"><b>합 계</b> : &nbsp;<%=sum %>원 &nbsp;</h5>
	 					</div>
						</td>
					</tr>
						
						
						
						
			<% }else {
				out.println("<script language='javascript'>");
		        out.println("alert('회원가입후 이용해주세요')");
		        out.println("location.href='login.jsp'");
		        out.println("</script>");
			
			}
				
			%>		
			</table>
	 					<div>
						<a href="about.jsp"> 돌아가기 </a></div> 

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
	
<script type="text/javascript">
	function review() {

		id = document.getElementById("user_id").value;
		name = document.getElementById("review_name").value;
		title = document.getElementById("review_title").value;
		content = document.getElementById("review_content").value;
		pkcode = document.getElementById("pId").value;
		
		
		
		location.href = "_review.jsp?pkcode=" + pkcode + "&name=" + name + "&title=" + title + "&content=" + content;
	}
</script>



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