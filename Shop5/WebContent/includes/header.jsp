<%@page import="bean.ProductDAO"%>
<%@page import="bean.AddCartDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="sun.font.Script"%>
<%@page import="bean.ProductDAO"%>
<%@page import="bean.ProductDTO"%>
<%@page import="bean.AddCartDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.AddCartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-132460737-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-132460737-1');
</script>


</head>
<body>
	<!-- Header -->
	
	<%
		
		String id = (String) session.getAttribute("id");
	    String name = (String) session.getAttribute("name");
	    String enc_id = (String) session.getAttribute("enc_id");
	    String admin = (String) session.getAttribute("admin");
		//id = "admin";
		
		String uId = id;
		AddCartDAO dao = new AddCartDAO();
		ArrayList<AddCartDTO> list = dao.getInfo(uId);
		ProductDAO pDAO = new ProductDAO();
		String path = request.getServletPath();
		path = path.substring(1,path.indexOf("."));

	%>
	
	<script type="text/javascript">
  	function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    	});
  	}
  	</script>

	<header class="header1">
		<!-- Header desktop -->
		<div class="container-menu-header">
			<div class="topbar">
				<div class="topbar-social">
					<a href="#" class="topbar-social-item fa fa-facebook"></a>
					<a href="#" class="topbar-social-item fa fa-instagram"></a>
					<a href="#" class="topbar-social-item fa fa-pinterest-p"></a>
					<a href="#" class="topbar-social-item fa fa-snapchat-ghost"></a>
					<a href="#" class="topbar-social-item fa fa-youtube-play"></a>
				</div>

				<span class="topbar-child1">
					Free shipping for standard order over $100
				</span>

            <div class="topbar-child2">
               <span class="topbar-email">
               
               
               
               		<%if(admin != null) {%>
               		<%=admin %> 님 안녕하세요 &nbsp;&nbsp;              		
               		<a href="_logout.jsp" onclick="signOut()">Logout</a>
               		<%}else{%>
               		
                 	<%if (id != null) { %>	
                 	<%=name %> 님 안녕하세요  &nbsp;&nbsp;
					<a href="_logout.jsp" onclick="signOut()">Logout</a>
					<%}else{%>
                 
					<span class="topbar-email">
						
					 	 <a href="login.jsp" id=login_main>로그인</a>
						
					</span>
					<% }%>
               		<%}%>
					</span>
               <div class="topbar-language rs1-select2">
                  <select class="selection-1" name="time">
                     <option>USD</option>
                     <option>EUR</option>
                  </select>
               </div>
            </div>
         </div>

			<div class="wrap_header">
				<!-- Logo -->
				<a href="index.jsp" class="logo">
					<img src="images/icons/logo.png" alt="IMG-LOGO">
				</a>

				<!-- Menu -->
				<div class="wrap_menu">
					<nav class="menu">
						<ul class="main_menu">
							<li id="index">
								<a href="index.jsp">Home</a>
						
							</li>

							<li id="product" class="menu-li">
								<a href="product.jsp?kind=all">Shop</a>
							</li>

							<li id="cart" class="menu-li">
								<a href="cart.jsp">Features</a>
							</li>

							<li id="blog" class="menu-li">
								<a href="notice.jsp">Board</a>
							</li>

							<li id="about" class="menu-li">
								<a href="about.jsp">About</a>
							</li>

							<li id="contact" class="menu-li">
								<a href="contact.jsp">Contact</a>
							</li>
						</ul>
					</nav>
				</div>
				<%
					out.println("<script type='text/javascript'>");
					out.println("var a = document.getElementById('"+path+"')");
					out.println("if(a!=null){a.setAttribute('class', 'menu-li sale-noti');}");
					out.println("</script>");
				%>
				<!-- Header Icon -->
								
				<div class="header-icons">
<%--
 --%>
					<%if(admin != null) { 
						if(admin.equals("관리자")){%>
		               <a href="admin-member.jsp" class="header-wrapicon1 dis-block">
		                  <img src="images/icons/admin.jpg" class="header-icon1" alt="ICON">
		               </a>	               
		               <span class="linedivide1"></span>
		               <%} %>
		            <%} %>
					<a href="member_mod.jsp" class="header-wrapicon1 dis-block">
						<img src="images/icons/icon-header-01.png" class="header-icon1" alt="ICON">
					</a>

					<span class="linedivide1"></span>

					<div class="header-wrapicon2">
						<img src="images/icons/icon-header-02.png" class="header-icon1 js-show-header-dropdown" alt="ICON">
						<span class="header-icons-noti"><%=list.size() %></span>
						<script type="text/javascript">
						   function deleteAddCart(x) {                   	 
		                    	 
	                    	 	var uid = document.getElementById("uid");
	                    	 	var pid = document.getElementById("pid"+x);
	                    	 	var size = document.getElementById("size"+x);
	                    	 	var cart = document.getElementById("cart"+x);
							 	cart.innerHTML="";

							
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
							
// 							//총 합 계산
// 	                   		 var subtotal = document.getElementById("subtotal");
// 	                    	 var allquantity = document.getElementsByName("num-product1");
// 	                    	 var allprice = document.getElementsByName("price");
// 	                    	 var sum = 0;
	                    	 
// 	                    	 for (var i = 0; i < allprice.length; i++) {	
	        
// 								sum += allquantity[i].value*allprice[i].value; 
// 							}
// 	                    	 subtotal.innerHTML = sum+"원";
	                   	 
	                   	 	}
						
						
						</script>
						<!-- Header cart noti -->
						<div class="header-cart header-dropdown">
							<ul class="header-cart-wrapitem">
							<input type="hidden" id="uid" value="root">
							<%
							int sum=0;
							for(int i=0; i<list.size(); i++){ 
								ProductDTO pDto = pDAO.getInfo(list.get(i).getpId());
								%>
								<input type="hidden" id="pid<%=i %>" value="<%=list.get(i).getpId() %>">
								<input type="hidden" id="size<%=i %>" value="<%=list.get(i).getSize() %>">
								
								<li class="header-cart-item" id="cart<%=i%>">
									<div onclick="deleteAddCart(<%=i %>)" class="header-cart-item-img">
										<img src="images/clothes/<%=list.get(i).getpId() %>_1.jpg" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="product-detail.jsp?pId=<%=list.get(i).getpId() %>" class="header-cart-item-name">
										<%=pDto.getName() %>
										</a>

										<span class="header-cart-item-info">
										  <%=list.get(i).getCount() %>개 (<%=list.get(i).getSize()%>) X <%=pDto.getPrice() %>원
										</span>
									</div>
								</li>
							<%
							sum += Integer.parseInt(list.get(i).getCount())*Integer.parseInt(pDto.getPrice()); 
							} %>							
							</ul>

							<div class="header-cart-total">
								<font size="1">페이지 이동 시마다 업데이트 됩니다.</font><br>
								Total: <%=sum %>원
							</div>

							<div class="header-cart-buttons">
								<div class="header-cart-wrapbtn">

								</div>
								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="cart.jsp" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										View Cart
									</a>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Header Mobile -->
		<div class="wrap_header_mobile">
			<!-- Logo moblie -->
			<a href="index.jsp" class="logo-mobile">
				<img src="images/icons/logo.png" alt="IMG-LOGO">
			</a>

			<!-- Button show menu -->
			<div class="btn-show-menu">
				<!-- Header Icon mobile -->
				<div class="header-icons-mobile">
					<a href="#" class="header-wrapicon1 dis-block">
						<img src="images/icons/icon-header-01.png" class="header-icon1" alt="ICON">
					</a>

					<span class="linedivide2"></span>

					<div class="header-wrapicon2">
						<img src="images/icons/icon-header-02.png" class="header-icon1 js-show-header-dropdown" alt="ICON">
						<span class="header-icons-noti">0</span>

						<!-- Header cart noti -->
						<div class="header-cart header-dropdown">
							<ul class="header-cart-wrapitem">
								<li class="header-cart-item">
									<div class="header-cart-item-img">
										<img src="images/item-cart-01.jpg" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											White Shirt With Pleat Detail Back
										</a>

										<span class="header-cart-item-info">
											1 x $19.00
										</span>
									</div>
								</li>

								<li class="header-cart-item">
									<div class="header-cart-item-img">
										<img src="images/item-cart-02.jpg" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											Converse All Star Hi Black Canvas
										</a>

										<span class="header-cart-item-info">
											1 x $39.00
										</span>
									</div>
								</li>

								<li class="header-cart-item">
									<div class="header-cart-item-img">
										<img src="images/item-cart-03.jpg" alt="IMG">
									</div>

									<div class="header-cart-item-txt">
										<a href="#" class="header-cart-item-name">
											Nixon Porter Leather Watch In Tan
										</a>

										<span class="header-cart-item-info">
											1 x $17.00
										</span>
									</div>
								</li>
							</ul>

							<div class="header-cart-total">
								Total: $75.00
							</div>

							<div class="header-cart-buttons">
								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="cart.jsp" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										View Cart
									</a>
								</div>

								<div class="header-cart-wrapbtn">
									<!-- Button -->
									<a href="#" class="flex-c-m size1 bg1 bo-rad-20 hov1 s-text1 trans-0-4">
										Check Out
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
					<span class="hamburger-box">
						<span class="hamburger-inner"></span>
					</span>
				</div>
			</div>
		</div>

		<!-- Menu Mobile -->
		<div class="wrap-side-menu" >
			<nav class="side-menu">
				<ul class="main-menu">
					<li class="item-topbar-mobile p-l-20 p-t-8 p-b-8">
						<span class="topbar-child1">
							Free shipping for standard order over $100
						</span>
					</li>

					<li class="item-topbar-mobile p-l-20 p-t-8 p-b-8">
						<div class="topbar-child2-mobile">
							<span class="topbar-email">
								fashe@example.com
							</span>

							<div class="topbar-language rs1-select2">
								<select class="selection-1" name="time">
									<option>USD</option>
									<option>EUR</option>
								</select>
							</div>
						</div>
					</li>

					<li class="item-topbar-mobile p-l-10">
						<div class="topbar-social-mobile">
							<a href="#" class="topbar-social-item fa fa-facebook"></a>
							<a href="#" class="topbar-social-item fa fa-instagram"></a>
							<a href="#" class="topbar-social-item fa fa-pinterest-p"></a>
							<a href="#" class="topbar-social-item fa fa-snapchat-ghost"></a>
							<a href="#" class="topbar-social-item fa fa-youtube-play"></a>
						</div>
					</li>

					<li class="item-menu-mobile">
						<a href="index.jsp">Home</a>
						<ul class="sub-menu">
							<li><a href="index.jsp">Homepage V1</a></li>
							<li><a href="home-02.jsp">Homepage V2</a></li>
							<li><a href="home-03.jsp">Homepage V3</a></li>
						</ul>
						<i class="arrow-main-menu fa fa-angle-right" aria-hidden="true"></i>
					</li>

					<li class="item-menu-mobile">
						<a href="product.jsp?kind=all">Shop</a>
					</li>

					<li class="item-menu-mobile">
						<a href="product.jsp?kind=all">Sale</a>
					</li>

					<li class="item-menu-mobile">
						<a href="cart.jsp">Features</a>
					</li>

					<li class="item-menu-mobile">
						<a href="blog.jsp">Blog</a>
					</li>

					<li class="item-menu-mobile">
						<a href="about.jsp">About</a>
					</li>

					<li class="item-menu-mobile">
						<a href="contact.jsp">Contact</a>
					</li>
				</ul>
			</nav>
		</div>
	</header>
</body>
</html>