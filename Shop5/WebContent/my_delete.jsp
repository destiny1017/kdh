<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
		String id = (String) session.getAttribute("id");
		String url = "jdbc:mysql://localhost:3306/test2";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
		out.println("<script language='javascript'>");
	    out.println("alert('회원탈퇴 성공')");
	    out.println("location.href='about.jsp'");
	    out.println("</script>");
		con.close();
		ps.close();
		
	%>
	
</body>
</html>