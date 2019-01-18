<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="bean.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.MemberDAO"%>
<%@ page
	import="com.oreilly.servlet.MultipartRequest,com.oreilly.servlet.multipart.DefaultFileRenamePolicy,java.util.*,java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Adminpage</title>
<%
String admin = (String)session.getAttribute("admin");
if(admin==null){
	   out.println("<script type='text/javascript'>");
	   out.println("alert('관리자 계정으로 로그인 후 이용 해주시기 바랍니다.');");
	   out.println("location.href='index.jsp';");
	   out.println("</script>");
}
%>
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

<style type="text/css">
.file_input label {
	position: relative;
	cursor: pointer;
	display: inline-block;
	vertical-align: middle;
	overflow: hidden;
	width: 100px;
	height: 30px;
	background: #777;
	color: #fff;
	text-align: center;
	line-height: 30px;
}

.file_input label input {
	position: absolute;
	width: 0;
	height: 0;
	overflow: hidden;
}

.file_input input[type=text] {
	vertical-align: middle;
	display: inline-block;
	width: 200px;
	height: 28px;
	line-height: 28px;
	font-size: 11px;
	padding: 0;
	border: 0;
	border: 1px solid #777;
}
</style>

</head>
<body class="animsition">

	<!-- Header -->
	<jsp:include page="includes/header.jsp" flush="false" />

	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m"
		style="background-image: url(images/heading-pages-06.jpg);">
	<h2 class="l-text2 t-center">AdminPage</h2>
	</section>


	<%--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ --%>

	<!-- content page -->
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
			<div class="col-md-8 col-lg-9 p-b-75">
				<form method="post" enctype="multipart/form-data" action="product-upload.jsp">
					<table class="table table-striped"
						style="text-align: center; 1px solid #dddddd">
						<thead>
							<tr>
								<th colspan="2"
									style="background-color: #eeeeee; text-align: center;">상품등록</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<table>
										<tr>
											<td colspan="8" id="td">
												<%--    기찮타                  --%>

												<Table>
													<tr>
														<td id="td1">

															<div class="file_input">
																<label> 제품사진1 <input
																	onchange="javascript:document.getElementById('file_route1').value=this.value"
																	type="file" name="filename1">
																</label> <input title="File Route" id="file_route1" type="text"
																	readonly="readonly">
															</div>
														</td>
														<td id="td2">

															<div class="file_input">
																<label> 제품사진2 <input
																	onchange="javascript:document.getElementById('file_route2').value=this.value"
																	type="file" name="filename2">
																</label> <input title="File Route" id="file_route2" type="text"
																	readonly="readonly">
															</div>
														</td>

														<td id="td3">

															<div class="file_input">
																<label> 제품사진3 <input
																	onchange="javascript:document.getElementById('file_route3').value=this.value"
																	type="file" name="filename3">
																</label> <input title="File Route" id="file_route3" type="text"
																	readonly="readonly">
															</div>
														</td>
													</tr>
												</Table> <%--         기찮타             --%>
											</td>
										</tr>
										<tr>
											<td width="50"><h5 class="m-text16">선택</h5></td>
											<td colspan="7"><select class="custom-select"
												id="bbsCategories" name="category">
													<option value="men">men</option>
													<option value="women">women</option>
													<option value="kids">kids</option>
											</select></td>
										</tr>
										<tr>
											<td width="50"><h5 class="m-text16">PID</h5></td>
											<td width="800" colspan="7"><input type="text"
												class="form-control" name="pId" maxlength="50"></td>
										</tr>
										<tr>
											<td width="50"><h5 class="m-text16">NAME</h5></td>
											<td width="800" colspan="7"><input type="text"
												class="form-control" name="name" maxlength="50"></td>
										</tr>
										<tr>
											<td width="50"><h5 class="m-text16">Explanation</h5></td>
											<td width="800" colspan="7"><input type="text"
												class="form-control" name="explanation" maxlength="50"></td>
										</tr>
										<tr>
											<td width="50"><h5 class="m-text16">Price</h5></td>
											<td width="800" colspan="7"><input type="text"
												class="form-control" name="price" maxlength="50"></td>
										</tr>
										<tr>
											<td width="50"><h5 class="m-text16">SizeS</h5></td>
											<td width="100"><input type="text" class="form-control"
												name="sizeS" maxlength="50"></td>
											<td width="50"><h5 class="m-text16">SizeM</h5></td>
											<td width="100"><input type="text" class="form-control"
												name="sizeM" maxlength="50"></td>
											<td width="50"><h5 class="m-text16">SizeL</h5></td>
											<td width="100"><input type="text" class="form-control"
												name="sizeL" maxlength="50"></td>
											<td width="50"><h5 class="m-text16">SizeXL</h5></td>
											<td width="100"><input type="text" class="form-control"
												name="sizeXL" maxlength="50"></td>
										</tr>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-secondary pull-right"
						data-toggle="modal" data-target="#exampleModalCenter">등록</button>

					<!-- Modal -->
					<div class="modal fade" id="exampleModalCenter" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalCenterTitle"
						aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalCenterTitle">상품
										등록</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">상품을 등록하시겠습니까?</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">취소</button>
									<input type="submit" value="등록하기" class="btn btn-primary">
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>

		</div>
	</section>


	<%--■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ --%>



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