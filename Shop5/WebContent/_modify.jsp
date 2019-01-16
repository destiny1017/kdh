<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>      
<%@page import="bean.*"%>
<%@page import="java.util.ArrayList"%>    
<%
    String id = (String)session.getAttribute("id");
    
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");
    String resNum = request.getParameter("resNum");
    String tel = request.getParameter("tel");
    String address = request.getParameter("address");
	
	String url = "jdbc:mysql://localhost:3306/shop";
	String user = "root";
	String password = "1234";

	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url, user, password);
	String sql = "update member set pw = ?, name = ?, resNum = ?, tel = ?, address = ? where id = ?";
	PreparedStatement ps = con.prepareStatement(sql); 
	ps.setString(1, pw);
	ps.setString(2, name);
	ps.setString(3, resNum);
	ps.setString(4, tel);
	ps.setString(5, address);
	ps.setString(6, id);
	
	ps.executeUpdate();
	
    out.println("<script language='javascript'>");
    out.println("alert('정보수정 성공')");
    out.println("location.href='member_mod.jsp'");
    out.println("</script>");
    
    
	con.close();
	ps.close();
%>