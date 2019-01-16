<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="bean.BbsDAO" %>
 <%@page import="bean.BbsDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
.star-input>.input,
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{display: inline-block;vertical-align:middle;background:url('images/grade_img.png')no-repeat;}
.star-input{display:inline-block; white-space:nowrap;width:225px;height:40px;padding:25px;line-height:30px;}
.star-input>.input{display:inline-block;width:150px;background-size:150px;height:28px;white-space:nowrap;overflow:hidden;position: relative;}
.star-input>.input>input{position:absolute;width:1px;height:1px;opacity:0;}
star-input>.input.focus{outline:1px dotted #ddd;}
.star-input>.input>label{width:30px;height:0;padding:28px 0 0 0;overflow: hidden;float:left;cursor: pointer;position: absolute;top: 0;left: 0;}
.star-input>.input>label:hover,
.star-input>.input>input:focus+label,
.star-input>.input>input:checked+label{background-size: 150px;background-position: 0 bottom;}
.star-input>.input>label:hover~label{background-image: none;}
.star-input>.input>label[for="p1"]{width:30px;z-index:5;}
.star-input>.input>label[for="p2"]{width:60px;z-index:4;}
.star-input>.input>label[for="p3"]{width:90px;z-index:3;}
.star-input>.input>label[for="p4"]{width:120px;z-index:2;}
.star-input>.input>label[for="p5"]{width:150px;z-index:1;}
.star-input>output{display:inline-block;width:60px; font-size:18px;text-align:right; vertical-align:middle;}
</style>

	<title>Community</title>
	<link rel="stylesheet" 
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
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
		int bbsId = 0;
		String bbsCategoires = request.getParameter("bbsCategories");
		String bbsImg = request.getParameter("img");
		String star = request.getParameter("star");
		
		if(request.getParameter("bbsId") != null) {
			bbsId = Integer.parseInt(request.getParameter("bbsId"));
		}
		BbsDTO dto = new BbsDAO().getBbs(bbsCategoires , bbsId);
	%>

	<!-- Header -->
	<jsp:include page="includes/header.jsp" flush="false" />
	
	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(images/headimg2.jpg);">
		<h2 class="l-text2 t-center">
			COMMUNITY
		</h2>
	</section>

	<!-- content page -->
	<section class="bgwhite p-t-60">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-lg-9 p-b-75">
					<table class="table table-striped" style="text-align: center; 1px solid #dddddd">
						<thead>
							<tr>
								<th colspan="2" style="background-color: #eeeeee; text-align: center;"><%=dto.getBbsCategories().toUpperCase() %></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="width: 10%">제목</td>
								<td colspan="2" style="text-align: left;"><%=dto.getBbsTitle() %></td>
							</tr>
							<tr>
								<td>작성자</td>
								<td colspan="2" style="text-align: left;"><%=dto.getUserId() %></td>
							</tr>
							<tr>
								<td>작성일</td>
								<td colspan="2" style="text-align: left;"><%=dto.getBbsDate().substring(0, 10) %> <%=dto.getBbsDate().substring(11, 13) %>시 <%=dto.getBbsDate().substring(14,16) %>분</td>
							</tr>
							<%
								if(dto.getBbsCategories().equals("review")) {
							%>
							<tr>
								<td>별점</td>
								<td colspan="2" style="text-align: left;">
									<%
										if(star.equals("5")) {
									%>
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star.gif">
									<%
										}
										else if(star.equals("4")) {
									%>
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star2.gif">
									<%
										}
										else if(star.equals("3")) {
									%>
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star2.gif">
											<img alt="" src="images/star2.gif">
									<%
										}
										else if(star.equals("2")) {
									%>
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star2.gif">
											<img alt="" src="images/star2.gif">
											<img alt="" src="images/star2.gif">
									<%
										}
										else if(star.equals("1")) {
									%>
											<img alt="" src="images/star.gif">
											<img alt="" src="images/star2.gif">
											<img alt="" src="images/star2.gif">
											<img alt="" src="images/star2.gif">
											<img alt="" src="images/star2.gif">									
									<%
										}
										else {
									%>
											<img alt="" src="images/star2.gif">
											<img alt="" src="images/star2.gif">
											<img alt="" src="images/star2.gif">
											<img alt="" src="images/star2.gif">
											<img alt="" src="images/star2.gif">
									<%
										}
									%>
								</td>
							</tr>
							<tr>
								<td></td>
								<td colspan="2" style="text-align: center;" ><img alt="" src="uploadFile/<%=bbsImg %>" width="500" height="800"></td>
							</tr>							
							<%
								}
							%>
							<tr>
								<td>내용</td>
								<td colspan="2" style="text-align: left;" ><%=dto.getBbsContent() %></td>
							</tr>
						</tbody>		
					</table>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-secondary pull-right" data-toggle="modal" data-target="#exampleModalCenter" onclick="history.back()">목록</button>
					<%
						if(dto.getBbsCategories().equals("qa") && !(dto.getBbsTitle().startsWith("[RE]"))) {
					%>
							<a href="reply.jsp?bbsId=<%=dto.getBbsId() %>&bbsTitle=<%=dto.getBbsTitle() %>&bbsCategoires=<%=dto.getBbsCategories() %>" class="btn btn-secondary">답글</a>					
					<%
						}
					%>
					<a href="update.jsp?bbsId=<%=dto.getBbsId() %>&bbsCategories=<%=dto.getBbsCategories() %>" class="btn btn-secondary">수정</a>
					<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="deleteAction.jsp?bbsId=<%=dto.getBbsId() %>&bbsCategories=<%=dto.getBbsCategories() %>" class="btn btn-secondary">삭제</a>
				</div>
				

				<div class="col-md-4 col-lg-3 p-b-75">
					<div class="rightbar">
						<!-- Search -->
						<div class="pos-relative bo11 of-hidden">
							<input class="s-text7 size16 p-l-23 p-r-50" type="text" name="search-product" placeholder="Search">

							<button class="flex-c-m size5 ab-r-m color1 color0-hov trans-0-4">
								<i class="fs-13 fa fa-search" aria-hidden="true"></i>
							</button>
						</div>

						<!-- Categories -->
						<h4 class="m-text23 p-t-56 p-b-34">
							Categories
						</h4>

						<ul>
							<li class="p-t-6 p-b-8 bo6">
								<a href="notice.jsp" class="s-text13 p-t-5 p-b-5">
									NOTICE
								</a>
							</li>

							<li class="p-t-6 p-b-8 bo7">
								<a href="news.jsp" class="s-text13 p-t-5 p-b-5">
									NEWS / EVENT
								</a>
							</li>

							<li class="p-t-6 p-b-8 bo7">
								<a href="qa.jsp" class="s-text13 p-t-5 p-b-5">
									Q & A
								</a>
							</li>

							<li class="p-t-6 p-b-8 bo7">
								<a href="review.jsp" class="s-text13 p-t-5 p-b-5">
									REVIEW
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="bg6 p-t-45 p-b-43 p-l-45 p-r-45">
		<div class="flex-w p-b-90">
			<div class="w-size6 p-t-30 p-l-15 p-r-15 respon3">
				<h4 class="s-text12 p-b-30">
					GET IN TOUCH
				</h4>

				<div>
					<p class="s-text7 w-size27">
						Any questions? Let us know in store at 8th floor, 379 Hudson St, New York, NY 10018 or call us on (+1) 96 716 6879
					</p>

					<div class="flex-m p-t-30">
						<a href="#" class="fs-18 color1 p-r-20 fa fa-facebook"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-instagram"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-pinterest-p"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-snapchat-ghost"></a>
						<a href="#" class="fs-18 color1 p-r-20 fa fa-youtube-play"></a>
					</div>
				</div>
			</div>

			<div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
				<h4 class="s-text12 p-b-30">
					Categories
				</h4>

				<ul>
					<li class="p-b-9">
						<a href="#" class="s-text7">
							Men
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Women
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Dresses
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Sunglasses
						</a>
					</li>
				</ul>
			</div>

			<div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
				<h4 class="s-text12 p-b-30">
					Links
				</h4>

				<ul>
					<li class="p-b-9">
						<a href="#" class="s-text7">
							Search
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							About Us
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Contact Us
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Returns
						</a>
					</li>
				</ul>
			</div>

			<div class="w-size7 p-t-30 p-l-15 p-r-15 respon4">
				<h4 class="s-text12 p-b-30">
					Help
				</h4>

				<ul>
					<li class="p-b-9">
						<a href="#" class="s-text7">
							Track Order
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Returns
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							Shipping
						</a>
					</li>

					<li class="p-b-9">
						<a href="#" class="s-text7">
							FAQs
						</a>
					</li>
				</ul>
			</div>

			<div class="w-size8 p-t-30 p-l-15 p-r-15 respon3">
				<h4 class="s-text12 p-b-30">
					Newsletter
				</h4>

				<form>
					<div class="effect1 w-size9">
						<input class="s-text7 bg6 w-full p-b-5" type="text" name="email" placeholder="email@example.com">
						<span class="effect1-line"></span>
					</div>

					<div class="w-size2 p-t-20">
						<!-- Button -->
						<button class="flex-c-m size2 bg4 bo-rad-23 hov1 m-text3 trans-0-4">
							Subscribe
						</button>
					</div>

				</form>
			</div>
		</div>

		<div class="t-center p-l-15 p-r-15">
			<a href="#">
				<img class="h-size2" src="images/icons/paypal.png" alt="IMG-PAYPAL">
			</a>

			<a href="#">
				<img class="h-size2" src="images/icons/visa.png" alt="IMG-VISA">
			</a>

			<a href="#">
				<img class="h-size2" src="images/icons/mastercard.png" alt="IMG-MASTERCARD">
			</a>

			<a href="#">
				<img class="h-size2" src="images/icons/express.png" alt="IMG-EXPRESS">
			</a>

			<a href="#">
				<img class="h-size2" src="images/icons/discover.png" alt="IMG-DISCOVER">
			</a>

			<div class="t-center s-text8 p-t-20">
				Copyright © 2018 All rights reserved. | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
			</div>
		</div>
	</footer>



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
