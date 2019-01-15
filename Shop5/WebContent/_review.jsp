<%@page import="javax.websocket.SendResult"%>
<%@page import="bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%	// 1.가입정보 받기
		String id = (String) session.getAttribute("id");
		String title = request.getParameter("review_title");
		String name = request.getParameter("review_name");
		String content = request.getParameter("review_content");
		String pId = request.getParameter("pId");

		ReviewDTO dto = new ReviewDTO();
		ReviewDAO dao = new ReviewDAO();
		
		
		dto.setId(id);
		dto.setTitle(title);
		dto.setName(name);
		dto.setContent(content);
		dto.setpId(pId);
		dao.reCheck(pId);
		dao.insert(dto);
		out.println("<script> alert(\"리뷰등록완료\"); location.href='member_pur.jsp'; </script>");
		
	%>	
	
</body>
</html>