<%@page import="bean.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		String search = (String) request.getParameter("search");
		String num = (String) request.getParameter("num");
		int number = Integer.parseInt(num);
		ProductDAO pDAO = new ProductDAO();
		ArrayList<ProductDTO> list=null;
		
		list = pDAO.getInfoName(search);
		
	%>
	<%
		for (int i = 0; i < list.size(); i++) {
			int j = 6*(number-1)+i;
			if(i==6||j==list.size()){
				break;
			}
	%>
	<input type="hidden" id="size" value="<%=list.size()%>">
	<div class="col-sm-12 col-md-6 col-lg-4 p-b-50">
		<!-- Block2 -->
		<div class="block2">
			<div
				class="block2-img wrap-pic-w of-hidden pos-relative block2-labelnew">
				<img src="images/clothes/<%=list.get(j).getPId()%>_1.jpg"
					alt="<%=list.get(j).getName()%>">

				<div class="block2-overlay trans-0-4">
					<a href="#" class="block2-btn-addwishlist hov-pointer trans-0-4">
						<i class="icon-wishlist icon_heart_alt" aria-hidden="true"></i> <i
						class="icon-wishlist icon_heart dis-none" aria-hidden="true"></i>
					</a>

					<div class="block2-btn-addcart w-size1 trans-0-4">
						<!-- Button -->
						<!-- 						<button -->
						<!-- 							class="flex-c-m size1 bg4 bo-rad-23 hov1 s-text1 trans-0-4"> -->
						<!-- 							Add to Cart</button> -->
					</div>
				</div>
			</div>

			<div class="block2-txt p-t-20">
				<a href="product-detail.jsp?pId=<%=list.get(j).getPId()%>"
					class="block2-name dis-block s-text3 p-b-5"> <%=list.get(j).getName()%>
				</a> <span class="block2-price m-text6 p-r-5"> <%=list.get(j).getPrice()%>원
				</span>
			</div>
		</div>
	</div>
	<input type="hidden" id="num" value="<%=number %>">
	<%
		}
	%>
	<script type="text/javascript">
	
	var pagination = document.getElementsByClassName("pagination");
	<%if(number==1){%>
	var button = "<a href=\"#\" onclick=\"page(1)\" id=\"page(1)\"class=\"item-pagination flex-c-m trans-0-4 active-pagination\">1</a>";
	<%}else{%>
	var button = "<a href=\"#\" onclick=\"page(1)\" id=\"page(1)\"class=\"item-pagination flex-c-m trans-0-4\">1</a>";
	<%}
	if (list.size() > 6) {
		int count = 1;
		for (int i = 6; i < list.size(); i++) {
			if (i % 6 == 0) {
				count++;
			if(count==number){
	%>
	button += "<a href=\"#\" onclick=\"page(<%=count%>)\" id=\"page(<%=count%>)\"class=\"item-pagination flex-c-m trans-0-4 active-pagination\"><%=count%></a>";
	<%			
			}else{
	%>
	button += "<a href=\"#\" onclick=\"page(<%=count%>)\" id=\"page(<%=count%>)\"class=\"item-pagination flex-c-m trans-0-4\"><%=count%></a>";
	<%
		}
			}
		}
	}
	%>
		pagination[0].innerHTML = button;
	</script>
	<input type="hidden" id="search">
</body>
</html>