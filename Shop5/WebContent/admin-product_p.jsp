<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String btn = (String) request.getParameter("btn");
	String num = (String) request.getParameter("num");
	
	session.setAttribute(btn, num);
	response.sendRedirect("admin-product.jsp");
%>

