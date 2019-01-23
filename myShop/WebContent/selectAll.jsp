<%@page import="java.util.ArrayList"%>
<%@page import="product.ProductDTO"%>
<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductDAO dao = new ProductDAO();
	ArrayList<ProductDTO> dto = dao.selectAll();
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
	<%for(int i = 0; i < dto.size(); i++){%>
	<tr>
		<td>1</td>
		<td><%=dto.get(i).getId() %></td>
		<td><%=dto.get(i).getName() %></td>
		<td><%=dto.get(i).getDetail() %></td>
		<td><%=dto.get(i).getPrice() %></td>
	</tr>
	<%} %>
</table>

</body>
</html>