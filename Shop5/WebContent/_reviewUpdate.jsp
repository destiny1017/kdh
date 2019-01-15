<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>      
<%@page import="bean.*"%>
<%@page import="java.util.ArrayList"%>    
<%
	String title = request.getParameter("review_title");
    String name = request.getParameter("review_name");
    String content = request.getParameter("review_content");
    String pId = request.getParameter("pId");
	
	String url = "jdbc:mysql://localhost:3306/test2";
	String user = "root";
	String password = "1234";
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url, user, password);
	String sql = "update review set title = ?, name = ?, content = ? where pId = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, title);
	ps.setString(2, name);
	ps.setString(3, content);
	ps.setString(4, pId);
	
	ps.executeUpdate();
	
    out.println("<script language='javascript'>");
    out.println("alert('리뷰수정 성공')");
    out.println("location.href='member_pur.jsp'");
    out.println("</script>");
    
    
	con.close();
	ps.close();
%>