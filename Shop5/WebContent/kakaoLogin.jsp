<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
      //카카오 
      String snsName = request.getParameter("nickname");
      String snsId = request.getParameter("id");
      session.setAttribute("name", snsName);
      session.setAttribute("id", snsId);
      response.sendRedirect("about.jsp");
 %>

</body>
</html>