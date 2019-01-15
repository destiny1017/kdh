<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="bean.ProductDAO"%>
<%@page import="bean.ProductDTO"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="com.oreilly.servlet.MultipartRequest,com.oreilly.servlet.multipart.DefaultFileRenamePolicy,java.util.*,java.io.*" %>
<%@ page import="java.sql.*" %>

<%
	 request.setCharacterEncoding("UTF-8");
	 
	 String category = request.getParameter("category");
	 String pId = request.getParameter("pId");
	 String name = request.getParameter("name");
	 String explanation = request.getParameter("explanation");
	 String price = request.getParameter("price");
	 String sizeS = request.getParameter("sizeS");
	 String sizeM = request.getParameter("sizeM");
	 String sizeL = request.getParameter("sizeL");
	 String sizeXL = request.getParameter("sizeXL");
	 
	 ProductDAO dao = new ProductDAO();
	 ProductDTO dto = new ProductDTO(pId, name, explanation, price, sizeS, sizeM, sizeL, sizeXL, category);
	 
	 dao.updateProduct(dto);
	 
%>
<script type="text/javascript">
	function rs(){		
		alert("상품 등록에 성공하였습니다.")
	}
	
	rs()
</script>
	
<title>Insert title here</title>
</head>
<body>
<%
	response.sendRedirect("admin-product.jsp");
%>

</body>
</html>
