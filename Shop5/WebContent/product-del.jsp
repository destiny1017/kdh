<%@page import="bean.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pId = request.getParameter("pId");
	ProductDAO dao = new ProductDAO();
	dao.deleteProduct(pId);
%>

<script>
	alert("정상적으로 삭제되었습니다.")
	location.href = "admin-product.jsp"
</script>