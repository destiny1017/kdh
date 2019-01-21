<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가 (경로 확인) -->	
	<script type="text/javascript" src="se2/js/service/HuskyEZCreator.js" charset="UTF-8"></script>
	
		<!-- jQuery를 사용하기위해 jQuery라이브러리 추가 -->		
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>		
		<script type="text/javascript">
		
		var oEditors = [];
		
		$(function(){
		
		      nhn.husky.EZCreator.createInIFrame({
		
		          oAppRef: oEditors,
		
		          elPlaceHolder: "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
		
		          //SmartEditor2Skin.html 파일이 존재하는 경로
		
		          sSkinURI: "se2/SmartEditor2Skin.html",  
		
		          htParams : {
		
		              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)		
		              bUseToolbar : true,             
		
		              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)		
		              bUseVerticalResizer : true,     
		
		              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)		
		              bUseModeChanger : true,         		
		              fOnBeforeUnload : function(){
				                   		
		              }		
		          }, 
		
		          fOnAppLoad : function(){
		
		              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용		
		              oEditors.getById["ir1"].exec("PASTE_HTML", [""]);		
		          },		
		          fCreator: "createSEditor2"		
		      });
		
		      //저장버튼 클릭시 form 전송		
		      $("#save").click(function(){

		          oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
		          $("#frm").submit();	
		      });    
		});
		</script>

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
	<% String id = (String)session.getAttribute("id");
		String admin = (String)session.getAttribute("admin");
	   if(id==null&&admin==null){
		   out.println("<script type='text/javascript'>");
		   out.println("alert('로그인 후 이용 해주시기 바랍니다.');");
		   out.println("history.back();");
		   out.println("</script>");
	   }
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
				<form action="writeAction.jsp" method="post">
					<table class="table table-striped" style="text-align: center; 1px solid #dddddd">
						<thead>
							<tr>
								<th colspan="2" style="background-color: #eeeeee; text-align: center;">글쓰기</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class="input-group mb-3">
  										<div class="input-group-prepend">
    										<label class="input-group-text" for="bbsCategories">선택</label>
  										</div>
  										<select class="custom-select" id="bbsCategories" name="bbsCategories">
    										<option value="" selected disabled>Categories</option>
    										<option value="notice">NOTICE</option>
    										<option value="news">NEWS / EVENT</option>
    										<option value="qa">Q & A</option>
    										<option value="review">REVIEW</option>
  										</select>
									</div>
									<input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50">
								</td>
							</tr>
							<tr>
								<td><textarea id="ir1" name="bbsContent" maxlength="2048" style="height: 350px; width: 841px;"></textarea></td>
							</tr>
						</tbody>		
					</table>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-secondary pull-right" data-toggle="modal" data-target="#exampleModalCenter">글쓰기</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
 						<div class="modal-dialog modal-dialog-centered" role="document">
  							<div class="modal-content">
      							<div class="modal-header">
        							<h5 class="modal-title" id="exampleModalCenterTitle">게시물 등록</h5>
        							<button type="button" class="he close" data-dismiss="modal" aria-label="Close">
          								<span aria-hidden="true">&times;</span>
        							</button>
     				 			</div>
      							<div class="modal-body">
       								게시물을 등록하시겠습니까?
     							</div>
      							<div class="modal-footer">
        							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
       								<input type="submit" id="save" value="등록하기" class="btn btn-primary">
     							</div>
    						</div>
  						</div>
					</div>
					</form>
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
	
	<script type="text/javascript">
		$('.he').each(function(){
			var nameProduct = $(this).parent().parent().parent().find('.block2-name').html();
			$(this).on('click', function(){
				swal(nameProduct, "게시글 등록에 성공하였습니다.", "성공");
			});
		});
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>
