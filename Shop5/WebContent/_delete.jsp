
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
		String pId = request.getParameter("pId");
		String orpId = request.getParameter("orpId");
		
		if(orpId != null) {
			OrderListDAO ordDao = new OrderListDAO();
			ordDao.orderDelete(orpId);
			out.println("<script language='javascript'>");
		    out.println("alert('주문취소 완료')");
		    out.println("location.href='member_ord.jsp'");
		    out.println("</script>");
		}else {
			PurchaseListDAO purDao = new PurchaseListDAO();
			purDao.purchaseDelete(pId);
			out.println("<script language='javascript'>");
		    out.println("alert('구매삭제 완료')");
		    out.println("location.href='member_pur.jsp'");
		    out.println("</script>");
		}
		
	%>
	

</body>
</html>