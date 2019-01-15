<%@page import="bean.AddCartDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.AddCartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	// 	String uId = request.getParameter("uId");
	String uId = "root";
	String pId = request.getParameter("pId");
	String size = request.getParameter("size");
	String count = request.getParameter("count");

	if (session.getAttribute("list") == null) {
		ArrayList<AddCartDTO> list = new ArrayList<>();
		AddCartDTO dto = new AddCartDTO();
		dto.setuId(uId);
		dto.setpId(pId);
		dto.setSize(size);
		dto.setCount(count);
		list.add(dto);
		session.setAttribute("list", list);
	}else{
		ArrayList<AddCartDTO> list = (ArrayList)session.getAttribute("list");
		AddCartDTO dto = new AddCartDTO();
		dto.setuId(uId);
		dto.setpId(pId);
		dto.setSize(size);
		dto.setCount(count);
		list.add(dto);		
		session.setAttribute("list", list);
	}
%>
<%=
1
%>

</head>
<body>


</body>
</html>