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
	  
      //네이버or회원아이디
      String id = (String) session.getAttribute("id");
      String name = (String) session.getAttribute("name");
      String enc_id = (String) session.getAttribute("enc_id");
      if (id != "admin") {
    	  
      }
	
    %>
	
	
</body>
</html>