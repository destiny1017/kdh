
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
	
		String url = "jdbc:mysql://localhost:3306/test2";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from purchaselist where pId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, pId);
		ps.executeUpdate();
		con.close();
		ps.close();
		out.println("<script language='javascript'>");
	    out.println("alert('목록삭제 완료')");
	    out.println("location.href='member_mod.jsp'");
	    out.println("</script>");
	%>
	

</body>
</html>