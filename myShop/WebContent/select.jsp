<%@page import="javax.websocket.SendResult"%>
<%@page import="product.ProductDTO"%>
<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductDAO dao = new ProductDAO();
	ProductDTO dto = dao.select(request.getParameter("id"));	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<td width="10">No.</td>
		<td width="30">id</td>
		<td width="50">상품명</td>
		<td width="100">상품상세</td>
		<td width="30">가격</td>
	</tr>
	<!-- 리턴값 존재할 시 -->
	<%if(dto != null) {%>
	<tr>
		<td>1</td>
		<td><%=dto.getId() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getDetail() %></td>
		<td><%=dto.getPrice() %></td>
	</tr>
	<!-- 리턴 값 없을 시 -->
	<%}else{ %>
	<tr>
		<td colspan="6">찾으시는 상품이 존재하지 않습니다.</td>
	</tr>
	<%} %>
</table>
<a href="select.html">이전 페이지로</a>

</body>
</html>