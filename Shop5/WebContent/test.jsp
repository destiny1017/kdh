<%@page import="db.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDAO dao = new MemberDAO();	
	ArrayList<MemberDTO> member = dao.select();
%>

					<table class="table table-hover">
						<tr>
							<td></td>						
							<td>ID</td>						
							<td>pw</td>						
							<td>이름</td>						
							<td>연락처</td>						
							<td>주소</td>						
						</tr>
						<%--
						 --%>
						<%for(int i = 0; i < member.size(); i++){%>
						<tr>
							<td><%=i %></td>
							<td><%=member.get(i).getId() %></td>											
							<td><%=member.get(i).getPw() %></td>											
							<td><%=member.get(i).getName() %></td>											
							<td><%=member.get(i).getTel() %></td>											
							<td><%=member.get(i).getAddr() %></td>											
						</tr>
						<%} %>

					</table>

</body>
</html>