<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="bean.BbsDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8"); 
	
	String admin = (String)session.getAttribute("admin");
	String userId = (String) session.getAttribute("id");
	if(admin!=null){
		userId=admin;
	}
	String bbsCategories = request.getParameter("bbsCategories");
	String bbsTitle = request.getParameter("bbsTitle");
	String bbsContent = request.getParameter("bbsContent");

	if(bbsCategories == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('카테고리를 분류하세요')");
		script.println("history.back()");
		script.println("</script>");
	} 
	else {
		if(bbsTitle == null || bbsContent == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('제목과 내용을 입력하세요')");
			script.println("history.back()");
			script.println("</script>");	
		}
		else {
			BbsDAO dao = new BbsDAO();
			int result = dao.write(bbsTitle, bbsContent, bbsCategories, userId);
			if(result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('글쓰기에 실패했습니다')");
				script.println("history.back()");
				script.println("</script>");	
			}
			else {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = '" + bbsCategories + ".jsp'");
				script.println("</script>");	
			}
		}
	}
%>
</body>
</html>