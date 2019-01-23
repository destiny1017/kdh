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
	<tr>
		<td>1</td>
		<td><%=dto.getId() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getDetail() %></td>
		<td><%=dto.getPrice() %></td>
	</tr>
</table>

</body>
</html>