<%@page import="bean.ProductDAO"%>
<%@page import="bean.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<body>
	<%
		String kind = (String) request.getParameter("kind");
		String num = (String) request.getParameter("num");
		int number = Integer.parseInt(num);
		ProductDAO pDAO = new ProductDAO();
		ArrayList<ProductDTO> list=null;
		if (kind.equals("all")) {
			list = pDAO.getInfoALL();
		} else {
			list = pDAO.getInfoCategory(kind);
		}
	%>
	<%
		for (int i = 0; i < list.size(); i++) {
			int j = 6*(number-1)+i;
			if(i==6||j==list.size()){
				break;
			}
	%>
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
	<%
		}
	%>

</body>

</html>

