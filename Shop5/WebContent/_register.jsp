<%@page import="javax.websocket.SendResult"%>
<%@page import="bean.MemberDAO"%>
<%@page import="bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%	// 1.가입정보 받기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String resNum = request.getParameter("resNum");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		int amount = 0;
		
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		boolean confirm;
		confirm = dao.idCheck(id);
		if (id == null) {
			out.println("<script> alert(\"회원정보를 입력해주세요\"); history.back(); </script>");	
		
		}else if(pw == null) {
			out.println("<script> alert(\"회원정보를 입력해주세요\"); history.back(); </script>");	
			
		}else if(name == null) {
			out.println("<script> alert(\"회원정보를 입력해주세요\"); history.back(); </script>");	
			
		}else if(resNum == null) {
			out.println("<script> alert(\"회원정보를 입력해주세요\"); history.back(); </script>");
			
		}else if(tel == null) {
			out.println("<script> alert(\"회원정보를 입력해주세요\"); history.back(); </script>");
			
		}else if(address == null) {
			out.println("<script> alert(\"회원정보를 입력해주세요\"); history.back(); </script>");
			
		}else if(confirm == true){
			out.println("<script> alert(\"아이디중복입니다\"); history.back(); </script>");
		
		}else {
		
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setResNum(resNum);
		dto.setTel(tel);
		dto.setAddress(address);
		dto.setAmount(amount);
		dao.insert(dto);
		out.println("<script> alert(\"회원가입완료\"); location.href='login.jsp'; </script>");
		}
		
	%>	
	
	
</body>
</html>