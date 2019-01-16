<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.BbsDAO"%>
<jsp:useBean id="bbs" class="bean.BbsDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="bbs" property="bbsCategories" />
<jsp:setProperty name="bbs" property="bbsTitle" />
<jsp:setProperty name="bbs" property="bbsContent" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("EUC-KR");
	
		if(request.getParameter("bbsTitle") == null || request.getParameter("bbsContent") == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('제목과 내용을 입력하세요')");
			script.println("history.back()");
			script.println("</script>");	
		}
		else {
			BbsDAO dao = new BbsDAO();
			int result = dao.update(Integer.parseInt(request.getParameter("bbsId")), request.getParameter("bbsTitle"), request.getParameter("bbsContent"), request.getParameter("bbsCategories"));
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
				script.println("location.href = '" + bbs.getBbsCategories() + ".jsp'");
				script.println("</script>");	
			}
		}
	%>
</body>
</html>