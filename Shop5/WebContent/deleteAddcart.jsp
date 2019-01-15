<%@page import="bean.AddCartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String uId = request.getParameter("uid");
	String pId = request.getParameter("pid");
	String size = request.getParameter("size");
	
	AddCartDAO dao = new AddCartDAO();
	dao.deleteInfo(uId, pId, size);
%>

</head>
<body>
</body>
</html>