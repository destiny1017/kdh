<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String tel = request.getParameter("tel");
				
		try {
			
			MemberDTO dto = new MemberDTO();
			MemberDAO dao = new MemberDAO();
			dto = dao.selectPw(id, tel);
			if(dto != null) {
			
				out.println("<script>alert('PW:"+dto.getPw()+"'); history.back(); </script>");
				
			}else {
				out.println("<script>alert('해당정보가 없습니다'); history.back(); </script>");
			}
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	%>
</body>
</html>