<%@page import="bean.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<%
		String id = (String) session.getAttribute("id");
		String name = request.getParameter("name");
		String sizeS = request.getParameter("sizeS");
		String sizeM = request.getParameter("sizeM");
		String sizeL = request.getParameter("sizeL");
		String sizeXL = request.getParameter("sizeXL");
		String price = request.getParameter("price");
		String pId = request.getParameter("pId");
		String reCheck = "X";

		PurchaseListDTO purDto = new PurchaseListDTO();
		PurchaseListDAO purDao = new PurchaseListDAO();
		OrderListDAO ordDao = new OrderListDAO();
		
		purDto.setId(id);
		purDto.setName(name);
		purDto.setSizeS(sizeS);
		purDto.setSizeM(sizeM);
		purDto.setSizeL(sizeL);
		purDto.setSizeXL(sizeXL);
		purDto.setPrice(price);
		purDto.setpId(pId);
		purDto.setReCheck(reCheck);
		purDao.purchaseInsert(purDto);
		ordDao.orderDelete(pId);
		
		out.println("<script> alert(\"구매확인\"); location.href='member_pur.jsp'; </script>");
		
	%>
	

</body>
</html>